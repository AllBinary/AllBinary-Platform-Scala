/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.layer.Layer

trait GeographicMapInterface {

    def getId() : Integer

    def getName() : String

    def reset() : Unit

    def getAllBinaryTiledLayer() : AllBinaryTiledLayer

    def getCellPositionsAt(layer : Layer, currentCellPositionArray : Array[Array[GeographicMapCellPosition]], cellPositionArray : Array[Array[GeographicMapCellPosition]]) : Boolean

    def getCellPositionAtXY(x : Int, y : Int) : GeographicMapCellPosition

    def getCellPositionAtXYNoThrow(x : Int, y : Int) : GeographicMapCellPosition

    // throws Exception;
    def getCellTypeFromMapCellTypeInt(cellTypeId : Int) : Int

    def getCellTypeAtXY(x : Int, y : Int) : GeographicMapCellType

    def getCellTypeAt(geographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellType

    def getGeographicMapCellPositionFactory() : BasicGeographicMapCellPositionFactory

    def getGeographicMapCellPositionFactoryInterface() : GeographicMapCellPositionFactoryInterface

    def getForegroundBasicColor() : BasicColor

    def getBackgroundBasicColor() : BasicColor

}


