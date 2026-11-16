/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.emulator.device

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.eclipse.swt.SWT
import _root_.org.eclipse.swt.graphics.ImageData
import _root_.org.eclipse.swt.graphics.ImageLoader
import _root_.org.microemu.device.swt.SwtMutableImage
import _root_.org.allbinary.AvianUtil
import _root_.org.allbinary.data.resource.ResourceUtil
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.opengles.OpenGLCapabilities
import _root_.org.allbinary.image.PreResourceImageUtil
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

//TTF
class TrueTypeFontUtil private() extends TrueTypeFontUtilBase(2) {
    import _root_.org.allbinary.emulator.device.TrueTypeFontUtil.{*}

    private val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()

    private var widthFloatArray : Array[Float] = null

    var fontImage : OpenGLESImage = OpenGLESImage.NULL_OPENGL_IMAGE

    private var widthScale : Float = 0.0f

    //Constructor
    {
        if (AvianUtil.isAvian()) {
            this.widthFloatArray = Array[Float](1504.0f, 967.0f, 527.0f, 961.0f, 957.0f, 1087.0f, 920.0f, 954.0f, 973.0f, 961.0f, 955.0f, 1296.0f, 1013.0f, 1106.0f, 1167.0f, 815.0f, 815.0f, 1216.0f, 1110.0f, 170.0f, 520.0f, 1056.0f, 815.0f, 1448.0f, 1142.0f, 1345.0f, 927.0f, 1345.0f, 1030.0f, 920.0f, 1096.0f, 1119.0f, 1219.0f, 1841.0f, 1166.0f, 1147.0f, 1005.0f, 879.0f, 965.0f, 792.0f, 964.0f, 927.0f, 753.0f, 1034.0f, 916.0f, 196.0f, 469.0f, 877.0f, 166.0f, 1563.0f, 916.0f, 1007.0f, 965.0f, 964.0f, 631.0f, 777.0f, 649.0f, 917.0f, 1026.0f, 1548.0f, 993.0f, 1028.0f, 795.0f, 241.0f, 798.0f, 241.0f, 905.0f, 1477.0f, 393.0f, 961.0f, 961.0f, 961.0f, 961.0f, 555.0f, 1029.0f, 1010.0f, 1378.0f, 952.0f, 952.0f, 952.0f, 952.0f, 463.0f, 463.0f, 926.0f, 961.0f, 491.0f, 930.0f, 457.0f, 457.0f, 644.0f, 643.0f, 326.0f, 186.0f, 1219.0f, 241.0f, 1599.0f, 961.0f, 302.0f, 711.0f, 961.0f, 961.0f, 710.0f, 141.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f, 1504.0f)
        } else {
            this.widthFloatArray = Array[Float](1504.0f, 967.0f, 527.0f, 961.0f, 957.0f, 1087.0f, 920.0f, 954.0f, 973.0f, 961.0f, 955.0f, 1296.0f, 1013.0f, 1106.0f, 1167.0f, 815.0f, 815.0f, 1216.0f, 1110.0f, 170.0f, 520.0f, 1056.0f, 815.0f, 1448.0f, 1142.0f, 1345.0f, 927.0f, 1345.0f, 1030.0f, 920.0f, 1096.0f, 1119.0f, 1219.0f, 1841.0f, 1166.0f, 1147.0f, 1005.0f, 879.0f, 965.0f, 792.0f, 964.0f, 927.0f, 753.0f, 1034.0f, 916.0f, 196.0f, 469.0f, 877.0f, 166.0f, 1563.0f, 916.0f, 1007.0f, 965.0f, 964.0f, 631.0f, 777.0f, 649.0f, 917.0f, 1026.0f, 1548.0f, 993.0f, 1028.0f, 795.0f, 241.0f, 798.0f, 241.0f, 905.0f, 1477.0f, 393.0f, 961.0f, 555.0f, 1029.0f, 1010.0f, 1378.0f, 952.0f, 463.0f, 463.0f, 926.0f, 961.0f, 491.0f, 930.0f, 457.0f, 457.0f, 644.0f, 643.0f, 326.0f, 186.0f, 1219.0f, 241.0f, 1599.0f, 961.0f, 302.0f, 711.0f, 961.0f, 961.0f, 710.0f, 141.0f, 1504.0f, 1504.0f)
        }
        this.widthScale = (if ((this.scale == 2)) 1.2f else 1f)
    }

