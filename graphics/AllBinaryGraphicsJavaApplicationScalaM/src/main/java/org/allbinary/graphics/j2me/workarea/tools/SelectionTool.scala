/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.java.awt.*
import _root_.java.util.HashMap
import _root_.javax.swing.tree.MutableTreeNode
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasJPanel
import _root_.org.allbinary.graphics.j2me.workarea.canvas.IntegerDimension
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.math.RectangleCollisionPointUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Node

/**  *  * @author user  */
class SelectionTool(param_canvasJPanel : CanvasJPanel) extends GraphicItemInterface {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.SelectionTool.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var canvasJPanel : CanvasJPanel = null

    private var active : Boolean = true

    private var controlIdDown : Boolean = false

    private val rectColor : Color = new Color(BasicColorFactory.getInstance().RED.intValue())

    private var startPoint : GPoint = PointFactory.getInstance().ZERO_ZERO

    private var endPoint : GPoint = this.startPoint

    //Constructor
    {
        val canvasJPanel : CanvasJPanel = param_canvasJPanel
        this.canvasJPanel = canvasJPanel
    }

    def setColor(color : Color) : Unit = {
    }

    def getTreeNode() : MutableTreeNode = {
        return null
    }

    def getPointsInterface() : Points = {
        return null
    }

    def setPointsInterface(points : Points) : Unit = {
    }

    //int getSize();
    def isValid() : Boolean = {
        return true
    }

    def isActive() : Boolean = {
        return this.active
    }

    def deactivate() : Unit = {
    }

    def activate() : Unit = {
    }

    def setFulcrumPoint(point : GPoint) : Unit = {
    }

    def translate(x : Int, y : Int) : Unit = {
    }

    def setRotate(theta : Double) : Unit = {
    }

    def addRotate(theta : Double) : Unit = {
    }

    def setAngle(angle : Double) : Unit = {
    }

    def addAngle(angle : Double) : Unit = {
    }

    def getAngle() : Double = {
        return 0
    }

    private def makeSelection() : Unit = {
        var xRect : Int = this.getXRect()
        var xRect2 : Int = Math.abs(this.endPoint.getX() - this.startPoint.getX()) + xRect
        var yRect : Int = this.getYRect()
        var yRect2 : Int = Math.abs(this.endPoint.getY() - this.startPoint.getY()) + yRect
        var hashMap : HashMap[Object, Object] = this.canvasJPanel.getGraphicItemHashMap().asInstanceOf[HashMap[Object, Object]]
        val graphicItemArray : Array[Object] = hashMap.keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = hashMap.get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                if (item.getName() eq LinesGraphicItem.getStaticName()) {
                    if (RectangleCollisionPointUtil.allPointsInsideCell(xRect, yRect, xRect2, yRect2, item.getPointsInterface().getPoints(), this.canvasJPanel.getXPixelsPerWorkAreaPixel(), this.canvasJPanel.getYPixelsPerWorkAreaPixel())) {
                        item.setColor(Color.YELLOW)
                        item.activate()
                    } else if (!this.controlIdDown) {
                        item.setColor(Color.WHITE)
                        item.deactivate()
                    }
                }
                index += 1
            }
        }
    }

    def getXRect() : Int = {
        var xDiff : Int = this.endPoint.getX() - this.startPoint.getX()
        var xRect : Int = this.startPoint.getX()
        if (xDiff < 0) {
            xRect = this.endPoint.getX()
        }
        return xRect
    }

    def getYRect() : Int = {
        var yDiff : Int = this.endPoint.getY() - this.startPoint.getY()
        var yRect : Int = this.startPoint.getY()
        if (yDiff < 0) {
            yRect = this.endPoint.getY()
        }
        return yRect
    }

    def paint(g : Graphics, canvasAngle : _root_.java.lang.Double, dimension : IntegerDimension, x : Int, y : Int) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, canvasStrings.PAINT);
        g.setColor(this.rectColor)
        var xRect : Int = this.getXRect()
        var width : Int = Math.abs(this.endPoint.getX() - this.startPoint.getX())
        var yRect : Int = this.getYRect()
        var height : Int = Math.abs(this.endPoint.getY() - this.startPoint.getY())
        g.drawRect(xRect, yRect, width, height)
    }

    def toDom(canvasDom : CanvasDom) : Node = {
        return null
    }

    def removePoint() : GPoint = {
        return null
    }

    def addPoint(point : GPoint) : Unit = {
    }

    def getName() : String = {
        return SelectionTool.NAME
    }

    //is used and not by the tool itself
    def mouseClicked(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
    }

    def mouseMoved(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
    }

    def mouseEntered(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
    }

    def mouseExited(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
    }

    def mousePressed(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, MouseStrings.getInstance().MOUSE_PRESSED)
        this.startPoint = PointFactory.getInstance().createXY(mouseEvent.getX(), mouseEvent.getY())
        this.endPoint = this.startPoint
    }

    def mouseReleased(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, MouseStrings.getInstance().MOUSE_RELEASED)
        this.endPoint = PointFactory.getInstance().createXY(mouseEvent.getX(), mouseEvent.getY())
        this.active = false
        this.makeSelection()
    }

    def mouseDragged(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, MouseStrings.getInstance().MOUSE_DRAGGED);
        this.endPoint = PointFactory.getInstance().createXY(mouseEvent.getX(), mouseEvent.getY())
    }

    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        if (keyEvent.getKeyCode() == _root_.java.awt.event.KeyEvent.VK_CONTROL) {
            this.controlIdDown = true
        }
    }

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        if (keyEvent.getKeyCode() == _root_.java.awt.event.KeyEvent.VK_CONTROL) {
            this.controlIdDown = false
        }
    }

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def duplicate() : GraphicItemInterface = {
        return null
    }

}

object SelectionTool {
    private val NAME : String = "Selection Tool"

    def getStaticName() : String = {
        return SelectionTool.NAME
    }

}


