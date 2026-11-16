/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.org.allbinary.thread.ARunnable
import _root_.java.net.URI
import _root_.java.net.URL
import _root_.java.awt.Desktop
import _root_.java.util.List
import _root_.javax.swing.ImageIcon
import _root_.javax.swing.JDialog
import _root_.javax.help.HelpSet
import _root_.javax.help.event.HelpSetEvent
import _root_.javax.help.event.HelpSetListener
import _root_.bundle.input.automation.InputAutomationBundleActivatorListenerInterface
import _root_.bundle.input.automation.module.configuration.InputAutomationConfigurationModuleChangeListener
import _root_.bundle.input.automation.robot.InputAutomationRobotChangeListener
import _root_.org.allbinary.globals.AppUrlGlobals
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.gui.dialog.BasicTextJDialog
import _root_.org.allbinary.gui.swing.workers.JListSwingWorker
import _root_.org.allbinary.input.automation.configuration.InputAutomationConfiguration
import _root_.org.allbinary.input.automation.configuration.InputAutomationConfigurationFactory
import _root_.org.allbinary.input.automation.configuration.InputAutomationConfigurationModuleChangeEvent
import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryFactory
import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfigurations
import _root_.org.allbinary.input.automation.osgi.DesktopBundle
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.osgi.InputAutomationRobotChangeEvent
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.java.help.JavaHelpUtil
import _root_.org.allbinary.logic.system.loader.WebappClassLoaderInfo
import _root_.org.allbinary.logic.system.security.licensing.InputAutomationClientInformationFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.RunnableInterface

class InputAutomationJFrame() extends _root_.javax.swing.JFrame with InputAutomationConfigurationModuleChangeListener with InputAutomationRobotChangeListener with HelpSetListener {
    import _root_.org.allbinary.input.automation.InputAutomationJFrame.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var inputAutomationModuleConfigurations : InputAutomationModuleConfigurations = new InputAutomationModuleConfigurations()

    private var inputAutomationModuleFactory : InputAutomationModuleFactoryFactory = null

    private var inputAutomationModuleInterface : InputAutomationModuleFactoryInterface = null

    private var runnableInterface : RunnableInterface = null

    private var thread : Thread = null

    private var helpSet : HelpSet = null

    private val uri : URI = new URI("http://geocities.com/allbinary/")

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var aboutJMenuItem : _root_.javax.swing.JMenuItem = null

    private var automationModuleConfigurationJPanel : _root_.javax.swing.JPanel = null

    private var gameRobotJTabbedPane : _root_.javax.swing.JTabbedPane = null

    private var helpJMenuItem : _root_.javax.swing.JMenuItem = null

    private var inputAutomationModuleJList : _root_.javax.swing.JList[Object] = null

    private var inputAutomationModuleJPanel : _root_.javax.swing.JPanel = null

    private var jScrollPane1 : _root_.javax.swing.JScrollPane = null

    private var mainJMenuBar : _root_.javax.swing.JMenuBar = null

    private var modulesJMenuItem : _root_.javax.swing.JMenuItem = null

    private var noModuleSelectedJDialog : _root_.javax.swing.JDialog = null

    private var noModuleSelectedJLabel : _root_.javax.swing.JLabel = null

    private var optionsJMenu : _root_.javax.swing.JMenu = null

    private var processingJMenu : _root_.javax.swing.JMenu = null

    private var startJMenuItem : _root_.javax.swing.JMenuItem = null

    private var stopJMenuItem : _root_.javax.swing.JMenuItem = null

    private var stopOnFocusJCheckBoxMenuItem : _root_.javax.swing.JCheckBoxMenuItem = null

    private var subscriptionJMenuItem : _root_.javax.swing.JMenuItem = null

    private var toolsJMenu : _root_.javax.swing.JMenu = null

    private var updatesJMenuItem : _root_.javax.swing.JMenuItem = null

