/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource


class ResourceLoadingLevel(param_name : String, param_level : Int) {

    private var name : String = null

    private var level : Int = 0

    //Constructor
    {
        val name : String = param_name
        val level : Int = param_level
        this.name = name
        this.level = level
    }

    def getLevel() : Int = {
        return this.level
    }

    def getName() : String = {
        return this.name
    }

}


