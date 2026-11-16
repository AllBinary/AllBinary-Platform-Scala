/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class OperatingSystemFactory private() {
    import _root_.org.allbinary.logic.system.os.OperatingSystemFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var genericOperatingSystem : GenericOperatingSystem = NoOperatingSystem.NO_OPERATING_SYSTEM

    def getOperatingSystemInstance() : GenericOperatingSystem = this.synchronized {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            //String osVersion = SystemProperties.getVersion();
            val osString : String = new StringMaker().append("OperatingSystem Info: ").append(this.genericOperatingSystem.toString()).toString()
            System.out.println(osString)
            this.logUtil.putF(osString, this, commonStrings.GET_INSTANCE)
        } catch {
            case e : Exception => {
                //{
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
            }
        }
        return this.genericOperatingSystem
    }

}

object OperatingSystemFactory {
    private val instance : OperatingSystemFactory = new OperatingSystemFactory()

    /**      * @return the instance      */
    def getInstance() : OperatingSystemFactory = {
        return OperatingSystemFactory.instance
    }

}


