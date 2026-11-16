/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.media.ScaleProperties

class BaseAnimationInterfaceFactoryInterfaceComposite(param_basicAnimationInterfaceFactoryInterfaceArray : Array[BasicAnimationInterfaceFactoryInterface]) extends AnimationInterfaceFactoryInterface {

    private var basicAnimationInterfaceFactoryInterfaceArray : Array[BasicAnimationInterfaceFactoryInterface] = null

    //Constructor
    {
        val basicAnimationInterfaceFactoryInterfaceArray : Array[BasicAnimationInterfaceFactoryInterface] = param_basicAnimationInterfaceFactoryInterfaceArray
        this.basicAnimationInterfaceFactoryInterfaceArray = basicAnimationInterfaceFactoryInterfaceArray
    }

    override def getInstance(instanceId : Int) : Animation = {
        return NullAnimationFactory.getFactoryInstance().getInstance(0)
    }

    /**      * @return the basicAnimationInterfaceFactoryInterfaceArray      */
    def getBasicAnimationInterfaceFactoryInterfaceArray() : Array[BasicAnimationInterfaceFactoryInterface] = {
        return this.basicAnimationInterfaceFactoryInterfaceArray
    }

    /**      * @param basicAnimationInterfaceFactoryInterfaceArray the basicAnimationInterfaceFactoryInterfaceArray to set      */
    def setBasicAnimationInterfaceFactoryInterfaceArray(basicAnimationInterfaceFactoryInterfaceArray : Array[BasicAnimationInterfaceFactoryInterface]) : Unit = {
        this.basicAnimationInterfaceFactoryInterfaceArray = basicAnimationInterfaceFactoryInterfaceArray
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

}


