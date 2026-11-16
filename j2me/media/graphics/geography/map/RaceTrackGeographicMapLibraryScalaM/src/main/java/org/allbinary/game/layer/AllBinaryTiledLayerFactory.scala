/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.game.TiledLayer
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.AllBinaryTiledLayerFactoryInterface
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackData
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackInfo
import _root_.org.allbinary.media.graphics.geography.map.racetrack.TiledLayerFactory

/**  *  * @author user  */
class AllBinaryTiledLayerFactory extends AllBinaryTiledLayerFactoryInterface {

    override def getInstance(raceTrackInfo : RaceTrackInfo, raceTrackData : RaceTrackData) : AllBinaryTiledLayer = {
        var allbinaryTiledLayer : AllBinaryTiledLayer = null
        val tiledLayer : TiledLayer = new TiledLayerFactory().getInstance(raceTrackData)
        allbinaryTiledLayer = new AllBinaryJ2METiledLayer(raceTrackData.getId(), tiledLayer, raceTrackData.getMapArray(), BasicColorFactory.getInstance().RED.intValue())
        allbinaryTiledLayer.setCells(raceTrackData.getMapArray())
        return allbinaryTiledLayer
    }

    override def getMiniInstance(raceTrackData : RaceTrackData) : AllBinaryTiledLayer = {
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val tiledLayer : TiledLayer = new TiledLayerFactory().getMiniInstance(raceTrackData)
        val allbinaryTiledLayer : AllBinaryTiledLayer = new AllBinaryJ2METiledLayer(smallIntegerSingletonFactory.getAt((raceTrackData.getId().intValue() + 100) + 1), tiledLayer, raceTrackData.getMapArray(), BasicColorFactory.getInstance().RED.intValue())
        allbinaryTiledLayer.setCells(raceTrackData.getMapArray())
        return allbinaryTiledLayer
    }

}


