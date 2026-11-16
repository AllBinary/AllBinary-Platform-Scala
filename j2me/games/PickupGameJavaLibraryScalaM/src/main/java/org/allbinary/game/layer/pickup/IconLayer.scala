/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.view.ViewPosition

class IconLayer(param_animationInterface : Animation, param_width : Int, param_height : Int) extends AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, new Rectangle(PointFactory.getInstance().ZERO_ZERO, param_width, param_height), ViewPosition.getInstanceD()) {
    import _root_.org.allbinary.game.layer.pickup.IconLayer.{NULL_ICON_LAYER as _, *}
    def NULL_ICON_LAYER : IconLayer = _root_.org.allbinary.game.layer.pickup.IconLayer.NULL_ICON_LAYER

    private var animationInterface : Animation = null

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val width : Int = param_width
        val height : Int = param_height
        this.animationInterface = animationInterface
    }

    override def paint(graphics : Graphics) : Unit = {
        this.animationInterface.paintXY(graphics, this.x, this.y)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        this.animationInterface.paintThreedXYZ(graphics, this.x, this.y, this.z)
    }

    def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

}

object IconLayer {
    val NULL_ICON_LAYER : IconLayer = new IconLayer(NullAnimationFactory.getFactoryInstance().getInstance(0), 0, 0)

}


