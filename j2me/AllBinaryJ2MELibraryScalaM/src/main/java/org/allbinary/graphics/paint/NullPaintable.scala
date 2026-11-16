/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.paint


class NullPaintable private() extends Paintable {
    import _root_.org.allbinary.graphics.paint.NullPaintable.{*}

}

object NullPaintable {
    private val SINGLETON : NullPaintable = new NullPaintable()

    def getInstance() : Paintable = {
        return NullPaintable.SINGLETON
    }

}


