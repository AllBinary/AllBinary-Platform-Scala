/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.InputProcessor
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.event.DownGameKeyEventHandler
import _root_.org.allbinary.game.input.event.DownKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker

class GameCanvasInputProcessor(param_allBinaryGameCanvas : AllBinaryGameCanvas) extends InputProcessor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var allBinaryGameCanvas : AllBinaryGameCanvas = null

    private val downGameKeyEventHandler : DownGameKeyEventHandler = DownGameKeyEventHandler.getInstance()

    private val upGameKeyEventHandler : UpGameKeyEventHandler = UpGameKeyEventHandler.getInstance()

    private val downKeyEventHandler : DownKeyEventHandler = DownKeyEventHandler.getInstance()

    private val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()

    private val inputToGameKeyMapping : InputToGameKeyMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().getInputMapping()

    private val NONE : GameKey = GameKeyFactory.getInstance().NONE

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    //Constructor
    {
        val allBinaryGameCanvas : AllBinaryGameCanvas = param_allBinaryGameCanvas
        this.allBinaryGameCanvas = allBinaryGameCanvas
        this.inputToGameKeyMapping.init(this.allBinaryGameCanvas)
    }

    //TWB - This is raw input from Canvas that does not include TouchButton Input
    override def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        try {
            //PreLogUtil.put(new StringMaker().append(new StringMaker().append("Key Code: ").append(Integer.toHexString(keyCode)).toString(), this, this.gameInputStrings.ADD_KEY_EVENT);
            val gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(this.allBinaryGameCanvas, keyCode)
            if (gameKey ne this.NONE) {
                val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this.allBinaryGameCanvas, gameKey)
                /*                  * //This is for key input debugging only GameKeyEvent                  * gameKeyEvent = GameKeyEventFactory.getInstance(this,                  * keyCode, gameActionKeyCode, gameKey.getKey(), repeated);                  * LogUtil                  * .put(LogFactory.getInstance(gameKeyEvent.toString(), this, this.gameInputStrings.ADD_KEY_EVENT));                  */
                this.downGameKeyEventHandler.fireEvent(gameKeyEvent)
                this.downGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.ADD_KEY_EVENT)
            }
            val keyCodeAsInteger : Integer = this.smallIntegerSingletonFactory.getAtNoThrow(keyCode)
            this.downKeyEventHandler.fireEventI(keyCodeAsInteger)
            this.downKeyEventHandler.getInstanceForDevice(deviceId).fireEventI(keyCodeAsInteger)
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

    override def keyReleasedByDevice(canvas : Canvas, keyCode : Int, deviceId : Int) : Unit = {
        this.removeGameKeyEvent(canvas, keyCode, deviceId, false)
    }

    private def removeGameKeyEvent(canvas : Canvas, keyCode : Int, deviceId : Int, repeated : Boolean) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append("Key Code: " + Integer.toHexString(keyCode), this, REMOVE_KEY_EVENT);
            val gameKey : GameKey = this.inputToGameKeyMapping.getInstanceForCanvas(canvas, keyCode)
            if (gameKey ne this.NONE) {
                val gameKeyEventSourceInterface : GameKeyEventSourceInterface = canvas.asInstanceOf[GameKeyEventSourceInterface]
                val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(gameKeyEventSourceInterface, gameKey)
                // TODO TWB - Remove or improve key input event handling
                this.upGameKeyEventHandler.fireEvent(gameKeyEvent)
                this.upGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
            } else {
                this.logUtil.putF(new StringMaker().append(this.gameInputStrings.NO_KEY).appendint(keyCode).toString(), this, this.gameInputStrings.REMOVE_KEY_EVENT)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put("Key Event Error", this, this.gameInputStrings.REMOVE_KEY_EVENT, e)
            }
        }
    }

}


