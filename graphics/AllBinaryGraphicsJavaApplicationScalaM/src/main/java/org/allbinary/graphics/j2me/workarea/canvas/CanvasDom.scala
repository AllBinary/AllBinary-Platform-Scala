/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas

import _root_.java.util.HashMap
import _root_.org.allbinary.animation.vector.VectorCenterGenerator
import _root_.org.allbinary.dom.DomHelper
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.GraphicsStrings
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanel
import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemFactory
import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemInterface
import _root_.org.allbinary.graphics.j2me.workarea.tools.LinesGraphicItem
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Node

class CanvasDom private () {
    import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.{FRAME as _, ROTATE as _, SIZE as _, X as _, Y as _, ZOOM as _, GRID as _, ENABLED as _, POSSIBLE as _, GRAPHICITEMS as _, REAL_SIZE as _, *}
    def FRAME : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.FRAME
    def ROTATE : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ROTATE
    def SIZE : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.SIZE
    def X : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.X
    def Y : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.Y
    def ZOOM : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ZOOM
    def GRID : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRID
    def ENABLED : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ENABLED
    def POSSIBLE : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.POSSIBLE
    def GRAPHICITEMS : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRAPHICITEMS
    def REAL_SIZE : String = _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.REAL_SIZE

    //Dom Nodes
    private val graphicsStrings : GraphicsStrings = GraphicsStrings.getInstance()

    // public static final String WORKAREA = "workArea";
    private var graphicItemHashMap : HashMap[Object, Object] = null

    private var angle : Double = 0.0

    private var dimension : IntegerDimension = null

    private var grid : Grid = null

