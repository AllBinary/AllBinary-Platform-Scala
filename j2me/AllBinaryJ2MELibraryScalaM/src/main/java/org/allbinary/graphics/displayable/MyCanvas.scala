/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.NullCommandListener
import _root_.org.allbinary.graphics.displayable.command.MyCommandInterface
import _root_.org.allbinary.graphics.displayable.command.MyCommandsFactory
import _root_.org.allbinary.input.TouchJ2ME
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABStack

class MyCanvas(param_name : String, param_childNameList : BasicArrayList) extends Canvas with DisplayableInterface with MyCommandInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    val stringUtil : StringUtil = StringUtil.getInstance()

    val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var name : String = null

    private var childNameList : BasicArrayList = null

    private var commandStack : ABStack[Object] = null

    private var commandListener : CommandListener = NullCommandListener.NULL_COMMAND_LISTENER

    //private boolean displayed;
    private var paused : Boolean = false

    private val touchME : TouchJ2ME = new TouchJ2ME()

    //    }
    //Constructor
    {
        val name : String = param_name
        val childNameList : BasicArrayList = param_childNameList
        this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        //It could also be set with basically an event.
        this.displayInfo.update(this, this.canvasStrings.CONSTRUCTOR)
        this.name = name
        this.childNameList = childNameList
        this.commandStack = StdUtil.getInstance().createStack()
    }

    //Needed for polyglot do not remove
    override def getWidth() : Int = {
        return super.getWidth()
    }

    //Needed for polyglot do not remove
    override def getHeight() : Int = {
        return super.getHeight()
    }

    override def setFullScreenMode(mode : Boolean) : Unit = {
        //PreLogUtil.put("Old W: " + this.getWidth() + " H: " + this.getHeight() +  " m: " + mode + " fs: " + this.isFullScreenMode(), this, "setFullScreenMode");
        super.setFullScreenMode(mode)
        //PreLogUtil.put("New W: " + this.getWidth() + " H: " + this.getHeight() +  " m: " + mode + " fs: " + this.isFullScreenMode(), this, "setFullScreenMode");
        this.displayInfo.update(this, this.canvasStrings.SET_FULL_SCREEN_MODE)
    }

    override def sizeChanged(w : Int, h : Int) : Unit = {
        this.displayInfo.update(this, this.canvasStrings.SIZE_CHANGED)
    }

    def getCommandStack() : ABStack[Object] = {
        return this.commandStack
    }

    def isCommand(command : Command) : Boolean = this.synchronized {
        return this.commandStack.contains(command)
    }

    override def addCommand(command : Command) : Unit = this.synchronized {
        if (!this.commandStack.contains(command)) {
            this.commandStack.push(command)
            super.addCommand(command)
        }
    }

    override def removeCommand(command : Command) : Unit = this.synchronized {
        //commandStack.remove(command);
        this.commandStack.removeElement(command)
        super.removeCommand(command)
    }

    override def removeAllCommands() : Unit = this.synchronized {
        var size : Int = this.commandStack.size()

        {
            var index : Int = 0
            while (index < size) {
                super.removeCommand(this.commandStack.pop().asInstanceOf[Command])
                index += 1
            }
        }
    }

    override def setCommandListener(l : CommandListener) : Unit = {
        super.setCommandListener(l)
        this.commandListener = l
    }

    def getCustomCommandListener() : CommandListener = {
        return this.commandListener
    }

    def isPaused() : Boolean = this.synchronized {
        return this.paused
    }

    def removePauseCommand() : Unit = {
        this.removeCommand(MyCommandsFactory.getInstance().PAUSE_COMMAND)
    }

    def pause() : Unit = this.synchronized {
        this.logUtil.putF(this.commonStrings.START, this, this.canvasStrings.PAUSE)
        this.removePauseCommand()
        this.addCommand(MyCommandsFactory.getInstance().RESUME_COMMAND)
        this.setPaused(true)
    }

    def unPause() : Unit = this.synchronized {
        this.logUtil.putF(this.commonStrings.START, this, this.canvasStrings.UN_PAUSE)
        this.removeCommand(MyCommandsFactory.getInstance().RESUME_COMMAND)
        this.addCommand(MyCommandsFactory.getInstance().PAUSE_COMMAND)
        this.setPaused(false)
    }

    def process() : Unit = {
        this.displayInfo.process()
    }

    //GameStatisticsFactory.getInstance();
    override def paint(graphics : Graphics) : Unit = {
    }

    def draw(graphics : Graphics) : Unit = {
    }

    def hasChild(displayable : MyCanvas) : Boolean = {
        return this.childNameList.contains(displayable.name)
    }

    def destroy() : Unit = {
        this.logUtil.putF("Destroyed MyCanvas", this, "destroy")
    }

    /*     public void setDisplayed(boolean displayed)     {         this.displayed = displayed;     }      protected boolean isDisplayed()     {         return displayed;     }     */
    def setPaused(isPaused : Boolean) : Unit = {
        this.paused = isPaused
    }

    def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
    }

    def keyRepeatedByDevice(keyCode : Int, deviceId : Int) : Unit = {
    }

    def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit = {
    }

    override def pointerDragged(x : Int, y : Int) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "pointerDragged");
        this.touchME.pointerDragged(x, y)
    }

    override def pointerPressed(x : Int, y : Int) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "pointerPressed");
        this.touchME.pointerPressed(x, y)
    }

    override def pointerReleased(x : Int, y : Int) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, "pointerReleased");
        this.touchME.pointerReleased(x, y)
    }

    def nextSong(nextSongSound : Sound, leftVolume : Int, rightVolume : Int) : Unit = {
    }

}


