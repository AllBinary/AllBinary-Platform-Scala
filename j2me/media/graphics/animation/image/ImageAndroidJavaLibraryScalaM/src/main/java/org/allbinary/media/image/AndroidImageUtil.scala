/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.android.graphics.Bitmap
import _root_.android.graphics.Canvas
import _root_.android.graphics.Color
import _root_.android.graphics.Matrix
import _root_.android.graphics.Paint
import _root_.javax.microedition.lcdui.Image
import _root_.org.microemu.android.device.AndroidImageInterface

/**  *  * @author User  */
class AndroidImageUtil {
    import _root_.org.allbinary.media.image.AndroidImageUtil.{*}

    def paintBitmap(bitmap : Bitmap, originalBitmap : Bitmap, paint : Paint) : Unit = {
        bitmap.eraseColor(Color.TRANSPARENT)
        val canvas : Canvas = new _root_.android.graphics.Canvas()
        canvas.setBitmap(bitmap)
        canvas.drawBitmap(originalBitmap, 0.0f, 0.0f, paint)
    }

    def paint(image : Image, originalImage : Image, paint : Paint) : Unit = {
        val androidImage : AndroidImageInterface = image.asInstanceOf[AndroidImageInterface]
        androidImage.getBitmap().eraseColor(Color.TRANSPARENT)
        val canvas : Canvas = androidImage.getCanvas()
        val originalAndroidImage : AndroidImageInterface = originalImage.asInstanceOf[AndroidImageInterface]
        canvas.drawBitmap(originalAndroidImage.getBitmap(), 0.0f, 0.0f, paint)
    }

    def rotate(image : Image, originalImage : Image, matrix : Matrix, paint : Paint) : Unit = {
        val androidImage : AndroidImageInterface = image.asInstanceOf[AndroidImageInterface]
        androidImage.getBitmap().eraseColor(Color.TRANSPARENT)
        val canvas : Canvas = androidImage.getCanvas()
        canvas.concat(matrix)
        val originalAndroidImage : AndroidImageInterface = originalImage.asInstanceOf[AndroidImageInterface]
        canvas.drawBitmap(originalAndroidImage.getBitmap(), 0.0f, 0.0f, paint)
    }

}

object AndroidImageUtil {
    private val instance : AndroidImageUtil = new AndroidImageUtil()

    /**      * @return the instance      */
    def getInstance() : AndroidImageUtil = {
        return AndroidImageUtil.instance
    }

}


