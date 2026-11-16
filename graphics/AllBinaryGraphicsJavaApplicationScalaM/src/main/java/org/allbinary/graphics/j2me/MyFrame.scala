/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me

import _root_.java.awt.*
import _root_.java.io.File
import _root_.java.util.HashMap
import _root_.javax.swing.*
import _root_.org.allbinary.data.tree.dom.XslHelper
import _root_.org.allbinary.dom.DomHelper
import _root_.org.allbinary.graphics.j2me.dialog.NewWorkAreaJDialog
import _root_.org.allbinary.graphics.j2me.dialog.RotateJDialog
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanel
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanelInterface
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEvent
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventService
import _root_.org.allbinary.graphics.j2me.workarea.canvas.event.MyCanvasEventSource
import _root_.org.allbinary.gui.dialog.FileJDialog
import _root_.org.allbinary.gui.dialog.FileJDialogListenerInterface
import _root_.org.allbinary.gui.dialog.HashMapJDialogListenerInterface
import _root_.org.allbinary.log.LOGGING
import _root_.org.allbinary.logic.communication.log.GuiLog
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document

class MyFrame() extends _root_.javax.swing.JFrame with FileJDialogListenerInterface with HashMapJDialogListenerInterface with _root_.java.awt.event.KeyListener {
    import _root_.org.allbinary.graphics.j2me.MyFrame.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val guiLog : GuiLog = GuiLog.getInstance()

    private val xslHelper : XslHelper = XslHelper.getInstance()

    //private final String JAVA_TEMPLATE = "javaExport.xsl";
    private val JAVA_TEMPLATE : String = "svgExport.xsl"

    private val SAVEEXTENSION : String = ".gxml"

    private val JAVAEXTENSION : String = ".javax"

    private var fileJDialog : FileJDialog = null

    private var rotateJDialog : RotateJDialog = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var animateJButton : _root_.javax.swing.JButton = null

    private var autoDamageJMenuItem : _root_.javax.swing.JMenuItem = null

    private var autoExplodeJMenuItem : _root_.javax.swing.JMenuItem = null

    private var autoGrowJMenuItem : _root_.javax.swing.JMenuItem = null

    private var autoRotateGenerationJMenuItem : _root_.javax.swing.JMenuItem = null

    private var autoSheildMenuItem : _root_.javax.swing.JMenuItem = null

    private var autoShrinkJMenuItem : _root_.javax.swing.JMenuItem = null

    private var centerJMenuItem : _root_.javax.swing.JMenuItem = null

    private var copyJMenuItem1 : _root_.javax.swing.JMenuItem = null

    private var exitJMenuItem : _root_.javax.swing.JMenuItem = null

    private var explodeAllJMenuItem : _root_.javax.swing.JMenuItem = null

    private var exportJMenuItem1 : _root_.javax.swing.JMenuItem = null

    private var fileJMenu : _root_.javax.swing.JMenu = null

    private var frameJMenu : _root_.javax.swing.JMenu = null

    private var generateJMenu : _root_.javax.swing.JMenu = null

    private var insertAfterJMenuItem : _root_.javax.swing.JMenuItem = null

    private var insertBeforeJMenuItem : _root_.javax.swing.JMenuItem = null

    private var jButton1 : _root_.javax.swing.JButton = null

    private var jButton2 : _root_.javax.swing.JButton = null

    private var jButton3 : _root_.javax.swing.JButton = null

    private var jButton4 : _root_.javax.swing.JButton = null

    private var jButton41 : _root_.javax.swing.JButton = null

    private var jButton5 : _root_.javax.swing.JButton = null

    private var jMenu1 : _root_.javax.swing.JMenu = null

    private var jMenuItem1 : _root_.javax.swing.JMenuItem = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var jTabbedPane : _root_.javax.swing.JTabbedPane = null

    private var jToolBar1 : _root_.javax.swing.JToolBar = null

