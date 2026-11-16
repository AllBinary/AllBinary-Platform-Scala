/* Generated Code Do Not Modify */
package org.apache.commons.fileupload

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.AbFileNativeUtil
import _root_.org.allbinary.logic.string.StringMaker

/**  *  * @author user  */
class FileItemUtil {
    import _root_.org.apache.commons.fileupload.FileItemUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val DEFAULT_CHARSET : String = "ISO-8859-1"

    def getString(byteArray : Array[Byte]) : String = {
        return new String(byteArray, this.DEFAULT_CHARSET)
    }

    def getString(fileItem : FileItemStream) : String = {
        return new String(this.getBytes(fileItem), DEFAULT_CHARSET)
    }

    def getBytes(fileItem : FileItemStream) : Array[Byte] = {
        val streamUtil : StreamUtil = StreamUtil.getInstance()
        var inputStream : InputStream = null
        var outputStream : ByteArrayOutputStream = null
        try {
            inputStream = fileItem.openStream()
            outputStream = new ByteArrayOutputStream()
            if (fileItem.isFormField()) {
                this.logUtil.putF("FileItemStream FieldName: " + fileItem.getFieldName(), this, "write()")
            } else {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Uploaded File FieldName: ")
                stringBuffer.append(fileItem.getFieldName())
                stringBuffer.append(" name = ")
                stringBuffer.append(fileItem.getName())
                this.logUtil.putF(stringBuffer.toString(), this, "write()")
            }
            outputStream = streamUtil.get(inputStream, outputStream, new Array[Byte](16384)).asInstanceOf[ByteArrayOutputStream]
            return outputStream.toByteArray()
        } finally {
            streamUtil.close(outputStream)
            streamUtil.close(inputStream)
        }
        throw new IllegalStateException()
    }

    def write(fileItem : FileItem, file : AbFile) : Unit = {
        fileItem.write(AbFileNativeUtil.get(file))
    }

}

object FileItemUtil {
    private val instance : FileItemUtil = new FileItemUtil()

    def getInstance() : FileItemUtil = {
        return FileItemUtil.instance
    }

}


