/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.form.RTSFormInput
import _root_.org.allbinary.game.multiplayer.layer.MultiPlayerGameLayer
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.NullIndexedAnimationFactory
import _root_.org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.RotationAnimation
import _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase
import _root_.org.allbinary.game.combat.destroy.DestroyedLayerProcessor
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.identification.GroupFactory
import _root_.org.allbinary.game.input.GameInputInterface
import _root_.org.allbinary.game.input.GameInputProcessor
import _root_.org.allbinary.game.input.GameInputProcessorUtil
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.form.NullRTSFormInputFactory
import _root_.org.allbinary.game.layer.waypoint.Waypoint2LogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointLogHelper
import _root_.org.allbinary.game.layer.waypoint.WaypointRunnableLogHelper
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.view.TileLayerPositionIntoViewPosition
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.view.event.ViewPositionEventHandler
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.LayerDistanceUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.view.ViewPositionBase

/**  *  * @author user  */
class RTSLayer(param_remoteInfo : RemoteInfo, param_groupInterface : Array[Group], param_rootName : String, param_name : String, param_healthInterface : Health, param_rtsFormInput : RTSFormInput, param_animationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_emptyAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_baseAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_buildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_verticleBuildAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface, param_proceduralAnimationInterfaceFactoryInterface : ProceduralAnimationInterfaceFactoryInterface, param_rectangle : Rectangle, param_x : Int, param_y : Int, param_viewPosition : ViewPositionBase) extends MultiPlayerGameLayer(param_remoteInfo, param_groupInterface, param_name, param_rectangle, param_viewPosition) with TickableInterface with GameInputInterface with GameKeyEventSourceInterface with RTSInterface with PathFindingLayerInterface {
    import _root_.org.allbinary.game.layer.RTSLayer.{MAIN_INDEX as _, SECONDARY_INDEX as _, *}
    def MAIN_INDEX : Int = _root_.org.allbinary.game.layer.RTSLayer.MAIN_INDEX
    def SECONDARY_INDEX : Int = _root_.org.allbinary.game.layer.RTSLayer.SECONDARY_INDEX

    val debug : Boolean = true

    val showMoreCaptionStates : Boolean = this.debug

    val inputProcessorArray : Array[GameInputProcessor] = new Array[GameInputProcessor](InputFactory.getInstance().MAX)

    var rtsLayer2LogHelper : RTSLayer2LogHelper = RTSLayer2LogHelper.getInstance()

    var waypointLogHelperP : WaypointLogHelper = WaypointLogHelper.getInstance()

    var waypoint2LogHelperP : Waypoint2LogHelper = Waypoint2LogHelper.getInstance()

    var waypointRunnableLogHelperP : WaypointRunnableLogHelper = WaypointRunnableLogHelper.getInstance()

    private var rtsFormInput : RTSFormInput = null

    private var verticleBuildAnimationInterface : IndexedAnimation = null

    var rangeAnimation : Animation = null

    var initRangeAnimation : Animation = null

    var sensorRangeAnimation : Animation = null

    var initSensorRangeAnimation : Animation = null

    var baseAnimationInterface : Animation = null

    private val buildFrameTimeHelper : TimeDelayHelper = new TimeDelayHelper(50)

    private var buildAnimationInterface : Animation = null

    private var animationInterface : Animation = null

    var initAnimationInterface : IndexedAnimation = null

    var indexedButShouldBeRotationAnimationInterface : IndexedAnimation = null

    var emptyAnimationInterface : IndexedAnimation = null

    var destroyAnimationInterface : IndexedAnimation = null

    val fireTimeHelper : TimeDelayHelper = new TimeDelayHelper(700)

    /*     private static final TimeDelayHelper towersFireTimeHelper = new TimeDelayHelper(50);     if (RTSLayer.towersFireTimeHelper.isTime())     {     }      */
    private var rootName : String = null

    val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private val BUILD_VALUE : Int = 63

    var geographicMapCellPositionAreaBase : GeographicMapCellPositionAreaBase = null

    private var healthInterface : Health = Health.NULL_HEALTH

    private var level : Int = 1

    private var maxLevel : Int = 1

    //Could change to health
    private var hackVerticleBuild : Int = this.BUILD_VALUE

    //private int hackBuild = 0;
    var slightAngle : Int = 0

    var percentCompleteP : Int = 0

    private var destroyed : Boolean = false

