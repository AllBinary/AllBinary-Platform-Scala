/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas


/**  *  * @author user  */
class IntegerDimension(param_width : Int, param_height : Int) {

    private var width : Int = 0

    private var height : Int = 0

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        this.setWidth(width)
        this.setHeight(height)
    }

    def getWidth() : Int = {
        return this.width
    }

    def setWidth(width : Int) : Unit = {
        this.width = width
    }

    def getHeight() : Int = {
        return this.height
    }

    def setHeight(height : Int) : Unit = {
        this.height = height
    }

}


