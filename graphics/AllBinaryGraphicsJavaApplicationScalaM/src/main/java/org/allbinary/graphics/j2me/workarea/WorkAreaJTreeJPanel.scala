/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea

import _root_.javax.swing.*
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.javax.swing.tree.MutableTreeNode
import _root_.javax.swing.tree.TreePath
import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasTreeLabel
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEvent
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventService
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventSource
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEvent
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEventService
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEventSource
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class WorkAreaJTreeJPanel(param_workAreaName : String) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var rootTreeNode : DefaultMutableTreeNode = null

    private var workAreaJTree : JTree = null

    private var highlightedBasicArrayList : BasicArrayList = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var copyJMenuItem : _root_.javax.swing.JMenuItem = null

    private var deleteJMenuItem : _root_.javax.swing.JMenuItem = null

    private var itemJPopupMenu : _root_.javax.swing.JPopupMenu = null

    private var itemJScrollPane1 : _root_.javax.swing.JScrollPane = null

    private var rotateJMenuItem : _root_.javax.swing.JMenuItem = null

    private var workAreaPropertiesJPanel : _root_.javax.swing.JPanel = null

    //Constructor
    {
        val workAreaName : String = param_workAreaName
        this.initComponents()
        this.rootTreeNode = new DefaultMutableTreeNode(workAreaName)
        this.workAreaPropertiesJPanel.removeAll()
        this.updateTree()
        this.highlightedBasicArrayList = new BasicArrayListD()
    }

    def add(treeNode : MutableTreeNode) : Unit = {
        this.rootTreeNode.add(treeNode)
    }

    def updateTree() : Unit = {
        this.workAreaJTree = new JTree(this.rootTreeNode)
        this.workAreaJTree.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    workAreaJTreeMousePressed(evt)
                }

            })
        this.workAreaPropertiesJPanel.removeAll()
        this.workAreaPropertiesJPanel.add(this.workAreaJTree)
    }

    def getNode(treePathArray : Array[TreePath]) : BasicArrayList = {
        var basicArrayList : BasicArrayList = new BasicArrayListD()
        if (treePathArray != null) {

            {
                var index : Int = 0
                while (index < treePathArray.length) {
                    basicArrayList.add(this.getNode(treePathArray(index)))
                    index += 1
                }
            }
        }
        return basicArrayList
    }

    def getNode(treePath : TreePath) : DefaultMutableTreeNode = {
        if (treePath != null) {
            var obj : Array[Object] = treePath.getPath()
            if (obj != null) {
                var node : DefaultMutableTreeNode = obj(obj.length - 1).asInstanceOf[DefaultMutableTreeNode]
                return node
            }
        }
        return null
    }

    def deselectAll() : Unit = {
        var size : Int = this.highlightedBasicArrayList.size()
        this.logUtil.putF("size: " + size, this, "deselectAll")

        {
            var index : Int = 0
            while (index < size) {
                var node : DefaultMutableTreeNode = this.highlightedBasicArrayList.get(index).asInstanceOf[DefaultMutableTreeNode]
                MyGraphicItemEventService.fire(new MyGraphicItemEvent((new MyGraphicItemEventSource(MyGraphicItemEventService.DESELECT, node)).asInstanceOf[Object]))
                index += 1
            }
        }
        this.highlightedBasicArrayList.clear()
    }

    def selectGraphicItem(node : DefaultMutableTreeNode) : Unit = {
        this.highlightedBasicArrayList.add(node)
        MyGraphicItemEventService.fire(new MyGraphicItemEvent((new MyGraphicItemEventSource(MyGraphicItemEventService.SELECT, node)).asInstanceOf[Object]))
    }

    def removeGraphicItem(node : DefaultMutableTreeNode) : Unit = {
        MyGraphicItemEventService.fire(new MyGraphicItemEvent((new MyGraphicItemEventSource(MyGraphicItemEventService.DELETE, node)).asInstanceOf[Object]))
    }

    def removeCanvas(node : DefaultMutableTreeNode) : Unit = {
        MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.DELETE, node)).asInstanceOf[Object]))
    }

    def remove(treePath : TreePath) : Unit = {
        var node : DefaultMutableTreeNode = this.getNode(treePath)
        if (node != null) {
            if (node.getUserObject().isInstanceOf[CanvasTreeLabel]) {
                this.removeCanvas(node)
            } else {
                this.removeGraphicItem(node)
            }
        }
        var parent : DefaultMutableTreeNode = node.getParent().asInstanceOf[DefaultMutableTreeNode]
        parent.remove(node)
    }

    private def copy() : Unit = {
        var treePath : TreePath = this.workAreaJTree.getSelectionPath()
        this.copy(treePath)
        this.updateTree()
        this.expand()
        this.repaint()
    }

    private def copy(treePath : TreePath) : Unit = {
        var node : DefaultMutableTreeNode = this.getNode(treePath)
        if (node != null) {
            if (node.getUserObject().isInstanceOf[CanvasTreeLabel]) {
                MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.DUPLICATE, node)).asInstanceOf[Object]))
            } else {
                MyGraphicItemEventService.fire(new MyGraphicItemEvent((new MyGraphicItemEventSource(MyGraphicItemEventService.DUPLICATE, node)).asInstanceOf[Object]))
            }
        }
    }

    def rotate(treePath : TreePath, angle : Double) : Unit = {
        var node : DefaultMutableTreeNode = this.getNode(treePath)
        if (node != null) {
            if (node.getUserObject().isInstanceOf[CanvasTreeLabel]) {
                MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.ROTATE, angle, node)).asInstanceOf[Object]))
            } else {
                MyGraphicItemEventService.fire(new MyGraphicItemEvent((new MyGraphicItemEventSource(MyGraphicItemEventService.ROTATE, angle, node)).asInstanceOf[Object]))
            }
        }
    }

    def getRootTreeNode() : MutableTreeNode = {
        return this.rootTreeNode
    }

    def expand() : Unit = {
        this.workAreaJTree.expandRow(0)
        this.workAreaJTree.expandRow(1)
    }

    def expand(treePath : TreePath) : Unit = {
        this.workAreaJTree.expandPath(treePath)
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        itemJPopupMenu = new _root_.javax.swing.JPopupMenu()
        this.deleteJMenuItem = new _root_.javax.swing.JMenuItem()
        this.copyJMenuItem = new _root_.javax.swing.JMenuItem()
        this.rotateJMenuItem = new _root_.javax.swing.JMenuItem()
        this.itemJScrollPane1 = new _root_.javax.swing.JScrollPane()
        this.workAreaPropertiesJPanel = new _root_.javax.swing.JPanel()
        itemJPopupMenu.addPopupMenuListener(new _root_.javax.swing.event.PopupMenuListener {
                override def popupMenuCanceled(evt : _root_.javax.swing.event.PopupMenuEvent) : Unit = {
                }

                override def popupMenuWillBecomeInvisible(evt : _root_.javax.swing.event.PopupMenuEvent) : Unit = {
                    itemJPopupMenuPopupMenuWillBecomeInvisible(evt)
                }

                override def popupMenuWillBecomeVisible(evt : _root_.javax.swing.event.PopupMenuEvent) : Unit = {
                    itemJPopupMenuPopupMenuWillBecomeVisible(evt)
                }

            })
        this.deleteJMenuItem.setText("Delete")
        this.deleteJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    deleteJMenuItemMousePressed(evt)
                }

            })
        this.itemJPopupMenu.add(this.deleteJMenuItem)
        this.copyJMenuItem.setText("Copy")
        this.copyJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    copyJMenuItemMousePressed(evt)
                }

            })
        this.itemJPopupMenu.add(this.copyJMenuItem)
        this.rotateJMenuItem.setText("Rotate 45*")
        this.rotateJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    rotateJMenuItemMousePressed(evt)
                }

            })
        this.itemJPopupMenu.add(this.rotateJMenuItem)
        setLayout(new _root_.java.awt.GridLayout(1, 1))
        this.workAreaPropertiesJPanel.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    workAreaPropertiesJPanelMousePressed(evt)
                }

            })
        this.workAreaPropertiesJPanel.setLayout(new _root_.java.awt.GridLayout(1, 0))
        this.itemJScrollPane1.setViewportView(this.workAreaPropertiesJPanel)
        add(this.itemJScrollPane1)
    }

    // </editor-fold>//GEN-END:initComponents
    private def rotateJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_rotateJMenuItemMousePressed
        try {
            var treePath : TreePath = this.workAreaJTree.getSelectionPath()
            this.rotate(treePath, 45)
            this.updateTree()
            this.expand()
            this.repaint()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "rotateJMenuItemMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_rotateJMenuItemMousePressed
    private def workAreaJTreeMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_workAreaJTreeMousePressed
        try {
            var selectedTreePathArray : Array[TreePath] = this.workAreaJTree.getSelectionPaths()
            var list : BasicArrayList = this.getNode(selectedTreePathArray)
            if (list.size() > 0) {
                if ((evt.getModifiers() & _root_.java.awt.event.MouseEvent.BUTTON3_MASK) == _root_.java.awt.event.MouseEvent.BUTTON3_MASK) {

                    {
                        var index : Int = 0
                        while (index < selectedTreePathArray.length) {
                            var defaultMutableTreeNode : DefaultMutableTreeNode = list.get(index).asInstanceOf[DefaultMutableTreeNode]
                            if (defaultMutableTreeNode.getUserObject().isInstanceOf[CanvasTreeLabel]) {
                                this.itemJPopupMenu.show(this, evt.getX(), evt.getY())
                            } else {
                                this.itemJPopupMenu.show(this, evt.getX(), evt.getY())
                            }
                            index += 1
                        }
                    }
                }
                if ((evt.getModifiers() & _root_.java.awt.event.MouseEvent.BUTTON1_MASK) == _root_.java.awt.event.MouseEvent.BUTTON1_MASK) {
                    this.deselectAll()

                    {
                        var index : Int = 0
                        while (index < selectedTreePathArray.length) {
                            var defaultMutableTreeNode : DefaultMutableTreeNode = list.get(index).asInstanceOf[DefaultMutableTreeNode]
                            if (defaultMutableTreeNode.getUserObject().isInstanceOf[CanvasTreeLabel]) {
                                MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.SELECT, defaultMutableTreeNode)).asInstanceOf[Object]))
                            } else {
                                this.selectGraphicItem(defaultMutableTreeNode)
                            }
                            index += 1
                        }
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "workAreaJTreeMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_workAreaJTreeMousePressed
    private def itemJPopupMenuPopupMenuWillBecomeInvisible(evt : _root_.javax.swing.event.PopupMenuEvent) : Unit = {
    }

    //GEN-LAST:event_itemJPopupMenuPopupMenuWillBecomeInvisible
    private def itemJPopupMenuPopupMenuWillBecomeVisible(evt : _root_.javax.swing.event.PopupMenuEvent) : Unit = {
    }

    //GEN-LAST:event_itemJPopupMenuPopupMenuWillBecomeVisible
    private def copyJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_copyJMenuItemMousePressed
        try {
            this.copy()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "copyJMenuItemMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_copyJMenuItemMousePressed
    private def deleteJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_deleteJMenuItemMousePressed
        try {
            var selectedTreePathArray : Array[TreePath] = this.workAreaJTree.getSelectionPaths()

            {
                var index : Int = 0
                while (index < selectedTreePathArray.length) {
                    var treePath : TreePath = selectedTreePathArray(index)
                    this.remove(treePath)
                    this.updateTree()
                    this.expand()
                    this.repaint()
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "deleteJMenuItemMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_deleteJMenuItemMousePressed
    private def workAreaPropertiesJPanelMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
    }

}


