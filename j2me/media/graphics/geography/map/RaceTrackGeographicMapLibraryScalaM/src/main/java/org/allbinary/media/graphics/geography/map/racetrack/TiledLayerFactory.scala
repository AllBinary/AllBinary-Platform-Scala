/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.javax.microedition.lcdui.game.TiledLayer

/**  *  * @author user  */
class TiledLayerFactory {

    def getInstance(raceTrackData : RaceTrackData) : TiledLayer = {
        val mapArray : Array[Array[Int]] = raceTrackData.getMapArray()
        return new TiledLayer(mapArray(0).length, mapArray.length, raceTrackData.getTileSetImage(), raceTrackData.getCellWidth(), raceTrackData.getCellHeight())
    }

    def getMiniInstance(raceTrackData : RaceTrackData) : TiledLayer = {
        val mapArray : Array[Array[Int]] = raceTrackData.getMapArray()
        return new TiledLayer(mapArray(0).length, mapArray.length, raceTrackData.getMiniTileSetImage(), raceTrackData.getMiniCellWidth(), raceTrackData.getMiniCellHeight())
    }

}


