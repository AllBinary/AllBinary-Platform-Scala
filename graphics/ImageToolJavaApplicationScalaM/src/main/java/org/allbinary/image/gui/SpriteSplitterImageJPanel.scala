/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
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
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.image.ImageProcessedVisitor
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageStrings
import _root_.org.allbinary.media.image.SpriteSplitterUtil
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class SpriteSplitterImageJPanel(param_imageProcessorInput : ImageProcessorInput) extends _root_.javax.swing.JPanel() with ImageProcessedVisitor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val imageStrings : ImageStrings = ImageStrings.getInstance()

    private var imageProcessorInput : ImageProcessorInput = null

    private var result : BufferedImage = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var generateJButton : _root_.javax.swing.JButton = null

    private var heightReductionTextField : _root_.javax.swing.JTextField = null

    private var increaseHeightTextField : _root_.javax.swing.JTextField = null

    private var increaseWidthTextField : _root_.javax.swing.JTextField = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jLabel3 : _root_.javax.swing.JLabel = null

    private var jLabel4 : _root_.javax.swing.JLabel = null

    private var jLabel5 : _root_.javax.swing.JLabel = null

    private var jLabel6 : _root_.javax.swing.JLabel = null

    private var jLabel7 : _root_.javax.swing.JLabel = null

    private var jLabel8 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var jPanel2 : _root_.javax.swing.JPanel = null

    private var spriteTypeJComboBox : _root_.javax.swing.JComboBox[String] = null

    private var totalAnimationsJComboBox : _root_.javax.swing.JComboBox[String] = null

    private var totalFramesJComboBox : _root_.javax.swing.JComboBox[String] = null

    private var widthReductionTextField : _root_.javax.swing.JTextField = null

    private var writeOverOriginalJCheckBox : _root_.javax.swing.JCheckBox = null

    //Constructor
    {
        val imageProcessorInput : ImageProcessorInput = param_imageProcessorInput
        initComponents()
        this.imageProcessorInput = imageProcessorInput
    }

    def process() : Unit = {
        new Thread {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    try {
                        val spriteSplitterUtil : SpriteSplitterUtil = SpriteSplitterUtil.getInstance()
                        val spriteType : String = spriteTypeJComboBox.getSelectedItem().asInstanceOf[String]
                        val totalFrames : Integer = Integer.valueOf(totalFramesJComboBox.getSelectedItem().asInstanceOf[String])
                        val totalAnimations : Integer = Integer.valueOf(totalAnimationsJComboBox.getSelectedItem().asInstanceOf[String])
                        val widthReduction : Int = Integer.valueOf(widthReductionTextField.getText())
                        val heightReduction : Int = Integer.valueOf(heightReductionTextField.getText())
                        val increaseWidth : Int = Integer.valueOf(increaseWidthTextField.getText())
                        val increaseHeight : Int = Integer.valueOf(increaseHeightTextField.getText())
                        spriteSplitterUtil.process(SpriteSplitterImageJPanel.this.getImageProcessorInput(), totalFrames, totalAnimations, widthReduction, heightReduction, increaseWidth, increaseHeight, spriteType, SpriteSplitterImageJPanel.this)
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            }.start()
    }

    /**      * This method is called from within the constructor to initialize the form.      * WARNING: Do NOT modify this code. The content of this method is always      * regenerated by the Form Editor.      */
    private def initComponents() : Unit = {
        this.writeOverOriginalJCheckBox = new _root_.javax.swing.JCheckBox()
        this.widthReductionTextField = new _root_.javax.swing.JTextField()
        this.jLabel5 = new _root_.javax.swing.JLabel()
        this.jPanel1 = new _root_.javax.swing.JPanel {
                override def paint(graphics : Graphics) : Unit = {
                    if (SpriteSplitterImageJPanel.this.result != null) {
                        graphics.drawImage(SpriteSplitterImageJPanel.this.result, 0, 0, SpriteSplitterImageJPanel.this.result.getWidth(null), SpriteSplitterImageJPanel.this.result.getHeight(null), null)
                    }
                }

            }
        this.jLabel4 = new _root_.javax.swing.JLabel()
        this.jLabel6 = new _root_.javax.swing.JLabel()
        this.heightReductionTextField = new _root_.javax.swing.JTextField()
        this.generateJButton = new _root_.javax.swing.JButton()
        this.jPanel2 = new _root_.javax.swing.JPanel()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.totalFramesJComboBox = new _root_.javax.swing.JComboBox()
        val size : Int = 70
        val animationStringArray2 : Array[String] = new Array[String](size - 1)

        {
            var index : Int = 1
            while (index < size) {
                animationStringArray2(index - 1) = Integer.toString(index)
                index += 1
            }
        }
        this.totalFramesJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel(animationStringArray2))
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.totalAnimationsJComboBox = new _root_.javax.swing.JComboBox()
        val animationStringArray : Array[String] = new Array[String](size - 1)

        {
            var index : Int = 1
            while (index < size) {
                animationStringArray(index - 1) = Integer.toString(index)
                index += 1
            }
        }
        this.totalAnimationsJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel(animationStringArray))
        this.jLabel3 = new _root_.javax.swing.JLabel()
        this.spriteTypeJComboBox = new _root_.javax.swing.JComboBox()
        //, org.allbinary.media.image.SpriteSplitterUtil.getInstance().VERTICLE_ANIMATIONS
        this.spriteTypeJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel(Array[String](_root_.org.allbinary.media.image.SpriteSplitterUtil.getInstance().DIRECTIONAL_ANIMATIONS, _root_.org.allbinary.media.image.SpriteSplitterUtil.getInstance().HORIZONTAL_ANIMATIONS, _root_.org.allbinary.media.image.SpriteSplitterUtil.getInstance().HORIZONTAL_SPRITE)))
        jLabel7 = new _root_.javax.swing.JLabel()
        this.increaseWidthTextField = new _root_.javax.swing.JTextField()
        this.jLabel8 = new _root_.javax.swing.JLabel()
        this.increaseHeightTextField = new _root_.javax.swing.JTextField()
        this.writeOverOriginalJCheckBox.setText("Write Over Original")
        this.writeOverOriginalJCheckBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    writeOverOriginalJCheckBoxActionPerformed(evt)
                }

            })
        this.widthReductionTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.widthReductionTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    widthReductionTextFieldActionPerformed(evt)
                }

            })
        this.jLabel5.setText("Less Width:")
        this.jLabel4.setText("Results:")
        var jPanel1Layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4).addGap(0, 0, _root_.java.lang.Short.MAX_VALUE)))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4).addGap(0, 184, _root_.java.lang.Short.MAX_VALUE)))
        this.jLabel6.setText("Less Height:")
        this.heightReductionTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.generateJButton.setText("Generate")
        this.generateJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Row Total:")
        this.totalFramesJComboBox.setSelectedIndex(1)
        this.totalFramesJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    totalFramesJComboBoxActionPerformed(evt)
                }

            })
        this.jLabel2.setText("Column Total :")
        this.totalAnimationsJComboBox.setSelectedIndex(3)
        this.totalAnimationsJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    totalAnimationsJComboBoxActionPerformed(evt)
                }

            })
        this.jLabel3.setText("Type:")
        this.spriteTypeJComboBox.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    spriteTypeJComboBoxActionPerformed(evt)
                }

            })
        var jPanel2Layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.jPanel2)
        this.jPanel2.setLayout(jPanel2Layout)
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalFramesJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 48, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalAnimationsJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 39, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(spriteTypeJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 172, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addGroup(jPanel2Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(totalFramesJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(totalAnimationsJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3).addComponent(spriteTypeJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))))
        this.jLabel7.setText("More Width:")
        this.increaseWidthTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        this.increaseWidthTextField.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    increaseWidthTextFieldActionPerformed(evt)
                }

            })
        this.jLabel8.setText("More Height:")
        this.increaseHeightTextField.setText(CommonPhoneStrings.getInstance().ZERO)
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel2, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 415, _root_.java.lang.Short.MAX_VALUE).addGap(78, 78, 78)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(writeOverOriginalJCheckBox).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(generateJButton)).addGroup(layout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(widthReductionTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 41, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel6).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(heightReductionTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 46, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel7).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(increaseWidthTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 41, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel8).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(increaseHeightTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 46, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(0, 0, _root_.java.lang.Short.MAX_VALUE))).addContainerGap()))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel2, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(increaseWidthTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 22, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel8).addComponent(increaseHeightTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(widthReductionTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 22, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6).addComponent(heightReductionTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(writeOverOriginalJCheckBox).addComponent(generateJButton)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def writeOverOriginalJCheckBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_writeOverOriginalJCheckBoxActionPerformed
    private def generateJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_generateJButtonActionPerformed
        this.process()
    }

    //GEN-LAST:event_generateJButtonActionPerformed
    private def spriteTypeJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        val spriteSplitterUtil : SpriteSplitterUtil = SpriteSplitterUtil.getInstance()
        this.jLabel1.setText(spriteSplitterUtil.ANIMATIONS_LABELS(this.spriteTypeJComboBox.getSelectedIndex()))
        this.jLabel2.setText(spriteSplitterUtil.ANIMATIONS_LABELS(this.spriteTypeJComboBox.getSelectedIndex() + 1))
    }

    //GEN-LAST:event_spriteTypeJComboBoxActionPerformed
    private def totalAnimationsJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_totalAnimationsJComboBoxActionPerformed
    private def totalFramesJComboBoxActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_totalFramesJComboBoxActionPerformed
    private def widthReductionTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_widthReductionTextFieldActionPerformed
    private def increaseWidthTextFieldActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    // End of variables declaration//GEN-END:variables
    def getImageProcessorInput() : ImageProcessorInput = {
        return this.imageProcessorInput
    }

    def setImageProcessorInput(imageProcessorInput : ImageProcessorInput) : Unit = {
        this.imageProcessorInput = imageProcessorInput
    }

    override def visit(generatedBufferedImage : BufferedImage, name : String, index : Int) : Unit = {
        this.logUtil.putF(this.commonStrings.VISIT, this, this.commonStrings.VISIT)
        this.result = generatedBufferedImage
        //);
        this.getParent().repaint()
        var file : File = this.imageProcessorInput.getFiles()(index)
        if (!this.writeOverOriginalJCheckBox.isSelected()) {
            var filePath : String = file.getAbsolutePath()
            val extensionIndex : Int = filePath.indexOf(this.imageStrings.PNG_EXTENSION)
            filePath = new StringMaker().append(filePath.substring(0, extensionIndex)).append(this.commonSeps.UNDERSCORE).append(name).append(this.imageStrings.PNG_EXTENSION).toString()
            file = new File(filePath)
        }
        val isWritten : Boolean = ImageIO.write(SpriteSplitterImageJPanel.this.result.asInstanceOf[RenderedImage], imageStrings.PNG, file)
        this.logUtil.putF(new StringMaker().append("File: ").append(StringUtil.getInstance().toString(file)).append(" Wrote: ").appendboolean(isWritten).toString(), this, this.commonStrings.RUN)
    }

}


