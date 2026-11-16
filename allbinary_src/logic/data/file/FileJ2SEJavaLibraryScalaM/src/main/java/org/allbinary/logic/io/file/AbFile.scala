/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.File
import _root_.java.io.FileFilter
import _root_.java.io.FilenameFilter
import _root_.java.io.IOException
import _root_.java.net.URI
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil

class AbFile(param_file : File) extends AbFileInterface {
    import _root_.org.allbinary.logic.io.file.AbFile.{NULL_FILE as _, *}
    def NULL_FILE : AbFile = _root_.org.allbinary.logic.io.file.AbFile.NULL_FILE

    private var file : File = null

    //Constructor
    {
        val file : File = param_file
        this.file = file
    }

    /**     * @return the file     */
    def getFile() : File = {
        return this.file
    }

    def getName() : String = {
        return this.file.getName()
    }

    override def getParent() : String = {
        return this.file.getParent()
    }

    def getParentFile() : Object = {
        return this.file.getParentFile()
    }

    override def getPath() : String = {
        return this.file.getPath()
    }

    override def isAbsolute() : Boolean = {
        return this.file.isAbsolute()
    }

    override def getAbsolutePath() : String = {
        return this.file.getAbsolutePath()
    }

    def getAbsoluteFile() : Object = {
        return this.file.getAbsoluteFile()
    }

    override def getCanonicalPath() : String = {
        return this.file.getCanonicalPath()
    }

    def getCanonicalFile() : Object = {
        return this.file.getCanonicalFile()
    }

    /*    public URL toURL() throws MalformedURLException    {    return this.file.toURL();    }     */
    override def toURI() : URI = {
        return this.file.toURI()
    }

    override def canRead() : Boolean = {
        return this.file.canRead()
    }

    override def canWrite() : Boolean = {
        return this.file.canWrite()
    }

    override def exists() : Boolean = {
        return this.file.exists()
    }

    override def isDirectory() : Boolean = {
        return this.file.isDirectory()
    }

    override def isFile() : Boolean = {
        return this.file.isFile()
    }

    override def isHidden() : Boolean = {
        return this.file.isHidden()
    }

    override def lastModified() : Long = {
        return this.file.lastModified()
    }

    override def length() : Long = {
        return this.file.length()
    }

    override def createNewFile() : Boolean = {
        return this.file.createNewFile()
    }

    //TWB - GAE throws exception but java.io does not
    override def delete() : Boolean = {
        return this.file.delete()
    }

    override def deleteOnExit() : Unit = {
        this.file.deleteOnExit()
    }

    override def list() : Array[String] = {
        return this.file.list()
    }

    override def listWithFilter(filter : FilenameFilter) : Array[String] = {
        return this.file.list(filter)
    }

    def listFiles() : Array[Object] = {
        return this.file.listFiles().asInstanceOf[Array[Object]]
    }

    def listFilesFileNameFilter(filter : FilenameFilter) : Array[Object] = {
        return this.file.listFiles(filter).asInstanceOf[Array[Object]]
    }

    def listFilesFileFilter(filter : FileFilter) : Array[Object] = {
        return this.file.listFiles(filter).asInstanceOf[Array[Object]]
    }

    override def mkdir() : Boolean = {
        return this.file.mkdir()
    }

    override def mkdirs() : Boolean = {
        return this.file.mkdirs()
    }

    def renameTo(dest : AbFile) : Boolean = {
        return this.file.renameTo(dest.getFile())
    }

    override def setLastModified(time : Long) : Boolean = {
        return this.file.setLastModified(time)
    }

    override def setReadOnly() : Boolean = {
        return this.file.setReadOnly()
    }

    def setWritable(writable : Boolean, ownerOnly : Boolean) : Boolean = {
        return this.file.setExecutable(writable, ownerOnly)
    }

    def setWritable(writable : Boolean) : Boolean = {
        return this.file.setWritable(writable)
    }

    def setReadable(readable : Boolean, ownerOnly : Boolean) : Boolean = {
        return this.file.setReadable(readable, ownerOnly)
    }

    def setReadable(readable : Boolean) : Boolean = {
        return this.file.setReadable(readable)
    }

    def setExecutable(executable : Boolean, ownerOnly : Boolean) : Boolean = {
        return this.file.setExecutable(executable, ownerOnly)
    }

    def setExecutable(executable : Boolean) : Boolean = {
        return this.file.setExecutable(executable)
    }

    def canExecute() : Boolean = {
        return this.file.canExecute()
    }

    def getTotalSpace() : Long = {
        return this.file.getTotalSpace()
    }

    def getFreeSpace() : Long = {
        return this.file.getFreeSpace()
    }

    def getUsableSpace() : Long = {
        return this.file.getUsableSpace()
    }

    def compareTo(pathname : File) : Int = {
        return this.file.compareTo(pathname)
    }

    override def equals(param_obj : Any) : Boolean = {
        val obj : Object = param_obj.asInstanceOf[Object]
        return TsUtil.getInstance().equalsNotstring(this.file, obj)
    }

    override def hashCode() : Int = {
        return this.file.hashCode()
    }

    override def toString() : String = {
        return this.file.toString()
    }

}

object AbFile {
    val NULL_FILE : AbFile = AbFile.createAbFileFromRawPath(StringUtil.getInstance().EMPTY_STRING)

    def createAbFileWithChild(file : AbFile, childPathName : String) : AbFile = {
        return new AbFile(new File(file.getFile(), childPathName))
    }

    def createAbFile(filePath : String) : AbFile = {
        return new AbFile(new File(new AbPath(filePath, StringUtil.getInstance().EMPTY_STRING).toFileSystemString()))
    }

    def createAbFilePathAndName(filePath : String, fileName : String) : AbFile = {
        return new AbFile(new File(new AbPath(filePath, StringUtil.getInstance().EMPTY_STRING).toFileSystemString(), fileName))
    }

    def createAbFileFromAbPath(abPath : AbPath) : AbFile = {
        return new AbFile(new File(abPath.toFileSystemString()))
    }

    def createAbFileFromRawPath(filePath : String) : AbFile = {
        return new AbFile(new File(filePath))
    }

}


