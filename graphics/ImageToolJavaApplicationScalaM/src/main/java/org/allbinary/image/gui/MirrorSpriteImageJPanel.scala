/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.RenderedImage
import _root_.java.io.File
import _root_.javax.imageio.ImageIO
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.BufferedImageUtil2
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageProcessorInputCompositeInterface
import _root_.org.allbinary.media.image.ImageStrings
import _root_.org.allbinary.media.image.MirrorImageUtil
import _root_.org.allbinary.string.CommonStrings

class MirrorSpriteImageJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel() with ImageProcessorInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val imageStrings : ImageStrings = ImageStrings.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    private var result : BufferedImage = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var generateJButton : _root_.javax.swing.JButton = null

    private var horizontalJCheckBox : _root_.javax.swing.JCheckBox = null

    private var imageHeightIsFrameSizeJCheckBox : _root_.javax.swing.JCheckBox = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLayeredPane1 : _root_.javax.swing.JLayeredPane = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var jPanel2 : _root_.javax.swing.JPanel = null

    private var jPanel3 : _root_.javax.swing.JPanel = null

    private var verticleJCheckBox : _root_.javax.swing.JCheckBox = null

    private var writeOverOriginalJCheckBox : _root_.javax.swing.JCheckBox = null

    //Constructor
    {
        val imageProcessorInput : ImageProcessorInput = param_imageProcessorInput
        this.logUtil.putF("Starting", this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.imageProcessorInput = imageProcessorInput
    }

    def process() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        var generatedBufferedImageArray : Array[BufferedImage] = null
                        val imageProcessorInput : ImageProcessorInput = MirrorSpriteImageJPanel.this.getImageProcessorInput()
                        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()

                        {
                            var index : Int = 0
                            while (index < bufferedImageArray.length) {
                                generatedBufferedImageArray = MirrorImageUtil.getInstance().getImages(bufferedImageArray(index), MirrorSpriteImageJPanel.this.verticleJCheckBox.isSelected(), MirrorSpriteImageJPanel.this.horizontalJCheckBox.isSelected())
                                MirrorSpriteImageJPanel.this.result = BufferedImageUtil2.getInstance().createSpriteImage(generatedBufferedImageArray)
                                MirrorSpriteImageJPanel.this.getParent().repaint()
                                var file : File = imageProcessorInput.getFiles()(index)
                                if (!MirrorSpriteImageJPanel.this.writeOverOriginalJCheckBox.isSelected()) {
                                    var filePath : String = file.getAbsolutePath()
                                    var extensionIndex : Int = filePath.indexOf(imageStrings.PNG_EXTENSION)
                                    filePath = (filePath.substring(0, extensionIndex) + "_mirror") + imageStrings.PNG_EXTENSION
                                    logUtil.putF("Renamed File: " + filePath, this, commonStrings.RUN)
                                    file = new File(filePath)
                                }
                                var isWritten : Boolean = ImageIO.write(MirrorSpriteImageJPanel.this.result.asInstanceOf[RenderedImage], imageStrings.PNG, file)
                                logUtil.putF((("File: " + file) + " Wrote: ") + isWritten, this, commonStrings.RUN)
                                index += 1
                            }
                        }
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
        jLayeredPane1 = new _root_.javax.swing.JLayeredPane()
        this.jPanel1 = new _root_.javax.swing.JPanel {
                override def paint(graphics : Graphics) : Unit = {
                    if (MirrorSpriteImageJPanel.this.result != null) {
                        graphics.drawImage(MirrorSpriteImageJPanel.this.result, 0, 0, MirrorSpriteImageJPanel.this.result.getWidth(null), MirrorSpriteImageJPanel.this.result.getHeight(null), null)
                    }
                }

            }
        this.jPanel2 = new _root_.javax.swing.JPanel()
        this.imageHeightIsFrameSizeJCheckBox = new _root_.javax.swing.JCheckBox()
        this.horizontalJCheckBox = new _root_.javax.swing.JCheckBox()
        this.verticleJCheckBox = new _root_.javax.swing.JCheckBox()
        this.writeOverOriginalJCheckBox = new _root_.javax.swing.JCheckBox()
        this.generateJButton = new _root_.javax.swing.JButton()
        this.jPanel3 = new _root_.javax.swing.JPanel()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        var jPanel1Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(0, 507, _root_.java.lang.Short.MAX_VALUE))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(0, 230, _root_.java.lang.Short.MAX_VALUE))
        this.imageHeightIsFrameSizeJCheckBox.setSelected(true)
        this.imageHeightIsFrameSizeJCheckBox.setText("Image Height Is Frame Size")
        this.imageHeightIsFrameSizeJCheckBox.setEnabled(false)
        this.imageHeightIsFrameSizeJCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    imageHeightIsFrameSizeJCheckBoxActionPerformed(evt)
                }

            })
        this.horizontalJCheckBox.setSelected(true)
        this.horizontalJCheckBox.setText("Horizontal")
        this.horizontalJCheckBox.setEnabled(false)
        this.verticleJCheckBox.setText("Verticle")
        this.verticleJCheckBox.setEnabled(false)
        //writeOverOriginalJCheckBox.setSelected(true);
        this.writeOverOriginalJCheckBox.setText("Write Over Original")
        this.generateJButton.setText("Generate")
        this.generateJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateJButtonActionPerformed(evt)
                }

            })
        var jPanel2Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel2)
        this.jPanel2.setLayout(jPanel2Layout)
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel2Layout.createSequentialGroup().addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).add(verticleJCheckBox).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.UNRELATED).add(horizontalJCheckBox).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(imageHeightIsFrameSizeJCheckBox).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(writeOverOriginalJCheckBox).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(generateJButton)))
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel2Layout.createSequentialGroup().add(jPanel2Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(imageHeightIsFrameSizeJCheckBox, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).add(horizontalJCheckBox).add(verticleJCheckBox).add(writeOverOriginalJCheckBox).add(generateJButton, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).addContainerGap()))
        this.jLabel2.setText("Results:")
        var jPanel3Layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.jPanel3)
        this.jPanel3.setLayout(jPanel3Layout)
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jPanel3Layout.createSequentialGroup().add(jLabel2).addContainerGap(448, _root_.java.lang.Short.MAX_VALUE)))
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(jLabel2))
        var layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(_root_.org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup().addContainerGap().add(jPanel3, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addContainerGap()).add(jPanel1, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).add(layout.createSequentialGroup().add(jPanel2, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().add(jPanel2, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(jPanel3, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(jPanel1, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def generateJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_generateJButtonActionPerformed
        this.process()
    }

    //GEN-LAST:event_generateJButtonActionPerformed
    private def imageHeightIsFrameSizeJCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    // End of variables declaration//GEN-END:variables
    def getImageProcessorInput() : ImageProcessorInput = {
        return this.imageProcessorInput
    }

    def setImageProcessorInput(imageProcessorInput : ImageProcessorInput) : Unit = {
        this.imageProcessorInput = imageProcessorInput
    }

}


