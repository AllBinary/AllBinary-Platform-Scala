/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class UserEmailEventsConfiguration() extends UserEmailEventsConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var emailEventHashMap : HashMap[Object, Object] = null

    //Constructor
    {
        this.init()
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.init()
    }

    private def init() : Unit = {
        this.emailEventHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, " Constructor")
        }
    }

    def getEventConfigurationHashMap() : HashMap[Object, Object] = {
        return this.emailEventHashMap
    }

    def addUserEmailEventConfiguration(userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("Adding: " + userEmailEventConfigurationInterface.log(), this, "addUserEmailEventConfiguration")
        }
        this.emailEventHashMap.put(userEmailEventConfigurationInterface.getName(), userEmailEventConfigurationInterface)
    }

    //Retrieve the eventlistener associated with a named event
    def getEventListener(abeClientInformation : AbeClientInformationInterface, userEmailEventNameData : UserEmailEventNameData, userInterface : UserInterface) : UserEmailEventListenerInterface = {
        val userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface = this.emailEventHashMap.get(userEmailEventNameData.toString()).asInstanceOf[UserEmailEventConfigurationInterface]
        return UserEmailEventListenerFactory.getInstance(abeClientInformation, userEmailEventConfigurationInterface, userInterface)
    }

}


