/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.logic.NullUtil

class TrackballMotionGestureFactory private() {
    import _root_.org.allbinary.input.motion.gesture.TrackballMotionGestureFactory.{*}

    var LEFT : MotionGestureInput = null

    var RIGHT : MotionGestureInput = null

    var UP : MotionGestureInput = null

    var DOWN : MotionGestureInput = null

    //Constructor
    {
        var MAX : Int = InputFactory.getInstance().MAX
        this.LEFT = new MotionGestureInput(MAX - 26, "L Trackball")
        this.RIGHT = new MotionGestureInput(MAX - 27, "R Trackball")
        this.UP = new MotionGestureInput(MAX - 28, "Up Trackball")
        this.DOWN = new MotionGestureInput(MAX - 29, "D Trackball")
    }

}

object TrackballMotionGestureFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : TrackballMotionGestureFactory = {
        if (TrackballMotionGestureFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            TrackballMotionGestureFactory.instance = new TrackballMotionGestureFactory()
        }
        return TrackballMotionGestureFactory.instance.asInstanceOf[TrackballMotionGestureFactory]
    }

}


