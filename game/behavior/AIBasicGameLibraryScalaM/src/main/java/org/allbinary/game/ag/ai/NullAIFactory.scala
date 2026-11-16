/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.util.ABHashtable

class NullAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {
    import _root_.org.allbinary.game.ag.ai.NullAIFactory.{*}

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        //return new NullAI();
        return NullAIFactory.NULL_AI
    }

}

object NullAIFactory {
    private var NULL_AI : NullAI = new NullAI()

    def getInstance() : ArtificialIntelligenceInterface = {
        return NullAIFactory.NULL_AI
    }

}


