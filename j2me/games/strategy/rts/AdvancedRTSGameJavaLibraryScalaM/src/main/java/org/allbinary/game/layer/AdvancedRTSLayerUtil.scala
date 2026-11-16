/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.layer.waypoint.WorkWaypoint
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BaseRaceTrackGeographicMap
import _root_.org.allbinary.util.ABHashtable

class AdvancedRTSLayerUtil {
    import _root_.org.allbinary.game.layer.AdvancedRTSLayerUtil.{*}

    final def createFakeRTSLayerHashtable(baseRaceTrackGeographicMap : BaseRaceTrackGeographicMap) : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = RTSLayerUtil.getInstance().createFakeRTSLayerHashtable(baseRaceTrackGeographicMap)
        hashtable.put(WorkWaypoint.ID, SmallIntegerSingletonFactory.getInstance().getAt(50))
        return hashtable
    }

}

object AdvancedRTSLayerUtil {
    private val instance : AdvancedRTSLayerUtil = new AdvancedRTSLayerUtil()

    def getInstance() : AdvancedRTSLayerUtil = {
        return AdvancedRTSLayerUtil.instance
    }

}


