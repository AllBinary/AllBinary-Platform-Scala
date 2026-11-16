/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Command
import _root_.org.allbinary.game.commands.GameCommandsFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.InputFeatureFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.layer.SWTUtil
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.graphics.form.CommandCurrentSelectionForm
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.audio.PrimaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.thread.PrimaryThreadPool
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList

//In general allow scrolling of the menu and selection the center item
class CommandFormInputProcessor(param_gameKeyEventList : BasicArrayList, param_playerInputId : Int, param_gameCanvas : MyCanvas, param_form : ScrollSelectionForm) extends BasicMenuInputProcessor(param_gameKeyEventList, param_playerInputId, param_gameCanvas) {

    private val MOTION_GESTURE_SOURCE_ID : Int = GameKeyEventFactory.getInstance().MOTION_GESTURE_SOURCE_ID

    private val CLICK_DELAY : Int = 150

    private val clickTimeHelper : TimeDelayHelper = new TimeDelayHelper(this.CLICK_DELAY)

    private val DOUBLE_CLICK_DELAY : Int = 1200

    private val doubleClickTimeHelper : TimeDelayHelper = new TimeDelayHelper(this.DOUBLE_CLICK_DELAY)

    val isSingleKeyProcessing : Boolean = InputFeatureFactory.getInstance().isSingleKeyProcessing()

    private var form : ScrollSelectionForm = null

    private var hasPressed : Boolean = false

    private val PROCESS_COMMAND : String = "processCommand"

    private val NAME_LABEL : String = " ScrollSelectionForm: "

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val playerInputId : Int = param_playerInputId
        val gameCanvas : MyCanvas = param_gameCanvas
        val form : ScrollSelectionForm = param_form
        this.form = form
    }

    def processInput(key : Int) : Int = {
        //this.logUtil.putF(new StringMaker().append(commonStrings.START).append("Canvas.").append(CanvasUtil.getKeyName(key)).toString(), this, GameInputStrings.getInstance().PROCESS_INPUT);
        if ((((key == Canvas.LEFT) || (key == Canvas.RIGHT)) || (key == Canvas.UP)) || (key == Canvas.DOWN)) {
            //ForcedLogUtil.log();
            PrimaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
            this.form.processInputKey(key)
            return 1
        } else if (key == Canvas.FIRE) {
            //ForcedLogUtil.log();
            PrimaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
            // this.logUtil.putF("Key: ").append(key, this, GameInputStrings.getInstance());
            return this.processCommand()
        }
        return 0
    }

    private def processCommand() : Int = {
        val commandCurrentSelectionForm : CommandCurrentSelectionForm = this.form.asInstanceOf[CommandCurrentSelectionForm]
        val command : Command = commandCurrentSelectionForm.getSelectedCommand()
        //"Command: "
        this.logUtil.putF(command.toString(), this, this.PROCESS_COMMAND)
        val features : Features = Features.getInstance()
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        if ((SWTUtil.isSWT && features.isFeature(openGLFeatureFactory.OPENGL)) && (command ne GameCommandsFactory.getInstance().EXIT_COMMAND)) {
            new CommandRunnable(this, command).run()
        } else {
            PrimaryThreadPool.getInstance().runTask(new CommandRunnable(this, command))
        }
        if (command eq GameCommandsFactory.getInstance().QUIT_COMMAND) {
            return -1
        } else {
            return 1
        }
        throw new IllegalStateException()
    }

    override def processInputList() : Int = {
        try {
            //PreLogUtil.put(commonStrings.START, this, GameInputStrings.getInstance().PROCESS_INPUT);
            val motionInputsIndex : Int = this.processMotionInputs()
            val list : BasicArrayList = this.getGameKeyEventList()
            val size : Int = list.size()
            var key : Int = 0
            var gameKeyEvent : GameKeyEvent = null

            {
                var index : Int = 0
                scala.util.boundary { (break_N75550 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < size) {
                        gameKeyEvent = list.objectArray(index).asInstanceOf[GameKeyEvent]
                        key = gameKeyEvent.getKey()
                        // CanvasUtil.getKeyName(key), this, GameInputStrings.getInstance());
                        if (gameKeyEvent.getSourceId() != this.MOTION_GESTURE_SOURCE_ID) {
                            if (this.processInput(key) == 1) {
                                scala.util.boundary.break()(using break_N75550)
                            }
                        }
                        index += 1
                    }
                }
            }
            this.clear()
            /*           * if (isSingleKeyProcessing) { this.clear(); } else {           * this.update(); }           */
            if ((size > 0) || (motionInputsIndex >= 0)) {
                return 1
            } else {
                return -1
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.PROCESS_INPUT, e)
                return -1
            }
        }
        throw new IllegalStateException()
    }

    // AllBinaryLayerManager layerManager
    def processMotionInputs() : Int = {
        //PreLogUtil.put(commonStrings.START, this, "processMotionInputs");
        val lastIndex : Int = this.motionGestureEventList.size() - 1
        if (lastIndex >= 0) {
            val motionGestureEvent : MotionGestureEvent = this.motionGestureEventList.objectArray(lastIndex).asInstanceOf[MotionGestureEvent]
            this.processMotionInput(motionGestureEvent)
        }
        this.motionGestureEventList.clear()
        return lastIndex
    }

    def processMotionInput(motionGestureEvent : MotionGestureEvent) : Unit = {
        //PreLogUtil.put(commonStrings.START, this, gameInputStrings.PROCESS_MOTION_INPUT);
        val touchMotionGestureFactory : TouchMotionGestureFactory = TouchMotionGestureFactory.getInstance()
        val motionGestureInput : MotionGestureInput = motionGestureEvent.getMotionGesture()
        if (motionGestureInput eq touchMotionGestureFactory.RELEASED) {
            val point : GPoint = motionGestureEvent.getCurrentPoint()
            if (this.form.isInForm(point)) {
                val index : Int = this.form.getSelectedIndexForPoint(point)
                if (index != -1) {
                    //this.logUtil.putF("Form Selected Index: ").append(index, this, gameInputStrings.PROCESS_MOTION_INPUT);
                    PrimaryPlayerQueueFactory.getInstance().add(SelectSound.getInstance())
                    if (index == this.form.getSelectedIndex()) {
                        if (this.clickTimeHelper.isTimeTNT()) {
                            this.processCommand()
                        }
                    } else {
                        this.form.setSelectedIndex(index)
                    }
                } else {
                }
            }
            // this.logUtil.putF("No Double Press Time: ").append(this.doubleClickTimeHelper.getElapsed(), this, gameInputStrings.PROCESS_MOTION_INPUT);
            if (this.hasPressed) {
                if (!this.doubleClickTimeHelper.isTimeTNT()) {
                    this.logUtil.putF("Double Press", this, this.gameInputStrings.PROCESS_MOTION_INPUT)
                    this.processCommand()
                }
                this.doubleClickTimeHelper.delay = this.DOUBLE_CLICK_DELAY
                this.doubleClickTimeHelper.setStartTimeTNT()
            }
            this.hasPressed = false
        } else if (motionGestureInput eq touchMotionGestureFactory.PRESSED) {
            // Can't be a double click/press if dragging or other
            this.doubleClickTimeHelper.delay = 0
            this.hasPressed = true
        }
    }

    override def toString() : String = {
        return new StringMaker().append(super.toString()).append(this.NAME_LABEL).append(this.form.toString()).toString()
    }

}


