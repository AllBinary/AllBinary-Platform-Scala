/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.Rectangle
import _root_.java.util.Vector
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class MotionRectangle(param_rectangle : Rectangle) extends Cloneable {

    private var rectangle : Rectangle = null

    private var pixelDeltaVector : BasicArrayList = null

    //Constructor
    {
        val rectangle : Rectangle = param_rectangle
        this.setRectangle(rectangle)
        this.setPixelDeltaVector(new BasicArrayListD())
    }

    def getRectangle() : Rectangle = {
        return this.rectangle
    }

    def setRectangle(rectangle : Rectangle) : Unit = {
        this.rectangle = rectangle
    }

    def getPixelDeltaVector() : BasicArrayList = {
        return this.pixelDeltaVector
    }

    def setPixelDeltaVector(pixelDeltaVector : BasicArrayList) : Unit = {
        this.pixelDeltaVector = pixelDeltaVector
    }

    override def clone() : Object = {
        var motionRectangle : MotionRectangle = new MotionRectangle(this.getRectangle().clone().asInstanceOf[Rectangle])
        motionRectangle.setPixelDeltaVector(this.getPixelDeltaVector().clone().asInstanceOf[BasicArrayList])
        return motionRectangle
    }

}


