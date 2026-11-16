/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

/*  * These are imaginary inputs outside of J2ME Canvas keys.  */
class GameKey(param_key : Int, param_name : String) extends Input(param_key, param_name) {
    import _root_.org.allbinary.game.input.GameKey.{NULL_GAME_KEY as _, *}
    def NULL_GAME_KEY : GameKey = _root_.org.allbinary.game.input.GameKey.NULL_GAME_KEY

    //Constructor
    {
        val key : Int = param_key
        val name : String = param_name
    }

    override def toString() : String = {
        return new StringMaker().append("GameKey ").append(super.toString()).toString()
    }

}

object GameKey {
    val NULL_GAME_KEY : GameKey = new GameKey(-1, StringUtil.getInstance().NULL_STRING)

}


