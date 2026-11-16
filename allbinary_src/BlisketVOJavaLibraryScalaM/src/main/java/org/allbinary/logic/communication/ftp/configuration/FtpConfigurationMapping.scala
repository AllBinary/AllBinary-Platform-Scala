/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.ftp.configuration

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.StdUtil

class FtpConfigurationMapping(param_ftpConfigurationInterface : FtpConfigurationInterface) extends TableMappingInterface {

    private var ftpConfigurationInterface : FtpConfigurationInterface = null

    //Constructor
    {
        val ftpConfigurationInterface : FtpConfigurationInterface = param_ftpConfigurationInterface
        this.ftpConfigurationInterface = ftpConfigurationInterface
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(FtpConfigurationData.SERVER, this.ftpConfigurationInterface.getServer())
        hashMap.put(FtpConfigurationData.USERNAME, this.ftpConfigurationInterface.getUserName())
        hashMap.put(FtpConfigurationData.PASSWORD, this.ftpConfigurationInterface.getPassword())
        hashMap.put(FtpConfigurationData.PATH, this.ftpConfigurationInterface.getPath())
        return hashMap
    }

    def getKey() : Object = {
        return FtpConfigurationData.NAME
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.ftpConfigurationInterface.getServer())
        vector.add(this.ftpConfigurationInterface.getUserName())
        vector.add(this.ftpConfigurationInterface.getPassword())
        vector.add(this.ftpConfigurationInterface.getPath())
        return vector
    }

}


