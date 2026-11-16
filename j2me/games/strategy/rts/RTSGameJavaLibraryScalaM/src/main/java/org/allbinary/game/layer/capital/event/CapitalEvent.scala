/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.capital.event

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class CapitalEvent(param_anyType : Object) extends AllBinaryEventObject(param_anyType) {

    private var value : Int = 0

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("CapitalEvent: Value: \n")
        stringBuffer.appendint(this.getValue())
        return stringBuffer.toString()
    }

    /**      * @return the value      */
    def getValue() : Int = {
        return this.value
    }

    /**      * @param value the value to set      */
    def setValue(value : Int) : Unit = {
        this.value = value
    }

}


