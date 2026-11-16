/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.swing.*
import _root_.org.allbinary.input.media.image.InputImageType
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class ImageActionScriptOutputJPanel(param_capturedImageActionScriptOutputInterface : ImageActionScriptOutputInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var capturedImageActionScriptOutputInterface : ImageActionScriptOutputInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var capturedImageActionJButton : _root_.javax.swing.JButton = null

    private var capturedImageActionJDialog : _root_.javax.swing.JDialog = null

    private var displayJCheckBox : _root_.javax.swing.JCheckBox = null

    private var itemTypesJList : _root_.javax.swing.JList[Object] = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jScrollPane1 : _root_.javax.swing.JScrollPane = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var saveJCheckBox : _root_.javax.swing.JCheckBox = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val capturedImageActionScriptOutputInterface : ImageActionScriptOutputInterface = param_capturedImageActionScriptOutputInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.capturedImageActionScriptOutputInterface = capturedImageActionScriptOutputInterface
        this.set()
    }

    private def set() : Unit = {
        this.setImageTypeJlistModel()
        var imageTypes : ImageTypes = this.capturedImageActionScriptOutputInterface.getImageTypes()
        var vector : BasicArrayList = imageTypes.getVector()
        var selectedArray : Array[Int] = new Array[Int](vector.size())
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var imageType : InputImageType = vector.get(index).asInstanceOf[InputImageType]
                selectedArray({ val value_N77462 = index; index += 1; value_N77462 }) = imageType.getIndex()
                index += 1
            }
        }
        this.itemTypesJList.setSelectedIndices(selectedArray)
        if (this.capturedImageActionScriptOutputInterface.isSaved()) {
            this.saveJCheckBox.setSelected(true)
        }
        if (this.capturedImageActionScriptOutputInterface.isSaved()) {
            this.displayJCheckBox.setSelected(true)
        }
        this.capturedImageActionScriptOutputInterface.log()
    }

    private def update() : Unit = {
        var anyType : Array[Object] = this.itemTypesJList.getSelectedValues()
        var imageTypes : ImageTypes = ImageTypes.valueOf(anyType)
        this.capturedImageActionScriptOutputInterface.setImageTypes(imageTypes)
        if (this.saveJCheckBox.isSelected()) {
            this.capturedImageActionScriptOutputInterface.setSaved(true)
        } else {
            this.capturedImageActionScriptOutputInterface.setSaved(false)
        }
        if (this.displayJCheckBox.isSelected()) {
            this.capturedImageActionScriptOutputInterface.setDisplay(true)
        } else {
            this.capturedImageActionScriptOutputInterface.setDisplay(false)
        }
        this.capturedImageActionScriptOutputInterface.log()
    }

    private def setImageTypeJlistModel() : Unit = {
        var defaultListModel : DefaultListModel[Object] = new DefaultListModel[Object]()
        var vector : BasicArrayList = InputImageType.getAllAsVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var imageType : InputImageType = vector.get(index).asInstanceOf[InputImageType]
                defaultListModel.addElement(imageType.getName())
                index += 1
            }
        }
        this.itemTypesJList.setModel(defaultListModel)
    }

    def getCapturedImageActionJDialog() : _root_.javax.swing.JDialog = {
        return this.capturedImageActionJDialog
    }

    def setCapturedImageActionJDialog(capturedImageActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.capturedImageActionJDialog = capturedImageActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.capturedImageActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.okJButton = new _root_.javax.swing.JButton()
        this.saveJCheckBox = new _root_.javax.swing.JCheckBox()
        this.displayJCheckBox = new _root_.javax.swing.JCheckBox()
        this.jScrollPane1 = new _root_.javax.swing.JScrollPane()
        this.itemTypesJList = new _root_.javax.swing.JList[Object]()
        this.capturedImageActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.capturedImageActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(250, 250))
        this.titleJLabel.setText("Image Output Options")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        this.saveJCheckBox.setText("Save To File")
        this.saveJCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.saveJCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.displayJCheckBox.setText("Display")
        this.displayJCheckBox.setBorder(_root_.javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0))
        this.displayJCheckBox.setMargin(new _root_.java.awt.Insets(0, 0, 0, 0))
        this.displayJCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    displayJCheckBoxActionPerformed(evt)
                }

            })
        this.itemTypesJList.setModel(new _root_.javax.swing.AbstractListModel[Object] {
                var strings : Array[String] = Array[String]("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

                def getSize() : Int = {
                    return strings.length
                }

                def getElementAt(i : Int) : Object = {
                    return strings(i)
                }

            })
        this.jScrollPane1.setViewportView(this.itemTypesJList)
        var capturedImageActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.capturedImageActionJDialog.getContentPane())
        this.capturedImageActionJDialog.getContentPane().setLayout(capturedImageActionJDialogLayout)
        capturedImageActionJDialogLayout.setHorizontalGroup(capturedImageActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addGroup(capturedImageActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addGap(61, 61, 61).addComponent(titleJLabel)).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addContainerGap().addGroup(capturedImageActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(capturedImageActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(displayJCheckBox).addComponent(saveJCheckBox, _root_.javax.swing.GroupLayout.Alignment.TRAILING)).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addGap(84, 84, 84).addComponent(okJButton)))).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 216, _root_.java.lang.Short.MAX_VALUE))).addContainerGap()))
        capturedImageActionJDialogLayout.setVerticalGroup(capturedImageActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(capturedImageActionJDialogLayout.createSequentialGroup().addComponent(titleJLabel).addGap(5, 5, 5).addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 105, _root_.java.lang.Short.MAX_VALUE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(saveJCheckBox).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(displayJCheckBox).addGap(9, 9, 9).addComponent(okJButton).addContainerGap()))
        setMinimumSize(new _root_.java.awt.Dimension(100, 0))
        this.capturedImageActionJButton.setText("Edit")
        this.capturedImageActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    capturedImageActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Capture Image:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(capturedImageActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(capturedImageActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def displayJCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_displayJCheckBoxActionPerformed
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.update()
        this.getCapturedImageActionJDialog().setVisible(false)
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def capturedImageActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.getCapturedImageActionJDialog().setVisible(true)
    }

}


