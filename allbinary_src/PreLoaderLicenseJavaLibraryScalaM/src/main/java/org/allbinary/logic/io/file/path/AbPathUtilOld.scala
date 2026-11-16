/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.path

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.io.path.AbFilePath
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil

//Used to correct user input for paths
class AbPathUtilOld private() {
    import _root_.org.allbinary.logic.io.file.path.AbPathUtilOld.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val abPathData : AbPathData = AbPathData.getInstance()

    private val filePathData : FilePathData = FilePathData.getInstance()

    def getExtension(abFilePath : AbFilePath) : String = {
        return this.getExtension(abFilePath.toString())
    }

    def getExtension(abPath : AbPath) : String = {
        return this.getExtension(abPath.toString())
    }

    def getExtension(filePath : String) : String = {
        if (filePath.length() < AbPathUtilOld.MIN) {
            //assuming the extension is 3 characters with a seperator
            throw new Exception("Could not be a file path since its less that 4 characters")
        }
        var beginIndex : Int = filePath.length() - AbPathUtilOld.MIN
        var extension : String = filePath.substring(beginIndex + 1)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("FileExtension: " + extension, this, "getExtension()")
        }
        return extension
    }

    def getWithoutExtension(abFilePath : AbFilePath) : String = {
        return this.getWithoutExtension(abFilePath.toString())
    }

    def getWithoutExtension(abPath : AbPath) : String = {
        return this.getWithoutExtension(abPath.toString())
    }

    def getWithoutExtension(filePath : String) : String = {
        if (filePath.length() < AbPathUtilOld.MIN) {
            //assuming the extension is 3 characters with a seperator
            throw new Exception("Could not be a file path since its less that 4 characters")
        }
        var endIndex : Int = filePath.length() - AbPathUtilOld.MIN
        var pathWithoutExtension : String = filePath.substring(0, endIndex)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("FileWithoutExtension: " + pathWithoutExtension, this, "getWithoutExtension()")
        }
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
        if (path.charAt(0) == this.abPathData.SEPARATORCHAR) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    private def isValidEnd(path : String) : Boolean = {
        if (StringValidationUtil.getInstance().isEmpty(path)) {
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
        if (StringValidationUtil.getInstance().isEmpty(path)) {
            return this.abPathData.SEPARATOR
        }
        //Convert \ to / I.E. from dos/windows file path to uri/unix path
        if (path.indexOf("\\") >= 0) {
            path = path.replace('\\', this.abPathData.SEPARATORCHAR)
        }
        /*       if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().FILE))       {          this.logUtil.putF("Path: " + path, this, "adjust");       }        */
        return path
    }

    def getNameFromPath(categoryPath : String) : String = this.synchronized {
        var endIndex : Int = categoryPath.lastIndexOf(this.abPathData.SEPARATOR)
        if (endIndex < 0) {
            endIndex = categoryPath.lastIndexOf(this.filePathData.SEPARATORCHAR)
        }
        if (endIndex < 0) {
            return categoryPath
        }
        //if the last char is sep then use the last token as the name
        if (categoryPath.length() == (endIndex + 1)) {
            var categoryName : String = categoryPath.substring(0, endIndex)
            return this.getNameFromPath(categoryName)
        } else {
            var categoryName : String = categoryPath.substring(endIndex + 1)
            return categoryName
        }
        throw new IllegalStateException()
    }

    def removeNameFromPath(categoryPath : String) : AbPath = this.synchronized {
        var endIndex : Int = categoryPath.lastIndexOf(this.abPathData.SEPARATOR)
        if (endIndex < 0) {
            endIndex = categoryPath.lastIndexOf(this.filePathData.SEPARATORCHAR)
        }
        if (endIndex < 0) {
            return AbPath.createAbPath()
        }
        //if the last char is sep then use the last token as the name
        if (categoryPath.length() == (endIndex + 1)) {
            return this.removeNameFromPath(categoryPath.substring(0, endIndex - 1))
        } else {
            var categoryName : String = categoryPath.substring(0, endIndex)
            return new AbPath(categoryName, StringUtil.getInstance().EMPTY_STRING)
        }
        throw new IllegalStateException()
    }

}

object AbPathUtilOld {
    private val instance : AbPathUtilOld = new AbPathUtilOld()

    def getInstance() : AbPathUtilOld = {
        return AbPathUtilOld.instance
    }

    private val MIN : Int = 4

}


