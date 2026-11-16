/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.configuration

import _root_.java.util.HashMap
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.time.created.TimeCreated
import _root_.org.allbinary.business.time.modified.TimeLastModified
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfiguration
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationInterface

class UserConfiguration() extends UserConfigurationInterface {

    //private FtpConfigurationInterface ftpConfigurationInterface;
    private var userEmailConfigurationInterface : UserEmailConfigurationInterface = null

    private var timeCreated : TimeCreated = null

    private var timeLastModified : TimeLastModified = null

    //Constructor
    {
        this.userEmailConfigurationInterface = (new UserEmailConfiguration()).asInstanceOf[UserEmailConfigurationInterface]
        this.timeCreated = new TimeCreated(0)
        this.timeLastModified = new TimeLastModified(0)
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        // new FtpConfiguration(hashMap);
        this.userEmailConfigurationInterface = (new UserEmailConfiguration(hashMap)).asInstanceOf[UserEmailConfigurationInterface]
        this.timeCreated = new TimeCreated(hashMap.get(EntryData.getInstance().TIMECREATED).asInstanceOf[String])
        this.timeLastModified = new TimeLastModified(hashMap.get(EntryData.getInstance().LASTMODIFIED).asInstanceOf[String])
    }

    /*    public FtpConfigurationInterface getFtpConfigurationInterface()    {       return this.ftpConfigurationInterface;    }     public void setFtpConfigurationInterface(       FtpConfigurationInterface ftpConfigurationInterface)    {       this.ftpConfigurationInterface = ftpConfigurationInterface;    }    */
    def getUserEmailConfigurationInterface() : UserEmailConfigurationInterface = {
        return this.userEmailConfigurationInterface
    }

    def setUserEmailConfigurationInterface(userEmailConfigurationInterface : UserEmailConfigurationInterface) : Unit = {
        this.userEmailConfigurationInterface = userEmailConfigurationInterface
    }

    def getTimeCreated() : TimeCreated = {
        return this.timeCreated
    }

    def getTimeLastModified() : TimeLastModified = {
        return this.timeLastModified
    }

    def setTimeCreated(timeCreated : TimeCreated) : Unit = {
        this.timeCreated = timeCreated
    }

    def setTimeLastModified(timeLastModified : TimeLastModified) : Unit = {
        this.timeLastModified = timeLastModified
    }

}


