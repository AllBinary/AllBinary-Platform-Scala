/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.util.BasicArrayList

class PathAnimation(param_pathFindingLayer : PathFindingLayerInterface, param_linePathAnimation : LinePathAnimation) extends Animation {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var linePathAnimation : LinePathAnimation = null

    private var pathFindingLayer : PathFindingLayerInterface = null

    var allBinaryGameLayerManagerP : AllBinaryGameLayerManager = AllBinaryGameLayerManager.getNullInstance()

    private val startColor : BasicColor = BasicColorFactory.getInstance().RED

    private val middleColor : BasicColor = BasicColorFactory.getInstance().BLUE

    private val endColor : BasicColor = BasicColorFactory.getInstance().GREEN

    //Constructor
    {
        val pathFindingLayer : PathFindingLayerInterface = param_pathFindingLayer
        val linePathAnimation : LinePathAnimation = param_linePathAnimation
        this.pathFindingLayer = pathFindingLayer
        this.linePathAnimation = linePathAnimation
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        this.allBinaryGameLayerManagerP = allBinaryGameLayerManager
    }

    override def nextFrame() : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        try {
            val waypointBehaviorBase : WaypointBehaviorBase = this.pathFindingLayer.getWaypointBehavior()
            if (waypointBehaviorBase != null) {
                val geographicMapCellHistory : GeographicMapCellHistory = waypointBehaviorBase.getCurrentGeographicMapCellHistory()
                val list : BasicArrayList = geographicMapCellHistory.getTracked()
                val size : Int = list.size()
                if (size > 0) {
                    //final CommonSeps commonSeps = CommonSeps.getInstance();
                    val geographicMapCompositeInterface : GeographicMapCompositeInterface = this.allBinaryGameLayerManagerP.asInstanceOf[GeographicMapCompositeInterface]
                    val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
                    val tiledLayer : AllBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
                    var geographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                    // = geographicMapCellPosition.getMidPoint();
                    var nextPoint : GPoint = null
                    //(GeographicMapCellPosition) list.get(list.size() - 1);
                    var point : GPoint = null
                    var start : Int = size - 2

                    {
                        var index : Int = 0
                        while (index < (size - 1)) {
                            if (index == start) {
                                this.setBasicColorP(this.startColor)
                                this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
                            } else if (geographicMapCellHistory.isVisited(geographicMapCellPosition)) {
                                this.setBasicColorP(this.endColor)
                                this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
                            } else {
                                this.setBasicColorP(this.middleColor)
                                this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
                            }
                            geographicMapCellPosition = list.get(index).asInstanceOf[GeographicMapCellPosition]
                            //final RaceTrackGeographicMapCellType geographicMapCellType = (RaceTrackGeographicMapCellType) geographicMapInterface.getCellTypeAt(geographicMapCellPosition);
                            point = geographicMapCellPosition.getMidPoint()
                            geographicMapCellPosition = list.get(index + 1).asInstanceOf[GeographicMapCellPosition]
                            //final RaceTrackGeographicMapCellType geographicMapCellType = (RaceTrackGeographicMapCellType) geographicMapInterface.getCellTypeAt(geographicMapCellPosition);
                            nextPoint = geographicMapCellPosition.getMidPoint()
                            this.linePathAnimation.paint(graphics, point, nextPoint, tiledLayer)
                            index += 1
                        }
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.putF("Cleared Target", this, CanvasStrings.getInstance().PAINT)
            }
        }
    }

}


