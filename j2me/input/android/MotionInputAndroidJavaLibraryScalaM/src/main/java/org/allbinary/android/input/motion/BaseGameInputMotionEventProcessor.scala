/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.android.view.MotionEvent
import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler
import _root_.org.allbinary.input.motion.gesture.observer.GameMotionGestureListener
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory
import _root_.org.allbinary.string.CommonStrings

class BaseGameInputMotionEventProcessor() extends MotionEventProcessor {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private AndroidMotionEventsToMotionGestureListener motionEventsToMotionGestureListener;
    private var gameMotionGestureListener : GameMotionGestureListener = null

    //Constructor
    {
        /*         motionEventsToMotionGestureListener = new AndroidMotionEventsToMotionGestureListener();                  MotionGestureRecognizer motionGestureRecognizer =              this.motionEventsToMotionGestureListener.getMotionRecognizer().getMotionGestureRecognizer();         BasicMotionGesturesHandler motionGesturesHandler =              motionGestureRecognizer.getMotionGesturesHandler();         */
        this.gameMotionGestureListener = new GameMotionGestureListener(MotionGestureReceiveInterfaceFactory.getInstance())
        this.addListener()
    }

    override def process(motionEvent : MotionEvent) : Unit = {
    }

    def addListener() : Unit = {
        var motionGesturesHandler : BasicMotionGesturesHandler = BasicMotionGesturesHandler.getInstance()
        motionGesturesHandler.addListenerInterface(this.gameMotionGestureListener)
    }

}