    private var mainJPanel : _root_.javax.swing.JPanel = null

    private var menuJMenuBar : _root_.javax.swing.JMenuBar = null

    private var newJMenuItem : _root_.javax.swing.JMenuItem = null

    private var nextFrameJMenuItem : _root_.javax.swing.JMenuItem = null

    private var objectJMenu : _root_.javax.swing.JMenu = null

    private var openJButton : _root_.javax.swing.JButton = null

    private var openJMenuItem : _root_.javax.swing.JMenuItem = null

    private var playJButton : _root_.javax.swing.JButton = null

    private var previousFrameJMenuItem : _root_.javax.swing.JMenuItem = null

    private var removeJMenuItem : _root_.javax.swing.JMenuItem = null

    private var saveAsJMenuItem : _root_.javax.swing.JMenuItem = null

    private var saveJButton : _root_.javax.swing.JButton = null

    private var saveJMenuItem : _root_.javax.swing.JMenuItem = null

    private var statusJPanel : _root_.javax.swing.JPanel = null

    private var stopJjButton : _root_.javax.swing.JButton = null

    private var viewJMenu : _root_.javax.swing.JMenu = null

    private var zoomInJMenuItem : _root_.javax.swing.JMenuItem = null

    private var zoomOutJMenuItem : _root_.javax.swing.JMenuItem = null

