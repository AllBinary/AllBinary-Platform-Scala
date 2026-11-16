/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.java.io.Reader
import _root_.java.io.Writer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.NullOutputStream
import _root_.org.allbinary.logic.io.NullReader
import _root_.org.allbinary.logic.io.NullWriter
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class SimpleFileUtil {
    import _root_.org.allbinary.logic.io.file.SimpleFileUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val NULL_WRITER : Writer = SimpleFileUtil.nullWriter()

    val NULL_READER : Reader = SimpleFileUtil.nullReader()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val nullUtil : NullUtil = NullUtil.getInstance()

    private val streamUtil : StreamUtil = StreamUtil.getInstance()

    def loadFileAsList(inputStream : InputStream, max : Int, byteArray1 : Array[Byte]) : BasicArrayList = {
        return this.loadFileAsListReturnLine(inputStream, max, byteArray1, 0)
    }

    def loadFileAsListReturnLine(inputStream : InputStream, max : Int, byteArray1 : Array[Byte], includeReturnLine : Int) : BasicArrayList = {
        val stringList : BasicArrayList = new BasicArrayListD()
        if (inputStream == null) {
            return stringList
        }
        var byteArray : Array[Byte] = this.nullUtil.NULL_BYTE_ARRAY
        try {
            val outputStream2 : ByteArrayOutputStream = new ByteArrayOutputStream(max)
            byteArray = this.streamUtil.getByteArray(inputStream, outputStream2, byteArray1)
            this.streamUtil.close(inputStream)
        } catch {
            case e : Exception => {
                this.streamUtil.close(inputStream)
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.ADD, e)
            }
        }
        if (byteArray == null) {
            return stringList
        }
        //final CommonSeps commonSeps = CommonSeps.getInstance();
        val size : Int = byteArray.length
        //this.logUtil.putF("size: " + size, this, this.commonStrings.PROCESS);
        var index : Int = 0
        var startIndex : Int = 0
        var returnLine : Int = 0

        {
            while (index < size) {
                //this.logUtil.putF("index" + index, this, this.commonStrings.PROCESS);
                startIndex = index

                {
                    while ((index < (size - 1)) && (byteArray(index) != '\n'.toByte)) {
                        index += 1
                    }
                }
                if (includeReturnLine == 0) {
                    if ((index > 0) && (byteArray(index - 1) == '\r'.toByte)) {
                        returnLine = 1
                    } else {
                        returnLine = 0
                    }
                }
                val s : String = new String(byteArray, startIndex, (((index + includeReturnLine) - returnLine) - startIndex))
                stringList.add(s)
                //stringMaker.append(s).append(commonSeps.NEW_LINE);
                index += 1
            }
        }
        //this.logUtil.putF("s: " + stringMaker.toString(), this, this.commonStrings.PROCESS);
        return stringList
    }

    def createStringFromArrayOfStrings(stringArray : Array[String]) : String = {
        val stringMaker : StringMaker = new StringMaker()
        val size : Int = stringArray.length

        {
            var index : Int = 0
            while (index < size) {
                stringMaker.append(stringArray(index))
                index += 1
            }
        }
        return stringMaker.toString()
    }

}

object SimpleFileUtil {
    private val instance : SimpleFileUtil = new SimpleFileUtil()

    /**      * @return the instance      */
    def getInstance() : SimpleFileUtil = {
        return SimpleFileUtil.instance
    }

    def nullOutputStream() : OutputStream = {
        return NullOutputStream.NULL_OUTPUT_STREAM
    }

    def nullWriter() : Writer = {
        return NullWriter.NULL_WRITER
    }

    def nullReader() : Reader = {
        return NullReader.NULL_READER
    }

}


