/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.image.BufferedImage
import _root_.java.io.File
import _root_.java.util.Arrays
import _root_.java.util.Comparator
import _root_.javax.imageio.ImageIO
import _root_.org.allbinary.gui.dialog.FileJDialog
import _root_.org.allbinary.gui.dialog.FileJDialogListenerInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.ImageProcessorInput
import _root_.org.allbinary.media.image.ImageProcessorInputCompositeInterface
import _root_.org.allbinary.media.image.analysis.ColorRange
import _root_.org.allbinary.media.image.analysis.ColorRangeInterface
import _root_.org.allbinary.media.image.analysis.ImageAnalysis
import _root_.org.allbinary.media.image.analysis.ImageAnalysisResults
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonStrings

class ImageToolJFrame() extends _root_.javax.swing.JFrame with FileJDialogListenerInterface {
    import _root_.org.allbinary.image.gui.ImageToolJFrame.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var fileJDialog : FileJDialog = null

    private var imageProcessorInput : ImageProcessorInput = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var analysisActionJDialog : _root_.javax.swing.JDialog = null

    private var analyzeJMenuItem : _root_.javax.swing.JMenuItem = null

    private var blueJLabel : _root_.javax.swing.JLabel = null

    private var colorRangeJLabel : _root_.javax.swing.JLabel = null

    private var createStripImageJMenuItem : _root_.javax.swing.JMenuItem = null

    private var fileJMenu : _root_.javax.swing.JMenu = null

    private var generateSpriteSplitterMenuItem : _root_.javax.swing.JMenuItem = null

    private var generateRotationMenuItem : _root_.javax.swing.JMenuItem = null

    private var generateMirrorSpriteMenuItem : _root_.javax.swing.JMenuItem = null

    private var generateRotationSpriteJMenuItem : _root_.javax.swing.JMenuItem = null

    private var greenJLabel : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var mainJMenuBar : _root_.javax.swing.JMenuBar = null

    private var maxBlueJTextField : _root_.javax.swing.JTextField = null

    private var maxGreenJTextField : _root_.javax.swing.JTextField = null

    private var maxJLabel : _root_.javax.swing.JLabel = null

    private var maxRedJTextField : _root_.javax.swing.JTextField = null

    private var minBlueJTextField : _root_.javax.swing.JTextField = null

    private var minGreenJTextField : _root_.javax.swing.JTextField = null

    private var minJLabel : _root_.javax.swing.JLabel = null

    private var minRedJTextField : _root_.javax.swing.JTextField = null

    private var mirrorJMenuItem : _root_.javax.swing.JMenuItem = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var openImageJMenuItem : _root_.javax.swing.JMenuItem = null

    private var processingJMenu : _root_.javax.swing.JMenu = null

    private var redJLabel : _root_.javax.swing.JLabel = null

    private var scaleImagesJMenuItem : _root_.javax.swing.JMenuItem = null

    private var canvasImagesJMenuItem : _root_.javax.swing.JMenuItem = null

