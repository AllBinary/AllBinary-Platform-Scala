/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.admin.configuration

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.configuration.ContextConfiguration
import _root_.org.allbinary.business.context.configuration.ContextConfigurationData
import _root_.org.allbinary.business.context.configuration.ContextConfigurationDomDocumentMapping
import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterface
import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterfaceFactory
import _root_.org.allbinary.business.context.configuration.ContextConfigurationPathUtil
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileWriter
import _root_.org.allbinary.string.CommonStrings

class AdminConfiguration() extends AdminConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var contextConfigurationInterface : ContextConfigurationInterface = null

    //Constructor
    {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.contextConfigurationInterface = ContextConfigurationInterfaceFactory.getInstance().getInstance(AdminConfigurationData.CONTEXTNAME)
    }

    def this(request : HttpServletRequest) = {
        this()
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.getFormData(new RequestParams(request).toHashMap())
    }

    def this(storeHashMap : HashMap[Object, Object]) = {
        this()
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.getFormData(storeHashMap)
    }

    private def getFormData(storeHashMap : HashMap[Object, Object]) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "getFormData")
        this.setContextConfigurationInterface((new ContextConfiguration(storeHashMap)).asInstanceOf[ContextConfigurationInterface])
    }

    def write() : Unit = this.synchronized {
        var contextConfigurationDomDocumentMapping : ContextConfigurationDomDocumentMapping = new ContextConfigurationDomDocumentMapping(this.getContextConfigurationInterface())
        var cryptFileWriter : CryptFileWriter = new CryptFileWriter(ContextConfigurationData.getInstance().UNCRYPTED_EXTENSION, ContextConfigurationData.getInstance().ENCRYPTED_EXTENSION)
        cryptFileWriter.write(ContextConfigurationPathUtil.getAbPath(AdminConfigurationData.CONTEXTNAME), contextConfigurationDomDocumentMapping.toXmlDoc())
    }

    def getContextConfigurationInterface() : ContextConfigurationInterface = {
        return this.contextConfigurationInterface
    }

    def setContextConfigurationInterface(contextConfigurationInterface : ContextConfigurationInterface) : Unit = {
        this.contextConfigurationInterface = contextConfigurationInterface
    }

}


