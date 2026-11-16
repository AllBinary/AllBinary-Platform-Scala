/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.image.AnimationFactoryInitializationVisitor
import _root_.org.allbinary.animation.image.BaseImageAnimationFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.media.image.ImageJ2MEScaleUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class AnimationFactoryImageScaleUtil {
    import _root_.org.allbinary.image.AnimationFactoryImageScaleUtil.{*}

    //private final ImageScaleUtil imageScaleUtil = ImageScaleUtil.getInstance();
    private val imageScaleUtil : ImageJ2MEScaleUtil = ImageJ2MEScaleUtil.getInstance()

    //private final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();
    def createImage(image : Image, width : Int, height : Int, scaleWidth : Int, scaleHeight : Int) : Image = {
        var scaledImage : Image = null
        //        this.logUtil.putF(stringMaker.append("before scale").append(commonLabels.WIDTH_LABEL).appendint(width).append(commonLabels.HEIGHT_LABEL).appendint(height).toString(), this, commonStrings.PROCESS);
        if ((scaleWidth != 0) && (scaleHeight != 0)) {
            val scaleX : Float = (scaleWidth.toFloat) / (width.toFloat)
            val scaleY : Float = (scaleHeight.toFloat) / (height.toFloat)
            //            this.logUtil.putF(stringMaker.append("0scaleX: ").appendfloat(scaleX).append(" scaleY: ").appendfloat(scaleY).toString(), this, commonStrings.PROCESS);
            if (((scaleX == 1.0f) && (scaleY == 1.0f)) || ((scaleX == 0.0f) || (scaleY == 0.0f))) {
                //scaledImage = this.imageCopyUtil.createImage(image);
                scaledImage = image
            } else {
                //scaledImage = this.imageScaleUtil.createImage(this.imageCache, image, scaleX, 1, scaleY, 1, true);
                val scaledWidth : Int = (scaleX * width).toInt
                val scaledHeight : Int = (scaleY * height).toInt
                //                this.logUtil.putF(stringMaker.append("scaledWidth: ").appendfloat(scaledWidth).append(" scaledHeight: ").appendfloat(scaledHeight).toString(), this, commonStrings.PROCESS);
                scaledImage = this.imageScaleUtil.scale(image, scaledWidth, scaledHeight)
            }
        } else {
            //scaledImage = this.imageCopyUtil.createImage(image);
            scaledImage = image
        }
        return scaledImage
    }

    def processAdjust(baseImageAnimationFactory : BaseImageAnimationFactory) : Unit = {
        val scaleProperties : ScaleProperties = baseImageAnimationFactory.getScalePropertiesP()
        if ((scaleProperties.scaleWidth != 0) && (scaleProperties.scaleHeight != 0)) {
            val animationFactoryInitializationVisitor : AnimationFactoryInitializationVisitor = baseImageAnimationFactory.getAnimationFactoryInitializationVisitorP()
            val scaleX : Float = (scaleProperties.scaleWidth.toFloat) / (animationFactoryInitializationVisitor.width.toFloat)
            val scaleY : Float = (scaleProperties.scaleHeight.toFloat) / (animationFactoryInitializationVisitor.height.toFloat)
            if (((scaleX == 1.0f) && (scaleY == 1.0f)) || ((scaleX == 0.0f) || (scaleY == 0.0f))) {
            } else {
                animationFactoryInitializationVisitor.dx = (animationFactoryInitializationVisitor.originalDx * scaleX).toInt
                animationFactoryInitializationVisitor.dy = (animationFactoryInitializationVisitor.originalDy * scaleY).toInt
            }
        } else {
        }
    }

}

object AnimationFactoryImageScaleUtil {
    private val instance : AnimationFactoryImageScaleUtil = new AnimationFactoryImageScaleUtil()

    /**      * @return the instance      */
    def getInstance() : AnimationFactoryImageScaleUtil = {
        return AnimationFactoryImageScaleUtil.instance
    }

}


