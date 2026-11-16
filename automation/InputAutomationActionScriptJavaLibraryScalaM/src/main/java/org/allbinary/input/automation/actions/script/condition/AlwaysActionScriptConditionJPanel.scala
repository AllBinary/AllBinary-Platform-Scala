/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class AlwaysActionScriptConditionJPanel(param_alwaysActionScriptConditionInterface : AlwaysActionScriptConditionInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var alwaysActionScriptConditionInterface : AlwaysActionScriptConditionInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var alwaysActionJButton : _root_.javax.swing.JButton = null

    private var alwaysActionJDialog : _root_.javax.swing.JDialog = null

    private var alwaysJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val alwaysActionScriptConditionInterface : AlwaysActionScriptConditionInterface = param_alwaysActionScriptConditionInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.alwaysActionScriptConditionInterface = alwaysActionScriptConditionInterface
        this.set()
    }

    private def set() : Unit = {
        if (this.alwaysActionScriptConditionInterface.isIsOn()) {
            this.alwaysJComboBox.setSelectedIndex(0)
        } else {
            this.alwaysJComboBox.setSelectedIndex(1)
        }
        this.alwaysActionScriptConditionInterface.log()
    }

    private def update() : Unit = {
        if (this.alwaysJComboBox.getSelectedIndex() == 0) {
            this.alwaysActionScriptConditionInterface.setIsOn(true)
        } else {
            this.alwaysActionScriptConditionInterface.setIsOn(false)
        }
        this.alwaysActionScriptConditionInterface.log()
    }

    def getAlwaysActionJDialog() : _root_.javax.swing.JDialog = {
        return this.alwaysActionJDialog
    }

    def setAlwaysActionJDialog(alwaysActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.alwaysActionJDialog = alwaysActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.alwaysActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.okJButton = new _root_.javax.swing.JButton()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.alwaysJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.alwaysActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.alwaysActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(250, 150))
        this.titleJLabel.setText("Always Condition Options")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        this.jLabel2.setText("On:")
        this.alwaysJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel[Object](Array[String]("true", "false").asInstanceOf[Array[Object]]))
        var alwaysActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.alwaysActionJDialog.getContentPane())
        this.alwaysActionJDialog.getContentPane().setLayout(alwaysActionJDialogLayout)
        alwaysActionJDialogLayout.setHorizontalGroup(alwaysActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(alwaysActionJDialogLayout.createSequentialGroup().addGroup(alwaysActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(alwaysActionJDialogLayout.createSequentialGroup().addGap(47, 47, 47).addGroup(alwaysActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, alwaysActionJDialogLayout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(alwaysJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(titleJLabel))).addGroup(alwaysActionJDialogLayout.createSequentialGroup().addGap(79, 79, 79).addComponent(okJButton))).addContainerGap(45, _root_.java.lang.Short.MAX_VALUE)))
        alwaysActionJDialogLayout.setVerticalGroup(alwaysActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(alwaysActionJDialogLayout.createSequentialGroup().addContainerGap().addComponent(titleJLabel).addGap(20, 20, 20).addGroup(alwaysActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(alwaysJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)).addGap(15, 15, 15).addComponent(okJButton).addContainerGap()))
        setMinimumSize(new _root_.java.awt.Dimension(100, 0))
        this.alwaysActionJButton.setText("Edit")
        this.alwaysActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    alwaysActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Always:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, _root_.java.lang.Short.MAX_VALUE).addComponent(alwaysActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(alwaysActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.update()
        this.getAlwaysActionJDialog().setVisible(false)
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def alwaysActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.getAlwaysActionJDialog().setVisible(true)
    }

}


