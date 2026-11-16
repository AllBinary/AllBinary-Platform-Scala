/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.server

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil

class EmailServerConfigurationMapping(param_emailServerConfigurationInterface : EmailServerConfigurationInterface) extends TableMappingInterface {

    private var emailServerConfigurationInterface : EmailServerConfigurationInterface = null

    //Constructor
    {
        val emailServerConfigurationInterface : EmailServerConfigurationInterface = param_emailServerConfigurationInterface
        this.emailServerConfigurationInterface = emailServerConfigurationInterface
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(EmailServerConfigurationData.SERVER, this.emailServerConfigurationInterface.getSmtpServer())
        hashMap.put(EmailServerConfigurationData.ACCOUNT, this.emailServerConfigurationInterface.getAccountName())
        hashMap.put(EmailServerConfigurationData.PASSWORD, this.emailServerConfigurationInterface.getPassword())
        return hashMap
    }

    def getKey() : Object = {
        return EmailServerConfigurationData.NAME
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.emailServerConfigurationInterface.getSmtpServer())
        return vector
    }

}


