/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class Input(param_id : Int, param_name : String) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var id : Int = 0

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val id : Int = param_id
        val name : String = param_name
        this.setId(id)
        this.setName(name)
    }

    def getId() : Int = {
        return this.id
    }

    private def setId(key : Int) : Unit = {
        this.id = key
    }

    def getName() : String = {
        return this.name
    }

    private def setName(keyName : String) : Unit = {
        this.name = keyName
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Name: ")
        stringBuffer.append(this.getName())
        stringBuffer.append(" Id: ")
        stringBuffer.appendint(this.getId())
        return stringBuffer.toString()
    }

}


