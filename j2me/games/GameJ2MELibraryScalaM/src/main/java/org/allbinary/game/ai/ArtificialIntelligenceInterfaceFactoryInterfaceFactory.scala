/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ai

import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class ArtificialIntelligenceInterfaceFactoryInterfaceFactory {
    import _root_.org.allbinary.game.ai.ArtificialIntelligenceInterfaceFactoryInterfaceFactory.{*}

    private var list : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    def clear() : Unit = {
        this.list = new BasicArrayListD()
    }

    def getInstanceFromCollection(hashtable : ABHashtable[Object, Object]) : ArtificialIntelligenceInterfaceFactoryInterface = {
        val typeInteger : Integer = hashtable.get(BasicAI.ID.asInstanceOf[Object]).asInstanceOf[Integer]
        var `type` : Int = typeInteger.intValue()
        val artificialIntelligenceInterfaceFactoryInterface : ArtificialIntelligenceInterfaceFactoryInterface = this.list.objectArray(`type` - 1).asInstanceOf[ArtificialIntelligenceInterfaceFactoryInterface]
        return artificialIntelligenceInterfaceFactoryInterface
    }

    def add(artificialIntelligenceInterfaceFactoryInterface : ArtificialIntelligenceInterfaceFactoryInterface) : Unit = {
        this.list.add(artificialIntelligenceInterfaceFactoryInterface)
    }

}

object ArtificialIntelligenceInterfaceFactoryInterfaceFactory {
    private var SINGLETON : ArtificialIntelligenceInterfaceFactoryInterfaceFactory = new ArtificialIntelligenceInterfaceFactoryInterfaceFactory()

    def getInstance() : ArtificialIntelligenceInterfaceFactoryInterfaceFactory = {
        return ArtificialIntelligenceInterfaceFactoryInterfaceFactory.SINGLETON
    }

}


