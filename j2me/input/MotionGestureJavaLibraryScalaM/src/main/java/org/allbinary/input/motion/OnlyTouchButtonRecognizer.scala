/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion

import _root_.org.allbinary.input.motion.button.TouchButtonRecognizer

/**  *   * @author user  */
class OnlyTouchButtonRecognizer() extends MotionRecognizer {

    private var touchButtonRecognizer : TouchButtonRecognizer = null

    private var touchButtonProcessing : Boolean = false

    //Constructor
    {
        this.touchButtonRecognizer = new TouchButtonRecognizer()
    }

    override def processStartMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        //Only one touch button can be pressed by a pointer !touchButtonProcessing &&
        if (this.touchButtonRecognizer.pressTouchButtonInput(x, y, deviceId)) {
            this.touchButtonProcessing = true
        }
    }

    override def processEndMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        if (this.touchButtonProcessing) {
            this.touchButtonProcessing = false
        }
        if (this.touchButtonRecognizer.releaseTouchButtonInput(x, y, deviceId)) {
            //this.touchButtonRecognizer.releaseAll();
            return
        }
    }

    override def processDraggedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
        //Allows sliding from one button to the next without releasing but only if a button press was already processing
        if (this.touchButtonProcessing) {
            this.touchButtonRecognizer.pressTouchButtonInput(x, y, deviceId)
        }
    }

}


