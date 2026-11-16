/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.DataOutputStream
import _root_.java.io.FileOutputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFileSystem
import _root_.org.allbinary.string.CommonStrings

class SmallDelete(param_fileName : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var fileName : String = null

    private var string : String = null

    //Constructor
    {
        val fileName : String = param_fileName
        this.fileName = fileName
        this.string = AbFileSystem.getInstance().readAsString(fileName)
    }

    //Include end
    def deleteAtStart(start : String, end : String) : Boolean = {
        try {
            var beginIndex : Int = 0
            var endIndex : Int = 0
            beginIndex = this.string.indexOf(start)
            endIndex = this.string.indexOf(end)
            //this.logUtil.putF("StartIndex: " + beginIndex + " EndIndex: " + endIndex, this, "deleteAtStart");
            if (((((endIndex > beginIndex) && (beginIndex >= 0)) && (endIndex >= 0)) && (beginIndex < 10)) && (endIndex < 525)) {
                val text : String = this.string.substring(endIndex, this.string.length())
                var idFile : FileOutputStream = new FileOutputStream(this.fileName)
                var idOutData : DataOutputStream = new DataOutputStream(idFile)
                idOutData.writeBytes(text)
                return true
            }
            return false
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "deleteAtStart", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def deleteBetween(start : String, end : String, newText : String) : Boolean = {
        try {
            var beginIndex : Int = 0
            var endIndex : Int = 0
            beginIndex = this.string.indexOf(start)
            endIndex = this.string.indexOf(end)
            //this.logUtil.putF("StartIndex: " + beginIndex + " EndIndex: " + endIndex, this, "deleteAtStart");
            if (((((endIndex > beginIndex) && (beginIndex >= 0)) && (endIndex >= 0)) && (beginIndex < 50)) && (endIndex < 425)) {
                val newStart : String = this.string.substring(0, beginIndex)
                val text : String = this.string.substring(endIndex + end.length(), this.string.length())
                var idFile : FileOutputStream = new FileOutputStream(this.fileName)
                var idOutData : DataOutputStream = new DataOutputStream(idFile)
                idOutData.writeBytes((newStart + newText) + text)
                return true
            }
            return false
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "deleteAtStart", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

}


