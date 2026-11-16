/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil

class UserEmailEventConfiguration() extends UserEmailEventConfigurationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var name : String = null

    //associated with this email event configuration
    private var eventListenerClassPath : String = null

    //Constructor
    {
        this.setName(StringUtil.getInstance().EMPTY_STRING)
        this.setEventListenerClassPath(StringUtil.getInstance().EMPTY_STRING)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("New", this, " Constructor")
        }
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.setName(hashMap.get(UserEmailEventConfigurationData.NAME).asInstanceOf[String])
        this.setEventListenerClassPath(hashMap.get(UserEmailEventConfigurationData.LISTENER_CLASSPATH).asInstanceOf[String])
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("Log: " + this.log(), this, " Constructor")
        }
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getEventListenerClassPath() : String = {
        return this.eventListenerClassPath
    }

    def setEventListenerClassPath(eventListenerClassPath : String) : Unit = {
        this.eventListenerClassPath = eventListenerClassPath
    }

    def log() : String = {
        return ((("\nUser Email Event Log Info:" + "\nName: ") + this.getName()) + "\nEventListenerClassPath: ") + this.getEventListenerClassPath()
    }

}


