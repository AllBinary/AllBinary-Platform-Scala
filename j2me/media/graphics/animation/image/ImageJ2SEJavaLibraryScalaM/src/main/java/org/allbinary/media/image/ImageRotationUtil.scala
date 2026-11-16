/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.microemu.device.j2se.J2SEImmutableImage
import _root_.org.microemu.device.j2se.J2SEMutableImage

class ImageRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageRotationUtil.{*}

    private val imageJ2SERotationUtil : ImageJ2SERotationUtil = ImageJ2SERotationUtil.getInstance()

    def rotateImage(originalImage : Image, image : Image, totalAngle : Int) : Unit = {
        if (image.isMutable()) {
            //PreLogUtil.put("3a", this, "createRotatedImage");
            val j2seImage : J2SEMutableImage = image.asInstanceOf[J2SEMutableImage]
            val newBufferedImage : BufferedImage = j2seImage.getImage().asInstanceOf[BufferedImage]
            //PreLogUtil.put(CommonPhoneStrings.getInstance().FOUR, this, "createRotatedImage");
            var originalAwtImage : _root_.java.awt.Image = null
            if (originalImage.isMutable()) {
                //PreLogUtil.put("3a", this, "createRotatedImage");
                var originalJ2SEImage : J2SEMutableImage = originalImage.asInstanceOf[J2SEMutableImage]
                originalAwtImage = originalJ2SEImage.getImage().asInstanceOf[_root_.java.awt.Image]
            } else {
                //PreLogUtil.put("3b", this, "createRotatedImage");
                val originalJ2SEImage : J2SEImmutableImage = originalImage.asInstanceOf[J2SEImmutableImage]
                originalAwtImage = originalJ2SEImage.getImage().asInstanceOf[_root_.java.awt.Image]
            }
            this.imageJ2SERotationUtil.rotateImage(originalAwtImage, newBufferedImage, totalAngle)
        } else {
            PreLogUtil.putOE("Not Mutable", this, "getRotatedImage", new Exception())
        }
    }

    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        //PreLogUtil.put("originalImage: " + originalImage + " rotationInDegrees: " + rotationInDegrees, this, "createRotatedImage");
        val image : Image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight())
        if (image.isMutable()) {
            var originalAwtImage : _root_.java.awt.Image = null
            if (originalImage.isMutable()) {
                //PreLogUtil.put("3a", this, "createRotatedImage");
                var originalJ2SEImage : J2SEMutableImage = originalImage.asInstanceOf[J2SEMutableImage]
                originalAwtImage = originalJ2SEImage.getImage().asInstanceOf[_root_.java.awt.Image]
            } else {
                //PreLogUtil.put("3b", this, "createRotatedImage");
                var originalJ2SEImage : J2SEImmutableImage = originalImage.asInstanceOf[J2SEImmutableImage]
                originalAwtImage = originalJ2SEImage.getImage().asInstanceOf[_root_.java.awt.Image]
            }
            var j2seImage : J2SEMutableImage = image.asInstanceOf[J2SEMutableImage]
            var newBufferedImage : BufferedImage = j2seImage.getImage().asInstanceOf[BufferedImage]
            var bufferedImage : BufferedImage = this.imageJ2SERotationUtil.createRotatedImage(originalAwtImage, newBufferedImage, rotationInDegrees)
            return image
        } else {
            throw new Exception("Not Mutable")
        }
        throw new IllegalStateException()
    }

}

object ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


