/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.pickup.life

import _root_.org.allbinary.game.ag.life.Life
import _root_.org.allbinary.game.ag.life.LifeInterfaceCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerCircularPool
import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface

class LifeLayerCircularStaticPool(param_allbinaryLayerFactoryInterface : AllBinaryLayerFactoryInterface, param_total : Int) extends AllBinaryLayerCircularPool {

    //Constructor
    {
        val allbinaryLayerFactoryInterface : AllBinaryLayerFactoryInterface = param_allbinaryLayerFactoryInterface
        val total : Int = param_total
        super.initAllBinaryLayerCircularPool(allbinaryLayerFactoryInterface, total)
    }

    def visit(sourceLayerInterface : AllBinaryLayer) : Unit = {
        val lifeLayer : LifeLayer = this.getNextInstance().asInstanceOf[LifeLayer]
        val lifeInterfaceCompositeInterface : LifeInterfaceCompositeInterface = sourceLayerInterface.asInstanceOf[LifeInterfaceCompositeInterface]
        val lifeInterface : Life = lifeInterfaceCompositeInterface.getLifeInterface()
        lifeLayer.visit(lifeInterface)
    }

}


