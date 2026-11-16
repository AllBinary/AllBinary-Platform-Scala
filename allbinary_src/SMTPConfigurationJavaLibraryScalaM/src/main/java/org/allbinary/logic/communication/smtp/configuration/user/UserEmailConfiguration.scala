/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfiguration
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfigurationInterface
import _root_.org.allbinary.string.CommonStrings

class UserEmailConfiguration() extends UserEmailConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        }
        this.setUserEmailEventsConfigurationInterface(new UserEmailEventsConfiguration())
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        }
        this.setUserEmailEventsConfigurationInterface(new UserEmailEventsConfiguration(hashMap))
    }

    def getUserEmailEventsConfigurationInterface() : UserEmailEventsConfigurationInterface = {
        return this.userEmailEventsConfigurationInterface
    }

    def setUserEmailEventsConfigurationInterface(userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface) : Unit = {
        this.userEmailEventsConfigurationInterface = userEmailEventsConfigurationInterface
    }

}


