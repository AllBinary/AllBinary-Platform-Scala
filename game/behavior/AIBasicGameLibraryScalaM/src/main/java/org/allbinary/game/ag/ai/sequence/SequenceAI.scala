/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.sequence

import _root_.org.allbinary.ai.ArtificialIntelligence
import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.ai.ArtificialIntelligenceTransitionInterface
import _root_.org.allbinary.game.ag.ai.ArrayAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class SequenceAI(param_artificialIntelligenceInterfaceArray : Array[ArtificialIntelligenceInterface], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends ArrayAI(param_artificialIntelligenceInterfaceArray, param_ownerLayerInterface, param_gameInput) {
    import _root_.org.allbinary.game.ag.ai.sequence.SequenceAI.{*}

    private var index : Int = 0

    //Constructor
    {
        val artificialIntelligenceInterfaceArray : Array[ArtificialIntelligenceInterface] = param_artificialIntelligenceInterfaceArray
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        this.getArtificialIntelligenceInterface()(this.index).processAI(allBinaryLayerManager)
    }

    def next() : Unit = {
        this.index += 1
        val artificialIntelligenceInterface : ArtificialIntelligenceInterface = this.getSelectedArtificialIntelligenceInterface()
        if (artificialIntelligenceInterface.getId() == ArtificialIntelligence.AI_ID) {
            val artificialIntelligenceTransitionInterface : ArtificialIntelligenceTransitionInterface = artificialIntelligenceInterface.asInstanceOf[ArtificialIntelligenceTransitionInterface]
            artificialIntelligenceTransitionInterface.transition()
        }
    }

    def getIndex() : Int = {
        return this.index
    }

    def setIndex(index : Int) : Unit = {
        this.index = index
    }

    def getSelectedArtificialIntelligenceInterface() : ArtificialIntelligenceInterface = {
        return this.getArtificialIntelligenceInterface()(this.index)
    }

    override def getName() : String = {
        return SequenceAI.SEQUENCE_AI
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(" Selected AI: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.getSelectedArtificialIntelligenceInterface()))
        return stringBuffer.toString()
    }

}

object SequenceAI {
    private val SEQUENCE_AI : String = "Sequence AI"

}


