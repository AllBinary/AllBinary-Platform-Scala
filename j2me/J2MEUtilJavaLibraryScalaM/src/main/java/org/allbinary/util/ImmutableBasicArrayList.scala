/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.util

import _root_.jsinterop.annotations.JsType
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil

@JsType
class ImmutableBasicArrayList(param_name : String, param_size : Int) extends BasicArrayListS(param_size) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        val size : Int = param_size
        this.name = name
    }

    override def add(e : Object) : Boolean = {
        ForcedLogUtil.log(this.name, this)
        return true
    }

    override def addAt(index : Int, element : Object) : Unit = {
        ForcedLogUtil.log(this.name, this)
    }

    override def toString() : String = {
        return this.name
    }

}


