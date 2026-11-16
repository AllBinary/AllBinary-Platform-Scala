/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.layer.Layer

/**  *  * @author User  */
class LinePathRelativeAnimation extends LinePathAnimation {
    import _root_.org.allbinary.game.layer.LinePathRelativeAnimation.{*}

    override def paint(graphics : Graphics, point : GPoint, nextPoint : GPoint, tiledLayer : Layer) : Unit = {
        graphics.drawLine(nextPoint.getX() - tiledLayer.getXP(), nextPoint.getY() - tiledLayer.getYP(), point.getX() - tiledLayer.getXP(), point.getY() - tiledLayer.getYP())
    }

}

object LinePathRelativeAnimation {
    private val instanceC : LinePathRelativeAnimation = new LinePathRelativeAnimation()

    /**      * @return the instance      */
    def getInstance() : LinePathAnimation = {
        return LinePathRelativeAnimation.instanceC
    }

}


