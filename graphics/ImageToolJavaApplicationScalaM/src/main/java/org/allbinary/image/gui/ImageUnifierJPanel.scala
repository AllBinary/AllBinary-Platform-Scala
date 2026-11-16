/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.image.BufferedImage
import _root_.java.io.File
import _root_.javax.swing.*
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.image.ImagePersistanceUtil
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageProcessorInputCompositeInterface
import _root_.org.allbinary.media.image.ImageStrings
import _root_.org.allbinary.media.image.ImageUnifierCell
import _root_.org.allbinary.media.image.ImageUnifierProperties
import _root_.org.allbinary.media.image.ImageUnifierUtil
import _root_.org.allbinary.media.image.ImageUtil
import _root_.org.allbinary.media.image.ImagesRatioUtil
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class ImageUnifierJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel with ImageProcessorInputCompositeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val imageStrings : ImageStrings = ImageStrings.getInstance()

    private val imagesRatioUtil : ImagesRatioUtil = ImagesRatioUtil.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    private var icon : Array[ImageIconUnique] = null

    private var imageUnifierProperties : ImageUnifierProperties = null

    private var result : BufferedImage = null

    private var isImageFillIn : Boolean = true

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var avgRatioJTextField : _root_.javax.swing.JTextField = null

    private var cellHeightJTextField : _root_.javax.swing.JTextField = null

    private var cellRatioJTextField : _root_.javax.swing.JTextField = null

    private var cellWidthJTextField : _root_.javax.swing.JTextField = null

    private var columnsJTextField : _root_.javax.swing.JTextField = null

    private var downJButton : _root_.javax.swing.JButton = null

    private var fudgeItJButton : _root_.javax.swing.JButton = null

    private var imageJList : _root_.javax.swing.JList[Object] = null

    private var jButton1 : _root_.javax.swing.JButton = null

    private var jButton2 : _root_.javax.swing.JButton = null

    private var jButtonOrder : _root_.javax.swing.JButton = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jLabel4 : _root_.javax.swing.JLabel = null

    private var jLabel5 : _root_.javax.swing.JLabel = null

    private var jLabel6 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var jScrollPane1 : _root_.javax.swing.JScrollPane = null

    private var jScrollPane2 : _root_.javax.swing.JScrollPane = null

    private var rowsJTextField : _root_.javax.swing.JTextField = null

    private var upJButton : _root_.javax.swing.JButton = null

    //Constructor
    {
        val imageProcessorInput : ImageProcessorInput = param_imageProcessorInput
        this.initComponents()
        this.setImageProcessorInput(imageProcessorInput)
    }

    def init() : Unit = {
        try {
            val imageProcessorInput : ImageProcessorInput = this.getImageProcessorInput()
            val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()
            this.icon = new Array[ImageIconUnique](bufferedImageArray.length)
            val defaultListModel : DefaultListModel[Object] = new DefaultListModel[Object]()

            {
                var index : Int = 0
                while (index < bufferedImageArray.length) {
                    val width : Double = bufferedImageArray(index).getWidth()
                    val height : Double = bufferedImageArray(index).getHeight()
                    val newWidth : Int = 52
                    val oldRatio : Double = width / height
                    val newHeight : Int = (newWidth / oldRatio).toInt
                    val iconBufferedImage : BufferedImage = ImageUtil.getInstance().createBufferedImage(bufferedImageArray(index), newWidth, newHeight, true)
                    this.icon(index) = new ImageIconUnique(iconBufferedImage, index)
                    defaultListModel.addElement(this.icon(index))
                    index += 1
                }
            }
            this.imageJList.setModel(defaultListModel)
            this.updateOnPropertiesChange()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

    private def updateImage() : Unit = {
        try {
            val bufferedImageArray : Array[BufferedImage] = this.getImageProcessorInput().getBufferedImageArray()
            val tempBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](bufferedImageArray.length)

            {
                var index : Int = 0
                while (index < bufferedImageArray.length) {
                    val indexedImageIcon : ImageIconUnique = this.imageJList.getModel().getElementAt(index).asInstanceOf[ImageIconUnique]
                    val bufferedImage : BufferedImage = ImageUtil.getInstance().createBufferedImage(bufferedImageArray(indexedImageIcon.getId()), this.imageUnifierProperties.getImageUnifierCell().getWidth(), this.imageUnifierProperties.getImageUnifierCell().getHeight(), false)
                    tempBufferedImageArray(index) = bufferedImage
                    index += 1
                }
            }
            var totalImages : Int = this.imageUnifierProperties.getRows() * this.imageUnifierProperties.getColumns()
            var averageRatio : Double = this.imagesRatioUtil.getAverage(tempBufferedImageArray, totalImages)
            var averageRatioString : String = new _root_.java.lang.Double(averageRatio).toString()
            if (averageRatioString.length() > 4) {
                averageRatioString = averageRatioString.substring(0, 4)
            }
            this.avgRatioJTextField.setText(averageRatioString)
            //new BasicTextJDialog("Your image ratio average does not match your selected").setVisible(false);
            this.fudgeItJButton.setEnabled(false)
            if (!this.imagesRatioUtil.isEqual(tempBufferedImageArray, totalImages)) {
                //new BasicTextJDialog("Your images have different ratios").setVisible(false);
                if (this.isImageFillIn) {
                    this.fudgeItJButton.setEnabled(true)
                }
            }
            this.updateImage(tempBufferedImageArray)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateImage", e)
            }
        }
    }

    private def updateImageWithFudgedImages() : Unit = {
        try {
            val bufferedImageArray : Array[BufferedImage] = this.getImageProcessorInput().getBufferedImageArray()
            val tempBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](bufferedImageArray.length)

            {
                var index : Int = 0
                while (index < bufferedImageArray.length) {
                    val indexedImageIcon : ImageIconUnique = this.imageJList.getModel().getElementAt(index).asInstanceOf[ImageIconUnique]
                    val bufferedImage : BufferedImage = ImageUtil.getInstance().createBufferedImage(bufferedImageArray(indexedImageIcon.getId()), this.imageUnifierProperties.getImageUnifierCell().getWidth(), this.imageUnifierProperties.getImageUnifierCell().getHeight(), false)
                    tempBufferedImageArray(index) = bufferedImage
                    index += 1
                }
            }
            val totalImages : Int = this.imageUnifierProperties.getRows() * this.imageUnifierProperties.getColumns()
            val averageRatio : Double = this.imagesRatioUtil.getAverage(tempBufferedImageArray, totalImages)
            val fudgedBufferedImageArray : Array[BufferedImage] = imagesRatioUtil.fudge(tempBufferedImageArray, totalImages, averageRatio)
            this.updateImage(fudgedBufferedImageArray)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updateImageWithFudgedImages", e)
            }
        }
    }

    private def updateImage(tempBufferedImageArray : Array[BufferedImage]) : Unit = {
        this.result = ImageUnifierUtil.getInstance().getImage(tempBufferedImageArray, this.imageUnifierProperties)
        val image : Icon = new ImageIcon(this.result)
        val label : JLabel = new JLabel(image)
        this.jScrollPane2.getViewport().add(label)
        this.updateUI()
    }

    private def updateOnPropertiesChange() : Unit = {
        if ((((this.rowsJTextField.getText().length() > 0) && (this.columnsJTextField.getText().length() > 0)) && (this.cellWidthJTextField.getText().length() > 0)) && (this.cellHeightJTextField.getText().length() > 0)) {
            this.imageUnifierProperties = new ImageUnifierProperties()
            this.imageUnifierProperties.setRows(new Integer(this.rowsJTextField.getText()))
            this.imageUnifierProperties.setColumns(new Integer(this.columnsJTextField.getText()))
            val imageUnifierCell : ImageUnifierCell = new ImageUnifierCell(new Integer(this.cellWidthJTextField.getText()), new Integer(this.cellHeightJTextField.getText()))
            this.imageUnifierProperties.setImageUnifierCell(imageUnifierCell)
            val cellRatio : Double = (imageUnifierCell.getWidth().toDouble / imageUnifierCell.getHeight())
            var cellRatioString : String = new _root_.java.lang.Double(cellRatio).toString()
            if (cellRatioString.length() > 4) {
                cellRatioString = cellRatioString.substring(0, 4)
            }
            this.cellRatioJTextField.setText(cellRatioString)
            this.updateImage()
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
        this.jScrollPane1 = new _root_.javax.swing.JScrollPane()
        this.imageJList = new _root_.javax.swing.JList[Object]()
        this.jScrollPane2 = new _root_.javax.swing.JScrollPane()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.jButton1 = new _root_.javax.swing.JButton()
        this.upJButton = new _root_.javax.swing.JButton()
        this.downJButton = new _root_.javax.swing.JButton()
        this.fudgeItJButton = new _root_.javax.swing.JButton()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.columnsJTextField = new _root_.javax.swing.JTextField()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.rowsJTextField = new _root_.javax.swing.JTextField()
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.cellWidthJTextField = new _root_.javax.swing.JTextField()
        this.jLabel4 = new _root_.javax.swing.JLabel()
        this.cellHeightJTextField = new _root_.javax.swing.JTextField()
        this.jLabel5 = new _root_.javax.swing.JLabel()
        this.cellRatioJTextField = new _root_.javax.swing.JTextField()
        this.jLabel6 = new _root_.javax.swing.JLabel()
        this.avgRatioJTextField = new _root_.javax.swing.JTextField()
        this.jButton2 = new _root_.javax.swing.JButton()
        this.jButtonOrder = new _root_.javax.swing.JButton()
        setMinimumSize(new _root_.java.awt.Dimension(500, 375))
        setPreferredSize(new _root_.java.awt.Dimension(0, 0))
        this.imageJList.setMinimumSize(new _root_.java.awt.Dimension(50, 0))
        this.jScrollPane1.setViewportView(this.imageJList)
        this.jButton1.setText("Save")
        this.jButton1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton1ActionPerformed(evt)
                }

            })
        this.upJButton.setText("Up")
        this.upJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    upJButtonActionPerformed(evt)
                }

            })
        this.downJButton.setText("Down")
        this.downJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    downJButtonActionPerformed(evt)
                }

            })
        this.fudgeItJButton.setText("Fudge It!")
        this.fudgeItJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    fudgeItJButtonActionPerformed(evt)
                }

            })
        this.jLabel2.setText("Columns:")
        this.columnsJTextField.setText(commonPhoneStrings.TWO)
        this.columnsJTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    columnsJTextFieldActionPerformed(evt)
                }

            })
        this.columnsJTextField.addPropertyChangeListener(new _root_.java.beans.PropertyChangeListener {
                override def propertyChange(evt : _root_.java.beans.PropertyChangeEvent) : Unit = {
                    columnsJTextFieldPropertyChange(evt)
                }

            })
        this.columnsJTextField.addKeyListener(new _root_.java.awt.event.KeyAdapter {
                override def keyPressed(evt : _root_.java.awt.event.KeyEvent) : Unit = {
                    columnsJTextFieldKeyPressed(evt)
                }

                override def keyTyped(evt : _root_.java.awt.event.KeyEvent) : Unit = {
                    columnsJTextFieldKeyTyped(evt)
                }

            })
        this.jLabel1.setText("Rows:")
        this.rowsJTextField.setText(commonPhoneStrings.TWO)
        this.rowsJTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    rowsJTextFieldActionPerformed(evt)
                }

            })
        this.jLabel3.setText("Cell Width:")
        this.cellWidthJTextField.setText("200")
        this.cellWidthJTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    cellWidthJTextFieldActionPerformed(evt)
                }

            })
        this.jLabel4.setText("Cell Height:")
        this.cellHeightJTextField.setText("150")
        this.cellHeightJTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    cellHeightJTextFieldActionPerformed(evt)
                }

            })
        this.jLabel5.setText("Cell Ratio:")
        this.cellRatioJTextField.setEditable(false)
        this.jLabel6.setText("Avg Image Ratio:")
        this.avgRatioJTextField.setEditable(false)
        this.jButton2.setText(this.commonStrings.UPDATE)
        this.jButton2.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton2ActionPerformed(evt)
                }

            })
        this.jButtonOrder.setText("Order")
        this.jButtonOrder.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButtonOrderActionPerformed(evt)
                }

            })
        var jPanel1Layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addGroup(jPanel1Layout.createSequentialGroup().addComponent(upJButton, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 71, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, _root_.java.lang.Short.MAX_VALUE).addComponent(downJButton, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 70, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(fudgeItJButton, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(avgRatioJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(jLabel6, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(cellRatioJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(jLabel5, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(cellHeightJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(cellWidthJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addComponent(jButton2, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jLabel1)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(rowsJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 103, _root_.java.lang.Short.MAX_VALUE).addGroup(jPanel1Layout.createSequentialGroup().addComponent(columnsJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 102, _root_.java.lang.Short.MAX_VALUE).addGap(1, 1, 1)))).addComponent(jButtonOrder, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 151, _root_.java.lang.Short.MAX_VALUE)).addContainerGap()))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jButton1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(upJButton).addComponent(downJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonOrder).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fudgeItJButton).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(columnsJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(rowsJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cellWidthJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cellHeightJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel5).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(cellRatioJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGap(7, 7, 7).addComponent(jLabel6).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(avgRatioJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGap(66, 66, 66)))
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 84, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 527, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jPanel1, _root_.javax.swing.GroupLayout.Alignment.LEADING, 0, 445, _root_.java.lang.Short.MAX_VALUE).addComponent(jScrollPane2, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 445, _root_.java.lang.Short.MAX_VALUE).addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 445, _root_.java.lang.Short.MAX_VALUE)).addContainerGap()))
    }

    // </editor-fold>//GEN-END:initComponents
    private def jButton2ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_jButton2ActionPerformed
        this.updateOnPropertiesChange()
    }

    //GEN-LAST:event_jButton2ActionPerformed
    private def columnsJTextFieldKeyPressed(evt : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    //GEN-LAST:event_columnsJTextFieldKeyPressed
    private def columnsJTextFieldKeyTyped(evt : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    //GEN-LAST:event_columnsJTextFieldKeyTyped
    private def columnsJTextFieldPropertyChange(evt : _root_.java.beans.PropertyChangeEvent) : Unit = {
    }

    //GEN-LAST:event_columnsJTextFieldPropertyChange
    private def fudgeItJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_fudgeItJButtonActionPerformed
        this.updateImageWithFudgedImages()
    }

    //GEN-LAST:event_fudgeItJButtonActionPerformed
    private def cellHeightJTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_cellHeightJTextFieldActionPerformed
        this.updateOnPropertiesChange()
    }

    //GEN-LAST:event_cellHeightJTextFieldActionPerformed
    private def cellWidthJTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_cellWidthJTextFieldActionPerformed
        this.updateOnPropertiesChange()
    }

    //GEN-LAST:event_cellWidthJTextFieldActionPerformed
    private def columnsJTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_columnsJTextFieldActionPerformed
        this.updateOnPropertiesChange()
    }

    //GEN-LAST:event_columnsJTextFieldActionPerformed
    private def rowsJTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_rowsJTextFieldActionPerformed
        this.updateOnPropertiesChange()
    }

    //GEN-LAST:event_rowsJTextFieldActionPerformed
    private def jButton1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        try {
            val fileArray : Array[File] = this.imageProcessorInput.getFiles()
            val file : File = fileArray(0)
            var filePath : String = file.getAbsolutePath()
            val extensionIndex : Int = filePath.indexOf(this.imageStrings.PNG_EXTENSION)
            filePath = new StringMaker().append(filePath.substring(0, extensionIndex)).append(CommonSeps.getInstance().UNDERSCORE).appendint(this.imageUnifierProperties.getColumns()).append("_By_").appendint(this.imageUnifierProperties.getRows()).append("_Unified").append(this.imageStrings.PNG_EXTENSION).toString()
            this.logUtil.putF("New File Path: " + filePath, this, StringUtil.getInstance().EMPTY_STRING)
            val outputFile : File = new File(filePath)
            ImagePersistanceUtil.getInstance().saveWithBatik(FileWrapperUtil.wrapFile(outputFile), this.result)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "jButton1ActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_jButton1ActionPerformed
    private def downJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        var index : Int = this.imageJList.getSelectedIndex()
        var defaultListModel : DefaultListModel[Object] = this.imageJList.getModel().asInstanceOf[DefaultListModel[Object]]
        if ((index >= 0) && ((index + 1) < defaultListModel.size())) {
            var indexedImageIcon : ImageIconUnique = defaultListModel.remove(index).asInstanceOf[ImageIconUnique]
            defaultListModel.insertElementAt(indexedImageIcon, index + 1)
            this.imageJList.setSelectedIndex(index + 1)
            this.updateImage()
        }
    }

    //GEN-LAST:event_downJButtonActionPerformed
    private def upJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        var index : Int = this.imageJList.getSelectedIndex()
        if (index > 0) {
            var defaultListModel : DefaultListModel[Object] = this.imageJList.getModel().asInstanceOf[DefaultListModel[Object]]
            var indexedImageIcon : ImageIconUnique = defaultListModel.remove(index).asInstanceOf[ImageIconUnique]
            defaultListModel.insertElementAt(indexedImageIcon, index - 1)
            this.imageJList.setSelectedIndex(index - 1)
            this.updateImage()
        }
    }

    //GEN-LAST:event_upJButtonActionPerformed
    private def jButtonOrderActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_jButtonOrderActionPerformed
        var defaultListModel : DefaultListModel[Object] = this.imageJList.getModel().asInstanceOf[DefaultListModel[Object]]
        var size : Int = defaultListModel.size()
        var last : Int = size - 1

        {
            var index : Int = last
            while (index >= 0) {
                var indexedImageIcon : ImageIconUnique = defaultListModel.remove(last).asInstanceOf[ImageIconUnique]
                defaultListModel.insertElementAt(indexedImageIcon, last - index)
                index -= 1
            }
        }
        if (size > 0) {
            this.imageJList.setSelectedIndex(0)
            this.updateImage()
        }
    }

    // End of variables declaration//GEN-END:variables
    def getImageProcessorInput() : ImageProcessorInput = {
        return this.imageProcessorInput
    }

    def setImageProcessorInput(imageProcessorInput : ImageProcessorInput) : Unit = {
        this.imageProcessorInput = imageProcessorInput
        this.init()
    }

}


