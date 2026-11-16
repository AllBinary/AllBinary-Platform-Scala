/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions

import _root_.org.allbinary.input.automation.actions.script.JTreeInterfaceFactory
import _root_.org.allbinary.input.automation.actions.script.condition.AlwaysActionScriptCondition
import _root_.org.allbinary.input.automation.actions.script.condition.ColorAtActionScriptCondition
import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionInterface
import _root_.org.allbinary.input.automation.actions.script.condition.TimeIntervalActionScriptCondition
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScriptJPanel
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author  USER  */
class GenericProfileActionJPanel() extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var genericProfileAction : GenericProfileAction = null

    private var genericProfileActionScriptJPanel : GenericProfileActionScriptJPanel = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var blankProfileActionScriptJPanel : _root_.javax.swing.JPanel = null

    private var genericProfileActionScriptJScrollPane : _root_.javax.swing.JScrollPane = null

    private var ifJLabel : _root_.javax.swing.JLabel = null

    private var newAlwaysJButton : _root_.javax.swing.JButton = null

    private var newColorAtJButton : _root_.javax.swing.JButton = null

    private var newTimeIntervalJButton : _root_.javax.swing.JButton = null

    /** Creates new form GenericProfileActionJPanel */
    //Constructor
    {
        this.initComponents()
    }

    def updateProfileActionUI() : Unit = {
        this.blankProfileActionScriptJPanel.removeAll()
        val genericProfileActionScriptJPanel : GenericProfileActionScriptJPanel = new GenericProfileActionScriptJPanel()
        JTreeInterfaceFactory.getInstance().set(genericProfileActionScriptJPanel)
        this.setGenericProfileActionScriptJPanel(genericProfileActionScriptJPanel)
        this.getGenericProfileActionScriptJPanel().setGenericProfileActionScript(this.getGenericProfileAction().getGenericProfileActionScript())
        this.getGenericProfileActionScriptJPanel().updateJTree()
        var layout : _root_.javax.swing.GroupLayout = this.blankProfileActionScriptJPanel.getLayout().asInstanceOf[_root_.javax.swing.GroupLayout]
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 395, _root_.java.lang.Short.MAX_VALUE).addComponent(this.getGenericProfileActionScriptJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, _root_.java.lang.Short.MAX_VALUE).addComponent(this.getGenericProfileActionScriptJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
        this.logUtil.putF("Updated UI", this, "updateUI")
    }

    def getGenericProfileAction() : GenericProfileAction = {
        return this.genericProfileAction
    }

    def setGenericProfileAction(genericProfileAction : GenericProfileAction) : Unit = {
        this.genericProfileAction = genericProfileAction
    }

    def getGenericProfileActionScriptJPanel() : GenericProfileActionScriptJPanel = {
        return this.genericProfileActionScriptJPanel
    }

    def setGenericProfileActionScriptJPanel(genericProfileActionScriptJPanel : GenericProfileActionScriptJPanel) : Unit = {
        this.genericProfileActionScriptJPanel = genericProfileActionScriptJPanel
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.genericProfileActionScriptJScrollPane = new _root_.javax.swing.JScrollPane()
        this.blankProfileActionScriptJPanel = new _root_.javax.swing.JPanel()
        this.ifJLabel = new _root_.javax.swing.JLabel()
        this.newColorAtJButton = new _root_.javax.swing.JButton()
        this.newTimeIntervalJButton = new _root_.javax.swing.JButton()
        this.newAlwaysJButton = new _root_.javax.swing.JButton()
        setMinimumSize(new _root_.java.awt.Dimension(440, 275))
        setPreferredSize(new _root_.java.awt.Dimension(440, 275))
        this.genericProfileActionScriptJScrollPane.setPreferredSize(new _root_.java.awt.Dimension(474, 270))
        this.blankProfileActionScriptJPanel.setMinimumSize(new _root_.java.awt.Dimension(400, 200))
        var blankProfileActionScriptJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.blankProfileActionScriptJPanel)
        this.blankProfileActionScriptJPanel.setLayout(blankProfileActionScriptJPanelLayout)
        blankProfileActionScriptJPanelLayout.setHorizontalGroup(blankProfileActionScriptJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 9996, _root_.java.lang.Short.MAX_VALUE))
        blankProfileActionScriptJPanelLayout.setVerticalGroup(blankProfileActionScriptJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 9967, _root_.java.lang.Short.MAX_VALUE))
        this.genericProfileActionScriptJScrollPane.setViewportView(this.blankProfileActionScriptJPanel)
        this.ifJLabel.setText("Conditions:")
        this.newColorAtJButton.setText("Color Range At")
        this.newColorAtJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newColorAtJButtonActionPerformed(evt)
                }

            })
        this.newTimeIntervalJButton.setText("Time Interval")
        this.newTimeIntervalJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newTimeIntervalJButtonActionPerformed(evt)
                }

            })
        this.newAlwaysJButton.setText("Always On/Off")
        this.newAlwaysJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newAlwaysJButtonActionPerformed(evt)
                }

            })
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(ifJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(newColorAtJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(newTimeIntervalJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(newAlwaysJButton).addContainerGap(61, _root_.java.lang.Short.MAX_VALUE)).addComponent(genericProfileActionScriptJScrollPane, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 440, _root_.java.lang.Short.MAX_VALUE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(ifJLabel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 14, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(newColorAtJButton).addComponent(newTimeIntervalJButton).addComponent(newAlwaysJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(genericProfileActionScriptJScrollPane, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 246, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def newTimeIntervalJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_newTimeIntervalJButtonActionPerformed
        this.logUtil.putF("New Time Interval Action Condition", this, "newTimeIntervalJButtonActionPerformed")
        this.getGenericProfileAction().getGenericProfileActionScript().addCondition((new TimeIntervalActionScriptCondition()).asInstanceOf[ProfileActionScriptConditionInterface])
        this.updateProfileActionUI()
    }

    //GEN-LAST:event_newTimeIntervalJButtonActionPerformed
    private def newAlwaysJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_newAlwaysJButtonActionPerformed
        this.logUtil.putF("New EveryTime Action Condition", this, "newEveryTimeJButtonActionPerformed")
        this.getGenericProfileAction().getGenericProfileActionScript().addCondition((new AlwaysActionScriptCondition()).asInstanceOf[ProfileActionScriptConditionInterface])
        this.updateProfileActionUI()
    }

    //GEN-LAST:event_newAlwaysJButtonActionPerformed
    private def newColorAtJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_newColorAtJButtonActionPerformed
        this.logUtil.putF("New Color At Action Condition", this, "newColorAtJButtonActionPerformed")
        this.getGenericProfileAction().getGenericProfileActionScript().addCondition((new ColorAtActionScriptCondition()).asInstanceOf[ProfileActionScriptConditionInterface])
        this.updateProfileActionUI()
    }

}


