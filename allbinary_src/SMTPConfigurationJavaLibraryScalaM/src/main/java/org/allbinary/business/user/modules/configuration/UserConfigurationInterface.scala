/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.configuration

import _root_.org.allbinary.business.time.created.TimeCreated
import _root_.org.allbinary.business.time.modified.TimeLastModified
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationInterface

trait UserConfigurationInterface {

    def getUserEmailConfigurationInterface() : UserEmailConfigurationInterface

    def setUserEmailConfigurationInterface(userEmailConfigurationInterface : UserEmailConfigurationInterface) : Unit

    def getTimeCreated() : TimeCreated

    def getTimeLastModified() : TimeLastModified

    def setTimeCreated(timeCreated : TimeCreated) : Unit

    def setTimeLastModified(timeLastModified : TimeLastModified) : Unit

}


