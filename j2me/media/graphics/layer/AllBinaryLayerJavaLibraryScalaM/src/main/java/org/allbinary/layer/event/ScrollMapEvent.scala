/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class ScrollMapEvent(param_anyType : Object) extends AllBinaryEventObject(param_anyType) {

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val anyType : Object = param_anyType
    }

    def setDx(dx : Int) : Unit = {
        this.dx = dx
    }

    def getDx() : Int = {
        return this.dx
    }

    def setDy(dy : Int) : Unit = {
        this.dy = dy
    }

    def getDy() : Int = {
        return this.dy
    }

    def setDxDy(dx : Int, dy : Int) : Unit = {
        this.dx = dx
        this.dy = dy
    }

}


