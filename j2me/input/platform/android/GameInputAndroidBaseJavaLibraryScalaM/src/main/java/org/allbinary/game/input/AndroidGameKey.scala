/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.string.StringUtil

class AndroidGameKey(param_keyCode : Int, param_name : String) extends Input(param_keyCode, param_name) {
    import _root_.org.allbinary.game.input.AndroidGameKey.{*}

    //Constructor
    {
        val keyCode : Int = param_keyCode
        val name : String = param_name
        val inputFactory : InputFactory = InputFactory.getInstance()
        inputFactory.inputIntegerArray(this.getId()) = this
    }

    override def toString() : String = {
        return "AndroidGameKey: " + super.toString()
    }

}

object AndroidGameKey {
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


