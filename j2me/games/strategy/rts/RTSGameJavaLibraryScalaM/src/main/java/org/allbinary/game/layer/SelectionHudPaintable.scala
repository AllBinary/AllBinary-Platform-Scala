/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.paint.InitUpdatePaintable
import _root_.org.allbinary.input.motion.button.CommonButtons
import _root_.org.allbinary.input.motion.button.TouchButtonLocationHelper
import _root_.org.allbinary.logic.math.PrimitiveLongUtil

class SelectionHudPaintable() extends InitUpdatePaintable with UpdateMyFontInterface {

    val y : Int = CommonButtons.getInstance().STANDARD_BUTTON_SIZE + 17

    private var primitiveLongUtil : PrimitiveLongUtil = null

    val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    private var x : Int = 0

    var textX : Int = 0

    var imageX : Int = 0

    // private String percentComplete = StringUtil.getInstance();
    private var basicColor : BasicColor = BasicColorFactory.getInstance().BLACK

    private var color : Int = 0

    private var width : Int = 0

    private var height : Int = 0

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    // private final int ANIMATION_WIDTH_MAGIC = 70;
    private var animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    private val backgroundColor : Int = BasicColorFactory.getInstance().GREY.intValue()

    //BasicColor.TRANSPARENT_GREY.intValue();
    //Constructor
    {
        this.update()
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(10000)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val commonButtons : CommonButtons = CommonButtons.getInstance()
        val font : Font = graphics.getFont()
        // MyFont.MYFONT.DEFAULT_CHAR_HEIGHT;
        this.setHeight(commonButtons.STANDARD_BUTTON_SIZE + font.getHeight())
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    override def update() : Unit = {
        val commonButtons : CommonButtons = CommonButtons.getInstance()
        val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
        val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        this.x = commonButtons.STANDARD_BUTTON_SIZE + touchButtonLocationHelper.getColumnsRemainderHalf()
        this.textX = this.getX() + 4
        this.width = displayInfoSingleton.getLastWidth() - (this.getX() * 2)
        this.imageX = (this.getWidth() + touchButtonLocationHelper.getColumnsRemainderHalf()) - 10
        this.myFontProcessor = this.updateMyFontProcessor
    }

    def updateSelectionInfo() : Unit = {
    }

    def updateInfo() : Unit = {
    }

    def getPrimitiveLongUtil() : PrimitiveLongUtil = {
        return this.primitiveLongUtil
    }

    def setAnimationInterface(animationInterface : Animation) : Unit = {
        this.animationInterface = animationInterface
    }

    def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getName() : String = {
        return this.name
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        this.basicColor = basicColor
        this.setColor(basicColor.intValue())
    }

    def getBasicColorP() : BasicColor = {
        return this.basicColor
    }

    def setColor(color : Int) : Unit = {
        this.color = color
    }

    def getColor() : Int = {
        return this.color
    }

    def getWidth() : Int = {
        return this.width
    }

    def setHeight(height : Int) : Unit = {
        this.height = height
    }

    def getHeight() : Int = {
        return this.height
    }

    def getX() : Int = {
        return this.x
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        graphics.setColor(this.backgroundColor)
        //graphics.fillRect(this.getX(), y, this.getWidth(), this.getHeight());
        graphics.drawRect(this.getX(), this.y, this.getWidth(), this.getHeight())
        graphics.setColor(this.getColor())
        graphics.drawString(this.getName(), this.textX, this.y, 0)
    }

}


