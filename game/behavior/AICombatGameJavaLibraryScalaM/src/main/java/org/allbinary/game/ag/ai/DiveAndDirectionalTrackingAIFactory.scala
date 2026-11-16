/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ag.ai.tactical.BasicRandomAIFactory
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.util.ABHashtable

class DiveAndDirectionalTrackingAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        var visitorCanBeNull : Object = hashtable.get(BasicAI.AI_VISITOR.asInstanceOf[Object])
        if (visitorCanBeNull == null) {
            visitorCanBeNull = ThrustAIVisitorFactory.getInstance()
        }
        val hashtable2 : ABHashtable[Object, Object] = new BasicProbabilityAIDataFactory().getInstance()
        hashtable2.put(BasicAI.AI_VISITOR, LastKeyAIVisitorFactory.getInstance())
        val artificialIntelligenceInterface : ArtificialIntelligenceInterface = new BasicRandomAIFactory().getInstance(hashtable2, ownerLayerInterface, gameInput)
        return new DiveAndDirectionalTrackingAI(ownerLayerInterface, artificialIntelligenceInterface, gameInput, visitorCanBeNull.asInstanceOf[Visitor])
    }

}


