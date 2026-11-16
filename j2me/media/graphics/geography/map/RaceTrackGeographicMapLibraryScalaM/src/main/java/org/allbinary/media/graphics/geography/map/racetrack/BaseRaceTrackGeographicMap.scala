/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionBaseFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInterface
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType

class BaseRaceTrackGeographicMap(param_raceTrackInfo : RaceTrackInfo, param_raceTrackData : RaceTrackData, param_tiledLayer : AllBinaryTiledLayer, param_miniGeographicMap : BasicGeographicMap, param_geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface, param_geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory, param_geographicMapCellTypeFactory : GeographicMapCellTypeFactory) extends BasicGeographicMap(param_raceTrackInfo.getId(), param_raceTrackInfo.getName(), param_raceTrackData.getCellTypeIdToGeographicMapCellTypeArray(), param_tiledLayer, param_raceTrackInfo.getForegroundBasicColor(), param_raceTrackInfo.getBackgroundBasicColor(), param_geographicMapCellPositionFactoryInterface, param_geographicMapCellPositionBaseFactory, param_geographicMapCellTypeFactory) with RaceTrackGeographicMapInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //public static final String NAME = "RACE_TRACK_MAP";
    private var raceTrackInfo : RaceTrackInfo = null

    private var raceTrackData : RaceTrackData = null

    private var miniGeographicMap : BasicGeographicMap = null

    //Constructor
    {
        val raceTrackInfo : RaceTrackInfo = param_raceTrackInfo
        val raceTrackData : RaceTrackData = param_raceTrackData
        val tiledLayer : AllBinaryTiledLayer = param_tiledLayer
        val miniGeographicMap : BasicGeographicMap = param_miniGeographicMap
        val geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface = param_geographicMapCellPositionFactoryInterface
        val geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory = param_geographicMapCellPositionBaseFactory
        val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = param_geographicMapCellTypeFactory
        this.raceTrackInfo = raceTrackInfo
        this.raceTrackData = raceTrackData
        this.miniGeographicMap = miniGeographicMap
        var miniTiledLayer : AllBinaryTiledLayer = this.miniGeographicMap.getAllBinaryTiledLayer()
        if (miniTiledLayer.getColumns() != this.getGeographicMapCellPositionFactory().getColumns()) {
            val error : String = new StringMaker().append("RaceTrackMap has incorrect Mini Map columns: ").appendint(miniTiledLayer.getColumns()).append(" != ").appendint(this.getGeographicMapCellPositionFactory().getColumns()).toString()
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR)
            throw new Exception(error)
        }
        if (miniTiledLayer.getRows() != this.getGeographicMapCellPositionFactory().getRows()) {
            var error : String = "RaceTrackMap has incorrect Mini Map rows"
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR)
            throw new Exception(error)
        }
    }

    override def getRaceTrackInfo() : RaceTrackInfo = {
        return this.raceTrackInfo
    }

    override def setRaceTrackInfo(aRaceTrackInfo : RaceTrackInfo) : Unit = {
        this.raceTrackInfo = aRaceTrackInfo
    }

    def setMiniBasicGeographicMap(miniBasicGeographicMap : BasicGeographicMap) : Unit = {
        this.miniGeographicMap = miniBasicGeographicMap
    }

    def getMiniBasicGeographicMap() : BasicGeographicMap = {
        return this.miniGeographicMap
    }

    override def getRaceTrackData() : RaceTrackData = {
        return this.raceTrackData
    }

    override def setRaceTrackData(raceTrackData : RaceTrackData) : Unit = {
        this.raceTrackData = raceTrackData
    }

    //Needed for polyglot do not remove
    override def getId() : Integer = {
        return super.getId()
    }

    //Needed for polyglot do not remove
    override def getName() : String = {
        return super.getName()
    }

    //Needed for polyglot do not remove
    override def reset() : Unit = {
        super.reset()
    }

    //Needed for polyglot do not remove
    override def getAllBinaryTiledLayer() : AllBinaryTiledLayer = {
        return super.getAllBinaryTiledLayer()
    }

    //Needed for polyglot do not remove
    override def getCellTypeFromMapCellTypeInt(cellTypeId : Int) : Int = {
        return super.getCellTypeFromMapCellTypeInt(cellTypeId)
    }

    //Needed for polyglot do not remove
    override def getCellTypeAt(cellPosition : GeographicMapCellPosition) : GeographicMapCellType = {
        return super.getCellTypeAt(cellPosition)
    }

    //Needed for polyglot do not remove
    override def getForegroundBasicColor() : BasicColor = {
        return super.getForegroundBasicColor()
    }

    //Needed for polyglot do not remove
    override def getBackgroundBasicColor() : BasicColor = {
        return super.getBackgroundBasicColor()
    }

}