    def getFontBitmapGL(gl : GL10, filename : String, cellSize : Int, basicColor : BasicColor) : Image = {
        try {
            if (this.fontImage eq OpenGLESImage.NULL_OPENGL_IMAGE) {
                val canvasStrings : CanvasStrings = CanvasStrings.getInstance()
                val openGLCapabilities : OpenGLCapabilities = OpenGLCapabilities.getInstance()
                if (openGLCapabilities.isTextureSizeValid(1024) && (this.scale == 2)) {
                    val FONT_ATLAS_1024 : String = "/font_1024.png"
                    val image : Image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_1024))
                    image.setName(canvasStrings.FONT_ATLAS)
                    this.fontImage = this.preResourceImageUtil.encapsulate(image).asInstanceOf[OpenGLESImage]
                } else if (openGLCapabilities.isTextureSizeValid(512)) {
                    val FONT_ATLAS_512 : String = "/font_512.png"
                    val image : Image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_512))
                    image.setName(canvasStrings.FONT_ATLAS)
                    this.fontImage = this.preResourceImageUtil.encapsulate(image).asInstanceOf[OpenGLESImage]
                } else {
                    val FONT_ATLAS_512 : String = "/font_512.png"
                    val image : Image = Image.createImage(ResourceUtil.getInstance().getResourceAsStream(FONT_ATLAS_512))
                    image.setName(canvasStrings.FONT_ATLAS)
                    this.fontImage = this.preResourceImageUtil.encapsulate(image).asInstanceOf[OpenGLESImage]
                }
                return this.fontImage
            } else {
                return this.fontImage
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.EXCEPTION, e)
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

    //For SWT this just saves a copy of the existing font image.
    def saveFontAtlasAsFile() : Unit = {
        //this.logUtil.putF(commonStrings.START, this, "saveFontAtlasAsFile");
        val image : Image = this.getFontBitmap(null, cellSize, BasicColorFactory.getInstance().WHITE)
        val imageLoader : ImageLoader = new ImageLoader()
        val imageData : ImageData = (image.asInstanceOf[SwtMutableImage]).image.getImageData()
        imageData.transparentPixel = imageData.getPixel(0, 0)
        imageLoader.data = Array[ImageData](imageData)
        imageLoader.save(CommonSeps.getInstance().PERIOD + CanvasStrings.getInstance().FONT_ATLAS, SWT.IMAGE_PNG)
    }

    def getFontBitmap(filename : String, cellSize : Int, basicColor : BasicColor) : Image = {
        //this.logUtil.putF(commonStrings.START, this, GET_FONT_BITMAP);
        val cellsPerRow2 : Int = this.CELLS_PER_ROW * 2
        val cellsPerRow3 : Int = this.CELLS_PER_ROW * 3
        val cellsPerRow4 : Int = this.CELLS_PER_ROW * 4
        val cellsPerRow5 : Int = this.CELLS_PER_ROW * 5
        val cellsPerRow6 : Int = this.CELLS_PER_ROW * 6
        val cellsPerRow7 : Int = this.CELLS_PER_ROW * 7
        //this.logUtil.putF("textureSize: " + textureSize, this, GET_FONT_BITMAP);
        val image : Image = Image.createImage(textureSize, textureSize)
        val graphics : Graphics = image.getGraphics()
        graphics.setColor(basicColor.intValue())
        //this.logUtil.putF("graphics: " + graphics, this, GET_FONT_BITMAP);
        var biggestHeight : Int = 0
        val bounds : Rectangle = new Rectangle(PointFactory.getInstance().createXY(0, 0), cellSize, cellSize)
        var x : Int = 0
        var y : Int = 0

        {
            var index : Int = 0
            while (index < size) {
                //if(pattern.length() > index) {
                this.characterArray(0) = pattern.charAt(index)
                //paint.getTextBounds(characterArray, 0, 1, bounds);
                _characterWidth(index) = bounds.getMaxX()
                if ((bounds.getMaxY() - bounds.getPoint().getX()) > biggestHeight) {
                    biggestHeight = bounds.getMaxY() - bounds.getPoint().getX()
                }
                x = (index % this.CELLS_PER_ROW) * cellSize
                x += (cellSize >> 1)
                x -= (_characterWidth(index) >> 1)
                y = -(cellSize >> 1)
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
                //graphics.drawRect(x, y, bounds.getWidth(), bounds.getHeight());
                graphics.drawChar(this.characterArray(0), x, y, 0)
                index += 1
            }
        }
        //this.saveFontAtlasAsFile();
        return image
    }

    def getFontWidths(filename : String, fontSize : Int) : Array[Int] = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        //final Rectangle bounds = new Rectangle(PointFactory.getInstance().getInstance(0, 0), (this.cellSize / 10) * 4, this.cellSize);

        {
            var index : Int = 0
            while (index < size) {
                this.characterArray(0) = pattern.charAt(index)
                //            }
                if (this.characterArray(0) == ' ') {
                    _characterWidth(index) = (fontSize / 4)
                } else {
                    //this.logUtil.putF("character: " + characterArray[0], this, commonStrings.START);
                    val shortPatternIndex : Int = this.shortPattern.indexOf(this.characterArray(0))
                    //this.logUtil.putF("shortPatternIndex: " + shortPatternIndex, this, commonStrings.START);
                    val w : Int = (this.widthFloatArray(shortPatternIndex) / 75).toInt + 19
                    //                    .toString(), this, commonStrings.START);
                    _characterWidth(index) = w.toInt
                    //if(characterArray[0] == 'E' || characterArray[0] == 'P') _characterWidth[index] += 5;
                    if ((this.characterArray(0) == '.') || (this.characterArray(0) == '1')) {
                        _characterWidth(index) += 4
                    }
                    if ((this.characterArray(0) >= 'a') && (this.characterArray(0) < 'k')) {
                        _characterWidth(index) -= 2
                    }
                    if ((this.characterArray(0) >= 'k') && (this.characterArray(0) < 'v')) {
                        _characterWidth(index) -= 4
                    }
                    if ((this.characterArray(0) >= 'v') && (this.characterArray(0) < 'z')) {
                        _characterWidth(index) -= 8
                    }
                    if (this.characterArray(0) == 'D') {
                        _characterWidth(index) -= 4
                    }
                    if ((this.characterArray(0) >= 'A') && (this.characterArray(0) <= 'Z')) {
                        _characterWidth(index) -= 2
                    }
                }
                _characterWidth(index) = (_characterWidth(index) * this.widthScale).toInt
                index += 1
            }
        }
        return _characterWidth
    }

}

object TrueTypeFontUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : TrueTypeFontUtil = new TrueTypeFontUtil()

    def getInstance() : TrueTypeFontUtil = {
        return TrueTypeFontUtil.instance
    }

}


