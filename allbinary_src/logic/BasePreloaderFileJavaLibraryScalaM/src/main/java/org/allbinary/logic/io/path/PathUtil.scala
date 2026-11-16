/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path

import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil

//Used to correct user input for paths
class PathUtil private() {
    import _root_.org.allbinary.logic.io.path.PathUtil.{*}

    private val abPathData : AbPathData = AbPathData.getInstance()

    private val filePathData : FilePathData = FilePathData.getInstance()

    def getExtensionWithAbFilePath(abFilePath : AbFilePath) : String = {
        return this.abPathData.getExtension(abFilePath.toString())
    }

    def getExtensionWithAbPath(abPath : AbPath) : String = {
        return this.abPathData.getExtension(abPath.toString())
    }

    def getWithoutExtensionWithAbFilePath(abFilePath : AbFilePath) : String = {
        return this.getWithoutExtension(abFilePath.toString())
    }

    def getWithoutExtensionWithAbPath(abPath : AbPath) : String = {
        return this.getWithoutExtension(abPath.toString())
    }

    def getWithoutExtension(filePath : String) : String = {
        var indexOfFileExtensionDelmiter : Int = this.abPathData.getExtensionIndex(filePath)
        //No extension by default
        var pathWithoutExtension : String = filePath
        if (indexOfFileExtensionDelmiter >= 0) {
            pathWithoutExtension = filePath.substring(0, indexOfFileExtensionDelmiter)
        }
        /*         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))         {             PreLogUtil.put("FileWithoutExtension: " + pathWithoutExtension, this, "getWithoutExtension()");         }         */
        return pathWithoutExtension
    }

    def isValid(path : String) : Boolean = {
        if (this.isValidStart(path)) {
            if (this.isValidEnd(path)) {
                return true
            }
        }
        return false
    }

    private def isValidStart(path : String) : Boolean = {
        if ((path.charAt(0) == this.abPathData.SEPARATORCHAR) || (path.charAt(0) == '.')) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    private def isValidEnd(path : String) : Boolean = {
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(path)) {
            return false
        }
        if (path.charAt(path.length() - 1) == this.abPathData.SEPARATORCHAR) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def adjustStart(param_path : String) : String = {
        var path : String = param_path
        if (!this.isValidStart(path)) {
            path = this.abPathData.SEPARATOR + path
        }
        return path
    }

    def adjustEnd(param_path : String) : String = {
        var path : String = param_path
        if (!this.isValidEnd(path)) {
            path = path + this.abPathData.SEPARATOR
        }
        return path
    }

    def adjust(param_path : String) : String = {
        var path : String = param_path
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(path)) {
            return this.abPathData.SEPARATOR
        }
        //Convert \ to / I.E. from dos/windows file path to uri/unix path
        if (path.indexOf("\\") >= 0) {
            //PreLogUtil.put("Adjusting Path: " + path, this, "adjust");
            path = path.replace('\\', this.abPathData.SEPARATORCHAR)
        }
        /*         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().FILE))         {             PreLogUtil.put("Path: " + path, this, "adjust");         }         */
        return path
    }

    //Do not update without checking the removeNameFromPath in AbPathData
    def removeNameFromPath(path : String) : AbPath = {
        var endIndex : Int = path.lastIndexOf(this.abPathData.SEPARATOR)
        if (endIndex < 0) {
            endIndex = path.lastIndexOf(this.filePathData.SEPARATORCHAR)
        }
        if (endIndex < 0) {
            return AbPath.createAbPath()
        }
        //if the last char is sep then use the last token as the name
        if (path.length() == (endIndex + 1)) {
            return this.removeNameFromPath(path.substring(0, endIndex - 1))
        } else {
            val pathWithoutName : String = path.substring(0, endIndex)
            return new AbPath(pathWithoutName, StringUtil.getInstance().EMPTY_STRING)
        }
        throw new IllegalStateException()
    }

}

object PathUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : PathUtil = new PathUtil()

    def getInstance() : PathUtil = {
        return PathUtil.instance
    }

}


