/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.bundle.logic.preloader

import _root_.org.osgi.framework.BundleActivator
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.ServiceReference
import _root_.org.osgi.framework.ServiceRegistration
import _root_.org.allbinary.bundle.logic.system.loader.CryptServiceFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class AllBinaryPreloaderActivator() extends BundleActivator {
    import _root_.org.allbinary.bundle.logic.preloader.AllBinaryPreloaderActivator.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def start(context : BundleContext) : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, "start")
            AllBinaryPreloaderActivator.context = context
            this.registerAsService()
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "start", e)
                throw e
            }
        }
    }

    def registerAsService() : Unit = {
        val properties : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        val serviceRegistration : ServiceRegistration = AllBinaryPreloaderActivator.context.registerService(CRYPT_REGISTRY_NAME, new CryptServiceFactory(), properties)
        var serviceReference : ServiceReference = serviceRegistration.getReference()
        serviceReference = AllBinaryPreloaderActivator.context.getServiceReference(CRYPT_REGISTRY_NAME)
        if (serviceReference == null) {
            throw new Exception("No Such Service Reference")
        }
    }

    def stop(context : BundleContext) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "stop")
    }

}

object AllBinaryPreloaderActivator {
    private var context : BundleContext = null

    private val CRYPT_REGISTRY_NAME : String = "bundle.abcs.logic.system.loader.CryptService"

    def getBundleContext() : BundleContext = {
        return AllBinaryPreloaderActivator.context
    }

}


