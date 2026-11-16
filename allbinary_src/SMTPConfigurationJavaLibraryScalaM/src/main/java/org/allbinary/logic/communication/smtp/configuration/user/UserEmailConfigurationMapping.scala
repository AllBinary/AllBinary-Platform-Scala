/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil

class UserEmailConfigurationMapping(param_userEmailConfigurationInterface : UserEmailConfigurationInterface) extends TableMappingInterface {

    private var userEmailConfigurationInterface : UserEmailConfigurationInterface = null

    //Constructor
    {
        val userEmailConfigurationInterface : UserEmailConfigurationInterface = param_userEmailConfigurationInterface
        this.userEmailConfigurationInterface = userEmailConfigurationInterface
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        return hashMap
    }

    def getKey() : Object = {
        return UserEmailConfigurationData.NAME
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        return vector
    }

}


