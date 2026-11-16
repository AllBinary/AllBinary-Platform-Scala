/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.InputProcessor
import _root_.org.allbinary.game.input.PlatformKeyFactory
import _root_.org.allbinary.game.input.event.DownKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class FormInputProcessor(param_allBinaryGameCanvas : AllBinaryGameCanvas) extends InputProcessor {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    //private final DownGameKeyEventHandler downGameKeyEventHandler = DownGameKeyEventHandler.getInstance();
    private val downKeyEventHandler : DownKeyEventHandler = DownKeyEventHandler.getInstance()

    private val upGameKeyEventHandler : UpGameKeyEventHandler = UpGameKeyEventHandler.getInstance()

    private val inputFactory : InputFactory = InputFactory.getInstance()

    private val platformKeyFactory : PlatformKeyFactory = PlatformKeyFactory.getInstance()

    private var allBinaryGameCanvas : AllBinaryGameCanvas = null

    //Constructor
    {
        val allBinaryGameCanvas : AllBinaryGameCanvas = param_allBinaryGameCanvas
        this.allBinaryGameCanvas = allBinaryGameCanvas
    }

    override def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit = {
        try {
            PreLogUtil.put(new StringMaker().append(this.inputFactory.KEY_CODE_LABEL).appendint(keyCode).append(CommonSeps.getInstance().SPACE).append(this.inputFactory.DEVICE_ID_LABEL).appendint(deviceId).toString(), this, this.gameInputStrings.KEY_PRESSED)
            val input : Input = this.inputFactory.getInstanceById(keyCode)
            val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this.allBinaryGameCanvas, input)
            this.downKeyEventHandler.fireEventForGameKeyEvent(gameKeyEvent)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

    //Handle the enter case as a GameKey
    override def keyReleasedByDevice(canvas : Canvas, keyCode : Int, deviceId : Int) : Unit = {
        try {
            //                     this, gameInputStrings.KEY_RELEASED);
            val input : Input = this.inputFactory.getInstanceById(keyCode)
            if (this.platformKeyFactory.isEnter(input)) {
                PreLogUtil.put(new StringMaker().append(this.inputFactory.KEY_CODE_LABEL).appendint(keyCode).append(CommonSeps.getInstance().SPACE).append(this.inputFactory.DEVICE_ID_LABEL).appendint(deviceId).toString(), this, this.gameInputStrings.KEY_RELEASED)
                val gameKey : GameKey = GameKeyFactory.getInstance().KEY_NUM0
                val gameKeyEventSourceInterface : GameKeyEventSourceInterface = canvas.asInstanceOf[GameKeyEventSourceInterface]
                val gameKeyEvent : GameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(gameKeyEventSourceInterface, gameKey)
                this.upGameKeyEventHandler.fireEvent(gameKeyEvent)
                this.upGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.ADD_KEY_EVENT, e)
            }
        }
    }

}


