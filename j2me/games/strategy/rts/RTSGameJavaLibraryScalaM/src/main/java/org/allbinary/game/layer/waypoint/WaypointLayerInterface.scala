/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
trait WaypointLayerInterface {

    def init(geographicMapCellHistory : GeographicMapCellHistory, geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit

    def getMoveOutOfBuildAreaPath(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList

    def setClosestGeographicMapCellHistory(pathsList : BasicArrayList) : Unit

    def teleportTo(geographicMapCellPosition : GeographicMapCellPosition) : Unit

    def setLoad(resource : Int) : Unit

    def getSurroundingGeographicMapCellPositionList() : BasicArrayList

    def isSelected() : Boolean

    def shouldAddWaypointFromBuilding() : Boolean

    def isShowMoreCaptionStates() : Boolean

    def trackTo(reason : String) : Unit

    def trackToDXY(dx : Int, dy : Int) : Unit

    def buildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Boolean

    def getTrackingEvent() : TrackingEvent

    def allStop() : Unit

    def isWaypointListEmptyOrOnlyTargets() : Boolean

    def getCurrentGeographicMapCellPosition() : GeographicMapCellPosition

    def getTopLeftGeographicMapCellPosition() : GeographicMapCellPosition

    def getCaptionAnimationHelper() : CaptionAnimationHelperBase

    def getWaypointBehavior() : WaypointBehaviorBase

    def getWaypointLogHelper() : WaypointLogHelper

    def getWaypoint2LogHelper() : Waypoint2LogHelper

    def getWaypointRunnableLogHelper() : WaypointRunnableLogHelper

}


