/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.RenderedImage
import _root_.java.io.File
import _root_.java.io.IOException
import _root_.javax.imageio.ImageIO
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.image.ImageArrayRotationUtil
import _root_.org.allbinary.media.image.ImageProcessedVisitor
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class RotationImageJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel() with ImageProcessedVisitor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val imageStrings : ImageStrings = ImageStrings.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    private var result : BufferedImage = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var generateJButton : _root_.javax.swing.JButton = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var jPanel2 : _root_.javax.swing.JPanel = null

    private var jPanel3 : _root_.javax.swing.JPanel = null

    private var totalAngleJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var writeOverOriginalJCheckBox : _root_.javax.swing.JCheckBox = null

    //Constructor
    {
        val imageProcessorInput : ImageProcessorInput = param_imageProcessorInput
        this.initComponents()
        this.imageProcessorInput = imageProcessorInput
    }

    def process() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val angleAsString : String = RotationImageJPanel.this.totalAngleJComboBox.getSelectedItem().asInstanceOf[String]
                        ImageArrayRotationUtil.getInstance().process(RotationImageJPanel.this.getImageProcessorInput(), angleAsString, RotationImageJPanel.this)
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.jPanel1 = new _root_.javax.swing.JPanel {
                override def paint(graphics : Graphics) : Unit = {
                    if (RotationImageJPanel.this.result != null) {
                        graphics.drawImage(RotationImageJPanel.this.result, 0, 0, RotationImageJPanel.this.result.getWidth(null), RotationImageJPanel.this.result.getHeight(null), null)
                    }
                }

            }
        this.jPanel2 = new _root_.javax.swing.JPanel()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.generateJButton = new _root_.javax.swing.JButton()
        this.totalAngleJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.writeOverOriginalJCheckBox = new _root_.javax.swing.JCheckBox()
        this.jPanel3 = new _root_.javax.swing.JPanel()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        var jPanel1Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(0, 436, _root_.java.lang.Short.MAX_VALUE))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(0, 227, _root_.java.lang.Short.MAX_VALUE))
        this.generateJButton.setText("Generate")
        this.generateJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateJButtonActionPerformed(evt)
                }

            })
        this.totalAngleJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel[Object](Array[String](this.commonStrings.UP, this.commonStrings.DOWN, "-90", "90").asInstanceOf[Array[Object]]))
        this.totalAngleJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    totalAngleJComboBoxActionPerformed(evt)
                }

            })
        this.jLabel3.setText("Total Angle:")
        //writeOverOriginalJCheckBox.setSelected(true);
        this.writeOverOriginalJCheckBox.setText("Write Over Original")
        var jPanel2Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel2)
        this.jPanel2.setLayout(jPanel2Layout)
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel2Layout.createSequentialGroup().add(8, 8, 8).add(jLabel1).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(jLabel3).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(totalAngleJComboBox, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(writeOverOriginalJCheckBox).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(generateJButton).addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel1).add(generateJButton).add(totalAngleJComboBox, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel3).add(writeOverOriginalJCheckBox)))
        this.jLabel2.setText("Results:")
        var jPanel3Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel3)
        this.jPanel3.setLayout(jPanel3Layout)
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel3Layout.createSequentialGroup().add(jLabel2).addContainerGap(377, _root_.java.lang.Short.MAX_VALUE)))
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jLabel2))
        var layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(_root_.org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).add(layout.createSequentialGroup().addContainerGap().add(jPanel3, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addContainerGap()).add(jPanel1, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().add(jPanel2, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.UNRELATED).add(jPanel3, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(jPanel1, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def generateJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.process()
    }

    //GEN-LAST:event_generateJButtonActionPerformed
    private def totalAngleJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    // End of variables declaration//GEN-END:variables
    def getImageProcessorInput() : ImageProcessorInput = {
        return this.imageProcessorInput
    }

    def setImageProcessorInput(imageProcessorInput : ImageProcessorInput) : Unit = {
        this.imageProcessorInput = imageProcessorInput
    }

    def visit(generatedBufferedImage : BufferedImage, name : String, index : Int) : Unit = {
        this.result = generatedBufferedImage
        //);
        this.getParent().repaint()
        var file : File = this.imageProcessorInput.getFiles()(index)
        if (!this.writeOverOriginalJCheckBox.isSelected()) {
            var filePath : String = file.getAbsolutePath()
            var extensionIndex : Int = filePath.indexOf(this.imageStrings.PNG_EXTENSION)
            filePath = new StringMaker().append(filePath.substring(0, extensionIndex)).append(CommonSeps.getInstance().UNDERSCORE).append(name).append(this.imageStrings.PNG_EXTENSION).toString()
            file = new File(filePath)
        }
        val isWritten : Boolean = ImageIO.write(RotationImageJPanel.this.result.asInstanceOf[RenderedImage], imageStrings.PNG, file)
        this.logUtil.putF((("File: " + file) + " Wrote: ") + isWritten, this, this.commonStrings.RUN)
    }

}