    private var selected : Boolean = false

    private val rtsLayerUtil : RTSLayerUtil = RTSLayerUtil.getInstance()

    private val layerDistanceUtil : LayerDistanceUtil = LayerDistanceUtil.getInstance()

    //Constructor
    {
        val remoteInfo : RemoteInfo = param_remoteInfo
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
        this.initInputProcessors()
        this.rootName = rootName
        this.healthInterface = healthInterface
        this.rtsFormInput = rtsFormInput
        //this.setPosition(x - this.getWidth() / 2, y - this.getHeight() / 2);
        this.setPosition(x, y, this.z)
        this.verticleBuildAnimationInterface = verticleBuildAnimationInterfaceFactoryInterface.getInstance(0).asInstanceOf[IndexedAnimation]
        this.buildAnimationInterface = buildAnimationInterfaceFactoryInterface.getInstance(0)
        this.baseAnimationInterface = baseAnimationInterfaceFactoryInterface.getInstance(0)
        this.emptyAnimationInterface = emptyAnimationInterfaceFactoryInterface.getInstance(0).asInstanceOf[IndexedAnimation]
        this.indexedButShouldBeRotationAnimationInterface = animationInterfaceFactoryInterface.getInstance(0).asInstanceOf[IndexedAnimation]
        this.initAnimationInterface = this.indexedButShouldBeRotationAnimationInterface
        this.destroyAnimationInterface = proceduralAnimationInterfaceFactoryInterface.getInstanceAnimation(this.indexedButShouldBeRotationAnimationInterface).asInstanceOf[IndexedAnimation]
        val animation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
        this.rangeAnimation = animation
        this.initRangeAnimation = animation
        this.sensorRangeAnimation = animation
        this.initSensorRangeAnimation = animation
        this.animationInterface = this.initAnimationInterface
        this.geographicMapCellPositionAreaBase = new GeographicMapCellPositionArea(this)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        val viewPosition2 : TileLayerPositionIntoViewPosition = this.getViewPosition().asInstanceOf[TileLayerPositionIntoViewPosition]
        viewPosition2.setTiledLayer(tiledLayer)
        this.updateWaypointBehavior(geographicMapInterface)
    }

    def updateWaypointBehavior(geographicMapInterface : BasicGeographicMap) : Unit = {
        this.geographicMapCellPositionAreaBase.update(geographicMapInterface)
    }

    def construct(rtsPlayerLayerInterface : RTSPlayerLayerInterface) : Unit = {
        ViewPositionEventHandler.getInstance().addListener(this.asInstanceOf[AllBinaryLayer])
        this.animationInterface = this.buildAnimationInterface
        this.hackVerticleBuild = 0
    }

    def select() : Unit = {
        //this.logUtil.putF("selected: ", this, "selected: select");
        this.rangeAnimation = this.initRangeAnimation
        this.sensorRangeAnimation = this.initSensorRangeAnimation
        this.setSelected(true)
    }

    def deselect() : Unit = {
        val animation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
        this.rangeAnimation = animation
        this.sensorRangeAnimation = animation
        this.setSelected(false)
    }

    def setSelected(selected : Boolean) : Unit = {
        this.selected = selected
    }

    override def isSelected() : Boolean = {
        return this.selected
    }

    override def getPercentComplete() : Int = {
        return this.percentCompleteP
    }

    def getScrollSelectionForm() : ScrollSelectionForm = {
        return ScrollSelectionForm.getNullScrollSelectionForm()
    }

    override def initInputProcessors() : Unit = {
        GameInputProcessorUtil.init(this.inputProcessorArray)
    }

