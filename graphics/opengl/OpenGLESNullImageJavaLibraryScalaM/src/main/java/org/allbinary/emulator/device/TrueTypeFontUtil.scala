/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.device

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.image.opengles.OpenGLESImage

class TrueTypeFontUtil private() extends TrueTypeFontUtilBase(1) {
    import _root_.org.allbinary.emulator.device.TrueTypeFontUtil.{*}

    var fontImage : OpenGLESImage = OpenGLESImage.NULL_OPENGL_IMAGE

    override def getAsTextureSize(textureSize : Int) : Int = {
        throw new RuntimeException()
    }

    override def getCellSize(cellSize : Int) : Int = {
        throw new RuntimeException()
    }

    def getFontBitmap(filename : String, fontSize : Int, cellSize : Int, basicColor : BasicColor) : Image = {
        throw new RuntimeException()
    }

    //This is only called from OpenGLES on Android via OpenGLESStrings
    def saveFontAtlasAsFile() : Unit = {
    }

    def getFontBitmapGL(gl : GL10, filename : String, cellSize : Int, basicColor : BasicColor) : Image = {
        throw new RuntimeException()
    }

    def getFontWidths(filename : String, fontSize : Int) : Array[Int] = {
        throw new RuntimeException()
    }

}

object TrueTypeFontUtil {
    private val instance : TrueTypeFontUtil = new TrueTypeFontUtil()

    def getInstance() : TrueTypeFontUtil = {
        return TrueTypeFontUtil.instance
    }

}


