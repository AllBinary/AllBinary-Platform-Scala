/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.combat.destroy.DestroyableInterface
import _root_.org.allbinary.game.identification.GroupInterfaceCompositeInterface
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.layer.waypoint.WaypointLayerInterface
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
trait PathFindingLayerInterface extends WaypointLayerInterface with GameKeyEventSourceInterface with GroupInterfaceCompositeInterface with DestroyableInterface {

    def getEndGeographicMapCellPositionList() : BasicArrayList

    def shouldHandleStartSameAsEnd() : Boolean

    def getGeographicMapCellPositionArea() : GeographicMapCellPositionAreaBase

    def getHudPaintable() : SelectionHudPaintable

    def handleCost(ownerLayer : PathFindingLayerInterface) : Unit

    def getParentLayer() : PathFindingLayerInterface

    def getRTSLayer2LogHelper() : RTSLayer2LogHelper

    def setTarget(targetGameLayer : PathFindingLayerInterface) : Unit

}


