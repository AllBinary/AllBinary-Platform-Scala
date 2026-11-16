/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.org.allbinary.logic.string.StringUtil
import _root_.java.io.IOException
import _root_.org.apache.xmlrpc.XmlRpcClient
import _root_.org.apache.xmlrpc.XmlRpcException
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient
import _root_.org.allbinary.logic.system.security.crypt.jcehelper.NoCrypt
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.ABHashtable

class XmlRpcRemoteLogClient(param_clientInfo : AbeClientInformationInterface) extends XmlRpcAbeClient(param_clientInfo, "SSLLogServ.logUtil") {

    //private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();
    private val noCrypt : NoCrypt = new NoCrypt()

    //Constructor
    {
        val clientInfo : AbeClientInformationInterface = param_clientInfo
    }

    override def get(anyType : Object) : Object = {
        try {
            // }
            var param : BasicArrayList = new BasicArrayListD()
            var serverUrl : String = getClientInfo().getLicenseServer(this.getServer())
            var index : Int = serverUrl.lastIndexOf("/")
            serverUrl = serverUrl.substring(0, index + 1) + "logservssl.php"
            //System.out.println("Renamed Server: " + serverUrl);
            val xmlRpcClient : XmlRpcClient = new XmlRpcClient(serverUrl)
            this.setClient(xmlRpcClient)
            xmlRpcClient.setBasicAuthentication(StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING)
            var hashtable : ABHashtable[Object, Object] = anyType.asInstanceOf[ABHashtable[Object, Object]]
            /*              * if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LICENSING)) {              this.logUtil.putF("Xml-Rpc Client Liscense Request: \n" +              * client.toString(), this, this.commonStrings.GET); }              */
            param.add(hashtable)
            // KeySpecFactory.DES,
            var result : Object = xmlRpcClient.executeWithCrypt(this.getRemoteMethod(), param, this.noCrypt)
            // {
            System.out.println((CommonLabels.getInstance().RESULT_ + CommonSeps.getInstance().NEW_LINE) + result.toString())
            // }
            return result
        } catch {
            case e : IOException => {
                // {
                System.out.println("IOException Trying Other Servers")
                // }
                if (!e.getMessage().startsWith(HOST_NOT_RESOLVED)) {
                    return this.tryAnother(anyType)
                } else {
                    throw new Exception(HOST_NOT_RESOLVED_MSG)
                }
            }
            case e : XmlRpcException => {
                // }
                return this.tryAnother(anyType)
            }
            case e : Exception => {
                // }
                return this.tryAnother(anyType)
            }
        }
        throw new IllegalStateException()
    }

}


