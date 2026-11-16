/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.xmlrpc

import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.xmlrpc.NullXmlRpcHandler
import _root_.org.apache.xmlrpc.XmlRpcClient
import _root_.org.apache.xmlrpc.XmlRpcHandler

class XmlRpcAbeClient(param_clientInfo : AbeClientInformationInterface, param_remoteMethod : String) {
    import _root_.org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var remoteMethod : String = null

    private var clientInfo : AbeClientInformationInterface = null

    private var client : XmlRpcHandler = NullXmlRpcHandler.NULL_XML_RPC_HANDLER

    private var server : Int = 0

    private var start : Int = 0

    private var maxServers : Int = 0

    private var isDone : Boolean = false

    private val START_SERVER : String = "Start With Server #"

    val TRYING : String = "Trying Server #"

    val SEP : String = CommonLabels.getInstance().COLON_SEP

    val CLIENT_INFO : String = "Client Info: \n"

    val RESULT : String = CommonLabels.getInstance().RESULT_ + CommonSeps.getInstance().NEW_LINE

    val INVALID : String = "License data is Invalid Trying Other Servers"

    val EXCEPTION_IN_CLIENT : String = "Exception in client"

    val SERVER_REPORTED_ERROR : String = "Server reported error"

    val UNKNOWN_ERROR : String = "Unknown License Retrieval Failure"

    val TRYING_OTHER_SERVERS : String = "IOException Trying Other Servers"

    val HOST_NOT_RESOLVED_MSG : String = "Not Trying Again Since Host Unresolved"

    val HOST_NOT_RESOLVED : String = "Host is unresolved"

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    //Constructor
    {
        val clientInfo : AbeClientInformationInterface = param_clientInfo
        val remoteMethod : String = param_remoteMethod
        this.remoteMethod = remoteMethod
        this.clientInfo = clientInfo
        if (clientInfo.getNumberOfLicenseServers() > 1) {
            // Now the first server is a backup license server
            this.maxServers = clientInfo.getNumberOfLicenseServers() - 2
            this.start = this.myRandomFactory.getAbsoluteNextInt(this.maxServers) + 1
        } else if (clientInfo.getNumberOfLicenseServers() == 1) {
            this.maxServers = 0
            this.start = 0
        }
        this.isDone = false
        this.server = this.start
        // {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.START_SERVER)
        stringBuffer.appendint(this.getServer())
        stringBuffer.append(this.SEP)
        stringBuffer.append(clientInfo.getLicenseServer(this.getServer()))
        this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.CONSTRUCTOR)
    }

    def get(anyType : Object) : Object = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
        return NullUtil.getInstance().NULL_OBJECT
    }

    def tryAnother(anyType : Object) : Object = {
        if (getServer() < getMaxServers()) {
            this.setServer(getServer() + 1)
        } else {
            this.setServer(0)
        }
        if ((getServer() != getStart()) && !isIsDone()) {
            return this.get(anyType)
        } else {
            this.setIsDone(true)
        }
        throw new Exception("Tried All Servers But Still Failed")
    }

    /**      * @return the clientInfo      */
    def getClientInfo() : AbeClientInformationInterface = {
        return this.clientInfo
    }

    /**      * @return the client      */
    def getClient() : XmlRpcHandler = {
        return this.client
    }

    /**      * @param client      *            the client to set      */
    def setClient(client : XmlRpcClient) : Unit = {
        this.client = client
    }

    /**      * @return the server      */
    def getServer() : Int = {
        return this.server
    }

    /**      * @param server      *            the server to set      */
    def setServer(server : Int) : Unit = {
        this.server = server
    }

    /**      * @return the start      */
    def getStart() : Int = {
        return this.start
    }

    /**      * @param start      *            the start to set      */
    def setStart(start : Int) : Unit = {
        this.start = start
    }

    /**      * @return the maxServers      */
    def getMaxServers() : Int = {
        return this.maxServers
    }

    /**      * @param maxServers      *            the maxServers to set      */
    def setMaxServers(maxServers : Int) : Unit = {
        this.maxServers = maxServers
    }

    /**      * @return the isDone      */
    def isIsDone() : Boolean = {
        return this.isDone
    }

    /**      * @param isDone      *            the isDone to set      */
    def setIsDone(isDone : Boolean) : Unit = {
        this.isDone = isDone
    }

    def getRemoteMethod() : String = {
        return this.remoteMethod
    }

}

object XmlRpcAbeClient {
    var isOnline : Boolean = true

}


