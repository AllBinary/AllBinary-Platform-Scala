/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.layer.SteeringVisitor
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.CollidableRTSBehavior
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.layer.TiledLayerUtil
import _root_.org.allbinary.game.layer.geographic.map.LayerPartialCellPositionsUtil
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.drop.DropCellPositionHistory
import _root_.org.allbinary.string.CommonStrings

class CollidableUnitBehavior(param_collidable : Boolean) extends CollidableRTSBehavior(param_collidable) {

    private val layerPartialCellPositionsUtil : LayerPartialCellPositionsUtil = LayerPartialCellPositionsUtil.getInstance()

    private val simpleSteeringVisitor : SimpleSteeringVisitor = new SimpleSteeringVisitor()

    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    //Collision with RTSLayers or other none damage game objects
    override def collideNone(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        //this.logUtil.putF(CommonLabels.getInstance().START + collidableInterface.getName(), this, "collideNone");
        this.chase(ownerLayer, collidableInterfaceCompositeInterface)
        val rtsLayer : AdvancedRTSGameLayer = collidableInterfaceCompositeInterface.asInstanceOf[AdvancedRTSGameLayer]
        if (rtsLayer.getType() == UnitLayer.getStaticType()) {
            this.collideUnit(ownerLayer, rtsLayer.asInstanceOf[UnitLayer])
        }
    }

    class SimpleSteeringVisitor extends SteeringVisitor {

