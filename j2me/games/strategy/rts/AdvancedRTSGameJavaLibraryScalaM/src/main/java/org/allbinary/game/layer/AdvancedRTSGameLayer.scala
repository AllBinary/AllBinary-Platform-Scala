/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.NullIndexedAnimationFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.transition.shake.ShakeAnimationListener
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.GameTypeFactory
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEvent
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventHandler
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventListenerInterface
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.identification.GroupFactory
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.layer.building.event.BuildingEventHandler
import _root_.org.allbinary.game.layer.waypoint.Waypoint2LogHelper
import _root_.org.allbinary.game.layer.waypoint.Waypoint2SelectedLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointBase
import _root_.org.allbinary.game.layer.waypoint.WaypointLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointRunnableLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointRunnableSelectedLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointSelectedLogHelper
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.game.tick.NullTickable
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.math.FrameUtil
import _root_.org.allbinary.media.AllBinaryVibrationME
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapDirectionUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.view.ViewPositionBase

/**  *  * @author user  */
class AdvancedRTSGameLayer(param_remoteInfo : RemoteInfo, param_parentLayer : PathFindingLayerInterface, param_advancedRTSProperties : AdvancedRTSProperties, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_healthInterface : Health, param_rtsFormInput : RTSFormInput, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_x : Int, param_y : Int, param_viewPosition : ViewPositionBase) extends RTSLayer(param_remoteInfo, param_groupInterface, param_rootName, param_name, param_healthInterface, param_rtsFormInput, param_animationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface, param_rectangle, param_x, param_y, param_viewPosition) with DestroyedEventListenerInterface {
    import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer.{*}

    var shakeListener : ShakeAnimationListener = null

    var vibration : AllBinaryVibrationME = null

    var duration : Int = 0

