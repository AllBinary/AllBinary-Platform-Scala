/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.java.util.Enumeration
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

class AbeHttpRequestInfo private () {

    private val NAME : String = "AbeHttpRequestInfo"

    private val abeHttpRequestInfoData : AbeHttpRequestInfoData = AbeHttpRequestInfoData.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private var httpUserAgent : String = null

    private var remoteAddress : String = null

    private var remoteHost : String = null

    private var remoteHostByAddr : String = null

    private var remotePort : String = null

    private var requestedFilePath : String = null

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        var stringUtil : StringUtil = StringUtil.getInstance()
        this.httpUserAgent = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.HTTP_USER_AGENT).asInstanceOf[String])
        this.remoteAddress = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.REMOTE_ADDRESS).asInstanceOf[String])
        this.remoteHost = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.REMOTE_HOST).asInstanceOf[String])
        this.remoteHostByAddr = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.REMOTE_HOST_BY_ADDRESS).asInstanceOf[String])
        this.remotePort = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.REMOTE_PORT).asInstanceOf[String])
        this.requestedFilePath = stringUtil.getNonNull(hashMap.get(this.abeHttpRequestInfoData.REQUEST_FILE_PATH).asInstanceOf[String])
    }

    def this(httpServletRequest : HttpServletRequest) = {
        this()
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.httpUserAgent = stringUtil.EMPTY_STRING
        var enumuration : Enumeration[? <: Object] = httpServletRequest.getHeaderNames().asInstanceOf[Enumeration[? <: Object]]

        {
            while (enumuration.hasMoreElements()) {
                var key : String = enumuration.nextElement().asInstanceOf[String]
                var value : String = httpServletRequest.getHeader(key)
                if (key.indexOf("user") >= 0) {
                    this.httpUserAgent = (("key: " + key) + " value: ") + value
                }
            }
        }
        /*       httpServletRequest.getAuthType()       httpServletRequest.getCharacterEncoding()       httpServletRequest.getContentLength()       httpServletRequest.getContentType()       httpServletRequest.getContextPath();       httpServletRequest.getLocale()       httpServletRequest.getPathInfo()       httpServletRequest.getPathTranslated()       httpServletRequest.getProtocol()       httpServletRequest.getQueryString()       */
        this.remoteHostByAddr = stringUtil.EMPTY_STRING
        this.remoteAddress = httpServletRequest.getRemoteAddr()
        this.remoteHost = httpServletRequest.getRemoteHost()
        /*       httpServletRequest.getRemoteUser()       httpServletRequest.getScheme()       httpServletRequest.getServerName()       httpServletRequest.getServerPort()       */
        this.requestedFilePath = httpServletRequest.getServletPath()
        this.remotePort = Integer.toString(httpServletRequest.getRemotePort())
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(abeHttpRequestInfoData.HTTP_USER_AGENT, this.httpUserAgent)
        hashMap.put(abeHttpRequestInfoData.REMOTE_ADDRESS, this.remoteAddress)
        hashMap.put(abeHttpRequestInfoData.REMOTE_HOST, this.remoteHost)
        hashMap.put(abeHttpRequestInfoData.REMOTE_HOST_BY_ADDRESS, this.remoteHostByAddr)
        hashMap.put(abeHttpRequestInfoData.REMOTE_PORT, this.remotePort)
        hashMap.put(abeHttpRequestInfoData.REQUEST_FILE_PATH, this.requestedFilePath)
        return hashMap
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.httpUserAgent)
        vector.add(this.remoteAddress)
        vector.add(this.remoteHost)
        vector.add(this.remoteHostByAddr)
        vector.add(this.remotePort)
        vector.add(this.requestedFilePath)
        return vector
    }

    override def toString() : String = {
        return new StringMaker().append(this.NAME).append(this.commonSeps.COLON_SEP).append(abeHttpRequestInfoData.HTTP_USER_AGENT).append(this.commonSeps.COLON_SEP).append(this.httpUserAgent).append(this.commonSeps.SPACE).append(abeHttpRequestInfoData.REMOTE_ADDRESS).append(this.commonSeps.COLON_SEP).append(this.remoteAddress).append(this.commonSeps.SPACE).append(abeHttpRequestInfoData.REMOTE_HOST).append(this.commonSeps.COLON_SEP).append(this.remoteHost).append(this.commonSeps.SPACE).append(abeHttpRequestInfoData.REMOTE_HOST_BY_ADDRESS).append(this.commonSeps.COLON_SEP).append(this.remoteHostByAddr).append(this.commonSeps.SPACE).append(abeHttpRequestInfoData.REMOTE_PORT).append(this.commonSeps.COLON_SEP).append(this.remotePort).append(this.commonSeps.SPACE).append(abeHttpRequestInfoData.REQUEST_FILE_PATH).append(this.commonSeps.COLON_SEP).append(this.requestedFilePath).toString()
    }

}


