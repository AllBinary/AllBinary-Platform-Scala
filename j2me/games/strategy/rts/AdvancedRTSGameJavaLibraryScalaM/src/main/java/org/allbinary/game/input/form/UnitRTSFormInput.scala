/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.game.layer.AdvancedPlayerOwnedRTSLayers
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.AdvancedRTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.capital.Capital
import _root_.org.allbinary.game.layer.unit.UnitLayer
import _root_.org.allbinary.game.layer.waypoint.WorkWaypoint
import _root_.org.allbinary.media.audio.BuildingSound
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEvent
import _root_.org.allbinary.game.layer.hud.event.GameNotificationEventHandler
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.ErrorSound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface

/**  *   * @author user  */
class UnitRTSFormInput(param_groupInterface : Array[Group]) extends RTSFormInput(param_groupInterface) {
    import _root_.org.allbinary.game.input.form.UnitRTSFormInput.{DECAL_ID as _, *}
    def DECAL_ID : Integer = _root_.org.allbinary.game.input.form.UnitRTSFormInput.DECAL_ID

    var noMoneyGameNotificationEvent : GameNotificationEvent = null

    var newUnitGameNotificationEvent : GameNotificationEvent = null

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        this.noMoneyGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NO_MONEY, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        this.newUnitGameNotificationEvent = new GameNotificationEvent(this, RTSGameStrings.getInstance().NEW_UNIT, smallIntegerSingletonFactory.getAt(2), basicColorFactory.WHITE, BooleanFactory.getInstance().FALSE)
        //Sets the default working load
        this.getHashtable().put(WorkWaypoint.ID, smallIntegerSingletonFactory.getAt(50))
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.noMoneyGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
        this.newUnitGameNotificationEvent.setBasicColorP(geographicMapInterface.getForegroundBasicColor())
    }

    override def processGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, itemIndex : Int) : Unit = {
        super.process(layerManager)
        val associatedRtsLayer2 : RTSLayer = associatedRtsLayer.asInstanceOf[RTSLayer]
        val geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = associatedRtsLayer2.geographicMapCellPositionAreaBase
        val geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionArea.getNextSurroundingGeographicMapCellPosition()
        this.getHashtable().put(Layer.ID, associatedRtsLayer)
        this.getHashtable().put(UnitRTSFormInput.DECAL_ID, (rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]).getDecalBasicColor())
        if (this.newUnconstructedRTSLayerInterfaceArray(itemIndex) eq CollidableDestroyableDamageableLayer.getNullInstance()) {
            this.newUnconstructedRTSLayerInterfaceArray(itemIndex) = this.getInstance(layerManager, item, geographicMapCellPosition)
        } else {
            //update area and position            
            var cellPoint : GPoint = geographicMapCellPosition.getPoint()
            val rtsLayer : RTSLayer = this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer]
            rtsLayer.setPosition(cellPoint.getX(), cellPoint.getY(), rtsLayer.getZP())
            val geographicMapCompositeInterface : GeographicMapCompositeInterface = rtsLayer.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
            val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
            rtsLayer.geographicMapCellPositionAreaBase.update(geographicMapInterface)
        }
        // Move unit to center
        val cellPoint : GPoint = geographicMapCellPosition.getMidPoint()
        val rtsLayer : RTSLayer = this.newUnconstructedRTSLayerInterfaceArray(itemIndex).asInstanceOf[RTSLayer]
        rtsLayer.setPosition(cellPoint.getX() - rtsLayer.getHalfWidth(), cellPoint.getY() - rtsLayer.getHalfHeight(), rtsLayer.getZP())
        //this.newUnconstructedRTSLayerInterface.geographicMapCellPositionArea.update();
        this.attemptBuild(associatedRtsLayer2, rtsPlayerLayerInterface, layerManager, rtsLayer.asInstanceOf[RTSLayer], itemIndex)
    }

    private def attemptBuild(associatedRtsLayer : RTSLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, layerInterface : RTSLayer, itemIndex : Int) : Unit = {
        val cost : Int = layerInterface.getCost()
        val capital : Capital = rtsPlayerLayerInterface.getCapital()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Trying to Build: ")
        stringBuffer.append(layerInterface.getName())
        stringBuffer.append(" for: $")
        stringBuffer.appendint(cost)
        stringBuffer.append(" with ")
        stringBuffer.appendint(capital.getTotalMoney())
        this.logUtil.putF(stringBuffer.toString(), this, "attemptBuild")
        if (cost <= capital.getTotalMoney()) {
            layerInterface.construct(rtsPlayerLayerInterface)
            this.newUnconstructedRTSLayerInterfaceArray(itemIndex) = CollidableDestroyableDamageableLayer.getNullInstance()
            rtsPlayerLayerInterface.add(BuildingSound.getInstance())
            capital.removeMoney(cost)
            // Add Building waypoint to new unit
            AssignWaypointsUtil.getInstance().set(layerInterface.asInstanceOf[UnitLayer], associatedRtsLayer.asInstanceOf[AdvancedRTSGameLayer])
            // layerManager.append(layerInterface);
            layerManager.appendAt(layerInterface, PlayersSingletonFactory.total)
            val advancedRTSPlayerLayerInterface : AdvancedRTSPlayerLayerInterface = rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]
            val advancedPlayerOwnedRTSLayers : AdvancedPlayerOwnedRTSLayers = advancedRTSPlayerLayerInterface.getAdvancedPlayerOwnedRTSLayers()
            advancedPlayerOwnedRTSLayers.addUnit(layerInterface)
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.newUnitGameNotificationEvent)
            }
        } else {
            //layerInterface.setDestroyed(true);
            rtsPlayerLayerInterface.add(ErrorSound.getInstance())
            if (!rtsPlayerLayerInterface.implmentsArtificialIntelligenceCompositeInterface()) {
                GameNotificationEventHandler.getInstance().fireEvent(this.noMoneyGameNotificationEvent)
            }
        }
    }

}

object UnitRTSFormInput {
    val DECAL_ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(23)

}


