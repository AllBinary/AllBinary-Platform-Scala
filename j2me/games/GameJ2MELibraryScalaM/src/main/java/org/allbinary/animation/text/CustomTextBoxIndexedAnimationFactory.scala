/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.TextField
import _root_.org.allbinary.graphics.form.item.CustomTextBox
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationInterfaceFactoryInterface
import _root_.org.allbinary.game.canvas.ABToGBUtil
import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.ScaleProperties

/**  *  * @author User  */
class CustomTextBoxIndexedAnimationFactory(param_fontSize : Int, param_maxLength : Int) extends AnimationInterfaceFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    var scaleProperties : ScaleProperties = null

    private var maxLength : Int = 0

    //Constructor
    {
        val fontSize : Int = param_fontSize
        val maxLength : Int = param_maxLength
        //logUtil.putF(this.commonStrings.START + fontSize, this, this.commonStrings.CONSTRUCTOR);
        this.scaleProperties = new ScaleProperties()
        this.scaleProperties.scaleHeight = fontSize
        this.maxLength = maxLength
    }

    override def getInstance(instanceId : Int) : Animation = {
        //logUtil.put(this.commonStrings.START, this, this.commonStrings.PROCESS);
        val abToGBUtil : ABToGBUtil = ABToGBUtil.getInstance()
        val abCanvas : AllBinaryGameCanvas = abToGBUtil.abCanvas.asInstanceOf[AllBinaryGameCanvas]
        val font : Font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, this.scaleProperties.scaleHeight)
        //this.getHighScoresArray(), highScore, 
        val customTextBox : CustomTextBox = new CustomTextBox2(abCanvas.getCustomCommandListener(), StringUtil.getInstance().EMPTY_STRING, StringUtil.getInstance().EMPTY_STRING, this.maxLength, TextField.ANY, font, abCanvas.getLayerManager().getBackgroundBasicColor(), abCanvas.getLayerManager().getForegroundBasicColor())
        return new CustomTextBoxIndexedAnimation(customTextBox)
    }

    override def setInitialScale(scaleProperties : ScaleProperties) : Unit = {
        val fontSize : Int = this.scaleProperties.scaleHeight
        this.scaleProperties = scaleProperties
        if (this.scaleProperties.scaleHeight < 6) {
            this.scaleProperties.scaleHeight = fontSize
        }
    }

}