    //Constructor
    {
        this.initComponents()
        this.setSize(new Dimension(550, 400))
        this.mainJPanel.setSize(new Dimension(550, 400))
        this.jTabbedPane.setSize(new Dimension(550, 400))
        this.fileJDialog = new FileJDialog()
        this.fileJDialog.addFinishedListener(this)
        this.rotateJDialog = new RotateJDialog(this, false)
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        jToolBar1 = new _root_.javax.swing.JToolBar()
        this.jButton2 = new _root_.javax.swing.JButton()
        this.saveJButton = new _root_.javax.swing.JButton()
        this.jButton1 = new _root_.javax.swing.JButton()
        this.openJButton = new _root_.javax.swing.JButton()
        this.jButton3 = new _root_.javax.swing.JButton()
        this.jButton4 = new _root_.javax.swing.JButton()
        this.jButton41 = new _root_.javax.swing.JButton()
        this.jButton5 = new _root_.javax.swing.JButton()
        this.animateJButton = new _root_.javax.swing.JButton()
        this.playJButton = new _root_.javax.swing.JButton()
        this.stopJjButton = new _root_.javax.swing.JButton()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.mainJPanel = new _root_.javax.swing.JPanel()
        this.jTabbedPane = new _root_.javax.swing.JTabbedPane()
        this.statusJPanel = new _root_.javax.swing.JPanel()
        MyFrame.statusJLabel = new _root_.javax.swing.JLabel()
        this.menuJMenuBar = new _root_.javax.swing.JMenuBar()
        this.fileJMenu = new _root_.javax.swing.JMenu()
        this.newJMenuItem = new _root_.javax.swing.JMenuItem()
        this.openJMenuItem = new _root_.javax.swing.JMenuItem()
        this.saveJMenuItem = new _root_.javax.swing.JMenuItem()
        this.saveAsJMenuItem = new _root_.javax.swing.JMenuItem()
        this.exportJMenuItem1 = new _root_.javax.swing.JMenuItem()
        this.exitJMenuItem = new _root_.javax.swing.JMenuItem()
        this.viewJMenu = new _root_.javax.swing.JMenu()
        this.zoomInJMenuItem = new _root_.javax.swing.JMenuItem()
        this.zoomOutJMenuItem = new _root_.javax.swing.JMenuItem()
        this.objectJMenu = new _root_.javax.swing.JMenu()
        this.explodeAllJMenuItem = new _root_.javax.swing.JMenuItem()
        this.frameJMenu = new _root_.javax.swing.JMenu()
        this.previousFrameJMenuItem = new _root_.javax.swing.JMenuItem()
        this.nextFrameJMenuItem = new _root_.javax.swing.JMenuItem()
        this.removeJMenuItem = new _root_.javax.swing.JMenuItem()
        this.copyJMenuItem1 = new _root_.javax.swing.JMenuItem()
        this.insertAfterJMenuItem = new _root_.javax.swing.JMenuItem()
        this.insertBeforeJMenuItem = new _root_.javax.swing.JMenuItem()
        this.generateJMenu = new _root_.javax.swing.JMenu()
        this.centerJMenuItem = new _root_.javax.swing.JMenuItem()
        this.autoDamageJMenuItem = new _root_.javax.swing.JMenuItem()
        this.autoExplodeJMenuItem = new _root_.javax.swing.JMenuItem()
        this.autoGrowJMenuItem = new _root_.javax.swing.JMenuItem()
        this.jMenuItem1 = new _root_.javax.swing.JMenuItem()
        this.autoRotateGenerationJMenuItem = new _root_.javax.swing.JMenuItem()
        this.autoSheildMenuItem = new _root_.javax.swing.JMenuItem()
        this.autoShrinkJMenuItem = new _root_.javax.swing.JMenuItem()
        this.jMenu1 = new _root_.javax.swing.JMenu()
        addWindowListener(new _root_.java.awt.event.WindowAdapter {
                override def windowClosing(evt : _root_.java.awt.event.WindowEvent) : Unit = {
                    exitForm(evt)
                }

            })
        this.jButton2.setText("New")
        this.jButton2.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton2ActionPerformed(evt)
                }

            })
        this.jToolBar1.add(this.jButton2)
        this.saveJButton.setText("Save")
        this.saveJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    saveJButtonActionPerformed(evt)
                }

            })
        this.jToolBar1.add(this.saveJButton)
        this.jButton1.setText("Export")
        this.jButton1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton1ActionPerformed(evt)
                }

            })
        this.jToolBar1.add(this.jButton1)
        this.openJButton.setText("Open")
        this.openJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    openJButtonActionPerformed(evt)
                }

            })
        this.jToolBar1.add(this.openJButton)
        this.jButton3.setText("Copy")
        this.jToolBar1.add(this.jButton3)
        this.jButton4.setText("Insert Before")
        this.jToolBar1.add(this.jButton4)
        this.jButton41.setText("Insert After")
        this.jToolBar1.add(this.jButton41)
        this.jButton5.setText("Delete")
        this.jToolBar1.add(this.jButton5)
        this.animateJButton.setText("AnimateEdit")
        this.jToolBar1.add(this.animateJButton)
        this.playJButton.setText("Play")
        this.playJButton.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    playJButtonMousePressed(evt)
                }

            })
        this.jToolBar1.add(this.playJButton)
        this.stopJjButton.setText("Stop")
        this.stopJjButton.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    stopJjButtonMousePressed(evt)
                }

            })
        this.jToolBar1.add(this.stopJjButton)
        getContentPane().add(this.jToolBar1, _root_.java.awt.BorderLayout.NORTH)
        this.jPanel1.setLayout(new _root_.java.awt.GridLayout(1, 0))
        this.mainJPanel.setLayout(new _root_.java.awt.GridLayout(1, 0))
        this.jTabbedPane.setMinimumSize(new _root_.java.awt.Dimension(550, 400))
        this.jTabbedPane.addChangeListener(new _root_.javax.swing.event.ChangeListener {
                override def stateChanged(evt : _root_.javax.swing.event.ChangeEvent) : Unit = {
                    jTabbedPaneStateChanged(evt)
                }

            })
        this.mainJPanel.add(this.jTabbedPane)
        this.jPanel1.add(this.mainJPanel)
        getContentPane().add(this.jPanel1, _root_.java.awt.BorderLayout.CENTER)
        this.statusJPanel.setLayout(new _root_.java.awt.GridLayout(1, 0))
        MyFrame.statusJLabel.setText("Status Bar")
        this.statusJPanel.add(MyFrame.statusJLabel)
        getContentPane().add(this.statusJPanel, _root_.java.awt.BorderLayout.SOUTH)
        this.fileJMenu.setText("File")
        this.fileJMenu.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    fileJMenuActionPerformed(evt)
                }

            })
        this.newJMenuItem.setText("New")
        this.newJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    newJMenuItemActionPerformed(evt)
                }

            })
        this.fileJMenu.add(this.newJMenuItem)
        this.openJMenuItem.setText("Open")
        this.openJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    openJMenuItemActionPerformed(evt)
                }

            })
        this.fileJMenu.add(this.openJMenuItem)
        this.saveJMenuItem.setText("Save")
        this.saveJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    saveJMenuItemMousePressed(evt)
                }

            })
        this.fileJMenu.add(this.saveJMenuItem)
        this.saveAsJMenuItem.setText("SaveAs")
        this.fileJMenu.add(this.saveAsJMenuItem)
        this.exportJMenuItem1.setText("Export")
        this.exportJMenuItem1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    exportJMenuItem1ActionPerformed(evt)
                }

            })
        this.fileJMenu.add(this.exportJMenuItem1)
        this.exitJMenuItem.setText("Exit")
        this.exitJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    exitJMenuItemActionPerformed(evt)
                }

            })
        this.fileJMenu.add(this.exitJMenuItem)
        this.menuJMenuBar.add(this.fileJMenu)
        this.viewJMenu.setText("View")
        this.zoomInJMenuItem.setText("Zoom In")
        this.zoomInJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    zoomInJMenuItemMousePressed(evt)
                }

            })
        this.viewJMenu.add(this.zoomInJMenuItem)
        this.zoomOutJMenuItem.setText("Zoom Out")
        this.zoomOutJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    zoomOutJMenuItemMousePressed(evt)
                }

            })
        this.viewJMenu.add(this.zoomOutJMenuItem)
        this.menuJMenuBar.add(this.viewJMenu)
        this.objectJMenu.setText("Objects")
        this.explodeAllJMenuItem.setText("Explode All")
        this.explodeAllJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    explodeAllJMenuItemMousePressed(evt)
                }

            })
        this.objectJMenu.add(this.explodeAllJMenuItem)
        this.menuJMenuBar.add(this.objectJMenu)
        this.frameJMenu.setText("Frame")
        this.frameJMenu.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    frameJMenuActionPerformed(evt)
                }

            })
        this.previousFrameJMenuItem.setText("Previous")
        this.frameJMenu.add(this.previousFrameJMenuItem)
        this.nextFrameJMenuItem.setText(CommonLabels.getInstance().NEXT)
        this.frameJMenu.add(this.nextFrameJMenuItem)
        this.removeJMenuItem.setText("Remove")
        this.frameJMenu.add(this.removeJMenuItem)
        this.copyJMenuItem1.setText("Copy")
        this.frameJMenu.add(this.copyJMenuItem1)
        this.insertAfterJMenuItem.setText("Ins After")
        this.frameJMenu.add(this.insertAfterJMenuItem)
        this.insertBeforeJMenuItem.setText("Ins Before")
        this.frameJMenu.add(this.insertBeforeJMenuItem)
        this.menuJMenuBar.add(this.frameJMenu)
        this.generateJMenu.setText("Generate")
        this.centerJMenuItem.setText("Center")
        this.centerJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    centerJMenuItemActionPerformed(evt)
                }

            })
        this.generateJMenu.add(this.centerJMenuItem)
        this.autoDamageJMenuItem.setText("Damage")
        this.generateJMenu.add(this.autoDamageJMenuItem)
        this.autoExplodeJMenuItem.setText("Explode")
        this.autoExplodeJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    autoExplodeJMenuItemMousePressed(evt)
                }

            })
        this.generateJMenu.add(this.autoExplodeJMenuItem)
        this.autoGrowJMenuItem.setText("Grow")
        this.generateJMenu.add(this.autoGrowJMenuItem)
        this.jMenuItem1.setText("Mirror")
        this.jMenuItem1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jMenuItem1ActionPerformed(evt)
                }

            })
        this.generateJMenu.add(this.jMenuItem1)
        this.autoRotateGenerationJMenuItem.setText("Rotate")
        this.autoRotateGenerationJMenuItem.addMouseListener(new _root_.java.awt.event.MouseAdapter {
                override def mousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
                    autoRotateGenerationJMenuItemMousePressed(evt)
                }

            })
        this.generateJMenu.add(this.autoRotateGenerationJMenuItem)
        this.autoSheildMenuItem.setText("Shield")
        this.generateJMenu.add(this.autoSheildMenuItem)
        this.autoShrinkJMenuItem.setText("Shrink")
        this.generateJMenu.add(this.autoShrinkJMenuItem)
        this.menuJMenuBar.add(this.generateJMenu)
        this.jMenu1.setText("Help")
        this.menuJMenuBar.add(this.jMenu1)
        setJMenuBar(this.menuJMenuBar)
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def explodeAllJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_explodeAllJMenuItemMousePressed
        try {
            MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.EXPLODE, null)).asInstanceOf[Object]))
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "explodeAllJMenuItemMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_explodeAllJMenuItemMousePressed
    private def autoExplodeJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_autoExplodeJMenuItemMousePressed
        try {
            MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.AUTOEXPLODE, null)).asInstanceOf[Object]))
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "autoExplodeJMenuItemMousePressed", e)
            }
        }
    }

    //GEN-LAST:event_autoExplodeJMenuItemMousePressed
    private def stopJjButtonMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_stopJjButtonMousePressed
        this.getSelectedWorkArea().stop()
    }

    //GEN-LAST:event_stopJjButtonMousePressed
    private def playJButtonMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_playJButtonMousePressed
        this.getSelectedWorkArea().play()
    }

    //GEN-LAST:event_playJButtonMousePressed
    private def autoRotateGenerationJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_autoRotateGenerationJMenuItemMousePressed
        this.rotateJDialog.setVisible(true)
    }

    //GEN-LAST:event_autoRotateGenerationJMenuItemMousePressed
    private def zoomOutJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_zoomOutJMenuItemMousePressed
        this.getSelectedWorkArea().changeZoom(-1)
    }

    //GEN-LAST:event_zoomOutJMenuItemMousePressed
    private def zoomInJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_zoomInJMenuItemMousePressed
        this.getSelectedWorkArea().changeZoom(1)
    }

    //GEN-LAST:event_zoomInJMenuItemMousePressed
    private def openJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_openJMenuItemActionPerformed
        this.openGraphics()
    }

    //GEN-LAST:event_openJMenuItemActionPerformed
    private def exportJMenuItem1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_exportJMenuItem1ActionPerformed
        this.`export`()
    }

    //GEN-LAST:event_exportJMenuItem1ActionPerformed
    private def saveJMenuItemMousePressed(evt : _root_.java.awt.event.MouseEvent) : Unit = {
        //GEN-HEADEREND:event_saveJMenuItemMousePressed
        this.save()
    }

    //GEN-LAST:event_saveJMenuItemMousePressed
    private def jTabbedPaneStateChanged(evt : _root_.javax.swing.event.ChangeEvent) : Unit = {
        //GEN-HEADEREND:event_jTabbedPaneStateChanged
        this.updateSelectedWorkArea()
    }

    //GEN-LAST:event_jTabbedPaneStateChanged
    private def frameJMenuActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_frameJMenuActionPerformed
    private def exitJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // Add your handling code here:
        System.exit(0)
    }

    //GEN-LAST:event_exitJMenuItemActionPerformed
    private def newJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_newJMenuItemActionPerformed
        this.newGraphics()
    }

    //GEN-LAST:event_newJMenuItemActionPerformed
    private def fileJMenuActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    /** Exit the Application */
    private def exitForm(evt : _root_.java.awt.event.WindowEvent) : Unit = {
        //GEN-FIRST:event_exitForm
        System.exit(0)
    }

    //GEN-LAST:event_exitForm
    private def openJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_openJButtonActionPerformed
        this.openGraphics()
    }

    //GEN-LAST:event_openJButtonActionPerformed
    private def jButton2ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_jButton2ActionPerformed
        this.newGraphics()
    }

    //GEN-LAST:event_jButton2ActionPerformed
    private def centerJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_centerJMenuItemActionPerformed
        try {
            MyCanvasEventService.fire(new MyCanvasEvent((new MyCanvasEventSource(MyCanvasEventService.CENTER, null)).asInstanceOf[Object]))
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "centerJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_centerJMenuItemActionPerformed
    private def saveJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_saveJButtonActionPerformed
        this.save()
    }

    //GEN-LAST:event_saveJButtonActionPerformed
    private def jButton1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_jButton1ActionPerformed
        this.`export`()
    }

    //GEN-LAST:event_jButton1ActionPerformed
    private def jMenuItem1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            this.getSelectedWorkArea().autoMirror()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "centerJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_jMenuItem1ActionPerformed
    def onFiles(files : Array[File]) : Unit = {
        try {
            this.logUtil.putF("Reading: " + files, this, "onFiles")

            {
                var index : Int = 0
                while (index < files.length) {
                    var document : Document = DomHelper.getInstance().createDocument(files(index))
                    var workAreaJPanel : WorkAreaJPanel = new WorkAreaJPanel(new WorkAreaDom(document), this.getSize())
                    workAreaJPanel.setLayout(new GridLayout(1, 1))
                    this.add(workAreaJPanel.asInstanceOf[WorkAreaJPanelInterface])
                    index += 1
                }
            }
            this.fileJDialog.setVisible(false)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onFiles", e)
            }
        }
    }

    private def newGraphics() : Unit = {
        try {
            var newName : String = "graphic" + MyFrame.numberOfWorkAreas
            var dim : Dimension = this.getSize()
            var newDialog : NewWorkAreaJDialog = new NewWorkAreaJDialog(this, false, dim, newName)
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.MENUEVENT)) {
                    this.guiLog.put(this.commonStrings.EXCEPTION, this, "newJMenuItemActionPerformed", e)
                }
            }
        }
    }

    private def openGraphics() : Unit = {
        try {
            this.logUtil.putF("Starting", this, "openImageJMenuItemActionPerformed")
            this.fileJDialog.setVisible(true)
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.MENUEVENT)) {
                    this.guiLog.put(this.commonStrings.EXCEPTION, this, "open", e)
                }
            }
        }
    }

    private def `export`() : Unit = {
        try {
            var workAreaJPanel : WorkAreaJPanelInterface = this.jTabbedPane.getSelectedComponent().asInstanceOf[WorkAreaJPanelInterface]
            var file : File = new File(((_root_.org.allbinary.graphics.j2me.MyFrame.SAVE_PATH + "/") + workAreaJPanel.getName()) + this.JAVAEXTENSION)
            var document : Document = workAreaJPanel.toDocument()
            this.logUtil.putF("Export: " + DomHelper.getInstance().toString(document), this, "exportJMenuItem1ActionPerformed")
            this.xslHelper.`export`(file, (MyFrame.TEMPLATE_EXPORT_PATH + "/") + this.JAVA_TEMPLATE, document)
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.MENUEVENT)) {
                    this.guiLog.put(this.commonStrings.EXCEPTION, this, "export", e)
                }
            }
        }
    }

    private def save() : Unit = {
        try {
            var workAreaJPanel : WorkAreaJPanelInterface = this.jTabbedPane.getSelectedComponent().asInstanceOf[WorkAreaJPanelInterface]
            DomHelper.getInstance().save(new File(((_root_.org.allbinary.graphics.j2me.MyFrame.SAVE_PATH + "/") + workAreaJPanel.getName()) + this.SAVEEXTENSION), workAreaJPanel.toDocument())
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.MENUEVENT)) {
                    this.guiLog.put(this.commonStrings.EXCEPTION, this, this.commonStrings.SAVE, e)
                }
            }
        }
    }

    def onHashMap(hashMap : HashMap[Object, Object]) : Unit = {
        var angleIncrementInteger : Integer = hashMap.get(Integer.valueOf(0)).asInstanceOf[Integer]
        var totalRotationInteger : Integer = hashMap.get(Integer.valueOf(1)).asInstanceOf[Integer]
        this.getSelectedWorkArea().autoRotate(angleIncrementInteger.intValue(), totalRotationInteger.intValue())
    }

    private def getSelectedWorkArea() : WorkAreaJPanelInterface = {
        return this.jTabbedPane.getSelectedComponent().asInstanceOf[WorkAreaJPanelInterface]
    }

    def updateSelectedWorkArea() : Unit = {
        var numberOfTabs : Int = this.jTabbedPane.getTabCount()

        {
            var index : Int = 0
            while (index < numberOfTabs) {
                var workAreaJPanel : WorkAreaJPanelInterface = this.jTabbedPane.getComponentAt(index).asInstanceOf[WorkAreaJPanelInterface]
                workAreaJPanel.deselect()
                index += 1
            }
        }
        var workAreaJPanel : WorkAreaJPanelInterface = this.jTabbedPane.getSelectedComponent().asInstanceOf[WorkAreaJPanelInterface]
        if (workAreaJPanel != null) {
            workAreaJPanel.select()
        }
    }

    def add(newCanvasInterface : WorkAreaJPanelInterface) : Unit = {
        try {
            _root_.org.allbinary.graphics.j2me.MyFrame.numberOfWorkAreas += 1
            if (_root_.org.allbinary.graphics.j2me.MyFrame.numberOfWorkAreas == MyFrame.MAXWORKAREAS) {
                throw new Exception()
            }
            this.jTabbedPane.addTab(newCanvasInterface.getName(), newCanvasInterface.asInstanceOf[JPanel])
            this.jTabbedPane.setSelectedComponent(newCanvasInterface.asInstanceOf[JPanel])
            //WorkAreaJPanel newCanvas = (WorkAreaJPanelInterface) newCanvasInterface;
            var animationThread : Thread = new Thread(newCanvasInterface.asInstanceOf[Runnable])
            animationThread.start()
            this.updateSelectedWorkArea()
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.GRAPHICSCREATION)) {
                    this.guiLog.put(this.commonStrings.EXCEPTION, this, "addNewCanvas", e)
                }
            }
        }
    }

    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        this.getSelectedWorkArea().keyPressed(keyEvent)
    }

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

}

object MyFrame {
    private val MAXWORKAREAS : Int = 10

    private var numberOfWorkAreas : Int = 0

    private val PATH : String = "G:/mnt/bc/mydev/work/graphics/AllBinaryGraphicsJavaApplication"

    private val SAVE_PATH : String = MyFrame.PATH + "/save"

    private val TEMPLATE_EXPORT_PATH : String = MyFrame.PATH + "/templates/export"

    def main(args : Array[String]) : Unit = {
        try {
            //.init();
            AngleFactory.getInstance()
            SmallIntegerSingletonFactory.getInstance().init()
            new MyFrame().show()
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.put(CommonStrings.getInstance().EXCEPTION, null, "main", e)
            }
        }
    }

    var statusJLabel : _root_.javax.swing.JLabel = null

}


