/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack.drop

import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.drop.DropLayerFactory
import _root_.org.allbinary.game.layer.pickup.PickupLayerCircularStaticPool
import _root_.org.allbinary.game.layer.pickup.RaceTrackPickupLayer
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *   * @author user  */
class RaceTrackRandomDropCellPositionGenerator private() extends RaceTrackDropCellPositionGenerator {
    import _root_.org.allbinary.media.graphics.geography.map.racetrack.drop.RaceTrackRandomDropCellPositionGenerator.{*}

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    private val cellsPerRowOrColumn : Int = 3

    private val totalCells : Int = this.cellsPerRowOrColumn * this.cellsPerRowOrColumn

    private val rowArray : Array[Int] = Array[Int](0, 1, 2, 0, 1, 2, 0, 1, 2)

    private val columnArray : Array[Int] = Array[Int](0, 0, 0, 1, 1, 1, 2, 2, 2)

    private var cellWidth : Int = 0

    private var cellHeight : Int = 0

    override def update(allBinaryGameLayerManager : AllBinaryGameLayerManager, geographicMapInterface : BasicGeographicMap) : Unit = {
        super.update(allBinaryGameLayerManager, geographicMapInterface)
        var tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        this.cellWidth = tiledLayer.getCellWidth() / this.cellsPerRowOrColumn
        this.cellHeight = tiledLayer.getCellHeight() / this.cellsPerRowOrColumn
    }

    override def drop(allBinaryLayerManager : AllBinaryLayerManager, index : Int) : Unit = {
        var geographicMapCellPosition : GeographicMapCellPosition = this.list.get(index).asInstanceOf[GeographicMapCellPosition]
        // (RaceTrackGeographicMapCellType) this.typeList.get(index);
        var point : GPoint = geographicMapCellPosition.getPoint()
        var randomCell : Int = this.myRandomFactory.getAbsoluteNextInt(this.totalCells)
        var row : Int = this.rowArray(randomCell)
        var column : Int = this.columnArray(randomCell)
        var x : Int = point.getX() + (row * this.cellWidth)
        var y : Int = point.getY() + (column * this.cellHeight)
        var pickedUpLayerInterfaceFactory : PickedUpLayerInterfaceFactoryInterface = DropLayerFactory.getInstance().getRandomInstance()
        var tiledLayer : AllBinaryTiledLayer = this.raceTrackGeographicMap.getAllBinaryTiledLayer()
        var pickupLayer : RaceTrackPickupLayer = PickupLayerCircularStaticPool.getInstance().getInstanceXYZ(pickedUpLayerInterfaceFactory, x, y, tiledLayer.getZP() + 3).asInstanceOf[RaceTrackPickupLayer]
        pickupLayer.setTiledLayer(tiledLayer)
        /*          * PickedUpLayerInterfaceFactoryInterface          * pickedUpLayerInterfaceFactoryInterface =          * pickupLayer.getPickedUpLayerInterfaceFactoryInterface();          *           * IndexedAnimationInterface iconIndexedAnimationInterface =          * (IndexedAnimationInterface) ((IconLayer)          * pickedUpLayerInterfaceFactoryInterface.getIconLayer()).getAnimationInterface();          *           * IndexedAnimationInterface indexedAnimationInterface =          * (IndexedAnimationInterface)          * pickedUpLayerInterfaceFactoryInterface.getAnimationInterface();          *           * if(raceTrackGeographicMapCellType ==          * RaceTrackGeographicMapCellType.HORIZONTAL_STRAIGHT_ROAD_CELL_TYPE) {          * indexedAnimationInterface.setFrame(0);          * iconIndexedAnimationInterface.setFrame(0); } else {          * indexedAnimationInterface.setFrame(1);          * iconIndexedAnimationInterface.setFrame(1); }          */
        allBinaryLayerManager.append(pickupLayer)
    }

}

object RaceTrackRandomDropCellPositionGenerator {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var SINGLETON : RaceTrackRandomDropCellPositionGenerator = new RaceTrackRandomDropCellPositionGenerator()

    def getInstance() : RaceTrackRandomDropCellPositionGenerator = {
        return RaceTrackRandomDropCellPositionGenerator.SINGLETON
    }

}


