/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image


class ImageUnifierCell(param_width : Integer, param_height : Integer) {

    private var width : Integer = null

    private var height : Integer = null

    //Constructor
    {
        val width : Integer = param_width
        val height : Integer = param_height
        this.setWidth(width)
        this.setHeight(height)
    }

    def getWidth() : Integer = {
        return this.width
    }

    def setWidth(width : Integer) : Unit = {
        this.width = width
    }

    def getHeight() : Integer = {
        return this.height
    }

    def setHeight(height : Integer) : Unit = {
        this.height = height
    }

}


