/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ag.ai.sequence.SequenceAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.layer.identification.GroupLayerManagerListener
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager

class NumberOnOwnGroupSequenceAI(param_numberOnSameTeam : Array[Integer], param_artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends SequenceAI(param_artificialIntelligenceInterface, param_ownerLayerInterface, param_gameInput) {

    private var numberOnSameTeam : Array[Integer] = null

    //Constructor
    {
        val numberOnSameTeam : Array[Integer] = param_numberOnSameTeam
        val artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface] = param_artificialIntelligenceInterface
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.numberOnSameTeam = numberOnSameTeam
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        val layerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
        var index : Int = this.getIndex()
        if (this.numberOnSameTeam.length > index) {
            val size : Int = GroupLayerManagerListener.getInstance().getGroupSizeFromInterface(layerInterface)
            if (this.numberOnSameTeam(index).intValue() > size) {
                this.next()
            }
        }
        super.processAI(allBinaryLayerManager)
    }

}


