/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.logic.NullUtil

class TouchMotionGestureFactory() {
    import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory.{*}

    var LEFT : MotionGestureInput = null

    var RIGHT : MotionGestureInput = null

    var UP : MotionGestureInput = null

    var DOWN : MotionGestureInput = null

    var PRESSED : MotionGestureInput = null

    var RELEASED : MotionGestureInput = null

    var DIAGONAL_DOWN_RIGHT : MotionGestureInput = null

    var DIAGONAL_DOWN_LEFT : MotionGestureInput = null

    var DIAGONAL_UP_RIGHT : MotionGestureInput = null

    var DIAGONAL_UP_LEFT : MotionGestureInput = null

    var SCROLL_UP : MotionGestureInput = null

    var SCROLL_DOWN : MotionGestureInput = null

    //public final MotionGestureInput TOUCH;
    var NO_MOTION : MotionGestureInput = null

    var LAST_MOTION : MotionGestureInput = null

    //Constructor
    {
        var MAX : Int = InputFactory.getInstance().MAX
        this.LEFT = new MotionGestureInput(MAX - 3, "Left Touch")
        this.RIGHT = new MotionGestureInput(MAX - 4, "Right Touch")
        this.UP = new MotionGestureInput(MAX - 5, "Up Touch")
        this.DOWN = new MotionGestureInput(MAX - 6, "Down Touch")
        this.PRESSED = new MotionGestureInput(MAX - 7, "Screen Press")
        this.RELEASED = new MotionGestureInput(MAX - 8, "Released")
        this.DIAGONAL_DOWN_RIGHT = new MotionGestureInput(MAX - 9, "Diagonal Dn R")
        this.DIAGONAL_DOWN_LEFT = new MotionGestureInput(MAX - 10, "Diagonal Dn L")
        this.DIAGONAL_UP_RIGHT = new MotionGestureInput(MAX - 11, "Diagonal Up R")
        this.DIAGONAL_UP_LEFT = new MotionGestureInput(MAX - 12, "Diagonal Up L")
        this.SCROLL_UP = new MotionGestureInput(MAX - 13, "Scroll Up")
        this.SCROLL_DOWN = new MotionGestureInput(MAX - 14, "Scroll Down")
        // 12, "Touch");
        this.NO_MOTION = new MotionGestureInput(MAX - 2, "No Motion")
        this.LAST_MOTION = new MotionGestureInput(MAX - 19, "Last Motion")
    }

}

object TouchMotionGestureFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : TouchMotionGestureFactory = {
        if (TouchMotionGestureFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            TouchMotionGestureFactory.instance = new TouchMotionGestureFactory()
        }
        return TouchMotionGestureFactory.instance.asInstanceOf[TouchMotionGestureFactory]
    }

}


