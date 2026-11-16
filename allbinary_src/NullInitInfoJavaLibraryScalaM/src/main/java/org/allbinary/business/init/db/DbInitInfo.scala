/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db

import _root_.org.allbinary.logic.communication.log.PreLogUtil

//import org.allbinary.logic.communication.log.config.type.LogConfigTypes;
class DbInitInfo(param_initFileName : String, param_read : Boolean) extends DbConnectionInfo() {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val initFileName : String = param_initFileName
        val read : Boolean = param_read
    }

    override def getUrl() : String = {
        var url : String = super.getUrl()
        //{
        PreLogUtil.put("Url: " + url, this, "getUrl")
        //}
        return url
    }

    def write() : Unit = this.synchronized {
    }

    private def load() : Unit = this.synchronized {
    }

    def setHasRead(value : Boolean) : Unit = this.synchronized {
    }

}


