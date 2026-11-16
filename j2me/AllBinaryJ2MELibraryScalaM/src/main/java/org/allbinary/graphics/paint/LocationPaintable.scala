/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint

import _root_.javax.microedition.lcdui.Graphics

/**  *  * @author user  */
class LocationPaintable extends LocationPaintableInterface {
    import _root_.org.allbinary.graphics.paint.LocationPaintable.{*}

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

}

object LocationPaintable {
    private val instance : LocationPaintable = new LocationPaintable()

    /**      * @return the instance      */
    def getInstance() : LocationPaintable = {
        return LocationPaintable.instance
    }

}


