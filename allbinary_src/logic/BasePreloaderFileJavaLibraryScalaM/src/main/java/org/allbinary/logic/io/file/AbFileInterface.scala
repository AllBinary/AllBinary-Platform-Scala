/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.FilenameFilter
import _root_.java.io.IOException
import _root_.java.net.URI

/**  *  * @author user  */
trait AbFileInterface {

    //boolean canExecute();
    def canRead() : Boolean

    def canWrite() : Boolean

    def createNewFile() : Boolean

    def delete() : Boolean

    def deleteOnExit() : Unit

    //boolean equals(Object obj);
    def exists() : Boolean

    def getAbsolutePath() : String

    def getCanonicalPath() : String

    //String getName();
    def getParent() : String

    def getPath() : String

    //int hashCode();
    def isAbsolute() : Boolean

    def isDirectory() : Boolean

    def isFile() : Boolean

    def isHidden() : Boolean

    def lastModified() : Long

    def length() : Long

    def list() : Array[String]

    def listWithFilter(filter : FilenameFilter) : Array[String]

    def mkdir() : Boolean

    def mkdirs() : Boolean

    //boolean setExecutable(boolean executable);
    def setLastModified(time : Long) : Boolean

    def setReadOnly() : Boolean

    //boolean setWritable(boolean writable);
    override def toString() : String

    def toURI() : URI

}


