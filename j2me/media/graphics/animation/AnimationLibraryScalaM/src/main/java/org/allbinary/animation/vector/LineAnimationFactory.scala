/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.ScaleProperties

/**  *  * @author user  */
class LineAnimationFactory(param_basicColor : BasicColor) extends AnimationInterfaceFactoryInterface {

    private var basicColor : BasicColor = null

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        this.basicColor = basicColor
    }

    override def getInstance(instanceId : Int) : Animation = {
        return new LineAnimation(this.basicColor)
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


