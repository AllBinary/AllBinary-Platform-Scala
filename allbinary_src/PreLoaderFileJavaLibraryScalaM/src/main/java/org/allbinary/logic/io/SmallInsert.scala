/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.DataOutputStream
import _root_.java.io.FileOutputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFileSystem
import _root_.org.allbinary.string.CommonStrings

class SmallInsert(param_fileName : String) {

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

    def atBeginning(text : String) : Boolean = {
        try {
            var idFile : FileOutputStream = new FileOutputStream(this.fileName)
            var idOutData : DataOutputStream = new DataOutputStream(idFile)
            idOutData.writeBytes(text + this.string)
            //System.out.println();
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insertAtBeginning", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def after(text : String, after : String) : Boolean = {
        try {
            var index : Int = this.string.indexOf(after)
            if (index < 0) {
                System.out.println((("No such start: " + after) + " in: ") + this.string)
                return false
            }
            index = index + after.length()
            var start : String = this.string.substring(0, index)
            var end : String = this.string.substring(index + 1, this.string.length())
            var idFile : FileOutputStream = new FileOutputStream(this.fileName)
            var idOutData : DataOutputStream = new DataOutputStream(idFile)
            idOutData.writeBytes((start + text) + end)
            //System.out.println("Output: " + start + text + end);
            idOutData.close()
            idFile.close()
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "after", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def atEnd(text : String) : Boolean = {
        try {
            var idFile : FileOutputStream = new FileOutputStream(this.fileName)
            var idOutData : DataOutputStream = new DataOutputStream(idFile)
            idOutData.writeBytes(this.string + text)
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insertAtEnd", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

}


