/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.business.init.LicenseInitInfoUtil
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.logic.io.file.SimpleFileUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class LicenseServerInitFileUtil {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val NULL_OUTPUT_STREAM : OutputStream = SimpleFileUtil.nullOutputStream()

    final def init() : Unit = {
        try {
            // this.logUtil.putF("Path: " + path, this, AndroidStrings.getInstance().START);
            val filePath : String = LicenseInitInfoUtil.getInstance().INITFILENAME
            LicenseInitInfoUtil.getInstance().setFilePath(StringUtil.getInstance().EMPTY_STRING)
            //PreLogUtil.put("SecurityManager = " + System.getSecurityManager(), this, this.commonStrings.INIT);
            if (FileFactory.getInstance().isFile(filePath)) {
                this.logUtil.putF("Using Existing License File", this, this.commonStrings.INIT)
            } else {
                this.write()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

    private def write() : Unit = {
        var fileOutputStream : OutputStream = this.NULL_OUTPUT_STREAM
        try {
            val resourceUtil : ResourceUtil = ResourceUtil.getInstance()
            val filePath : String = LicenseInitInfoUtil.getInstance().INITFILENAME
            val inputStream : InputStream = resourceUtil.getResourceAsStream(filePath)
            this.logUtil.putF("Writing Default License File", this, this.commonStrings.INIT)
            val fileStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            fileOutputStream = fileStreamFactory.getFileOutputStreamInstance(StringUtil.getInstance().EMPTY_STRING, filePath)
            var b : Int = 0
            var index : Int = 0

            {
                scala.util.boundary { (break_N71290 : scala.util.boundary.Label[Unit]) ?=>
                    while (true) {
                        b = inputStream.read()
                        if (b == -1) {
                            scala.util.boundary.break()(using break_N71290)
                        }
                        fileOutputStream.write(b)
                        index += 1
                    }
                }
            }
            this.logUtil.putF("Wrote Bytes: " + index, this, this.commonStrings.INIT)
            fileOutputStream.flush()
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        } finally {
            StreamUtil.getInstance().close(fileOutputStream)
        }
    }

}


