/*  * AllBinary Open License Version 1  * Copyright (c) 2019 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.android

import _root_.java.util.List
import _root_.android.app.ActivityManager
import _root_.android.app.ActivityManager.RunningServiceInfo
import _root_.android.content.ComponentName
import _root_.android.content.Context
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author User  */
class AndroidServicesUtil {
    import _root_.org.allbinary.android.AndroidServicesUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    private val resourceUtil : ResourceUtil = ResourceUtil.getInstance()

    private val SERVICE_LIMIT_MAX : Int = 1000

    private val IS_SERVICE_RUNNING : String = "isServiceRunning"

    //private final String SERVICE_FOUND_RUNNING = "Service found Running: ";
    private val SERVICE_NOT_FOUND_RUNNING : String = "Service not found Running: "

    def isServiceRunning(name : String) : Boolean = {
        val activityManager : ActivityManager = this.resourceUtil.getContext().getSystemService(Context.ACTIVITY_SERVICE).asInstanceOf[ActivityManager]
        val runningServicesList : List[RunningServiceInfo] = activityManager.getRunningServices(this.SERVICE_LIMIT_MAX)
        var runningServiceInfo : RunningServiceInfo = null
        var serviceComponent : ComponentName = null
        var serviceName : String = null
        val size : Int = runningServicesList.size()

        {
            var index : Int = 0
            while (index < size) {
                runningServiceInfo = runningServicesList.get(index)
                serviceComponent = runningServiceInfo.service
                serviceName = serviceComponent.toString()
                //this.logUtil.putF(serviceName, this, IS_SERVICE_RUNNING);
                if (serviceName.indexOf(name) >= 0) {
                    //this.logUtil.putF(SERVICE_FOUND_RUNNING + serviceName, this, IS_SERVICE_RUNNING);
                    return true
                }
                index += 1
            }
        }
        this.logUtil.putF(this.SERVICE_NOT_FOUND_RUNNING + name, this, this.IS_SERVICE_RUNNING)
        return false
    }

}

object AndroidServicesUtil {
    /**      * @return the instance      */
    def getInstance() : AndroidServicesUtil = {
        return AndroidServicesUtil.instance
    }

    private val instance : AndroidServicesUtil = new AndroidServicesUtil()

}


