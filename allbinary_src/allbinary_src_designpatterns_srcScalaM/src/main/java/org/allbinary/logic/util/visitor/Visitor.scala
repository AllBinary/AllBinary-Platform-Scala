/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.visitor

import _root_.org.allbinary.logic.NullUtil

class Visitor extends VisitorInterface {
    import _root_.org.allbinary.logic.util.visitor.Visitor.{*}

    val nullUtil : NullUtil = NullUtil.getInstance()

    override def visit(anyType : Object) : Object = {
        return this.nullUtil.NULL_OBJECT
    }

}

object Visitor {
    private val instance : Visitor = new Visitor()

    def getInstance() : Visitor = {
        return Visitor.instance
    }

}


