/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.awt.event.InputEvent
import _root_.javax.swing.*
import _root_.org.allbinary.input.automation.robot.InputRobot
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.TempInputRobotNames
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class MouseActionScriptInputJPanel(param_mouseActionScriptInputInterface : MouseActionScriptInputInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var mouseActionScriptInputInterface : MouseActionScriptInputInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var button1JCheckBox : _root_.javax.swing.JCheckBox = null

    private var button2JCheckBox : _root_.javax.swing.JCheckBox = null

    private var inputAutomationTypeJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var inputTypeJLabel : _root_.javax.swing.JLabel = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jLabel4 : _root_.javax.swing.JLabel = null

    private var jLabel5 : _root_.javax.swing.JLabel = null

    private var jLabel6 : _root_.javax.swing.JLabel = null

    private var mouseActionJButton : _root_.javax.swing.JButton = null

    private var mouseActionJDialog : _root_.javax.swing.JDialog = null

    private var mouseDelayJTextField : _root_.javax.swing.JTextField = null

    private var mouseXJTextField : _root_.javax.swing.JTextField = null

    private var mouseYJTextField : _root_.javax.swing.JTextField = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val mouseActionScriptInputInterface : MouseActionScriptInputInterface = param_mouseActionScriptInputInterface
        this.logUtil.putF(CommonLabels.getInstance().START + mouseActionScriptInputInterface, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.mouseActionScriptInputInterface = mouseActionScriptInputInterface
        val defaultComboBoxModel : DefaultComboBoxModel[Object] = new DefaultComboBoxModel[Object]()
        defaultComboBoxModel.addElement(TempInputRobotNames.LOW_NAME)
        defaultComboBoxModel.addElement(TempInputRobotNames.SYS_NAME)
        defaultComboBoxModel.addElement(InputRobot.NAME)
        this.inputAutomationTypeJComboBox.setModel(defaultComboBoxModel)
        //InputAutomationTypeDefaultComboBoxModelFactory.getInstance());
        this.set()
    }

    private def set() : Unit = {
        val inputTypeComboBoxModel : ComboBoxModel[Object] = this.inputAutomationTypeJComboBox.getModel().asInstanceOf[ComboBoxModel[Object]]
        inputTypeComboBoxModel.setSelectedItem(this.mouseActionScriptInputInterface.getInputRobotInterface().getName())
        if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON1_MASK) != 0) {
            this.button1JCheckBox.setSelected(true)
        } else {
            this.button1JCheckBox.setSelected(false)
        }
        if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON2_MASK) != 0) {
            this.button2JCheckBox.setSelected(true)
        } else {
            this.button2JCheckBox.setSelected(false)
        }
        this.mouseDelayJTextField.setText(Integer.toString(this.mouseActionScriptInputInterface.getTime()))
        this.mouseXJTextField.setText(Integer.toString(this.mouseActionScriptInputInterface.getPoint().x))
        this.mouseYJTextField.setText(Integer.toString(this.mouseActionScriptInputInterface.getPoint().y))
        this.mouseActionScriptInputInterface.log()
    }

    private def updateInputType() : Unit = {
        val comboBoxModel : ComboBoxModel[Object] = this.inputAutomationTypeJComboBox.getModel().asInstanceOf[ComboBoxModel[Object]]
        val selectedItem : String = comboBoxModel.getSelectedItem().asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(selectedItem)) {
            this.mouseActionScriptInputInterface.setInputRobotInterface(InputRobotFactory.getInstance().get(selectedItem))
        }
    }

    private def update() : Unit = {
        this.updateInputType()
        this.mouseActionScriptInputInterface.setTime(Integer.valueOf(this.mouseDelayJTextField.getText()))
        this.logUtil.putF("Button State: " + this.mouseActionScriptInputInterface.getButtonClicks(), this, "update")
        if (this.button1JCheckBox.isSelected()) {
            if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON1_MASK) == 0) {
                this.mouseActionScriptInputInterface.setButtonClicks(this.mouseActionScriptInputInterface.getButtonClicks() | InputEvent.BUTTON1_MASK)
                this.logUtil.putF("Button 1 Selected: " + this.mouseActionScriptInputInterface.getButtonClicks(), this, "update")
            }
        } else {
            if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON1_MASK) != 0) {
                this.mouseActionScriptInputInterface.setButtonClicks(this.mouseActionScriptInputInterface.getButtonClicks() ^ InputEvent.BUTTON1_MASK)
                this.logUtil.putF("Button 1 Deselected: " + this.mouseActionScriptInputInterface.getButtonClicks(), this, "update")
            }
        }
        if (this.button2JCheckBox.isSelected()) {
            if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON2_MASK) == 0) {
                this.mouseActionScriptInputInterface.setButtonClicks(this.mouseActionScriptInputInterface.getButtonClicks() | InputEvent.BUTTON2_MASK)
                this.logUtil.putF("Button 2 Selected: " + this.mouseActionScriptInputInterface.getButtonClicks(), this, "update")
            }
        } else {
            if ((this.mouseActionScriptInputInterface.getButtonClicks() & InputEvent.BUTTON2_MASK) != 0) {
                this.mouseActionScriptInputInterface.setButtonClicks(this.mouseActionScriptInputInterface.getButtonClicks() ^ InputEvent.BUTTON2_MASK)
                this.logUtil.putF("Button 2 Deselected: " + this.mouseActionScriptInputInterface.getButtonClicks(), this, "update")
            }
        }
        var mouseXString : String = this.mouseXJTextField.getText()
        if (!StringValidationUtil.getInstance().isEmpty(mouseXString) && StringValidationUtil.getInstance().isNumber(mouseXString)) {
            this.mouseActionScriptInputInterface.getPoint().x = Integer.parseInt(mouseXString)
        }
        var mouseYString : String = this.mouseYJTextField.getText()
        if (!StringValidationUtil.getInstance().isEmpty(mouseYString) && StringValidationUtil.getInstance().isNumber(mouseYString)) {
            this.mouseActionScriptInputInterface.getPoint().y = Integer.parseInt(mouseYString)
        }
        this.mouseActionScriptInputInterface.log()
    }

    def getMouseActionJDialog() : _root_.javax.swing.JDialog = {
        return this.mouseActionJDialog
    }

    def setMouseActionJDialog(mouseActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.mouseActionJDialog = mouseActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.mouseActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.okJButton = new _root_.javax.swing.JButton()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.button1JCheckBox = new _root_.javax.swing.JCheckBox()
        this.button2JCheckBox = new _root_.javax.swing.JCheckBox()
        this.jLabel4 = new _root_.javax.swing.JLabel()
        this.mouseXJTextField = new _root_.javax.swing.JTextField()
        this.jLabel5 = new _root_.javax.swing.JLabel()
        this.mouseYJTextField = new _root_.javax.swing.JTextField()
        this.inputTypeJLabel = new _root_.javax.swing.JLabel()
        this.inputAutomationTypeJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.jLabel6 = new _root_.javax.swing.JLabel()
        this.mouseDelayJTextField = new _root_.javax.swing.JTextField()
        this.mouseActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.mouseActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(275, 185))
        this.titleJLabel.setText("Mouse Input Options")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        this.jLabel2.setText("Buttons:")
        this.jLabel3.setText("Move To:")
        this.button1JCheckBox.setText(CommonPhoneStrings.getInstance().ONE)
        this.button1JCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.button1JCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.button2JCheckBox.setText(CommonPhoneStrings.getInstance().TWO)
        this.button2JCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.button2JCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.button2JCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    button2JCheckBoxActionPerformed(evt)
                }

            })
        this.jLabel4.setText("x:")
        this.mouseXJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.jLabel5.setText("y:")
        this.mouseYJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.inputTypeJLabel.setText("Input Type:")
        this.jLabel6.setText("Delay:")
        this.mouseDelayJTextField.setText("100")
        var mouseActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.mouseActionJDialog.getContentPane())
        this.mouseActionJDialog.getContentPane().setLayout(mouseActionJDialogLayout)
        mouseActionJDialogLayout.setHorizontalGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(mouseActionJDialogLayout.createSequentialGroup().addContainerGap().addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(inputTypeJLabel).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, mouseActionJDialogLayout.createSequentialGroup().addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, mouseActionJDialogLayout.createSequentialGroup().addComponent(jLabel2).addGap(25, 25, 25)).addGroup(mouseActionJDialogLayout.createSequentialGroup().addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3).addComponent(jLabel6)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(mouseDelayJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 154, _root_.java.lang.Short.MAX_VALUE).addGroup(mouseActionJDialogLayout.createSequentialGroup().addComponent(titleJLabel).addGap(45, 45, 45)).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, mouseActionJDialogLayout.createSequentialGroup().addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(inputAutomationTypeJComboBox, 0, 154, _root_.java.lang.Short.MAX_VALUE)).addGroup(mouseActionJDialogLayout.createSequentialGroup().addComponent(button1JCheckBox).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(button2JCheckBox)).addGroup(mouseActionJDialogLayout.createSequentialGroup().addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addGroup(mouseActionJDialogLayout.createSequentialGroup().addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(okJButton)).addGroup(mouseActionJDialogLayout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, _root_.java.lang.Short.MAX_VALUE).addComponent(mouseXJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 59, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel5).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(mouseYJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 62, _root_.java.lang.Short.MAX_VALUE))))).addContainerGap()))
        mouseActionJDialogLayout.setVerticalGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(mouseActionJDialogLayout.createSequentialGroup().addComponent(titleJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(inputTypeJLabel).addComponent(inputAutomationTypeJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 15, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(button1JCheckBox).addComponent(button2JCheckBox))).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(mouseDelayJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(mouseActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5).addComponent(mouseYJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mouseXJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(okJButton).addContainerGap()))
        setMinimumSize(new _root_.java.awt.Dimension(100, 0))
        this.mouseActionJButton.setText("Edit")
        this.mouseActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    mouseActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Mouse:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, _root_.java.lang.Short.MAX_VALUE).addComponent(mouseActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(mouseActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def button2JCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_button2JCheckBoxActionPerformed
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            this.update()
            this.getMouseActionJDialog().setVisible(false)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "okButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def mouseActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.getMouseActionJDialog().setVisible(true)
    }

}


