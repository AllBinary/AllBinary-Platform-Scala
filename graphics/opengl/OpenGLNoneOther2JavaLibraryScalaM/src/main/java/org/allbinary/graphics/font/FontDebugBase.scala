/* Generated Code Do Not Modify */
package org.allbinary.graphics.font

import _root_.javax.microedition.lcdui.Font
import _root_.org.allbinary.logic.string.StringMaker

//OpenGLNoneOther2JavaLibrary
class FontDebugBase {
    import _root_.org.allbinary.graphics.font.FontDebugBase.{*}

    val SET_FONT : String = "setFont"

    def debugMetrics(currentFont : Font, convertedTextSize : Float, displayMetrics : Object, stringBuffer : StringMaker) : Unit = {
    }

    def debugDpi(densityDpi : Int, stringBuffer : StringMaker) : Unit = {
    }

    def debugDimension(currentFont : Font, convertedTextSize : Float, longestDimensionTotalPixels : Int, stringBuffer : StringMaker) : Unit = {
    }

}

object FontDebugBase {
    private val instanceBase : FontDebugBase = new FontDebugBase()

    /**      * @return the instance      */
    def getInstance() : FontDebugBase = {
        return FontDebugBase.instanceBase
    }

}


