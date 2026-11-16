/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system

import _root_.org.allbinary.KotlinUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class SoftwareInformation(param_name : String, param_version : String, param_shortName : String) {

    private var name : String = null

    private var shortName : String = null

    private var version : String = null

    //Constructor
    {
        val name : String = param_name
        val version : String = param_version
        val shortName : String = param_shortName
        this.name = name
        this.version = version
        //Since Kotlin build input mappings are not the same as Java for some reason we need to include that in the shortname to make sure we are not using the incorrect mapping.
        this.shortName = new StringMaker().append(shortName).append(KotlinUtil.getShortName()).toString()
    }

    def getName() : String = {
        return this.name
    }

    def getVersion() : String = {
        return this.version
    }

    def toShortString() : String = {
        return this.shortName
    }

    override def toString() : String = {
        val NAME : String = "Name: "
        val VERSION : String = "Version: "
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(NAME)
        stringBuffer.append(this.getName())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(VERSION)
        stringBuffer.append(this.getVersion())
        return stringBuffer.toString()
    }

}


