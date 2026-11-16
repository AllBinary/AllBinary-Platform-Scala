/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path

import _root_.org.allbinary.logic.io.file.FilePathData
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

class AbPathData private() {
    import _root_.org.allbinary.logic.io.path.AbPathData.{*}

    val EXTENSION_SEP : String = CommonSeps.getInstance().PERIOD

    val SEPARATORCHAR : Char = '/'

    val SEPARATOR : String = CommonSeps.getInstance().FORWARD_SLASH

    def getExtensionIndex(filePath : String) : Int = {
        val indexOfFileExtensionDelmiter : Int = filePath.lastIndexOf(this.EXTENSION_SEP)
        val indexOfLatDelimiter : Int = filePath.lastIndexOf(this.SEPARATORCHAR)
        if (indexOfFileExtensionDelmiter < 0) {
            //throw new Exception("No File Extension for: " + filePath);
            return -1
        }
        if (indexOfFileExtensionDelmiter < indexOfLatDelimiter) {
            //throw new Exception("No File Extension for: " + filePath);
            return -1
        }
        /*       if(filePath.length() < indexOfFileExtensionDelmiter)       {          throw new Exception("Could not be a file path since its less than " + indexOfFileExtensionDelmiter + " characters");       }          */
        return indexOfFileExtensionDelmiter
    }

    def getExtensionWithDot(filePath : String) : String = {
        val indexOfFileExtensionDelmiter : Int = this.getExtensionIndex(filePath)
        var extension : String = StringUtil.getInstance().EMPTY_STRING
        if (indexOfFileExtensionDelmiter >= 0) {
            extension = filePath.substring(indexOfFileExtensionDelmiter)
        }
        return extension
    }

    def getExtension(filePath : String) : String = {
        val indexOfFileExtensionDelmiter : Int = this.getExtensionIndex(filePath)
        var extension : String = StringUtil.getInstance().EMPTY_STRING
        if (indexOfFileExtensionDelmiter >= 0) {
            extension = filePath.substring(indexOfFileExtensionDelmiter + 1)
        }
        /*         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))         {             PreLogUtil.put("FileExtension: " + extension, this, "getExtension()");         }          */
        return extension
    }

    def getNameFromPath(path : String) : String = {
        var endIndex : Int = path.lastIndexOf(this.SEPARATORCHAR)
        if (endIndex < 0) {
            endIndex = path.lastIndexOf(FilePathData.getInstance().SEPARATORCHAR)
        }
        if (endIndex < 0) {
            return path
        }
        //if the last char is sep then use the last token as the name
        if (path.length() == (endIndex + 1)) {
            var categoryName : String = path.substring(0, endIndex)
            return this.getNameFromPath(categoryName)
        } else {
            var categoryName : String = path.substring(endIndex + 1)
            return categoryName
        }
        throw new IllegalStateException()
    }

    //Do not update without checking the removeNameFromPath in PathUtil
    def removeNameFromPath(path : String) : String = {
        var endIndex : Int = path.lastIndexOf(this.SEPARATORCHAR)
        if (endIndex < 0) {
            endIndex = path.lastIndexOf(FilePathData.getInstance().SEPARATORCHAR)
        }
        if (endIndex < 0) {
            return StringUtil.getInstance().EMPTY_STRING
        }
        //if the last char is sep then use the last token as the name
        if (path.length() == (endIndex + 1)) {
            return this.removeNameFromPath(path.substring(0, endIndex - 1))
        } else {
            var pathWithoutName : String = path.substring(0, endIndex)
            return pathWithoutName
        }
        throw new IllegalStateException()
    }

}

object AbPathData {
    private val instance : AbPathData = new AbPathData()

    def getInstance() : AbPathData = {
        return AbPathData.instance
    }

}


