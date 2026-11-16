/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.gyro

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureInput
import _root_.org.allbinary.logic.NullUtil

class OrientationMotionGestureFactory private() {
    import _root_.org.allbinary.input.gyro.OrientationMotionGestureFactory.{*}

    var LEFT : MotionGestureInput = null

    var RIGHT : MotionGestureInput = null

    var UP : MotionGestureInput = null

    var DOWN : MotionGestureInput = null

    var ROLL_LEFT : MotionGestureInput = null

    var ROLL_RIGHT : MotionGestureInput = null

    //Constructor
    {
        var MAX : Int = InputFactory.getInstance().MAX
        this.LEFT = new MotionGestureInput(MAX - 20, "Left Orient")
        this.RIGHT = new MotionGestureInput(MAX - 21, "Right Orient")
        this.UP = new MotionGestureInput(MAX - 22, "Up Orient")
        this.DOWN = new MotionGestureInput(MAX - 23, "Down Orient")
        this.ROLL_LEFT = new MotionGestureInput(MAX - 24, "Roll Left")
        this.ROLL_RIGHT = new MotionGestureInput(MAX - 25, "Roll Right")
    }

}

object OrientationMotionGestureFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : OrientationMotionGestureFactory = {
        if (OrientationMotionGestureFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            OrientationMotionGestureFactory.instance = new OrientationMotionGestureFactory()
        }
        return OrientationMotionGestureFactory.instance.asInstanceOf[OrientationMotionGestureFactory]
    }

}


