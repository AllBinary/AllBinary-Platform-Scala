/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.image.BufferedImage
import _root_.java.awt.image.Raster
import _root_.java.io.File
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageProcessorInputCompositeInterface
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class CreateIconImagesJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel() with ImageProcessorInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var aboveJButton : _root_.javax.swing.JButton = null

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
                        val stringMaker : StringMaker = new StringMaker()
                        val imageProcessorInput : ImageProcessorInput = CreateIconImagesJPanel.this.getImageProcessorInput()
                        val files : Array[File] = imageProcessorInput.getFiles()
                        val iconWidthList : BasicArrayList = new BasicArrayListD()
                        val iconHeightList : BasicArrayList = new BasicArrayListD()
                        //android
                        iconWidthList.add(Integer.valueOf(864))
                        iconHeightList.add(Integer.valueOf(864))
                        //                        iconHeightList.add(1024);
                        val ANDROID : String = "android-icon-"
                        val IOS : String = "ios-icon-"
                        val size : Int = iconWidthList.size()
                        var width : Int = 0
                        var height : Int = 0

                        {
                            var index2 : Int = 0
                            while (index2 < size) {
                                width = (iconWidthList.get(index2).asInstanceOf[Integer]).intValue()
                                height = (iconHeightList.get(index2).asInstanceOf[Integer]).intValue()
                                var generatedBufferedImageArray : Array[BufferedImage] = imageUtil.createBufferedImage3(imageProcessorInput.getBufferedImageArray(), width, height, true)
                                val imagePersistanceUtil : ImagePersistanceUtil = ImagePersistanceUtil.getInstance()

                                {
                                    var index : Int = 0
                                    while (index < generatedBufferedImageArray.length) {
                                        val filePath : String = files(index).getAbsolutePath()
                                        val endIndex : Int = filePath.lastIndexOf('\\')
                                        val path : String = filePath.substring(0, endIndex + 1)
                                        stringMaker.delete(0, stringMaker.length())
                                        stringMaker.append(path).append(ANDROID).appendint(width).append(CanvasStrings.getInstance()._PNG)
                                        var newFilePath : String = stringMaker.toString()
                                        imagePersistanceUtil.saveWithBatik(AbFile.createAbFile(newFilePath), generatedBufferedImageArray(index))
                                        stringMaker.delete(0, stringMaker.length())
                                        stringMaker.append(path).append(IOS).appendint(width).append(CanvasStrings.getInstance()._PNG)
                                        newFilePath = stringMaker.toString()
                                        imagePersistanceUtil.saveWithBatik(AbFile.createAbFile(newFilePath), generatedBufferedImageArray(index))
                                        index += 1
                                    }
                                }
                                index2 += 1
                            }
                        }
                        CreateIconImagesJPanel.this.getParent().repaint()
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
        this.aboveJButton = new _root_.javax.swing.JButton()
        this.aboveJButton.setText("Process")
        this.aboveJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    aboveJButtonActionPerformed(evt)
                }

            })
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(aboveJButton).addGap(0, 335, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(aboveJButton).addContainerGap(286, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def aboveJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_aboveJButtonActionPerformed
        this.process()
    }

}


