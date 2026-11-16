/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log.config.`type`

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class LogConfigType(param_name : String, param_description : String) {
    import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigType.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var name : String = null

    private var description : String = null

    //Constructor
    {
        val name : String = param_name
        val description : String = param_description
        //this.logUtil.putF(name, this, this.commonStrings.CONSTRUCTOR);
        this.name = name
        this.description = description
        LogConfigType.availableLogConfigTypes.add(this)
    }

    def getName() : String = {
        return this.name
    }

    def getDescription() : String = {
        return this.description
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setDescription(value : String) : Unit = {
        this.description = value
    }

}

object LogConfigType {
    var availableLogConfigTypes : BasicArrayList = new BasicArrayListD()

}


