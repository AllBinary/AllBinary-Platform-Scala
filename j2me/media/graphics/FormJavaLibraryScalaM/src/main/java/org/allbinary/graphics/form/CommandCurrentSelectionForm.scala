/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.animation.vector.RectangleAdjustedAnimation
import _root_.org.allbinary.animation.vector.RectangleFilledAdjustedAnimation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.form.item.CommandTextItem
import _root_.org.allbinary.graphics.form.item.ABCustomItem

class CommandCurrentSelectionForm(param_title : String, param_items : Array[ABCustomItem], param_border : Int, param_moveForSmallScreen : Boolean, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ScrollCurrentSelectionForm(param_title, param_items, ItemPaintableFactory.getInstance(), param_border, -3, param_moveForSmallScreen, param_backgroundBasicColor, param_foregroundBasicColor) with UpdateMyFontInterface {

    val selectedAnimationArray : Array[Animation] = new Array[Animation](16)

    val unSelectedAnimationArray : Array[Animation] = new Array[Animation](16)

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val border : Int = param_border
        val moveForSmallScreen : Boolean = param_moveForSmallScreen
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.initAnimations()
        this.addAll(items)
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        this.updateAll(graphics, this.getAllitems())
        super.updateMeasurement(graphics)
    }

    private def initAnimations() : Unit = {
        val nullAnimation : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

        {
            var index : Int = this.selectedAnimationArray.length
            while ({ index -= 1; index } >= 0) {
                this.selectedAnimationArray(index) = nullAnimation
            }
        }

        {
            var index : Int = this.unSelectedAnimationArray.length
            while ({ index -= 1; index } >= 0) {
                this.unSelectedAnimationArray(index) = nullAnimation
            }
        }
    }

    private def addAll(items : Array[ABCustomItem]) : Unit = {

        {
            var index : Int = items.length
            while ({ index -= 1; index } >= 0) {
                this.addAt(index, items(index))
            }
        }
    }

    private def addAt(index : Int, item : ABCustomItem) : Unit = {
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        val buttonColor : BasicColor = basicColorFactory.TRANSPARENT_GREY
        val selectedButtonColor : BasicColor = basicColorFactory.TRANSPARENT_RED
        var width : Int = item.getMinimumWidth()
        var height : Int = item.getMinimumHeight()
        //TWB - Adjust gap between menu items rectangles
        var adjustedBorder : Int = 3
        val offset : Int = -(this.halfBorder + adjustedBorder)
        val rectWidth : Int = (width + this.border) - adjustedBorder
        val rectHeight : Int = (height + this.border) - adjustedBorder
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
            this.selectedAnimationArray(index) = new RectangleAdjustedAnimation(rectWidth, rectHeight, offset, offset, selectedButtonColor)
        } else {
            this.selectedAnimationArray(index) = new RectangleFilledAdjustedAnimation(rectWidth, rectHeight, offset, offset, selectedButtonColor)
        }
        //TWB - Adjust gap between menu items rectangles
        adjustedBorder = 4
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
            this.unSelectedAnimationArray(index) = new RectangleAdjustedAnimation(rectWidth, rectHeight, offset, offset, buttonColor)
        } else {
            this.unSelectedAnimationArray(index) = new RectangleFilledAdjustedAnimation(rectWidth, rectHeight, offset, offset, buttonColor)
        }
    }

    private def updateAll(graphics : Graphics, items : Array[ABCustomItem]) : Unit = {

        {
            var index : Int = items.length
            while ({ index -= 1; index } >= 0) {
                items(index).preMeasurement(graphics)
                this.updateAt(index, items(index))
            }
        }
    }

    private def updateAt(index : Int, item : ABCustomItem) : Unit = {
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        val buttonColor : BasicColor = basicColorFactory.TRANSPARENT_GREY
        val selectedButtonColor : BasicColor = basicColorFactory.TRANSPARENT_RED
        val width : Int = item.getMinimumWidth()
        val height : Int = item.getMinimumHeight()
        //TWB - Adjust gap between menu items rectangles
        var adjustedBorder : Int = 3
        val offset : Int = -(this.halfBorder + adjustedBorder)
        val rectWidth : Int = (width + this.border) - adjustedBorder
        val rectHeight : Int = (height + this.border) - adjustedBorder
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
            val rectangleAdjustedAnimation : RectangleAdjustedAnimation = this.selectedAnimationArray(index).asInstanceOf[RectangleAdjustedAnimation]
            rectangleAdjustedAnimation.setWidth(rectWidth)
            rectangleAdjustedAnimation.setHeight(rectHeight)
            rectangleAdjustedAnimation.setOffsetX(offset)
            rectangleAdjustedAnimation.setOffsetY(offset)
            rectangleAdjustedAnimation.setBasicColorP(selectedButtonColor)
        } else {
            val rectangleAdjustedAnimation : RectangleFilledAdjustedAnimation = this.selectedAnimationArray(index).asInstanceOf[RectangleFilledAdjustedAnimation]
            rectangleAdjustedAnimation.setWidth(rectWidth)
            rectangleAdjustedAnimation.setHeight(rectHeight)
            rectangleAdjustedAnimation.setOffsetX(offset)
            rectangleAdjustedAnimation.setOffsetY(offset)
            rectangleAdjustedAnimation.setBasicColorP(selectedButtonColor)
        }
        //TWB - Adjust gap between menu items rectangles
        adjustedBorder = 4
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
            val rectangleAdjustedAnimation : RectangleAdjustedAnimation = this.unSelectedAnimationArray(index).asInstanceOf[RectangleAdjustedAnimation]
            rectangleAdjustedAnimation.setWidth(rectWidth)
            rectangleAdjustedAnimation.setHeight(rectHeight)
            rectangleAdjustedAnimation.setOffsetX(offset)
            rectangleAdjustedAnimation.setOffsetY(offset)
            rectangleAdjustedAnimation.setBasicColorP(buttonColor)
        } else {
            val rectangleAdjustedAnimation : RectangleFilledAdjustedAnimation = this.unSelectedAnimationArray(index).asInstanceOf[RectangleFilledAdjustedAnimation]
            rectangleAdjustedAnimation.setWidth(rectWidth)
            rectangleAdjustedAnimation.setHeight(rectHeight)
            rectangleAdjustedAnimation.setOffsetX(offset)
            rectangleAdjustedAnimation.setOffsetY(offset)
            rectangleAdjustedAnimation.setBasicColorP(buttonColor)
        }
    }

    def getSelectedCommand() : Command = {
        val index : Int = super.getSelectedIndex()
        val commandTextItem : CommandTextItem = this.get(index).asInstanceOf[CommandTextItem]
        return commandTextItem.getCommand()
    }

    override def append(item : ABCustomItem) : Int = {
        var result : Int = super.append(item)
        this.addAt(result, item)
        return result
    }

    override def delete(itemNum : Int) : Unit = {
        super.delete(itemNum)
    }

    override def deleteAll() : Unit = {
        this.initAnimations()
        super.deleteAll()
    }

    override def insert(itemNum : Int, item : ABCustomItem) : Unit = {
        super.insert(itemNum, item)
    }

    override def set(itemNum : Int, item : ABCustomItem) : Unit = {
        super.set(itemNum, item)
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        super.paint(graphics)
    }

    override def paintItem(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        this.selectedAnimationArray(index).paintXY(graphics, x, y)
        return super.paintItem(graphics, index, item, x, y)
    }

    override def paintUnselectedItem(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        this.unSelectedAnimationArray(index).paintXY(graphics, x, y)
        return super.paintUnselectedItem(graphics, index, item, x, y)
    }

}


