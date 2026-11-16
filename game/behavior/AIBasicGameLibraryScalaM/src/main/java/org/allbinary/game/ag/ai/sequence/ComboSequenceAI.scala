/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.sequence

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class ComboSequenceAI(param_artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends SequenceAI(param_artificialIntelligenceInterface, param_ownerLayerInterface, param_gameInput) {

    //Constructor
    {
        val artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface] = param_artificialIntelligenceInterface
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        val artificialIntelligenceInterfaceArray : Array[ArtificialIntelligenceInterface] = this.getArtificialIntelligenceInterface()
        val size : Int = artificialIntelligenceInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.setIndex(index)
                super.processAI(allBinaryLayerManager)
                index += 1
            }
        }
    }

}


