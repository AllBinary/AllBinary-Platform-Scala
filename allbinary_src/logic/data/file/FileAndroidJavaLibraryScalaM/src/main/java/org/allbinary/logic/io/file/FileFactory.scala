/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file

import _root_.java.io.FileNotFoundException
import _root_.android.content.Context
import _root_.org.allbinary.data.resource.ResourceUtil

/**  *  * @author user  */
class FileFactory private(param_context : Context) {
    import _root_.org.allbinary.logic.io.file.FileFactory.{*}

    private var context : Context = null

    //Constructor
    {
        val context : Context = param_context
        this.context = context
    }

    def isFile(path : String) : Boolean = {
        try {
            //                //Some early Android devices do not give true for File checking even when file does exist
            this.context.openFileInput(path)
            //            }
            return true
        } catch {
            case e : FileNotFoundException => {
                return false
            }
        }
        throw new IllegalStateException()
    }

    /*     public boolean isFile(AbPath abPath) throws Exception     {         try         {             this.context.openFileInput(abPath.toFileSystemString());             return true;         }         catch (FileNotFoundException e)         {             return false;         }     }      public boolean isFile(String path) throws Exception     {         AbFile file = AbFile.createAbFile(path);         if (file.exists())         {             return true;         }         else         {             return false;         }     }         */
    def getContext() : Context = {
        return this.context
    }

    def getFile(filePath : String) : AbFile = {
        return AbFile.createAbFileFromRawPath(filePath)
    }

    def getInstance(file : AbFile, childFilePath : String) : AbFile = {
        return AbFile.createAbFileWithChild(file, childFilePath)
    }

}

object FileFactory {
    private val SINGLETON : FileFactory = new FileFactory(ResourceUtil.getInstance().getContext())

    def getInstance() : FileFactory = {
        return FileFactory.SINGLETON
    }

}


