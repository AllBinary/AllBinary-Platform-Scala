/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.directory

import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.util.visitor.VisitorInterface

class DirectoryBooleanFileVisitor() extends VisitorInterface {

    def visit(anyType : Object) : Object = {
        return this.visit(anyType.asInstanceOf[AbFile]).asInstanceOf[Object]
    }

    def visit(file : AbFile) : _root_.java.lang.Boolean = {
        if (file.isDirectory()) {
            return _root_.java.lang.Boolean.TRUE
        }
        return _root_.java.lang.Boolean.FALSE
    }

}


