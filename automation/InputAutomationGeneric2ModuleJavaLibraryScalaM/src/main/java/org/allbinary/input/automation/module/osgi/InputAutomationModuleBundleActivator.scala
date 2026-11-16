/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.osgi

import _root_.org.osgi.framework.BundleActivator
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.ServiceFactory
import _root_.org.osgi.framework.ServiceReference
import _root_.bundle.input.automation.module.InputAutomationModuleServiceInterface
import _root_.bundle.input.automation.module.configuration.InputAutomationConfigurationModuleChangeListener
import _root_.org.allbinary.input.automation.configuration.InputAutomationConfigurationModuleChangeEvent
import _root_.org.allbinary.input.automation.configuration.InputAutomationConfigurationUtil
import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIActivatorUtil
import _root_.org.allbinary.string.CommonStrings

class InputAutomationModuleBundleActivator() extends BundleActivator {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var inputAutomationModuleInterface : Array[InputAutomationModuleFactoryInterface] = null

    private var serviceFactory : ServiceFactory = null

    //Constructor
    {
        this.init()
    }

    def init() : Unit = {
        throw new RuntimeException()
    }

    private def getInputAutomationConfigurationModuleChangeListener(context : BundleContext) : InputAutomationConfigurationModuleChangeListener = {
        var serviceReference : ServiceReference = context.getServiceReference(classOf[InputAutomationConfigurationModuleChangeListener].getName())
        if (serviceReference != null) {
            var inputAutomationConfigurationModuleChangeListener : InputAutomationConfigurationModuleChangeListener = context.getService(serviceReference).asInstanceOf[InputAutomationConfigurationModuleChangeListener]
            if (inputAutomationConfigurationModuleChangeListener == null) {
                throw new Exception("No Service For ServiceReference")
            }
            return inputAutomationConfigurationModuleChangeListener
        } else {
            this.logUtil.putF("No ServiceReference: " + classOf[InputAutomationConfigurationModuleChangeListener].getName(), this, "addModules")
            return null
        }
        throw new IllegalStateException()
    }

    private def addModules(context : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "addModules")
            var inputAutomationConfigurationModuleChangeListener : InputAutomationConfigurationModuleChangeListener = this.getInputAutomationConfigurationModuleChangeListener(context)
            if (inputAutomationConfigurationModuleChangeListener != null) {

                {
                    var index : Int = 0
                    while (index < this.getInputAutomationModuleInterface().length) {
                        var inputAutomationConfigurationModuleChangeEvent : InputAutomationConfigurationModuleChangeEvent = InputAutomationConfigurationUtil.getChangeEvent(this.getInputAutomationModuleInterface()(index))
                        inputAutomationConfigurationModuleChangeListener.onAdd(inputAutomationConfigurationModuleChangeEvent)
                        index += 1
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION, this, "addModules")
            }
        }
    }

    def registerAsService(bundleContext : BundleContext) : Unit = {
        OSGIActivatorUtil.registerAsService(bundleContext, getServiceFactory(), classOf[InputAutomationModuleServiceInterface].getName())
    }

    private def removeModules(context : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "removeModules")
            var inputAutomationConfigurationModuleChangeListener : InputAutomationConfigurationModuleChangeListener = this.getInputAutomationConfigurationModuleChangeListener(context)
            if (inputAutomationConfigurationModuleChangeListener != null) {

                {
                    var index : Int = 0
                    while (index < this.getInputAutomationModuleInterface().length) {
                        var inputAutomationConfigurationModuleChangeEvent : InputAutomationConfigurationModuleChangeEvent = InputAutomationConfigurationUtil.getChangeEvent(this.getInputAutomationModuleInterface()(index))
                        inputAutomationConfigurationModuleChangeListener.onRemove(inputAutomationConfigurationModuleChangeEvent)
                        index += 1
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION, this, "removeModules")
            }
        }
    }

    def start(context : BundleContext) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START)
        this.addModules(context)
        this.registerAsService(context)
    }

    def stop(context : BundleContext) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "stop")
        this.removeModules(context)
    }

    def getInputAutomationModuleInterface() : Array[InputAutomationModuleFactoryInterface] = {
        return this.inputAutomationModuleInterface
    }

    def setInputAutomationModuleInterface(inputAutomationModuleInterface : Array[InputAutomationModuleFactoryInterface]) : Unit = {
        this.inputAutomationModuleInterface = inputAutomationModuleInterface
    }

    def getServiceFactory() : Object = {
        return this.serviceFactory
    }

    def setServiceFactory(serviceObject : ServiceFactory) : Unit = {
        this.serviceFactory = serviceObject
    }

}


