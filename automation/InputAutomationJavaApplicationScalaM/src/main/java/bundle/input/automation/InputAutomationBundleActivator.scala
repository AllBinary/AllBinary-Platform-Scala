/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation

import _root_.org.osgi.framework.BundleActivator
import _root_.org.osgi.framework.BundleContext
import _root_.bundle.input.automation.module.configuration.InputAutomationConfigurationModuleChangeListener
import _root_.bundle.input.automation.robot.InputAutomationRobotChangeListener
import _root_.org.allbinary.input.automation.InputAutomationJFrame
import _root_.org.allbinary.input.automation.module.osgi.InputAutomationModuleServiceConsumer
import _root_.org.allbinary.input.automation.module.osgi.InputAutomationNewBundleRunnable
import _root_.org.allbinary.input.automation.osgi.InputAutomationServiceFactory
import _root_.org.allbinary.input.automation.robot.osgi.InputAutomationRobotServiceConsumer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIActivatorUtil
import _root_.org.allbinary.string.CommonStrings

class InputAutomationBundleActivator extends BundleActivator with InputAutomationBundleActivatorListenerInterface {
    import _root_.bundle.input.automation.InputAutomationBundleActivator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def start(bundleContext : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START)
            _root_.bundle.input.automation.InputAutomationBundleActivator.bundleContext = bundleContext
            /*                 try {                 }                 catch (IOException ioe) {                         //throw new FactoryConfigurationError(ioe);                 }                  */
            InputAutomationBundleActivator.moduleManagementThread = new Thread(new InputAutomationNewBundleRunnable(this))
            InputAutomationBundleActivator.moduleManagementThread.start()
            InputAutomationJFrame.create(this)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.START, e)
                throw e
            }
        }
    }

    def registerAsService() : Unit = {
        OSGIActivatorUtil.registerAsService(_root_.bundle.input.automation.InputAutomationBundleActivator.getBundleContext(), InputAutomationServiceFactory.getInstance(), classOf[InputAutomationConfigurationModuleChangeListener].getName())
        OSGIActivatorUtil.registerAsService(_root_.bundle.input.automation.InputAutomationBundleActivator.getBundleContext(), InputAutomationServiceFactory.getInstance(), classOf[InputAutomationRobotChangeListener].getName())
    }

    def useServices() : Unit = {
        new InputAutomationRobotServiceConsumer(_root_.bundle.input.automation.InputAutomationBundleActivator.getBundleContext()).process()
        new InputAutomationModuleServiceConsumer(_root_.bundle.input.automation.InputAutomationBundleActivator.getBundleContext()).process()
    }

    def stop(context : BundleContext) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "stop")
        if (InputAutomationJFrame.getInstance() != null) {
            InputAutomationJFrame.destroy()
        } else {
            this.logUtil.putF("Nothing to stop", this, "stop")
        }
    }

}

object InputAutomationBundleActivator {
    private var moduleManagementThread : Thread = null

    private var bundleContext : BundleContext = null

    //private ServiceTracker remoteTracker;
    def getBundleContext() : BundleContext = {
        return InputAutomationBundleActivator.bundleContext
    }

}


