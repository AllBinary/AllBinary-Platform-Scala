/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.drop

import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class DropLayerFactory private() {
    import _root_.org.allbinary.game.layer.drop.DropLayerFactory.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    /*    private PickedUpLayerInterfaceFactoryInterface getInstance(int index)    {       return (PickedUpLayerInterfaceFactoryInterface) this.list.get(index);    }    */
    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    def clear() : Unit = {
        this.list.clear()
    }

    def getSize() : Int = {
        return this.list.size()
    }

    def getRandomInstance() : PickedUpLayerInterfaceFactoryInterface = {
        return this.basicArrayListUtil.getRandom(this.list).asInstanceOf[PickedUpLayerInterfaceFactoryInterface]
    }

    def add(layerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface) : Unit = {
        this.list.add(layerInterfaceFactoryInterface)
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}

object DropLayerFactory {
    private val DROP_LAYER_FACTORY : DropLayerFactory = new DropLayerFactory()

    def getInstance() : DropLayerFactory = {
        return DropLayerFactory.DROP_LAYER_FACTORY
    }

}


