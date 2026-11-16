/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os.android

import _root_.android.content.Context
import _root_.android.os.Build
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class AndroidSystemProperties(param_context : Context) {
    import _root_.org.allbinary.logic.system.os.android.AndroidSystemProperties.{*}

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final String androidId;
    //Constructor
    {
        val context : Context = param_context
    }

    //IMEI
    def getDeviceId() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    def getDeviceSoftwareVersion() : String = {
        return this.commonStrings.DISABLE
    }

    def getLine1Number() : String = {
        return this.commonStrings.DISABLE
    }

    def getNetworkCountryIso() : String = {
        return this.commonStrings.DISABLE
    }

    def getNetworkOperator() : String = {
        return this.commonStrings.DISABLE
    }

    def getNetworkOperatorName() : String = {
        return this.commonStrings.DISABLE
    }

    def getSimCountryIso() : String = {
        return this.commonStrings.DISABLE
    }

    def getSimOperator() : String = {
        return this.commonStrings.DISABLE
    }

    def getSimOperatorName() : String = {
        return this.commonStrings.DISABLE
    }

    def getSimSerialNumber() : String = {
        return this.commonStrings.DISABLE
    }

    def getSubscriberId() : String = {
        return this.commonStrings.DISABLE
    }

    def getVoiceMailAlphaTag() : String = {
        return this.commonStrings.DISABLE
    }

    def getVoiceMailNumber() : String = {
        return this.commonStrings.DISABLE
    }

    def getNetworkType() : Int = {
        return -1
    }

    def getPhoneType() : Int = {
        return -1
    }

    //Build Properties
    def getBoard() : String = {
        return Build.BOARD
    }

    def getBrand() : String = {
        return Build.BRAND
    }

    /*     public String getCpuAbi()     {      return Build.CPU_ABI;     }     */
    def getDevice() : String = {
        return Build.DEVICE
    }

    /*     public String getDisplay()     {      return Build.DISPLAY;     }     */
    def getFingerprint() : String = {
        return Build.FINGERPRINT
    }

    def getHost() : String = {
        return Build.HOST
    }

    def getId() : String = {
        return Build.ID
    }

    def getModel() : String = {
        return Build.MODEL
    }

    def getProduct() : String = {
        return Build.PRODUCT
    }

    def getTags() : String = {
        return Build.TAGS
    }

    def getTime() : Long = {
        return Build.TIME
    }

    def getType() : String = {
        return Build.TYPE
    }

    def getUser() : String = {
        return Build.USER
    }

}

object AndroidSystemProperties {
    //private static AndroidSystemProperties SINGLETON = null;
    private val SINGLETON : AndroidSystemProperties = new AndroidSystemProperties(ResourceUtil.getInstance().getContext())

    //private TelephonyManager telephonyManager;
    def getInstance() : AndroidSystemProperties = {
        return AndroidSystemProperties.SINGLETON
    }

}


