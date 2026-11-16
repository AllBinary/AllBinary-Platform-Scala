/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.building

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.ag.weapon.media.audio.ExplosionBasicSound
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.NullIndexedAnimationFactory
import _root_.org.allbinary.game.identification.GroupFactory
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.input.form.VisibleCellPositionsSingleton
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.AdvancedRTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.AdvancedRTSProperties
import _root_.org.allbinary.game.layer.CollidableRTSBehavior
import _root_.org.allbinary.game.layer.RTSLayerUtil
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.SelectionHudPaintable
import _root_.org.allbinary.game.layer.waypoint.Waypoint
import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.RotationAnimationInterfaceCompositeInterface
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.combat.damage.DamageFloaters
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase
import _root_.org.allbinary.game.layer.NullPathFindingLayer
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.game.tracking.TrackingEventListenerInterface
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.SelectSound
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapDirectionUtil
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayListS
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.animation.RotationAnimation

class BuildingLayer(param_remoteInfo : RemoteInfo, param_buildingPropertiesFactory : BuildingPropertiesFactory, param_advancedRTSProperties : AdvancedRTSProperties, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_healthInterface : Health, param_rtsFormInput : RTSFormInput, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_x : Int, param_y : Int) extends AdvancedRTSGameLayer(param_remoteInfo, NullPathFindingLayer.NULL_PATH_FINDING_LAYER, param_advancedRTSProperties, param_groupInterface, param_rootName, param_name, param_healthInterface, param_rtsFormInput, param_animationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface, param_rectangle, param_x, param_y, new TileLayerPositionIntoViewPosition()) with RotationAnimationInterfaceCompositeInterface with TrackingEventListenerInterface {
    import _root_.org.allbinary.game.layer.building.BuildingLayer.{*}

    private var buildingLevelCost : Int = 0

    private var productivity : Int = 0

    private var efficiency : Int = 0

    private var efficiencyPerLevel : Int = 0

    private var trackingEvent : TrackingEvent = null

    private var damageFloaters : DamageFloaters = null

    private var damageFloatersPaintableInterface : Paintable = null

    private var healthBar : Paintable = null

    private var pathsHashtable : ABHashtable[Object, Object] = null

    var local : Boolean = false

