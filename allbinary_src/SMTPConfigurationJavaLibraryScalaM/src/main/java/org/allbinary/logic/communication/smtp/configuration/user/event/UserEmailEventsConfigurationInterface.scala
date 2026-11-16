/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

trait UserEmailEventsConfigurationInterface {

    def getEventConfigurationHashMap() : HashMap[Object, Object]

    def addUserEmailEventConfiguration(userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface) : Unit

    def getEventListener(abeClientInformation : AbeClientInformationInterface, userEmailEventNameData : UserEmailEventNameData, userInterface : UserInterface) : UserEmailEventListenerInterface

}


