/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class TimeIntervalActionScriptConditionJPanel(param_timeIntervalActionScriptConditionInterface : TimeIntervalActionScriptConditionInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var timeIntervalActionScriptConditionInterface : TimeIntervalActionScriptConditionInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var timeIntervalActionJButton : _root_.javax.swing.JButton = null

    private var timeIntervalActionJDialog : _root_.javax.swing.JDialog = null

    private var timeIntervalJTextField : _root_.javax.swing.JTextField = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val timeIntervalActionScriptConditionInterface : TimeIntervalActionScriptConditionInterface = param_timeIntervalActionScriptConditionInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.timeIntervalActionScriptConditionInterface = timeIntervalActionScriptConditionInterface
        this.set()
    }

    private def set() : Unit = {
        this.getTimeIntervalJTextField().setText(Integer.toString(this.timeIntervalActionScriptConditionInterface.getTimeDelayHelper().delay))
        this.timeIntervalActionScriptConditionInterface.log()
    }

    private def update() : Unit = {
        this.timeIntervalActionScriptConditionInterface.getTimeDelayHelper().delay = Integer.valueOf(this.getTimeIntervalJTextField().getText())
        this.timeIntervalActionScriptConditionInterface.log()
    }

    def getTimeIntervalJTextField() : _root_.javax.swing.JTextField = {
        return this.timeIntervalJTextField
    }

    def setTimeIntervalJTextField(timeIntervalJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.timeIntervalJTextField = timeIntervalJTextField
    }

    def getTimeIntervalActionJDialog() : _root_.javax.swing.JDialog = {
        return this.timeIntervalActionJDialog
    }

    def setTimeIntervalActionJDialog(timeIntervalActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.timeIntervalActionJDialog = timeIntervalActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.timeIntervalActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.okJButton = new _root_.javax.swing.JButton()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.timeIntervalJTextField = new _root_.javax.swing.JTextField()
        this.timeIntervalActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.timeIntervalActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(250, 150))
        this.titleJLabel.setText("Time Interval Condition Options")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        this.jLabel2.setText("Time (ms):")
        var timeIntervalActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.timeIntervalActionJDialog.getContentPane())
        this.timeIntervalActionJDialog.getContentPane().setLayout(timeIntervalActionJDialogLayout)
        timeIntervalActionJDialogLayout.setHorizontalGroup(timeIntervalActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(timeIntervalActionJDialogLayout.createSequentialGroup().addGroup(timeIntervalActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, timeIntervalActionJDialogLayout.createSequentialGroup().addGap(82, 82, 82).addComponent(okJButton)).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, timeIntervalActionJDialogLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(timeIntervalActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(timeIntervalActionJDialogLayout.createSequentialGroup().addComponent(jLabel2).addGap(16, 16, 16).addComponent(timeIntervalJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 85, _root_.java.lang.Short.MAX_VALUE)).addComponent(titleJLabel)))).addContainerGap(36, _root_.java.lang.Short.MAX_VALUE)))
        timeIntervalActionJDialogLayout.setVerticalGroup(timeIntervalActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(timeIntervalActionJDialogLayout.createSequentialGroup().addContainerGap().addComponent(titleJLabel).addGap(20, 20, 20).addGroup(timeIntervalActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(timeIntervalJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(15, 15, 15).addComponent(okJButton).addContainerGap()))
        setMinimumSize(new _root_.java.awt.Dimension(100, 0))
        this.timeIntervalActionJButton.setText("Edit")
        this.timeIntervalActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    timeIntervalActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Time Interval:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(timeIntervalActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(timeIntervalActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.update()
        this.getTimeIntervalActionJDialog().setVisible(false)
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def timeIntervalActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.getTimeIntervalActionJDialog().setVisible(true)
    }

}


