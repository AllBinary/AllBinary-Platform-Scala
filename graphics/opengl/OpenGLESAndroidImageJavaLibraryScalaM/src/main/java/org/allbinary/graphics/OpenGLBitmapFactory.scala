/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.android.graphics.Bitmap
import _root_.android.graphics.BitmapFactory
import _root_.java.io.IOException
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase
import _root_.org.microemu.android.device.AndroidImageInterface

/**  *  * @author User  */
class OpenGLBitmapFactory extends PlatformBitmapBaseFactory {
    import _root_.org.allbinary.graphics.OpenGLBitmapFactory.{*}

    val ARGB_8888 : OpenGLBitmapConfig = new OpenGLBitmapConfig(Bitmap.Config.ARGB_8888)

    def createBitmap(width : Int, height : Int, config : OpenGLBitmapConfig) : OpenGLBitmap = {
        return new OpenGLBitmap(Bitmap.createBitmap(width, height, config.bitmapConfig))
    }

    def decodeStream(inputStream : InputStream) : OpenGLBitmap = {
        return new OpenGLBitmap(BitmapFactory.decodeStream(inputStream))
    }

    override def createBitmap(image : Image) : PlatformBitmapBase = {
        return new OpenGLBitmap((image.asInstanceOf[AndroidImageInterface]).getBitmap())
    }

}

object OpenGLBitmapFactory {
    private val instance : OpenGLBitmapFactory = new OpenGLBitmapFactory()

    /**      * @return the instance      */
    def getInstance() : OpenGLBitmapFactory = {
        return OpenGLBitmapFactory.instance
    }

}


