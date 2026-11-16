/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class MotionRectanglesResultsEvent(param_anyType : Object, param_frame : _root_.java.lang.Long, param_motionRectangles : MotionRectangles) extends AllBinaryEventObject(param_anyType) {

    private var frame : _root_.java.lang.Long = null

    private var motionRectangles : MotionRectangles = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val frame : _root_.java.lang.Long = param_frame
        val motionRectangles : MotionRectangles = param_motionRectangles
        this.frame = frame
        this.setMotionRectangles(motionRectangles)
    }

    def getMotionRectangles() : MotionRectangles = {
        return this.motionRectangles
    }

    def setMotionRectangles(motionRectangles : MotionRectangles) : Unit = {
        this.motionRectangles = motionRectangles
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

}


