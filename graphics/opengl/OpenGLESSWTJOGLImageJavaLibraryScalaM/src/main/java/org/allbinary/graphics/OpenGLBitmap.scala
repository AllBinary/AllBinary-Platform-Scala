/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.DisposalUtil
import _root_.org.allbinary.platform.graphics.PlatformBitmapBase
import _root_.org.microemu.device.swt.SwtImmutableImage
import _root_.org.microemu.device.swt.SwtMutableImage

/**  *  * @author User  */
class OpenGLBitmap(param_bitmap : Object) extends PlatformBitmapBase {

    var image : Image = null

    //Constructor
    {
        val bitmap : Object = param_bitmap
        this.image = bitmap.asInstanceOf[Image]
    }

    override def getImage() : Image = {
        return this.image
    }

    def getDepth() : Int = {
        if (this.image.isMutable()) {
            val mutableImage : SwtMutableImage = this.image.asInstanceOf[SwtMutableImage]
            return mutableImage.getDepth()
        } else {
            val immutableImage : SwtImmutableImage = this.image.asInstanceOf[SwtImmutableImage]
            return immutableImage.getDepth()
        }
        throw new IllegalStateException()
    }

    def getPixels(pixels : Array[Int], offset : Int, stride : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        if (this.image.isMutable()) {
            val mutableImage : SwtMutableImage = this.image.asInstanceOf[SwtMutableImage]
            mutableImage.getRGB(pixels, offset, stride, x, y, width, height)
        } else {
            val immutableImage : SwtImmutableImage = this.image.asInstanceOf[SwtImmutableImage]
            immutableImage.getRGB(pixels, offset, stride, x, y, width, height)
        }
    }

    def setPixels(pixels : Array[Int], offset : Int, stride : Int, x : Int, y : Int, width : Int, height : Int) : Unit = {
        this.image.setRGB2(pixels, offset, height, x, y, width, height)
    }

    override def getWidth() : Int = {
        return this.image.getWidth()
    }

    override def getHeight() : Int = {
        return this.image.getHeight()
    }

    def recycle() : Unit = {
        DisposalUtil.getInstance().disposeImage(this.image)
    }

}


