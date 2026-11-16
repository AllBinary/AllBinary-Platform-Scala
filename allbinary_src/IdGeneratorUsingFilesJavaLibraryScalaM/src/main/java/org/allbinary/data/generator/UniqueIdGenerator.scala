/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.generator

import _root_.java.io.IOException
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbDataInputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.string.CommonStrings

class UniqueIdGenerator() extends IdGeneratorInterface {
    import _root_.org.allbinary.data.generator.UniqueIdGenerator.{EXT as _, *}
    def EXT : String = _root_.org.allbinary.data.generator.UniqueIdGenerator.EXT

    val logUtil : LogUtil = LogUtil.getInstance()

    //private String uniqueIdFile;
    private var newFile : AbFile = null

    private var id : Long = 0

    def initialize(value : Int) : Unit = {
        try {
            this.newFile.createNewFile()
            val idData : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(this.newFile)
            idData.writeLong(value)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "initialize", e)
                }
            }
        }
    }

    def setFile(filePathName : String, name : String) : Unit = this.synchronized {
        //uniqueIdFile=filePathName;
        this.newFile = AbFile.createAbFile(filePathName)
    }

    def getNext() : String = this.synchronized {
        var idData : AbDataInputStream = null
        var idOutData : AbDataOutputStream = null
        try {
            val idFile : AbFileInputStream = AbFileInputStream.createFromAbFile(this.newFile)
            idData = new AbDataInputStream(idFile)
            this.id = idData.readLong()
            val idOutFile : AbFileOutputStream = AbFileOutputStream.createFromAbFile(this.newFile)
            idOutData = new AbDataOutputStream(idOutFile)
            idOutData.writeLong(this.id + 1)
            val idLong : _root_.java.lang.Long = new _root_.java.lang.Long(this.id)
            return idLong.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().IDLOGGING)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getNext", e)
                }
                return "Error"
            }
        } finally {
            StreamUtil.getInstance().close(idData)
            StreamUtil.getInstance().close(idOutData)
        }
        throw new IllegalStateException()
    }

}

object UniqueIdGenerator {
    val EXT : String = ".unq"

}