        override def visit(anyType : Object) : Object = {
            val logUtil : LogUtil = LogUtil.getInstance()
            try {
                val ownerLayer : CollidableCompositeLayer = anyType.asInstanceOf[CollidableCompositeLayer]
                if (this.getList().size() > 0) {
                    ///logUtil.putF("steering", this, "visit");
                    val allbinaryLayer : CollidableCompositeLayer = this.getList().get(0).asInstanceOf[CollidableCompositeLayer]
                    var clear : Boolean = CollidableUnitBehavior.this.steer(ownerLayer, allbinaryLayer)
                    if (clear) {
                        this.getList().clear()
                        return NullUtil.getInstance().NULL_OBJECT
                    }
                    return BooleanFactory.getInstance().TRUE
                }
                return NullUtil.getInstance().NULL_OBJECT
            } catch {
                case e : Exception => {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, this, "visit", e)
                    return NullUtil.getInstance().NULL_OBJECT
                }
            }
            throw new IllegalStateException()
        }

    }

    private def steer(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Boolean = {
        //this.logUtil.putF("Unit: " + collidableInterface.getName(), this, "chase");
        val ownerUnitLayer : UnitLayer = ownerLayer.asInstanceOf[UnitLayer]
        val unitLayer : UnitLayer = collidableInterfaceCompositeInterface.asInstanceOf[UnitLayer]
        val angleInfo2 : AngleInfo = unitLayer.getRotationAnimationInterface().getAngleInfoP()
        //Since buildings don't move just turn to go around
        val angleInfo : AngleInfo = ownerUnitLayer.getRotationAnimationInterface().getAngleInfoP()
        val angle : Int = angleInfo.getAngle() - angleInfo2.getAngle()
        //this.logUtil.putF("Unit: " + collidableInterface.getName(), this, "chase");
        if ((angle < 90) || (angle > 270)) {
            return true
        } else if ((angle >= 90) || (angle <= 270)) {
            ownerUnitLayer.getGameKeyEventList().add(GameKeyEventFactory.getInstance().getInstanceForKey(ownerUnitLayer, Canvas.RIGHT))
            return false
        }
        throw new Exception("Error")
    }

    //This allows units to go around other units that it collides with
    private def chase(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        //this.logUtil.putF(CommonLabels.getInstance().START + collidableInterface.getName(), this, "chase");
        val rtsLayer : AdvancedRTSGameLayer = collidableInterfaceCompositeInterface.asInstanceOf[AdvancedRTSGameLayer]
        if (rtsLayer.getType() == UnitLayer.getStaticType()) {
            if (!this.simpleSteeringVisitor.getList().contains(collidableInterfaceCompositeInterface)) {
                this.simpleSteeringVisitor.getList().add(collidableInterfaceCompositeInterface)
            }
            val ownerUnitLayer : UnitLayer = ownerLayer.asInstanceOf[UnitLayer]
            val list : BasicArrayList = ownerUnitLayer.getUnitWaypointBehavior().getSteeringVisitorList()
            if (!list.contains(this.simpleSteeringVisitor)) {
                list.add(this.simpleSteeringVisitor)
            }
        }
    }

    def collideUnit(ownerLayer : CollidableCompositeLayer, unitLayer : UnitLayer) : Unit = {
        val ownerUnitLayer : UnitLayer = ownerLayer.asInstanceOf[UnitLayer]
        val partialPositionList : BasicArrayList = UnitLayer.getPartialpositionlist()
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = ownerUnitLayer.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val basicGeographicMap : BasicGeographicMap = geographicMapInterface
        //        }
        val dropCellPositionHistory : DropCellPositionHistory = DropCellPositionHistory.getInstance()
        val tiledLayerUtil : TiledLayerUtil = TiledLayerUtil.getInstance()
        val tiledLayer : AllBinaryTiledLayer = basicGeographicMap.getAllBinaryTiledLayer()
        if ((ownerLayer.getXP() < unitLayer.getXP()) && (ownerLayer.getX2() > unitLayer.getXP())) {
            val diff : Int = ownerLayer.getWidth() + 1
            this.layerPartialCellPositionsUtil.getAllDXY(basicGeographicMap, ownerLayer, -diff, 0, partialPositionList)
            if (!dropCellPositionHistory.anyCellPositionWithDrop(partialPositionList)) {
                var x : Int = unitLayer.getXP() - diff
                var y : Int = ownerLayer.getYP()
                x = tiledLayerUtil.keepOnMapX(tiledLayer, x, ownerLayer.getWidth())
                y = tiledLayerUtil.keepOnMapY(tiledLayer, y, ownerLayer.getHeight())
                ownerLayer.setPosition(x, y, ownerLayer.getZP())
            }
            this.layerPartialCellPositionsUtil.getAllDXY(basicGeographicMap, unitLayer, diff, 0, partialPositionList)
            if (!dropCellPositionHistory.anyCellPositionWithDrop(partialPositionList)) {
                var x : Int = unitLayer.getXP() + diff
                var y : Int = unitLayer.getYP()
                x = tiledLayerUtil.keepOnMapX(tiledLayer, x, unitLayer.getWidth())
                y = tiledLayerUtil.keepOnMapY(tiledLayer, y, unitLayer.getHeight())
                unitLayer.setPosition(x, y, unitLayer.getZP())
            }
        }
        if ((ownerLayer.getYP() < unitLayer.getYP()) && (ownerLayer.getY2() > unitLayer.getYP())) {
            var diff : Int = ownerLayer.getHeight() + 1
            this.layerPartialCellPositionsUtil.getAllDXY(basicGeographicMap, ownerLayer, 0, -diff, partialPositionList)
            if (!dropCellPositionHistory.anyCellPositionWithDrop(partialPositionList)) {
                var x : Int = ownerLayer.getXP()
                var y : Int = unitLayer.getYP() - diff
                x = tiledLayerUtil.keepOnMapX(tiledLayer, x, ownerLayer.getWidth())
                y = tiledLayerUtil.keepOnMapY(tiledLayer, y, ownerLayer.getHeight())
                ownerLayer.setPosition(x, y, ownerLayer.getZP())
            }
            this.layerPartialCellPositionsUtil.getAllDXY(basicGeographicMap, unitLayer, 0, diff, partialPositionList)
            if (!dropCellPositionHistory.anyCellPositionWithDrop(partialPositionList)) {
                var x : Int = unitLayer.getXP()
                var y : Int = unitLayer.getYP() + diff
                x = tiledLayerUtil.keepOnMapX(tiledLayer, x, unitLayer.getWidth())
                y = tiledLayerUtil.keepOnMapY(tiledLayer, y, unitLayer.getHeight())
                unitLayer.setPosition(x, y, unitLayer.getZP())
            }
        }
    }

}


