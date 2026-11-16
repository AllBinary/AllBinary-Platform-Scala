/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFront
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.installer.Portion
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.StoreAdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.AdminEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.StoreEmailInfo
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class StoreFrontsRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var pageContext : PageContext = null

    private var request : HttpServletRequest = null

    //private StoreFrontInterface storeFrontInterface;
    private var weblisketSession : WeblisketSession = null

    private var storeName : String = null

    private var modifyingStoreFrontInterface : StoreFrontInterface = null

    private var portion : Portion = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.pageContext = pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.portion = new Portion(hashMap)
        this.getFormData()
    }

    private def getFormData() : Unit = {
        //if(this.storeName==null)
        this.storeName = this.weblisketSession.getStoreName()
        this.modifyingStoreFrontInterface = (new StoreFront(this.request)).asInstanceOf[StoreFrontInterface]
    }

    override def update() : String = {
        try {
            var success : String = "Updated Successfully"
            var hashMapData : HashMap[Object, Object] = this.modifyingStoreFrontInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
            StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().update(hashMapData)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update storefronts table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def sendStoreCreatedEmails() : Unit = {
        var storeManagerEmailSubject : String = "Store Manager Nofification For Store: " + this.modifyingStoreFrontInterface.getName()
        var adminEmailSubject : String = "Admin Notification For Store: " + this.modifyingStoreFrontInterface.getName()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Store Created: ")
        stringBuffer.append(this.modifyingStoreFrontInterface.getName())
        stringBuffer.append("\n\n")
        stringBuffer.append("Click here for the Admin Interface:\n")
        stringBuffer.append(this.modifyingStoreFrontInterface.getCurrentHomeHostName())
        stringBuffer.append("/admin/login.jsp\n\n")
        stringBuffer.append("Goto Your Store:\n")
        stringBuffer.append(this.modifyingStoreFrontInterface.getCurrentHomeHostName())
        stringBuffer.append(this.modifyingStoreFrontInterface.getName())
        stringBuffer.append("/index.jsp")
        stringBuffer.append("\n\n")
        stringBuffer.append("UserName: ")
        stringBuffer.append(this.weblisketSession.getUserName())
        var adminEmailTextBody : String = stringBuffer.toString()
        var adminBasicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
        var storeAdminBasicEmailInfo : BasicEmailInfo = (new StoreEmailInfo(this.modifyingStoreFrontInterface, storeManagerEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
        var storeAdminEmailInfo : EmailInfo = new EmailInfo(storeAdminBasicEmailInfo)
        var adminEmailInfo : EmailInfo = new EmailInfo(adminBasicEmailInfo)
        //Send response to Admin(s)
        var adminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.STORECREATED)
        var storeAdminUserEmailEventHandler : UserEmailEventHandler = StoreAdminUserEmailEventHandlerSingletons.getInstance().getInstance(UserEmailEventNameData.STORECREATED, this.abeClientInformation, this.modifyingStoreFrontInterface)
        storeAdminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.STORECREATED, storeAdminEmailInfo)
        adminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.STORECREATED, adminEmailInfo)
    }

    def install() : String = this.synchronized {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Intall StoreFront Successfully: ")
            stringBuffer.appendint(this.portion.getCurrent().intValue())
            stringBuffer.append(" of ")
            stringBuffer.appendint(this.portion.getTotal().intValue())
            var success : String = stringBuffer.toString()
            this.modifyingStoreFrontInterface.install(this.portion.getCurrent().intValue(), this.portion.getTotal().intValue())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "install()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to Install storefront"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "install()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def insert() : String = this.synchronized {
        try {
            var success : String = "Added Successfully"
            var values : BasicArrayList = this.modifyingStoreFrontInterface.toVector()
            StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add storefront"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            var success : String = "Delete Successfully"
            StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance().delete(this.storeName)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete storefronts table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


