/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geographic.map

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.animation.vector.CircleFilledAnimation
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.ColorCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEvent
import _root_.org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEventHandler
import _root_.org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEventListenerInterface
import _root_.org.allbinary.view.ViewPositionBase

class MiniMapLayer(param_geographicMapInterface : BasicGeographicMap, param_viewPosition : ViewPositionBase) extends AllBinaryLayer(StringUtil.getInstance().EMPTY_STRING, new Rectangle(PointFactory.getInstance().createXY(0, param_viewPosition.getY()), param_geographicMapInterface.getAllBinaryTiledLayer().getWidth(), param_geographicMapInterface.getAllBinaryTiledLayer().getHeight()), param_viewPosition) with GeographicMapCellPositionEventListenerInterface {

    //private final SimpleGeographicMap simpleGeographicMap;
    var allBinaryTiledLayer : AllBinaryTiledLayer = null

    private var geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = null

    private var list : BasicArrayList = null

    private var basicColorList : BasicArrayList = null

    private var positionList : BasicArrayList = null

    private var animationInterface : CircleFilledAnimation = null

    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val viewPosition : ViewPositionBase = param_viewPosition
        //this.simpleGeographicMap = simpleGeographicMap;
        this.allBinaryTiledLayer = geographicMapInterface.getAllBinaryTiledLayer()
        this.geographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
        this.animationInterface = new CircleFilledAnimation(this.allBinaryTiledLayer.getCellWidth(), this.allBinaryTiledLayer.getCellHeight(), BasicColorFactory.getInstance().WHITE)
        //this.logUtil.put("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Alpha: " + this.bufferedImage.getBitmap().getPixel(0,0), this, "updateBufferedImage");
        this.list = new BasicArrayListD()
        this.basicColorList = new BasicArrayListD()
        this.positionList = new BasicArrayListD()
        // geographicMapInterface.getGeographicMapCellPositionFactory();
        GeographicMapCellPositionEventHandler.getInstance().addListener(this)
        this.init()
    }

    def init() : Unit = {
        this.allBinaryTiledLayer.setPosition(this.x, this.y, this.z)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onRemoveGeographicMapCellPositionEvent(geographicMapCellPositionEvent : GeographicMapCellPositionEvent) : Unit = this.synchronized {
        val colorCompositeInterface : ColorCompositeInterface = geographicMapCellPositionEvent.getSource().asInstanceOf[ColorCompositeInterface]
        val index : Int = this.list.indexOf(colorCompositeInterface)
        if (index >= 0) {
            this.list.removeAt(index)
            this.basicColorList.removeAt(index)
            this.positionList.removeAt(index)
        }
    }

    override def onGeographicMapCellPositionEvent(geographicMapCellPositionEvent : GeographicMapCellPositionEvent) : Unit = this.synchronized {
        //this.logUtil.putF(this.commonStrings.START, this, "onEvent");
        val colorCompositeInterface : ColorCompositeInterface = geographicMapCellPositionEvent.getSource().asInstanceOf[ColorCompositeInterface]
        var layerIndex : Int = -1
        var size : Int = this.list.size()
        var nextColorCompositeInterface : ColorCompositeInterface = null

        {
            var index : Int = 0
            scala.util.boundary { (break_N71544 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    nextColorCompositeInterface = this.list.get(index).asInstanceOf[ColorCompositeInterface]
                    if (nextColorCompositeInterface eq colorCompositeInterface) {
                        layerIndex = index
                        scala.util.boundary.break()(using break_N71544)
                    }
                    index += 1
                }
            }
        }
        val geographicMapCellPosition : GeographicMapCellPosition = this.geographicMapCellPositionFactory.getInstance(geographicMapCellPositionEvent.getGeographicMapCellPosition())
        var point : GPoint = geographicMapCellPosition.getPoint()
        if (layerIndex == -1) {
            this.list.add(colorCompositeInterface)
            var basicColor : BasicColor = colorCompositeInterface.getBasicColorP()
            this.basicColorList.add(basicColor)
            this.positionList.add(point)
            layerIndex = this.basicColorList.size() - 1
        } else {
            //update
            this.positionList.set(layerIndex, point)
        }
    }

    //private final int clearColor = BasicColor.CLEAR_COLOR.intValue();
    def paintDots(graphics : Graphics) : Unit = {
        val localPositionList : BasicArrayList = this.positionList
        val localBasicColorList : BasicArrayList = this.basicColorList
        val length : Int = localPositionList.size()
        //int localY;
        var point : GPoint = null
        var basicColor : BasicColor = null

        {
            var index : Int = length
            while ({ index -= 1; index } >= 0) {
                point = localPositionList.get(index).asInstanceOf[GPoint]
                basicColor = localBasicColorList.get(index).asInstanceOf[BasicColor]
                graphics.setColor(basicColor.intValue())
                //localY = point.getYP();
                this.animationInterface.setBasicColorP(basicColor)
                this.animationInterface.paintXY(graphics, point.getX() + this.x, point.getY() + this.y)
            }
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        this.allBinaryTiledLayer.paint(graphics)
        this.paintDots(graphics)
    }

}


