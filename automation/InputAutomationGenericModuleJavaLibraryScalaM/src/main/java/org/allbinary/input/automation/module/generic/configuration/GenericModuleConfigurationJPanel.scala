/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfile
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfileDataWorkerType
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActions
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActionsJPanel
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class GenericModuleConfigurationJPanel() extends _root_.javax.swing.JPanel with GenericModuleConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val stringUtil : StringUtil = StringUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var genericProfiles : GenericProfiles = null

    private var selectedGenericProfile : GenericProfile = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var blankGenericProfileActionsJPanel : _root_.javax.swing.JPanel = null

    private var buttonGroup2 : _root_.javax.swing.ButtonGroup = null

    private var captureComparisonJCheckBox : _root_.javax.swing.JCheckBox = null

    private var captureMotionAnalysisJCheckBox : _root_.javax.swing.JCheckBox = null

    private var deleteProfileJButton : _root_.javax.swing.JButton = null

    private var genericJTabbedPane : _root_.javax.swing.JTabbedPane = null

    private var genericProfilesJList : _root_.javax.swing.JList[Object] = null

    private var genericProfilesJPanel : _root_.javax.swing.JPanel = null

    private var genericProfilesJScrollPane : _root_.javax.swing.JScrollPane = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var newProfileJButton : _root_.javax.swing.JButton = null

    private var newProfileJDialog : _root_.javax.swing.JDialog = null

    private var newProfileNameJLabel : _root_.javax.swing.JLabel = null

    private var newProfileNameJTextField : _root_.javax.swing.JTextField = null

    private var okNewProfileJButton : _root_.javax.swing.JButton = null

    private var savedCaptureJRadioButton : _root_.javax.swing.JRadioButton = null

    private var screenCaptureJRadioButton : _root_.javax.swing.JRadioButton = null

    //Constructor
    {
        this.initComponents()
        this.setGenericProfiles(new GenericProfiles(GenericProfiles.DEFAULT_FILE))
        this.selectFirstElement()
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.newProfileJDialog = new _root_.javax.swing.JDialog()
        this.okNewProfileJButton = new _root_.javax.swing.JButton()
        this.newProfileNameJLabel = new _root_.javax.swing.JLabel()
        this.newProfileNameJTextField = new _root_.javax.swing.JTextField()
        this.buttonGroup2 = new _root_.javax.swing.ButtonGroup()
        this.genericJTabbedPane = new _root_.javax.swing.JTabbedPane()
        this.genericProfilesJPanel = new _root_.javax.swing.JPanel()
        this.genericProfilesJScrollPane = new _root_.javax.swing.JScrollPane()
        this.genericProfilesJList = new _root_.javax.swing.JList[Object]()
        this.newProfileJButton = new _root_.javax.swing.JButton()
        this.deleteProfileJButton = new _root_.javax.swing.JButton()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.screenCaptureJRadioButton = new _root_.javax.swing.JRadioButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.savedCaptureJRadioButton = new _root_.javax.swing.JRadioButton()
        this.captureMotionAnalysisJCheckBox = new _root_.javax.swing.JCheckBox()
        this.captureComparisonJCheckBox = new _root_.javax.swing.JCheckBox()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.blankGenericProfileActionsJPanel = new _root_.javax.swing.JPanel()
        this.newProfileJDialog.setMinimumSize(new _root_.java.awt.Dimension(250, 150))
        this.newProfileJDialog.setResizable(false)
        this.okNewProfileJButton.setText("Ok")
        this.okNewProfileJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okNewProfileJButtonActionPerformed(evt)
                }

            })
        this.newProfileNameJLabel.setText("New Profile Name")
        var newProfileJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.newProfileJDialog.getContentPane())
        this.newProfileJDialog.getContentPane().setLayout(newProfileJDialogLayout)
        newProfileJDialogLayout.setHorizontalGroup(newProfileJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(newProfileJDialogLayout.createSequentialGroup().addGroup(newProfileJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(newProfileJDialogLayout.createSequentialGroup().addGap(80, 80, 80).addComponent(newProfileNameJLabel)).addGroup(newProfileJDialogLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(newProfileNameJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 180, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(newProfileJDialogLayout.createSequentialGroup().addGap(100, 100, 100).addComponent(okNewProfileJButton))).addContainerGap(35, _root_.java.lang.Short.MAX_VALUE)))
        newProfileJDialogLayout.setVerticalGroup(newProfileJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(newProfileJDialogLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(newProfileNameJLabel).addGap(16, 16, 16).addComponent(newProfileNameJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20).addComponent(okNewProfileJButton)))
        setLayout(new _root_.java.awt.GridLayout(1, 0))
        setMinimumSize(new _root_.java.awt.Dimension(400, 300))
        setPreferredSize(new _root_.java.awt.Dimension(700, 700))
        this.genericJTabbedPane.setToolTipText(this.stringUtil.EMPTY_STRING)
        this.genericJTabbedPane.setMinimumSize(new _root_.java.awt.Dimension(800, 600))
        this.genericProfilesJPanel.setMinimumSize(new _root_.java.awt.Dimension(400, 300))
        this.genericProfilesJPanel.setPreferredSize(new _root_.java.awt.Dimension(0, 0))
        this.genericProfilesJList.addListSelectionListener(new _root_.javax.swing.event.ListSelectionListener {
                override def valueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
                    genericProfilesJListValueChanged(evt)
                }

            })
        this.genericProfilesJScrollPane.setViewportView(this.genericProfilesJList)
        this.newProfileJButton.setText("New")
        this.newProfileJButton.setToolTipText("Creates a new profile")
        this.newProfileJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newProfileJButtonActionPerformed(evt)
                }

            })
        this.deleteProfileJButton.setText("Delete")
        this.deleteProfileJButton.setToolTipText("Deletes the selected profile")
        this.deleteProfileJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    deleteProfileJButtonActionPerformed(evt)
                }

            })
        this.jPanel1.setPreferredSize(new _root_.java.awt.Dimension(1000, 100))
        this.screenCaptureJRadioButton.setText("Screen Captures")
        this.screenCaptureJRadioButton.setToolTipText("Records the screen into memory for logical processing")
        this.screenCaptureJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.screenCaptureJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.screenCaptureJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    screenCaptureJRadioButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Profile Options")
        this.jLabel2.setText("Process From:")
        this.savedCaptureJRadioButton.setText("Saved Images")
        this.savedCaptureJRadioButton.setToolTipText("Loads images from files for logical processing.  Usually for debugging your profile actions")
        this.savedCaptureJRadioButton.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.savedCaptureJRadioButton.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.savedCaptureJRadioButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    savedCaptureJRadioButtonActionPerformed(evt)
                }

            })
        this.captureMotionAnalysisJCheckBox.setText("Motion Analysis")
        this.captureMotionAnalysisJCheckBox.setToolTipText("Uses image comparison and contraints to locate moving objects")
        this.captureMotionAnalysisJCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.captureMotionAnalysisJCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.captureMotionAnalysisJCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    captureMotionAnalysisJCheckBoxActionPerformed(evt)
                }

            })
        this.captureComparisonJCheckBox.setText("Comparison")
        this.captureComparisonJCheckBox.setToolTipText("Compares the last two input images for multi image logic")
        this.captureComparisonJCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.captureComparisonJCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.captureComparisonJCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    captureComparisonJCheckBoxActionPerformed(evt)
                }

            })
        this.jLabel3.setText("Image Processing:")
        this.jLabel3.setToolTipText("Turns on/off various extended image processing")
        var jPanel1Layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(screenCaptureJRadioButton).addComponent(jLabel1).addComponent(jLabel2).addComponent(savedCaptureJRadioButton).addComponent(captureMotionAnalysisJCheckBox).addComponent(captureComparisonJCheckBox).addComponent(jLabel3)).addContainerGap(22, _root_.java.lang.Short.MAX_VALUE)))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addGap(7, 7, 7).addComponent(screenCaptureJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(savedCaptureJRadioButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addGap(7, 7, 7).addComponent(captureComparisonJCheckBox).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(captureMotionAnalysisJCheckBox).addContainerGap(106, _root_.java.lang.Short.MAX_VALUE)))
        var genericProfilesJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.genericProfilesJPanel)
        this.genericProfilesJPanel.setLayout(genericProfilesJPanelLayout)
        genericProfilesJPanelLayout.setHorizontalGroup(genericProfilesJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(genericProfilesJPanelLayout.createSequentialGroup().addGroup(genericProfilesJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(genericProfilesJPanelLayout.createSequentialGroup().addComponent(newProfileJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(deleteProfileJButton)).addGroup(genericProfilesJPanelLayout.createSequentialGroup().addComponent(genericProfilesJScrollPane, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 119, _root_.java.lang.Short.MAX_VALUE))).addContainerGap()))
        genericProfilesJPanelLayout.setVerticalGroup(genericProfilesJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(genericProfilesJPanelLayout.createSequentialGroup().addGroup(genericProfilesJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(newProfileJButton).addComponent(deleteProfileJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(genericProfilesJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 246, _root_.java.lang.Short.MAX_VALUE).addComponent(genericProfilesJScrollPane, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 246, _root_.java.lang.Short.MAX_VALUE))))
        this.genericJTabbedPane.addTab("Profiles", genericProfilesJPanel)
        var blankGenericProfileActionsJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.blankGenericProfileActionsJPanel)
        this.blankGenericProfileActionsJPanel.setLayout(blankGenericProfileActionsJPanelLayout)
        blankGenericProfileActionsJPanelLayout.setHorizontalGroup(blankGenericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 395, _root_.java.lang.Short.MAX_VALUE))
        blankGenericProfileActionsJPanelLayout.setVerticalGroup(blankGenericProfileActionsJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 275, _root_.java.lang.Short.MAX_VALUE))
        this.genericJTabbedPane.addTab("Actions", blankGenericProfileActionsJPanel)
        add(this.genericJTabbedPane)
    }

    // </editor-fold>//GEN-END:initComponents
    private def savedCaptureJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_savedCaptureJRadioButtonActionPerformed
        try {
            if (this.savedCaptureJRadioButton.isSelected()) {
                this.logUtil.putF("Selected", this, "savedCaptureJRadioButtonActionPerformed")
                this.getSelectedGenericProfile().add(GenericProfileDataWorkerType.SAVED_CAPTURE)
                this.getSelectedGenericProfile().remove(GenericProfileDataWorkerType.SCREEN_CAPTURE)
                this.screenCaptureJRadioButton.setSelected(false)
                this.getGenericProfiles().save()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "savedCaptureJRadioButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_savedCaptureJRadioButtonActionPerformed
    private def screenCaptureJRadioButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_screenCaptureJRadioButtonActionPerformed
        try {
            if (this.screenCaptureJRadioButton.isSelected()) {
                this.logUtil.putF("Selected", this, "screenCaptureJRadioButtonActionPerformed")
                this.getSelectedGenericProfile().add(GenericProfileDataWorkerType.SCREEN_CAPTURE)
                this.getSelectedGenericProfile().remove(GenericProfileDataWorkerType.SAVED_CAPTURE)
                this.savedCaptureJRadioButton.setSelected(false)
                this.getGenericProfiles().save()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "screenCaptureJRadioButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_screenCaptureJRadioButtonActionPerformed
    private def captureMotionAnalysisJCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_captureMotionAnalysisJCheckBoxActionPerformed
        try {
            if (this.captureMotionAnalysisJCheckBox.isSelected()) {
                this.getSelectedGenericProfile().add(GenericProfileDataWorkerType.MOTION)
            } else {
                this.getSelectedGenericProfile().remove(GenericProfileDataWorkerType.MOTION)
            }
            this.getGenericProfiles().save()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "captureComparisonJCheckBoxActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_captureMotionAnalysisJCheckBoxActionPerformed
    private def captureComparisonJCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            if (this.captureComparisonJCheckBox.isSelected()) {
                this.getSelectedGenericProfile().add(GenericProfileDataWorkerType.COMPARISON)
            } else {
                this.getSelectedGenericProfile().remove(GenericProfileDataWorkerType.COMPARISON)
            }
            this.getGenericProfiles().save()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "captureComparisonJCheckBoxActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_captureComparisonJCheckBoxActionPerformed
    private def updateProfileUI(profileNameString : String) : Unit = {
        this.getBlankGenericProfileActionsJPanel().removeAll()
        if (profileNameString != null) {
            var genericProfileActionsJPanel : GenericProfileActionsJPanel = new GenericProfileActionsJPanel()
            //Load actions for a given profile
            this.setSelectedGenericProfile(this.getGenericProfiles().get(profileNameString))
            this.getSelectedGenericProfile().setGenericProfileActions(new GenericProfileActions(genericProfileActionsJPanel, profileNameString))
            //this.getSelectedGenericProfile().getGenericProfileActions().addListener(this);
            genericProfileActionsJPanel.setGenericProfileActions(this.getSelectedGenericProfile().getGenericProfileActions())
            genericProfileActionsJPanel.selectFirstElement()
            var layout : _root_.javax.swing.GroupLayout = this.getBlankGenericProfileActionsJPanel().getLayout().asInstanceOf[_root_.javax.swing.GroupLayout]
            layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 395, _root_.java.lang.Short.MAX_VALUE).addComponent(genericProfileActionsJPanel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
            layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, _root_.java.lang.Short.MAX_VALUE).addComponent(genericProfileActionsJPanel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
            //Set selected profile options
            this.updateProfileOptions()
            this.logUtil.putF("Setting Configuration Profile JPanel", this, "updateProfileUI")
        } else {
            this.logUtil.putF("Null Configuration Profile", this, "updateProfileUI")
        }
    }

    private def selectFirstElement() : Unit = {
        this.genericProfilesJList.setModel(this.getGenericProfiles().getDefaultListModelHelper().getListModel())
        if (this.genericProfilesJList.getModel().getSize() > 0) {
            this.genericProfilesJList.setSelectedValue(this.genericProfilesJList.getModel().getElementAt(0), true)
            this.updateProfileUI(this.genericProfilesJList.getModel().getElementAt(0).asInstanceOf[String])
        }
    }

    private def updateProfileOptions() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "updateProfileOptions")
        var genericProfile : GenericProfile = this.getSelectedGenericProfile()
        var vector : BasicArrayList = genericProfile.getGenericProfileDataWorkerTypeVector()
        this.screenCaptureJRadioButton.setSelected(false)
        this.savedCaptureJRadioButton.setSelected(false)
        this.captureComparisonJCheckBox.setSelected(false)
        this.captureMotionAnalysisJCheckBox.setSelected(false)
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var genericProfileDataWorkerType : GenericProfileDataWorkerType = vector.get(index).asInstanceOf[GenericProfileDataWorkerType]
                this.logUtil.putF((genericProfile.getName() + " has GenericProfileDataWorkerType: ") + genericProfileDataWorkerType.toString(), this, "updateProfileOptions")
                if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.SCREEN_CAPTURE) {
                    this.logUtil.putF("Screen Capture Selected", this, "updateProfileOptions")
                    this.screenCaptureJRadioButton.setSelected(true)
                } else if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.SAVED_CAPTURE) {
                    this.logUtil.putF("Saved Capture Selected", this, "updateProfileOptions")
                    this.savedCaptureJRadioButton.setSelected(true)
                } else if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.COMPARISON) {
                    this.logUtil.putF("Checking Comparison Box", this, "updateProfileOptions")
                    this.captureComparisonJCheckBox.setSelected(true)
                } else if (genericProfileDataWorkerType eq GenericProfileDataWorkerType.MOTION) {
                    this.logUtil.putF("Checking Motion Box", this, "updateProfileOptions")
                    this.captureMotionAnalysisJCheckBox.setSelected(true)
                }
                index += 1
            }
        }
        if (!this.screenCaptureJRadioButton.isSelected() && !this.savedCaptureJRadioButton.isSelected()) {
            this.screenCaptureJRadioButton.setSelected(true)
            this.getSelectedGenericProfile().add(GenericProfileDataWorkerType.SCREEN_CAPTURE)
        }
        this.logUtil.putF(this.commonStrings.END, this, "updateProfileOptions")
    }

    def getBlankGenericProfileActionsJPanel() : _root_.javax.swing.JPanel = {
        return this.blankGenericProfileActionsJPanel
    }

    def setBlankGenericProfileActionsJPanel(blankGenericProfileActionsJPanel : _root_.javax.swing.JPanel) : Unit = {
        this.blankGenericProfileActionsJPanel = blankGenericProfileActionsJPanel
    }

    private def getGenericProfiles() : GenericProfiles = {
        return this.genericProfiles
    }

    private def setGenericProfiles(genericProfiles : GenericProfiles) : Unit = {
        this.genericProfiles = genericProfiles
    }

    def getSelectedGenericProfile() : GenericProfile = {
        return this.selectedGenericProfile
    }

    def setSelectedGenericProfile(selectedGenericProfile : GenericProfile) : Unit = {
        this.selectedGenericProfile = selectedGenericProfile
    }

    private def genericProfilesJListValueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var profileNameString : String = this.genericProfilesJList.getSelectedValue().asInstanceOf[String]
            this.updateProfileUI(profileNameString)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "genericProfilesJListValueChanged", e)
            }
        }
    }

    //GEN-LAST:event_genericProfilesJListValueChanged
    private def deleteProfileJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var anyType : Array[Object] = this.genericProfilesJList.getSelectedValues()

            {
                var index : Int = 0
                while (index < anyType.length) {
                    var nextSelectedValueString : String = anyType(index).asInstanceOf[String]
                    this.getGenericProfiles().remove(nextSelectedValueString)
                    index += 1
                }
            }
            this.selectFirstElement()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "deleteProfileJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_deleteProfileJButtonActionPerformed
    private def okNewProfileJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            var newProfileName : String = this.newProfileNameJTextField.getText()
            this.getGenericProfiles().add(newProfileName)
            this.genericProfilesJList.setModel(this.getGenericProfiles().getDefaultListModelHelper().getListModel())
            this.genericProfilesJList.setSelectedValue(newProfileName, true)
            this.newProfileJDialog.setVisible(false)
            this.updateProfileUI(newProfileName)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "okNewProfileJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_okNewProfileJButtonActionPerformed
    private def newProfileJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.newProfileJDialog.setVisible(true)
    }

}


