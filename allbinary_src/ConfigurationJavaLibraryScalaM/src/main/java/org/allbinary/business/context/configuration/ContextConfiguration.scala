/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.configuration

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfiguration
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationInterface
import _root_.org.allbinary.string.CommonStrings

class ContextConfiguration() extends ContextConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var emailServerConfigurationInterface : EmailServerConfigurationInterface = null

    //Constructor
    {
        this.logUtil.putF(this.commonStrings.START, this, "ContextConfiguration")
        this.setEmailServerConfigurationInterface((new EmailServerConfiguration()).asInstanceOf[EmailServerConfigurationInterface])
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.logUtil.putF(this.commonStrings.START, this, "ContextConfiguration(HashMap)")
        this.setEmailServerConfigurationInterface((new EmailServerConfiguration(hashMap)).asInstanceOf[EmailServerConfigurationInterface])
    }

    def getEmailServerConfigurationInterface() : EmailServerConfigurationInterface = {
        return this.emailServerConfigurationInterface
    }

    def setEmailServerConfigurationInterface(emailServerConfigurationInterface : EmailServerConfigurationInterface) : Unit = {
        this.emailServerConfigurationInterface = emailServerConfigurationInterface
    }

}


