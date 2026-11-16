/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.org.allbinary.game.input.PlayerGameInput
import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.input.motion.gesture.observer.BaseMotionGestureEventListener
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicMenuInputProcessor(param_gameKeyEventList : BasicArrayList, param_playerInputId : Int, param_gameCanvas : Canvas) extends PlayerGameInput(param_gameKeyEventList, new BasicArrayListD(), param_playerInputId) with BaseMotionGestureEventListener {

    val motionGestureEventList : BasicArrayList = new BasicArrayListD()

    private var canvas : Canvas = NullCanvas.NULL_CANVAS

    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val playerInputId : Int = param_playerInputId
        val gameCanvas : Canvas = param_gameCanvas
        this.canvas = gameCanvas
    }

    override def onMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
        //.append(" point: ").append(motionGestureEvent.getCurrentPoint()).toString());
        this.motionGestureEventList.add(motionGestureEvent)
    }

    override def onScrolledMotionGestureEvent(motionGestureEvent : MotionGestureEvent) : Unit = {
    }

    private def setCanvas(canvas : MyCanvas) : Unit = {
        this.canvas = canvas
    }

    def getCanvas() : MyCanvas = {
        return this.canvas.asInstanceOf[MyCanvas]
    }

    def processInputList() : Int = {
        return -1
    }

}


