/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.java.awt.*
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.javax.swing.tree.MutableTreeNode
import _root_.org.allbinary.dom.DomHelper
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.j2me.StatusFactory
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom
import _root_.org.allbinary.graphics.j2me.workarea.canvas.IntegerDimension
import _root_.org.allbinary.graphics.pipeline.BasicGraphicsPipeline
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class LinesGraphicItem() extends GraphicItemInterface {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.LinesGraphicItem.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    private var treeNode : DefaultMutableTreeNode = null

    private var pointTreeNodeVector : BasicArrayList = null

    private var currentMousePoint : GPoint = null

    private var fulcrumPoint : GPoint = null

    private var active : Boolean = false

    private var theta : Double = 0

    //private int tempAngle = 0;
    private var color : Color = new Color(BasicColorFactory.getInstance().WHITE.intValue())

    private var points : Points = null

    //Constructor
    {
        this.points = new Points()
        try {
            this.init()
            this.active = true
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    def this(linesNode : Node) = {
        this()
        this.points = new Points()
        this.init()
        this.active = false
        var lineNodes : BasicArrayList = DomHelper.getInstance().getWithoutTextNodes(linesNode.getChildNodes())
        var numberOfLines : Int = lineNodes.size()

        {
            var index : Int = 0
            while (index < numberOfLines) {
                var lineNode : Node = lineNodes.get(index).asInstanceOf[Node]
                var pointNodes : BasicArrayList = DomHelper.getInstance().getWithoutTextNodes(lineNode.getChildNodes())
                var pointOneNode : Node = DomHelper.getInstance().searchNodeList(PointsDomUtil.getInstance().POINTONE, pointNodes)
                this.addPoint(pointOneNode.getChildNodes())
                if (index == (numberOfLines - 1)) {
                    var pointTwoNode : Node = DomHelper.getInstance().searchNodeList(PointsDomUtil.getInstance().POINTTWO, pointNodes)
                    this.addPoint(pointTwoNode.getChildNodes())
                }
                index += 1
            }
        }
        if (numberOfLines == 0) {
            throw new Exception("Lines node does not contain a line")
        }
    }

    def init() : Unit = {
        this.treeNode = new DefaultMutableTreeNode(PointsDomUtil.getInstance().LINES + LinesGraphicItem.item)
        LinesGraphicItem.item += 1
        this.points.init()
        this.pointTreeNodeVector = new BasicArrayListD()
        this.fulcrumPoint = PointFactory.getInstance().createXY(0, 0)
    }

    def translate(x : Int, y : Int) : Unit = {
        StatusFactory.getInstance().setStatus("Translating: " + this.points.getPoints())
        var basicGraphicsPipeline : BasicGraphicsPipeline = new BasicGraphicsPipeline(this.points.getPoints())
        basicGraphicsPipeline.translate(x, y)
        this.points = new Points()
        this.points.addPoints(basicGraphicsPipeline.getMatrix())
    }

    def setRotate(param_theta : Double) : Unit = {
        var theta : Double = param_theta

        {
            while (theta > (2 * Math.PI)) {
                theta -= 2 * Math.PI
            }
        }

        {
            while (theta < 0) {
                theta += 2 * Math.PI
            }
        }
        this.theta = theta
    }

    def addRotate(theta : Double) : Unit = {
        this.setRotate(this.theta + theta)
    }

    def setAngle(angle : Double) : Unit = {
        this.setRotate(Math.toRadians(angle))
    }

    def addAngle(angle : Double) : Unit = {
        this.setRotate(this.theta + Math.toRadians(angle))
    }

    def getTreeNode() : MutableTreeNode = {
        return this.treeNode.asInstanceOf[MutableTreeNode]
    }

    def getName() : String = {
        return LinesGraphicItem.NAME
    }

    private def addPoint(pointNodes : NodeList) : Unit = this.synchronized {
        var list : BasicArrayList = DomHelper.getInstance().getWithoutTextNodes(pointNodes)
        var xNode : Node = DomHelper.getInstance().searchNodeList(PositionStrings.getInstance().X, list)
        var xTextNode : Node = xNode.getFirstChild()
        var xInteger : Integer = new Integer(xTextNode.getNodeValue())
        var yNode : Node = DomHelper.getInstance().searchNodeList(PositionStrings.getInstance().Y, list)
        var yTextNode : Node = yNode.getFirstChild()
        var yInteger : Integer = new Integer(yTextNode.getNodeValue())
        var point : GPoint = PointFactory.getInstance().createXY(xInteger.intValue(), yInteger.intValue())
        this.addPoint(point)
    }

    def addPoint(point : GPoint) : Unit = this.synchronized {
        this.points.getPoints().add(point)
        this.logUtil.putF(point.toString(), this, "addPoint")
        this.pointTreeNodeVector.add(new DefaultMutableTreeNode(point.toString()))
        this.treeNode.add(this.pointTreeNodeVector.get(this.pointTreeNodeVector.size() - 1).asInstanceOf[DefaultMutableTreeNode])
    }

    def removePoint() : GPoint = this.synchronized {
        var point : GPoint = null
        if (this.points.getSize() > 0) {
            var lastPoint : Int = this.points.getSize() - 1
            point = this.points.getPoints().removeAt(lastPoint).asInstanceOf[GPoint]
            var index : Int = this.pointTreeNodeVector.size() - 1
            if (index > 0) {
                this.treeNode.remove(this.pointTreeNodeVector.get(index).asInstanceOf[DefaultMutableTreeNode])
                this.pointTreeNodeVector.remove(Integer.valueOf(index))
            }
        }
        return point
    }

    def isActive() : Boolean = {
        return this.active
    }

    def deactivate() : Unit = {
        this.active = false
    }

    def activate() : Unit = {
        this.active = true
    }

    def duplicatePoints(list : BasicArrayList) : Unit = {
        var size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                var point : GPoint = list.get(index).asInstanceOf[GPoint]
                if (point != null) {
                    this.points.getPoints().add(PointFactory.getInstance().createXY(point.getX(), point.getY()))
                    this.pointTreeNodeVector.add(new DefaultMutableTreeNode(point.toString()))
                    this.treeNode.add(this.pointTreeNodeVector.get(this.pointTreeNodeVector.size() - 1).asInstanceOf[DefaultMutableTreeNode])
                }
                index += 1
            }
        }
    }

    def duplicate() : GraphicItemInterface = {
        var linesGraphicItem : LinesGraphicItem = new LinesGraphicItem()
        linesGraphicItem.duplicatePoints(this.points.getPoints())
        linesGraphicItem.deactivate()
        return linesGraphicItem
    }

    def getAngle() : Double = {
        return Math.toDegrees(this.theta)
    }

    def setFulcrumPoint(point : GPoint) : Unit = {
        this.fulcrumPoint = point
    }

    def paint(g : Graphics, canvasAngle : _root_.java.lang.Double, dimension : IntegerDimension, x : Int, y : Int) : Unit = {
        try {
            var graphics : Graphics2D = g.asInstanceOf[Graphics2D]
            graphics.setColor(getColor())
            graphics.setStroke(new BasicStroke(x))
            if (this.isActive() && (this.currentMousePoint != null)) {
                this.points.getPoints().add(this.currentMousePoint)
            }
            var tempPointVector : BasicArrayList = PointsUtil.getInstance().doTransforms(this.points.getPoints(), canvasAngle, PointFactory.getInstance().createXY(dimension.getWidth(), dimension.getHeight()))
            if (this.isActive() && (this.currentMousePoint != null)) {
                this.currentMousePoint = this.points.getPoints().removeAt(this.points.getSize() - 1).asInstanceOf[GPoint]
            }
            var size : Int = tempPointVector.size()
            var firstPoint : GPoint = null
            if (size > 0) {
                firstPoint = tempPointVector.get(0).asInstanceOf[GPoint]
            }

            {
                var index : Int = 1
                while (index < size) {
                    var secondPoint : GPoint = tempPointVector.get(index).asInstanceOf[GPoint]
                    graphics.drawLine((firstPoint.getX() * x) - (x / 4), (firstPoint.getY() * y) - (y / 4), (secondPoint.getX() * x) - (x / 4), (secondPoint.getY() * y) - (y / 4))
                    firstPoint = secondPoint
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "mouseMoved", e)
            }
        }
    }

    def toDom(canvasDom : CanvasDom) : Node = {
        return PointsDomUtil.getInstance().toDom(canvasDom, this.points.getPoints())
    }

    def isValid() : Boolean = {
        return this.points.isValid()
    }

    def getPointsInterface() : Points = {
        return this.points
    }

    def setPointsInterface(points : Points) : Unit = {
        this.points = points
    }

    def getColor() : Color = {
        return this.color
    }

    def setColor(color : Color) : Unit = {
        this.color = color
    }

    //event methods
    def mouseClicked(mouseEvent : _root_.java.awt.event.MouseEvent, x : Int, y : Int) : Unit = {
        try {
            var mousePoint : GPoint = PointFactory.getInstance().createXY(mouseEvent.getPoint().x, mouseEvent.getPoint().y)
            if ((mouseEvent.getModifiers() & _root_.java.awt.event.MouseEvent.BUTTON1_MASK) == _root_.java.awt.event.MouseEvent.BUTTON1_MASK) {
                var point : GPoint = PointFactory.getInstance().createXY(mousePoint.getX() / x, mousePoint.getY() / y)
                StatusFactory.getInstance().setStatus("Line Point Added: " + point.toString())
                this.addPoint(point)
            } else if ((mouseEvent.getModifiers() & _root_.java.awt.event.MouseEvent.BUTTON3_MASK) == _root_.java.awt.event.MouseEvent.BUTTON3_MASK) {
                StatusFactory.getInstance().setStatus("Line Point Removed")
                this.removePoint()
            }
            this.currentMousePoint = mousePoint
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "mouseMoved", e)
            }
        }
    }

    def mouseEntered(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
    }

    def mouseExited(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
    }

    def mousePressed(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
    }

    def mouseReleased(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
    }

    def mouseDragged(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
    }

    def mouseMoved(mouseEvent : _root_.java.awt.event.MouseEvent, x : Int, y : Int) : Unit = {
        try {
            var mousePoint : GPoint = PointFactory.getInstance().createXY(mouseEvent.getPoint().x, mouseEvent.getPoint().y)
            var point : GPoint = PointFactory.getInstance().createXY(mousePoint.getX() / x, mousePoint.getY() / y)
            this.currentMousePoint = point
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "mouseMoved", e)
            }
        }
    }

    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        try {
            var keyCode : Int = keyEvent.getKeyCode()
            if (keyCode == _root_.java.awt.event.KeyEvent.VK_ESCAPE) {
                StatusFactory.getInstance().setStatus("Deactivated")
                this.deactivate()
            } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_UP) {
                this.translate(0, -1)
            } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_DOWN) {
                this.translate(0, 1)
            } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_LEFT) {
                this.translate(-1, 0)
            } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_RIGHT) {
                this.translate(1, 0)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, gameInputStrings.KEY_PRESSED, e)
            }
        }
    }

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

}

object LinesGraphicItem {
    //Dom node element names
    private val RECT : String = "rect"

    private val ARC : String = "arc"

    private val STRING : String = "string"

    private val CHAR : String = "char"

    private val IMAGE : String = "image"

    private var item : Int = 0

    private val NAME : String = "Line Tool"

    def getStaticName() : String = {
        return LinesGraphicItem.NAME
    }

}


