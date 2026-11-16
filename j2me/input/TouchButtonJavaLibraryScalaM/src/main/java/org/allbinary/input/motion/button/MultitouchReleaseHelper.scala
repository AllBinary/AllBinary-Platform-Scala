/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.event.GameKeyEvent

class MultitouchReleaseHelper(param_touchButtonRecognizer : TouchButtonRecognizer) extends ReleaseHelper(param_touchButtonRecognizer) {

    //Constructor
    {
        val touchButtonRecognizer : TouchButtonRecognizer = param_touchButtonRecognizer
    }

    // This releases an associated button even if it has not been released
    override def release(touchButtonInput : TouchButtonInput, deviceId : Int) : Unit = {
        val cancelTouchButtonInput : TouchButtonInput = CancelTouchButtonInputFactory.getInstance().getCancel(touchButtonInput)
        var nextTouchButtonInput : TouchButtonInput = null
        var gameKeyEvent : GameKeyEvent = null

        {
            var index : Int = this.touchButtonRecognizer.currentlyPressedTouchButtonSingleton.size() - 1
            while (index >= 0) {
                nextTouchButtonInput = this.touchButtonRecognizer.currentlyPressedTouchButtonSingleton.get(index)
                // touchButtonInput ||
                if (cancelTouchButtonInput eq nextTouchButtonInput) {
                    // "Release Associated Button Press", this, // "processTouchButtonInput");
                    gameKeyEvent = nextTouchButtonInput.getGameKeyEvent()
                    this.touchButtonRecognizer.upGameKeyEventHandler.fireEvent(gameKeyEvent)
                    this.touchButtonRecognizer.upGameKeyEventHandler.getInstanceForDevice(deviceId).fireEvent(gameKeyEvent)
                    this.touchButtonRecognizer.currentlyPressedTouchButtonSingleton.removeAt(index)
                }
                index -= 1
            }
        }
    }

}


