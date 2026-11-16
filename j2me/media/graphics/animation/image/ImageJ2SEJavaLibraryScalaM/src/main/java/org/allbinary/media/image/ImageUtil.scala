/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.Graphics2D
import _root_.java.awt.GraphicsConfiguration
import _root_.java.awt.GraphicsDevice
import _root_.java.awt.GraphicsEnvironment
import _root_.java.awt.Transparency
import _root_.java.awt.geom.AffineTransform
import _root_.java.awt.image.BufferedImage
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.microemu.device.j2se.J2SEImmutableImage
import _root_.org.microemu.device.j2se.J2SEMutableImage

class ImageUtil private() {
    import _root_.org.allbinary.media.image.ImageUtil.{*}

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private var IIOIMAGE_POOL_NAME : String = "IIOIMAGE_POOL_NAME"

    //public static PoolInterface poolInterface = null;
    private val CREATE_BUFFERED_IMAGE : String = "createBufferedImage"

    private def getDefaultConfiguration() : GraphicsConfiguration = {
        val ge : GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
        val gd : GraphicsDevice = ge.getDefaultScreenDevice()
        return gd.getDefaultConfiguration()
    }

    def create(width : Int, height : Int) : BufferedImage = {
        val graphicsConfiguration : GraphicsConfiguration = this.getDefaultConfiguration()
        return graphicsConfiguration.createCompatibleImage(width, height, Transparency.TRANSLUCENT)
    }

