/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.game.layer.SpriteFactory
import _root_.org.allbinary.graphics.opengles.OpenGLUtil
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.image.opengles.OpenGLESImageExclusionUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.J2SEMath
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.image.ImageScaleUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class AnimationFactorySpriteScaleUtil {
    import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil.{*}

    private val imageCache : ImageCache = ImageCacheFactory.getInstance()

    private val imageScaleUtil : ImageScaleUtil = ImageScaleUtil.getInstance()

    //private final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();
    private val openGLUtil : OpenGLUtil = OpenGLUtil.getInstance()

    private val j2seMath : J2SEMath = J2SEMath.getInstance()

    private val openGLESImageExclusionUtil : OpenGLESImageExclusionUtil = OpenGLESImageExclusionUtil.getInstance()

    def createImage(image : Image, width : Int, height : Int, scaleWidth : Int, scaleHeight : Int) : Sprite = {
        //       this.logUtil.putF(stringMaker.append(image.getName()).append(" width: ").appendint(width).append(" height: ").appendint(height).append("scaleWidth: ").appendint(scaleWidth).append(" scaleHeight: ").appendint(scaleHeight).toString(), this, commonStrings.PROCESS);
        val spriteFactory : SpriteFactory = SpriteFactory.getInstance()
        var sprite : Sprite = null
        var scaledImage : Image = null
        if ((scaleWidth != 0) && (scaleHeight != 0)) {
            var scaleX : Float = (scaleWidth.toFloat) / (width.toFloat)
            var scaleY : Float = (scaleHeight.toFloat) / (height.toFloat)
            //           this.logUtil.putF(stringMaker.append("0scaleX: ").appendfloat(scaleX).append(" scaleY: ").appendfloat(scaleY).toString(), this, commonStrings.PROCESS);
            if (((scaleX == 1.0f) && (scaleY == 1.0f)) || ((scaleX == 0.0f) || (scaleY == 0.0f))) {
                //               this.logUtil.putF(stringMaker.append("noscale ").append(commonLabels.WIDTH_LABEL).appendint(width).append(commonLabels.HEIGHT_LABEL).appendint(height).toString(), this, commonStrings.PROCESS);
                scaledImage = this.openGLUtil.addImage(image)
                sprite = spriteFactory.createSprite(scaledImage, width, height)
            } else {
                //               this.logUtil.putF(stringMaker.append("scaleX: ").appendfloat(scaleX).append(" scaleY: ").appendfloat(scaleY).toString(), this, commonStrings.PROCESS);
                if (this.openGLESImageExclusionUtil.isCustomScaling(image)) {
                    //This does not work for J2ME.
                    val width2 : Int = this.j2seMath.round((scaleWidth) - 0.5f)
                    val height2 : Int = this.j2seMath.round((scaleHeight) - 0.5f)
                    val multiplesOf16Width : Int = width2 / 16
                    val by16Width : Int = multiplesOf16Width * 16
                    scaleX = (by16Width.toFloat) / width
                    val multiplesOf16Height : Int = height2 / 16
                    val by16Height : Int = multiplesOf16Height * 16
                    scaleY = (by16Height.toFloat) / height
                    //                   scaleY = 1.0f;
                    if (scaleWidth < width) {
                        //                            .append(" 2.35f").toString(), this, commonStrings.PROCESS);
                        scaleX = scaleX * 2.35f
                    }
                    if (scaleHeight < height) {
                        //                            .append(" 2.35f").toString(), this, commonStrings.PROCESS);
                        scaleY = scaleY * 2.35f
                    }
                }
                scaledImage = this.imageScaleUtil.createImage2(this.imageCache, image, scaleX, 1.0f, scaleY, 1.0f, true)
                //               this.logUtil.putF(stringMaker.append("scaledImage.getHeight(): ").appendint(scaledImage.getHeight()).append(" height * scaleY: ").appendfloat(height * scaleY).toString(), this, commonStrings.PROCESS);
                sprite = spriteFactory.createSprite(scaledImage, (width * scaleX).toInt, (height * scaleY).toInt)
            }
        } else {
            //           this.logUtil.putF(stringMaker.append("noscale2").append(commonLabels.WIDTH_LABEL).appendint(width).append(commonLabels.HEIGHT_LABEL).appendint(height).toString(), this, commonStrings.PROCESS);
            scaledImage = this.openGLUtil.addImage(image)
            sprite = spriteFactory.createSprite(scaledImage, width, height)
        }
        return sprite
    }

}

object AnimationFactorySpriteScaleUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : AnimationFactorySpriteScaleUtil = new AnimationFactorySpriteScaleUtil()

    /**      * @return the instance      */
    def getInstance() : AnimationFactorySpriteScaleUtil = {
        return AnimationFactorySpriteScaleUtil.instance
    }

}


