/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.geological.resources.GeologicalGeographicMapCellPosition
import _root_.org.allbinary.game.layer.geological.resources.GeologicalResource
import _root_.org.allbinary.game.layer.unit.UnitLayer
import _root_.org.allbinary.game.layer.unit.UnitWaypointBehavior
import _root_.org.allbinary.media.audio.WorkSound
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

/**  *  * @author user  */
class WorkWaypoint(param_ownerLayer : PathFindingLayerInterface) extends Waypoint(param_ownerLayer, WorkSound.getInstance()) {
    import _root_.org.allbinary.game.layer.waypoint.WorkWaypoint.{ID as _, *}
    def ID : Integer = _root_.org.allbinary.game.layer.waypoint.WorkWaypoint.ID

    //Constructor
    {
        val ownerLayer : PathFindingLayerInterface = param_ownerLayer
    }

    def visit(unitLayer : UnitLayer) : Unit = {
        //Only visit waypoint if in same group
        if (unitLayer.getGroupInterface()(0) ne this.ownerLayer.getGroupInterface()(0)) {
            return
        }
        val size : Int = this.getConnectedWaypointList().size()
        if (size > 0) {
            //Remove Resources
            val occupyList : BasicArrayList = this.ownerLayer.getGeographicMapCellPositionArea().getOccupyingGeographicMapCellPositionList()
            var outOfResources : Boolean = true
            var geologicalGeographicMapCellPosition : GeologicalGeographicMapCellPosition = null
            var geologicalResource : GeologicalResource = null

            {
                var index : Int = occupyList.size()
                while ({ index -= 1; index } >= 0) {
                    geologicalGeographicMapCellPosition = occupyList.get(index).asInstanceOf[GeologicalGeographicMapCellPosition]
                    geologicalResource = geologicalGeographicMapCellPosition.getGeologicalResource()
                    if (geologicalResource.getTotal() >= 1) {
                        //this.logUtil.putF(unitLayer.getName() + " loaded resource from " + geologicalGeographicMapCellPosition.toString(), this, "visit");
                        outOfResources = false
                        val maxResourceLoad : Int = unitLayer.getMaxResourceLoad().toInt
                        geologicalResource.remove(maxResourceLoad)
                        unitLayer.setLoad(maxResourceLoad)
                    }
                }
            }
            //Only update if it is shown
            val waypointInfoHudPaintable : WaypointInfoHudPaintable = this.ownerLayer.getHudPaintable().asInstanceOf[WaypointInfoHudPaintable]
            if (this.ownerLayer eq waypointInfoHudPaintable.getRtsLayer()) {
                waypointInfoHudPaintable.updateSelectionInfo()
            }
            //Stop if our of resources
            if (!outOfResources) {
                //this.logUtil.putF("Returning: " + unitLayer.getName(), this, "visit");
                val unitWaypointBehavior : UnitWaypointBehavior = unitLayer.getWaypointBehavior().asInstanceOf[UnitWaypointBehavior]
                //Remove dead waypoints
                var rtsLayer : RTSLayer = null

                {
                    scala.util.boundary { (break_N78185 : scala.util.boundary.Label[Unit]) ?=>
                        while (this.getConnectedWaypointList().size() > 0) {
                            rtsLayer = this.getConnectedWaypointList().get(0).asInstanceOf[RTSLayer]
                            if (rtsLayer.isDestroyed()) {
                                this.getConnectedWaypointList().remove(rtsLayer)
                            } else {
                                unitWaypointBehavior.insertWaypoint(0, rtsLayer)
                                scala.util.boundary.break()(using break_N78185)
                            }
                        }
                    }
                }
            }
        }
    }

    override def getType() : Int = {
        return 2
    }

}

object WorkWaypoint {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    val ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(25)

}


