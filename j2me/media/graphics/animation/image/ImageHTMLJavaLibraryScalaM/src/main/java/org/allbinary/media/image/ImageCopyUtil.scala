/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil

class ImageCopyUtil private() {
    import _root_.org.allbinary.media.image.ImageCopyUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val imageCreationUtil : ImageCreationUtil = ImageCreationUtil.getInstance()

    private var anchor : Int = Anchor.TOP_LEFT

    def createImageForRotation(originalImage : Image) : Image = {
        return this.createImage(originalImage)
    }

    // String resource,
    def createImage(originalImage : Image) : Image = {
        val image : Image = this.imageCreationUtil.getInstance(originalImage.getWidth(), originalImage.getHeight())
        if (image.isMutable()) {
            image.getGraphics().drawImage(originalImage, 0, 0, this.anchor)
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

    def createImageScale(originalImage : Image, canvasScale : Float, resize : Boolean) : Image = {
        //this.logUtil.putF(this.commonLabels + originalImage.getWidth() + commonLabels + originalImage.getHeight(), this, this.commonStrings.CONSTRUCTOR);
        var newWidth : Int = (originalImage.getWidth() * canvasScale).toInt
        var newHeight : Int = (originalImage.getHeight() * canvasScale).toInt
        if (resize) {
            if (newWidth < newHeight) {
                newWidth = newHeight
            }
            if (newHeight < newWidth) {
                newHeight = newWidth
            }
        }
        //this.logUtil.putF("newWidth: " + newWidth + " newHeight: " + newHeight, this, this.commonStrings.CONSTRUCTOR);
        val image : Image = this.imageCreationUtil.getInstance(newWidth, newHeight)
        if (image.isMutable()) {
            val halfWidthDelta : Int = (newWidth - originalImage.getWidth()) / 2
            val halfHeightDelta : Int = (newHeight - originalImage.getHeight()) / 2
            //this.logUtil.putF("deltas" + commonLabels + halfWidthDelta + commonLabels + halfHeightDelta, this, this.commonStrings.CONSTRUCTOR);
            val graphics : Graphics = image.getGraphics()
            graphics.drawImage(originalImage, halfWidthDelta, halfHeightDelta, this.anchor)
            //graphics.drawRect(0, 0, newWidth, newHeight);
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

}

object ImageCopyUtil {
    private val instance : ImageCopyUtil = new ImageCopyUtil()

    def getInstance() : ImageCopyUtil = {
        return ImageCopyUtil.instance
    }

}


