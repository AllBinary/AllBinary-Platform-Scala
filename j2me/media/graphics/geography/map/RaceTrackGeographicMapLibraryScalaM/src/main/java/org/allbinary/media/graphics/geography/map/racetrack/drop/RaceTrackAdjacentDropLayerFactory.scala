/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack.drop

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.layer.LayerInterfaceFactoryInterface

class RaceTrackAdjacentDropLayerFactory private() {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.drop.RaceTrackAdjacentDropLayerFactory.{*}

    private var list : BasicArrayList = new BasicArrayListD()

    /*    private LayerInterfaceFactoryInterface getInstance(int index)    {       return (LayerInterfaceFactoryInterface) this.list.get(index);    }    */
    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    def clear() : Unit = {
        this.list.clear()
    }

    def getSize() : Int = {
        return this.list.size()
    }

    def getRandomInstance() : LayerInterfaceFactoryInterface = {
        return this.basicArrayListUtil.getRandom(this.list).asInstanceOf[LayerInterfaceFactoryInterface]
    }

    def add(layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface) : Unit = {
        this.list.add(layerInterfaceFactoryInterface)
    }

}

object RaceTrackAdjacentDropLayerFactory {
    private var DROP_LAYER_FACTORY : RaceTrackAdjacentDropLayerFactory = new RaceTrackAdjacentDropLayerFactory()

    def getInstance() : RaceTrackAdjacentDropLayerFactory = {
        return RaceTrackAdjacentDropLayerFactory.DROP_LAYER_FACTORY
    }

}


