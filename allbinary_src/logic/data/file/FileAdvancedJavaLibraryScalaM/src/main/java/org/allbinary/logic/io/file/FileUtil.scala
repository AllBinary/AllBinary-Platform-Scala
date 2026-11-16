/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.AbFileLocalInputStream
import _root_.org.allbinary.logic.io.AbIOSystem
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

//data/init/views/TestStore/template/type/genericTemplateObjectConfig.xml
class FileUtil private() {
    import _root_.org.allbinary.logic.io.file.FileUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val directory : Directory = Directory.getInstance()

    private val logConfigTypeFactory : LogConfigTypeFactory = LogConfigTypeFactory.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val streamUtil : StreamUtil = StreamUtil.getInstance()

    private val WRITE_LABEL : String = "Write file: "

    private val DATA_LABEL : String = " data: "

    private val WRITE_METHOD : String = "write"

    /*     }     catch(Exception e)     {     if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(logConfigTypeFactory.FILEERROR))     {     this.logUtil.put("Error Copying File from: " + from.toString() + " to: " +     to.toString(),instance,"copyFile", e);     }     throw e;     }     }      */
    def write(inputStream : InputStream, file : AbFile) : Unit = {
        var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(file)
        this.write(inputStream, dataOutputStream)
    }

    def write(inputStream : InputStream, param_dataOutputStream : AbDataOutputStream) : Unit = {
        var dataOutputStream : AbDataOutputStream = param_dataOutputStream
        try {
            dataOutputStream = StreamUtil.getInstance().get(inputStream, dataOutputStream, new Array[Byte](16384)).asInstanceOf[AbDataOutputStream]
            dataOutputStream.flush()
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
        }
    }

    def write(inputStream : InputStream, param_dataOutputStream : AbDataOutputStream, buffer : Array[Byte]) : Unit = {
        var dataOutputStream : AbDataOutputStream = param_dataOutputStream
        try {
            dataOutputStream = StreamUtil.getInstance().get(inputStream, dataOutputStream, buffer).asInstanceOf[AbDataOutputStream]
            dataOutputStream.flush()
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
        }
    }

    private def copy(dataInputStream : AbFileInputStream, param_dataOutputStream : AbDataOutputStream) : Unit = {
        var dataOutputStream : AbDataOutputStream = param_dataOutputStream
        try {
            dataOutputStream = StreamUtil.getInstance().get(dataInputStream, dataOutputStream, new Array[Byte](16384)).asInstanceOf[AbDataOutputStream]
            dataOutputStream.flush()
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
            StreamUtil.getInstance().close(dataInputStream)
        }
    }

