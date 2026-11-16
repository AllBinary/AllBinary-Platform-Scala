/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterface
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.util.ABHashtable

class TerrainPatrolAIFactory extends ArtificialIntelligenceInterfaceFactoryInterface {

    override def getInstance(hashtable : ABHashtable[Object, Object], ownerLayerInterface : AllBinaryLayer, gameInput : GameInput) : ArtificialIntelligenceInterface = {
        hashtable.put(BasePatrolAI.MAX_DISTANCE, SmallIntegerSingletonFactory.getInstance().getAt(220))
        return new TerrainPatrolAI(hashtable, ownerLayerInterface, gameInput)
    }

}


