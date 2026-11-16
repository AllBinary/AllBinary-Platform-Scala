/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.org.eclipse.swt.SWT
import _root_.org.eclipse.swt.widgets.Canvas
import _root_.org.eclipse.swt.widgets.Composite
import _root_.org.eclipse.swt.graphics.GC
import _root_.org.eclipse.swt.graphics.ImageData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.eclipse.swt.events.PaintEvent
import _root_.org.eclipse.swt.events.PaintListener
import _root_.org.eclipse.swt.graphics.Transform
import _root_.org.eclipse.swt.widgets.Display
import _root_.org.microemu.app.BareMain

class ImageUtil private() {
    import _root_.org.allbinary.media.image.ImageUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private var IIOIMAGE_POOL_NAME : String = "IIOIMAGE_POOL_NAME"

    //public static PoolInterface poolInterface = null;
    private val CREATE_BUFFERED_IMAGE : String = "createBufferedImage"

    //Constructor
    {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    def create(width : Int, height : Int) : _root_.org.eclipse.swt.graphics.Image = {
        val display : Display = BareMain.shell.getDisplay()
        return new _root_.org.eclipse.swt.graphics.Image(display, width, height)
    }

    def createBufferedImage(bufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image], percent : Int, scale : Boolean) : Array[_root_.org.eclipse.swt.graphics.Image] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image] = new Array[_root_.org.eclipse.swt.graphics.Image](size)
        var bufferedImage : _root_.org.eclipse.swt.graphics.Image = null
        var imageData : ImageData = null

        {
            var index : Int = 0
            while (index < size) {
                bufferedImage = bufferedImageArray(index)
                imageData = bufferedImage.getImageData()
                val newWidth : Int = ((imageData.width * percent) / 100).toInt
                val newHeight : Int = ((imageData.height * percent) / 100).toInt
                scaledBufferedImageArray(index) = this.createBufferedImage5(bufferedImage, newWidth, newHeight, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImage2(bufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image], percent : Float, scale : Boolean) : Array[_root_.org.eclipse.swt.graphics.Image] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image] = new Array[_root_.org.eclipse.swt.graphics.Image](size)
        var bufferedImage : _root_.org.eclipse.swt.graphics.Image = null
        var imageData : ImageData = null

        {
            var index : Int = 0
            while (index < size) {
                bufferedImage = bufferedImageArray(index)
                imageData = bufferedImage.getImageData()
                val newWidth : Int = (imageData.width * percent).toInt
                val newHeight : Int = (imageData.height * percent).toInt
                scaledBufferedImageArray(index) = this.createBufferedImage5(bufferedImage, newWidth, newHeight, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImage3(bufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image], width : Int, height : Int, scale : Boolean) : Array[_root_.org.eclipse.swt.graphics.Image] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[_root_.org.eclipse.swt.graphics.Image] = new Array[_root_.org.eclipse.swt.graphics.Image](size)

        {
            var index : Int = 0
            while (index < size) {
                scaledBufferedImageArray(index) = this.createBufferedImage5(bufferedImageArray(index), width, height, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImage4(bufferedImage : _root_.org.eclipse.swt.graphics.Image, newWidth : Int, newHeight : Int) : _root_.org.eclipse.swt.graphics.Image = {
        return this.createBufferedImage5(bufferedImage, newWidth, newHeight, true)
    }

    def createBufferedImage5(bufferedImage : _root_.org.eclipse.swt.graphics.Image, newWidth : Int, newHeight : Int, scale : Boolean) : _root_.org.eclipse.swt.graphics.Image = {
        return this.createBufferedImage6(bufferedImage, newWidth, newHeight, scale, false)
    }

    def createBufferedImage6(bufferedImage : _root_.org.eclipse.swt.graphics.Image, newWidth : Int, newHeight : Int, scale : Boolean, allowTranslate : Boolean) : _root_.org.eclipse.swt.graphics.Image = {
        val imageData : ImageData = bufferedImage.getImageData()
        val width : Float = imageData.width
        val height : Float = imageData.height
        val d_newWidth : Float = newWidth
        val d_newHeight : Float = newHeight
        val widthRatio : Float = d_newWidth / width
        val heightRatio : Float = d_newHeight / height
        var ratioX : Float = 1.0f
        var ratioY : Float = 1.0f
        if (scale) {
            ratioX = widthRatio
            ratioY = heightRatio
        }
        this.logUtil.putF(new StringMaker().appendfloat(width).append(this.commonSeps.FORWARD_SLASH).appendfloat(height).append(this.commonSeps.COLON).appendint(newWidth).append(this.commonSeps.FORWARD_SLASH).appendint(newHeight).append(this.commonSeps.COLON).appendfloat(widthRatio).append(this.commonSeps.FORWARD_SLASH).appendfloat(heightRatio).toString(), this, this.CREATE_BUFFERED_IMAGE)
        var dx : Float = 0
        var dy : Float = 0
        if (!scale && allowTranslate) {
            dx = (newWidth - width) / 2
            dy = (newHeight - height) / 2
            this.logUtil.putF(new StringMaker().append("Translate dx: ").appendfloat(dx).append(" dy: ").appendfloat(dy).toString(), this, this.CREATE_BUFFERED_IMAGE)
        }
        val newBufferedImage : _root_.org.eclipse.swt.graphics.Image = new _root_.org.eclipse.swt.graphics.Image(BareMain.shell.getDisplay(), newWidth, newHeight)
        //bufferedImage.getImageData().scaledTo(newWidth, newHeight);
        val gc : GC = new GC(newBufferedImage)
        val affineTransform : Transform = new Transform(gc.getDevice())
        affineTransform.scale(ratioX, ratioY)
        affineTransform.translate(dx, dy)
        gc.setTransform(affineTransform)
        gc.setAntialias(SWT.ON)
        gc.setInterpolation(SWT.HIGH)
        gc.drawImage(bufferedImage, 0, 0, bufferedImage.getBounds().width, bufferedImage.getBounds().height, 0, 0, newWidth, newHeight)
        //gc.drawImage(bufferedImage, 0, 0, bufferedImage.getBounds().width, bufferedImage.getBounds().height, (int) dx, (int) dy, (int) ((width * ratioX) + dx), (int) ((height * ratioY) + dy));
        gc.dispose()
        return newBufferedImage
    }

    def drawTransformedImage(image : _root_.org.eclipse.swt.graphics.Image, parent : Composite, dx : Int, dy : Int, width : Int, height : Int) : Canvas = {
        val imageCanvas : Canvas = new Canvas(parent, SWT.NONE)
        imageCanvas.addPaintListener(new PaintListener {
                def paintControl(event : PaintEvent) : Unit = {
                    val gc : GC = event.gc
                    val affineTransform : Transform = new Transform(gc.getDevice())
                    affineTransform.translate(dx, dy)
                    gc.setAntialias(SWT.ON)
                    gc.setInterpolation(SWT.HIGH)
                    gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height)
                }

            })
        return imageCanvas
    }

    def toString(bufferedImage : _root_.org.eclipse.swt.graphics.Image) : String = {
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        val imageData : ImageData = bufferedImage.getImageData()
        stringBuffer.append(" org.eclipse.swt.graphics.Image: ")
        stringBuffer.append(commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(imageData.width)
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(imageData.height)
        stringBuffer.append(" Type: ")
        stringBuffer.appendint(imageData.`type`)
        return stringBuffer.toString()
    }

}

object ImageUtil {
    private val instance : ImageUtil = new ImageUtil()

    /**      * @return the instance      */
    def getInstance() : ImageUtil = {
        return ImageUtil.instance
    }

}


