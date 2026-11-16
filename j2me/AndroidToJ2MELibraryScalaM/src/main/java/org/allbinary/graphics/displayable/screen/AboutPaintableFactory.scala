/* * AllBinary Open License Version 1 * Copyright (c) 2022 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable

/**  *  * @author User  */
class AboutPaintableFactory {
    import _root_.org.allbinary.graphics.displayable.screen.AboutPaintableFactory.{*}

    var paintableArray : Array[Paintable] = Array[Paintable](NullPaintable.getInstance())

}

object AboutPaintableFactory {
    private val instance : AboutPaintableFactory = new AboutPaintableFactory()

    /**      * @return the instance      */
    def getInstance() : AboutPaintableFactory = {
        return AboutPaintableFactory.instance
    }

}


