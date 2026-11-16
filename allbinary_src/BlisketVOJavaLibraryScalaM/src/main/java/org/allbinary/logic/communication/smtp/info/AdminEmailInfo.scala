/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.info

import _root_.org.allbinary.business.context.configuration.ContextConfigurationInterface
import _root_.org.allbinary.business.user.modules.admin.configuration.AdminConfiguration
import _root_.org.allbinary.business.user.modules.admin.configuration.AdminConfigurationInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationInterface
import _root_.org.allbinary.string.CommonStrings

class AdminEmailInfo(param_subject : String, param_textBody : String) extends BasicEmailInfo(param_subject, param_textBody) {

    val logUtil_AdminEmailInfo : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val subject : String = param_subject
        val textBody : String = param_textBody
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil_AdminEmailInfo.putF(commonStrings.START, this, commonStrings.CONSTRUCTOR)
        }
        this.init()
    }

    override def init() : Unit = {
        var adminConfigurationInterface : AdminConfigurationInterface = (new AdminConfiguration()).asInstanceOf[AdminConfigurationInterface]
        var contextConfigurationInterface : ContextConfigurationInterface = adminConfigurationInterface.getContextConfigurationInterface()
        var emailServerConfigurationInterface : EmailServerConfigurationInterface = contextConfigurationInterface.getEmailServerConfigurationInterface()
        this.setEmailServerConfigurationInterface(emailServerConfigurationInterface)
    }

}


