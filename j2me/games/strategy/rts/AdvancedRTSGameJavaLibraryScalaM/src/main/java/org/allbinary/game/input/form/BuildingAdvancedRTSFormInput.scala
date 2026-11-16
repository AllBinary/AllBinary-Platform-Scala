/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.layer.AdvancedPlayerOwnedRTSLayers
import _root_.org.allbinary.game.layer.AdvancedRTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.building.event.BuildingEventHandler
import _root_.org.allbinary.game.layer.building.event.LocalPlayerBuildingEventHandler
import _root_.org.allbinary.game.layer.waypoint.WaypointCellPositionHistory
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory

/**  *  * @author user  */
class BuildingAdvancedRTSFormInput(param_groupInterface : Array[Group], param_isUnitProducer : Boolean) extends BuildingRTSFormInput(param_groupInterface, param_isUnitProducer) {

    var atLeastOneHouseGameNotificationEvent : GameNotificationEvent = null

    private val BUILD_BUILDING_RTS_LAYER_EVENT : RTSLayerEvent = new RTSLayerEvent(NullPathFindingLayer.NULL_PATH_FINDING_LAYER)

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val isUnitProducer : Boolean = param_isUnitProducer
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.atLeastOneHouseGameNotificationEvent = new GameNotificationEvent(this, "Build At Least One House First", SmallIntegerSingletonFactory.getInstance().getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.atLeastOneHouseGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    override def isPositionBlocked() : Boolean = {
        if (DropCellPositionHistory.getInstance().isCellPositionWithDrop(this.getSelectedGeographicCellPosition()) || WaypointCellPositionHistory.getInstance().isCellPositionWithDrop(this.getSelectedGeographicCellPosition())) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def isBuildAttemptValid(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerInterface : RTSLayer) : Boolean = {
        var advancedRTSPlayerLayerInterface : AdvancedRTSPlayerLayerInterface = rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]
        var advancedPlayerOwnedRTSLayers : AdvancedPlayerOwnedRTSLayers = advancedRTSPlayerLayerInterface.getAdvancedPlayerOwnedRTSLayers()
        var totalHouses : Int = advancedPlayerOwnedRTSLayers.getHouseList().size()
        //PreLogUtil.put("Total Houses: " + totalHouses + " " + (layerInterface.getType() != HouseBuildingLayer.getStaticType()), this, "isBuildAttemptValid");
        if ((totalHouses < 1) && (layerInterface.getName().indexOf(" House") < 0)) {
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.atLeastOneHouseGameNotificationEvent)
            }
            return false
        }
        return super.isBuildAttemptValid(rtsPlayerLayerInterface, layerInterface)
    }

    override def add(rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, layerInterface : RTSLayer) : Unit = {
        //layerInterface
        this.BUILD_BUILDING_RTS_LAYER_EVENT.setRtsLayer(layerInterface)
        BuildingEventHandler.getInstance().fireEvent(this.BUILD_BUILDING_RTS_LAYER_EVENT)
        if ((rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]).isLocalPlayer()) {
            LocalPlayerBuildingEventHandler.getInstance().fireEvent(this.BUILD_BUILDING_RTS_LAYER_EVENT)
        }
        super.add(rtsPlayerLayerInterface, layerManager, layerInterface)
    }

}


