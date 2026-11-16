/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config.`type`

import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class LogConfigTypeFactory private() {
    import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.{*}

    private val NO_DESCRIPTION : String = "No Description"

    //The Following Strings contain all of the logging levels
    val AUTHENTICATION : LogConfigType = new LogConfigType("Authentication", this.NO_DESCRIPTION)

    val AUTHENTICATIONERROR : LogConfigType = new LogConfigType("Authentication Error", this.NO_DESCRIPTION)

    val CATEGORY : LogConfigType = new LogConfigType("Category", this.NO_DESCRIPTION)

    val CATEGORYERROR : LogConfigType = new LogConfigType("Category Error", this.NO_DESCRIPTION)

    val CRYPT : LogConfigType = new LogConfigType("Crypt", this.NO_DESCRIPTION)

    val CRYPTERROR : LogConfigType = new LogConfigType("Crypt Error", this.NO_DESCRIPTION)

    val EMAILLOGGING : LogConfigType = new LogConfigType("Email", this.NO_DESCRIPTION)

    //org.allbinary.business.context.configuration.ContextConfiguration
    val EMAILLOGGINGERROR : LogConfigType = new LogConfigType("Email Error", this.NO_DESCRIPTION)

    val ENTITYFACTORYERROR : LogConfigType = new LogConfigType("Entity Factory Error", this.NO_DESCRIPTION)

    //org.allbinary.data.tables.licensing.server.request.LicenseServerRequestEntityFactory
    val NETBEANS_MODULE : LogConfigType = new LogConfigType("NetBeans Module", this.NO_DESCRIPTION)

    val NETBEANS_MODULE_ERROR : LogConfigType = new LogConfigType("NetBeans Module Error", this.NO_DESCRIPTION)

    val FACTORYERROR : LogConfigType = new LogConfigType("General Factory Error", this.NO_DESCRIPTION)

    val FILE : LogConfigType = new LogConfigType("File", this.NO_DESCRIPTION)

    val FILEERROR : LogConfigType = new LogConfigType("File Error", this.NO_DESCRIPTION)

    val HTTP : LogConfigType = new LogConfigType("HTTP", this.NO_DESCRIPTION)

    val HTTPERROR : LogConfigType = new LogConfigType("HTTP Error", this.NO_DESCRIPTION)

    val HTTPREQUEST : LogConfigType = new LogConfigType("Http Request", this.NO_DESCRIPTION)

    //org.allbinary.logic.communication.http.request
    val HTTPREQUESTERROR : LogConfigType = new LogConfigType("Http Request Error", this.NO_DESCRIPTION)

    val IDLOGGING : LogConfigType = new LogConfigType("ID Logging", this.NO_DESCRIPTION)

    val JSPEXTRAOUTPUT : LogConfigType = new LogConfigType("JSP Extra Output", this.NO_DESCRIPTION)

    val JSPTAGEXTRAOUTPUT : LogConfigType = new LogConfigType("JSP Tag Extra Output", this.NO_DESCRIPTION)

    val JSPTAG : LogConfigType = new LogConfigType("JSP Tag", this.NO_DESCRIPTION)

    val JSPTAGERROR : LogConfigType = new LogConfigType("JSP Tag Error", this.NO_DESCRIPTION)

    val LICENSING : LogConfigType = new LogConfigType("Licensing", this.NO_DESCRIPTION)

    val LICENSINGERROR : LogConfigType = new LogConfigType("Licensing Error", this.NO_DESCRIPTION)

    //org.allbinary.logic.system.security.licensing.server.AbeLicenseServerXmlRpcHandler
    val LOADER : LogConfigType = new LogConfigType("Loader", this.NO_DESCRIPTION)

    val LOADERERROR : LogConfigType = new LogConfigType("Loader Error", this.NO_DESCRIPTION)

    val OS : LogConfigType = new LogConfigType("OS", this.NO_DESCRIPTION)

    val OSERROR : LogConfigType = new LogConfigType("OS Error", this.NO_DESCRIPTION)

    val PAYMENT : LogConfigType = new LogConfigType("Payment", this.NO_DESCRIPTION)

    //   org.allbinary.business.user.commerce.money.payment.gateway.transaction.TransactionResult
    val PAYMENTERROR : LogConfigType = new LogConfigType("Payment Error", this.NO_DESCRIPTION)

    val PRELOADER : LogConfigType = new LogConfigType("PreLoader", this.NO_DESCRIPTION)

    val PRELOADERERROR : LogConfigType = new LogConfigType("PreLoader Error", this.NO_DESCRIPTION)

    val PRODUCTSEARCHLOGGING : LogConfigType = new LogConfigType("Product Search Logging", this.NO_DESCRIPTION)

    val PRODUCTSEARCHLOGGINGERROR : LogConfigType = new LogConfigType("Product Search Logging Error", this.NO_DESCRIPTION)

    val SERVLET : LogConfigType = new LogConfigType("Servlet", this.NO_DESCRIPTION)

    val SERVLETERROR : LogConfigType = new LogConfigType("Servlet Error", this.NO_DESCRIPTION)

    val SHIPPINGERROR : LogConfigType = new LogConfigType("Shipping Error", this.NO_DESCRIPTION)

    val SQLLOGGINGERROR : LogConfigType = new LogConfigType("SQL Error", this.NO_DESCRIPTION)

    val SQLLOGGING : LogConfigType = new LogConfigType("SQL Logging", this.NO_DESCRIPTION)

    //org.allbinary.data.tables.licensing.server.request.LicenseServerRequestEntity
    val SQLTAGS : LogConfigType = new LogConfigType("SQL Tag Logging", this.NO_DESCRIPTION)

    val SQLTAGSERROR : LogConfigType = new LogConfigType("SQL Tag Error", this.NO_DESCRIPTION)

    val STYLE : LogConfigType = new LogConfigType("Style", this.NO_DESCRIPTION)

    val STYLEERROR : LogConfigType = new LogConfigType("Style Error", this.NO_DESCRIPTION)

    val TAGHELPER : LogConfigType = new LogConfigType("Tag Helper", this.NO_DESCRIPTION)

    val TAGHELPERERROR : LogConfigType = new LogConfigType("Tag Helper Error", this.NO_DESCRIPTION)

    val TAGHELPERFACTORY : LogConfigType = new LogConfigType("Tag Helper Factory", this.NO_DESCRIPTION)

    val TAGHELPERFACTORYERROR : LogConfigType = new LogConfigType("Tag Helper Factory Error", this.NO_DESCRIPTION)

    val TAX : LogConfigType = new LogConfigType("Tax", this.NO_DESCRIPTION)

    val TAXERROR : LogConfigType = new LogConfigType("Tax Error", this.NO_DESCRIPTION)

    val VALIDATION : LogConfigType = new LogConfigType("Validation", this.NO_DESCRIPTION)

    val VALIDATIONERROR : LogConfigType = new LogConfigType("Validation Error", this.NO_DESCRIPTION)

    val VIEW : LogConfigType = new LogConfigType("View", this.NO_DESCRIPTION)

    val VIEWERROR : LogConfigType = new LogConfigType("View Error", this.NO_DESCRIPTION)

    val VIEWFACTORYERROR : LogConfigType = new LogConfigType("View Factory Error", this.NO_DESCRIPTION)

    val WORKFLOW : LogConfigType = new LogConfigType("Workflow", this.NO_DESCRIPTION)

    val WORKFLOWERROR : LogConfigType = new LogConfigType("Workflow Error", this.NO_DESCRIPTION)

    val XMLLOGGING : LogConfigType = new LogConfigType("XML Logging", this.NO_DESCRIPTION)

    val XMLLOGGINGERROR : LogConfigType = new LogConfigType("XML Logging Error", this.NO_DESCRIPTION)

    val XSLLOGGING : LogConfigType = new LogConfigType("XSL Logging", this.NO_DESCRIPTION)

    val XSLLOGGINGERROR : LogConfigType = new LogConfigType("XSL Logging Error", this.NO_DESCRIPTION)

    //The Following Strings contain all of the logging levels
    val REPLACE : LogConfigType = new LogConfigType("Replace", this.NO_DESCRIPTION)

    val REPLACE_INFO : LogConfigType = new LogConfigType("Replace Info", this.NO_DESCRIPTION)

    val REPLACEERROR : LogConfigType = new LogConfigType("Replace Error", this.NO_DESCRIPTION)

    val SQLLOGGINGPOOL : LogConfigType = new LogConfigType("SQL Pool", this.NO_DESCRIPTION)

    val SQLLOGGINGPOOLERROR : LogConfigType = new LogConfigType("SQL Pool Error", this.NO_DESCRIPTION)

    val STATICPAGEGENERATIONLOGGING : LogConfigType = new LogConfigType("Static Page Generation Logging", this.NO_DESCRIPTION)

    val STATICPAGEGENERATIONLOGGINGERROR : LogConfigType = new LogConfigType("Static Page Generation Logging Error", this.NO_DESCRIPTION)

    //Constructor
    {
        PreLogUtil.put("FreeBlisket", this, CommonStrings.getInstance().CONSTRUCTOR)
    }

}

object LogConfigTypeFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : LogConfigTypeFactory = new LogConfigTypeFactory()

    /**      * @return the instance      */
    def getInstance() : LogConfigTypeFactory = {
        return LogConfigTypeFactory.instance
    }

}


