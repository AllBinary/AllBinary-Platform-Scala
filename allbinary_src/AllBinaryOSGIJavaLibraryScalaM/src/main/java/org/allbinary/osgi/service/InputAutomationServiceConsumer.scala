/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.osgi.service

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.ServiceReference
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIServiceInterface
import _root_.org.allbinary.osgi.OSGIServiceVisitorInterface
import _root_.org.allbinary.string.CommonStrings

class InputAutomationServiceConsumer(param_registryName : String, param_bundleContext : BundleContext, param_osgiServiceVisitorInterface : OSGIServiceVisitorInterface) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val osgiServiceUtil : OSGIServiceUtil = OSGIServiceUtil.getInstance()

    private var registryName : String = null

    private var bundleContext : BundleContext = null

    private var osgiServiceVisitorInterface : OSGIServiceVisitorInterface = null

    //Constructor
    {
        val registryName : String = param_registryName
        val bundleContext : BundleContext = param_bundleContext
        val osgiServiceVisitorInterface : OSGIServiceVisitorInterface = param_osgiServiceVisitorInterface
        this.setRegistryName(registryName)
        this.setBundleContext(bundleContext)
        this.setOsgiServiceVisitorInterface(osgiServiceVisitorInterface)
    }

    def process() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS)
        val vector : BasicArrayList = this.osgiServiceUtil.getServicesObjectVector(this.getBundleContext(), this.getServiceReferences())
        this.logUtil.putF(("Processing " + vector.size()) + " Services", this, this.commonStrings.PROCESS)
        val size : Int = vector.size()
        var osgiServiceInterface : OSGIServiceInterface = null

        {
            var index : Int = 0
            while (index < size) {
                osgiServiceInterface = vector.get(index).asInstanceOf[OSGIServiceInterface]
                if (!getOsgiServiceVisitorInterface().visit(osgiServiceInterface)) {
                    throw new Exception("Unable to process service: " + osgiServiceInterface)
                }
                index += 1
            }
        }
    }

    private def getServiceReferences() : Array[ServiceReference] = {
        return this.getBundleContext().getServiceReferences(this.getRegistryName(), null)
    }

    def getBundleContext() : BundleContext = {
        return this.bundleContext
    }

    def setBundleContext(aBundleContext : BundleContext) : Unit = {
        this.bundleContext = aBundleContext
    }

    def getRegistryName() : String = {
        return this.registryName
    }

    def setRegistryName(registryName : String) : Unit = {
        this.registryName = registryName
    }

    def getOsgiServiceVisitorInterface() : OSGIServiceVisitorInterface = {
        return this.osgiServiceVisitorInterface
    }

    def setOsgiServiceVisitorInterface(osgiServiceVisitorInterface : OSGIServiceVisitorInterface) : Unit = {
        this.osgiServiceVisitorInterface = osgiServiceVisitorInterface
    }

}


