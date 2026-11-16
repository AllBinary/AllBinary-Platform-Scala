/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game

import _root_.org.allbinary.logic.string.StringUtil

class GameMode private(param_name : String) {
    import _root_.org.allbinary.game.GameMode.{*}

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        val name : String = param_name
        this.setName(name)
    }

    private def setName(name : String) : Unit = {
        this.name = name
    }

    def getName() : String = {
        return this.name
    }

    override def toString() : String = {
        return this.getName()
    }

}

object GameMode {
    var NONE : GameMode = new GameMode(StringUtil.getInstance().NULL_STRING)

    var SERVER : GameMode = new GameMode("Server")

    var CLIENT : GameMode = new GameMode("Client")

}


