/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.android.graphics.Bitmap
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase

/**  *  * @author User  */
class OpenGLBitmap(param_bitmap : Object) extends PlatformBitmapBase {

    var bitmap : Bitmap = null

    //Constructor
    {
        val bitmap : Object = param_bitmap
        this.bitmap = bitmap.asInstanceOf[Bitmap]
    }

    def getPixels(pixels : Array[Int], offset : Int, stride : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        this.bitmap.getPixels(pixels, offset, stride, x, y, width, height)
    }

    def setPixels(pixels : Array[Int], offset : Int, stride : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        this.bitmap.setPixels(pixels, offset, stride, x, y, width, height)
    }

    override def getWidth() : Int = {
        return this.bitmap.getWidth()
    }

    override def getHeight() : Int = {
        return this.bitmap.getHeight()
    }

    def recycle() : Unit = {
        this.bitmap.recycle()
    }

}


