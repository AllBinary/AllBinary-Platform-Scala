/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.registration

import _root_.org.allbinary.logic.string.StringUtil
import _root_.java.io.IOException
import _root_.org.apache.xmlrpc.XmlRpcClient
import _root_.org.apache.xmlrpc.XmlRpcException
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient
import _root_.org.allbinary.logic.java.exception.ExceptionUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.util.ABHashtable

class XmlRpcRemoteLicenseRegistrationClient(param_clientInfo : AbeClientInformationInterface) extends XmlRpcAbeClient(param_clientInfo, "LicenseRegistrationServer.process") {

    val logUtil_XmlRpcRemoteLicenseRegistrationClient : LogUtil = LogUtil.getInstance()

    private val PAGE : String = "licenseregistrationserverssl.php"

    //Constructor
    {
        val clientInfo : AbeClientInformationInterface = param_clientInfo
        //Start with the first server
        this.setServer(0)
    }

    def get(anyType : Object, cryptInterface : CryptInterface) : Object = {
        try {
            //System.out.println("Start Trying Server #" + this.getServer() + CommonLabels.getInstance().COLON_SEP + getClientInfo().getLicenseServer(this.getServer()));
            var server : String = getClientInfo().getLicenseServer(this.getServer())
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(TRYING)
            stringBuffer.appendint(this.getServer())
            stringBuffer.append(SEP)
            stringBuffer.append(server)
            this.logUtil_XmlRpcRemoteLicenseRegistrationClient.putF(CommonLabels.getInstance().START_LABEL + stringBuffer.toString(), this, this.commonStrings.GET)
            // }
            var param : BasicArrayList = new BasicArrayListD()
            var serverUrl : String = getClientInfo().getLicenseServer(this.getServer())
            var index : Int = serverUrl.lastIndexOf("/")
            serverUrl = serverUrl.substring(0, index + 1) + this.PAGE
            //System.out.println("Renamed Server: " + serverUrl);
            val xmlRpcClient : XmlRpcClient = new XmlRpcClient(serverUrl)
            this.setClient(xmlRpcClient)
            xmlRpcClient.setBasicAuthentication(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)
            var hashtable : ABHashtable[Object, Object] = anyType.asInstanceOf[ABHashtable[Object, Object]]
            //System.out.println("Client Info: \n" + hashtable.toString());
            this.logUtil_XmlRpcRemoteLicenseRegistrationClient.putF(CLIENT_INFO + hashtable.toString(), this, this.commonStrings.GET)
            /*              * if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LICENSING)) {              * this.logUtil.putF("Xml-Rpc Client Liscense Request: \n" +              * client.toString(), this, GET); }              */
            param.add(hashtable)
            // KeySpecFactory.DES,
            var result : Object = xmlRpcClient.executeWithCrypt(this.getRemoteMethod(), param, cryptInterface)
            //System.out.println(CommonLabels.getInstance().RESULT_ + CommonSeps.getInstance().NEW_LING + result.toString());
            this.logUtil_XmlRpcRemoteLicenseRegistrationClient.putF(RESULT + result.toString(), this, this.commonStrings.GET)
            // }
            XmlRpcAbeClient.isOnline = true
            return result
        } catch {
            case e : IOException => {
                //System.out.println("IOException Trying Other Servers");
                this.logUtil_XmlRpcRemoteLicenseRegistrationClient.putF(TRYING_OTHER_SERVERS + ExceptionUtil.getInstance().getStackTrace(e), this, this.commonStrings.GET)
                // }
                if (!e.getMessage().startsWith(HOST_NOT_RESOLVED)) {
                    return this.tryAnother(anyType)
                } else {
                    throw new Exception(HOST_NOT_RESOLVED_MSG)
                }
            }
            case e : XmlRpcException => {
                //System.out.println(message);
                this.logUtil_XmlRpcRemoteLicenseRegistrationClient.put(SERVER_REPORTED_ERROR, this, this.commonStrings.GET, e)
                // }
                return this.tryAnother(anyType)
            }
            case e : Exception => {
                //System.out.println(message);
                this.logUtil_XmlRpcRemoteLicenseRegistrationClient.put(UNKNOWN_ERROR, this, this.commonStrings.GET, e)
                // }
                return this.tryAnother(anyType)
            }
        }
        throw new IllegalStateException()
    }

}


