/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.font

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics

/**  *  * @author User  */
class FontDebugFactory {
    import _root_.org.allbinary.graphics.font.FontDebugFactory.{*}

    def setFont(font : Font, graphics : Graphics) : Unit = {
        graphics.setFont(font)
    }

}

object FontDebugFactory {
    private val instance : FontDebugFactory = new FontDebugFactory()

    /**      * @return the instance      */
    def getInstance() : FontDebugFactory = {
        return FontDebugFactory.instance
    }

}


