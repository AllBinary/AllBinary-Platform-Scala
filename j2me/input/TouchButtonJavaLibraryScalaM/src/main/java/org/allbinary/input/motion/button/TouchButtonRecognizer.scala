/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.event.DownGameKeyEventHandler
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.UpGameKeyEventHandler
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.math.RectangleCollisionUtil
import _root_.org.allbinary.util.BasicArrayList

class TouchButtonRecognizer() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()

    val upGameKeyEventHandler : UpGameKeyEventHandler = UpGameKeyEventHandler.getInstance()

    private val downGameKeyEventHandler : DownGameKeyEventHandler = DownGameKeyEventHandler.getInstance()

    private var lastPressedTouchButtonInput : TouchButtonInput = BasicTouchInputFactory.getInstance().NONE

    val currentlyPressedTouchButtonSingleton : CurrentlyPressedTouchButtonSingleton = CurrentlyPressedTouchButtonSingleton.getInstance()

    //CurrentlyPressedTouchButtonSingletonDebug.getInstance();
    private var releaseHelper : ReleaseHelper = null

    //Constructor
    {
        if (TouchScreenFactory.getInstance().isMultiTouch()) {
            //PreLogUtil.put("Multitouch Release Helper", this, this.commonStrings.CONSTRUCTOR);
            this.releaseHelper = new MultitouchReleaseHelper(this)
        } else {
            //PreLogUtil.put("Singletouch Release Helper", this, this.commonStrings.CONSTRUCTOR);
            this.releaseHelper = new ReleaseHelper(this)
        }
    }

    /*     public void releaseAll() throws Exception     {         for (int index = this.currentlyPressedTouchButtonInputList.size() - 1; index >= 0; index--)         {             TouchButtonInput nextTouchButtonInput = (TouchButtonInput)                this.currentlyPressedTouchButtonInputList.get(index);              // this.logUtil.putF(             // "Release Associated Button Press", this, // "processTouchButtonInput");             UpGameKeyEventHandler.getInstance().fireEvent(                     nextTouchButtonInput.getGameKeyEvent());         }         this.currentlyPressedTouchButtonInputList.clear();     }     */
    private def processRelease(touchButtonInput : TouchButtonInput, deviceId : Int) : Unit = {
        // Release associated button if not released
        this.releaseHelper.release(touchButtonInput, deviceId)
        //this.logUtil.putF("Event Inside Button Area - Action: " + touchButtonInput.getGameKeyEvent(), this, "processTouchButtonInput");
        val gameKeyEvent : GameKeyEvent = touchButtonInput.getGameKeyEvent()
        this.upGameKeyEventHandler.fireEvent(gameKeyEvent)
        this.upGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
        this.currentlyPressedTouchButtonSingleton.remove(touchButtonInput)
    }

    def releaseTouchButtonInput(x : Int, y : Int, deviceId : Int) : Boolean = this.synchronized {
        //TouchButtonInput touchButtonInput = BasicTouchInputFactory.getInstance().NONE;
        var touchButtonInput : TouchButtonInput = this.lastPressedTouchButtonInput
        // if already pressed then cancel associated button and release
        if (this.currentlyPressedTouchButtonSingleton.contains(touchButtonInput)) {
            this.lastPressedTouchButtonInput = BasicTouchInputFactory.getInstance().NONE
            this.processRelease(touchButtonInput, deviceId)
            //this.currentlyPressedTouchButtonSingleton.releaseAndFired(touchButtonInput);
            return true
        } else {
            val list : BasicArrayList = TouchButtonFactory.getInstance().getList()
            var rectangle : Rectangle = null
            var point : GPoint = null
            var touchButton : TouchButton = null

            {
                var index : Int = list.size() - 1
                while (index >= 0) {
                    touchButton = list.objectArray(index).asInstanceOf[TouchButton]
                    rectangle = touchButton.getRectangle()
                    point = rectangle.getPoint()
                    if (this.rectangleCollisionUtil.isInside(point.getX(), point.getY(), rectangle.getMaxX(), rectangle.getMaxY(), x, y)) {
                        touchButtonInput = touchButton.getTouchButtonInput()
                        this.processRelease(touchButtonInput, deviceId)
                        //this.currentlyPressedTouchButtonSingleton.releaseAndFired2(touchButtonInput);
                        return true
                    }
                    index -= 1
                }
            }
        }
        return false
    }

    def pressTouchButtonInput(x : Int, y : Int, deviceId : Int) : Boolean = this.synchronized {
        //PreLogUtil.put(string, this, "processTouchButtonInput");
        val list : BasicArrayList = TouchButtonFactory.getInstance().getList()
        var rectangle : Rectangle = null
        var point : GPoint = null
        var touchButton : TouchButton = null
        var touchButtonInput : TouchButtonInput = null
        var gameKeyEvent : GameKeyEvent = null

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                touchButton = list.objectArray(index).asInstanceOf[TouchButton]
                rectangle = touchButton.getRectangle()
                point = rectangle.getPoint()
                if (this.rectangleCollisionUtil.isInside(point.getX(), point.getY(), rectangle.getMaxX(), rectangle.getMaxY(), x, y)) {
                    touchButtonInput = touchButton.getTouchButtonInput()
                    //if not already pressed then cancel associated button and press
                    if (!this.currentlyPressedTouchButtonSingleton.contains(touchButtonInput)) {
                        //Release associated button if not released
                        this.releaseHelper.release(touchButtonInput, deviceId)
                        this.lastPressedTouchButtonInput = touchButtonInput
                        this.currentlyPressedTouchButtonSingleton.add(touchButtonInput)
                        //PreLogUtil.put("Event Inside Button Area - Action: " + touchButtonInput.getGameKey(), this, "processTouchButtonInput");
                        gameKeyEvent = touchButtonInput.getGameKeyEvent()
                        this.downGameKeyEventHandler.fireEvent(gameKeyEvent)
                        this.downGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
                    }
                    /*                 else                 {                     currentlyPressedTouchButtonSingleton.pressedAndNotFired(touchButtonInput);                 }                 */
                    return true
                }
                index -= 1
            }
        }
        return false
    }

}


