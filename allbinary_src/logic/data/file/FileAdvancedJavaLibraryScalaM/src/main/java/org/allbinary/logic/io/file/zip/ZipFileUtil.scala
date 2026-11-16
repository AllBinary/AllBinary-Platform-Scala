/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.zip

import _root_.java.util.zip.ZipEntry
import _root_.java.util.zip.ZipInputStream
import _root_.java.util.zip.ZipOutputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class ZipFileUtil {
    import _root_.org.allbinary.logic.io.file.zip.ZipFileUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def create(outFilename : String, fileBasicArrayList : BasicArrayList) : Unit = {
        try {
            val zipFile : AbFile = AbFile.createAbFile(outFilename)
            if (zipFile.exists()) {
                zipFile.delete()
            }
            zipFile.createNewFile()
            val outputStream : ZipOutputStream = new ZipOutputStream(AbFileOutputStream.createFromAbFile(zipFile))
            val streamUtil : StreamUtil = StreamUtil.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            val byteArray : Array[Byte] = new Array[Byte](16384)
            var fileInputStream : AbFileInputStream = null
            val size : Int = fileBasicArrayList.size()
            var current : Int = 0

            {
                var i : Int = 0
                while (i < size) {
                    var file : AbFile = fileBasicArrayList.get(i).asInstanceOf[AbFile]
                    if (file.isDirectory()) {
                    } else if (file.isFile()) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.appendint(current)
                        stringBuffer.append(" Creating Zip File Entry: ")
                        stringBuffer.append(file.getPath())
                        this.logUtil.putF(stringBuffer.toString(), this, "create()")
                        try {
                            fileInputStream = AbFileInputStream.createFromAbFile(file)
                            outputStream.putNextEntry(new ZipEntry(file.getPath()))
                            streamUtil.get(fileInputStream, outputStream, byteArray)
                            outputStream.closeEntry()
                            streamUtil.close(fileInputStream)
                        } catch {
                            case e : Exception => {
                                this.logUtil.putF("Skipping File (Probably Local): " + file.getPath(), this, "create()")
                            }
                        }
                    }
                    current += 1
                    i += 1
                }
            }
            streamUtil.close(outputStream)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "create", e)
            }
        }
    }

    def unzip(path : String, zipFile : AbFile, fileName : String) : Unit = {
        var buffer : Array[Byte] = new Array[Byte](16384)
        var inputStream : ZipInputStream = null
        try {
            inputStream = new ZipInputStream(AbFileInputStream.createFromAbFile(zipFile))
            var zipEntry : ZipEntry = null
            val stringBuffer : StringMaker = new StringMaker()
            val fileUtil : FileUtil = FileUtil.getInstance()

            {
                while (({ zipEntry = inputStream.getNextEntry(); zipEntry }) != null) {
                    var entryName : String = zipEntry.getName()
                    if (zipEntry.isDirectory()) {
                    } else {
                        var entryFile : AbFile = AbFile.createAbFile(path + entryName)
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append("ZipEntry Name: ")
                        stringBuffer.append(entryName)
                        stringBuffer.append(" isFile: ")
                        stringBuffer.appendboolean(entryFile.isFile())
                        stringBuffer.append(" isDirectory: ")
                        stringBuffer.appendboolean(entryFile.isDirectory())
                        stringBuffer.append(" getParent: ")
                        stringBuffer.append(entryFile.getParent())
                        this.logUtil.putF(stringBuffer.toString(), this, "unzip")
                        var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(entryFile)
                        fileUtil.write(inputStream, dataOutputStream, buffer)
                    }
                    inputStream.closeEntry()
                }
            }
        } finally {
            StreamUtil.getInstance().close(inputStream)
        }
    }

}

object ZipFileUtil {
    private val instance : ZipFileUtil = new ZipFileUtil()

    /**      * @return the instance      */
    def getInstance() : ZipFileUtil = {
        return ZipFileUtil.instance
    }

}


