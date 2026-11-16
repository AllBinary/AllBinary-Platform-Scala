/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.client

import _root_.org.allbinary.logic.string.StringUtil
import _root_.java.io.IOException
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient
import _root_.org.allbinary.logic.java.exception.ExceptionUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.AbeClientLicense
import _root_.org.allbinary.logic.system.security.licensing.AbeLicenseInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.ABHashtable
import _root_.org.apache.xmlrpc.XmlRpcClient
import _root_.org.apache.xmlrpc.XmlRpcException

class XmlRpcAbeLicenseRetrievalClient(param_clientInfo : AbeClientInformationInterface) extends XmlRpcAbeClient(param_clientInfo, "LicServ.getLicense") {

    val logUtil_XmlRpcAbeLicenseRetrievalClient : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val clientInfo : AbeClientInformationInterface = param_clientInfo
    }

    def get(anyType : Object, cryptInterface : CryptInterface) : Object = {
        try {
            // {
            val server : String = getClientInfo().getLicenseServer(this.getServer())
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(TRYING)
            stringBuffer.appendint(this.getServer())
            stringBuffer.append(SEP)
            stringBuffer.append(server)
            this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(CommonLabels.getInstance().START_LABEL + stringBuffer.toString(), this, this.commonStrings.GET)
            // }
            val param : BasicArrayList = new BasicArrayListD()
            val xmlRpcClient : XmlRpcClient = new XmlRpcClient(server)
            this.setClient(xmlRpcClient)
            xmlRpcClient.setBasicAuthentication(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)
            val hashtable : ABHashtable[Object, Object] = this.getClientInfo().toHashtable()
            // {
            this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(CLIENT_INFO + hashtable.toString(), this, this.commonStrings.GET)
            /*              * if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LICENSING)) {              * this.logUtil.putF("Xml-Rpc Client Liscense Request: \n" +              * client.toString(), this,GET); }              */
            param.add(hashtable)
            // KeySpecFactory.DES,
            val result : Object = xmlRpcClient.executeWithCrypt(this.getRemoteMethod(), param, cryptInterface)
            // {
            this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(RESULT + result.toString(), this, this.commonStrings.GET)
            // }
            val resultHashtable : ABHashtable[Object, Object] = result.asInstanceOf[ABHashtable[Object, Object]]
            if (!AbeClientLicense.hasRequiredKeys(resultHashtable)) {
                // {
                this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(INVALID, this, this.commonStrings.GET)
                // }
                return this.tryAnother(anyType)
            }
            val abeLicenseInterface : AbeLicenseInterface = new AbeClientLicense(resultHashtable)
            // {
            this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(this.commonStrings.END + stringBuffer.toString(), this, this.commonStrings.GET)
            // }
            XmlRpcAbeClient.isOnline = true
            return abeLicenseInterface
        } catch {
            case e : IOException => {
                // {
                this.logUtil_XmlRpcAbeLicenseRetrievalClient.put(EXCEPTION_IN_CLIENT, this, this.commonStrings.GET, e)
                // {
                this.logUtil_XmlRpcAbeLicenseRetrievalClient.putF(TRYING_OTHER_SERVERS + ExceptionUtil.getInstance().getStackTrace(e), this, this.commonStrings.GET)
                // }
                if (!e.getMessage().startsWith(HOST_NOT_RESOLVED)) {
                    return this.tryAnother(anyType)
                } else {
                    XmlRpcAbeClient.isOnline = false
                    throw new Exception(HOST_NOT_RESOLVED_MSG)
                }
            }
            case e : XmlRpcException => {
                // {
                this.logUtil_XmlRpcAbeLicenseRetrievalClient.put(SERVER_REPORTED_ERROR, this, this.commonStrings.GET, e)
                // }
                return this.tryAnother(anyType)
            }
            case e : Exception => {
                // {
                this.logUtil_XmlRpcAbeLicenseRetrievalClient.put(UNKNOWN_ERROR, this, this.commonStrings.GET, e)
                // }
                return this.tryAnother(anyType)
            }
        }
        throw new IllegalStateException()
    }

}


