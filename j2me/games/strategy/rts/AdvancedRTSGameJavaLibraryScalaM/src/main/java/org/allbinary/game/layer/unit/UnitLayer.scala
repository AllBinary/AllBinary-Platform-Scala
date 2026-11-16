/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.ag.weapon.media.audio.ExplosionBasicSound
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.NullIndexedAnimationFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.animation.caption.CaptionAnimationHelper
import _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase
import _root_.org.allbinary.animation.vector.AdjustedCircleAnimation
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.game.combat.damage.DamageFloaters
import _root_.org.allbinary.game.combat.damage.PtsDamageFloaters
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.health.HealthBar
import _root_.org.allbinary.game.health.HealthBarTwodAnimation
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.identification.GroupCommonFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.event.GameKeyEventUtil
import _root_.org.allbinary.game.input.form.VisibleCellPositionsSingleton
import _root_.org.allbinary.game.input.form.WaypointRTSFormInput
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.AdvancedRTSProperties
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.LayerCaptionResources
import _root_.org.allbinary.game.layer.LinePathRelativeAnimation
import _root_.org.allbinary.game.layer.PathAnimation
import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.game.layer.RTSLayer2LogHelper
import _root_.org.allbinary.game.layer.RTSLayer2SelectedLogHelper
import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.game.layer.RTSLayerHudPaintable
import _root_.org.allbinary.game.layer.RTSLayerLogHelper
import _root_.org.allbinary.game.layer.RTSLayerSelectedLogHelper
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.SelectionHudPaintable
import _root_.org.allbinary.game.layer.SensorActionFactory
import _root_.org.allbinary.game.layer.SteeringVisitor
import _root_.org.allbinary.game.layer.TiledLayerUtil
import _root_.org.allbinary.game.layer.VehicleFrictionProperties
import _root_.org.allbinary.game.layer.VehicleProperties
import _root_.org.allbinary.game.layer.WaypointBehaviorBase
import _root_.org.allbinary.game.layer.building.BuildingLayer
import _root_.org.allbinary.game.layer.building.event.BuildingEventHandler
import _root_.org.allbinary.game.layer.building.event.BuildingEventListenerInterface
import _root_.org.allbinary.game.layer.capital.event.CapitalEvent
import _root_.org.allbinary.game.layer.capital.event.CapitalEventHandlerFactory
import _root_.org.allbinary.game.layer.geographic.map.LayerPartialCellPositionsUtil
import _root_.org.allbinary.game.layer.special.SpecialDownGameInputProcessor
import _root_.org.allbinary.game.layer.special.SpecialFireGameInputProcessor
import _root_.org.allbinary.game.layer.special.SpecialLeftGameInputProcessor
import _root_.org.allbinary.game.layer.special.SpecialRightGameInputProcessor
import _root_.org.allbinary.game.layer.special.SpecialUpGameInputProcessor
import _root_.org.allbinary.game.layer.waypoint.MultipassNoCacheWaypoint
import _root_.org.allbinary.game.layer.waypoint.NoCacheWaypoint
import _root_.org.allbinary.game.layer.waypoint.WaypointBase
import _root_.org.allbinary.game.layer.waypoint.event.WaypointEventHandlerFactory
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.game.part.weapon.BasicWeaponPart
import _root_.org.allbinary.game.part.weapon.SalvoInterface
import _root_.org.allbinary.game.physics.velocity.VelocityProperties
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.game.tracking.TrackingEventListenerInterface
import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.Layer
import _root_.org.allbinary.layer.LayerInterfaceFactoryInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.math.FrameUtil
import _root_.org.allbinary.math.LayerDistanceUtil
import _root_.org.allbinary.math.NamedAngle
import _root_.org.allbinary.media.audio.AttackSound
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMap
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListS
import _root_.org.allbinary.view.ViewPositionBase

/**  *   * @author user  */
class UnitLayer(param_remoteInfo : RemoteInfo, param_parentLayer : PathFindingLayerInterface, param_advancedRTSProperties : AdvancedRTSProperties, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_vehicleProperties : VehicleProperties, param_healthInterface : Health, param_maxResourceLoad : Integer, param_moveSoundInterface : Sound, param_waypointLayerInterfaceFactoryInterface : LayerInterfaceFactoryInterface, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_decalAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_resourceAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_direction : Direction, param_x : Int, param_y : Int, param_z : Int, param_viewPosition : ViewPositionBase) extends AdvancedRTSGameLayer(param_remoteInfo, param_parentLayer, param_advancedRTSProperties, param_groupInterface, param_rootName, param_name, param_healthInterface, new WaypointRTSFormInput(param_groupInterface, true), param_animationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface, param_rectangle, param_x, param_y, param_viewPosition) with BuildingEventListenerInterface with TrackingEventListenerInterface {
    import _root_.org.allbinary.game.layer.unit.UnitLayer.{*}

    //private final short ANGLE_INCREMENT = 10;
    private val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    private val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()

    private val layerPartialCellPositionsUtil : LayerPartialCellPositionsUtil = LayerPartialCellPositionsUtil.getInstance()

    private val layerDistanceUtil : LayerDistanceUtil = LayerDistanceUtil.getInstance()

    private val angleFactory : AngleFactory = AngleFactory.getInstance()

    private val cellPositionFactory : CellPositionFactory = CellPositionFactory.getInstance()

