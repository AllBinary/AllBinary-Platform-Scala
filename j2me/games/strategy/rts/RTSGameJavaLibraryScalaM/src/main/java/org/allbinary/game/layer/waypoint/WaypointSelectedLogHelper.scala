/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class WaypointSelectedLogHelper extends WaypointLogHelper {
    import _root_.org.allbinary.game.layer.waypoint.WaypointSelectedLogHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    override def onWaypointEvent(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        //        stringBuffer.append(associatedAdvancedRTSGameLayer.isSelected());
        stringBuffer.append(" onWaypointEvent: ")
        stringBuffer.append(advancedRTSGameLayer.getName())
        if (advancedRTSGameLayer.getParentLayer() != null) {
            stringBuffer.append(" With Parent: ")
            stringBuffer.append(advancedRTSGameLayer.getParentLayer().getName())
        }
        this.logUtil.putF(stringBuffer.toString(), this, "onWaypointEvent")
    }

    override def addWaypointFromBuilding(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        //        stringBuffer.append(associatedAdvancedRTSGameLayer.isSelected());
        stringBuffer.append(" Adding Waypoint: ")
        stringBuffer.append(advancedRTSGameLayer.getName())
        if (advancedRTSGameLayer.getParentLayer() != null) {
            stringBuffer.append(" With Parent: ")
            stringBuffer.append(advancedRTSGameLayer.getParentLayer().getName())
        }
        this.logUtil.putF(stringBuffer.toString(), this, "selected: onWaypointEvent")
    }

    override def addWaypointFromBuildingList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, advancedRTSGameLayer : PathFindingLayerInterface, list : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" Waypoints: ")
        stringBuffer.append(this.stringUtil.toString(list))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: onWaypointEvent")
    }

    override def insertWaypoint(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, index : Int, rtsLayer : CollidableDestroyableDamageableLayer, waypointName : String) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(waypointName)
        stringBuffer.append(" Insert: ")
        stringBuffer.append(rtsLayer.getName())
        stringBuffer.append(" for Waypoint: ")
        this.logUtil.putF(stringBuffer.toString(), this, "selected: insertWaypoint")
    }

    override def insertWaypointList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, index : Int, rtsLayer : CollidableDestroyableDamageableLayer, waypointName : String, list : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(waypointName)
        stringBuffer.append(" Insert: ")
        stringBuffer.append(rtsLayer.getName())
        stringBuffer.append(" Waypoints: ")
        stringBuffer.append(this.stringUtil.toString(list))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: insertWaypoint")
    }

    override def setRandomGeographicMapCellHistoryList(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, pathsList : BasicArrayList) : Unit = {
        val size : Int = pathsList.size()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(CommonLabels.getInstance().START)
        stringBuffer.appendint(size)
        stringBuffer.append(" -> ")
        stringBuffer.append(this.stringUtil.toString(pathsList))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: setRandomGeographicMapCellHistory")
    }

    override def moveAwayFromBuilding(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" Trying to move away from building").toString(), this, "selected: moveAwayFromBuilding")
    }

    override def needToMove(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, unitWaypointBehavior : WaypointBehaviorBase) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(unitWaypointBehavior.getMovementLogicAsString()).toString(), this, "needToMove")
    }

    override def setRandomGeographicMapCellHistory(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" pathsList is null").toString(), this, "setRandomGeographicMapCellHistory")
    }

    override def setCurrentPathGeographicMapCellPosition(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, existingCurrentPathGeographicMapCellPosition : GeographicMapCellPosition, currentPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        if (existingCurrentPathGeographicMapCellPosition == null) {
            this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" currentPathGeographicMapCellPosition: ").append(this.stringUtil.toString(currentPathGeographicMapCellPosition)).toString(), this, "setCurrentPathGeographicMapCellPosition")
        }
    }

    override def setNextUnvisitedPathGeographicMapCellPosition(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, existingNextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition, nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        if (existingNextUnvisitedPathGeographicMapCellPosition ne nextUnvisitedPathGeographicMapCellPosition) {
            this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" nextUnvisitedPathGeographicMapCellPosition: ").append(this.stringUtil.toString(nextUnvisitedPathGeographicMapCellPosition)).toString(), this, "setNextUnvisitedPathGeographicMapCellPosition")
        }
    }

}

object WaypointSelectedLogHelper {
    private val instanceC : WaypointSelectedLogHelper = new WaypointSelectedLogHelper()

    /**      * @return the instance      */
    def getInstance() : WaypointSelectedLogHelper = {
        return WaypointSelectedLogHelper.instanceC
    }

}


