/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventListenerInterface
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

class UserEmailEventListenerFactory private() {
    import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventListenerFactory.{*}

}

object UserEmailEventListenerFactory {
    def getInstance(abeClientInformation : AbeClientInformationInterface, userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface, userInterface : UserInterface) : UserEmailEventListenerInterface = {
        var params : Array[Object] = new Array[Object](1)
        var classes : Array[Class[?]] = new Array[Class[?]](1)
        classes(0) = classOf[UserInterface]
        params(0) = userInterface.asInstanceOf[Object]
        return AbeFactory.getInstance().getInstance(abeClientInformation, userEmailEventConfigurationInterface.getEventListenerClassPath(), classes, params).asInstanceOf[UserEmailEventListenerInterface]
    }

}


