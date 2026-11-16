/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.osgi

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.NullServiceReferenceFactory
import _root_.org.osgi.framework.ServiceReference
import _root_.org.osgi.framework.ServiceRegistration

class OSGIActivatorUtil private() {
    import _root_.org.allbinary.osgi.OSGIActivatorUtil.{*}

}

object OSGIActivatorUtil {
    def registerAsService(bundleContext : BundleContext, anyType : Object, serviceName : String) : Unit = {
        OSGIActivatorUtil.registerAsService(bundleContext, anyType, serviceName, StdUtil.getInstance().createHashtable())
    }

    def registerAsService(bundleContext : BundleContext, anyType : Object, serviceName : String, properties : ABHashtable[Object, Object]) : Unit = {
        val serviceRegistration : ServiceRegistration = bundleContext.registerService(serviceName, anyType, properties)
        var serviceReference : ServiceReference = serviceRegistration.getReference()
        serviceReference = bundleContext.getServiceReference(serviceName)
        if (serviceReference eq NullServiceReferenceFactory.getInstance().NULL_SERVICE_REFERENCE) {
            throw new Exception("No Such Service Reference")
        }
    }

}


