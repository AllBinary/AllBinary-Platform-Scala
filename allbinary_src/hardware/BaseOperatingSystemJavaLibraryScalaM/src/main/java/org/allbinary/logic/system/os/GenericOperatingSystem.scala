/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os

import _root_.org.allbinary.logic.java.character.CharacterSet
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonSeps

class GenericOperatingSystem() extends OperatingSystemInterface {

    private var osName : String = null

    private var osArch : String = null

    private var osVersion : String = null

    private val characterSet : CharacterSet = new CharacterSet()

    var scalable : Boolean = false

    //Constructor
    {
        val systemProperties : SystemProperties = SystemProperties.getInstance()
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        if (stringValidationUtil.isEmpty(systemProperties.getName())) {
            this.osName = EMPTY_STRING
        } else {
            this.osName = systemProperties.getName()
        }
        if (stringValidationUtil.isEmpty(systemProperties.getArch())) {
            this.osArch = EMPTY_STRING
        } else {
            this.osArch = systemProperties.getArch()
        }
        if (stringValidationUtil.isEmpty(systemProperties.getVersion())) {
            this.osVersion = EMPTY_STRING
        } else {
            this.osVersion = systemProperties.getVersion()
        }
    }

    override def getName() : String = {
        return this.osName
    }

    override def getVersion() : String = {
        return this.osVersion
    }

    override def getArch() : String = {
        return this.osArch
    }

    override def getCharacterSet() : CharacterSet = {
        return this.characterSet
    }

    override def isOverScan() : Boolean = {
        return false
    }

    override def getOverScanXPercent() : Int = {
        return 100
    }

    override def getOverScanYPercent() : Int = {
        return 100
    }

    override def isScalable() : Boolean = {
        return this.scalable
    }

    override def isAutoHide() : Boolean = {
        return false
    }

    override def toString() : String = {
        val NEW_LINE : String = CommonSeps.getInstance().NEW_LINE
        val osBuffer : StringMaker = new StringMaker()
        osBuffer.append("Operating System Info: \n")
        osBuffer.append(this.getName())
        osBuffer.append(NEW_LINE)
        osBuffer.append(this.getArch())
        osBuffer.append(NEW_LINE)
        osBuffer.append(this.getVersion())
        osBuffer.append(NEW_LINE)
        osBuffer.append(StringUtil.getInstance().toString(this.getCharacterSet()))
        osBuffer.append(NEW_LINE)
        return osBuffer.toString()
    }

}