    def createBufferedImageForResize(bufferedImageArray : Array[BufferedImage], percent : Int, scale : Boolean) : Array[BufferedImage] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](size)
        var bufferedImage : BufferedImage = null

        {
            var index : Int = 0
            while (index < size) {
                bufferedImage = bufferedImageArray(index)
                val newWidth : Int = ((bufferedImage.getWidth() * percent) / 100).toInt
                val newHeight : Int = ((bufferedImage.getHeight() * percent) / 100).toInt
                scaledBufferedImageArray(index) = this.createBufferedImage(bufferedImage, newWidth, newHeight, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImage2(bufferedImageArray : Array[BufferedImage], percent : Float, scale : Boolean) : Array[BufferedImage] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](size)
        var bufferedImage : BufferedImage = null

        {
            var index : Int = 0
            while (index < size) {
                bufferedImage = bufferedImageArray(index)
                val newWidth : Int = (bufferedImage.getWidth() * percent).toInt
                val newHeight : Int = (bufferedImage.getHeight() * percent).toInt
                scaledBufferedImageArray(index) = this.createBufferedImage(bufferedImage, newWidth, newHeight, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImage3(bufferedImageArray : Array[BufferedImage], width : Int, height : Int, scale : Boolean) : Array[BufferedImage] = {
        val size : Int = bufferedImageArray.length
        val scaledBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](size)

        {
            var index : Int = 0
            while (index < size) {
                scaledBufferedImageArray(index) = this.createBufferedImage(bufferedImageArray(index), width, height, scale)
                index += 1
            }
        }
        return scaledBufferedImageArray
    }

    def createBufferedImageForSave(bufferedImage : BufferedImage, newWidth : Int, newHeight : Int) : BufferedImage = {
        return this.createBufferedImage(bufferedImage, newWidth, newHeight, true)
    }

    def createBufferedImage(bufferedImage : BufferedImage, newWidth : Int, newHeight : Int, scale : Boolean) : BufferedImage = {
        return this.createBufferedImageAllowTranslate(bufferedImage, newWidth, newHeight, scale, false)
    }

    //private final String TRANSLATE = "Translate ";
    def createBufferedImageAllowTranslate(bufferedImage : BufferedImage, newWidth : Int, newHeight : Int, scale : Boolean, allowTranslate : Boolean) : BufferedImage = {
        val width : Double = bufferedImage.getWidth()
        val height : Double = bufferedImage.getHeight()
        val d_newWidth : Double = newWidth
        val d_newHeight : Double = newHeight
        val widthRatio : Double = d_newWidth / width
        val heightRatio : Double = d_newHeight / height
        var ratioX : Double = 1.0
        var ratioY : Double = 1.0
        if (scale) {
            ratioX = widthRatio
            ratioY = heightRatio
        }
        val affineTransform : AffineTransform = AffineTransform.getScaleInstance(ratioX, ratioY)
        //              .append((float) widthRatio).append(this.commonSeps.FORWARD_SLASH).append((float) heightRatio).toString(), this, CREATE_BUFFERED_IMAGE);
        if (!scale && allowTranslate) {
            val dx : Double = (newWidth - width) / 2
            val dy : Double = (newHeight - height) / 2
            //this.logUtil.putF(new StringMaker().append(TRANSLATE).append(PositionStrings.getInstance().DX_LABEL).append((float) dx).append(PositionStrings.getInstance().DY_LABEL).append((float) dy).toString(), this, CREATE_BUFFERED_IMAGE);
            affineTransform.translate(dx, dy)
        }
        val newBufferedImage : BufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB_PRE)
        val graphics : Graphics2D = newBufferedImage.createGraphics()
        graphics.drawRenderedImage(bufferedImage, affineTransform)
        /*       Graphics2D g = (Graphics2D) newBufferedImage.getGraphics();       g.scale(widthRatio, heightRatio);              ImageObserver imageObserver = (ImageObserver) new JFrame();       boolean isDrawDone = g.drawImage(bufferedImage, 0, 0, imageObserver);              if(!isDrawDone)       {       boolean isTimeUp = false;       final int MAX = 10;       int numberOfRetries = 0;       while(!isDrawDone && !isTimeUp)       {       if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))       {       LogUtil.put("Draw Did Not Finish Yet.  Must Wait.... :-< Retry: " + numberOfRetries, "ImageUtil", this.CREATE_BUFFERED_IMAGE);       }              Thread.currentThread().sleep(1000);              isDrawDone = imageObserver.imageUpdate(       newBufferedImage, ImageObserver.ALLBITS, 0, 0, 0, 0);              if(numberOfRetries > MAX)       {       throw new Exception("Draw Image Is Taking To Long. >" + numberOfRetries*1000);       }              numberOfRetries++;       }       }       else       {       //if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))       //{       LogUtil.put("Draw Was Complete", "ImageUtil", this.CREATE_BUFFERED_IMAGE);       //}       }        */
        return newBufferedImage
    }

    def createBufferedImageWithLargerCanvas(bufferedImage : BufferedImage, newWidth : Int, newHeight : Int) : BufferedImage = {
        val width : Double = bufferedImage.getWidth()
        val height : Double = bufferedImage.getHeight()
        val d_newWidth : Double = newWidth
        val d_newHeight : Double = newHeight
        val widthRatio : Double = d_newWidth / width
        val heightRatio : Double = d_newHeight / height
        //              .append((float) widthRatio).append(this.commonSeps.FORWARD_SLASH).append((float) heightRatio).toString(), this, CREATE_BUFFERED_IMAGE);
        val dx2 : Int = (newWidth - width).toInt
        val dy2 : Int = (newHeight - height).toInt
        val dx : Int = dx2.toInt / 2
        val dy : Int = dy2.toInt / 2
        val dx4 : Int = dx2.toInt / 4
        val dy4 : Int = dy2.toInt / 4
        //this.logUtil.putF(new StringMaker().append(TRANSLATE).append(PositionStrings.getInstance().DX_LABEL).append((float) dx).append(PositionStrings.getInstance().DY_LABEL).append((float) dy).toString(), this, CREATE_BUFFERED_IMAGE);
        val newBufferedImage : BufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB_PRE)
        val graphics : Graphics2D = newBufferedImage.createGraphics()
        //graphics.drawImage(bufferedImage, dx, dy, null);
        graphics.drawImage(bufferedImage, dx4, dy4, null)
        //      graphics.drawLine((int) newWidth - dx, (int) newHeight - dy, (int) newWidth - dx - 1, (int) newHeight - dy - 1);
        return newBufferedImage
    }

    def convertToBufferedImage(toolkitImage : _root_.java.awt.Image) : BufferedImage = {
        if (toolkitImage == null) {
            return null
        }
        val bufferedImage : BufferedImage = new BufferedImage(toolkitImage.getWidth(null), toolkitImage.getHeight(null), BufferedImage.TYPE_INT_ARGB)
        val g2d : Graphics2D = bufferedImage.createGraphics()
        g2d.drawImage(toolkitImage, 0, 0, null)
        g2d.dispose()
        return bufferedImage
    }

    def getBufferedImage(image : Image) : BufferedImage = {
        var bufferedImage : BufferedImage = null
        //java.awt.Image bufferedImage;
        if (image.isMutable()) {
            val j2seImage : J2SEMutableImage = image.asInstanceOf[J2SEMutableImage]
            bufferedImage = j2seImage.getImage().asInstanceOf[BufferedImage]
        } else {
            val j2seImage : J2SEImmutableImage = image.asInstanceOf[J2SEImmutableImage]
            //sun.awt.image.ToolkitImage cannot be cast to class java.awt.image.BufferedImage
            bufferedImage = j2seImage.getImage().asInstanceOf[BufferedImage]
        }
        return bufferedImage
    }

    def toString(bufferedImage : BufferedImage) : String = {
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(" BufferedImage -")
        stringBuffer.append(commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(bufferedImage.getWidth())
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(bufferedImage.getHeight())
        stringBuffer.append(" Type: ")
        stringBuffer.appendint(bufferedImage.getType())
        return stringBuffer.toString()
    }

}

object ImageUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageUtil = new ImageUtil()

    /**      * @return the instance      */
    def getInstance() : ImageUtil = {
        return ImageUtil.instance
    }

}


