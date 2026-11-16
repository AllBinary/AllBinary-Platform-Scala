/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.AdminUserEmailEventHandlerSingletons
import _root_.org.allbinary.logic.communication.smtp.info.AdminEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.BasicEmailInfo
import _root_.org.allbinary.logic.communication.smtp.info.EmailInfo
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory

class BasicTextEmailHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var hashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.pageContext = pageContext
        this.hashMap = hashMap
    }

    def send() : Unit = {
        var adminEmailSubject : String = this.hashMap.get("Subject").asInstanceOf[String]
        var adminEmailTextBody : String = this.hashMap.get("Body").asInstanceOf[String]
        var adminBasicEmailInfo : BasicEmailInfo = (new AdminEmailInfo(adminEmailSubject, adminEmailTextBody)).asInstanceOf[BasicEmailInfo]
        var adminEmailInfo : EmailInfo = new EmailInfo(adminBasicEmailInfo)
        //Send response to Admin(s)
        var adminUserEmailEventHandler : UserEmailEventHandler = AdminUserEmailEventHandlerSingletons.getInstance().getInstance(this.abeClientInformation, UserEmailEventNameData.INSTALLER)
        adminUserEmailEventHandler.receiveEmailInfo(UserEmailEventNameData.INSTALLER, adminEmailInfo)
    }

}


