/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer


trait MotionGestureEventListener extends BaseMotionGestureEventListener {

    def onPressedMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onUpMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onDownMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onRightMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onDiagonalDownRightMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onDiagonalDownLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onDiagonalUpRightMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def onDiagonalUpLeftMotionGestureEvent(ev : MotionGestureEvent) : Unit

    def released(ev : MotionGestureEvent) : Unit

}


