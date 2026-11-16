/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.ai

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerProcessor

class ArtificialIntelligenceLayerProcessor() extends LayerProcessor(new ArtificialIntelligenceLayerManager()) {

    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, index : Int) : Unit = {
        var artificialIntelligenceCompositeInterface : ArtificialIntelligenceCompositeInterface = layerInterface.asInstanceOf[ArtificialIntelligenceCompositeInterface]
        artificialIntelligenceCompositeInterface.getArtificialIntelligenceInterface().processAI(allBinaryLayerManager)
    }

    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        /*         if (layerInterface instanceof ArtificialIntelligenceInterface)         {             throw new Exception("Uh oh you still have not gone to all composites");         }         */
        if (layerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


