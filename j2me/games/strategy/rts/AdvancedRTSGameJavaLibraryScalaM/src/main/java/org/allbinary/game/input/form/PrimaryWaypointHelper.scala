/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.waypoint.WaypointLayer

/**  *  * @author user  */
class PrimaryWaypointHelper private() {
    import _root_.org.allbinary.game.input.form.PrimaryWaypointHelper.{*}

    private var waypointLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    /**      * @return the waypointLayer      */
    def getWaypointLayer() : PathFindingLayerInterface = {
        return this.waypointLayer
    }

    /**      * @param waypointLayer the waypointLayer to set      */
    def setWaypointLayer(waypointLayer : WaypointLayer) : Unit = {
        this.waypointLayer = waypointLayer
    }

}

object PrimaryWaypointHelper {
    private val instance : PrimaryWaypointHelper = new PrimaryWaypointHelper()

    /**      * @return the instance      */
    def getInstance() : PrimaryWaypointHelper = {
        return PrimaryWaypointHelper.instance
    }

}


