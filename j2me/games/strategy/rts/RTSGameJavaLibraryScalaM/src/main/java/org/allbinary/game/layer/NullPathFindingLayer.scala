/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.waypoint.Waypoint2LogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointRunnableLogHelper
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class NullPathFindingLayer extends PathFindingLayerInterface {
    import _root_.org.allbinary.game.layer.NullPathFindingLayer.{NULL_PATH_FINDING_LAYER as _, *}
    def NULL_PATH_FINDING_LAYER : NullPathFindingLayer = _root_.org.allbinary.game.layer.NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    override def getName() : String = {
        throw new RuntimeException()
    }

    override def getEndGeographicMapCellPositionList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def shouldHandleStartSameAsEnd() : Boolean = {
        throw new RuntimeException()
    }

    override def getGeographicMapCellPositionArea() : GeographicMapCellPositionAreaBase = {
        throw new RuntimeException()
    }

    override def getHudPaintable() : SelectionHudPaintable = {
        throw new RuntimeException()
    }

    override def handleCost(ownerLayer : PathFindingLayerInterface) : Unit = {
        throw new RuntimeException()
    }

    override def getParentLayer() : PathFindingLayerInterface = {
        throw new RuntimeException()
    }

    override def getRTSLayer2LogHelper() : RTSLayer2LogHelper = {
        throw new RuntimeException()
    }

    override def setTarget(targetGameLayer : PathFindingLayerInterface) : Unit = {
        throw new RuntimeException()
    }

    override def init(geographicMapCellHistory : GeographicMapCellHistory, geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit = {
        throw new RuntimeException()
    }

    override def getMoveOutOfBuildAreaPath(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        throw new RuntimeException()
    }

    override def setClosestGeographicMapCellHistory(pathsList : BasicArrayList) : Unit = {
        throw new RuntimeException()
    }

    override def teleportTo(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        throw new RuntimeException()
    }

    override def setLoad(resource : Int) : Unit = {
        throw new RuntimeException()
    }

    override def getSurroundingGeographicMapCellPositionList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def isSelected() : Boolean = {
        throw new RuntimeException()
    }

    override def shouldAddWaypointFromBuilding() : Boolean = {
        throw new RuntimeException()
    }

    override def isShowMoreCaptionStates() : Boolean = {
        throw new RuntimeException()
    }

    override def trackTo(reason : String) : Unit = {
        throw new RuntimeException()
    }

    override def trackToDXY(dx : Int, dy : Int) : Unit = {
        throw new RuntimeException()
    }

    override def buildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Boolean = {
        throw new RuntimeException()
    }

    override def getTrackingEvent() : TrackingEvent = {
        throw new RuntimeException()
    }

    override def allStop() : Unit = {
        throw new RuntimeException()
    }

    override def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        throw new RuntimeException()
    }

    override def getCurrentGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getTopLeftGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getCaptionAnimationHelper() : CaptionAnimationHelperBase = {
        throw new RuntimeException()
    }

    override def getWaypointBehavior() : WaypointBehaviorBase = {
        throw new RuntimeException()
    }

    override def getWaypointLogHelper() : WaypointLogHelper = {
        throw new RuntimeException()
    }

    override def getWaypoint2LogHelper() : Waypoint2LogHelper = {
        throw new RuntimeException()
    }

    override def getWaypointRunnableLogHelper() : WaypointRunnableLogHelper = {
        throw new RuntimeException()
    }

    override def getGroupInterface() : Array[Group] = {
        throw new RuntimeException()
    }

    override def isDestroyed() : Boolean = {
        throw new RuntimeException()
    }

    override def getSourceId() : Int = {
        throw new RuntimeException()
    }

}

object NullPathFindingLayer {
    val NULL_PATH_FINDING_LAYER : NullPathFindingLayer = new NullPathFindingLayer()

}


