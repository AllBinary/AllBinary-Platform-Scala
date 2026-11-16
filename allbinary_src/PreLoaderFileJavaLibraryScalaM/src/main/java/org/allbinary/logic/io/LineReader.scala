/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.DataInputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class LineReader(param_fileName : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var fileName : String = null

    private var string : String = null

    private var index : Int = 0

    private var idFile : AbFileInputStream = null

    private var idData : DataInputStream = null

    //Constructor
    {
        val fileName : String = param_fileName
        try {
            var bytes : Array[Byte] = new Array[Byte](100000)
            this.fileName = fileName
            this.idFile = new AbFileInputStream(fileName)
            this.idFile.read(bytes)
            this.string = new String(bytes)
        } catch {
            case e : Exception => {
                this.logUtil.put("File: " + fileName, this, "LineReader", e)
                //if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().IDLOGGING))

                {
                }
            }
        }
    }

    def hasNext() : Boolean = {
        try {
            val nextIndex : Int = this.string.indexOf(CommonSeps.getInstance().NEW_LINE, index)
            if (nextIndex == -1) {
                return false
            }
            return true
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, "hasNext", e)
                //if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().IDLOGGING))

                {
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    def next() : String = {
        try {
            val nextIndex : Int = this.string.indexOf(CommonSeps.getInstance().NEW_LINE, index)
            if (nextIndex == -1) {
                throw new Exception("next() should have been called first")
            }
            val temp : String = this.string.substring(index, nextIndex)
            index = nextIndex + 1
            return temp
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, "next", e)
                //if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().IDLOGGING))

                {
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


