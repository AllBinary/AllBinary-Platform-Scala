/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase
import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory

/**  *  * @author User  */
class OpenGLBitmapFactory extends PlatformBitmapBaseFactory {
    import _root_.org.allbinary.graphics.OpenGLBitmapFactory.{*}

    val ARGB_8888 : OpenGLBitmapConfig = new OpenGLBitmapConfig(NullUtil.getInstance().NULL_OBJECT)

    def createBitmap(width : Int, height : Int, config : OpenGLBitmapConfig) : OpenGLBitmap = {
        return new OpenGLBitmap(NullUtil.getInstance().NULL_OBJECT)
    }

    def decodeStream(inputStream : InputStream) : OpenGLBitmap = {
        return new OpenGLBitmap(NullUtil.getInstance().NULL_OBJECT)
    }

    override def createBitmap(image : Image) : PlatformBitmapBase = {
        return new OpenGLBitmap(NullUtil.getInstance().NULL_OBJECT)
    }

}

object OpenGLBitmapFactory {
    private val instance : OpenGLBitmapFactory = new OpenGLBitmapFactory()

    /**      * @return the instance      */
    def getInstance() : OpenGLBitmapFactory = {
        return OpenGLBitmapFactory.instance
    }

}


