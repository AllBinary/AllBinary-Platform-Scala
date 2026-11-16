/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.AbContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.AcceptableResponseGenerator
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.StoreAdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.AdminEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.StoreEmailInfo
import _root_.org.allbinary.logic.control.search.SearchParams
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.views.admin.inventory.listings.ProductListingFactory

class StaticPagesRequestHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends AbContext(param_propertiesHashMap, param_pageContext) with TagHelperInterface {

    val logUtil_StaticPagesRequestHelper : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var request : HttpServletRequest = null

    private var storeName : String = null

    private var searchParams : SearchParams = null

    private var xslFile : String = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.xslFile = propertiesHashMap.get(TransformInfoData.getInstance().TEMPLATEFILENAME).asInstanceOf[String]
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.storeName = this.request.getParameter(StoreFrontData.getInstance().NAME)
        this.searchParams = new SearchParams(this.request)
    }

    private def email() : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil_StaticPagesRequestHelper.putF("Generated Static Pages Notification Email", this, "email")
            }
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.storeName)
            var adminEmailSubject : String = "Generated Static Pages Email Notification"
            var adminEmailTextBody : String = "Generated static pages for store: " + this.storeName
            var adminBasicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
            var storeAdminBasicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(storeFrontInterface, adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
            var storeAdminEmailInfo : EmailInfo = new EmailInfo(storeAdminBasicEmailInfo)
            var adminEmailInfo : EmailInfo = new EmailInfo(adminBasicEmailInfo)
            //Send response to Admin(s)
            var adminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.STOREGENERATINGSTATICPAGES)
            var storeAdminUserEmailEventHandler : UserEmailEventHandler = StoreAdminUserEmailEventHandlerSingletons.getInstance().getInstance(UserEmailEventNameData.STOREGENERATINGSTATICPAGES, this.abeClientInformation, storeFrontInterface)
            storeAdminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.STOREGENERATINGSTATICPAGES, storeAdminEmailInfo)
            adminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.STOREGENERATINGSTATICPAGES, adminEmailInfo)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGINGERROR)) {
                    this.logUtil_StaticPagesRequestHelper.put(this.commonStrings.FAILURE, this, "email", e)
                }
            }
        }
    }

    def generateStaticPages() : String = {
        try {
            //this.logUtil.putF(this.commonStrings.START, this, "generateStaticPages()");
            var contentType : String = AcceptableResponseGenerator.getInstance().get(this.request)
            var searchRequest : SearchRequest = new SearchRequest(null, this.searchParams, this.xslFile, contentType, this.getPropertiesHashMap(), this.getPageContext())
            var success : String = ProductListingFactory.getInstance(searchRequest).generateAll(this.storeName)
            this.email()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil_StaticPagesRequestHelper.putF(success, this, "generateStaticPages()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to generate staticpages table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StaticPagesRequestHelper.put(this.commonStrings.EXCEPTION, this, "generateStaticPages()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def makePublic() : String = {
        try {
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.storeName)
            var fromAbPath : AbPath = new AbPath(storeFrontInterface.getTestHtmlPath() + storeFrontInterface.getStaticPath(), StringUtil.getInstance().EMPTY_STRING)
            var toAbPath : AbPath = new AbPath(((URLGLOBALS.getWebappPath() + storeFrontInterface.getName()) + AbPathData.getInstance().SEPARATOR) + storeFrontInterface.getStaticPath(), StringUtil.getInstance().EMPTY_STRING)
            FileUtil.getInstance().copy(fromAbPath, toAbPath)
            var success : String = "Made Public"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil_StaticPagesRequestHelper.putF(success, this, "makePublic()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to makePublic"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_StaticPagesRequestHelper.put(this.commonStrings.EXCEPTION, this, "makePublic()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


