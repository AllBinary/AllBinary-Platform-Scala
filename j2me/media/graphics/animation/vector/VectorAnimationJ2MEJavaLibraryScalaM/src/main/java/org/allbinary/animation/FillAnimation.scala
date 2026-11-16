/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author User  */
class FillAnimation(param_pixelBuffer : Array[Int], param_width : Int, param_height : Int, param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) {

    private var pixelBuffer : Array[Int] = null

    private var width : Int = 0

    private var height : Int = 0

    //Constructor
    {
        val pixelBuffer : Array[Int] = param_pixelBuffer
        val width : Int = param_width
        val height : Int = param_height
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.width = 100
        this.height = 100
        this.pixelBuffer = pixelBuffer
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        if ((this.getBasicColorP() == null) || (this.getBasicColorP().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.setBasicColorP(basicColor)
        if (changed) {
            //            this.setColorProcessor = SetColorProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def changeBasicColor(basicColor : BasicColor) : Unit = {
        var changed : Boolean = false
        //if(this.getBasicColorP() == null || this.getBasicColorP().intValue() != basicColor.intValue()) {
        if ((this.getChangeBasicColor() == null) || (this.getChangeBasicColor().intValue() != basicColor.intValue())) {
            changed = true
        }
        super.changeBasicColor(basicColor)
        if (changed) {
            //            this.changeColorProcessor = ChangeColorProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def setAlpha(alpha : Int) : Unit = {
        var changed : Boolean = false
        if (this.alphaP != alpha) {
            changed = true
        }
        super.setAlpha(alpha)
        if (changed) {
            //            this.alphaProcessor = AlphaProcessor.getInstance();
            this.updateModifiers()
        }
    }

    override def setScale(scaleX : Float, scaleY : Float) : Unit = {
    }

    override def setMaxScale(maxScaleX : Float, maxScaleY : Float) : Unit = {
    }

    private def updateModifiers() : Unit = {
    }

    def paint(g : Graphics) : Unit = {
        g.drawRGB(pixelBuffer, 0, width, 0, 0, width, height, true)
    }

}