    //For loading a canvas from a file
    def this(canvasNode : Node) = {
        this()
        this.grid = new Grid()
        this.grid.grid = PointFactory.getInstance().createXY(0, 0)
        this.dimension = new IntegerDimension(0, 0)
        var name : String = canvasNode.getNodeName()
        if (name.compareTo(CanvasDom.FRAME) == 0) {
            this.graphicItemHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var angleNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ROTATE, canvasNode.getChildNodes())
            var angleTextNode : Node = angleNode.getFirstChild()
            var angle : Double = new _root_.java.lang.Double(angleTextNode.getNodeValue()).doubleValue()
            this.setAngle(angle)
            var sizeNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.SIZE, canvasNode.getChildNodes())
            var xNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.X, sizeNode.getChildNodes())
            var xTextNode : Node = xNode.getFirstChild()
            var x : Int = new Integer(xTextNode.getNodeValue()).intValue()
            var yNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.Y, sizeNode.getChildNodes())
            var yTextNode : Node = yNode.getFirstChild()
            var y : Int = new Integer(yTextNode.getNodeValue()).intValue()
            this.setWorkArea(x, y)
            var zoomNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ZOOM, canvasNode.getChildNodes())
            var zoomTextNode : Node = zoomNode.getFirstChild()
            this.grid.setZoom(new Integer(zoomTextNode.getNodeValue()).intValue())
            var gridNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRID, canvasNode.getChildNodes())
            var gridSizeNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.SIZE, gridNode.getChildNodes())
            var gridXNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.X, gridSizeNode.getChildNodes())
            var gridXTextNode : Node = gridXNode.getFirstChild()
            var gridX : Int = new Integer(gridXTextNode.getNodeValue()).intValue()
            var gridYNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.Y, gridSizeNode.getChildNodes())
            var gridYTextNode : Node = gridYNode.getFirstChild()
            var gridY : Int = new Integer(gridYTextNode.getNodeValue()).intValue()
            this.setGrid(gridX, gridY)
            var enableNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ENABLED, gridNode.getChildNodes())
            var enableTextNode : Node = enableNode.getFirstChild()
            this.grid.showGrid(new _root_.java.lang.Boolean(enableTextNode.getNodeValue()).booleanValue())
            var possibleNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.POSSIBLE, gridNode.getChildNodes())
            var possibleTextNode : Node = possibleNode.getFirstChild()
            this.grid.isGridPossible_Grid = new _root_.java.lang.Boolean(possibleTextNode.getNodeValue()).booleanValue()
            var graphicItemNodeList : BasicArrayList = DomHelper.getInstance().getChildrenWithoutTextNodes(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRAPHICITEMS, canvasNode.getChildNodes())
            if (graphicItemNodeList != null) {
                this.graphicItemHashMap = GraphicItemFactory.getInstance().getInstance(graphicItemNodeList).asInstanceOf[HashMap[Object, Object]]
            }
        } else {
            throw new Exception("Frame Element Not Found but Found: " + name)
        }
    }

    //for exporting or saving a canvas to a file
    def this(canvasJPanel : CanvasJPanel) = {
        this()
        this.angle = canvasJPanel.getAngle()
        this.graphicItemHashMap = canvasJPanel.getGraphicItemHashMap().asInstanceOf[HashMap[Object, Object]]
        this.dimension = canvasJPanel.getCanvasDimension()
        this.grid = new Grid(canvasJPanel.getGrid())
        this.angle = canvasJPanel.getAngle()
    }

    /*     public int getXPixelsPerWorkAreaPixel()     {     return this.xPixelsPerWorkArea;     }      public int getYPixelsPerWorkAreaPixel()     {     return this.yPixelsPerWorkArea;     }      */
    def getAngle() : Double = {
        return this.angle
    }

    def getGraphicItemHashMap() : HashMap[Object, Object] = {
        return this.graphicItemHashMap
    }

    def setAngle(angle : Double) : Unit = {
        this.angle = angle
    }

    def setWorkArea(x : Int, y : Int) : Unit = {
        this.setDimension(new IntegerDimension(x, y))
    }

    def setGrid(gridX : Int, gridY : Int) : Unit = {
        this.grid.grid = PointFactory.getInstance().createXY(gridX, gridY)
    }

    private def getPointNode(point : GPoint, pointName : String) : Node = {
        var document : _root_.org.w3c.dom.Document = WorkAreaJPanel.getDocument()
        var pointNode : Node = document.createElement(pointName).asInstanceOf[Node]
        var xNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.X).asInstanceOf[Node]
        var xTextNode : Node = document.createTextNode(Integer.toString(point.getX())).asInstanceOf[Node]
        xNode.appendChild(xTextNode)
        var yNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.Y).asInstanceOf[Node]
        var yTextNode : Node = document.createTextNode(Integer.toString(point.getY())).asInstanceOf[Node]
        yNode.appendChild(yTextNode)
        pointNode.appendChild(xNode)
        pointNode.appendChild(yNode)
        return pointNode
    }

    //used for saving and exporting a canvas in a workarea
    def toDom() : Node = {
        var document : _root_.org.w3c.dom.Document = WorkAreaJPanel.getDocument()
        var frameNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.FRAME).asInstanceOf[Node]
        var angleNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ROTATE).asInstanceOf[Node]
        var angleTextNode : Node = document.createTextNode(new _root_.java.lang.Double(this.getAngle()).toString()).asInstanceOf[Node]
        angleNode.appendChild(angleTextNode)
        var sizeNode : Node = this.getPointNode(PointFactory.getInstance().createXY(this.getDimension().getWidth(), this.getDimension().getHeight()), _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.SIZE).asInstanceOf[Node]
        var zoomNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ZOOM).asInstanceOf[Node]
        var zoomTextNode : Node = document.createTextNode(new Integer(this.getGrid().getZoom()).toString()).asInstanceOf[Node]
        zoomNode.appendChild(zoomTextNode)
        var gridNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRID).asInstanceOf[Node]
        var gridSizeNode : Node = this.getPointNode(this.getGrid().grid, _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.SIZE).asInstanceOf[Node]
        gridNode.appendChild(gridSizeNode)
        var enableNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.ENABLED).asInstanceOf[Node]
        var enableTextNode : Node = document.createTextNode(new _root_.java.lang.Boolean(this.getGrid().isGridOn()).toString()).asInstanceOf[Node]
        enableNode.appendChild(enableTextNode)
        gridNode.appendChild(enableNode)
        var possibleNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.POSSIBLE).asInstanceOf[Node]
        var possibleTextNode : Node = document.createTextNode(new _root_.java.lang.Boolean(this.getGrid().isGridPossible()).toString()).asInstanceOf[Node]
        possibleNode.appendChild(possibleTextNode)
        gridNode.appendChild(possibleNode)
        var realSizeNode : Node = document.createElement(REAL_SIZE).asInstanceOf[Node]
        var vectorCenterGenerator : VectorCenterGenerator = new VectorCenterGenerator()
        vectorCenterGenerator.calculate(this.getGraphicItemHashMap())
        var widthNode : Node = document.createElement(this.graphicsStrings.WIDTH).asInstanceOf[Node]
        var widthTextNode : Node = document.createTextNode(Integer.toString(vectorCenterGenerator.getWidth())).asInstanceOf[Node]
        widthNode.appendChild(widthTextNode)
        realSizeNode.appendChild(widthNode)
        var heightNode : Node = document.createElement(this.graphicsStrings.HEIGHT).asInstanceOf[Node]
        var heightTextNode : Node = document.createTextNode(Integer.toString(vectorCenterGenerator.getHeight())).asInstanceOf[Node]
        heightNode.appendChild(heightTextNode)
        realSizeNode.appendChild(heightNode)
        frameNode.appendChild(angleNode)
        frameNode.appendChild(sizeNode)
        frameNode.appendChild(zoomNode)
        frameNode.appendChild(gridNode)
        frameNode.appendChild(realSizeNode)
        var graphicItemNode : Node = document.createElement(_root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom.GRAPHICITEMS).asInstanceOf[Node]
        val graphicItemArray : Array[Object] = this.getGraphicItemHashMap().keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = this.graphicItemHashMap.get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                if (item.getName() eq LinesGraphicItem.getStaticName()) {
                    if (item.isValid()) {
                        graphicItemNode.appendChild(item.toDom(this))
                    }
                }
                index += 1
            }
        }
        frameNode.appendChild(graphicItemNode)
        return frameNode
    }

    def getDimension() : IntegerDimension = {
        return this.dimension
    }

    def setDimension(dimension : IntegerDimension) : Unit = {
        this.dimension = dimension
    }

    /**      * @return the grid      */
    def getGrid() : Grid = {
        return this.grid
    }

}

object CanvasDom {
    val FRAME : String = "frame"

    val ROTATE : String = "rotate"

    val SIZE : String = "size"

    val X : String = "X"

    val Y : String = "Y"

    val ZOOM : String = "zoom"

    val GRID : String = "grid"

    //y
    val ENABLED : String = "enabled"

    val POSSIBLE : String = "possible"

    val GRAPHICITEMS : String = "graphicItems"

    val REAL_SIZE : String = "realSize"

}


