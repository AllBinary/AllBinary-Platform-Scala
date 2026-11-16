/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event.handler

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationInterface
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfigurationInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.modules.log.LogUserEmailEventListenerModule
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class EmailEventHandlerUtil private() {
    import _root_.org.allbinary.logic.communication.smtp.event.handler.EmailEventHandlerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    /*    public static void send(       EmailInfo storeAdminEmailInfo,        StoreFrontInterface storeFrontInterface)    {       UserEmailInfoEventHandler userEmailInfoEventHandler =           UserEmailInfoEventHandlerSingleton.getInstance();       userEmailInfoEventHandler.receiveEmailInfo(storeAdminUserEmailInfo);    }        //send request to admins if subscribed to handler    public static void send(EmailInfo adminEmailInfo)    {       UserEmailInfoEventHandler userEmailInfoEventHandler =           UserEmailInfoEventHandlerSingleton.getInstance(             UserEmailInfoEventHandlerNameData.QUOTEREQUEST);       userEmailInfoEventHandler.receiveEmailInfo(adminUserEmailInfo);    }     **/
    def getEventHandler(abeClientInformation : AbeClientInformationInterface, userEmailEventNameData : UserEmailEventNameData, userVector : BasicArrayList) : UserEmailEventHandler = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Returning UserEmailEventHandler for ")
            stringBuffer.appendint(userVector.size())
            stringBuffer.append(" users.")
            this.logUtil.putF(stringBuffer.toString(), this, "getEventHandler")
        }
        val userEmailEventHandler : UserEmailEventHandler = new UserEmailEventHandler()
        userEmailEventHandler.addListener(new LogUserEmailEventListenerModule())
        var size : Int = userVector.size()

        {
            var index : Int = 0
            while (index < size) {
                val userInterface : UserInterface = userVector.get(index).asInstanceOf[UserInterface]
                val vector : BasicArrayList = EmailEventHandlerUtil.getUserEmailEventListenerVector(abeClientInformation, userEmailEventNameData, userInterface)
                userEmailEventHandler.addListener(vector)
                index += 1
            }
        }
        return userEmailEventHandler
    }

}

object EmailEventHandlerUtil {
    private val instance : EmailEventHandlerUtil = new EmailEventHandlerUtil()

    def getInstance() : EmailEventHandlerUtil = {
        return EmailEventHandlerUtil.instance
    }

    def getUserEmailEventListenerVector(abeClientInformation : AbeClientInformationInterface, userEmailEventNameData : UserEmailEventNameData, userInterface : UserInterface) : BasicArrayList = {
        //Currently uses a single user configuration
        val userConfigurationInterface : UserConfigurationInterface = userInterface.getUserConfigurationInterface()
        val userEmailConfigurationInterface : UserEmailConfigurationInterface = userConfigurationInterface.getUserEmailConfigurationInterface()
        val userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface = userEmailConfigurationInterface.getUserEmailEventsConfigurationInterface()
        val userEmailEventListenerInterface : UserEmailEventListenerInterface = userEmailEventsConfigurationInterface.getEventListener(abeClientInformation, userEmailEventNameData, userInterface)
        val vector : BasicArrayList = new BasicArrayListD()
        //Add event listener
        vector.add(userEmailEventListenerInterface)
        return vector
    }

}


