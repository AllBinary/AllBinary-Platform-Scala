/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.ai

import _root_.org.allbinary.layer.AllBinaryLayerManager

/**  *  * @author user  */
class ArtificialIntelligence() extends ArtificialIntelligenceInterface {
    import _root_.org.allbinary.ai.ArtificialIntelligence.{AI_ID as _, *}
    def AI_ID : Int = _root_.org.allbinary.ai.ArtificialIntelligence.AI_ID

    override def processAI(layerManager : AllBinaryLayerManager) : Unit = {
    }

    override def getId() : Int = {
        return 1
    }

}

object ArtificialIntelligence {
    val AI_ID : Int = 2

    private val instance : ArtificialIntelligence = new ArtificialIntelligence()

    /**      * @return the instance      */
    def getInstance() : ArtificialIntelligence = {
        return ArtificialIntelligence.instance
    }

}


