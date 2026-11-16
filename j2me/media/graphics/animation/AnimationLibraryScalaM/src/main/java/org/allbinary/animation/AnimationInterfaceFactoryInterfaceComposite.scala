/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.media.ScaleProperties

class AnimationInterfaceFactoryInterfaceComposite(param_basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface]) extends AnimationInterfaceFactoryInterface {

    private var animationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = null

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[AnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        this.animationInterfaceFactoryInterfaceArray = basicAnimationInterfaceFactoryInterfaceArray
    }

    override def getInstance(instanceId : Int) : Animation = {
        return NullAnimationFactory.getFactoryInstance().getInstance(0)
    }

    /**      * @return the basicAnimationInterfaceFactoryInterfaceArray      */
    def getAnimationInterfaceFactoryInterfaceArray() : Array[AnimationInterfaceFactoryInterface] = {
        return this.animationInterfaceFactoryInterfaceArray
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


