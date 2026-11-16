/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.Raster
import _root_.java.io.File
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageProcessorInputCompositeInterface
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ResizeImageJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel() with ImageProcessorInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var aboveJButton : _root_.javax.swing.JButton = null

    private var adjustFor16AboveJButton : _root_.javax.swing.JButton = null

    private var adjustFor16BelowJButton : _root_.javax.swing.JButton = null

    private var floatPercentJTextField : _root_.javax.swing.JTextField = null

    private var jComboBox1 : _root_.javax.swing.JComboBox[String] = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jTextField1 : _root_.javax.swing.JTextField = null

    private var jTextField2 : _root_.javax.swing.JTextField = null

    private var updateJButton : _root_.javax.swing.JButton = null

    //Constructor
    {
        val imageProcessorInput : ImageProcessorInput = param_imageProcessorInput
        initComponents()
        this.imageProcessorInput = imageProcessorInput
        var numberStringArray : Array[String] = new Array[String](101)
        numberStringArray(0) = Integer.toString(-1)

        {
            var index : Int = 1
            while (index < 100) {
                numberStringArray(index) = Integer.toString(index)
                index += 1
            }
        }
        this.jComboBox1.setModel(new _root_.javax.swing.DefaultComboBoxModel(numberStringArray))
        val araster : Raster = this.imageProcessorInput.getBufferedImageArray()(0).getAlphaRaster()
        if (araster == null) {
            System.out.println("there is no Alpha channel!!!!!!!!!")
        } else {
            System.out.println("Alpha channel found !")
        }
    }

    def process() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val imageUtil : ImageUtil = ImageUtil.getInstance()
                        val percent : Integer = Integer.valueOf(ResizeImageJPanel.this.jComboBox1.getSelectedItem().asInstanceOf[String])
                        val percentAsFloat : _root_.java.lang.Float = _root_.java.lang.Float.parseFloat(ResizeImageJPanel.this.floatPercentJTextField.getText())
                        val imageProcessorInput : ImageProcessorInput = ResizeImageJPanel.this.getImageProcessorInput()
                        val files : Array[File] = imageProcessorInput.getFiles()
                        var generatedBufferedImageArray : Array[BufferedImage] = null
                        if (percentAsFloat.intValue() != -1) {
                            generatedBufferedImageArray = imageUtil.createBufferedImage2(imageProcessorInput.getBufferedImageArray(), percentAsFloat, true)
                        } else if (percent.intValue() != -1) {
                            generatedBufferedImageArray = imageUtil.createBufferedImageForResize(imageProcessorInput.getBufferedImageArray(), percent, true)
                        } else {
                            val width : Integer = Integer.valueOf(ResizeImageJPanel.this.jTextField1.getText().asInstanceOf[String])
                            val height : Integer = Integer.valueOf(ResizeImageJPanel.this.jTextField2.getText().asInstanceOf[String])
                            generatedBufferedImageArray = imageUtil.createBufferedImage3(imageProcessorInput.getBufferedImageArray(), width, height, true)
                        }
                        val araster : Raster = generatedBufferedImageArray(0).getAlphaRaster()
                        if (araster == null) {
                            System.out.println("No Alpha Channel In Result")
                        } else {
                            System.out.println("Found Alpha Channel In Result")
                        }
                        val imagePersistanceUtil : ImagePersistanceUtil = ImagePersistanceUtil.getInstance()

                        {
                            var index : Int = 0
                            while (index < generatedBufferedImageArray.length) {
                                imagePersistanceUtil.saveWithBatik(FileWrapperUtil.wrapFile(files(index)), generatedBufferedImageArray(index))
                                index += 1
                            }
                        }
                        ResizeImageJPanel.this.getParent().repaint()
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    def update() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val imageProcessorInput : ImageProcessorInput = ResizeImageJPanel.this.getImageProcessorInput()
                        val size : Int = imageProcessorInput.getBufferedImageArray().length
                        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()
                        var bufferedImage : BufferedImage = null

                        {
                            var index : Int = 0
                            while (index < size) {
                                bufferedImage = bufferedImageArray(0)
                                ResizeImageJPanel.this.jTextField1.setText(Integer.toString(bufferedImage.getWidth()))
                                ResizeImageJPanel.this.jTextField2.setText(Integer.toString(bufferedImage.getHeight()))
                                index += 1
                            }
                        }
                        ResizeImageJPanel.this.getParent().repaint()
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    def updateFor16Above() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val imageProcessorInput : ImageProcessorInput = ResizeImageJPanel.this.getImageProcessorInput()
                        val size : Int = imageProcessorInput.getBufferedImageArray().length
                        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()
                        var bufferedImage : BufferedImage = null

                        {
                            var index : Int = 0
                            while (index < size) {
                                bufferedImage = bufferedImageArray(0)
                                ResizeImageJPanel.this.jTextField1.setText(Integer.toString((bufferedImage.getWidth() / 16) * 16))
                                ResizeImageJPanel.this.jTextField2.setText(Integer.toString((bufferedImage.getHeight() / 16) * 16))
                                index += 1
                            }
                        }
                        ResizeImageJPanel.this.getParent().repaint()
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    def updateFor16Below() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val imageProcessorInput : ImageProcessorInput = ResizeImageJPanel.this.getImageProcessorInput()
                        val size : Int = imageProcessorInput.getBufferedImageArray().length
                        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()
                        var bufferedImage : BufferedImage = null

                        {
                            var index : Int = 0
                            while (index < size) {
                                bufferedImage = bufferedImageArray(0)
                                ResizeImageJPanel.this.jTextField1.setText(Integer.toString(((bufferedImage.getWidth() / 16) + 1) * 16))
                                ResizeImageJPanel.this.jTextField2.setText(Integer.toString(((bufferedImage.getHeight() / 16) + 1) * 16))
                                index += 1
                            }
                        }
                        ResizeImageJPanel.this.getParent().repaint()
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    def getImageProcessorInput() : ImageProcessorInput = {
        return this.imageProcessorInput
    }

    def setImageProcessorInput(imageProcessorInput : ImageProcessorInput) : Unit = {
        this.imageProcessorInput = imageProcessorInput
    }

    /**      * This method is called from within the constructor to initialize the form.      * WARNING: Do NOT modify this code. The content of this method is always      * regenerated by the Form Editor.      */
    private def initComponents() : Unit = {
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.jComboBox1 = new _root_.javax.swing.JComboBox()
        this.aboveJButton = new _root_.javax.swing.JButton()
        this.jTextField1 = new _root_.javax.swing.JTextField()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.jTextField2 = new _root_.javax.swing.JTextField()
        this.updateJButton = new _root_.javax.swing.JButton()
        this.floatPercentJTextField = new _root_.javax.swing.JTextField()
        this.adjustFor16AboveJButton = new _root_.javax.swing.JButton()
        this.adjustFor16BelowJButton = new _root_.javax.swing.JButton()
        this.jLabel1.setText("Percent:")
        this.jComboBox1.setModel(new _root_.javax.swing.DefaultComboBoxModel(Array[String]("Item 1", "Item 2", "Item 3", "Item 4")))
        this.aboveJButton.setText("Process")
        this.aboveJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    aboveJButtonActionPerformed(evt)
                }

            })
        this.jLabel2.setText("Width:")
        this.jLabel3.setText("Height:")
        this.updateJButton.setText("Update")
        this.updateJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    updateJButtonActionPerformed(evt)
                }

            })
        this.floatPercentJTextField.setText("-1.000000")
        this.floatPercentJTextField.setMinimumSize(new _root_.java.awt.Dimension(120, 22))
        this.adjustFor16AboveJButton.setText("Adjust for 16 Above")
        this.adjustFor16AboveJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    adjustFor16AboveJButtonActionPerformed(evt)
                }

            })
        this.adjustFor16BelowJButton.setText("Adjust for 16 Below")
        this.adjustFor16BelowJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    adjustFor16BelowJButtonActionPerformed(evt)
                }

            })
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jComboBox1, 0, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(jTextField1).addComponent(jTextField2)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(floatPercentJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(adjustFor16AboveJButton).addComponent(adjustFor16BelowJButton)).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(updateJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(aboveJButton).addGap(0, 250, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jComboBox1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(floatPercentJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(adjustFor16AboveJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jTextField2, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(adjustFor16BelowJButton)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(aboveJButton).addComponent(updateJButton)).addContainerGap(175, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def aboveJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_aboveJButtonActionPerformed
        this.process()
    }

    //GEN-LAST:event_aboveJButtonActionPerformed
    private def updateJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_updateJButtonActionPerformed
        this.update()
    }

    //GEN-LAST:event_updateJButtonActionPerformed
    private def adjustFor16AboveJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_adjustFor16AboveJButtonActionPerformed
        this.updateFor16Above()
    }

    //GEN-LAST:event_adjustFor16AboveJButtonActionPerformed
    private def adjustFor16BelowJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_adjustFor16BelowJButtonActionPerformed
        this.updateFor16Below()
    }

}


