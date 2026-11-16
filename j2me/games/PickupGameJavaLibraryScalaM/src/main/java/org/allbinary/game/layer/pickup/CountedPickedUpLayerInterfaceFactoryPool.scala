/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CountedPickedUpLayerInterfaceFactoryPool private() {
    import _root_.org.allbinary.game.layer.pickup.CountedPickedUpLayerInterfaceFactoryPool.{*}

    private var list : BasicArrayList = null

    //Constructor
    {
        this.list = new BasicArrayListD()
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}

object CountedPickedUpLayerInterfaceFactoryPool {
    private var SINGLETON : CountedPickedUpLayerInterfaceFactoryPool = new CountedPickedUpLayerInterfaceFactoryPool()

    def getInstance() : CountedPickedUpLayerInterfaceFactoryPool = {
        return CountedPickedUpLayerInterfaceFactoryPool.SINGLETON
    }

    def init() : Unit = {
        CountedPickedUpLayerInterfaceFactoryPool.SINGLETON = new CountedPickedUpLayerInterfaceFactoryPool()
    }

}