    //So set a dx dy that is still in
    private var maxResourceLoad : Short = 0

    private var vehicleProperties : VehicleProperties = null

    //private int repair;
    var accelerationBasicDecimal : BasicDecimal = new BasicDecimal(1600)

    var decelerationBasicDecimal : BasicDecimal = new BasicDecimal(-1000)

    private var trackingEvent : TrackingEvent = null

    private var damageFloaters : DamageFloaters = null

    private var damageFloatersPaintableInterface : Paintable = null

    private var healthBar : Paintable = null

    private var moveSoundInterface : Sound = null

    private var initResourceAnimation : RotationAnimation = null

    private var resourceAnimation : IndexedAnimation = NullIndexedAnimationFactory.getFactoryInstance().getInstance(0).asInstanceOf[IndexedAnimation]

    private var initPathAnimation : PathAnimation = null

    private var pathAnimation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    private val captionAnimationHelper : CaptionAnimationHelperBase = new CaptionAnimationHelper(FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance().get(LayerCaptionResources.getInstance().RESOURCE).getInstance(0), -23, -25, 6, 0)

    private var decalAnimation : RotationAnimation = null

    private var waypointLayerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = null

    private var resourceLoad : Int = 0

    private var weaponRange : Int = 0

    var rtsLogHelper : RTSLayerLogHelper = RTSLayerLogHelper.getInstance()

    //Same as parent Animation    
    var rotationAnimationInterfaceP : RotationAnimation = null

    private var movementAngle : NamedAngle = this.angleFactory.NOT_ANGLE

    private var steeringInsideGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private val sensorGeographicMapCellPositionList : BasicArrayList = new BasicArrayListD()

