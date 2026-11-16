/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.java.awt.*
import _root_.javax.swing.tree.MutableTreeNode
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom
import _root_.org.allbinary.graphics.j2me.workarea.canvas.IntegerDimension
import _root_.org.w3c.dom.Node

trait GraphicItemInterface {

    def getName() : String

    def setColor(color : Color) : Unit

    def getTreeNode() : MutableTreeNode

    def getPointsInterface() : Points

    def setPointsInterface(points : Points) : Unit

    //int getSize();
    def isValid() : Boolean

    def isActive() : Boolean

    def deactivate() : Unit

    def activate() : Unit

    def setFulcrumPoint(point : GPoint) : Unit

    def translate(x : Int, y : Int) : Unit

    def setRotate(theta : Double) : Unit

    def addRotate(theta : Double) : Unit

    def setAngle(angle : Double) : Unit

    def addAngle(angle : Double) : Unit

    def getAngle() : Double

    def paint(g : Graphics, canvasAngle : _root_.java.lang.Double, dimension : IntegerDimension, x : Int, y : Int) : Unit

    def toDom(canvasDom : CanvasDom) : Node

    def removePoint() : GPoint

    def addPoint(point : GPoint) : Unit

    //is used and not by the tool itself
    def mouseClicked(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit

    def mouseEntered(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit

    def mouseExited(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit

    def mousePressed(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit

    def mouseReleased(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit

    def mouseDragged(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit

    def mouseMoved(mouseEvent : _root_.java.awt.event.MouseEvent, xPixelsPerCell : Int, yPixelsPerCell : Int) : Unit

    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit

    def duplicate() : GraphicItemInterface

}


