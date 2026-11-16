/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory

final class MotionGestureInput(param_id : Int, param_name : String) extends Input(param_id, param_name) {

    //private static MotionGestureInput[] motionGestureInputArray = new MotionGestureInput[Input.MAX];
    //Constructor
    {
        val id : Int = param_id
        val name : String = param_name
        val inputFactory : InputFactory = InputFactory.getInstance()
        inputFactory.add(this.getId(), this)
    }

}


