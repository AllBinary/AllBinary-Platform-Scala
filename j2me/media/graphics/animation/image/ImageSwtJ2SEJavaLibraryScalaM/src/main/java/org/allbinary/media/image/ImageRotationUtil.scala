/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.eclipse.swt.graphics.GC
import _root_.org.microemu.device.swt.SwtImmutableImage
import _root_.org.microemu.device.swt.SwtMutableImage

class ImageRotationUtil private() {
    import _root_.org.allbinary.media.image.ImageRotationUtil.{*}

    private val imageSwtRotationUtil : ImageSwtRotationUtil = ImageSwtRotationUtil.getInstance()

    private val features : Features = Features.getInstance()

    def rotateImage(originalImage : Image, image : Image, totalAngle : Int) : Unit = {
        var originalImage2 : Image = originalImage
        if (this.features.isFeature(OpenGLFeatureFactory.getInstance().OPENGL)) {
            if (image.getType() >= OpenGLESImage.TYPE) {
                val openGLESImage : OpenGLESImage = (image.asInstanceOf[OpenGLESImage])
                //originalImage2 = openGLESImage.openGLBitmap.getImage();
                openGLESImage.openGLESImageProperties.angle = totalAngle
                //                }
                return
            } else {
                PreLogUtil.put((("OpenGL but image is: " + image) + " type: ") + image.getType(), this, "rotateImage")
            }
        }
        val originalSwtImage : _root_.org.eclipse.swt.graphics.Image = (originalImage2.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image])
        var gc : GC = null
        var copySwtImage : _root_.org.eclipse.swt.graphics.Image = null
        if (image.isMutable()) {
            //PreLogUtil.put("3a", this, "createRotatedImage");
            val swtImage : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            copySwtImage = swtImage.getImage().asInstanceOf[_root_.org.eclipse.swt.graphics.Image]
            gc = swtImage.getGc()
            //PreLogUtil.put(CommonPhoneStrings.getInstance().FOUR, this, "createRotatedImage");
            this.imageSwtRotationUtil.rotateImage(originalSwtImage, copySwtImage, gc, totalAngle)
        } else {
            //final SwtImmutableImage swtImage = (SwtImmutableImage) image;
            PreLogUtil.put("No rotation for: " + image.toString(), this, "rotateImage")
        }
    }

    def createRotatedImage(originalImage : Image, rotationInDegrees : Int) : Image = {
        //        }
        return originalImage
    }

}

object ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : ImageRotationUtil = new ImageRotationUtil()

    def getInstance() : ImageRotationUtil = {
        return ImageRotationUtil.instance
    }

}