    val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(3000)

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
        val buildingPropertiesFactory : BuildingPropertiesFactory = param_buildingPropertiesFactory
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
        this.setCollidableInferface(new CollidableRTSBehavior(true))
        this.getWaypointBehavior().setWaypoint(new Waypoint(this, SelectSound.getInstance()))
        this.damageFloaters = buildingPropertiesFactory.getDamageFloaters(this)
        this.damageFloatersPaintableInterface = buildingPropertiesFactory.damageFloatersPaintableInterface
        this.healthBar = buildingPropertiesFactory.getHealthBar(this)
        this.pathsHashtable = buildingPropertiesFactory.getHashtable()
        this.setMaxLevel(30)
        this.setProductivity(1)
        this.setEfficiency(this.calculateEfficiency())
        this.efficiencyPerLevel = buildingPropertiesFactory.getEfficiencyPerLevel(this)
        this.efficiency = this.efficiencyPerLevel
        this.generateMoveOutOfBuildAreaPaths()
        this.trackingEvent = buildingPropertiesFactory.getTrackingEvent(this)
    }

    override def initVisibility(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        val advancedRTSPlayerLayerInterface : AdvancedRTSPlayerLayerInterface = rtsPlayerLayerInterface.asInstanceOf[AdvancedRTSPlayerLayerInterface]
        if (advancedRTSPlayerLayerInterface.isLocalPlayer()) {
            this.local = true
            this.addVisibility()
        } else {
            this.local = false
        }
        super.initVisibility(rtsPlayerLayerInterface)
    }

    override def construct(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        super.construct(rtsPlayerLayerInterface)
        TrackingEventHandler.getInstance().addListenerInterface(this)
    }

    override def onMovement(trackingEvent : TrackingEvent) : Unit = {
        try {
            val layerInterface : AdvancedRTSGameLayer = trackingEvent.getLayerInterface().asInstanceOf[AdvancedRTSGameLayer]
            //this.logUtil.putF("Possible Target: " + layerInterface.getName(), this, "onMovement");
            if (layerInterface.getGroupInterface()(0) ne this.getGroupInterface()(0)) {
                //this.logUtil.putF("Enemy Possible Target: " + layerInterface.getName(), this, "onMovement");
                layerInterface.onMovementFound(this.trackingEvent)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onMovement", e)
            }
        }
    }

    override def processBuiltTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.getHealthInterface().isDamaged()) {
            this.setAnimationInterface(this.destroyAnimationInterface)
        }
        /*         else         {             this.setAnimationInterface(this.indexedAnimationInterface);         }         */
        if (!this.getHealthInterface().isAlive()) {
            if (this.isReadyForExplosion()) {
                val currentFrame : Int = this.destroyAnimationInterface.getFrame()
                val size : Int = this.destroyAnimationInterface.getSize() - 1
                //this.logUtil.putF("Explosion - Processing: " + currentFrame + "==" + size, this, "processTick");
                if ((currentFrame == size) && !this.timeDelayHelper.isTimeTNT()) {
                    //this.logUtil.putF("Explosion - End", this, "processTick");
                    if (!this.getHealthInterface().isAlive()) {
                        this.setDestroyed(true)
                    }
                } else {
                    // show next frame in explosion
                    this.destroyAnimationInterface.nextFrame()
                }
            } else {
                // this.logUtil.putF("Explosion - Begin", // this, "processTick");
                this.setAnimationInterface(this.destroyAnimationInterface)
                //this.getVehicleProperties().getVelocityProperties().zero();
                SecondaryPlayerQueueFactory.getInstance().add(ExplosionBasicSound.getInstance())
                this.shakeListener.onSmallShakeEvent()
                this.vibration.vibrate(this.duration, 0, 0)
                this.timeDelayHelper.setStartTimeTNT()
                this.setReadyForExplosion(true)
            }
        } else {
            super.processBuiltTick(allBinaryLayerManager)
        }
        this.indexedButShouldBeRotationAnimationInterface.nextFrame()
    }

    final private def calculateEfficiency() : Int = {
        return this.efficiencyPerLevel
    }

    override def getCost() : Int = {
        val total : Long = RTSLayerUtil.getInstance().getCostExponential((this.getLevel() * this.getBuildingLevelCost()).toLong)
        return total.toInt
    }

    override def getDowngradeCost() : Int = {
        val downgradeCost : Long = RTSLayerUtil.getInstance().getCostExponential(((this.getLevel() - 1) * this.getBuildingLevelCost()).toLong)
        this.logUtil.putF("Cost: " + downgradeCost, this, "getDowngradeCost")
        return (downgradeCost.toInt * 9) / 10
    }

    override def getUpgradeCost() : Int = {
        val upgradeCost : Long = RTSLayerUtil.getInstance().getCostExponential(((this.getLevel() + 1) * this.getBuildingLevelCost()).toLong)
        //this.logUtil.putF("Cost: " + upgradeCost, this, "getUpgradeCost");
        return upgradeCost.toInt
    }

    override def downgrade() : Unit = {
        super.downgrade()
        this.setProductivity(this.getProductivity() - 1)
        this.setEfficiency(this.getEfficiency() - this.calculateEfficiency())
        this.getHealthInterface().setMaxHealth(this.getHealthInterface().getMaxHealth() - ((this.getLevel() + 1) * 100))
    }

    override def upgrade() : Unit = {
        super.upgrade()
        this.setProductivity(this.getProductivity() + 1)
        this.setEfficiency(this.getEfficiency() + this.calculateEfficiency())
        this.getHealthInterface().setMaxHealth(this.getHealthInterface().getMaxHealth() + (this.getLevel() * 100))
    }

    /**      * @return the buildingLevelCost      */
    private def getBuildingLevelCost() : Int = {
        return this.buildingLevelCost
    }

    /**      * @param buildingLevelCost the buildingLevelCost to set      */
    def setBuildingLevelCost(buildingLevelCost : Int) : Unit = {
        this.buildingLevelCost = buildingLevelCost
    }

    /**      * @return the productivity      */
    def getProductivity() : Int = {
        return this.productivity
    }

    /**      * @param productivity the productivity to set      */
    def setProductivity(productivity : Int) : Unit = {
        this.productivity = productivity
    }

    /**      * @return the efficiency      */
    def getEfficiency() : Int = {
        return this.efficiency
    }

    /**      * @param efficiency the efficiency to set      */
    def setEfficiency(efficiency : Int) : Unit = {
        this.efficiency = efficiency
    }

    private def generateMoveOutOfBuildAreaPaths() : Unit = {
        val occupyList : BasicArrayList = this.geographicMapCellPositionAreaBase.getOccupyingGeographicMapCellPositionList()
        val surroundList : BasicArrayList = this.geographicMapCellPositionAreaBase.getSurroundingGeographicMapCellPositionList()
        val NO_DIRECTION : Direction = DirectionFactory.getInstance().NO_DIRECTION
        //}
        val geographicMapDirectionUtil : GeographicMapDirectionUtil = GeographicMapDirectionUtil.getInstance()
        var pathsList : BasicArrayList = null
        var occupyGeographicMapCellPosition : GeographicMapCellPosition = null
        var surroundGeographicMapCellPosition : GeographicMapCellPosition = null
        var list : BasicArrayList = null

        {
            var index2 : Int = occupyList.size() - 1
            while (index2 >= 0) {
                pathsList = new BasicArrayListD()
                occupyGeographicMapCellPosition = occupyList.get(index2).asInstanceOf[GeographicMapCellPosition]

                {
                    var index : Int = surroundList.size() - 1
                    while (index >= 0) {
                        surroundGeographicMapCellPosition = surroundList.get(index).asInstanceOf[GeographicMapCellPosition]
                        //If bordered with
                        if (geographicMapDirectionUtil.getEightDirectionFromCellPositionToAdjacentCellPosition(surroundGeographicMapCellPosition, occupyGeographicMapCellPosition) ne NO_DIRECTION) {
                            list = new BasicArrayListS(1)
                            //list.add(occupyGeographicMapCellPosition);
                            list.add(surroundGeographicMapCellPosition)
                            pathsList.add(list)
                        }
                        index -= 1
                    }
                }
                this.pathsHashtable.put(occupyGeographicMapCellPosition, pathsList)
                index2 -= 1
            }
        }
    }

    override def getMoveOutOfBuildAreaPath(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        val pathsList : BasicArrayList = this.pathsHashtable.get(geographicMapCellPosition).asInstanceOf[BasicArrayList]
        return pathsList
    }

    override def getEndGeographicMapCellPositionList() : BasicArrayList = {
        return this.geographicMapCellPositionAreaBase.getSurroundingGeographicMapCellPositionList()
    }

    override def shouldHandleStartSameAsEnd() : Boolean = {
        return false
    }

    override def paint(graphics : Graphics) : Unit = {
        if (this.isVisible()) {
            super.paint(graphics)
            this.damageFloatersPaintableInterface.paint(graphics)
            this.healthBar.paint(graphics)
        }
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
        super.damage(damage, damageType)
        this.damageFloaters.add(damage)
        //this.logUtil.putF("Recieving Damage: " + damage, this, "damage");
        if (damage > 0) {
            this.getHealthInterface().damage(damage)
        }
    }

    override def getDamage(damageType : Int) : Int = {
        return 0
    }

    def addVisibility() : Unit = {
        val geographicMapCellPositionArea : GeographicMapCellPositionAreaBase = this.geographicMapCellPositionAreaBase
        val occupyList : BasicArrayList = geographicMapCellPositionArea.getOccupyingGeographicMapCellPositionList()
        VisibleCellPositionsSingleton.getInstance().addStationaryCellPositions(occupyList)
        val surroundList : BasicArrayList = geographicMapCellPositionArea.getSurroundingGeographicMapCellPositionList()
        VisibleCellPositionsSingleton.getInstance().addStationaryCellPositions(surroundList)
    }

    def removeVisibility() : Unit = {
        val occupyList : BasicArrayList = this.geographicMapCellPositionAreaBase.getOccupyingGeographicMapCellPositionList()
        VisibleCellPositionsSingleton.getInstance().removeStationaryCellPositions(occupyList)
        val surroundList : BasicArrayList = this.geographicMapCellPositionAreaBase.getSurroundingGeographicMapCellPositionList()
        VisibleCellPositionsSingleton.getInstance().removeStationaryCellPositions(surroundList)
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        super.setDestroyed(destroyed)
        if (this.isDestroyed()) {
            DropCellPositionHistory.getInstance().removeAll(this)
            TrackingEventHandler.getInstance().removeListener(this)
            if (this.local) {
                this.removeVisibility()
            }
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

    /*     protected void collideUnit(UnitLayer collidableInterface) throws Exception     {     this.logUtil.putF("Move Away From Building", this, "collideUnit");     collidableInterface.moveAwayFromBuilding(this);      //1. Unit started path before building built or was pushed into building     //if(collidableInterface.isTrackingWaypoint())     //{     //Try to get unit to get new path to waypoint     //this.logUtil.putF("Building force Clearing Target", this, "collideUnit");     //  collidableInterface.moveAwayFromBuilding(this);     //}     //else     //2. Unit Chasing or was pushed into building     //{     //    collidableInterface.moveAwayFromBuilding(this);     //}     }      */
    override def createHudPaintable() : SelectionHudPaintable = {
        val buildingInfoHudPaintable : BuildingInfoHudPaintable = BuildingInfoHudPaintable.getInstance()
        buildingInfoHudPaintable.setBasicColorP(this.allBinaryGameLayerManagerP.getForegroundBasicColor())
        buildingInfoHudPaintable.setRtsLayer(this)
        return buildingInfoHudPaintable
    }

    override def getHudPaintable() : SelectionHudPaintable = {
        val buildingInfoHudPaintable : BuildingInfoHudPaintable = BuildingInfoHudPaintable.getInstance()
        return buildingInfoHudPaintable
    }

    override def getType() : Int = {
        return BuildingLayer.getStaticType()
    }

    //Needed for polyglot do not remove
    override def getRotationAnimationInterface() : RotationAnimation = {
        return super.getRotationAnimationInterface()
    }

    //Needed for polyglot do not remove
    override def setFrame(index : Int) : Unit = {
        super.setFrame(index)
    }

}

object BuildingLayer {
    def createSimulated() : BuildingLayer = {
        val nullAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullAnimationFactory.getFactoryInstance()
        val nullIndexedAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullIndexedAnimationFactory.getFactoryInstance()
        return new BuildingLayer(RemoteInfo.REMOTE_INFO, SimulatedBuildingPropertiesFactory.getInstance(), AdvancedRTSProperties.createPropertiesSimulated(), GroupFactory.getInstance().NULL_GROUP_ARRAY, StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING, Health.NULL_HEALTH, NullRTSFormInputFactory.getInstance(), nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, NullIndexedAnimationFactory.getFactoryInstance(), RectangleFactory.SINGLETON, 0, 0)
    }

    def getStaticType() : Int = {
        return 2
    }

}


