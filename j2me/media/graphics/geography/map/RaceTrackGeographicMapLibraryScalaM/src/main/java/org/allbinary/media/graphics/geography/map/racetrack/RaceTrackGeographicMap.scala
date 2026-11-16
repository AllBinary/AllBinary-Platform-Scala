/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionBaseFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInterface
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory

class RaceTrackGeographicMap(param_raceTrackInfo : RaceTrackInfo, param_raceTrackData : RaceTrackData, param_tiledLayerFactoryInterface : AllBinaryTiledLayerFactoryInterface, param_geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface, param_geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory, param_geographicMapCellTypeFactory : GeographicMapCellTypeFactory, param_customMapGeneratorBaseFactory : CustomMapGeneratorBaseFactory) extends BaseRaceTrackGeographicMap(param_raceTrackInfo, param_raceTrackData, param_tiledLayerFactoryInterface.getInstance(param_raceTrackInfo, param_raceTrackData), new BasicGeographicMapFactory().getInstance(param_raceTrackInfo, param_raceTrackData, param_tiledLayerFactoryInterface, param_geographicMapCellPositionFactoryInterface, param_geographicMapCellTypeFactory), param_geographicMapCellPositionFactoryInterface, param_geographicMapCellPositionBaseFactory, param_geographicMapCellTypeFactory) {

    private var customMapGenerator : CustomMapGeneratorBase = null

    //Constructor
    {
        val raceTrackInfo : RaceTrackInfo = param_raceTrackInfo
        val raceTrackData : RaceTrackData = param_raceTrackData
        val tiledLayerFactoryInterface : AllBinaryTiledLayerFactoryInterface = param_tiledLayerFactoryInterface
        val geographicMapCellPositionFactoryInterface : GeographicMapCellPositionFactoryInterface = param_geographicMapCellPositionFactoryInterface
        val geographicMapCellPositionBaseFactory : GeographicMapCellPositionBaseFactory = param_geographicMapCellPositionBaseFactory
        val geographicMapCellTypeFactory : GeographicMapCellTypeFactory = param_geographicMapCellTypeFactory
        val customMapGeneratorBaseFactory : CustomMapGeneratorBaseFactory = param_customMapGeneratorBaseFactory
        this.customMapGenerator = customMapGeneratorBaseFactory.create(this)
    }

    def getCustomMapGenerator() : CustomMapGeneratorBase = {
        return this.customMapGenerator
    }

    //This should never happen remove when bug is found
    def isValid(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val customMapArray : Array[Array[Int]] = this.customMapGenerator.getCustomMapArray()
        if (geographicMapCellPosition.getColumn() >= customMapArray(0).length) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Column: ")
            stringBuffer.appendint(geographicMapCellPosition.getColumn())
            stringBuffer.append(" not in: ")
            stringBuffer.appendint(customMapArray(0).length)
            this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
            if (geographicMapCellPosition.getColumn() == customMapArray(0).length) {
                return true
            } else {
                return false
            }
        } else if (geographicMapCellPosition.getRow() > customMapArray.length) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Row: ")
            stringBuffer.appendint(geographicMapCellPosition.getRow())
            stringBuffer.append(" not in: ")
            stringBuffer.appendint(customMapArray.length)
            this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.IS_VALID)
            if (geographicMapCellPosition.getRow() == customMapArray.length) {
                return true
            } else {
                return false
            }
        }
        return true
    }

}


