/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.osgi.service

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.ServiceReference
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.osgi.OSGIServiceInterface

class OSGIServiceUtil private() {
    import _root_.org.allbinary.osgi.service.OSGIServiceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getServicesObjectVector(bundleContext : BundleContext, serviceReferences : Array[ServiceReference]) : BasicArrayList = {
        val vector : BasicArrayList = new BasicArrayListD()
        if (serviceReferences != null) {
            val size : Int = serviceReferences.length
            this.logUtil.putF("Service References: " + size, this, "getServicesObjectVector")

            {
                var index : Int = 0
                while (index < size) {
                    var serviceReference : ServiceReference = serviceReferences(index)
                    //this.logUtil.putF("Service Reference Properties: " + stringBuffer.toString(), this, "getInputAutomationModuleServices");
                    if (serviceReference != null) {
                        val osgiServiceInterface : OSGIServiceInterface = bundleContext.getService(serviceReference).asInstanceOf[OSGIServiceInterface]
                        if (osgiServiceInterface == null) {
                            throw new Exception("No Service For Reference")
                        }
                        vector.add(osgiServiceInterface)
                    }
                    index += 1
                }
            }
        }
        return vector
    }

}

object OSGIServiceUtil {
    private val instance : OSGIServiceUtil = new OSGIServiceUtil()

    /**      * @return the instance      */
    def getInstance() : OSGIServiceUtil = {
        return OSGIServiceUtil.instance
    }

}


