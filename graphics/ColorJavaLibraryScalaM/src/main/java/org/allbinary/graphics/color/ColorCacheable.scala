/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.java.awt.*
import _root_.org.allbinary.logic.util.cache.CacheableInterface

class ColorCacheable(param_key : Object) extends CacheableInterface {

    private var key : Object = null

    private var color : Color = null

    //Constructor
    {
        val key : Object = param_key
        this.key = key
        this.color = new Color((key.asInstanceOf[Integer]).intValue())
    }

    def getKey() : Object = {
        return this.key
    }

    def getColor() : Color = {
        return this.color
    }

    def setColor(color : Color) : Unit = {
        this.color = color
    }

}


