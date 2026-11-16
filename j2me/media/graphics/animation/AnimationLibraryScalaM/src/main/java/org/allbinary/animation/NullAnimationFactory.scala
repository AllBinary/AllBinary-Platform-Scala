/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.media.ScaleProperties

class NullAnimationFactory private() extends AnimationInterfaceFactoryInterface with ProceduralAnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.NullAnimationFactory.{*}

    private val NULL_ANIMATION : Animation = new Animation {
            override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
            }

        }

    val EMPTY_ARRAY : Array[Animation] = new Array[Animation](0)

    override def getInstance(instanceId : Int) : Animation = {
        return this.NULL_ANIMATION
    }

    override def getInstanceAnimation(animationInterface : Animation) : Animation = {
        return this.NULL_ANIMATION
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}

object NullAnimationFactory {
    var NULL_NOT_FOR_USE_ANIMATION_FACTORY : NullAnimationFactory = new NullAnimationFactory()

    private var NULL_ANIMATION_FACTORY : NullAnimationFactory = new NullAnimationFactory()

    def getFactoryInstance() : NullAnimationFactory = {
        return NullAnimationFactory.NULL_ANIMATION_FACTORY
    }

}


