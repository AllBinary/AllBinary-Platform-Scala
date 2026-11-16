/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions.script

import _root_.java.awt.event.MouseEvent
import _root_.javax.swing.*
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.javax.swing.tree.DefaultTreeModel
import _root_.javax.swing.tree.TreePath
import _root_.org.allbinary.input.automation.actions.script.JTreeInterface
import _root_.org.allbinary.input.automation.actions.script.condition.CustomTreeNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class GenericProfileActionScriptJPanel() extends _root_.javax.swing.JPanel with JTreeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var defaultMutableTreeNode : DefaultMutableTreeNode = new DefaultMutableTreeNode("Root")

    private var genericProfileActionScript : GenericProfileActionScript = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var actionScriptJTree : _root_.javax.swing.JTree = null

    private var jScrollPane1 : _root_.javax.swing.JScrollPane = null

    /** Creates new form GenericProfileActionScriptJPanel */
    //Constructor
    {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
    }

    def updateJTree() : Unit = {
        var defaultTreeModel : DefaultTreeModel = new DefaultTreeModel(this.getGenericProfileActionScript())
        this.getActionScriptJTree().setModel(defaultTreeModel)
        this.repaint()
        this.logUtil.putF("Updated UI", this, "updateJTree")
    }

    def getGenericProfileActionScript() : GenericProfileActionScript = {
        return this.genericProfileActionScript
    }

    def setGenericProfileActionScript(genericProfileActionScript : GenericProfileActionScript) : Unit = {
        this.genericProfileActionScript = genericProfileActionScript
    }

    def getActionScriptJTree() : _root_.javax.swing.JTree = {
        return this.actionScriptJTree
    }

    def setActionScriptJTree(actionScriptJTree : _root_.javax.swing.JTree) : Unit = {
        this.actionScriptJTree = actionScriptJTree
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.jScrollPane1 = new _root_.javax.swing.JScrollPane()
        this.actionScriptJTree = new _root_.javax.swing.JTree()
        setLayout(new _root_.java.awt.GridLayout(1, 0))
        this.actionScriptJTree.setPreferredSize(new _root_.java.awt.Dimension(500, 500))
        this.actionScriptJTree.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mouseClicked(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    actionScriptJTreeMouseClicked(evt)
                }

                override def mouseReleased(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    actionScriptJTreeMouseReleased(evt)
                }

            })
        this.jScrollPane1.setViewportView(this.actionScriptJTree)
        add(this.jScrollPane1)
    }

    // </editor-fold>//GEN-END:initComponents
    private def actionScriptJTreeMouseReleased(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_actionScriptJTreeMouseReleased
        var button : Int = evt.getButton()
        if (button == MouseEvent.BUTTON3) {
            var treePath : TreePath = this.getActionScriptJTree().getSelectionPath()
            if (treePath != null) {
                var anyType : Object = treePath.getLastPathComponent()
                if (anyType.isInstanceOf[CustomTreeNodeInterface]) {
                    var customTreeNodeInterface : CustomTreeNodeInterface = anyType.asInstanceOf[CustomTreeNodeInterface]
                    var jPopupMenu : JPopupMenu = customTreeNodeInterface.getJPopupMenu()
                    jPopupMenu.show(evt.getSource().asInstanceOf[JComponent], evt.getX(), evt.getY())
                }
            }
        }
    }

    //GEN-LAST:event_actionScriptJTreeMouseReleased
    private def actionScriptJTreeMouseClicked(evt : _root_.java.awt.event.MouseEvent) : Unit = {
    }

}


