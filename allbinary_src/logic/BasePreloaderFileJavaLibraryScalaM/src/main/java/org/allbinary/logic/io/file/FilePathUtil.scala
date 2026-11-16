/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringValidationUtil

//Used to correct user input for paths
class FilePathUtil private() {
    import _root_.org.allbinary.logic.io.file.FilePathUtil.{*}

}

object FilePathUtil {
    /*    public static boolean isValid(String path)    {       if(FilePathUtil.isValidStart(path))       {          if(FilePathUtil.isValidEnd(path))          {             return true;          }       }       return false;    }     private static boolean isValidStart(String path)    {       //FilePathData.SEPARATORCHAR       if(path.charAt(0) == FilePathData.SEPARATORCHAR)       {          return true;       }       else       {          return false;       }    }     private static boolean isValidEnd(String path)    {       if(StringValidationUtil.isEmpty(path))       {          return false;       }        //FilePathData.SEPARATORCHAR       if(path.charAt(path.length()-1) == FilePathData.SEPARATORCHAR)       {          return true;       }       else       {          return false;       }    }    */
    def adjust(param_path : String) : String = {
        var path : String = param_path
        val abPathData : AbPathData = AbPathData.getInstance()
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        val filePathData : FilePathData = FilePathData.getInstance()
        if (stringValidationUtil.isEmpty(path)) {
            //FilePathData.
            return filePathData.PATH_START
        }
        //PreLogUtil.put("Adjusting Path: " + path, "FilePathUtil", "adjust");
        path = path.replace(abPathData.SEPARATORCHAR, filePathData.SEPARATORCHAR)
        /*       if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().FILE))       {          PreLogUtil.put("Path: " + path, "PathUtil", "adjust");       }       */
        return path
    }

}


