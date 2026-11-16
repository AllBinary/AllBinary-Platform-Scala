/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.device

import _root_.java.io.File
import _root_.java.io.FileOutputStream
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.android.graphics.Bitmap
import _root_.android.graphics.Canvas
import _root_.android.graphics.Paint
import _root_.android.graphics.Rect
import _root_.android.graphics.Typeface
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.image.PreResourceImageUtil
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.microemu.android.device.AndroidImageInterface
import _root_.org.microemu.android.device.AndroidImmutableImage

//TTF
class TrueTypeFontUtil private() extends TrueTypeFontUtilBase(1) {
    import _root_.org.allbinary.emulator.device.TrueTypeFontUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()

    private val realFontSize : Int = 18

    var fontImage : OpenGLESImage = OpenGLESImage.NULL_OPENGL_IMAGE

    //This is only called from OpenGLES on Android via OpenGLESStrings
    def saveFontAtlasAsFile() : Unit = {
        try {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            val file : File = ResourceUtil.getInstance().getContext().getFilesDir()
            val path : String = file.getAbsolutePath() + CanvasStrings.getInstance().FONT_ATLAS
            this.logUtil.putF(path, this, commonStrings.CONSTRUCTOR)
            val fos : FileOutputStream = new FileOutputStream(path)
            val bitmap : Bitmap = (this.fontImage.openGLBitmap.getImage().asInstanceOf[AndroidImageInterface]).getBitmap()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.EXCEPTION, e)
            }
        }
    }

    def getFontBitmapGL(gl : GL10, filename : String, cellSize : Int, basicColor : BasicColor) : Image = {
        if (this.fontImage eq OpenGLESImage.NULL_OPENGL_IMAGE) {
            val cellsPerRow2 : Int = this.CELLS_PER_ROW * 2
            val cellsPerRow3 : Int = this.CELLS_PER_ROW * 3
            val cellsPerRow4 : Int = this.CELLS_PER_ROW * 4
            val cellsPerRow5 : Int = this.CELLS_PER_ROW * 5
            val cellsPerRow6 : Int = this.CELLS_PER_ROW * 6
            val cellsPerRow7 : Int = this.CELLS_PER_ROW * 7
            val typeface : Typeface = Typeface.DEFAULT
            //Must make bitmap as texture for GL so it must be as a texture size.
            val textureSize : Int = this.getAsTextureSize(this.CELLS_PER_ROW * cellSize)
            val bitmap : Bitmap = Bitmap.createBitmap(textureSize, textureSize, Bitmap.Config.ARGB_8888)
            // AndroidBitmapConfigUtil.get());
            val canvas : Canvas = new Canvas(bitmap)
            val paint : Paint = new Paint()
            paint.setTypeface(typeface)
            paint.setTextSize(this.realFontSize.toFloat)
            //(int) basicColor.blue);
            paint.setAlpha(basicColor.alpha.toInt)
            paint.setColor(basicColor.intValue())
            var biggestHeight : Int = 0
            val bounds : Rect = new Rect()
            var x : Int = 0
            var y : Int = 0

            {
                var index : Int = 0
                while (index < this.size) {
                    this.characterArray(0) = this.pattern.charAt(index)
                    paint.getTextBounds(this.characterArray, 0, 1, bounds)
                    this._characterWidth(index) = bounds.right
                    if ((bounds.bottom - bounds.top) > biggestHeight) {
                        biggestHeight = bounds.bottom - bounds.top
                    }
                    x = (index % this.CELLS_PER_ROW) * cellSize
                    x += (cellSize >> 1)
                    x -= (this._characterWidth(index) >> 1)
                    y = 0
                    if (index >= this.CELLS_PER_ROW) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow2) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow3) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow4) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow5) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow6) {
                        y += cellSize
                    }
                    if (index >= cellsPerRow7) {
                        y += cellSize
                    }
                    y += cellSize
                    y -= (cellSize >> 2)
                    canvas.drawText(this.characterArray, 0, 1, x.toFloat - 3, y.toFloat - 6, paint)
                    index += 1
                }
            }
            canvas.save()
            val image : Image = AndroidImmutableImage.create(bitmap)
            //image.setName(FONT_ATLAS);
            this.fontImage = this.preResourceImageUtil.encapsulate(image).asInstanceOf[OpenGLESImage]
            return this.fontImage
        } else {
            return this.fontImage
        }
        throw new IllegalStateException()
    }

    def getFontWidths(filename : String, fontSize : Int) : Array[Int] = {
        val typeface : Typeface = Typeface.DEFAULT
        //Typeface.createFromAsset(ResourceUtil.getInstance().getContext().getAssets(), filename);
        val paint : Paint = new Paint()
        paint.setTypeface(typeface)
        paint.setTextSize(fontSize.toFloat)
        paint.setARGB(255, 255, 255, 255)
        val bounds : Rect = new Rect()

        {
            var index : Int = 0
            while (index < this.size) {
                this.characterArray(0) = this.pattern.charAt(index)
                paint.getTextBounds(this.characterArray, 0, 1, bounds)
                if (index < this.lastCapIndex) {
                    if (this.characterArray(0) == '1') {
                        this._characterWidth(index) = bounds.right + 3
                    } else if (((((((this.characterArray(0) == 'J') || (this.characterArray(0) == 'V')) || (this.characterArray(0) == '2')) || (this.characterArray(0) == '9')) || (this.characterArray(0) == 'I')) || (this.characterArray(0) == 'N')) || (this.characterArray(0) == 'U')) {
                        this._characterWidth(index) = bounds.right + 1
                    } else if ((((this.characterArray(0) == '4') || (this.characterArray(0) == 'C')) || (this.characterArray(0) == 'E')) || (this.characterArray(0) == 'O')) {
                        this._characterWidth(index) = bounds.right - 2
                    } else if ((((((this.characterArray(0) == 'B') || (this.characterArray(0) == 'D')) || (this.characterArray(0) == 'G')) || (this.characterArray(0) == 'H')) || (this.characterArray(0) == 'T')) || (this.characterArray(0) == 'W')) {
                        this._characterWidth(index) = bounds.right - 3
                    } else if (((this.characterArray(0) == 'A') || (this.characterArray(0) == 'Q')) || (this.characterArray(0) == 'R')) {
                        this._characterWidth(index) = bounds.right - 5
                    } else if (this.characterArray(0) == 'M') {
                        this._characterWidth(index) = bounds.right - 6
                    } else if (this.characterArray(0) == 'm') {
                        this._characterWidth(index) = bounds.right - 8
                    } else {
                        this._characterWidth(index) = bounds.right
                    }
                } else {
                    if (this.characterArray(0) == ' ') {
                        this._characterWidth(index) = bounds.right + 10
                    } else if ((((((this.characterArray(0) == 'l') || (this.characterArray(0) == 'i')) || (this.characterArray(0) == 'j')) || (this.characterArray(0) == '.')) || (this.characterArray(0) == '!')) || (this.characterArray(0) == '|')) {
                        this._characterWidth(index) = bounds.right + 6
                    } else if ((((this.characterArray(0) == 'f') || (this.characterArray(0) == 't')) || (this.characterArray(0) == 'u')) || (this.characterArray(0) == 'v')) {
                        this._characterWidth(index) = bounds.right + 1
                    } else if (this.characterArray(0) == 'r') {
                        this._characterWidth(index) = bounds.right + 2
                    } else if ((((this.characterArray(0) == 'a') || (this.characterArray(0) == 'b')) || (this.characterArray(0) == 'g')) || (this.characterArray(0) == 'u')) {
                        this._characterWidth(index) = bounds.right - 1
                    } else if ((this.characterArray(0) == 'o') || (this.characterArray(0) == 'e')) {
                        this._characterWidth(index) = bounds.right - 2
                    } else if (this.characterArray(0) == 'm') {
                        this._characterWidth(index) = bounds.right - 7
                    } else {
                        this._characterWidth(index) = bounds.right
                    }
                }
                index += 1
            }
        }
        this._characterWidth(0) = (fontSize >> 1) - 2
        return this._characterWidth
    }

}

object TrueTypeFontUtil {
    private val instance : TrueTypeFontUtil = new TrueTypeFontUtil()

    def getInstance() : TrueTypeFontUtil = {
        return TrueTypeFontUtil.instance
    }

}


