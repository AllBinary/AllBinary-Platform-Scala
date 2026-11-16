/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.file.visitor

import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.util.visitor.VisitorInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class BooleanFileVisitor(param_filterStringBasicArrayList : BasicArrayList) extends VisitorInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var filterStringBasicArrayList : BasicArrayList = null

    //Constructor
    {
        val filterStringBasicArrayList : BasicArrayList = param_filterStringBasicArrayList
        this.setFilterStringBasicArrayList(filterStringBasicArrayList)
        PreLogUtil.put("Filter BasicArrayList: " + this.getFilterStringBasicArrayList().toString(), this, this.commonStrings.CONSTRUCTOR)
    }

    override def visit(anyType : Object) : Object = {
        return this.visit(anyType.asInstanceOf[AbFile]).asInstanceOf[Object]
    }

    def visit(file : AbFile) : _root_.java.lang.Boolean = {
        val list : BasicArrayList = this.getFilterStringBasicArrayList()
        val size : Int = list.size()
        var nextFileFilterString : String = null

        {
            var index : Int = 0
            while (index < size) {
                nextFileFilterString = list.get(index).asInstanceOf[String]
                if (this.visit(file, nextFileFilterString).booleanValue()) {
                    return _root_.java.lang.Boolean.TRUE
                }
                index += 1
            }
        }
        return _root_.java.lang.Boolean.FALSE
    }

    def getFilterStringBasicArrayList() : BasicArrayList = {
        return this.filterStringBasicArrayList
    }

    def setFilterStringBasicArrayList(filterStringBasicArrayList : BasicArrayList) : Unit = {
        this.filterStringBasicArrayList = filterStringBasicArrayList
    }

    def visit(file : AbFile, fileNameString : String) : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.FALSE
    }

}


