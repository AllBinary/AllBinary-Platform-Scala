/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.Closeable
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class StreamUtil private() {
    import _root_.org.allbinary.logic.io.StreamUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    /*      * public static ByteArrayOutputStream get( InputStream in) throws Exception      * { ByteArrayOutputStream buffer = new ByteArrayOutputStream();      *      * int ch;      *      * while ((ch = in.read()) != -1) { buffer.write((byte) ch); }      *      * in.close();      *      * return buffer; }      */
    def get(inputStream : InputStream, outputStream : OutputStream, buffer : Array[Byte]) : OutputStream = {
        //int total = 0;
        var len : Int = 0

        {
            scala.util.boundary { (break_N67390 : scala.util.boundary.Label[Unit]) ?=>
                while (true) {
                    len = inputStream.read(buffer, 0, buffer.length)
                    if (len != -1) {
                    } else {
                        scala.util.boundary.break()(using break_N67390)
                    }
                    outputStream.write(buffer, 0, len)
                }
            }
        }
        /*         if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().FILE))         {         this.logUtil.putF("Total Bytes Written: " + total, this, this.commonStrings.GET);         }          */
        return outputStream
    }

    //    }
    def getByteArray(inputStream : InputStream, outputStream2 : ByteArrayOutputStream, byteArray : Array[Byte]) : Array[Byte] = {
        val outputStream : ByteArrayOutputStream = outputStream2
        try {
            this.get(inputStream, outputStream, byteArray)
            return outputStream.toByteArray()
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            this.close(outputStream)
        }
        throw new IllegalStateException()
    }

    //    }
    def close(closeable : Closeable) : Boolean = {
        try {
            if (closeable != null) {
                //this.logUtil.putF("Closing: " + closeable, this, CLOSE);
                closeable.close()
            }
            return true
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CLOSE, e)
                return false
            }
        }
        throw new IllegalStateException()
    }

}

object StreamUtil {
    private val instance : StreamUtil = new StreamUtil()

    /**      * @return the instance      */
    def getInstance() : StreamUtil = {
        return StreamUtil.instance
    }

}


