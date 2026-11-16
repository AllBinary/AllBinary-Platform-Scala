/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.unit.UnitLayer
import _root_.org.allbinary.game.layer.unit.UnitWaypointBehavior
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil

class AssignWaypointsUtil {
    import _root_.org.allbinary.game.input.form.AssignWaypointsUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val WAYPOINT_EVENT : RTSLayerEvent = new RTSLayerEvent(NullPathFindingLayer.NULL_PATH_FINDING_LAYER)

    def set(unitLayer : UnitLayer, ownerAdvancedRTSGameLayer : AdvancedRTSGameLayer) : Unit = {
        try {
            var list : BasicArrayList = ownerAdvancedRTSGameLayer.getWaypointBehavior().getOwnedWaypointList()
            var unitWaypointBehavior : UnitWaypointBehavior = unitLayer.getWaypointBehavior().asInstanceOf[UnitWaypointBehavior]

            {
                var index : Int = list.size() - 1
                while (index >= 0) {
                    var waypointLayer : RTSLayer = list.get(index).asInstanceOf[RTSLayer]
                    this.WAYPOINT_EVENT.setRtsLayer(waypointLayer)
                    unitWaypointBehavior.onWaypointEvent(this.WAYPOINT_EVENT)
                    index -= 1
                }
            }
            val waypointLayer : PathFindingLayerInterface = PrimaryWaypointHelper.getInstance().getWaypointLayer()
            if (waypointLayer ne NullPathFindingLayer.NULL_PATH_FINDING_LAYER) {
                this.WAYPOINT_EVENT.setRtsLayer(waypointLayer)
                unitWaypointBehavior.onWaypointEvent(this.WAYPOINT_EVENT)
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "set", e)
            }
        }
    }

}

object AssignWaypointsUtil {
    private val instance : AssignWaypointsUtil = new AssignWaypointsUtil()

    def getInstance() : AssignWaypointsUtil = {
        return AssignWaypointsUtil.instance
    }

}


