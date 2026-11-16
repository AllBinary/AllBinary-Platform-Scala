/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class MotionRectanglesResultsFrameCacheable(param_motionRectangles : MotionRectangles, param_frame : _root_.java.lang.Long) extends CacheableInterface {

    private var motionRectangles : MotionRectangles = null

    private var frame : _root_.java.lang.Long = null

    //Constructor
    {
        val motionRectangles : MotionRectangles = param_motionRectangles
        val frame : _root_.java.lang.Long = param_frame
        this.frame = frame
        this.setMotionRectangles(motionRectangles)
    }

    def getKey() : Object = {
        return this.frame
    }

    def getMotionRectangles() : MotionRectangles = {
        return this.motionRectangles
    }

    def setMotionRectangles(motionRectangles : MotionRectangles) : Unit = {
        this.motionRectangles = motionRectangles
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(" Frame: ")
        stringBuffer.append(this.getKey().toString())
        return stringBuffer.toString()
    }

}


