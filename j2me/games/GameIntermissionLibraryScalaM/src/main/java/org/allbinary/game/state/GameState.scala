/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.state


class GameState(param_name : String, param_state : Int) {

    private var name : String = null

    //private int state;
    //Constructor
    {
        val name : String = param_name
        val state : Int = param_state
        this.name = name
    }

    override def toString() : String = {
        return this.name
    }

}