    /*     private final boolean isInCloud(AbFile file)     throws Exception     {     AbPath rootPath = new AbPath(URLGLOBALS.getWebappPath());      //if (file.getPath().indexOf(rootPath) != -1)     if (file.getPath().contains(rootPath.getPath()))     {     return false;     } else     {     return true;     }     }      */
    private def fixPath(file : AbFile, path : AbPath, realPath : AbPath, cloud : String) : AbPath = {
        var beginIndex : Int = file.getPath().indexOf(cloud) + cloud.length()
        //int beginIndex = path.getPath().length();
        var endIndex : Int = file.getPath().indexOf(file.getName())
        var fixedPathString : String = realPath.toFileSystemString() + file.getPath().substring(beginIndex, endIndex)
        var fixedPath : AbPath = new AbPath(fixedPathString, StringUtil.getInstance().EMPTY_STRING)
        this.directory.create(fixedPath)
        val string : String = fixedPath.toFileSystemString()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
            this.logUtil.putF(string, this, "fixPath")
        }
        var outPath : AbPath = new AbPath(string, file.getName())
        return outPath
    }

    def copyToCloud(file : AbFile, path : AbPath, realPath : AbPath, cloud : String) : Unit = {
        this.copyToCloud(file, path, realPath, cloud, false, false)
    }

    def copyToCloud(file : AbFile, path : AbPath, realPath : AbPath, cloud : String, overwriteNewer : Boolean, overwriteAll : Boolean) : Unit = {
        try {
            var outPath : AbPath = this.fixPath(file, path, realPath, cloud)
            var outFile : AbFile = AbFile.createAbFileFromAbPath(outPath)
            //{
            if (!this.copyPrepare(file, outFile, overwriteNewer, overwriteAll)) {
                return
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Out File: ")
                    stringBuffer.append(outFile.getPath())
                    stringBuffer.append(" In File: ")
                    stringBuffer.append(file.getPath())
                    stringBuffer.append(" to cloud.")
                    this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyToCloud")
                }
            }
            var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(outFile)
            var fileInputStream : AbFileInputStream = new AbFileLocalInputStream(file)
            //  new AbDataInputStream(fileInputStream);
            this.copy(fileInputStream, dataOutputStream)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILEERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Copying File File: ")
                    stringBuffer.append(file.toString())
                    stringBuffer.append(" to cloud.")
                    this.logUtil.put(stringBuffer.toString(), getInstance(), "copyToCloud", e)
                }
                throw e
            }
        }
    }

    def copyToCloud(file : AbFile, outFile : AbFile) : Unit = {
        this.copyToCloud(file, outFile, false, false)
    }

    def copyToCloud(file : AbFile, outFile : AbFile, overwriteNewer : Boolean, overwriteAll : Boolean) : Unit = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            //{
            if (!this.copyPrepare(file, outFile, overwriteNewer, overwriteAll)) {
                return
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Out File: ")
                    stringBuffer.append(outFile.getPath())
                    stringBuffer.append(" In File: ")
                    stringBuffer.append(file.getPath())
                    stringBuffer.append(" to cloud.")
                    this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyToCloud")
                }
            }
            var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(outFile)
            var fileInputStream : AbFileInputStream = new AbFileLocalInputStream(file)
            //  new AbDataInputStream(fileInputStream);
            this.copy(fileInputStream, dataOutputStream)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILEERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Copying File File: ")
                    stringBuffer.append(file.toString())
                    stringBuffer.append(" to cloud.")
                    this.logUtil.put(stringBuffer.toString(), getInstance(), "copyToCloud", e)
                }
                throw e
            }
        }
    }

    private def copyPrepare(fromFile : AbFile, toFile : AbFile, overwriteNewer : Boolean, overwriteAll : Boolean) : Boolean = {
        if (toFile.exists()) {
            var stringBuffer : StringMaker = new StringMaker()
            //Overwrite existing
            if (overwriteAll) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Overwriting File: ")
                    stringBuffer.append(toFile.getPath())
                    this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyFile")
                }
                toFile.delete()
                toFile.createNewFile()
            } else if ((toFile.lastModified() < fromFile.lastModified()) && overwriteNewer) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Newer by: ")
                    stringBuffer.appendlong(fromFile.lastModified() - toFile.lastModified())
                    stringBuffer.append("ms ")
                    stringBuffer.append("Copying File: ")
                    stringBuffer.append(toFile.getPath())
                    this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyFile")
                }
                toFile.delete()
                toFile.createNewFile()
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("File Already Exists")
                    if (overwriteNewer) {
                        stringBuffer.append(" And Is Not Older")
                    } else {
                        stringBuffer.append(" And Not A In Overwrite Mode")
                    }
                    stringBuffer.append(CommonLabels.getInstance().COLON_SEP)
                    stringBuffer.append(toFile.getPath())
                    this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyFile")
                }
                return false
            }
        } else {
            toFile.createNewFile()
        }
        return true
    }

    private def copyFile(fromFile : AbFile, toFile : AbFile) : Unit = {
        this.copyFile(fromFile, toFile, false, false)
    }

    private def copyFile(fromFile : AbFile, toFile : AbFile, overwriteNewer : Boolean, overwriteAll : Boolean) : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Copying ")
                stringBuffer.appendlong(fromFile.length())
                stringBuffer.append(" bytes from File: ")
                stringBuffer.append(fromFile.getPath())
                stringBuffer.append(" to: ")
                stringBuffer.append(toFile.getPath())
                this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyFile")
            }
            if (!this.copyPrepare(fromFile, toFile, overwriteNewer, overwriteAll)) {
                return
            }
            var dataOutputStream : AbDataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(toFile)
            var fileInputStream : AbFileInputStream = AbFileInputStream.createFromAbFile(fromFile)
            //  new AbDataInputStream(fileInputStream);
            this.copy(fileInputStream, dataOutputStream)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILEERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Copying File fromFile: ")
                    stringBuffer.append(fromFile.toString())
                    stringBuffer.append(" to: ")
                    stringBuffer.append(toFile.toString())
                    this.logUtil.put(stringBuffer.toString(), getInstance(), "copyFile", e)
                }
                throw e
            }
        }
    }

    def copyDirectoryPortion(fromDirectoryAbPath : AbPath, toDirectoryAbPath : AbPath, overwriteNewer : Boolean, overwriteAll : Boolean, current : Int, total : Int) : Unit = {
        val file : AbFile = AbFile.createAbFileFromAbPath(fromDirectoryAbPath)
        if (!file.isDirectory()) {
            throw new Exception("Not a directory: " + file.getPath())
        }
        val fileList : BasicArrayList = this.directory.search(file, true)
        val size : Int = fileList.size()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Searched: ")
        stringBuffer.append(file.getPath())
        stringBuffer.append(" Total: ")
        stringBuffer.appendint(size)
        //Add one to round up so files will not be missed
        val portion : Int = (size / total) + 1
        val start : Int = portion * current
        var end : Int = start + portion
        if (end > size) {
            end = size
        }
        stringBuffer.append(" Section: ")
        stringBuffer.appendint(start)
        stringBuffer.append(" - ")
        stringBuffer.appendint(end)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
            this.logUtil.putF(stringBuffer.toString(), getInstance(), "copySomeFilesToDirectory()")
        }
        //PreLogUtil.put(stringBuffer.toString(), this, "copySomeFilesToDirectory()");
        var nextFile : AbFile = null

        {
            var index : Int = start
            while (index < end) {
                nextFile = fileList.get(index).asInstanceOf[AbFile]
                if (nextFile.isDirectory()) {
                } else {
                    var path : String = new AbPath(nextFile.getPath(), StringUtil.getInstance().EMPTY_STRING).getPath()
                    //String temp = fromDirectoryAbPath.getPath();
                    var beginIndex : Int = fromDirectoryAbPath.getPath().length()
                    //get webapp path may have schema that may not be in paths
                    if (path.indexOf(URLGLOBALS.getWebappPath()) < 0) {
                        beginIndex -= new AbPath(URLGLOBALS.getWebappPath(), StringUtil.getInstance().EMPTY_STRING).getPath().length()
                    }
                    //String newPath = toDirectoryAbPath.getPath() + path.substring(beginIndex);
                    var newPath : String = toDirectoryAbPath.toFileSystemString() + path.substring(beginIndex)
                    //this.logUtil.putF(stringBuffer.toString(), this, "copyDirectoryPortion");
                    var toFile : AbFile = AbFile.createAbFileFromAbPath(new AbPath(newPath, StringUtil.getInstance().EMPTY_STRING))
                    this.copyFile(nextFile, toFile, overwriteNewer, overwriteAll)
                }
                index += 1
            }
        }
    }

    //recursively copy files and create directories
    private def copyDirectory(fromFile : AbFile, to : AbFile) : Unit = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Copying Directory from: ")
                stringBuffer.append(fromFile.getPath())
                stringBuffer.append(" to: ")
                stringBuffer.append(to.getPath())
                this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyDirectory")
            }
            //create new directory            
            val newDirectory : String = FileUtil.getNewDirectory(fromFile)
            val newDirectoryAbPath : AbPath = new AbPath((to.getPath() + AbPathData.getInstance().SEPARATOR) + newDirectory, StringUtil.getInstance().EMPTY_STRING)
            if (!this.directory.create(newDirectoryAbPath)) {
                throw new Exception("Failed to create directory: " + newDirectoryAbPath)
            }
            //copy all files and subdirectories
            val fileArray : Array[AbFile] = FileWrapperUtil.wrapFiles(fromFile.listFiles().asInstanceOf[Array[Object]])
            val size : Int = fileArray.length
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Copying ")
                stringBuffer.appendint(size)
                stringBuffer.append(" files from: ")
                stringBuffer.append(fromFile.getPath())
                stringBuffer.append(" to: ")
                stringBuffer.append(to.getPath())
                this.logUtil.putF(stringBuffer.toString(), getInstance(), "copyDirectory")
            }
            var file : AbFile = null

            {
                var index : Int = 0
                while (index < size) {
                    file = fileArray(index)
                    if (file.isFile()) {
                        this.copyFile(file, AbFile.createAbFilePathAndName(newDirectoryAbPath.toString(), file.getName()))
                    } else if (file.isDirectory()) {
                        this.copyDirectory(file, AbFile.createAbFileFromAbPath(newDirectoryAbPath))
                    } else {
                        throw new Exception("File Copy Error")
                    }
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILEERROR)) {
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Copying Directory fromFile: ")
                    stringBuffer.append(fromFile.toString())
                    stringBuffer.append(" to: ")
                    stringBuffer.append(to.toString())
                    this.logUtil.put(stringBuffer.toString(), getInstance(), "copyDirectory", e)
                }
                throw e
            }
        }
    }

    //Example: fromFile = /home/dir/ to = /home/dest/ then the result will be /home/dest/(all subdirectories of /home/dir/)
    def copy(fromAbPath : AbPath, to : AbPath) : Boolean = this.synchronized {
        val COPY : String = "copy"
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Copying AbPaths from: ")
                stringBuffer.append(fromAbPath.toString())
                stringBuffer.append(" to: ")
                stringBuffer.append(to.toString())
                this.logUtil.putF(stringBuffer.toString(), getInstance(), COPY)
            }
            if (fromAbPath == null) {
                throw new Exception("Cannot Copy From A Null Location")
            }
            if (to == null) {
                throw new Exception("Cannot Copy To A Null Location")
            }
            val fromLocationFile : AbFile = AbFile.createAbFileFromAbPath(fromAbPath)
            val toLocationFile : AbFile = AbFile.createAbFileFromAbPath(to)
            //copy single file
            if (fromLocationFile.isFile()) {
                if (toLocationFile.isDirectory()) {
                    //keep the same file
                    var file : AbFile = AbFile.createAbFileWithChild(toLocationFile, fromLocationFile.getName())
                    this.copyFile(fromLocationFile, file)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append("Copied file=")
                        stringBuffer.append(fromLocationFile.getName())
                        stringBuffer.append(" from: ")
                        stringBuffer.append(fromLocationFile.getPath())
                        stringBuffer.append(" to: ")
                        stringBuffer.append(toLocationFile.getPath())
                        this.logUtil.putF(stringBuffer.toString(), getInstance(), COPY)
                    }
                } else {
                    //rename the file
                    this.copyFile(fromLocationFile, toLocationFile)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        var stringBuffer : StringMaker = new StringMaker()
                        stringBuffer.append("Copied file with new name ")
                        stringBuffer.append(" from: ")
                        stringBuffer.append(fromLocationFile.getPath())
                        stringBuffer.append(" to: ")
                        stringBuffer.append(toLocationFile.getPath())
                        this.logUtil.putF(stringBuffer.toString(), getInstance(), COPY)
                    }
                }
            } else if (fromLocationFile.isDirectory() && toLocationFile.isDirectory()) {
                //check last character
                if (fromAbPath.toFileSystemString().charAt(fromAbPath.toFileSystemString().length() - 1) == _root_.java.io.File.separatorChar) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        this.logUtil.putF("Copying subdirectories", getInstance(), COPY)
                    }
                    var fileArray : Array[AbFile] = FileWrapperUtil.wrapFiles(fromLocationFile.listFiles().asInstanceOf[Array[Object]])

                    {
                        var index : Int = 0
                        while (index < fileArray.length) {
                            var file : AbFile = fileArray(index)
                            if (file.isFile()) {
                                var aFile : AbFile = AbFile.createAbFileWithChild(toLocationFile, file.getName())
                                this.copyFile(file, aFile)
                            } else if (file.isDirectory()) {
                                this.copyDirectory(file, toLocationFile)
                            } else {
                                throw new Exception("File Copy Error")
                            }
                            index += 1
                        }
                    }
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        this.logUtil.putF("Copied subdirectories", getInstance(), COPY)
                    }
                } else {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        this.logUtil.putF("Copyinhg directory", getInstance(), COPY)
                    }
                    this.copyDirectory(fromLocationFile, toLocationFile)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILE)) {
                        this.logUtil.putF("Copied directory", getInstance(), COPY)
                    }
                }
            }
            return true
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(this.logConfigTypeFactory.FILEERROR)) {
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Copying fromAbPath: ")
                    stringBuffer.append(fromAbPath.toString())
                    stringBuffer.append(" to: ")
                    stringBuffer.append(to.toString())
                    this.logUtil.put(stringBuffer.toString(), getInstance(), COPY, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    // CategoryData.ENCRYPTED_EXTENSION);
    def shouldSkip(file : AbFile, skipFiles : Array[String]) : Boolean = {
        val size : Int = skipFiles.length
        var skipFile : String = null

        {
            var index : Int = 0
            while (index < size) {
                skipFile = skipFiles(index)
                if (file.getPath().compareTo(skipFile) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    def write(filePath : String, string : String) : Unit = {
        var dataOutputStream : AbDataOutputStream = null
        try {
            //this.logUtil.putF("Write Configuration: " + this.toString(), this, "write");
            PreLogUtil.put(new StringMaker().append(this.WRITE_LABEL).append(filePath).append(this.DATA_LABEL).append(string).toString(), this, this.WRITE_METHOD)
            val fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            val fileOutputStream : OutputStream = fileInputStreamFactory.getFileOutputStreamInstance(StringUtil.getInstance().EMPTY_STRING, filePath)
            dataOutputStream = new AbDataOutputStream(fileOutputStream)
            dataOutputStream.write(string.getBytes(), 0, string.length())
            dataOutputStream.flush()
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
        }
    }

    def loadFileAsList(file : AbFile, max : Int, byteArray1 : Array[Byte]) : BasicArrayList = {
        return FileUtil2.getInstance().loadFileAsList(file, max, byteArray1)
    }

}

object FileUtil {
    private val instance : FileUtil = new FileUtil()

    /**      * @return the instance      */
    def getInstance() : FileUtil = {
        return FileUtil.instance
    }

    private def getNewDirectory(fromFile : AbFile) : String = {
        var newDirectory : String = fromFile.getPath()
        var separatorChar : String = FilePathData.getInstance().PATH_START
        if (AbIOSystem.getInstance().isType("com.vobject.appengine.java.io")) {
            separatorChar = AbPathData.getInstance().SEPARATOR
        }
        var lastIndex : Int = newDirectory.lastIndexOf(separatorChar)
        if (lastIndex >= newDirectory.length()) {
            newDirectory = newDirectory.substring(0, newDirectory.length() - 1)
            lastIndex = newDirectory.lastIndexOf(separatorChar)
        }
        return newDirectory.substring(lastIndex, newDirectory.length())
    }

}


