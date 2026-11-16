/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.math.AngleInfo

class ImageArrayRotationAnimationInfo(param_imageArray : Array[Image], param_angleIncrement : Int, param_totalAngle : Int, param_dx : Int, param_dy : Int) {

    private var imageArray : Array[Image] = null

    private var angleIncrement : Int = 0

    private var totalAngle : Int = 0

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val imageArray : Array[Image] = param_imageArray
        val angleIncrement : Int = param_angleIncrement
        val totalAngle : Int = param_totalAngle
        val dx : Int = param_dx
        val dy : Int = param_dy
        this.imageArray = imageArray
        this.angleIncrement = angleIncrement
        this.totalAngle = totalAngle
        this.dx = dx
        this.dy = dy
    }

    def setImageArray(imageArray : Array[Image]) : Unit = {
        this.imageArray = imageArray
    }

    def getImageArray() : Array[Image] = {
        return this.imageArray
    }

    def getAngleInfoP() : AngleInfo = {
        return AngleInfo.getInstance(this.angleIncrement.toShort)
    }

    def setTotalAngle(totalAngle : Int) : Unit = {
        this.totalAngle = totalAngle
    }

    def getTotalAngle() : Int = {
        return this.totalAngle
    }

    def setDx(dx : Int) : Unit = {
        this.dx = dx
    }

    def getDx() : Int = {
        return this.dx
    }

    def setDy(dy : Int) : Unit = {
        this.dy = dy
    }

    def getDy() : Int = {
        return this.dy
    }

}


