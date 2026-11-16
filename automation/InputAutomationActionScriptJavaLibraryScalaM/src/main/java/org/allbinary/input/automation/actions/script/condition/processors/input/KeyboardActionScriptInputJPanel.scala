/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.javax.swing.*
import _root_.org.allbinary.input.KeySingletonFactory
import _root_.org.allbinary.input.automation.robot.InputRobot
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.TempInputRobotNames
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class KeyboardActionScriptInputJPanel(param_keyActionScriptInputInterface : KeyboardActionScriptInputInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var keyActionScriptInputInterface : KeyboardActionScriptInputInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var addKeyJLabel : _root_.javax.swing.JLabel = null

    private var delayBetweenJLabel : _root_.javax.swing.JLabel = null

    private var delayJTextField : _root_.javax.swing.JTextField = null

    private var holdTimeJLabel : _root_.javax.swing.JLabel = null

    private var inputAutomationTypeJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var inputTypeJLabel : _root_.javax.swing.JLabel = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var keyActionJButton : _root_.javax.swing.JButton = null

    private var keyActionJDialog : _root_.javax.swing.JDialog = null

    private var keyIntegerJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var keyNameJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var normalJRadioButton : _root_.javax.swing.JRadioButton = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var pressJRadioButton : _root_.javax.swing.JRadioButton = null

    private var releaseJRadioButton : _root_.javax.swing.JRadioButton = null

    private var sequenceJRadioButton : _root_.javax.swing.JRadioButton = null

    private var simultaneousJRadioButton : _root_.javax.swing.JRadioButton = null

    private var testJLabel : _root_.javax.swing.JLabel = null

    private var textJTextField : _root_.javax.swing.JTextField = null

    private var timeJTextField : _root_.javax.swing.JTextField = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val keyActionScriptInputInterface : KeyboardActionScriptInputInterface = param_keyActionScriptInputInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.keyActionScriptInputInterface = keyActionScriptInputInterface
        var defaultComboBoxModel : DefaultComboBoxModel[Object] = new DefaultComboBoxModel[Object]()
        defaultComboBoxModel.addElement(TempInputRobotNames.DX_NAME)
        defaultComboBoxModel.addElement(InputRobot.NAME)
        this.inputAutomationTypeJComboBox.setModel(defaultComboBoxModel)
        //InputAutomationTypeDefaultComboBoxModelFactory.getInstance());
        this.keyNameJComboBox.setModel(KeyNameDefaultComboBoxModelFactory.getInstance())
        this.keyIntegerJComboBox.setModel(KeyCharDefaultComboBoxModelFactory.getInstance())
        if (this.keyActionScriptInputInterface.isNormal()) {
            this.normalJRadioButton.setSelected(true)
            this.pressJRadioButton.setSelected(false)
            this.releaseJRadioButton.setSelected(false)
        } else if (this.keyActionScriptInputInterface.isPress()) {
            this.normalJRadioButton.setSelected(false)
            this.pressJRadioButton.setSelected(true)
            this.releaseJRadioButton.setSelected(false)
        } else if (this.keyActionScriptInputInterface.isRelease()) {
            this.normalJRadioButton.setSelected(false)
            this.pressJRadioButton.setSelected(false)
            this.releaseJRadioButton.setSelected(true)
        }
        this.set()
    }

    private def set() : Unit = {
        var inputTypeComboBoxModel : ComboBoxModel[Object] = this.inputAutomationTypeJComboBox.getModel().asInstanceOf[ComboBoxModel[Object]]
        inputTypeComboBoxModel.setSelectedItem(this.keyActionScriptInputInterface.getInputRobotInterface().getName())
        this.textJTextField.setText(this.keyActionScriptInputInterface.getText())
        this.delayJTextField.setText(Integer.toString(this.keyActionScriptInputInterface.getDelayBetweenKeys()))
        this.timeJTextField.setText(Integer.toString(this.keyActionScriptInputInterface.getTime()))
        this.keyActionScriptInputInterface.log()
    }

    private def updateInputType() : Unit = {
        var comboBoxModel : ComboBoxModel[Object] = this.inputAutomationTypeJComboBox.getModel().asInstanceOf[ComboBoxModel[Object]]
        var selectedItem : String = comboBoxModel.getSelectedItem().asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(selectedItem)) {
            this.keyActionScriptInputInterface.setInputRobotInterface(InputRobotFactory.getInstance().get(selectedItem))
        }
    }

    private def getSelectedKey() : Integer = {
        var comboBoxModel : ComboBoxModel[Object] = this.keyNameJComboBox.getModel().asInstanceOf[ComboBoxModel[Object]]
        var selectedItem : String = comboBoxModel.getSelectedItem().asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(selectedItem)) {
            return KeySingletonFactory.getHashtable().get(selectedItem).asInstanceOf[Integer]
        }
        return null
    }

    private def updateKeys() : Unit = {
        var text : String = this.textJTextField.getText()
        this.keyActionScriptInputInterface.setText(text)
    }

    private def update() : Unit = {
        this.updateInputType()
        this.updateKeys()
        this.keyActionScriptInputInterface.setTime(Integer.valueOf(this.timeJTextField.getText()).intValue())
        this.keyActionScriptInputInterface.log()
    }

    def getKeyActionJDialog() : _root_.javax.swing.JDialog = {
        return this.keyActionJDialog
    }

    def setKeyActionJDialog(keyActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.keyActionJDialog = keyActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.keyActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.addKeyJLabel = new _root_.javax.swing.JLabel()
        this.keyNameJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.timeJTextField = new _root_.javax.swing.JTextField()
        this.holdTimeJLabel = new _root_.javax.swing.JLabel()
        this.inputAutomationTypeJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.inputTypeJLabel = new _root_.javax.swing.JLabel()
        this.delayJTextField = new _root_.javax.swing.JTextField()
        this.delayBetweenJLabel = new _root_.javax.swing.JLabel()
        this.testJLabel = new _root_.javax.swing.JLabel()
        this.textJTextField = new _root_.javax.swing.JTextField()
        this.pressJRadioButton = new _root_.javax.swing.JRadioButton()
        this.releaseJRadioButton = new _root_.javax.swing.JRadioButton()
        this.normalJRadioButton = new _root_.javax.swing.JRadioButton()
        this.simultaneousJRadioButton = new _root_.javax.swing.JRadioButton()
        this.sequenceJRadioButton = new _root_.javax.swing.JRadioButton()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.okJButton = new _root_.javax.swing.JButton()
        this.keyIntegerJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.keyActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.keyActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(255, 280))
        this.titleJLabel.setHorizontalAlignment(_root_.javax.swing.SwingConstants.CENTER)
        this.titleJLabel.setText("Keyboard Input Options")
        this.addKeyJLabel.setText("Add Key:")
        this.keyNameJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    keyNameJComboBoxActionPerformed(evt)
                }

            })
        this.timeJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.holdTimeJLabel.setText("Hold Time (ms):")
        this.inputTypeJLabel.setText("Input Type:")
        this.delayJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.delayBetweenJLabel.setText("Delay Between Keys (ms):")
        this.testJLabel.setText("Text:")
        this.textJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.pressJRadioButton.setText("Press")
        this.pressJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.pressJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.pressJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    pressJRadioButtonActionPerformed(evt)
                }

            })
        this.releaseJRadioButton.setText("Release")
        this.releaseJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.releaseJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.releaseJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    releaseJRadioButtonActionPerformed(evt)
                }

            })
        this.normalJRadioButton.setSelected(true)
        this.normalJRadioButton.setText("Normal")
        this.normalJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.normalJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.normalJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    normalJRadioButtonActionPerformed(evt)
                }

            })
        this.simultaneousJRadioButton.setSelected(true)
        this.simultaneousJRadioButton.setText("Simultaneous")
        this.simultaneousJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.simultaneousJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.simultaneousJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    simultaneousJRadioButtonActionPerformed(evt)
                }

            })
        this.sequenceJRadioButton.setText("Sequence")
        this.sequenceJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.sequenceJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.sequenceJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    sequenceJRadioButtonActionPerformed(evt)
                }

            })
        this.okJButton.setText("OK")
        this.okJButton.setHorizontalTextPosition(_root_.javax.swing.SwingConstants.CENTER)
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        this.jPanel1.add(this.okJButton)
        this.keyIntegerJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    keyIntegerJComboBoxActionPerformed(evt)
                }

            })
        var keyActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.keyActionJDialog.getContentPane())
        this.keyActionJDialog.getContentPane().setLayout(keyActionJDialogLayout)
        keyActionJDialogLayout.setHorizontalGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(keyActionJDialogLayout.createSequentialGroup().addContainerGap().addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(keyActionJDialogLayout.createSequentialGroup().addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(addKeyJLabel, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(inputTypeJLabel, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(inputAutomationTypeJComboBox, 0, 148, _root_.java.lang.Short.MAX_VALUE).addComponent(textJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 148, _root_.java.lang.Short.MAX_VALUE).addGroup(keyActionJDialogLayout.createSequentialGroup().addComponent(keyNameJComboBox, 0, 101, _root_.java.lang.Short.MAX_VALUE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(keyIntegerJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 41, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)))).addComponent(testJLabel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 60, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(keyActionJDialogLayout.createSequentialGroup().addComponent(normalJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pressJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(releaseJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, keyActionJDialogLayout.createSequentialGroup().addComponent(holdTimeJLabel).addGap(22, 22, 22).addComponent(timeJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 113, _root_.java.lang.Short.MAX_VALUE)).addGroup(keyActionJDialogLayout.createSequentialGroup().addComponent(delayBetweenJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, _root_.java.lang.Short.MAX_VALUE).addComponent(delayJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 68, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(keyActionJDialogLayout.createSequentialGroup().addComponent(simultaneousJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(sequenceJRadioButton))).addContainerGap()).addComponent(titleJLabel, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 229, _root_.java.lang.Short.MAX_VALUE).addComponent(jPanel1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 229, _root_.java.lang.Short.MAX_VALUE))
        keyActionJDialogLayout.setVerticalGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(keyActionJDialogLayout.createSequentialGroup().addComponent(titleJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(inputTypeJLabel).addComponent(inputAutomationTypeJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(addKeyJLabel).addComponent(keyIntegerJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(keyNameJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(testJLabel).addComponent(textJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(pressJRadioButton).addComponent(normalJRadioButton).addComponent(releaseJRadioButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(holdTimeJLabel).addComponent(timeJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(delayBetweenJLabel).addComponent(delayJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(keyActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(simultaneousJRadioButton).addComponent(sequenceJRadioButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()))
        setMinimumSize(new _root_.java.awt.Dimension(100, 0))
        this.keyActionJButton.setText("Edit")
        this.keyActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    keyActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Key:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, _root_.java.lang.Short.MAX_VALUE).addComponent(keyActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(keyActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def prependText(integer : Integer) : Unit = {
        if (integer != null) {
            var newKey : String = ("&#" + integer.toString()) + ";"
            this.textJTextField.setText(newKey + this.textJTextField.getText())
        }
    }

    private def keyIntegerJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_keyIntegerJComboBoxActionPerformed
        this.keyIntegerJComboBox.getSelectedIndex()
        this.keyNameJComboBox.setSelectedIndex(this.keyIntegerJComboBox.getSelectedIndex())
    }

    //GEN-LAST:event_keyIntegerJComboBoxActionPerformed
    private def sequenceJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_sequenceJRadioButtonActionPerformed
        if (this.sequenceJRadioButton.isSelected()) {
            this.delayJTextField.setText(CommonPhoneStrings.getInstance().ONE)
            this.simultaneousJRadioButton.setSelected(false)
        }
    }

    //GEN-LAST:event_sequenceJRadioButtonActionPerformed
    private def simultaneousJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_simultaneousJRadioButtonActionPerformed
        if (this.simultaneousJRadioButton.isSelected()) {
            this.delayJTextField.setText(CommonPhoneStrings.getInstance().ZERO)
            this.sequenceJRadioButton.setSelected(false)
        }
    }

    //GEN-LAST:event_simultaneousJRadioButtonActionPerformed
    private def keyNameJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_keyNameJComboBoxActionPerformed
        var integer : Integer = this.getSelectedKey()
        this.prependText(integer)
        this.keyIntegerJComboBox.setSelectedIndex(this.keyNameJComboBox.getSelectedIndex())
    }

    //GEN-LAST:event_keyNameJComboBoxActionPerformed
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_okJButtonActionPerformed
        try {
            this.update()
            this.getKeyActionJDialog().setVisible(false)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "okButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def keyActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_keyActionJButtonActionPerformed
        this.getKeyActionJDialog().setVisible(true)
    }

    //GEN-LAST:event_keyActionJButtonActionPerformed
    private def normalJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_normalJRadioButtonActionPerformed
        if (this.normalJRadioButton.isSelected()) {
            this.keyActionScriptInputInterface.setNormal()
            this.pressJRadioButton.setSelected(false)
            this.releaseJRadioButton.setSelected(false)
        }
    }

    private def releaseJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_releaseJRadioButtonActionPerformed
        if (this.releaseJRadioButton.isSelected()) {
            this.keyActionScriptInputInterface.setRelease(true)
            this.keyActionScriptInputInterface.setPress(false)
            this.pressJRadioButton.setSelected(false)
            this.normalJRadioButton.setSelected(false)
        }
    }

    //GEN-LAST:event_releaseJRadioButtonActionPerformed
    private def pressJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_pressJRadioButtonActionPerformed
        if (this.pressJRadioButton.isSelected()) {
            this.keyActionScriptInputInterface.setPress(true)
            this.keyActionScriptInputInterface.setRelease(false)
            this.releaseJRadioButton.setSelected(false)
            this.normalJRadioButton.setSelected(false)
        }
    }

}


