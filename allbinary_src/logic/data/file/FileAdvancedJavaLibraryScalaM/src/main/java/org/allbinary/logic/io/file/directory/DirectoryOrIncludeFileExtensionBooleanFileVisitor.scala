/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.visitor.IncludeFileExtensionsBooleanFileVisitor
import _root_.org.allbinary.util.BasicArrayList

class DirectoryOrIncludeFileExtensionBooleanFileVisitor private (super_1 : BasicArrayList, constructor_ : Unit) extends IncludeFileExtensionsBooleanFileVisitor(super_1) {

    private var includesString : String = null

    def this(filterStringBasicArrayList : BasicArrayList, includesString : String) = {
        this(filterStringBasicArrayList, ())
        this.includesString = includesString
    }

    def this(filterStringBasicArrayList : BasicArrayList) = {
        this(filterStringBasicArrayList, ())
        this.includesString = null
    }

    override def visit(file : AbFile) : _root_.java.lang.Boolean = {
        if (file.isDirectory()) {
            return _root_.java.lang.Boolean.TRUE
        }
        if ((this.includesString == null) || (file.getAbsolutePath().indexOf(this.includesString) >= 0)) {
            return super.visit(file)
        } else {
            return _root_.java.lang.Boolean.FALSE
        }
        throw new IllegalStateException()
    }

}


