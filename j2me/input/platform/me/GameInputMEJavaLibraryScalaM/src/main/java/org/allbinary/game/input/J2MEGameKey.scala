/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class J2MEGameKey(param_key : Int, param_keyName : String) extends Input(param_key, param_keyName) {
    import _root_.org.allbinary.game.input.J2MEGameKey.{*}

    //Constructor
    {
        val key : Int = param_key
        val keyName : String = param_keyName
        var id : Int = this.getId()
        if (id >= 0) {
            val inputFactory : InputFactory = InputFactory.getInstance()
            inputFactory.add(id, this)
        }
    }

    override def toString() : String = {
        return new StringMaker().append("J2MEGameKey: ").append(super.toString()).toString()
    }

}

object J2MEGameKey {
    def getString(keyCode : Int) : String = {
        var input : Input = InputFactory.getInstance().getInstanceById(keyCode)
        if (input != null) {
            return input.getName()
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

}


