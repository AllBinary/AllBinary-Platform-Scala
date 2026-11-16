/* Generated Code Do Not Modify */
package org.allbinary.game.layer.drop

import _root_.org.allbinary.layer.AllBinaryLayerFactoryInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class PlacedLayerFactory private() {
    import _root_.org.allbinary.game.layer.drop.PlacedLayerFactory.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    def clear() : Unit = {
        this.list.clear()
    }

    def getSize() : Int = {
        return this.list.size()
    }

    def getRandomInstance() : AllBinaryLayerFactoryInterface = {
        return this.basicArrayListUtil.getRandom(this.list).asInstanceOf[AllBinaryLayerFactoryInterface]
    }

    def add(layerInterfaceFactoryInterface : AllBinaryLayerFactoryInterface) : Unit = {
        this.list.add(layerInterfaceFactoryInterface)
    }

}

object PlacedLayerFactory {
    private val instance : PlacedLayerFactory = new PlacedLayerFactory()

    def getInstance() : PlacedLayerFactory = {
        return PlacedLayerFactory.instance
    }

}