    //Constructor
    {
        this.initComponents()
        //fileJDialog.addFinishedListener(this);
        var url : URL = this.getClass().getResource("/help/Help.hs")
        this.logUtil.putF("URL: " + url, this, this.commonStrings.CONSTRUCTOR)
        this.helpSet = JavaHelpUtil.getInstance().getHelpSet(url)
        url = this.getClass().getResource("/resources/allbinaryicon8bit.jpg")
        val imageIcon : ImageIcon = new ImageIcon(url)
        this.setIconImage(imageIcon.getImage())
        this.init()
    }

    def helpSetAdded(helpSetEvent : HelpSetEvent) : Unit = {
        this.helpSet.add(helpSetEvent.getHelpSet())
    }

    def helpSetRemoved(helpSetEvent : HelpSetEvent) : Unit = {
        this.helpSet.remove(helpSetEvent.getHelpSet())
    }

    private def init() : Unit = {
        val inputAutomationConfigurationFactory : InputAutomationConfigurationFactory = InputAutomationConfigurationFactory.getInstance()
        inputAutomationConfigurationFactory.init(InputAutomationClientInformationFactory.getInstance())
        val inputAutomationModuleConfigurationList : List[InputAutomationModuleConfiguration] = inputAutomationConfigurationFactory.inputAutomationConfiguration.getInputAutomationModuleConfigurationList()
        if (inputAutomationModuleConfigurationList == null) {
        } else {
            this.inputAutomationModuleConfigurations = new InputAutomationModuleConfigurations(inputAutomationModuleConfigurationList)
        }
        this.inputAutomationModuleFactory = new InputAutomationModuleFactoryFactory(inputAutomationModuleConfigurations, this)
        (new JListSwingWorker(this.inputAutomationModuleJList, this.inputAutomationModuleFactory.getListModel())).execute()
        this.gameRobotJTabbedPane.setEnabledAt(1, false)
        this.gameRobotJTabbedPane.setSelectedIndex(0)
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.noModuleSelectedJDialog = new _root_.javax.swing.JDialog()
        this.noModuleSelectedJLabel = new _root_.javax.swing.JLabel()
        this.gameRobotJTabbedPane = new _root_.javax.swing.JTabbedPane()
        this.inputAutomationModuleJPanel = new _root_.javax.swing.JPanel()
        this.jScrollPane1 = new _root_.javax.swing.JScrollPane()
        this.inputAutomationModuleJList = new _root_.javax.swing.JList[Object]()
        this.automationModuleConfigurationJPanel = new _root_.javax.swing.JPanel()
        this.mainJMenuBar = new _root_.javax.swing.JMenuBar()
        this.processingJMenu = new _root_.javax.swing.JMenu()
        this.startJMenuItem = new _root_.javax.swing.JMenuItem()
        this.stopJMenuItem = new _root_.javax.swing.JMenuItem()
        this.optionsJMenu = new _root_.javax.swing.JMenu()
        this.stopOnFocusJCheckBoxMenuItem = new _root_.javax.swing.JCheckBoxMenuItem()
        this.toolsJMenu = new _root_.javax.swing.JMenu()
        this.helpJMenuItem = new _root_.javax.swing.JMenuItem()
        this.updatesJMenuItem = new _root_.javax.swing.JMenuItem()
        this.subscriptionJMenuItem = new _root_.javax.swing.JMenuItem()
        this.modulesJMenuItem = new _root_.javax.swing.JMenuItem()
        this.aboutJMenuItem = new _root_.javax.swing.JMenuItem()
        this.noModuleSelectedJDialog.setMinimumSize(new _root_.java.awt.Dimension(200, 100))
        this.noModuleSelectedJLabel.setText("Please Select A Module")
        var noModuleSelectedJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.noModuleSelectedJDialog.getContentPane())
        this.noModuleSelectedJDialog.getContentPane().setLayout(noModuleSelectedJDialogLayout)
        noModuleSelectedJDialogLayout.setHorizontalGroup(noModuleSelectedJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(noModuleSelectedJDialogLayout.createSequentialGroup().addContainerGap().addComponent(noModuleSelectedJLabel).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        noModuleSelectedJDialogLayout.setVerticalGroup(noModuleSelectedJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(noModuleSelectedJLabel, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 48, _root_.java.lang.Short.MAX_VALUE))
        setDefaultCloseOperation(_root_.javax.swing.WindowConstants.EXIT_ON_CLOSE)
        this.setMinimumSize(new _root_.java.awt.Dimension(325, 215))
        setResizable(false)
        addWindowFocusListener(new _root_.java.awt.event.WindowFocusListener {
                override def windowGainedFocus(evt : _root_.java.awt.event.WindowEvent) : Unit = {
                    formWindowGainedFocus(evt)
                }

                override def windowLostFocus(evt : _root_.java.awt.event.WindowEvent) : Unit = {
                    formWindowLostFocus(evt)
                }

            })
        addFocusListener(new _root_.java.awt.event.FocusAdapter {
                override def focusGained(evt : _root_.java.awt.event.FocusEvent) : Unit = {
                    formFocusGained(evt)
                }

                override def focusLost(evt : _root_.java.awt.event.FocusEvent) : Unit = {
                    formFocusLost(evt)
                }

            })
        this.gameRobotJTabbedPane.setMinimumSize(new _root_.java.awt.Dimension(320, 200))
        this.inputAutomationModuleJList.setMinimumSize(new _root_.java.awt.Dimension(200, 0))
        this.inputAutomationModuleJList.addListSelectionListener(new _root_.javax.swing.event.ListSelectionListener {
                override def valueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
                    inputAutomationModuleJListValueChanged(evt)
                }

            })
        this.jScrollPane1.setViewportView(this.inputAutomationModuleJList)
        var inputAutomationModuleJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.inputAutomationModuleJPanel)
        this.inputAutomationModuleJPanel.setLayout(inputAutomationModuleJPanelLayout)
        inputAutomationModuleJPanelLayout.setHorizontalGroup(inputAutomationModuleJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(inputAutomationModuleJPanelLayout.createSequentialGroup().addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 199, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(367, _root_.java.lang.Short.MAX_VALUE)))
        inputAutomationModuleJPanelLayout.setVerticalGroup(inputAutomationModuleJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(inputAutomationModuleJPanelLayout.createSequentialGroup().addComponent(jScrollPane1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 330, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(_root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        this.gameRobotJTabbedPane.addTab("Modules", inputAutomationModuleJPanel)
        var automationModuleConfigurationJPanelLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.automationModuleConfigurationJPanel)
        this.automationModuleConfigurationJPanel.setLayout(automationModuleConfigurationJPanelLayout)
        automationModuleConfigurationJPanelLayout.setHorizontalGroup(automationModuleConfigurationJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 566, _root_.java.lang.Short.MAX_VALUE))
        automationModuleConfigurationJPanelLayout.setVerticalGroup(automationModuleConfigurationJPanelLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 334, _root_.java.lang.Short.MAX_VALUE))
        this.gameRobotJTabbedPane.addTab("Configuration", automationModuleConfigurationJPanel)
        this.processingJMenu.setText("Processing")
        this.processingJMenu.setToolTipText("Set module processing state")
        this.startJMenuItem.setText(this.commonStrings.START)
        this.startJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    startJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.startJMenuItem)
        this.stopJMenuItem.setText("Stop")
        this.stopJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    stopJMenuItemActionPerformed(evt)
                }

            })
        this.processingJMenu.add(this.stopJMenuItem)
        this.mainJMenuBar.add(this.processingJMenu)
        this.optionsJMenu.setText("Options")
        this.optionsJMenu.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    optionsJMenuActionPerformed(evt)
                }

            })
        this.stopOnFocusJCheckBoxMenuItem.setSelected(true)
        this.stopOnFocusJCheckBoxMenuItem.setEnabled(false)
        this.stopOnFocusJCheckBoxMenuItem.setLabel("Stop Module On Focus")
        this.stopOnFocusJCheckBoxMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    stopOnFocusJCheckBoxMenuItemActionPerformed(evt)
                }

            })
        this.optionsJMenu.add(this.stopOnFocusJCheckBoxMenuItem)
        this.mainJMenuBar.add(this.optionsJMenu)
        this.toolsJMenu.setText("Help")
        this.helpJMenuItem.setText("Help")
        this.helpJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    helpJMenuItemActionPerformed(evt)
                }

            })
        this.toolsJMenu.add(this.helpJMenuItem)
        this.updatesJMenuItem.setText("Updates")
        this.updatesJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    updatesJMenuItemActionPerformed(evt)
                }

            })
        this.toolsJMenu.add(this.updatesJMenuItem)
        this.subscriptionJMenuItem.setText("Subscription")
        this.subscriptionJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    subscriptionJMenuItemActionPerformed(evt)
                }

            })
        this.toolsJMenu.add(this.subscriptionJMenuItem)
        this.modulesJMenuItem.setText("Module Manager")
        this.modulesJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    modulesJMenuItemActionPerformed(evt)
                }

            })
        this.toolsJMenu.add(this.modulesJMenuItem)
        this.aboutJMenuItem.setText("About")
        this.aboutJMenuItem.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    aboutJMenuItemActionPerformed(evt)
                }

            })
        this.toolsJMenu.add(this.aboutJMenuItem)
        this.mainJMenuBar.add(this.toolsJMenu)
        setJMenuBar(this.mainJMenuBar)
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(getContentPane())
        getContentPane().setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(gameRobotJTabbedPane, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 571, _root_.java.lang.Short.MAX_VALUE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(gameRobotJTabbedPane, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 359, _root_.java.lang.Short.MAX_VALUE))
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def subscriptionJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_subscriptionJMenuItemActionPerformed
        try {
            Desktop.getDesktop().browse(this.uri)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "subscriptionJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_subscriptionJMenuItemActionPerformed
    private def updatesJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_updatesJMenuItemActionPerformed
        try {
            Desktop.getDesktop().browse(this.uri)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "updatesJMenuItemActionPerformed", e)
            }
        }
    }

    //GEN-LAST:event_updatesJMenuItemActionPerformed
    private def aboutJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        var textJDialog : JDialog = new BasicTextJDialog("Copyright (c) 2002-2007 AllBinary")
        textJDialog.setVisible(true)
        textJDialog.setLocationRelativeTo(this)
    }

    //GEN-LAST:event_aboutJMenuItemActionPerformed
    private def modulesJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_modulesJMenuItemActionPerformed
        try {
            new DesktopBundle().start()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "modulesJMenuItemActionPerformed", e)
            }
        }
    }

    /*    private void addModuleJMenuItemActionPerformed(java.awt.event.ActionEvent evt)    {    this.fileJDialog.setVisible(true);    }     */
    private def helpJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_helpJMenuItemActionPerformed
        JavaHelpUtil.getInstance().show(this.helpSet)
    }

    //GEN-LAST:event_helpJMenuItemActionPerformed
    private def stopOnFocusJCheckBoxMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_stopOnFocusJCheckBoxMenuItemActionPerformed
    private def optionsJMenuActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
    }

    //GEN-LAST:event_optionsJMenuActionPerformed
    private def formWindowLostFocus(evt : _root_.java.awt.event.WindowEvent) : Unit = {
        // TODO add your handling code here:
        this.logUtil.putF("Nothing", this, "focusLost")
    }

    //GEN-LAST:event_formWindowLostFocus
    private def formWindowGainedFocus(evt : _root_.java.awt.event.WindowEvent) : Unit = {
        // TODO add your handling code here:
        if (this.stopOnFocusJCheckBoxMenuItem.isSelected()) {
            this.logUtil.putF("Stopping", this, "focusGained")
            if (this.runnableInterface != null) {
                this.runnableInterface.setRunning(false)
            }
        }
    }

    //GEN-LAST:event_formWindowGainedFocus
    private def formFocusLost(evt : _root_.java.awt.event.FocusEvent) : Unit = {
    }

    //GEN-LAST:event_formFocusLost
    private def formFocusGained(evt : _root_.java.awt.event.FocusEvent) : Unit = {
    }

    //GEN-LAST:event_formFocusGained
    private def inputAutomationModuleJListValueChanged(evt : _root_.javax.swing.event.ListSelectionEvent) : Unit = {
        //GEN-HEADEREND:event_inputAutomationModuleJListValueChanged
        try {
            var gameAutomationRobotModuleNameString : String = this.inputAutomationModuleJList.getSelectedValue().asInstanceOf[String]
            if (gameAutomationRobotModuleNameString != null) {
                this.inputAutomationModuleInterface = this.inputAutomationModuleFactory.getInstance(gameAutomationRobotModuleNameString)
                this.getAutomationModuleConfigurationJPanel().removeAll()
                var layout : _root_.javax.swing.GroupLayout = this.getAutomationModuleConfigurationJPanel().getLayout().asInstanceOf[_root_.javax.swing.GroupLayout]
                layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 395, _root_.java.lang.Short.MAX_VALUE).addComponent(this.inputAutomationModuleInterface.getConfigurationJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
                layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, _root_.java.lang.Short.MAX_VALUE).addComponent(this.inputAutomationModuleInterface.getConfigurationJPanel(), _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))
                this.gameRobotJTabbedPane.setEnabledAt(1, true)
                this.logUtil.putF(("Setting Module: " + gameAutomationRobotModuleNameString) + " and Configuration JPanel", this, "gameAutomationRobotModuleJListValueChanged")
            } else {
                this.logUtil.putF("Module name was null", this, "gameAutomationRobotModuleJListValueChanged")
                this.gameRobotJTabbedPane.setEnabledAt(1, false)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "gameAutomationRobotModuleJListValueChanged", e)
            }
        }
    }

    //GEN-LAST:event_inputAutomationModuleJListValueChanged
    private def stopJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_stopJMenuItemActionPerformed
        if (this.runnableInterface != null) {
            this.runnableInterface.setRunning(false)
        } else {
            this.noModuleSelectedJDialog.setVisible(true)
            this.noModuleSelectedJDialog.setLocationRelativeTo(this)
        }
    }

    //GEN-LAST:event_stopJMenuItemActionPerformed
    private def startJMenuItemActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_startJMenuItemActionPerformed
        try {
            this.logUtil.putF("Starting", this, "startJMenuItemActionPerformed")
            if (this.inputAutomationModuleInterface != null) {
                this.runnableInterface = this.inputAutomationModuleInterface.getInstance()
                if (this.runnableInterface != null) {
                    this.thread = new Thread(this.runnableInterface)
                    this.thread.setPriority(Thread.MIN_PRIORITY + 1)
                    this.thread.start()
                } else {
                    this.logUtil.putF("Runnnable was null", this, "startJMenuItemActionPerformed")
                    this.noModuleSelectedJDialog.setVisible(true)
                    this.noModuleSelectedJDialog.setLocationRelativeTo(this)
                }
            } else {
                this.logUtil.putF("InputAutomationModuleInterface was null", this, "startJMenuItemActionPerformed")
                this.noModuleSelectedJDialog.setVisible(true)
                this.noModuleSelectedJDialog.setLocationRelativeTo(this)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "startJMenuItemActionPerformed", e)
            }
        }
    }

    def getAutomationModuleConfigurationJPanel() : _root_.javax.swing.JPanel = {
        return this.automationModuleConfigurationJPanel
    }

    def setAutomationModuleConfigurationJPanel(automationModuleConfigurationJPanel : _root_.javax.swing.JPanel) : Unit = {
        this.automationModuleConfigurationJPanel = automationModuleConfigurationJPanel
    }

    def onAdd(inputAutomationRobotChangeEvent : InputAutomationRobotChangeEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onAdd")
            InputRobotFactory.getInstance().add(inputAutomationRobotChangeEvent.getInputAutomationRobotInterfaceWrapper().getInputRobotInterface())
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onAdd", e)
            }
        }
    }

    def onRemove(inputAutomationRobotChangeEvent : InputAutomationRobotChangeEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onRemove")
            InputRobotFactory.getInstance().add(inputAutomationRobotChangeEvent.getInputAutomationRobotInterfaceWrapper().getInputRobotInterface())
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onRemove", e)
            }
        }
    }

    def onAdd(inputAutomationConfigurationChangeEvent : InputAutomationConfigurationModuleChangeEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onAdd")
            this.inputAutomationModuleConfigurations.add(inputAutomationConfigurationChangeEvent.getInputAutomationModuleConfiguration())
            //inputAutomationConfiguration.save();
            this.init()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onAdd", e)
            }
        }
    }

    def onRemove(inputAutomationConfigurationChangeEvent : InputAutomationConfigurationModuleChangeEvent) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "onRemove")
            val inputAutomationConfiguration : InputAutomationConfiguration = InputAutomationConfigurationFactory.getInstance().inputAutomationConfiguration
            val inputAutomationModuleConfigurationList : _root_.java.util.List[InputAutomationModuleConfiguration] = inputAutomationConfiguration.getInputAutomationModuleConfigurationList()
            if (inputAutomationModuleConfigurationList == null) {
                val logUtil : LogUtil = LogUtil.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.putF("inputAutomationModuleConfigurationList: " + inputAutomationModuleConfigurationList, this, commonStrings.INIT)
                throw new Exception()
            }
            val inputAutomationModuleConfigurations : InputAutomationModuleConfigurations = new InputAutomationModuleConfigurations(inputAutomationConfiguration.getInputAutomationModuleConfigurationList())
            inputAutomationModuleConfigurations.remove(inputAutomationConfigurationChangeEvent.getInputAutomationModuleConfiguration())
            //inputAutomationConfiguration.save();
            this.init()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "onRemove", e)
            }
        }
    }

}

