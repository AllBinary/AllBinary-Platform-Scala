/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tick

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerProcessor

class TickableLayerProcessor() extends LayerProcessor(new TickableLayerManager()) {

    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, index : Int) : Unit = {
        // no physics here - just destroy them
        var tickableInterface : TickableInterface = layerInterface.asInstanceOf[TickableInterface]
        tickableInterface.processTick(allBinaryLayerManager)
    }

    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        if (layerInterface.implmentsTickableInterface()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


