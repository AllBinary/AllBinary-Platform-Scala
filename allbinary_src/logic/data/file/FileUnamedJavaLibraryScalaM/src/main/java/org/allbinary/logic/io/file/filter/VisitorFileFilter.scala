/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.filter

import _root_.java.io.File
import _root_.java.io.FileFilter
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.logic.util.visitor.VisitorInterface

class VisitorFileFilter(param_booleanVisitorInterface : VisitorInterface) extends FileFilter {

    private var booleanVisitorInterface : VisitorInterface = null

    //Constructor
    {
        val booleanVisitorInterface : VisitorInterface = param_booleanVisitorInterface
        this.booleanVisitorInterface = booleanVisitorInterface
    }

    def accept(file : File) : Boolean = {
        //System.out.println("File Path: " + file.getPath());
        var abFile : AbFile = FileWrapperUtil.wrapFile(file)
        var isFileAcceptable : Boolean = (this.booleanVisitorInterface.visit(abFile).asInstanceOf[_root_.java.lang.Boolean]).booleanValue()
        //System.out.println("End Accept");
        return isFileAcceptable || file.isDirectory()
    }

    def accept(file : AbFile) : Boolean = {
        //System.out.println("File Path: " + file.getPath());
        var isFileAcceptable : Boolean = (this.booleanVisitorInterface.visit(file).asInstanceOf[_root_.java.lang.Boolean]).booleanValue()
        //System.out.println("End Accept");
        return isFileAcceptable || file.isDirectory()
    }

}


