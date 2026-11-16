/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.view


class StaticViewPosition(param_x : Int, param_y : Int, param_z : Int) extends ViewPosition(param_x, param_y, param_z) {

    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
    }

    override def getX() : Int = {
        return this.getRawX()
    }

    override def getY() : Int = {
        return this.getRawY()
    }

    override def getZ() : Int = {
        return this.getRawZ()
    }

}


