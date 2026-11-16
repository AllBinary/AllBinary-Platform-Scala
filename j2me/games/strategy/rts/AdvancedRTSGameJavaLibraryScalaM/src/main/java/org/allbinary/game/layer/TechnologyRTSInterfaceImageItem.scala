/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.form.item.ABCustomImageItem
import _root_.org.allbinary.logic.java.character.CharArrayFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.logic.math.PrimitiveLongUtil

/**  *  * @author user  */
class TechnologyRTSInterfaceImageItem(param_label : String, param_img : Image, param_layout : Int, param_altText : String, param_basicColor : BasicColor, param_rtsInterface : RTSInterface) extends ABCustomImageItem(param_label, param_img, param_layout, param_altText, param_basicColor, 0) with UpdateMyFontInterface {

    private var rtsInterface : RTSInterface = null

    private val primitiveLongUtil : PrimitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(10000)

    private val LEVEL : String = "Level"

    private val COST : String = "Cost"

    private val DOLLAR : String = "$"

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    //private String costString = StringUtil.getInstance();
    private var costString : Array[Char] = CharArrayFactory.getInstance().getZeroCharArray()

    private var costLength : Int = 0

    //private String levelString = StringUtil.getInstance();
    private var levelString : Array[Char] = CharArrayFactory.getInstance().getZeroCharArray()

    private var levelLength : Int = 0

    private var adjustedCostLabelY : Int = 0

    private var adjustedCostX : Int = 0

    private var adjustedCostY : Int = 0

    private var adjustedLevelX : Int = 0

    private var adjustedLevelY : Int = 0

    //Constructor
    {
        val label : String = param_label
        val img : Image = param_img
        val layout : Int = param_layout
        val altText : String = param_altText
        val basicColor : BasicColor = param_basicColor
        val rtsInterface : RTSInterface = param_rtsInterface
        this.rtsInterface = rtsInterface
        this.update()
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        val fontHeight : Int = font.getHeight()
        var imageHeight : Int = 0
        val image : Image = this.getImage()
        if (image ne NullImage.NULL_IMAGE) {
            imageHeight = image.getHeight()
        }
        this.adjustedCostLabelY = (-this.yOffset + imageHeight) - (3 * fontHeight)
        this.adjustedCostY = (-this.yOffset + imageHeight) - (2 * fontHeight)
        this.adjustedCostX = 2 + (this.DOLLAR.length() * (fontHeight - 1))
        this.adjustedLevelY = (-this.yOffset + imageHeight) - fontHeight
        this.adjustedLevelX = 2 + (this.LEVEL.length() * (fontHeight - 1))
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    /**      * @return the rtsInterface      */
    def getRtsInterface() : RTSInterface = {
        return this.rtsInterface
    }

    def update() : Unit = {
        this.costString = this.primitiveLongUtil.getCharArray(this.getRtsInterface().getUpgradeCost())
        this.levelString = this.primitiveLongUtil.getCharArray(this.getRtsInterface().getLevel())
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.myFontProcessor.process(graphics)
        super.paintXY(graphics, x, y)
        var xa : Int = x + 2
        graphics.drawString(this.COST, xa, y + this.adjustedCostLabelY, 0)
        graphics.drawString(this.DOLLAR, xa, y + this.adjustedCostY, 0)
        graphics.drawChars(this.costString, 0, this.costLength, x + this.adjustedCostX, y + this.adjustedCostY, 0)
        graphics.drawString(this.LEVEL, xa, y + this.adjustedLevelY, 0)
        graphics.drawChars(this.levelString, 0, this.levelLength, x + this.adjustedLevelX, y + this.adjustedLevelY, 0)
    }

}


