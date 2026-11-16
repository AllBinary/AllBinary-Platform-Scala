/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.view

import _root_.org.allbinary.graphics.GPoint

class ViewPositionBase(param_x : Int, param_y : Int, param_z : Int) extends GPoint(param_x, param_y, param_z) {
    import _root_.org.allbinary.view.ViewPositionBase.{NULL_VIEW_POSITION as _, *}
    def NULL_VIEW_POSITION : ViewPositionBase = _root_.org.allbinary.view.ViewPositionBase.NULL_VIEW_POSITION

    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
    }

    def getX2() : Int = {
        return this.getX()
    }

    def getY2() : Int = {
        return this.getY()
    }

    def getZ2() : Int = {
        return this.getZ()
    }

    def setAllbinaryLayer(allbinaryLayer : Object) : Unit = {
    }

}

object ViewPositionBase {
    val NULL_VIEW_POSITION : ViewPositionBase = new ViewPositionBase(0, 0, 0)

}


