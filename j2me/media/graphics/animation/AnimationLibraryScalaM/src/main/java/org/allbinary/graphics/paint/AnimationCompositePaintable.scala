/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation

/**  *  * @author user  */
class AnimationCompositePaintable(param_animationInterface : Animation) extends InitUpdatePaintable {

    private var animationInterface : Animation = null

    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        this.animationInterface = animationInterface
    }

    override def paint(graphics : Graphics) : Unit = {
        this.animationInterface.paintXY(graphics, 0, 0)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        this.animationInterface.paintThreedXYZ(graphics, 0, 0, 0)
    }

}


