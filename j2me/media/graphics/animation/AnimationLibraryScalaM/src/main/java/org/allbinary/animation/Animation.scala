/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.image.opengles.OpenGLSurfaceChangedInterface

class Animation() extends AnimationInterface with OpenGLSurfaceChangedInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    var colorP : Int = 0

    var changeBasicColorP : BasicColor = BasicColorFactory.getInstance().NULL_COLOR

    var changeColorP : Int = 0

    var alphaP : Int = 0

    def setAlpha(alpha : Int) : Unit = {
        this.alphaP = alpha
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
    }

    override def paintThreedXYZ(graphics : Graphics, x : Int, y : Int, z : Int) : Unit = {
    }

    def isThreed() : Boolean = {
        return false
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def setBasicColorP(basicColor : BasicColor) : Unit = {
        //this.logUtil.putF("setBasicColor", this, basicColor.toString());
        this.basicColor = basicColor
        this.colorP = this.basicColor.intValue()
    }

    def setBackgroundBasicColorP(basicColor : BasicColor) : Unit = {
    }

    def getChangeBasicColor() : BasicColor = {
        return this.changeBasicColorP
    }

    def changeBasicColor(basicColor : BasicColor) : Unit = {
        //this.logUtil.putF("setBasicColor", this, basicColor.toString());
        this.changeBasicColorP = basicColor
        this.changeColorP = this.changeBasicColorP.intValue()
    }

    def getChangeColor() : Int = {
        return this.changeColorP
    }

    def getColor() : Int = {
        return this.colorP
    }

    def setScale(scaleX : Float, scaleY : Float) : Unit = {
    }

    def setMaxScale(maxScaleX : Float, maxScaleY : Float) : Unit = {
    }

    override def set(gl : GL) : Unit = {
    }

    def setDx(dx : Int) : Unit = {
    }

    def getDx() : Int = {
        return 0
    }

    def setDy(dy : Int) : Unit = {
    }

    def getDy() : Int = {
        return 0
    }

}


