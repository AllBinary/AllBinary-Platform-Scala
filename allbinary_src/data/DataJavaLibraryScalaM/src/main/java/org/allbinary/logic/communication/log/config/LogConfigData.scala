/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config


class LogConfigData private() {
    import _root_.org.allbinary.logic.communication.log.config.LogConfigData.{*}

    val NAME : String = "LOG_CONFIG_NAME"

    val DESCRIPTION : String = "LOG_CONFIG_DESCRIPTION"

    //public final String PATH = "LOG_CONFIG_PATH";
    val FILE : String = "LOG_CONFIG_FILE"

}

object LogConfigData {
    private val instance : LogConfigData = new LogConfigData()

    def getInstance() : LogConfigData = {
        return LogConfigData.instance
    }

}


