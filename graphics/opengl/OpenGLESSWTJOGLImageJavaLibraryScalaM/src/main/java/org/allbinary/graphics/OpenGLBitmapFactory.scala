/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.ImageFactory
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase

/**  *  * @author User  */
class OpenGLBitmapFactory extends PlatformBitmapBaseFactory {
    import _root_.org.allbinary.graphics.OpenGLBitmapFactory.{*}

    val ARGB_8888 : OpenGLBitmapConfig = new OpenGLBitmapConfig(null)

    def createBitmap(width : Int, height : Int, config : OpenGLBitmapConfig) : OpenGLBitmap = {
        //return new OpenGLBitmap(Image.createRGBImage(new int[width * height], width, height, true));
        return new OpenGLBitmap(Image.createImage(width, height))
    }

    def decodeStream(inputStream : InputStream) : OpenGLBitmap = {
        return new OpenGLBitmap(ImageFactory.getInstance().createImageFromInputStream(inputStream))
    }

    override def createBitmap(image : Image) : PlatformBitmapBase = {
        return new OpenGLBitmap(image)
    }

}

object OpenGLBitmapFactory {
    private val instance : OpenGLBitmapFactory = new OpenGLBitmapFactory()

    /**      * @return the instance      */
    def getInstance() : OpenGLBitmapFactory = {
        return OpenGLBitmapFactory.instance
    }

}


