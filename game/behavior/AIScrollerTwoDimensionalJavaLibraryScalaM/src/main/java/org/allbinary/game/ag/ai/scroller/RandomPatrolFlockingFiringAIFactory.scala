/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ag.ai.ArrayAI
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.util.ABHashtable

class RandomPatrolFlockingFiringAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        val artificialIntelligenceInterface : Array[ArtificialIntelligenceInterface] = new Array[ArtificialIntelligenceInterface](2)
        artificialIntelligenceInterface(0) = new RandomPatrolAI(hashtable, ownerLayerInterface, gameInput)
        artificialIntelligenceInterface(1) = new TimedFireAI(1800, ownerLayerInterface, gameInput)
        //  new FlockingAI(hashtable, ownerLayerInterface, gameInput);
        return new ArrayAI(artificialIntelligenceInterface, ownerLayerInterface, gameInput)
    }

}


