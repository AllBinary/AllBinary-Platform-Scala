/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanel
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Node

/**  *  * @author user  */
class PointsDomUtil {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.PointsDomUtil.{*}

    val LINES : String = "lines"

    val POINTONE : String = "pointOne"

    val POINTTWO : String = "pointTwo"

    //Y
    private val ROTATEDPOINTONE : String = "rotatedPointOne"

    //Y
    private val ROTATEDPOINTTWO : String = "rotatedPointTwo"

    //Y
    private val LINE : String = "line"

    def toDom(canvasDom : CanvasDom, pointVector : BasicArrayList) : Node = {
        var tempPointVector : BasicArrayList = PointsUtil.getInstance().doTransforms(pointVector, new _root_.java.lang.Double(canvasDom.getAngle()), PointFactory.getInstance().createXY(canvasDom.getDimension().getWidth(), canvasDom.getDimension().getHeight()))
        var document : _root_.org.w3c.dom.Document = WorkAreaJPanel.getDocument()
        var linesNode : Node = document.createElement(this.LINES).asInstanceOf[Node]
        var size2 : Int = tempPointVector.size()
        var size : Int = pointVector.size()
        var firstPoint : GPoint = null
        var rotatedFirstPoint : GPoint = null
        var index : Int = 0
        if ((index < size) && (index < size2)) {
            rotatedFirstPoint = tempPointVector.get(index).asInstanceOf[GPoint]
            firstPoint = pointVector.get(index).asInstanceOf[GPoint]
            index += 1
        }

        {
            while ((index < size) && (index < size2)) {
                var lineNode : Node = document.createElement(this.LINE).asInstanceOf[Node]
                var rotatedSecondPoint : GPoint = tempPointVector.get(index).asInstanceOf[GPoint]
                var secondPoint : GPoint = pointVector.get(index).asInstanceOf[GPoint]
                var pointOneNode : Node = this.getPointNode(firstPoint, this.POINTONE)
                var pointTwoNode : Node = this.getPointNode(secondPoint, this.POINTTWO)
                var rotatedPointOneNode : Node = this.getPointNode(rotatedFirstPoint, this.ROTATEDPOINTONE)
                var rotatedPointTwoNode : Node = this.getPointNode(rotatedSecondPoint, this.ROTATEDPOINTTWO)
                lineNode.appendChild(pointOneNode)
                lineNode.appendChild(pointTwoNode)
                lineNode.appendChild(rotatedPointOneNode)
                lineNode.appendChild(rotatedPointTwoNode)
                firstPoint = secondPoint
                rotatedFirstPoint = rotatedSecondPoint
                linesNode.appendChild(lineNode)
                index += 1
            }
        }
        return linesNode
    }

    private def getPointNode(point : GPoint, pointName : String) : Node = {
        var document : _root_.org.w3c.dom.Document = WorkAreaJPanel.getDocument()
        var pointNode : Node = document.createElement(pointName).asInstanceOf[Node]
        var xNode : Node = document.createElement(PositionStrings.getInstance().X).asInstanceOf[Node]
        var xTextNode : Node = document.createTextNode(Integer.toString(point.getX())).asInstanceOf[Node]
        xNode.appendChild(xTextNode)
        var yNode : Node = document.createElement(PositionStrings.getInstance().Y).asInstanceOf[Node]
        var yTextNode : Node = document.createTextNode(Integer.toString(point.getY())).asInstanceOf[Node]
        yNode.appendChild(yTextNode)
        pointNode.appendChild(xNode)
        pointNode.appendChild(yNode)
        return pointNode
    }

}

object PointsDomUtil {
    private val instance : PointsDomUtil = new PointsDomUtil()

    /**      * @return the instance      */
    def getInstance() : PointsDomUtil = {
        return PointsDomUtil.instance
    }

}


