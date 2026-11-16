/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot.osgi

import _root_.org.osgi.framework.BundleActivator
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.ServiceFactory
import _root_.org.osgi.framework.ServiceReference
import _root_.bundle.input.automation.robot.InputAutomationRobotChangeListener
import _root_.bundle.input.automation.robot.InputAutomationRobotServiceInterface
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIActivatorUtil
import _root_.org.allbinary.string.CommonStrings

class InputAutomationRobotBundleActivator() extends BundleActivator {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var inputRobotInterface : Array[InputRobotInterface] = null

    private var serviceFactory : ServiceFactory = null

    //Constructor
    {
        this.init()
    }

    def init() : Unit = {
        throw new RuntimeException()
    }

    def registerAsService(bundleContext : BundleContext) : Unit = {
        OSGIActivatorUtil.registerAsService(bundleContext, getServiceFactory(), classOf[InputAutomationRobotServiceInterface].getName())
    }

    private def getInputAutomationRobotChangeListener(context : BundleContext) : InputAutomationRobotChangeListener = {
        var serviceReference : ServiceReference = context.getServiceReference(classOf[InputAutomationRobotChangeListener].getName())
        if (serviceReference != null) {
            var inputAutomationRobotChangeListener : InputAutomationRobotChangeListener = context.getService(serviceReference).asInstanceOf[InputAutomationRobotChangeListener]
            if (inputAutomationRobotChangeListener == null) {
                throw new Exception("No Service For ServiceReference")
            }
            return inputAutomationRobotChangeListener
        } else {
            this.logUtil.putF("No ServiceReference: " + classOf[InputAutomationRobotChangeListener].getName(), this, "getInputAutomationRobotChangeListener")
            return null
        }
        throw new IllegalStateException()
    }

    private def addRobots(context : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "addRobots")
            var inputAutomationRobotChangeListener : InputAutomationRobotChangeListener = this.getInputAutomationRobotChangeListener(context)
            if (inputAutomationRobotChangeListener != null) {

                {
                    var index : Int = 0
                    while (index < this.getInputRobotInterface().length) {
                        var inputAutomationRobotChangeEvent : InputAutomationRobotChangeEvent = InputAutomationRobotUtil.getChangeEvent(this.getInputRobotInterface()(index))
                        inputAutomationRobotChangeListener.onAdd(inputAutomationRobotChangeEvent)
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

    private def removeRobots(context : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "removeRobots")
            var inputAutomationRobotChangeListener : InputAutomationRobotChangeListener = this.getInputAutomationRobotChangeListener(context)
            if (inputAutomationRobotChangeListener != null) {

                {
                    var index : Int = 0
                    while (index < this.getInputRobotInterface().length) {
                        var inputAutomationRobotChangeEvent : InputAutomationRobotChangeEvent = InputAutomationRobotUtil.getChangeEvent(this.getInputRobotInterface()(index))
                        inputAutomationRobotChangeListener.onRemove(inputAutomationRobotChangeEvent)
                        index += 1
                    }
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION, this, "removeRobots")
            }
        }
    }

    def start(context : BundleContext) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.START)
        //added twice but that will not cause failure.
        this.addRobots(context)
        this.registerAsService(context)
    }

    def stop(context : BundleContext) : Unit = {
        this.logUtil.putF("Stop", this, this.commonStrings.START)
        this.removeRobots(context)
    }

    def getServiceFactory() : Object = {
        return this.serviceFactory
    }

    def setServiceFactory(serviceObject : ServiceFactory) : Unit = {
        this.serviceFactory = serviceObject
    }

    def getInputRobotInterface() : Array[InputRobotInterface] = {
        return this.inputRobotInterface
    }

    def setInputRobotInterface(inputRobotInterface : Array[InputRobotInterface]) : Unit = {
        this.inputRobotInterface = inputRobotInterface
    }

}


