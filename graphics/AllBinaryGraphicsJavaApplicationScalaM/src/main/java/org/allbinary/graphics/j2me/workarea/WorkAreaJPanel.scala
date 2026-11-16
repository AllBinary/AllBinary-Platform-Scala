/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea

import _root_.java.awt.*
import _root_.java.util.EventListener
import _root_.java.util.HashMap
import _root_.java.util.LinkedList
import _root_.javax.swing.*
import _root_.javax.swing.tree.MutableTreeNode
import _root_.org.allbinary.dom.DomHelper
import _root_.org.allbinary.graphics.j2me.StatusFactory
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasDom
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasJPanel
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEvent
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventListener
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventService
import _root_.org.allbinary.graphics.j2me.workarea.properties.PropertiesJPanel
import _root_.org.allbinary.graphics.j2me.workarea.tools.ToolJPanel
import _root_.org.allbinary.log.LOGGING
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class WorkAreaJPanel private () extends JPanel with WorkAreaJPanelInterface with MyCanvasEventListener with EventListener with Runnable {
    import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanel.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //linked list of CanvasJPanels
    private var canvasJPanelList : LinkedList[Object] = null

    private var canvasHolderJPanel : JPanel = null

    private var name : String = null

    private var selectedFrame : Int = 0

    private var propertiesJPanel : PropertiesJPanel = null

    private var workAreaJTreeJPanel : WorkAreaJTreeJPanel = null

    //workarea animation
    private var isPlaying_WorkAreaJPanel : Boolean = false

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var innerJPanel : _root_.javax.swing.JPanel = null

    def this(name : String, dimension : Dimension, x : Int, y : Int) = {
        this()
        try {
            this.initComponents()
            this.name = name
            this.initMyComponents(dimension)
            this.workAreaJTreeJPanel = new WorkAreaJTreeJPanel(this.name)
            var canvasJPanel : CanvasJPanel = new CanvasJPanel(this.workAreaJTreeJPanel, this.getSize(), x, y)
            this.canvasJPanelList.add(canvasJPanel)
            this.selectedFrame = 0
            this.propertiesJPanel.set(this.workAreaJTreeJPanel)
            this.canvasHolderJPanel.add(canvasJPanel.asInstanceOf[Component])
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    def this(workAreaDom : WorkAreaDom, dimension : Dimension) = {
        this()
        try {
            this.initComponents()
            this.name = workAreaDom.getName()
            this.initMyComponents(dimension)
            var canvasNodeList : BasicArrayList = workAreaDom.getCanvasNodes()
            var numberOfFrames : Int = canvasNodeList.size()

            {
                var index : Int = 0
                while (index < numberOfFrames) {
                    var node : Node = canvasNodeList.get(index).asInstanceOf[Node]
                    var canvasJPanel : CanvasJPanel = new CanvasJPanel(this.workAreaJTreeJPanel, this.getSize(), new CanvasDom(node))
                    this.canvasJPanelList.add(canvasJPanel)
                    index += 1
                }
            }
            this.selectedFrame = 0
            this.canvasHolderJPanel.add(this.getCurrentFrame().asInstanceOf[Component])
            this.propertiesJPanel.set(this.workAreaJTreeJPanel)
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.LOADINGERROR)) {
                    this.logUtil.put("Constructor Error", this, "WorkAreaJPanel", e)
                }
                throw e
            }
        }
    }

    private def initMyComponents(dimension : Dimension) : Unit = {
        this.workAreaJTreeJPanel = new WorkAreaJTreeJPanel(this.name)
        this.canvasHolderJPanel = new JPanel()
        this.canvasHolderJPanel.setSize(dimension)
        this.canvasHolderJPanel.setLayout(new GridLayout(1, 1))
        this.setSize(dimension)
        this.canvasJPanelList = new LinkedList[Object]()
        var gridBagLayout : GridBagLayout = new GridBagLayout()
        var gridBagConstraints : GridBagConstraints = new GridBagConstraints()
        this.innerJPanel.setLayout(gridBagLayout)
        //this.setLayout(new GridLayout(1,1));
        gridBagConstraints.gridx = 0
        gridBagConstraints.gridy = 0
        gridBagConstraints.gridwidth = 1
        //gridBagConstraints.gridheight =;
        gridBagConstraints.fill = _root_.java.awt.GridBagConstraints.BOTH
        gridBagConstraints.weightx = 0.05
        gridBagConstraints.weighty = 0.05
        var toolJPanel : ToolJPanel = new ToolJPanel()
        gridBagLayout.setConstraints(toolJPanel, gridBagConstraints)
        this.innerJPanel.add(toolJPanel)
        gridBagConstraints = new GridBagConstraints()
        gridBagConstraints.gridx = 1
        gridBagConstraints.gridy = 0
        gridBagConstraints.gridwidth = 6
        //gridBagConstraints.gridheight =400;
        gridBagConstraints.fill = _root_.java.awt.GridBagConstraints.BOTH
        gridBagConstraints.weightx = 1
        gridBagConstraints.weighty = 1
        gridBagLayout.setConstraints(this.canvasHolderJPanel, gridBagConstraints)
        this.innerJPanel.add(this.canvasHolderJPanel)
        gridBagConstraints = new GridBagConstraints()
        gridBagConstraints.gridx = 8
        gridBagConstraints.gridy = 0
        gridBagConstraints.gridwidth = _root_.java.awt.GridBagConstraints.REMAINDER
        //gridBagConstraints.gridheight =400;
        gridBagConstraints.fill = _root_.java.awt.GridBagConstraints.BOTH
        gridBagConstraints.weightx = 0.1
        gridBagConstraints.weighty = 0.1
        //this);
        this.propertiesJPanel = new PropertiesJPanel()
        gridBagLayout.setConstraints(this.propertiesJPanel, gridBagConstraints)
        this.innerJPanel.add(this.propertiesJPanel)
        MyCanvasEventService.addListener(this.asInstanceOf[MyCanvasEventListener])
    }

    //hashMap keeps track of what jtree node goes with a specific canvas
    private def getCanvasHashMap() : HashMap[Object, Object] = {
        val canvasJPanelHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val size : Int = this.canvasJPanelList.size()

        {
            var index : Int = 0
            while (index < size) {
                val canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(index).asInstanceOf[CanvasJPanel]
                canvasJPanelHashMap.put(canvasJPanel.getTreeNode(), new Integer(index))
                index += 1
            }
        }
        return canvasJPanelHashMap
    }

    def play() : Unit = this.synchronized {
        this.isPlaying_WorkAreaJPanel = true
    }

    def stop() : Unit = this.synchronized {
        this.isPlaying_WorkAreaJPanel = false
    }

    def isPlaying() : Boolean = this.synchronized {
        return this.isPlaying_WorkAreaJPanel
    }

    override def getName() : String = {
        return this.name
    }

    override def setName(value : String) : Unit = {
        this.name = value
    }

    def disableCanvas() : Unit = {
        this.canvasHolderJPanel.removeAll()
    }

    def enableCanvas() : Unit = {
        this.canvasHolderJPanel.add(this.getCurrentFrame().asInstanceOf[Component])
    }

    def deselect() : Unit = {
        super.setVisible(false)
    }

    def select() : Unit = {
        super.setVisible(true)
        if (this.canvasHolderJPanel.getComponentCount() == 1) {
            val component : Component = this.canvasHolderJPanel.getComponent(0)
            if (component != null) {
                component.repaint()
            }
        }
    }

    //zoom all canvas/frame
    def changeZoom(factor : Int) : Unit = {
        val size : Int = this.canvasJPanelList.size()

        {
            var index : Int = 0
            while (index < size) {
                var canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(index).asInstanceOf[CanvasJPanel]
                canvasJPanel.getGrid().setZoom(canvasJPanel.getGrid().getZoom() + factor)
                index += 1
            }
        }
    }

    def getCurrentFrame() : CanvasJPanel = {
        return this.canvasJPanelList.get(this.selectedFrame).asInstanceOf[CanvasJPanel]
    }

    private def initDuplicate(newCanvasJPanel : CanvasJPanel) : Unit = {
        if (newCanvasJPanel != null) {
            this.canvasJPanelList.add(newCanvasJPanel)
            this.select(this.canvasJPanelList.size() - 1)
        }
    }

    private def duplicate(treeNode : MutableTreeNode) : Unit = {
        var canvasJPanelHashMap : HashMap[Object, Object] = this.getCanvasHashMap().asInstanceOf[HashMap[Object, Object]]
        if (canvasJPanelHashMap.containsKey(treeNode)) {
            var frameInteger : Integer = canvasJPanelHashMap.get(treeNode).asInstanceOf[Integer]
            var canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(frameInteger.intValue()).asInstanceOf[CanvasJPanel]
            this.initDuplicate(canvasJPanel.duplicate())
        }
    }

    def autoRotate(increments : Int, totalAngle : Int) : Unit = {
        var incrementAngle : Int = (totalAngle / increments).toInt

        {
            var index : Int = 1
            while (index < increments) {
                var canvasJPanel : CanvasJPanel = this.getCurrentFrame().asInstanceOf[CanvasJPanel]
                var newCanvasJPanel : CanvasJPanel = canvasJPanel.duplicate()
                newCanvasJPanel.setAngle(incrementAngle * index)
                this.initDuplicate(newCanvasJPanel)
                index += 1
            }
        }
    }

    def explodeAll() : Unit = {
        var canvasJPanel : CanvasJPanel = this.getCurrentFrame().asInstanceOf[CanvasJPanel]
        //make sure all graphic items are reduced to the min number of points
        canvasJPanel.explodeAll()
    }

    def autoExplode(numberOfFrames : Int, explodeType : Int) : Unit = {

        {
            var index : Int = 1
            while (index < numberOfFrames) {
                var canvasJPanel : CanvasJPanel = this.getCurrentFrame().asInstanceOf[CanvasJPanel]
                var newCanvasJPanel : CanvasJPanel = canvasJPanel.duplicate()
                newCanvasJPanel.explode(index + 1, explodeType)
                this.initDuplicate(newCanvasJPanel)
                index += 1
            }
        }
    }

    def autoMirror() : Unit = {
        var canvasJPanel : CanvasJPanel = this.getCurrentFrame().asInstanceOf[CanvasJPanel]
        var newCanvasJPanel : CanvasJPanel = canvasJPanel.duplicate()
        newCanvasJPanel.mirror()
        this.initDuplicate(newCanvasJPanel)
    }

    private def select(index : Int) : Unit = this.synchronized {
        if (index < this.canvasJPanelList.size()) {
            var canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(index).asInstanceOf[CanvasJPanel]
            if (canvasJPanel != null) {
                this.canvasHolderJPanel.removeAll()
                this.canvasHolderJPanel.add(canvasJPanel)
                this.selectedFrame = index
                canvasJPanel.changed()
                this.canvasHolderJPanel.repaint()
                canvasJPanel.repaint()
            }
        }
    }

    private def select(treeNode : MutableTreeNode) : Unit = {
        var canvasJPanelHashMap : HashMap[Object, Object] = this.getCanvasHashMap().asInstanceOf[HashMap[Object, Object]]
        var frameInteger : Integer = canvasJPanelHashMap.get(treeNode).asInstanceOf[Integer]
        if (frameInteger != null) {
            this.select(frameInteger.intValue())
        }
    }

    def toDocument() : Document = {
        WorkAreaJPanel.document = DomHelper.getInstance().createDocument()
        var workAreaNode : Node = WorkAreaJPanel.document.createElement(WorkAreaDom.WORKAREA)
        var nameNode : Node = WorkAreaJPanel.document.createElement(WorkAreaDom.NAME)
        var nameTextNode : Node = WorkAreaJPanel.document.createTextNode(this.name)
        nameNode.appendChild(nameTextNode)
        var framesNode : Node = WorkAreaJPanel.document.createElement(WorkAreaDom.FRAMES)
        val size : Int = this.canvasJPanelList.size()

        {
            var index : Int = 0
            while (index < size) {
                var canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(index).asInstanceOf[CanvasJPanel]
                framesNode.appendChild(canvasJPanel.toDom())
                index += 1
            }
        }
        workAreaNode.appendChild(nameNode)
        workAreaNode.appendChild(framesNode)
        WorkAreaJPanel.document.appendChild(workAreaNode)
        return document
    }

    private def initComponents() : Unit = {
        this.innerJPanel = new _root_.javax.swing.JPanel()
        setLayout(new _root_.java.awt.GridLayout(1, 1))
        this.innerJPanel.addKeyListener(new _root_.java.awt.event.KeyAdapter {
                override def keyTyped(evt : _root_.java.awt.event.KeyEvent) : Unit = {
                    innerJPanelKeyTyped(evt)
                }

                override def keyPressed(evt : _root_.java.awt.event.KeyEvent) : Unit = {
                    innerJPanelKeyPressed(evt)
                }

                override def keyReleased(evt : _root_.java.awt.event.KeyEvent) : Unit = {
                    innerJPanelKeyReleased(evt)
                }

            })
        add(this.innerJPanel)
    }

    //event methods
    private def innerJPanelKeyReleased(evt : _root_.java.awt.event.KeyEvent) : Unit = {
        // Add your handling code here:
        StatusFactory.getInstance().setStatus("Key Pressed1")
    }

    //GEN-LAST:event_innerJPanelKeyReleased
    private def innerJPanelKeyPressed(evt : _root_.java.awt.event.KeyEvent) : Unit = {
        // Add your handling code here:
        StatusFactory.getInstance().setStatus("Key Pressed2")
    }

    //GEN-LAST:event_innerJPanelKeyPressed
    private def innerJPanelKeyTyped(evt : _root_.java.awt.event.KeyEvent) : Unit = {
        // Add your handling code here:
        StatusFactory.getInstance().setStatus("Key Pressed3")
    }

    //GEN-LAST:event_innerJPanelKeyTyped
    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        this.getCurrentFrame().keyPressed(keyEvent)
    }

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def delete(evt : MyCanvasEvent) : Unit = {
        var canvasJPanelHashMap : HashMap[Object, Object] = this.getCanvasHashMap().asInstanceOf[HashMap[Object, Object]]
        if (canvasJPanelHashMap.containsKey(evt.getTreeNode())) {
            this.canvasHolderJPanel.removeAll()
            var frameInt : Integer = canvasJPanelHashMap.get(evt.getTreeNode()).asInstanceOf[Integer]
            this.canvasJPanelList.remove(Integer.valueOf(frameInt.intValue()))
            this.select(frameInt.intValue())
        }
    }

    def duplicate(evt : MyCanvasEvent) : Unit = {
        this.duplicate(evt.getTreeNode())
    }

    def select(evt : MyCanvasEvent) : Unit = {
        this.select(evt.getTreeNode())
        StatusFactory.getInstance().setStatus("Frame Selected")
    }

    def rotate(evt : MyCanvasEvent) : Unit = {
        var canvasJPanelHashMap : HashMap[Object, Object] = this.getCanvasHashMap().asInstanceOf[HashMap[Object, Object]]
        var treeNode : MutableTreeNode = evt.getTreeNode()
        var frameInt : Integer = canvasJPanelHashMap.get(evt.getTreeNode()).asInstanceOf[Integer]
        var canvasJPanel : CanvasJPanel = this.canvasJPanelList.get(frameInt.intValue()).asInstanceOf[CanvasJPanel]
        if (canvasJPanel != null) {
            canvasJPanel.addAngle(evt.getAngle())
            this.select(frameInt.intValue())
        }
        StatusFactory.getInstance().setStatus("Canvas Rotated")
    }

    def explode(evt : MyCanvasEvent) : Unit = {
        this.explodeAll()
    }

    def autoExplode(evt : MyCanvasEvent) : Unit = {
        this.autoExplode(10, 0)
    }

    def center() : Unit = {
        var canvasJPanel : CanvasJPanel = this.getCurrentFrame().asInstanceOf[CanvasJPanel]
        canvasJPanel.center()
    }

    def center(evt : MyCanvasEvent) : Unit = {
        this.center()
    }

    def run() : Unit = {
        try {

            {
                while (true) {
                    if (this.isPlaying()) {
                        val size : Int = this.canvasJPanelList.size()

                        {
                            var index : Int = 0
                            scala.util.boundary { (break_N91203 : scala.util.boundary.Label[Unit]) ?=>
                                while (index < size) {
                                    if (!this.isPlaying()) {
                                        scala.util.boundary.break()(using break_N91203)
                                    }
                                    this.select(index)
                                    Thread.sleep(100)
                                    index += 1
                                }
                            }
                        }
                    } else {
                        Thread.sleep(500)
                    }
                    Thread.sleep(250)
                }
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
            }
        }
    }

}

object WorkAreaJPanel {
    private var document : _root_.org.w3c.dom.Document = null

    //dom methods excluding constructor
    def getDocument() : Document = {
        return WorkAreaJPanel.document
    }

}