    private var parentLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    //WaypointBehaviorBase
    var waypointBehaviorBase : TickableInterface = NullTickable.getInstance()

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
        val parentLayer : PathFindingLayerInterface = param_parentLayer
        val advancedRTSProperties : AdvancedRTSProperties = param_advancedRTSProperties
        val groupInterface : Array[Group] = param_groupInterface
        val rootName : String = param_rootName
        val name : String = param_name
        val healthInterface : Health = param_healthInterface
        val rtsFormInput : RTSFormInput = param_rtsFormInput
        val animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_animationInterfaceFactoryInterface
        val emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_emptyAnimationInterfaceFactoryInterface
        val baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_baseAnimationInterfaceFactoryInterface
        val buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_buildAnimationInterfaceFactoryInterface
        val verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_verticleBuildAnimationInterfaceFactoryInterface
        val proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface = param_proceduralAnimationInterfaceFactoryInterface
        val rectangle : Rectangle = param_rectangle
        val x : Int = param_x
        val y : Int = param_y
        val viewPosition : ViewPositionBase = param_viewPosition
        this.setVisible(false)
        this.setWaypointBehavior(new WaypointBehaviorBase())
        this.shakeListener = advancedRTSProperties.shakeListener
        this.vibration = advancedRTSProperties.vibration
        this.duration = advancedRTSProperties.duration
        this.setParentLayer(parentLayer)
    }

    //    }
    override def updateWaypointBehavior(geographicMapInterface : BasicGeographicMap) : Unit = {
        super.updateWaypointBehavior(geographicMapInterface)
        this.getWaypointBehavior().getWaypoint().setAllBinaryGameLayerManager(this.allBinaryGameLayerManagerP)
    }

    def initVisibility(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        var advancedRTSPlayerLayerInterface : AdvancedRTSPlayerLayerInterface = rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]
        if (advancedRTSPlayerLayerInterface.isLocalPlayer() || (advancedRTSPlayerLayerInterface.getGameType() eq GameTypeFactory.getInstance().BOT)) {
            this.setVisible(true)
        } else {
            this.setVisible(false)
        }
    }

    override def construct(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        super.construct(rtsPlayerLayerInterface)
        this.initVisibility(rtsPlayerLayerInterface)
        BuildingEventHandler.getInstance().addListenerInterface(this.getWaypointBehavior().getWaypoint())
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            BuildingEventHandler.getInstance().removeListener(this.getWaypointBehavior().getWaypoint())
            BuildingEventHandler.getInstance().removeListener(this)
            DestroyedEventHandler.getInstance().addListener(this)
            //Destroy owned waypoints as well
            RTSLayerUtil.getInstance().destroyAndClear(this.getWaypointBehavior().getOwnedWaypointList())
        }
    }

    /**      * @return the parentLayer      */
    override def getParentLayer() : PathFindingLayerInterface = {
        return this.parentLayer
    }

    def setParentLayer(parentLayer : PathFindingLayerInterface) : Unit = {
        this.parentLayer = parentLayer
    }

    override def getWaypointBehavior() : WaypointBehaviorBase = {
        return this.waypointBehaviorBase.asInstanceOf[WaypointBehaviorBase]
    }

    def setWaypointBehavior(unitWaypointHelper : WaypointBehaviorBase) : Unit = {
        this.waypointBehaviorBase = unitWaypointHelper
    }

    override def getWaypointLogHelper() : WaypointLogHelper = {
        return this.waypointLogHelperP
    }

    override def getWaypoint2LogHelper() : Waypoint2LogHelper = {
        return this.waypoint2LogHelperP
    }

    override def getWaypointRunnableLogHelper() : WaypointRunnableLogHelper = {
        return this.waypointRunnableLogHelperP
    }

    override def shouldAddWaypointFromBuilding() : Boolean = {
        if (this.parentLayer ne NullPathFindingLayer.NULL_PATH_FINDING_LAYER) {
            val parentAdvancedRTSGameLayer : AdvancedRTSGameLayer = this.parentLayer.asInstanceOf[AdvancedRTSGameLayer]
            if (parentAdvancedRTSGameLayer.getType() != 1) {
                return true
            }
        }
        return false
    }

    override def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        if (this.getType() != 1) {
            return true
        }
        return false
    }

    override def buildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Boolean = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.getCurrentGeographicMapCellPosition()
        //this.currentPathGeographicMapCellPosition
        val buildingDirection : Direction = GeographicMapDirectionUtil.getInstance().getDirectionFromCellPositionToAdjacentCellPosition(geographicMapCellPosition, cellPosition)
        val angleInfo : AngleInfo = this.getRotationAnimationInterface().getAngleInfoP()
        val angle : Int = FrameUtil.getInstance().adjustAngleToFrameAngle(angleInfo.getAngle() + 90)
        val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()
        if (buildingDirection eq DirectionFactory.getInstance().UP) {
            this.rtsLayer2LogHelper.buildingAbove(this)
            //if(Math.abs(angle - Angle.RIGHT.getValue()) > Math.abs(angle - Angle.LEFT.getValue()))
            if ((angle > 180) && (angle < 360)) {
                this.rtsLayer2LogHelper.buildingChaseLeft(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.LEFT))
                //if(angle < 225)
                if (angle <= 190) {
                    return true
                }
            } else {
                this.rtsLayer2LogHelper.buildingChaseRight(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.RIGHT))
                //if(angle > 135)
                if (angle >= 170) {
                    return true
                }
            }
        } else if (buildingDirection eq DirectionFactory.getInstance().DOWN) {
            this.rtsLayer2LogHelper.buildingDown(this)
            //Probably going left
            if ((angle > 180) && (angle < 360)) {
                this.rtsLayer2LogHelper.buildingChaseLeft(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.RIGHT))
                if (angle > 315) {
                    return true
                }
            } else {
                this.rtsLayer2LogHelper.buildingChaseRight(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.LEFT))
                if (angle < 45) {
                    return true
                }
            }
        } else if (buildingDirection eq DirectionFactory.getInstance().LEFT) {
            this.rtsLayer2LogHelper.buildingLeft()
            //Probably going down
            if ((angle > 90) && (angle < 270)) {
                this.rtsLayer2LogHelper.buildingChaseDown(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.LEFT))
                if (angle < 135) {
                    return true
                }
            } else {
                this.rtsLayer2LogHelper.buildingChaseUp(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.RIGHT))
                if (angle > 45) {
                    return true
                }
            }
        } else if (buildingDirection eq DirectionFactory.getInstance().RIGHT) {
            this.rtsLayer2LogHelper.buildingRight()
            //Probably going down
            if ((angle > 90) && (angle < 270)) {
                this.rtsLayer2LogHelper.buildingChaseDown(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.RIGHT))
                if (angle > 225) {
                    return true
                }
            } else {
                this.rtsLayer2LogHelper.buildingChaseUp(this, angle)
                this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.LEFT))
                if ((angle < 315) && (angle > 180)) {
                    return true
                }
            }
        } else {
            return true
        }
        return false
    }

    override def getSurroundingGeographicMapCellPositionList() : BasicArrayList = {
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        this.geographicMapCellPositionAreaBase.update(geographicMapInterface)
        return this.geographicMapCellPositionAreaBase.getSurroundingGeographicMapCellPositionList()
    }

    override def setSelected(selected : Boolean) : Unit = {
        super.setSelected(selected)
        if (this.debug) {
            if (selected) {
                this.waypointLogHelperP = WaypointSelectedLogHelper.getInstance()
                this.waypoint2LogHelperP = Waypoint2SelectedLogHelper.getInstance()
                this.waypointRunnableLogHelperP = WaypointRunnableSelectedLogHelper.getInstance()
            } else {
                this.waypointLogHelperP = WaypointLogHelper.getInstance()
                this.waypoint2LogHelperP = Waypoint2LogHelper.getInstance()
                this.waypointRunnableLogHelperP = WaypointRunnableLogHelper.getInstance()
            }
        }
    }

    override def onDestroyed(destroyedEvent : DestroyedEvent) : Unit = {
        try {
            var layerInterface : AllBinaryLayer = destroyedEvent.getLayerInterface()
            if (layerInterface eq this) {
                DestroyedEventHandler.getInstance().removeListener(this)
                var waypoint : WaypointBase = this.getWaypointBehavior().getWaypoint().asInstanceOf[WaypointBase]
                waypoint.reset()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onDestroyed", e)
            }
        }
    }

}

object AdvancedRTSGameLayer {
    //used to simulate cost
    def createSimulated() : AdvancedRTSGameLayer = {
        val nullAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullAnimationFactory.getFactoryInstance()
        val nullIndexedAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullIndexedAnimationFactory.getFactoryInstance()
        return new AdvancedRTSGameLayer(RemoteInfo.REMOTE_INFO, NullPathFindingLayer.NULL_PATH_FINDING_LAYER, AdvancedRTSProperties.createPropertiesSimulated(), GroupFactory.getInstance().NULL_GROUP_ARRAY, StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING, Health.NULL_HEALTH, NullRTSFormInputFactory.getInstance(), nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, NullIndexedAnimationFactory.getFactoryInstance(), RectangleFactory.SINGLETON, 0, 0, new TileLayerPositionIntoViewPosition())
    }

}


