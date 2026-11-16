/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.java.io.File
import _root_.java.io.FileFilter
import _root_.org.allbinary.logic.util.visitor.VisitorInterface

class DirectoryFileVisitor() extends VisitorInterface with FileFilter {

    def accept(arg0 : _root_.java.io.File) : Boolean = {
        return (this.visit(arg0.asInstanceOf[Object]).asInstanceOf[_root_.java.lang.Boolean]).booleanValue()
    }

    def visit(anyType : Object) : Object = {
        var file : File = anyType.asInstanceOf[File]
        var index : Int = 1
        var aFile : File = file.getParentFile()

        {
            while (({ aFile = aFile.getParentFile(); aFile }) != null) {
                index += 1
            }
        }
        if (file.isDirectory() && (index < 5)) {
            return _root_.java.lang.Boolean.TRUE
        }
        return _root_.java.lang.Boolean.FALSE
    }

}


