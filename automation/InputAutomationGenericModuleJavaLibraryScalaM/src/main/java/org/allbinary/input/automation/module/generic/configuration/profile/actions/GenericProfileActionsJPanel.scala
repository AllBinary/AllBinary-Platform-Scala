/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions

import _root_.org.allbinary.input.automation.module.DefaultListModelHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class GenericProfileActionsJPanel() extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var genericProfileActions : GenericProfileActions = null

    private var genericProfileActionJPanel : GenericProfileActionJPanel = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var blankGenericProfileActionJPanel : _root_.javax.swing.JPanel = null

    private var deleteActionJButton : _root_.javax.swing.JButton = null

    private var genericProfileActionsJList : _root_.javax.swing.JList[Object] = null

    private var genericProfileActionsJPanel : _root_.javax.swing.JPanel = null

    private var genericProfileActionsJScrollPane : _root_.javax.swing.JScrollPane = null

    private var newActionJButton : _root_.javax.swing.JButton = null

    private var newProfileActionJDialog : _root_.javax.swing.JDialog = null

    private var newProfileActionJLabel : _root_.javax.swing.JLabel = null

    private var newProfileActionJTextField : _root_.javax.swing.JTextField = null

    private var okNewProfileActionJButton : _root_.javax.swing.JButton = null

    private var saveJButton : _root_.javax.swing.JButton = null

    /** Creates new form genericProfileActionsJPanel */
    //Constructor
    {
        this.initComponents()
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.newProfileActionJDialog = new _root_.javax.swing.JDialog()
        this.newProfileActionJLabel = new _root_.javax.swing.JLabel()
        this.okNewProfileActionJButton = new _root_.javax.swing.JButton()
        this.newProfileActionJTextField = new _root_.javax.swing.JTextField()
        this.genericProfileActionsJPanel = new _root_.javax.swing.JPanel()
        this.genericProfileActionsJScrollPane = new _root_.javax.swing.JScrollPane()
        this.genericProfileActionsJList = new _root_.javax.swing.JList[Object]()
        this.newActionJButton = new _root_.javax.swing.JButton()
        this.deleteActionJButton = new _root_.javax.swing.JButton()
        this.saveJButton = new _root_.javax.swing.JButton()
        this.blankGenericProfileActionJPanel = new _root_.javax.swing.JPanel()
        this.newProfileActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(250, 150))
        this.newProfileActionJDialog.setResizable(false)
        this.newProfileActionJLabel.setText("New Action Name")
        this.okNewProfileActionJButton.setText("Ok")
        this.okNewProfileActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okNewProfileActionJButtonActionPerformed(evt)
                }

            })
        var newProfileActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.newProfileActionJDialog.getContentPane())
        this.newProfileActionJDialog.getContentPane().setLayout(newProfileActionJDialogLayout)
        newProfileActionJDialogLayout.setHorizontalGroup(newProfileActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(newProfileActionJDialogLayout.createSequentialGroup().addGroup(newProfileActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(newProfileActionJDialogLayout.createSequentialGroup().addGap(93, 93, 93).addComponent(okNewProfileActionJButton)).addGroup(newProfileActionJDialogLayout.createSequentialGroup().addGap(75, 75, 75).addComponent(newProfileActionJLabel)).addGroup(newProfileActionJDialogLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(newProfileActionJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 178, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(34, _root_.java.lang.Short.MAX_VALUE)))
        newProfileActionJDialogLayout.setVerticalGroup(newProfileActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, newProfileActionJDialogLayout.createSequentialGroup().addContainerGap().addComponent(newProfileActionJLabel).addGap(21, 21, 21).addComponent(newProfileActionJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, _root_.java.lang.Short.MAX_VALUE).addComponent(okNewProfileActionJButton).addContainerGap()))
        this.genericProfileActionsJPanel.setPreferredSize(new _root_.java.awt.Dimension(10000, 10000))
        this.genericProfileActionsJList.addListSelectionListener(new _root_.javax.swing.event.ListSelectionListener {
                override def valueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
                    genericProfileActionsJListValueChanged(evt)
                }

            })
        this.genericProfileActionsJScrollPane.setViewportView(this.genericProfileActionsJList)
        this.newActionJButton.setText("New")
        this.newActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newActionJButtonActionPerformed(evt)
                }

            })
        this.deleteActionJButton.setText("Delete")
        this.deleteActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    deleteActionJButtonActionPerformed(evt)
                }

            })
        this.saveJButton.setText("Save")
        this.saveJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    saveJButtonActionPerformed(evt)
                }

            })
        this.blankGenericProfileActionJPanel.setMinimumSize(new _root_.java.awt.Dimension(500, 300))
        var blankGenericProfileActionJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.blankGenericProfileActionJPanel)
        this.blankGenericProfileActionJPanel.setLayout(blankGenericProfileActionJPanelLayout)
        blankGenericProfileActionJPanelLayout.setHorizontalGroup(blankGenericProfileActionJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 500, _root_.java.lang.Short.MAX_VALUE))
        blankGenericProfileActionJPanelLayout.setVerticalGroup(blankGenericProfileActionJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 296, _root_.java.lang.Short.MAX_VALUE))
        var genericProfileActionsJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.genericProfileActionsJPanel)
        this.genericProfileActionsJPanel.setLayout(genericProfileActionsJPanelLayout)
        genericProfileActionsJPanelLayout.setHorizontalGroup(genericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(genericProfileActionsJPanelLayout.createSequentialGroup().addComponent(genericProfileActionsJScrollPane, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 95, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(blankGenericProfileActionJPanel, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)).addGroup(genericProfileActionsJPanelLayout.createSequentialGroup().addComponent(newActionJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(deleteActionJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(saveJButton).addContainerGap()))
        genericProfileActionsJPanelLayout.setVerticalGroup(genericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(genericProfileActionsJPanelLayout.createSequentialGroup().addGroup(genericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(newActionJButton).addComponent(deleteActionJButton).addComponent(saveJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(genericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(blankGenericProfileActionJPanel, 0, 296, _root_.java.lang.Short.MAX_VALUE).addComponent(genericProfileActionsJScrollPane, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 296, _root_.java.lang.Short.MAX_VALUE)).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(genericProfileActionsJPanel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 596, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(genericProfileActionsJPanel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 336, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
    }

    // </editor-fold>//GEN-END:initComponents
    def setModel() : Unit = {
        var defaultListModelHelper : DefaultListModelHelper = this.getGenericProfileActions().getDefaultListModelHelper()
        if (defaultListModelHelper.getListModel().getSize() > 0) {
            this.genericProfileActionsJList.setModel(defaultListModelHelper.getListModel())
        }
    }

    private def saveJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            this.getGenericProfileActions().save()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "saveJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_saveJButtonActionPerformed
    private def updateProfileActionUI(profileActionNameString : String) : Unit = {
        this.blankGenericProfileActionJPanel.removeAll()
        if (profileActionNameString != null) {
            var genericProfileAction : GenericProfileAction = this.getGenericProfileActions().getAction(profileActionNameString)
            this.setGenericProfileActionJPanel(new GenericProfileActionJPanel())
            this.getGenericProfileActionJPanel().setGenericProfileAction(genericProfileAction)
            this.getGenericProfileActionJPanel().updateProfileActionUI()
            var layout : _root_.javax.swing.GroupLayout = this.blankGenericProfileActionJPanel.getLayout().asInstanceOf[_root_.javax.swing.GroupLayout]
            layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 395, _root_.java.lang.Short.MAX_VALUE).addComponent(this.getGenericProfileActionJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
            layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, _root_.java.lang.Short.MAX_VALUE).addComponent(this.getGenericProfileActionJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
            this.logUtil.putF("Setting Configuration Profile Actions JPanel", this, "genericProfileActionsJListValueChanged")
        }
    }

    private def genericProfileActionsJListValueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var profileActionNameString : String = this.genericProfileActionsJList.getSelectedValue().asInstanceOf[String]
            this.updateProfileActionUI(profileActionNameString)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "genericProfileActionsJListValueChanged", e)
            }
        }
    }

    //GEN-LAST:event_genericProfileActionsJListValueChanged
    private def okNewProfileActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var newActionName : String = this.newProfileActionJTextField.getText()
            this.getGenericProfileActions().add(newActionName)
            this.setModel()
            this.genericProfileActionsJList.setSelectedValue(newActionName, true)
            this.newProfileActionJDialog.setVisible(false)
            this.updateProfileActionUI(newActionName)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "okNewProfileActionJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_okNewProfileActionJButtonActionPerformed
    private def deleteActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var anyType : Array[Object] = this.genericProfileActionsJList.getSelectedValues()

            {
                var index : Int = 0
                while (index < anyType.length) {
                    var nextSelectedValueString : String = anyType(index).asInstanceOf[String]
                    this.getGenericProfileActions().remove(nextSelectedValueString)
                    index += 1
                }
            }
            this.selectFirstElement()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "deleteActionJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_deleteActionJButtonActionPerformed
    def selectFirstElement() : Unit = {
        this.setModel()
        if (this.genericProfileActionsJList.getModel().getSize() > 0) {
            this.genericProfileActionsJList.setSelectedValue(this.genericProfileActionsJList.getModel().getElementAt(0), true)
            this.updateProfileActionUI(this.genericProfileActionsJList.getModel().getElementAt(0).asInstanceOf[String])
        } else {
            //Clear the action window
            this.blankGenericProfileActionJPanel.removeAll()
            this.blankGenericProfileActionJPanel.repaint()
        }
    }

    def getGenericProfileActionJPanel() : GenericProfileActionJPanel = {
        return this.genericProfileActionJPanel
    }

    def setGenericProfileActionJPanel(genericProfileActionJPanel : GenericProfileActionJPanel) : Unit = {
        this.genericProfileActionJPanel = genericProfileActionJPanel
    }

    def getGenericProfileActions() : GenericProfileActions = {
        return this.genericProfileActions
    }

    def setGenericProfileActions(genericProfileActions : GenericProfileActions) : Unit = {
        this.genericProfileActions = genericProfileActions
    }

    private def newActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.newProfileActionJDialog.setVisible(true)
    }

}


