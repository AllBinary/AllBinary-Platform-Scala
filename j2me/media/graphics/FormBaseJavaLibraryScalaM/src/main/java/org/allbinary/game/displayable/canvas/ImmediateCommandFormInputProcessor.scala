/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList

class ImmediateCommandFormInputProcessor(param_gameKeyEventList : BasicArrayList, param_playerInputId : Int, param_gameCommandCanvas : GameCommandCanvas, param_form : ScrollSelectionForm) extends CommandFormInputProcessor(param_gameKeyEventList, param_playerInputId, param_gameCommandCanvas, param_form) {

    private val timeHelper : TimeDelayHelper = new TimeDelayHelper(25)

    var gameCommandCanvas : GameCommandCanvas = null

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val playerInputId : Int = param_playerInputId
        val gameCommandCanvas : GameCommandCanvas = param_gameCommandCanvas
        val form : ScrollSelectionForm = param_form
        this.gameCommandCanvas = gameCommandCanvas
    }

    override def onPressGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        try {
            //PreLogUtil.put(commonStrings.START, this, gameInputStrings.ON_PRESS_GAME_KEY);
            super.onPressGameKeyEvent(gameKeyEvent)
            if (this.timeHelper.isTimeTNT()) {
                this.processInputList()
                this.gameCommandCanvas.repaintBehavior.onChangeRepaint(this.getCanvas())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.ON_PRESS_GAME_KEY, e)
            }
        }
    }

    override def onDownGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        try {
            //PreLogUtil.put(commonStrings.START, this, gameInputStrings.ON_DOWN_GAME_KEY);
            super.onDownGameKeyEvent(gameKeyEvent)
            if (this.timeHelper.isTimeTNT()) {
                this.processInputList()
                this.gameCommandCanvas.repaintBehavior.onChangeRepaint(this.getCanvas())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.ON_DOWN_GAME_KEY, e)
            }
        }
    }

    override def onUpGameKeyEvent(gameKeyEvent : GameKeyEvent) : Unit = this.synchronized {
        try {
            //PreLogUtil.put(commonStrings.START, this, gameInputStrings.ON_UP_GAME_KEY);
            super.onUpGameKeyEvent(gameKeyEvent)
            if (this.timeHelper.isTimeTNT()) {
                this.processInputList()
                this.gameCommandCanvas.repaintBehavior.onChangeRepaint(this.getCanvas())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.gameInputStrings.ON_UP_GAME_KEY, e)
            }
        }
    }

    override def onMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
        try {
            //PreLogUtil.put(commonStrings.START, this, "onMotionGestureEvent");
            super.onMotionGestureEvent(motionGestureEvent)
            if (this.timeHelper.isTimeTNT()) {
                this.processInputList()
                this.gameCommandCanvas.repaintBehavior.onChangeRepaint(this.getCanvas())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onMotionGestureEvent", e)
            }
        }
    }

}


