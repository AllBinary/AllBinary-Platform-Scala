/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion


/**  *   * @author user  */
class AllMotionRecognizer() {
    import _root_.org.allbinary.input.motion.AllMotionRecognizer.{*}

    private var id : Int = 0

    //Constructor
    {
        this.id = { val value_N66271 = AllMotionRecognizer.index; AllMotionRecognizer.index += 1; value_N66271 }
    }

    def processStartMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
    }

    def processEndMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
    }

    def processDraggedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
    }

    def processMovedMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
    }

    def processScrolledMotionEvent(x : Int, y : Int, deviceId : Int, modifiers : Int) : Unit = {
    }

    def getId() : Int = {
        return this.id
    }

}

object AllMotionRecognizer {
    private var index : Int = 0

}


