/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.canvas.Processor
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.form.item.ABCustomItem

class ScrollCurrentSelectionForm(param_title : String, param_items : Array[ABCustomItem], param_formPaintableFactory : ItemPaintableFactory, param_border : Int, param_adjustedExtraBorder : Int, param_moveForSmallScreen : Boolean, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ScrollSelectionForm(param_title, param_items, param_formPaintableFactory, param_border, param_adjustedExtraBorder, param_backgroundBasicColor, param_foregroundBasicColor) with UpdateMyFontInterface {

    private var moveForSmallScreen : Boolean = false

    val updateMyFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    var myFontProcessor : MyFontProcessor = this.updateMyFontProcessor

    var processor : Processor = Processor.getInstance()

    private var preItemIndexDx : ItemIndexDx = ItemIndexDx.getInstance()

    private var dx : Int = 0

    private var dy : Int = 0

    private var maxWidth : Int = 0

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val formPaintableFactory : ItemPaintableFactory = param_formPaintableFactory
        val border : Int = param_border
        val adjustedExtraBorder : Int = param_adjustedExtraBorder
        val moveForSmallScreen : Boolean = param_moveForSmallScreen
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.moveForSmallScreen = moveForSmallScreen
    }

    override def init(rectangle : Rectangle, formType : FormType) : Unit = {
        super.init(rectangle, formType)
        //this.logUtil.putF("ScrollCurrentSelectionForm formType: " + formType.toString(), this, this.commonStrings.INIT);
        val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
        if (formType eq formTypeFactory.TEMP_HORIZONTAL_FORM) {
            this.processor = new TempHorizontalFormProcessor(this)
            this.preItemIndexDx = new TempHorizontalItemIndexDx(this)
        } else if (formType eq formTypeFactory.HORIZONTAL_FORM) {
            this.processor = new HorizontalFormProcessor(this)
            this.preItemIndexDx = new HorizontalItemIndexDx(this)
        } else if (formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
            this.processor = new VerticalFormProcessor(this)
            this.preItemIndexDx = new VerticalItemIndexDx(this)
        } else if (formType eq formTypeFactory.NULL_FORM_TYPE) {
        } else {
            this.logUtil.putF(formTypeFactory.UNK, this, this.commonStrings.INIT)
        }
        this.myFontProcessor = this.updateMyFontProcessor
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def processTempHorizontalForm() : Unit = {
        this.dx = (this.x - 30) + (this.rectangle.getWidth() >> 1)
        this.dy = this.y
    }

    def processHorizontalForm() : Unit = {
        val size : Int = this.size()
        var totalWidth : Int = 0
        var item : ABCustomItem = null

        {
            var index : Int = 0
            while (index < size) {
                item = this.get(index)
                totalWidth += item.getMinimumWidth() + this.border
                index += 1
            }
        }
        this.dx = (this.x + (this.rectangle.getWidth() >> 1)) - (totalWidth >> 1)
        /*             int maxHeight = 0;              for (int index = 0; index < size; index++)             {                 FormItemInterface item = (FormItemInterface) this.get(index);                  if(item.getMinimumHeight() > maxHeight)                 {                     maxHeight = item.getMinimumHeight();                 }             }          */
        this.dy = this.y + (this.rectangle.getHeight() >> 1)
        // animation
        if (this.moveForSmallScreen) {
            var maxTitleHeight : Int = 175
            if (this.dy < maxTitleHeight) {
                this.dy = maxTitleHeight
            }
        }
    }

    def processVerticalForm() : Unit = {
        var totalHeight : Int = 0
        val size : Int = this.size()
        var item2 : ABCustomItem = null

        {
            var index : Int = 0
            while (index < size) {
                item2 = this.get(index)
                if (this.maxWidth < item2.getMinimumWidth()) {
                    this.maxWidth = item2.getMinimumWidth()
                }
                totalHeight += item2.getMinimumHeight() + this.border
                index += 1
            }
        }
        this.dx = ((this.rectangle.getWidth() - this.maxWidth) / 2)
        // dx = this.rectangle.getWidth() - maxWidth;
        if (this.size() > 0) {
            // item.getMinimumHeight()) / 2);
            this.dy = this.y + ((this.rectangle.getHeight() - totalHeight) / 2)
            // animation
            if (this.moveForSmallScreen) {
                var maxTitleHeight : Int = 175
                if (this.dy < maxTitleHeight) {
                    this.dy = maxTitleHeight
                }
            }
        } else {
            // dy = y - 30 + ((this.rectangle.getHeight()) >> 1);
            this.dy = this.y
        }
    }

    def getXTempHorizontalForm(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return this.getDiffX(item)
    }

    def getXHorizontalForm(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        //this.halfBorder;
        return 0
    }

    def getXVerticalForm(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return this.getDiffX(item) + this.halfBorder
    }

    override def getDiffX(item : ABCustomItem) : Int = {
        return ((this.maxWidth - item.getMinimumWidth()) >> 1)
    }

    /**      * @return the dx      */
    override def getDx() : Int = {
        return this.dx
    }

    /**      * @return the dy      */
    override def getDy() : Int = {
        return this.dy
    }

    override def paint(graphics : Graphics) : Unit = {
        try {
            this.processor.process()
            var delta : Int = 0
            var deltaX : Int = this.getDx()
            var deltaY : Int = this.getDy()
            val size : Int = this.size()
            val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
            var item : ABCustomItem = null

            {
                var index : Int = 0
                while (index < size) {
                    item = this.get(index)
                    var diffX : Int = this.preItemIndexDx.getDx(index, item, this.dx, this.dy)
                    if (index == this.getSelectedIndex()) {
                        delta = this.paintItem(graphics, index, item, deltaX + diffX, deltaY)
                        this.paintable.paint(graphics, index, deltaX + diffX, deltaY)
                    } else {
                        delta = this.paintUnselectedItem(graphics, index, item, deltaX + diffX, deltaY)
                        this.paintable.paint(graphics, index, deltaX + diffX, deltaY)
                    }
                    if (this.formType eq formTypeFactory.TEMP_HORIZONTAL_FORM) {
                    } else if (this.formType eq formTypeFactory.HORIZONTAL_FORM) {
                        deltaX = delta
                    } else if (this.formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
                        deltaY = delta
                    } else {
                        throw new Exception(formTypeFactory.UNK)
                    }
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.PAINT, e)
            }
        }
    }

}


