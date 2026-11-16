/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.sequence

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class NumberLayersSequenceAI(param_numberOfEnemiesLeft : Int, param_artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends SequenceAI(param_artificialIntelligenceInterface, param_ownerLayerInterface, param_gameInput) {

    private var numberOfLayersLeft : Int = 0

    //Constructor
    {
        val numberOfEnemiesLeft : Int = param_numberOfEnemiesLeft
        val artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface] = param_artificialIntelligenceInterface
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.numberOfLayersLeft = numberOfEnemiesLeft
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.getIndex() == 0) {
            if (allBinaryLayerManager.getSize() < this.numberOfLayersLeft) {
                this.setIndex(1)
            }
        }
        super.processAI(allBinaryLayerManager)
    }

}


