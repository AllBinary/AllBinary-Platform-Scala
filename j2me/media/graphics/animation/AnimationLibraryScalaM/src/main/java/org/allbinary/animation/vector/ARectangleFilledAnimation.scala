/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.color.BasicColorFactory

class ARectangleFilledAnimation() extends RectangleFilledAnimation(0, 0, BasicColorFactory.getInstance().BLACK) {

    var x : Int = 0

    var y : Int = 0

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, unusedX : Int, unusedY : Int) : Unit = {
        super.paintXY(graphics, this.x, this.y)
    }

}