    private val CAPITAL_EVENT : CapitalEvent = new CapitalEvent(this)

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
        val parentLayer : PathFindingLayerInterface = param_parentLayer
        val advancedRTSProperties : AdvancedRTSProperties = param_advancedRTSProperties
        val groupInterface : Array[Group] = param_groupInterface
        val rootName : String = param_rootName
        val name : String = param_name
        val vehicleProperties : VehicleProperties = param_vehicleProperties
        val healthInterface : Health = param_healthInterface
        val maxResourceLoad : Integer = param_maxResourceLoad
        val moveSoundInterface : Sound = param_moveSoundInterface
        val waypointLayerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = param_waypointLayerInterfaceFactoryInterface
        val animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_animationInterfaceFactoryInterface
        val emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_emptyAnimationInterfaceFactoryInterface
        val baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_baseAnimationInterfaceFactoryInterface
        val buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_buildAnimationInterfaceFactoryInterface
        val verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_verticleBuildAnimationInterfaceFactoryInterface
        val decalAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_decalAnimationInterfaceFactoryInterface
        val resourceAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = param_resourceAnimationInterfaceFactoryInterface
        val proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface = param_proceduralAnimationInterfaceFactoryInterface
        val rectangle : Rectangle = param_rectangle
        val direction : Direction = param_direction
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
        val viewPosition : ViewPositionBase = param_viewPosition
        this.setCollidableInferface(new CollidableUnitBehavior(true))
        this.waypointLayerInterfaceFactoryInterface = waypointLayerInterfaceFactoryInterface
        this.maxResourceLoad = maxResourceLoad.shortValue()
        this.moveSoundInterface = moveSoundInterface
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().DAMAGE_FLOATERS)) {
            this.damageFloaters = new PtsDamageFloaters(this)
            this.damageFloatersPaintableInterface = this.damageFloaters
        } else {
            this.damageFloatersPaintableInterface = NullPaintable.getInstance()
            this.damageFloaters = new DamageFloaters()
        }
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().HEALTH_BARS)) {
            this.healthBar = new HealthBar(this, this.getHealthInterface(), new HealthBarTwodAnimation(this.asInstanceOf[AllBinaryLayer], BasicHudFactory.getInstance().BOTTOMLEFT), -1)
        } else {
            this.healthBar = NullPaintable.getInstance()
        }
        //this.logUtil.putF("Direction: " + direction, this, this.commonStrings.CONSTRUCTOR);
        this.decalAnimation = decalAnimationInterfaceFactoryInterface.getInstance(0).asInstanceOf[RotationAnimation]
        this.initResourceAnimation = resourceAnimationInterfaceFactoryInterface.getInstance(0).asInstanceOf[RotationAnimation]
        this.initResourceAnimation.setFrameByDirection(direction)
        this.decalAnimation.setFrameByDirection(direction)
        this.rotationAnimationInterfaceP = this.indexedButShouldBeRotationAnimationInterface.asInstanceOf[RotationAnimation]
        this.rotationAnimationInterfaceP.setFrameByDirection(direction)
        this.setMaxLevel(12)
        this.vehicleProperties = vehicleProperties
        //this.repair = UnitTechnologySingletonFactory.getInstance().getRepair();
        this.trackingEvent = new TrackingEvent(this)
        this.initPathAnimation = new PathAnimation(this, LinePathRelativeAnimation.getInstance())
    }

    /*     protected UnitLayer()         throws Exception     {         super();  this.setCollidableInferface(new CollidableUnitBehavior(this, true));          this.moveSoundInterface = null;                  this.vehicleProperties = null;          this.trackingEvent = null;          this.damageFloaters = null;         this.damageFloatersPaintableInterface = null;         this.healthBar = null;     }     */
    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        this.initPathAnimation.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
    }

    override def updateWaypointBehavior(geographicMapInterface : BasicGeographicMap) : Unit = {
        val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        hashtable.put(this.groupCommonFactory.ID, this.getGroupInterface())
        hashtable.put(Layer.ID, this)
        hashtable.put(AllBinaryGameLayerManager.ID, this.allBinaryGameLayerManagerP)
        this.setWaypointBehavior(new UnitWaypointBehavior2(this, this.waypointLayerInterfaceFactoryInterface.getNextInstance(hashtable, this.x, this.y, this.z).asInstanceOf[AdvancedRTSGameLayer]))
        val features : Features = Features.getInstance()
        val waypoint : WaypointBase = (if (J2MEUtil.isHTML()) new MultipassNoCacheWaypoint(this, AttackSound.getInstance()) else new NoCacheWaypoint(this, AttackSound.getInstance()))
        this.getWaypointBehavior().setWaypoint(waypoint)
        super.updateWaypointBehavior(geographicMapInterface)
        this.initRangeHack()
    }

    override def construct(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        super.construct(rtsPlayerLayerInterface)
        TrackingEventHandler.getInstance().addListenerInterface(this)
        WaypointEventHandlerFactory.getInstance(this.getGroupInterface()(0)).addListenerInterface(this.getUnitWaypointBehavior())
        BuildingEventHandler.getInstance().addListenerInterface(this)
        this.getUnitWaypointBehavior().setCurrentPathGeographicMapCellPosition(this.getCurrentGeographicMapCellPosition())
        this.updateSensorGeographicMapCellPositionList()
        this.getUnitWaypointBehavior().setLastPathGeographicMapCellPosition(this.getUnitWaypointBehavior().getCurrentPathGeographicMapCellPosition())
    }

    def updateSensorGeographicMapCellPositionList() : Unit = {
        if (VisibleCellPositionsSingleton.getInstance().shouldProcess()) {
            //  (UnitWaypointBehavior) this.getWaypointBehavior();
            val currentGeographicMapCellPosition : GeographicMapCellPosition = this.getCurrentGeographicMapCellPosition()
            //unitWaypointBehavior.getCurrentPathGeographicMapCellPosition()
            this.sensorGeographicMapCellPositionList.clear()
            this.sensorGeographicMapCellPositionList.add(currentGeographicMapCellPosition)
            val sensorRange : Int = this.weaponRange * UnitLayer.SENSOR_RANGE_MULTIPLIER
            val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
            val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
            val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
            val totalCells : Int = (sensorRange / tiledLayer.getCellHeight()) / 2
            val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
            val column : Int = currentGeographicMapCellPosition.getColumn()
            val row : Int = currentGeographicMapCellPosition.getRow()
            var lastColumn : Int = column + totalCells
            var lastRow : Int = row + totalCells
            if (lastColumn > tiledLayer.getColumns()) {
                lastColumn = tiledLayer.getColumns()
            }
            if (lastRow > tiledLayer.getRows()) {
                lastRow = tiledLayer.getRows()
            }
            var firstColumn : Int = column - totalCells
            var firstRow : Int = row - totalCells
            if (firstColumn < 0) {
                firstColumn = 0
            }
            if (firstRow < 0) {
                firstRow = 0
            }
            //PreLogUtil.put(stringBuffer.toString(), this, "updateSensorGeographicMapCellPositionList");

            {
                var index : Int = lastColumn - 1
                while (index >= firstColumn) {

                    {
                        var index2 : Int = lastRow - 1
                        while (index2 >= firstRow) {
                            val geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionFactory.getAt(index, index2)
                            if (!this.sensorGeographicMapCellPositionList.contains(geographicMapCellPosition)) {
                                this.sensorGeographicMapCellPositionList.add(geographicMapCellPosition)
                            }
                            index2 -= 1
                        }
                    }
                    index -= 1
                }
            }
        }
    }

    def getSensorGeographicMapCellPositionList() : BasicArrayList = {
        return this.sensorGeographicMapCellPositionList
    }

    override def select() : Unit = {
        this.pathAnimation = this.initPathAnimation
        super.select()
    }

    override def deselect() : Unit = {
        this.pathAnimation = NullAnimationFactory.getFactoryInstance().getInstance(0)
        super.deselect()
    }

    override def setSelected(selected : Boolean) : Unit = {
        super.setSelected(selected)
        if (selected) {
            if (this.debug) {
                this.rtsLogHelper = RTSLayerSelectedLogHelper.getInstance()
            }
            this.rtsLayer2LogHelper = RTSLayer2SelectedLogHelper.getInstance()
        } else {
            if (this.debug) {
                this.rtsLogHelper = RTSLayerLogHelper.getInstance()
            }
            this.rtsLayer2LogHelper = RTSLayer2LogHelper.getInstance()
        }
    }

    override def setClosestGeographicMapCellHistory(pathsList : BasicArrayList) : Unit = {
        this.rtsLogHelper.setClosestGeographicMapCellHistory(this, pathsList)
        var closestIndex : Int = -1
        var shortestDistance : Int = Integer.MAX_VALUE
        var currentDistance : Int = Integer.MAX_VALUE

        {
            var index : Int = pathsList.size() - 1
            while (index >= 0) {
                val geographicMapCellPositionBasicArrayList : BasicArrayList = pathsList.get(index).asInstanceOf[BasicArrayList]
                val geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionBasicArrayList.get(geographicMapCellPositionBasicArrayList.size() - 1).asInstanceOf[GeographicMapCellPosition]
                currentDistance = this.layerDistanceUtil.getDistanceAt(this, geographicMapCellPosition.getMidPoint())
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance
                    closestIndex = index
                }
                index -= 1
            }
        }
        if (closestIndex >= 0) {
            val geographicMapCellPositionBasicArrayList : BasicArrayList = pathsList.get(closestIndex).asInstanceOf[BasicArrayList]
            val geographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPositionBasicArrayList.get(0).asInstanceOf[GeographicMapCellPosition]
            this.teleportTo(geographicMapCellPosition)
        }
    }

    override def init(geographicMapCellHistory : GeographicMapCellHistory, geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit = {
        // this.logUtil.putF("Adding " + size + " path nodes for Tracking", this, this.commonStrings.INIT);
        geographicMapCellHistory.trackAll(geographicMapCellPositionBasicArrayList)
    }

    override def onMovement(trackingEvent : TrackingEvent) : Unit = {
        try {
            val layerInterface : AdvancedRTSGameLayer = trackingEvent.getLayerInterface().asInstanceOf[AdvancedRTSGameLayer]
            /*                 if(this.isSelected())                 {                     this.logUtil.putF("Possible Target: " + layerInterface.getName(), this, "selected: onMovement");                 }                 */
            if (layerInterface.getGroupInterface()(0) ne this.getGroupInterface()(0)) {
                this.getUnitWaypointBehavior().getPossibleTargetList().add(layerInterface)
                //this.onEnemyMovement(layerInterface);
                layerInterface.onMovementFound(this.getTrackingEvent())
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onMovement", e)
            }
        }
    }

    override def onMovementFound(trackingEvent : TrackingEvent) : Unit = {
        val layerInterface : AdvancedRTSGameLayer = trackingEvent.getLayerInterface().asInstanceOf[AdvancedRTSGameLayer]
        /*         if(this.isSelected())         {             this.logUtil.putF("Possible Target: " + layerInterface.getName(), this, "selected: onMovementFound");         }         */
        if (layerInterface.getGroupInterface()(0) ne this.getGroupInterface()(0)) {
            this.getUnitWaypointBehavior().getPossibleTargetList().add(layerInterface)
        }
    }

    def initRangeHack() : Unit = {
        val basicWeaponPart : BasicWeaponPart = this.getPartInterfaceArray()(0).asInstanceOf[BasicWeaponPart]
        val weaponProperties : WeaponProperties = basicWeaponPart.getWeaponProperties()
        this.weaponRange = weaponProperties.getRange()
        this.initRangeAnimation = AdjustedCircleAnimation.createW(this.weaponRange, this.weaponRange, this.getWidth(), this.basicColorFactory.GREEN)
        val sensorRange : Int = this.weaponRange * UnitLayer.SENSOR_RANGE_MULTIPLIER
        this.initSensorRangeAnimation = AdjustedCircleAnimation.createW(sensorRange, sensorRange, this.getWidth(), this.basicColorFactory.RED)
        this.getUnitWaypointBehavior().initRange(this.weaponRange)
        this.fireTimeHelper.delay = (weaponProperties.getReloadTime().toInt)
    }

    override def processBuiltTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (!this.getHealthInterface().isAlive()) {
            if (this.isReadyForExplosion()) {
                val currentFrame : Int = this.destroyAnimationInterface.getFrame()
                val size : Int = this.destroyAnimationInterface.getSize() - 1
                // this.logUtil.putF("Explosion - Processing: " + currentFrame + "==" + size, this, "processTick");
                if (currentFrame == size) {
                    // this.logUtil.putF("Explosion - End", this, "processTick");
                    if (!this.getHealthInterface().isAlive()) {
                        this.setDestroyed(true)
                    }
                } else {
                    // show next frame in explosion
                    this.destroyAnimationInterface.nextFrame()
                }
            } else {
                // this.logUtil.putF("Explosion - Begin", this, "processTick");
                this.setAnimationInterface(this.destroyAnimationInterface)
                // this.getVehicleProperties().getVelocityProperties().zero();
                SecondaryPlayerQueueFactory.getInstance().add(ExplosionBasicSound.getInstance())
                this.shakeListener.onSmallShakeEvent()
                this.vibration.vibrate(this.duration, 0, 0)
                // this.delayMovementTimeHelper.setStartTime();
                this.setReadyForExplosion(true)
            }
        } else {
            super.processBuiltTick(allBinaryLayerManager)
        }
        this.captionAnimationHelper.tick()
        this.getUnitWaypointBehavior().processTick(allBinaryLayerManager)
    }

    override def teleportTo(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        val point : GPoint = geographicMapCellPosition.getMidPoint()
        this.setPosition(point.getX() - this.getHalfWidth(), point.getY() - this.getHalfHeight(), this.z)
    }

    override def getCurrentGeographicMapCellPosition() : GeographicMapCellPosition = {
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val geographicMapCellPosition : GeographicMapCellPosition = geographicMapInterface.getCellPositionAtXY(this.x + this.getHalfWidth(), this.y + this.getHalfHeight())
        //This should never happen remove when bug is found
        val raceTrackGeographicMap : RaceTrackGeographicMap = geographicMapInterface.asInstanceOf[RaceTrackGeographicMap]
        if (!raceTrackGeographicMap.isValid(geographicMapCellPosition)) {
            throw new Exception("Position is not really on the map: " + geographicMapCellPosition)
        }
        return geographicMapCellPosition
    }

    override def fire(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
        //this.logUtil.putF("fireAll", this, "fire");
        if (this.fireTimeHelper.isTimeTNT()) {
            //this.logUtil.putF("fire", this, gameInputStrings.PROCESS_INPUT);
            this.fireAll(layerManager)
        } else {
            this.reload()
        }
    }

    override def left() : Unit = {
        this.initResourceAnimation.previousRotation()
        this.decalAnimation.previousRotation()
        this.rotationAnimationInterfaceP.previousRotation()
    }

    override def right() : Unit = {
        /*         if(this.isChase())         {             this.logUtil.putF("Turning while chasing", this, "right");         }         */
        this.initResourceAnimation.nextRotation()
        this.decalAnimation.nextRotation()
        this.rotationAnimationInterfaceP.nextRotation()
    }

    override def down() : Unit = {
        val velocityProperties : VelocityProperties = this.getVehicleProperties().getVelocityProperties()
        if (!velocityProperties.isOverXYMaxForwardVelocity()) {
            this.accelerate(this.decelerationBasicDecimal)
        }
    }

    //accelerate
    override def up() : Unit = {
        val velocityProperties : VelocityProperties = this.getVehicleProperties().getVelocityProperties()
        if (!velocityProperties.isOverXYMaxForwardVelocity()) {
            this.accelerate(this.accelerationBasicDecimal)
        }
    }

    override def initInputProcessors() : Unit = {
        this.inputProcessorArray(Canvas.RIGHT) = new SpecialRightGameInputProcessor(this)
        this.inputProcessorArray(Canvas.LEFT) = new SpecialLeftGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_NUM0) = new SpecialFireGameInputProcessor(this)
        this.inputProcessorArray(Canvas.KEY_POUND) = this.inputProcessorArray(Canvas.KEY_NUM0)
        this.inputProcessorArray(Canvas.DOWN) = new SpecialDownGameInputProcessor(this)
        this.inputProcessorArray(Canvas.UP) = new SpecialUpGameInputProcessor(this)
        super.initInputProcessors()
    }

    override def processInput(layerManager : AllBinaryLayerManager) : Unit = {
        val list : BasicArrayList = this.getGameKeyEventList()
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                var anyType : Object = list.get(index)
                var key : Int = GameKeyEventUtil.getKey(anyType)
                this.inputProcessorArray(key).processEvent(layerManager, GameKeyEvent.NONE)
                index += 1
            }
        }
        list.clear()
        this.groundFriction()
        this.move()
    }

    def accelerate(accelerate : BasicDecimal) : Unit = {
        this.getVehicleProperties().getVelocityProperties().addVelocityi(accelerate.getUnscaled(), this.rotationAnimationInterfaceP.getAngleInfoP().getAngle().toInt, 90)
    }

    def fireAll(layerManager : AllBinaryLayerManager) : Unit = {
        val angleInfo : AngleInfo = this.rotationAnimationInterfaceP.getAngleInfoP()
        val angle : Int = (angleInfo.getAngle() + this.slightAngle).toInt
        this.hashtable.put(SmallIntegerSingletonFactory.getInstance().getAt(1), SmallIntegerSingletonFactory.getInstance().getAt(AngleFactory.getInstance().getAt(angle).getValue().toInt))
        val salvoInterface : SalvoInterface = this.getPartInterfaceArray()(0).asInstanceOf[SalvoInterface]
        salvoInterface.process(layerManager, angle.toShort, (90).toShort)
    }

    override def downgrade() : Unit = {
        if (this.getLevel() > 1) {
            super.downgrade()
        }
    }

    override def upgrade() : Unit = {
        super.upgrade()
        this.initRangeHack()
    }

    def groundFriction() : Unit = {
        val vehicleFrictionProperties : VehicleFrictionProperties = this.getVehicleProperties().getVehicleFrictionProperties()
        this.getVehicleProperties().getVehicleFrictionProperties().friction(this.getVehicleProperties().getVelocityProperties(), vehicleFrictionProperties.getTireFrictionNominator())
    }

    override def trackTo(reason : String) : Unit = {
        val waypointBehaviorBase : WaypointBehaviorBase = this.waypointBehaviorBase.asInstanceOf[WaypointBehaviorBase]
        val nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = waypointBehaviorBase.getNextUnvisitedPathGeographicMapCellPosition()
        val point : GPoint = nextUnvisitedPathGeographicMapCellPosition.getMidPoint()
        val dx : Int = (this.getXP() + this.getHalfWidth()) - point.getX()
        val dy : Int = (this.getYP() + this.getHalfHeight()) - point.getY()
        this.rtsLogHelper.trackTo(this, nextUnvisitedPathGeographicMapCellPosition, dx, dy, reason)
        this.trackToDXY(dx, dy)
    }

    //private final NoDecimalTrigTable noDecimalTrigTable = NoDecimalTrigTable.getInstance();
    override def trackToDXY(dx : Int, dy : Int) : Unit = {
        //final int angleOfTarget = -90 - noDecimalTrigTable.antiTan(dx, dy);
        val angleOfTarget : Int = 0
        this.trackToDXYTargetAngle(dx, dy, angleOfTarget)
    }

    private def turnTo(dx : Int, dy : Int, param_targetAngle : Int) : Boolean = {
        var targetAngle : Int = param_targetAngle
        // int angleOfTarget = NoDecimalTrigTable.antiTan(dx, dy);
        val waypointBehaviorBase : WaypointBehaviorBase = this.waypointBehaviorBase.asInstanceOf[WaypointBehaviorBase]
        val nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = waypointBehaviorBase.getNextUnvisitedPathGeographicMapCellPosition()
        var evading : Boolean = false
        // Run until out of sensor range
        if (this.getUnitWaypointBehavior().getSensorAction() eq SensorActionFactory.getInstance().EVADE) {
            this.rtsLogHelper.evade(this)
            evading = true
            targetAngle += 180
        }
        //final int angleOfTarget2 = AngleFactory.getInstance().getClosestDirection(angleOfTarget).getValue();
        val angleInfo : AngleInfo = this.rotationAnimationInterfaceP.getAngleInfoP()
        val angle : Int = FrameUtil.getInstance().adjustAngleToFrameAngle(angleInfo.getAngle() - 270)
        //if (this.getUnitWaypointBehavior().isWaypointListEmptyOrOnlyTargets())
        this.rtsLogHelper.turnTo(this, dx, dy, angleInfo, angle, this.movementAngle, evading, targetAngle)
        val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()
        //() || 
        if ((dx == 0) && (dy == 0)) {
            this.rtsLogHelper.doneMoving(this)
            return true
        } else if ((this.movementAngle.getValue().toInt) == angle) {
            if ((dx > 0) && (this.movementAngle eq this.angleFactory.LEFT)) {
                this.rtsLogHelper.movingLeft(this)
                return false
            }
            if ((dx < 0) && (this.movementAngle eq this.angleFactory.RIGHT)) {
                this.rtsLogHelper.movingRight(this)
                return false
            }
            if ((dy > 0) && (this.movementAngle eq this.angleFactory.UP)) {
                this.rtsLogHelper.movingUp(this)
                return false
            }
            if ((dy < 0) && (this.movementAngle eq this.angleFactory.DOWN)) {
                this.rtsLogHelper.movingDown(this)
                return false
            }
            this.rtsLogHelper.currentMoveEnded(this)
            if ((this.movementAngle eq this.angleFactory.LEFT) || (this.movementAngle eq this.angleFactory.RIGHT)) {
                this.handleDeltalY(dx, dy)
            } else if ((this.movementAngle eq this.angleFactory.UP) || (this.movementAngle eq this.angleFactory.DOWN)) {
                this.handleDeltalX(dx, dy)
            }
            return true
        } else {
            //this.slightAngle = angleOfTarget - angle;
            if (nextUnvisitedPathGeographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
                if (this.steeringInsideGeographicMapCellPosition ne nextUnvisitedPathGeographicMapCellPosition) {
                    if ((Math.abs(dx) > Math.abs(dy)) && (dy != 0)) {
                        this.handleDeltalY(dx, dy)
                    } else if (dx != 0) {
                        this.handleDeltalX(dx, dy)
                    } else {
                        this.handleDeltalY(dx, dy)
                    }
                }
                var deltaAngle2 : Int = this.movementAngle.getValue() - angle
                if (deltaAngle2 > 0) {
                    this.rtsLogHelper.rotateRight(this)
                    this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.RIGHT))
                } else {
                    this.rtsLogHelper.rotateLeft(this)
                    this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.LEFT))
                }
                return true
            } else {
                this.rtsLogHelper.noRotation(this)
            }
            return false
        }
        throw new IllegalStateException()
    }

    private def handleDeltalX(dx : Int, dy : Int) : Unit = {
        val waypointBehaviorBase : WaypointBehaviorBase = this.waypointBehaviorBase.asInstanceOf[WaypointBehaviorBase]
        val nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = waypointBehaviorBase.getNextUnvisitedPathGeographicMapCellPosition()
        if (dx > 0) {
            this.movementAngle = this.angleFactory.LEFT
            this.steeringInsideGeographicMapCellPosition = nextUnvisitedPathGeographicMapCellPosition
        } else {
            this.movementAngle = this.angleFactory.RIGHT
            this.steeringInsideGeographicMapCellPosition = nextUnvisitedPathGeographicMapCellPosition
        }
        this.rtsLogHelper.handle(this, this.movementAngle)
    }

    private def handleDeltalY(dx : Int, dy : Int) : Unit = {
        val waypointBehaviorBase : WaypointBehaviorBase = this.waypointBehaviorBase.asInstanceOf[WaypointBehaviorBase]
        val nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition = waypointBehaviorBase.getNextUnvisitedPathGeographicMapCellPosition()
        if (dy > 0) {
            this.movementAngle = this.angleFactory.UP
            this.steeringInsideGeographicMapCellPosition = nextUnvisitedPathGeographicMapCellPosition
        } else {
            this.movementAngle = this.angleFactory.DOWN
            this.steeringInsideGeographicMapCellPosition = nextUnvisitedPathGeographicMapCellPosition
        }
        this.rtsLogHelper.handle(this, this.movementAngle)
    }

    private def trackToDXYTargetAngle(dx : Int, dy : Int, targetAngle : Int) : Unit = {
        //If colliding with a game object then don't try to turn since in chase mode
        val list : BasicArrayList = this.getUnitWaypointBehavior().getSteeringVisitorList()
        if (list.size() > 0) {
            //this.logUtil.putF("Chasing", this, "trackTo");

            {
                var index : Int = list.size() - 1
                while (index >= 0) {
                    val steeringVisitor : SteeringVisitor = list.get(index).asInstanceOf[SteeringVisitor]
                    val anyType : Object = steeringVisitor.visit(this)
                    if (anyType == null) {
                        list.removeAt(index)
                    }
                    index -= 1
                }
            }
            this.fireOrMove()
        } else if (!this.turnTo(dx, dy, targetAngle)) {
            this.fireOrMove()
        }
    }

    def fireOrMove() : Unit = {
        //this.logUtil.putF("Move/Attack: " +  " trackingWaypoint: " + this.trackingWaypoint + " sensorAction: " + this.sensorAction + " currentTargetDistance >= longWeaponRange " + this.currentTargetDistance + ">=" + this.longWeaponRange , this, "trackTo");
        val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()
        // Move if going to waypoint, evading, or towards target
        if (this.getUnitWaypointBehavior().needToMove()) {
            this.rtsLayer2LogHelper.steeringUp(this)
            if (this.showMoreCaptionStates && !this.captionAnimationHelper.isShowing()) {
                this.captionAnimationHelper.update(UnitLayer.MOVE, this.basicColorFactory.GREEN)
            }
            this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.UP))
        } else {
            this.captionAnimationHelper.update(CommonPhoneStrings.getInstance().FIRE, this.basicColorFactory.RED)
            // int anotherTargetDistance = DistanceUtil.getDistance(this, this.currentTargetLayerInterface);
            this.rtsLayer2LogHelper.steeringFireOrStop(this)
            // this.currentTargetDistance + ">=" + this.longWeaponRange, // this, "processTargeting");
            this.allStop()
            this.getGameKeyEventList().add(gameKeyEventFactory.getInstanceForKey(this, Canvas.KEY_NUM0))
            TrackingEventHandler.getInstance().fireEvent(this.getTrackingEvent())
        }
    }

    override def move() : Unit = {
        try {
            val velocityProperties : VelocityProperties = this.getVehicleProperties().getVelocityProperties()
            val velocityXScaled : Long = velocityProperties.getVelocityXBasicDecimalP().getScaled().toLong
            val velocityYScaled : Long = velocityProperties.getVelocityYBasicDecimalP().getScaled().toLong
            this.getUnitWaypointBehavior().move()
            if ((velocityXScaled != 0L) || (velocityYScaled != 0L)) {
                this.getUnitWaypointBehavior().setMoving(true)
                val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
                val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
                this.layerPartialCellPositionsUtil.getAllDXY(geographicMapInterface, this, velocityXScaled.toInt, velocityYScaled.toInt, UnitLayer.getPartialpositionlist())
                //is building in path
                val cellPosition : GeographicMapCellPosition = DropCellPositionHistory.getInstance().getCellPositionWithDrop(UnitLayer.getPartialpositionlist()).asInstanceOf[GeographicMapCellPosition]
                if (cellPosition eq this.cellPositionFactory.NONE) {
                    val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
                    val tiledLayerUtil : TiledLayerUtil = TiledLayerUtil.getInstance()
                    var x : Int = this.x + velocityXScaled.toInt
                    var y : Int = this.y + velocityYScaled.toInt
                    x = tiledLayerUtil.keepOnMapX(tiledLayer, x, this.getWidth())
                    y = tiledLayerUtil.keepOnMapY(tiledLayer, y, this.getHeight())
                    this.setPosition(x, y, this.z)
                } else {
                    val allbinaryLayer : AllBinaryLayer = DropCellPositionHistory.getInstance().getLayerInterface(cellPosition)
                    this.getUnitWaypointBehavior().setMovingFromStopped(false)
                    this.getUnitWaypointBehavior().addBuildingChase(allbinaryLayer, cellPosition)
                }
            }
            if (this.getUnitWaypointBehavior().isMoving()) {
                // this.logUtil.putF("moving", this, "move");
                TrackingEventHandler.getInstance().fireEvent(this.getTrackingEvent())
            } else {
                this.getUnitWaypointBehavior().setMovingFromStopped(false)
            }
            if (this.getUnitWaypointBehavior().isMovingFromStopped() && this.isVisible()) {
                SecondaryPlayerQueueFactory.getInstance().add(this.moveSoundInterface)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "move", e)
            }
        }
    }

    override def allStop() : Unit = {
        val velocityProperties : VelocityProperties = this.getVehicleProperties().getVelocityProperties()
        velocityProperties.getVelocityXBasicDecimalP().setint(0)
        velocityProperties.getVelocityYBasicDecimalP().setint(0)
    }

    override def paint(graphics : Graphics) : Unit = {
        if (this.isVisible()) {
            // this.getAnimationInterface().paint(graphics, viewX, viewY);
            super.paint(graphics)
            val viewPosition : ViewPositionBase = this.getViewPosition()
            var viewX : Int = viewPosition.getX()
            var viewY : Int = viewPosition.getY()
            this.decalAnimation.paintXY(graphics, viewX, viewY)
            this.rangeAnimation.paintXY(graphics, viewX, viewY)
            this.sensorRangeAnimation.paintXY(graphics, viewX, viewY)
            this.damageFloatersPaintableInterface.paint(graphics)
            this.healthBar.paint(graphics)
            this.captionAnimationHelper.paintXY(graphics, viewX, viewY)
            this.pathAnimation.paintXY(graphics, viewX, viewY)
            this.resourceAnimation.paintXY(graphics, viewX, viewY)
        }
    }

    override def onBuildingEvent(event : RTSLayerEvent) : Unit = {
        var buildingLayer : BuildingLayer = event.getRtsLayer().asInstanceOf[BuildingLayer]
        this.getUnitWaypointBehavior().moveAwayFromBuilding(buildingLayer)
    }

    /**      * @return the vehicleProperties      */
    def getVehicleProperties() : VehicleProperties = {
        return this.vehicleProperties
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
        super.damage(damage, damageType)
        this.damageFloaters.add(damage)
        if (damage > 0) {
            this.getHealthInterface().damage(damage)
        }
    }

    override def getDamage(damageType : Int) : Int = {
        return 0
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "setDestroyed")
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            WaypointEventHandlerFactory.getInstance(this.getGroupInterface()(0)).removeListener(this.getUnitWaypointBehavior())
            TrackingEventHandler.getInstance().removeListener(this)
            BuildingEventHandler.getInstance().removeListener(this)
            if (!this.getHealthInterface().isAlive()) {
                val damage : Int = this.getHealthInterface().getMaxHealth()
                if (damage > 10) {
                    SecondaryPlayerQueueFactory.getInstance().add(ExplosionBasicSound.getInstance())
                    if (damage < 100) {
                        this.shakeListener.onSmallShakeEvent()
                        this.vibration.vibrate(this.duration, 0, 0)
                    } else if (damage < 1000) {
                        this.shakeListener.onMediumShakeEvent()
                        this.vibration.vibrate(this.duration * 2, 0, 0)
                    } else if (damage < 3000) {
                        this.shakeListener.onLargeShakeEvent()
                        this.vibration.vibrate(this.duration * 4, 0, 0)
                    }
                }
            }
        }
    }

    /**      * @return the resource      */
    def getLoad() : Int = {
        return this.resourceLoad
    }

    def clearResourceAnimation() : Unit = {
        this.resourceAnimation = NullIndexedAnimationFactory.getFactoryInstance().getInstance(0).asInstanceOf[IndexedAnimation]
    }

    /**      * @param resource      *            the resource to set      */
    override def setLoad(resource : Int) : Unit = {
        if (resource > 0) {
            this.resourceAnimation = this.initResourceAnimation
        } else {
            //Drop load... I could have yet another animation showing the load being dropped
            this.clearResourceAnimation()
        }
        this.resourceLoad = resource
    }

    /**      * @param resource      *            the resource add      */
    def addLoad(resource : Int) : Unit = {
        this.resourceLoad += resource
    }

    override def handleCost(ownerLayer : PathFindingLayerInterface) : Unit = {
        if (this.getLoad() > 0) {
            //Add Capital
            this.CAPITAL_EVENT.setValue(this.getLoad())
            CapitalEventHandlerFactory.getInstance(ownerLayer.getGroupInterface()(0)).fireEvent(this.CAPITAL_EVENT)
            this.setLoad(0)
        }
    }

    override def createHudPaintable() : SelectionHudPaintable = {
        val rtsLayerHudPaintable : RTSLayerHudPaintable = RTSLayerHudPaintable.getInstance()
        rtsLayerHudPaintable.setBasicColorP(this.allBinaryGameLayerManagerP.getForegroundBasicColor())
        rtsLayerHudPaintable.setRtsLayer(this)
        return rtsLayerHudPaintable
    }

    override def getHudPaintable() : SelectionHudPaintable = {
        val rtsLayerHudPaintable : RTSLayerHudPaintable = RTSLayerHudPaintable.getInstance()
        return rtsLayerHudPaintable
    }

    override def getType() : Int = {
        return 1
    }

    def getUnitWaypointBehavior() : UnitWaypointBehavior = {
        return this.getWaypointBehavior().asInstanceOf[UnitWaypointBehavior]
    }

    override def getTrackingEvent() : TrackingEvent = {
        return this.trackingEvent
    }

    override def getCaptionAnimationHelper() : CaptionAnimationHelperBase = {
        return this.captionAnimationHelper
    }

    override def isSelfUpgradeable() : Boolean = {
        return false
    }

    def getMaxResourceLoad() : Short = {
        return this.maxResourceLoad
    }

}

object UnitLayer {
    private val partialPositionList : BasicArrayList = new BasicArrayListS(4)

    private val SENSOR_RANGE_MULTIPLIER : Int = 6

    private val MOVE : String = "Moving"

    def getStaticType() : Int = {
        return 1
    }

    def getPartialpositionlist() : BasicArrayList = {
        return UnitLayer.partialPositionList
    }

}


