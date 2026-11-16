/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.logic.string.StringUtil

class PlayerType(param_name : String, param_value : Int) {

    private var id : Int = 0

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val name : String = param_name
        val value : Int = param_value
        this.name = name
        this.id = value
    }

    //    }
    def getId() : Int = {
        return this.id
    }

    //    }
    def getName() : String = {
        return this.name
    }

    override def toString() : String = {
        return this.getName()
    }

}