    private var createIconImagesJMenuItem : _root_.javax.swing.JMenuItem = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    //Constructor
    {
        this.initComponents()
        val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()
        //this.jPanel1.setLayout(new java.awt.FlowLayout());
        this.setSize(640, 480)
        this.getMaxRedJTextField().setText("255")
        this.getMaxGreenJTextField().setText("255")
        this.getMaxBlueJTextField().setText("255")
        this.getMinRedJTextField().setText(commonPhoneStrings.ZERO)
        this.getMinGreenJTextField().setText(commonPhoneStrings.ZERO)
        this.getMinBlueJTextField().setText(commonPhoneStrings.ZERO)
        this.fileJDialog = new FileJDialog()
        this.fileJDialog.addFinishedListener(this)
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        analysisActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.colorRangeJLabel = new _root_.javax.swing.JLabel()
        this.redJLabel = new _root_.javax.swing.JLabel()
        this.minJLabel = new _root_.javax.swing.JLabel()
        this.maxJLabel = new _root_.javax.swing.JLabel()
        this.greenJLabel = new _root_.javax.swing.JLabel()
        this.blueJLabel = new _root_.javax.swing.JLabel()
        this.minRedJTextField = new _root_.javax.swing.JTextField()
        this.maxRedJTextField = new _root_.javax.swing.JTextField()
        this.maxGreenJTextField = new _root_.javax.swing.JTextField()
        this.minBlueJTextField = new _root_.javax.swing.JTextField()
        this.maxBlueJTextField = new _root_.javax.swing.JTextField()
        this.okJButton = new _root_.javax.swing.JButton()
        this.minGreenJTextField = new _root_.javax.swing.JTextField()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.mainJMenuBar = new _root_.javax.swing.JMenuBar()
        this.fileJMenu = new _root_.javax.swing.JMenu()
        this.openImageJMenuItem = new _root_.javax.swing.JMenuItem()
        this.processingJMenu = new _root_.javax.swing.JMenu()
        this.analyzeJMenuItem = new _root_.javax.swing.JMenuItem()
        this.generateSpriteSplitterMenuItem = new _root_.javax.swing.JMenuItem()
        this.generateRotationMenuItem = new _root_.javax.swing.JMenuItem()
        this.generateMirrorSpriteMenuItem = new _root_.javax.swing.JMenuItem()
        this.generateRotationSpriteJMenuItem = new _root_.javax.swing.JMenuItem()
        this.createStripImageJMenuItem = new _root_.javax.swing.JMenuItem()
        this.mirrorJMenuItem = new _root_.javax.swing.JMenuItem()
        this.scaleImagesJMenuItem = new _root_.javax.swing.JMenuItem()
        this.canvasImagesJMenuItem = new _root_.javax.swing.JMenuItem()
        this.createIconImagesJMenuItem = new _root_.javax.swing.JMenuItem()
        this.analysisActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(350, 250))
        this.titleJLabel.setText("              Color At Action Options            ")
        this.colorRangeJLabel.setText("Color Range")
        this.redJLabel.setText("Red:")
        this.minJLabel.setText("Minimum")
        this.maxJLabel.setText("Maximum")
        this.greenJLabel.setText("Green:")
        this.blueJLabel.setText("Blue:")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        var analysisActionJDialogLayout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(this.analysisActionJDialog.getContentPane())
        this.analysisActionJDialog.getContentPane().setLayout(analysisActionJDialogLayout)
        analysisActionJDialogLayout.setHorizontalGroup(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(analysisActionJDialogLayout.createSequentialGroup().addContainerGap().add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(analysisActionJDialogLayout.createSequentialGroup().add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(blueJLabel).add(greenJLabel).add(redJLabel).add(colorRangeJLabel)).add(29, 29, 29).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(_root_.org.jdesktop.layout.GroupLayout.TRAILING, minJLabel, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 58, _root_.java.lang.Short.MAX_VALUE).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING, false).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, minBlueJTextField).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, minGreenJTextField).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, minRedJTextField, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 42, _root_.java.lang.Short.MAX_VALUE).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, okJButton))).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, analysisActionJDialogLayout.createSequentialGroup().add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING, false).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, maxRedJTextField).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, analysisActionJDialogLayout.createSequentialGroup().add(1, 1, 1).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(maxBlueJTextField).add(maxGreenJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED, 17, _root_.java.lang.Short.MAX_VALUE)).add(_root_.org.jdesktop.layout.GroupLayout.LEADING, maxJLabel, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, _root_.java.lang.Short.MAX_VALUE)).addContainerGap()).add(_root_.org.jdesktop.layout.GroupLayout.TRAILING, analysisActionJDialogLayout.createSequentialGroup().add(titleJLabel).add(25, 25, 25)))))
        analysisActionJDialogLayout.setVerticalGroup(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(analysisActionJDialogLayout.createSequentialGroup().add(titleJLabel).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(minJLabel).add(colorRangeJLabel).add(maxJLabel)).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING).add(redJLabel).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(minRedJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(maxRedJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING).add(greenJLabel).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(minGreenJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(maxGreenJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))).addPreferredGap(_root_.org.jdesktop.layout.LayoutStyle.RELATED).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.TRAILING).add(blueJLabel).add(analysisActionJDialogLayout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.BASELINE).add(minBlueJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(maxBlueJTextField, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))).add(16, 16, 16).add(okJButton).addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        setDefaultCloseOperation(_root_.javax.swing.WindowConstants.EXIT_ON_CLOSE)
        getContentPane().setLayout(new _root_.java.awt.GridLayout(1, 0))
        this.jPanel1.setLayout(new _root_.java.awt.GridLayout(1, 0))
        getContentPane().add(this.jPanel1)
        this.fileJMenu.setText("File")
        this.fileJMenu.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    fileJMenuActionPerformed(evt)
                }

            })
        this.openImageJMenuItem.setText("Open")
        this.openImageJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    openImageJMenuItemActionPerformed(evt)
                }

            })
        this.fileJMenu.add(this.openImageJMenuItem)
        this.mainJMenuBar.add(this.fileJMenu)
        this.processingJMenu.setText("Processing")
        this.processingJMenu.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    processingJMenuActionPerformed(evt)
                }

            })
        this.analyzeJMenuItem.setText("Image Analyze")
        this.analyzeJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    analyzeJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.analyzeJMenuItem)
        this.generateMirrorSpriteMenuItem.setText("Mirror Sprite Generator")
        this.generateMirrorSpriteMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateMirrorSpriteMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.generateMirrorSpriteMenuItem)
        this.generateRotationSpriteJMenuItem.setText("Rotation Sprite Generator")
        this.generateRotationSpriteJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateRotationSpriteJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.generateRotationSpriteJMenuItem)
        this.generateSpriteSplitterMenuItem.setText("Sprite Splitter Generator")
        this.generateSpriteSplitterMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateSpriteSplitterMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.generateSpriteSplitterMenuItem)
        this.generateRotationMenuItem.setText("Rotate Image Generator")
        this.generateRotationMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    generateRotationMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.generateRotationMenuItem)
        this.createStripImageJMenuItem.setText("Multi Image Unifier")
        this.createStripImageJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    createStripImageJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.createStripImageJMenuItem)
        this.mirrorJMenuItem.setText("Mirror Image(s)")
        this.mirrorJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    mirrorJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.mirrorJMenuItem)
        this.scaleImagesJMenuItem.setText("Scale Image(s)")
        this.scaleImagesJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    scaleImagesJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.scaleImagesJMenuItem)
        this.canvasImagesJMenuItem.setText("Canvas Image(s)")
        this.canvasImagesJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    canvasImagesJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.canvasImagesJMenuItem)
        this.createIconImagesJMenuItem.setText("Create Icon Image(s)")
        this.createIconImagesJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    createIconsJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.createIconImagesJMenuItem)
        this.mainJMenuBar.add(this.processingJMenu)
        setJMenuBar(this.mainJMenuBar)
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def createStripImageJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_createStripImageJMenuItemActionPerformed
        try {
            var imageUnifierJPanel : ImageUnifierJPanel = new ImageUnifierJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(imageUnifierJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = imageUnifierJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "createStripImageJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_createStripImageJMenuItemActionPerformed
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_okJButtonActionPerformed
        try {
            this.logUtil.putF("Starting", this, "okJButtonActionPerformed")
            val imageAnalysisResultsArray : Array[ImageAnalysisResults] = ImageAnalysis.getInstance().process(this.imageProcessorInput.getBufferedImageArray(), this.getColorRangeInterface())
            this.jPanel1.removeAll()
            this.jPanel1.add(new ImageAnalysisResultsJPanel(imageAnalysisResultsArray))
            this.jPanel1.updateUI()
            this.analysisActionJDialog.setVisible(false)
            ImageToolJFrame.imageProcessorInputCompositeInterface = null
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "okJButtonActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def processingJMenuActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_processingJMenuActionPerformed
    private def openImageJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_openImageJMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "openImageJMenuItemActionPerformed")
            this.fileJDialog.setVisible(true)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "openImageJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_openImageJMenuItemActionPerformed
    def onFiles(files : Array[File]) : Unit = {
        try {
            this.logUtil.putF(("Reading " + files.length) + " files.", this, "onFiles")
            Arrays.sort(files, new Comparator[File] {
                    override def compare(file1 : File, file2 : File) : Int = {
                        val fileNameIndexValue1 : Int = extractIndexNumberIfAnyFromFileName(file1.getName())
                        val fileNameIndexValue2 : Int = extractIndexNumberIfAnyFromFileName(file2.getName())
                        return fileNameIndexValue1 - fileNameIndexValue2
                    }

                    private def extractIndexNumberIfAnyFromFileName(name : String) : Int = {
                        var i : Int = 0
                        try {
                            val start : Int = name.lastIndexOf('_') + 1
                            val end : Int = name.lastIndexOf('.')
                            val number : String = name.substring(start, end)
                            i = Integer.parseInt(number)
                        } catch {
                            case e : Exception => {
                                i = 0
                            }
                        }
                        return i
                    }

                })
            val bufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](files.length)

            {
                var index : Int = 0
                while (index < files.length) {
                    bufferedImageArray(index) = ImageIO.read(files(index))
                    if (bufferedImageArray(index) == null) {
                        throw new Exception("Unable to read file: " + files(index).getPath())
                    }
                    index += 1
                }
            }
            this.imageProcessorInput = new ImageProcessorInput(files, bufferedImageArray)
            this.fileJDialog.setVisible(false)
            if (ImageToolJFrame.imageProcessorInputCompositeInterface != null) {
                ImageToolJFrame.imageProcessorInputCompositeInterface.setImageProcessorInput(this.imageProcessorInput)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onFiles", e)
            }
        }
    }

    private def fileJMenuActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_fileJMenuActionPerformed
    private def analyzeJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_analyzeJMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "analyzeJMenuItemActionPerformed")
            this.analysisActionJDialog.setVisible(true)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "analyzeJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_analyzeJMenuItemActionPerformed
    private def generateRotationSpriteJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_generateRotationSpriteJMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "generateRotationSpriteJMenuItemActionPerformed")
            var spriteImageJPanel : RotationSpriteImageJPanel = new RotationSpriteImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(spriteImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = spriteImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "generateRotationSpriteJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_generateRotationSpriteJMenuItemActionPerformed
    private def generateSpriteSplitterMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_generateRotationMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "generateRotationSpriteJMenuItemActionPerformed")
            var imageJPanel : SpriteSplitterImageJPanel = new SpriteSplitterImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(imageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = imageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "generateRotationMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_generateRotationMenuItemActionPerformed
    private def generateRotationMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_generateRotationMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "generateRotationSpriteJMenuItemActionPerformed")
            var rotationImageJPanel : RotationImageJPanel = new RotationImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(rotationImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = rotationImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "generateRotationMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_generateRotationMenuItemActionPerformed
    private def scaleImagesJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_scaleImagesJMenuItemActionPerformed
        try {
            this.logUtil.putF(this.commonStrings.START, this, "scaleImagesJMenuItemActionPerformed")
            val resizeImageJPanel : ResizeImageJPanel = new ResizeImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(resizeImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = resizeImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "scaleImagesJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_scaleImagesJMenuItemActionPerformed
    private def createIconsJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_createIconsJMenuItemActionPerformed
        try {
            this.logUtil.putF(this.commonStrings.START, this, "createIconsJMenuItemActionPerformed")
            val createIconImagesJPanel : CreateIconImagesJPanel = new CreateIconImagesJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(createIconImagesJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = createIconImagesJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "scaleImagesJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:createIconsJMenuItemActionPerformed
    private def canvasImagesJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_scaleImagesJMenuItemActionPerformed
        try {
            this.logUtil.putF(this.commonStrings.START, this, "canvasImagesJMenuItemActionPerformed")
            val resizeImageJPanel : CanvasImageJPanel = new CanvasImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(resizeImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = resizeImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "scaleImagesJMenuItemActionPerformed", e)
            }
        }
    }

    private def generateMirrorSpriteMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_generateMirrorSpriteMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "generateMirrorSpriteJMenuItemActionPerformed")
            var spriteImageJPanel : MirrorSpriteImageJPanel = new MirrorSpriteImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(spriteImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = spriteImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "generateMirrorSpriteJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_generateMirrorSpriteMenuItemActionPerformed
    private def mirrorJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_mirrorJMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "generateMirrorJMenuItemActionPerformed")
            var mirrorImageJPanel : MirrorImageJPanel = new MirrorImageJPanel(this.imageProcessorInput)
            this.jPanel1.removeAll()
            this.jPanel1.add(mirrorImageJPanel)
            this.jPanel1.updateUI()
            ImageToolJFrame.imageProcessorInputCompositeInterface = mirrorImageJPanel
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "generateMirrorJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_mirrorJMenuItemActionPerformed
    private def getColorRangeInterface() : ColorRangeInterface = {
        var colorRangeInterface : ColorRangeInterface = (new ColorRange()).asInstanceOf[ColorRangeInterface]
        colorRangeInterface.setMinRed(new Integer(this.getMinRedJTextField().getText()).intValue())
        colorRangeInterface.setMaxRed(new Integer(this.getMaxRedJTextField().getText()).intValue())
        colorRangeInterface.setMinGreen(new Integer(this.getMinGreenJTextField().getText()).intValue())
        colorRangeInterface.setMaxGreen(new Integer(this.getMaxGreenJTextField().getText()).intValue())
        colorRangeInterface.setMinBlue(new Integer(this.getMinBlueJTextField().getText()).intValue())
        colorRangeInterface.setMaxBlue(new Integer(this.getMaxBlueJTextField().getText()).intValue())
        return colorRangeInterface
    }

    def getMaxBlueJTextField() : _root_.javax.swing.JTextField = {
        return this.maxBlueJTextField
    }

    def setMaxBlueJTextField(maxBlueJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxBlueJTextField = this.maxBlueJTextField
    }

    def getMaxGreenJTextField() : _root_.javax.swing.JTextField = {
        return this.maxGreenJTextField
    }

    def setMaxGreenJTextField(maxGreenJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxGreenJTextField = this.maxGreenJTextField
    }

    def getMaxRedJTextField() : _root_.javax.swing.JTextField = {
        return this.maxRedJTextField
    }

    def setMaxRedJTextField(maxRedJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxRedJTextField = this.maxRedJTextField
    }

    def getMinBlueJTextField() : _root_.javax.swing.JTextField = {
        return this.minBlueJTextField
    }

    def setMinBlueJTextField(minBlueJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minBlueJTextField = this.minBlueJTextField
    }

    def getMinGreenJTextField() : _root_.javax.swing.JTextField = {
        return this.minGreenJTextField
    }

    def setMinGreenJTextField(minGreenJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minGreenJTextField = this.minGreenJTextField
    }

    def getMinRedJTextField() : _root_.javax.swing.JTextField = {
        return this.minRedJTextField
    }

    def setMinRedJTextField(minRedJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minRedJTextField = this.minRedJTextField
    }

}

object ImageToolJFrame {
    private var imageProcessorInputCompositeInterface : ImageProcessorInputCompositeInterface = null

}