    def processBuiltTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        this.animationInterface = this.indexedButShouldBeRotationAnimationInterface
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        try {
            if (this.isCompleted()) {
                this.processBuiltTick(allBinaryLayerManager)
            } else {
                this.build()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "processTick", e)
            }
        }
    }

    override def processInput(layerManager : AllBinaryLayerManager) : Unit = {
    }

    def reload() : Unit = {
    }

    def onMovement(trackingEvent : TrackingEvent) : Unit = {
    }

    def onMovementFound(trackingEvent : TrackingEvent) : Unit = {
    }

    override def paint(graphics : Graphics) : Unit = {
        super.paintFirst(graphics)
        val viewPosition : ViewPositionBase = this.getViewPosition()
        val viewX : Int = viewPosition.getX()
        val viewY : Int = viewPosition.getY()
        this.getAnimationInterface().paintXY(graphics, viewX, viewY)
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
    }

    override def getSourceId() : Int = {
        return RTSLayer.id
    }

    override def downgrade() : Unit = {
        this.rtsLayerUtil.downgrade(this)
    }

    override def upgrade() : Unit = {
        this.rtsLayerUtil.upgrade(this)
    }

    override def isCompleted() : Boolean = {
        if (this.hackVerticleBuild < this.BUILD_VALUE) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    private def build() : Unit = {
        if (this.buildFrameTimeHelper.isTimeTNT()) {
            this.animationInterface = this.buildAnimationInterface
            //this.buildAnimationInterface.nextFrame()
            this.verticleBuildAnimationInterface.nextFrame()
            this.hackVerticleBuild += 1
        }
        this.percentCompleteP = (100 * this.hackVerticleBuild) / this.BUILD_VALUE
        this.getHudPaintable().updateInfo()
    }

    override def isSelfUpgradeable() : Boolean = {
        return true
    }

    override def getCost() : Int = {
        return this.rtsLayerUtil.getCost(this)
    }

    override def getDowngradeCost() : Int = {
        return this.rtsLayerUtil.getDowngradeCost(this)
    }

    override def getUpgradeCost() : Int = {
        return this.rtsLayerUtil.getUpgradeCost(this)
    }

    override def isUpgradeable() : Boolean = {
        if (this.getLevel() < this.getMaxLevel()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def isDowngradeable() : Boolean = {
        if (this.getLevel() > 1) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    /**      * @return the level      */
    override def getLevel() : Int = {
        return this.level
    }

    /**      * @param level the level to set      */
    def setLevel(level : Int) : Unit = {
        this.level = level
    }

    /**      * @return the verticleBuildAnimationInterface      */
    def getVerticleBuildAnimationInterface() : Animation = {
        return this.verticleBuildAnimationInterface
    }

    /**      * @return the animationInterface      */
    def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    /**      * @param animationInterface the animationInterface to set      */
    def setAnimationInterface(animationInterface : Animation) : Unit = {
        this.animationInterface = animationInterface
    }

    override def setTarget(targetGameLayer : PathFindingLayerInterface) : Unit = {
        val anotherTargetDistance : Int = this.layerDistanceUtil.getDistance(this.asInstanceOf[AllBinaryLayer], targetGameLayer.asInstanceOf[AllBinaryLayer])
        val waypointBehaviorBase : WaypointBehaviorBase = this.getWaypointBehavior()
        waypointBehaviorBase.setTargetWithDistance(targetGameLayer.asInstanceOf[PathFindingLayerInterface], anotherTargetDistance)
    }

    def createHudPaintable() : SelectionHudPaintable = {
        throw new RuntimeException()
    }

    override def getHudPaintable() : SelectionHudPaintable = {
        throw new RuntimeException()
    }

    /**      * @return the maxLevel      */
    override def getMaxLevel() : Int = {
        return this.maxLevel
    }

    /**      * @param maxLevel the maxLevel to set      */
    def setMaxLevel(maxLevel : Int) : Unit = {
        this.maxLevel = maxLevel
    }

    /**      * @return the healthInterface      */
    def getHealthInterface() : Health = {
        return this.healthInterface
    }

    /**      * @param healthInterface the healthInterface to set      */
    def setHealthInterface(healthInterface : Health) : Unit = {
        this.healthInterface = healthInterface
    }

    /**      * @return the rtsFormInput      */
    def getRTSFormInput() : RTSFormInput = {
        return this.rtsFormInput
    }

    override def isDestroyed() : Boolean = {
        return this.destroyed
    }

    def setDestroyed(destroyed : Boolean) : Unit = {
        this.destroyed = destroyed
        if (this.isDestroyed()) {
            /*             final StringMaker stringBuffer = new StringMaker();              stringBuffer.append("setDestroyed: ");             stringBuffer.append(this.getName());                          this.logUtil.putF(stringBuffer.toString(), this, "setDestroyed");             */
            DestroyedLayerProcessor.getInstance().add(this)
            ViewPositionEventHandler.getInstance().removeListener(this)
        }
    }

    override def getEndGeographicMapCellPositionList() : BasicArrayList = {
        return this.geographicMapCellPositionAreaBase.getOccupyingGeographicMapCellPositionList()
    }

    override def getGeographicMapCellPositionArea() : GeographicMapCellPositionAreaBase = {
        return this.geographicMapCellPositionAreaBase
    }

    override def shouldHandleStartSameAsEnd() : Boolean = {
        return true
    }

    override def handleCost(ownerLayer : PathFindingLayerInterface) : Unit = {
    }

    override def getWaypointBehavior() : WaypointBehaviorBase = {
        throw new RuntimeException()
    }

    override def getParentLayer() : PathFindingLayerInterface = {
        throw new RuntimeException()
    }

    override def getRTSLayer2LogHelper() : RTSLayer2LogHelper = {
        return this.rtsLayer2LogHelper
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
        return false
    }

    override def getCaptionAnimationHelper() : CaptionAnimationHelperBase = {
        throw new RuntimeException()
    }

    override def isShowMoreCaptionStates() : Boolean = {
        return this.showMoreCaptionStates
    }

    override def init(geographicMapCellHistory : GeographicMapCellHistory, geographicMapCellPositionBasicArrayList : BasicArrayList) : Unit = {
    }

    override def getCurrentGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getTopLeftGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getMoveOutOfBuildAreaPath(geographicMapCellPosition : GeographicMapCellPosition) : BasicArrayList = {
        throw new RuntimeException()
    }

    override def setClosestGeographicMapCellHistory(pathsList : BasicArrayList) : Unit = {
    }

    override def teleportTo(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
    }

    override def setLoad(resource : Int) : Unit = {
    }

    override def getSurroundingGeographicMapCellPositionList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def trackTo(reason : String) : Unit = {
    }

    override def trackToDXY(dx : Int, dy : Int) : Unit = {
    }

    override def isWaypointListEmptyOrOnlyTargets() : Boolean = {
        return false
    }

    override def getTrackingEvent() : TrackingEvent = {
        throw new RuntimeException()
    }

    override def buildingChase(allbinaryLayer : AllBinaryLayer, cellPosition : GeographicMapCellPosition) : Boolean = {
        return false
    }

    override def allStop() : Unit = {
    }

    override def implmentsTickableInterface() : Boolean = {
        return true
    }

    override def implmentsGameInputInterface() : Boolean = {
        return true
    }

    def getRootName() : String = {
        return this.rootName
    }

    /**      * @return the rotationAnimationInterface      */
    def getRotationAnimationInterface() : RotationAnimation = {
        return this.indexedButShouldBeRotationAnimationInterface.asInstanceOf[RotationAnimation]
    }

    def setFrame(index : Int) : Unit = {
        this.getRotationAnimationInterface().setFrame(index)
    }

    /**      * @param rotationAnimationInterface the rotationAnimationInterface to set      */
    def setRotationAnimationInterface(rotationAnimationInterface : RotationAnimation) : Unit = {
        this.indexedButShouldBeRotationAnimationInterface = rotationAnimationInterface
    }

}

object RTSLayer {
    //used to simulate cost
    def createSimulatedInstance(remoteInfo : RemoteInfo) : RTSLayer = {
        val nullAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullAnimationFactory.getFactoryInstance()
        val nullIndexedAnimationInterfaceFactoryInterface : AnimationInterfaceFactoryInterface = NullIndexedAnimationFactory.getFactoryInstance()
        return new RTSLayer(RemoteInfo.REMOTE_INFO, GroupFactory.getInstance().NULL_GROUP_ARRAY, StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING, Health.NULL_HEALTH, NullRTSFormInputFactory.getInstance(), nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullAnimationInterfaceFactoryInterface, nullIndexedAnimationInterfaceFactoryInterface, NullIndexedAnimationFactory.getFactoryInstance(), RectangleFactory.SINGLETON, 0, 0, new TileLayerPositionIntoViewPosition())
    }

    private val id : Int = 0

    val MAIN_INDEX : Int = 0

    val SECONDARY_INDEX : Int = 1

    def getMinStaticType() : Int = {
        return 1
    }

    def getMaxStaticType() : Int = {
        return 4
    }

    def isRTSLayer(layerInterface : AllBinaryLayer) : Boolean = {
        if ((layerInterface.getType() >= RTSLayer.getMinStaticType()) && (layerInterface.getType() <= RTSLayer.getMaxStaticType())) {
            return true
        }
        return false
    }

}


