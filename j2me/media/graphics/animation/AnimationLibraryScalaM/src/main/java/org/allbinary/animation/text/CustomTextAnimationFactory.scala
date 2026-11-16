/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Font
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehaviorFactory
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.ScaleProperties

/**  *  * @author User  */
class CustomTextAnimationFactory(param_text : String, param_fontSize : Int, param_animationBehaviorFactory : AnimationBehaviorFactory) extends AnimationInterfaceFactoryInterface {
    import _root_.org.allbinary.animation.text.CustomTextAnimationFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var animationBehaviorFactory : AnimationBehaviorFactory = null

    var basicColor : BasicColor = BasicColorFactory.getInstance().BLACK

    private var text : String = null

    private var initScaleHeight : Int = 0

    var dx : Int = 0

    var dy : Int = 0

    var font : Font = null

    var scaleProperties : ScaleProperties = null

    //Constructor
    {
        val text : String = param_text
        val fontSize : Int = param_fontSize
        val animationBehaviorFactory : AnimationBehaviorFactory = param_animationBehaviorFactory
        this.scaleProperties = new ScaleProperties()
        this.text = text
        this.scaleProperties.scaleHeight = fontSize.toInt - (fontSize / 4)
        this.initScaleHeight = this.scaleProperties.scaleHeight
        this.animationBehaviorFactory = animationBehaviorFactory
        this.font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, this.initScaleHeight)
    }

    override def getInstance(instanceId : Int) : Animation = {
        var customTextAnimation : CustomTextAnimation = null
        if ((this.dx != 0) || (this.dy != 0)) {
            customTextAnimation = new AdjustCustomTextAnimation(this.text, this.scaleProperties.scaleHeight, this.dx, this.dy, this.animationBehaviorFactory.getOrCreateInstance())
        } else {
            customTextAnimation = new CustomTextAnimation(this.text, this.scaleProperties.scaleHeight, this.animationBehaviorFactory.getOrCreateInstance())
        }
        customTextAnimation.setBasicColorP(this.basicColor)
        return customTextAnimation
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
    }

    def getWidth() : Int = {
        //        this.logUtil.putF(new StringMaker().append("getWidth - font: ").append(font.getSize()).append(commonLabels.WIDTH_LABEL).append(font.stringWidth(this.text)).append(" text: ").append(text).toString(), this, this.commonStrings.PROCESS);
        return this.font.stringWidth(this.text)
    }

    def getHeight() : Int = {
        return this.font.getHeight()
    }

}

object CustomTextAnimationFactory {
    def createDXY(text : String, fontSize : Int, dx : Int, dy : Int, animationBehaviorFactory : AnimationBehaviorFactory) : CustomTextAnimationFactory = {
        val customTextAnimationFactory : CustomTextAnimationFactory = new CustomTextAnimationFactory(text, fontSize, animationBehaviorFactory)
        customTextAnimationFactory.dx = dx
        customTextAnimationFactory.dy = dy
        return customTextAnimationFactory
    }

}


