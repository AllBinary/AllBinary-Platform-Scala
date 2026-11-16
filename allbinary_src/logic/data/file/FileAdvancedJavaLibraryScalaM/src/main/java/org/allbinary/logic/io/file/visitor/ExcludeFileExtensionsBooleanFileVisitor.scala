/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.visitor

import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.util.BasicArrayList

class ExcludeFileExtensionsBooleanFileVisitor(param_filterStringBasicArrayList : BasicArrayList) extends BooleanFileVisitor(param_filterStringBasicArrayList) {

    //Constructor
    {
        val filterStringBasicArrayList : BasicArrayList = param_filterStringBasicArrayList
    }

    override def visit(file : AbFile) : _root_.java.lang.Boolean = {
        if (this.getFilterStringBasicArrayList().size() == 0) {
            return _root_.java.lang.Boolean.TRUE
        }
        return super.visit(file)
    }

    override def visit(file : AbFile, fileNameString : String) : _root_.java.lang.Boolean = {
        var fileNameAndExtension : String = file.getPath()
        if (fileNameAndExtension.length() > fileNameString.length()) {
            var startIndex : Int = fileNameAndExtension.length() - fileNameString.length()
            var fileName : String = fileNameAndExtension.substring(startIndex)
            if (fileName.compareTo(fileNameString) == 0) {
                return _root_.java.lang.Boolean.FALSE
            }
        }
        return _root_.java.lang.Boolean.TRUE
    }

}


