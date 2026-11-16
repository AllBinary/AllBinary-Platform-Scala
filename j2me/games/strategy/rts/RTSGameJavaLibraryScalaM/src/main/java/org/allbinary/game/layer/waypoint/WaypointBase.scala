/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.audio.NoSound
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.pathfinding.MultipassState
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class WaypointBase(param_sound : Sound) extends EventListenerInterface {
    import _root_.org.allbinary.game.layer.waypoint.WaypointBase.{*}

    private val connectedWaypointList : BasicArrayList = new BasicArrayListD()

    private var sound : Sound = null

    var allBinaryGameLayerManagerP : AllBinaryGameLayerManager = AllBinaryGameLayerManager.getNullInstance()

    //Constructor
    {
        val sound : Sound = param_sound
        this.sound = sound
    }

    /**      * @return the sound      */
    def getSound() : Sound = {
        return this.sound
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        this.allBinaryGameLayerManagerP = allBinaryGameLayerManager
    }

    /**      * @return the list      */
    def getConnectedWaypointList() : BasicArrayList = {
        return this.connectedWaypointList
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def getPathFindingInfo(geographicMapCellPosition : GeographicMapCellPosition) : PathFindingInfo = {
        throw new RuntimeException()
    }

    def getPathsList(geographicMapCellPosition : GeographicMapCellPosition, pathFindingInfo : PathFindingInfo, multipassState : MultipassState) : BasicArrayList = {
        throw new RuntimeException()
    }

    def getPathsListRunnable(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        throw new RuntimeException()
    }

    def getPathsListFromCacheOnly(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        throw new RuntimeException()
    }

    def visit(unitLayer : PathFindingLayerInterface) : Unit = {
    }

    def reset() : Unit = {
    }

    def getType() : Int = {
        return 0
    }

}

object WaypointBase {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    var NULL_WAYPOINT_BASE : WaypointBase = new WaypointBase(NoSound.getInstance())

}


