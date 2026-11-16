/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.tactical

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.ag.ai.InputProbability
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.util.ABHashtable

class BasicRandomAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        var visitor : Visitor = hashtable.get(BasicAI.AI_VISITOR.asInstanceOf[Object]).asInstanceOf[Visitor]
        if (visitor == null) {
            throw new Exception("No Visitor Provided")
        }
        val inputProbability : InputProbability = hashtable.get(InputProbability.INPUT_PROBABILITY.asInstanceOf[Object]).asInstanceOf[InputProbability]
        return new BasicRandomAI(ownerLayerInterface, gameInput, inputProbability, visitor)
    }

}


