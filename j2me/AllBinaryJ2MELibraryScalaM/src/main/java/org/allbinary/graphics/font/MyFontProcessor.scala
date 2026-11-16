/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.font

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics

/**  *  * @author User  */
class MyFontProcessor {
    import _root_.org.allbinary.graphics.font.MyFontProcessor.{*}

    def process(graphics : Graphics) : Unit = {
    }

}

object MyFontProcessor {
    def defaultCharWidth(font : Font) : Int = {
        return font.charWidth('C')
    }

    def defaultStringWidth(font : Font, size : Int) : Int = {
        return MyFontProcessor.defaultCharWidth(font) * size
    }

    private val instance : MyFontProcessor = new MyFontProcessor()

    /**      * @return the instance      */
    def getInstance() : MyFontProcessor = {
        return MyFontProcessor.instance
    }

}


