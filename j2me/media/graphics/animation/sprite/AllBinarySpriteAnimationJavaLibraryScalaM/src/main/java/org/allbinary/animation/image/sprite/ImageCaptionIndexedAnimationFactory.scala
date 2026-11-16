/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.javax.microedition.media.Player
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.caption.CaptionIndexedAnimation
import _root_.org.allbinary.animation.image.ImageAnimation
import _root_.org.allbinary.graphics.color.BasicColorUtil
import _root_.org.allbinary.image.AnimationFactoryImageScaleUtil
import _root_.org.allbinary.image.sprite.AnimationFactorySpriteScaleUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.media.ScaleProperties
import _root_.org.allbinary.media.audio.Sound

class ImageCaptionIndexedAnimationFactory(param_captionImage : Image, param_spriteMovieImage : Image, param_soundInterface : Sound, param_frameWidth : Int, param_frameHeight : Int, param_captionDx : Int, param_captionDy : Int, param_dx : Int, param_dy : Int, param_time : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {

    val animationFactoryImageScaleUtil : AnimationFactoryImageScaleUtil = AnimationFactoryImageScaleUtil.getInstance()

    private val animationFactorySpriteScaleUtil : AnimationFactorySpriteScaleUtil = AnimationFactorySpriteScaleUtil.getInstance()

    private var captionImage : Image = null

    private var spriteMovieImage : Image = null

    private var frameWidth : Int = 0

    private var frameHeight : Int = 0

    private var captionDx : Int = 0

    private var captionDy : Int = 0

    private var dx : Int = 0

    private var dy : Int = 0

    private var time : Int = 0

    private var soundInterface : Sound = null

    var scaleProperties : ScaleProperties = ScaleProperties.instance

    private var animationBehaviorFactory : AnimationBehaviorFactory = null

    //Constructor
    {
        val captionImage : Image = param_captionImage
        val spriteMovieImage : Image = param_spriteMovieImage
        val soundInterface : Sound = param_soundInterface
        val frameWidth : Int = param_frameWidth
        val frameHeight : Int = param_frameHeight
        val captionDx : Int = param_captionDx
        val captionDy : Int = param_captionDy
        val dx : Int = param_dx
        val dy : Int = param_dy
        val time : Int = param_time
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        if (animationBehaviorFactory eq AnimationBehaviorFactory.getInstance()) {
            ForcedLogUtil.log("Using default AnimationBehaviorFactory with IndexedAnimationFactory", this)
        }
        this.captionImage = captionImage
        this.spriteMovieImage = spriteMovieImage
        this.frameWidth = frameWidth
        this.frameHeight = frameHeight
        this.captionDx = captionDx
        this.captionDy = captionDy
        this.dx = dx
        this.dy = dy
        this.time = time
        this.soundInterface = soundInterface
        this.animationBehaviorFactory = animationBehaviorFactory
    }

    override def getInstance(instanceId : Int) : Animation = {
        val scaledImage : Image = this.animationFactoryImageScaleUtil.createImage(this.captionImage, this.captionImage.getWidth(), this.captionImage.getHeight(), this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        val animationInterface : Animation = new ImageAnimation(scaledImage, this.animationBehaviorFactory.getOrCreateInstance())
        val sprite : Sprite = this.animationFactorySpriteScaleUtil.createImage(this.spriteMovieImage, this.frameWidth, this.frameHeight, this.scaleProperties.scaleWidth, this.scaleProperties.scaleHeight)
        val movieIndexedAnimationInterface : IndexedAnimation = new SpriteIndexedAnimation(sprite, this.spriteMovieImage, BasicColorUtil.getInstance().ZERO_ARRAY, this.animationBehaviorFactory.getOrCreateInstance())
        var player : Player = this.soundInterface.getPlayerP()
        if (player == null) {
            throw new Exception("Sound Was not Initialized")
        }
        return new CaptionIndexedAnimation(animationInterface, movieIndexedAnimationInterface, player, this.captionDx, this.captionDy, this.dx, this.dy, this.time, this.animationBehaviorFactory.getOrCreateInstance())
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
        this.scaleProperties = scaleProperties
    }

}