object InputAutomationJFrame {
    //GEN-LAST:event_startJMenuItemActionPerformed
    private var INPUTAUTOMATION_JFRAME : InputAutomationJFrame = null

    def getInstance() : InputAutomationJFrame = {
        return InputAutomationJFrame.INPUTAUTOMATION_JFRAME
    }

    def destroy() : Unit = {
        InputAutomationJFrame.INPUTAUTOMATION_JFRAME.setVisible(false)
    }

    def create(inputAutomationBundleActivatorListenerInterface : InputAutomationBundleActivatorListenerInterface) : Unit = {
        LogConfigTypeFactory.getInstance()
        val appUrlGlobals : AppUrlGlobals = new AppUrlGlobals()
        appUrlGlobals.setWebappPath("G:/mnt/bc/mydev/work_automation/automation/run/")
        URLGLOBALS.init(appUrlGlobals)
        WebappClassLoaderInfo.setLoader(appUrlGlobals.getClass().getClassLoader())
        _root_.java.awt.EventQueue.invokeLater(new ARunnable {
                override def run() : Unit = {
                    val logUtil : LogUtil = LogUtil.getInstance()
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    try {
                        logUtil.putF("Running", this, commonStrings.RUN)
                        INPUTAUTOMATION_JFRAME = new InputAutomationJFrame()
                        InputRobotFactory.getInstance().addListener(InputAutomationJFrame.getInstance())
                        if (inputAutomationBundleActivatorListenerInterface != null) {
                            inputAutomationBundleActivatorListenerInterface.registerAsService()
                            inputAutomationBundleActivatorListenerInterface.useServices()
                        }
                        INPUTAUTOMATION_JFRAME.setVisible(true)
                    } catch {
                        case e : Exception => {
                            logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
                        }
                    }
                }

            })
    }

    def main(args : Array[String]) : Unit = {
        InputAutomationJFrame.create(null)
    }

}


