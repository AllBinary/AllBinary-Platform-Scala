/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Canvas
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.RectangleCollisionUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class ScrollSelectionForm(param_title : String, param_items : Array[ABCustomItem], param_formPaintableFactory : ItemPaintableFactory, param_border : Int, param_adjustedExtraBorder : Int, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends PaintableForm(param_title, param_items, param_backgroundBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.graphics.form.ScrollSelectionForm.{*}

    private val rectangleCollisionUtil : RectangleCollisionUtil = RectangleCollisionUtil.getInstance()

    var border : Int = 0

    var halfBorder : Int = 0

    private var buttonBasicColor : BasicColor = null

    var scrollSelectionFormFormTypeItemIndexPaintable : ItemIndexPaintable = ItemIndexPaintable.getInstance()

    private var formTypeItemIndexDx : ItemIndexDx = ItemIndexDx.getInstance()

    var paintable : ItemPaintable = ItemPaintableFactory.getInstance()

    private var adjustedExtraBorder : Int = 0

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val formPaintableFactory : ItemPaintableFactory = param_formPaintableFactory
        val border : Int = param_border
        val adjustedExtraBorder : Int = param_adjustedExtraBorder
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.adjustedExtraBorder = adjustedExtraBorder
        this.buttonBasicColor = foregroundBasicColor
        //        }
        this.border = border
        this.halfBorder = (border >> 1)
        this.paintable = formPaintableFactory.getInstanceItemPaintable(this)
    }

    override def init(rectangle : Rectangle, formType : FormType) : Unit = {
        super.init(rectangle, formType)
        //this.logUtil.putF("ScrollSelectionForm formType: " + formType.toString(), this, this.commonStrings.INIT);
        val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
        if (formType eq formTypeFactory.HORIZONTAL_FORM) {
            this.scrollSelectionFormFormTypeItemIndexPaintable = new ScrollSelectionFormHorizontalPaintable(this)
            this.formTypeItemIndexDx = new ScrollSelectionFormHorizontalDx(this)
        } else if (formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
            this.scrollSelectionFormFormTypeItemIndexPaintable = new ScrollSelectionFormVerticalPaintable(this)
            this.formTypeItemIndexDx = new ScrollSelectionFormVericalDx(this)
        } else if (formType eq formTypeFactory.TEMP_HORIZONTAL_FORM) {
            this.scrollSelectionFormFormTypeItemIndexPaintable = new ScrollSelectionFormTempHorizontalPaintable(this)
            this.formTypeItemIndexDx = new ScrollSelectionFormTempHorizontalDx(this)
        } else if (formType eq formTypeFactory.NULL_FORM_TYPE) {
        } else {
            throw new Exception(formTypeFactory.UNK)
        }
    }

    def paintItemHorizontal(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        val width : Int = item.getMinimumWidth()
        return (x + width) + this.border
    }

    def paintItemVertical(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        val height : Int = item.getMinimumHeight()
        return (y + height) + this.border
    }

    def paintItemTempHorizontal(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        return 0
    }

    def getSelectedIndexForPointHorizontalDx(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return dx - this.halfBorder
    }

    def getSelectedIndexForPointVerticalDx(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return dx + this.getDiffX(item)
    }

    def getSelectedIndexForPointTempHorizontalDx(index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return dx + this.getDiffX(item)
    }

    override def append(item : ABCustomItem) : Int = {
        //((FormItemInterface) item).setOwner(this);
        return super.append(item)
    }

    def getSelectedItem(point : GPoint) : ABCustomItem = {
        var index : Int = this.getSelectedIndexForPoint(point)
        if (index != -1) {
            return this.get(index)
        } else {
            return ABCustomItem.getNullInstance()
        }
        throw new IllegalStateException()
    }

    def getItemIndex(item : ABCustomItem) : Int = {
        var nextItem : ABCustomItem = null
        val size : Int = this.size()

        {
            var index : Int = 0
            while (index < size) {
                nextItem = this.get(index).asInstanceOf[ABCustomItem]
                if (nextItem eq item) {
                    return index
                }
                index += 1
            }
        }
        return -1
    }

    def getStartIndex() : Int = {
        return 0
    }

    def getSelectedIndexForPoint(point : GPoint) : Int = {
        val start : Int = this.getStartIndex()
        val size : Int = this.size()
        var dx : Int = this.getDx()
        var dy : Int = this.getDy()
        val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(commonLabels.START_LABEL)
        stringBuffer.appendint(start)
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(commonLabels.TOTAL_LABEL)
        stringBuffer.appendint(size)
        this.logUtil.putF(stringBuffer.toString(), this, ScrollSelectionForm.GET_SELECTED_INDEX)
        var item : ABCustomItem = null
        var width : Int = 0
        var height : Int = 0
        var diffX : Int = 0

        {
            var index : Int = start
            scala.util.boundary { (break_N74647 : scala.util.boundary.Label[Unit]) ?=>
                while (index < size) {
                    item = this.get(index)
                    width = item.getMinimumWidth()
                    height = item.getMinimumHeight()
                    //int diffX = dx + this.getDiffX(item) - this.halfBorder;
                    diffX = this.formTypeItemIndexDx.getDx(index, item, dx, dy)
                    //if (RectangleCollisionUtil.isInside(dx, dy, dx + width, this.rectangle.getMaxY(),
                    if (this.rectangleCollisionUtil.isInside(diffX, dy - this.halfBorder, (diffX + width) + this.border, ((dy + height) + this.halfBorder) + 1, point.getX(), point.getY())) {
                        stringBuffer.delete(0, stringBuffer.length())
                        stringBuffer.append(commonLabels.ITEM_LABEL)
                        stringBuffer.append(item.getLabel())
                        stringBuffer.append(CommonSeps.getInstance().SPACE)
                        stringBuffer.append(commonLabels.INDEX_LABEL)
                        stringBuffer.appendint(index)
                        this.logUtil.putF(stringBuffer.toString(), this, ScrollSelectionForm.GET_SELECTED_INDEX)
                        return index
                    }
                    if (this.formType eq formTypeFactory.HORIZONTAL_FORM) {
                        dx = (dx + width) + this.border
                        // dx = dx + width;
                        if (dx > this.rectangle.getMaxX()) {
                            scala.util.boundary.break()(using break_N74647)
                        }
                    } else if (this.formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
                        dy = (dy + height) + this.border
                        if (dy > this.rectangle.getMaxY()) {
                            scala.util.boundary.break()(using break_N74647)
                        }
                    } else if (this.formType eq formTypeFactory.NULL_FORM_TYPE) {
                    } else {
                        throw new Exception(formTypeFactory.UNK)
                    }
                    index += 1
                }
            }
        }
        return -1
    }

    def processInputKey(gameKeyCode : Int) : Int = {
        //PreLogUtil.put("Start - Selected " commonLabels.INDEX_LABEL).append(this.getSelectedIndex()).append(" of: ").append(this.size(), this, GameInputStrings.getInstance());
        val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
        if (this.size() == 0) {
            return -1
        }
        var index : Int = this.getSelectedIndex()
        if ((this.formType eq formTypeFactory.HORIZONTAL_FORM) || (this.formType eq formTypeFactory.TEMP_HORIZONTAL_FORM)) {
            if (gameKeyCode == Canvas.RIGHT) {
                index += 1
            } else if (gameKeyCode == Canvas.LEFT) {
                index -= 1
            }
        } else if (this.formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
            if (gameKeyCode == Canvas.DOWN) {
                index += 1
            } else if (gameKeyCode == Canvas.UP) {
                index -= 1
            }
        } else if (this.formType eq formTypeFactory.NULL_FORM_TYPE) {
        } else {
            throw new Exception(formTypeFactory.UNK)
        }
        val max : Int = this.size() - 1
        if (index < 0) {
            this.setSelectedIndex(0)
        } else if (index > max) {
            this.setSelectedIndex(max)
        } else {
            this.setSelectedIndex(index)
        }
        //this.logUtil.putF("End - Selected ").append(commonLabels.INDEX_LABEL).append(this.getSelectedIndex(), this, GameInputStrings.getInstance());
        return -1
    }

    def isInForm(point : GPoint) : Boolean = {
        //- halfBorder
        if (this.rectangleCollisionUtil.isInside(this.x, this.y - this.halfBorder, this.rectangle.getMaxX() + this.border, this.rectangle.getMaxY() + this.border, point.getX(), point.getY())) {
            this.logUtil.putF(new StringMaker().append(StringUtil.getInstance().toString(point)).append(ScrollSelectionForm.INSIDE_FORM).toString(), this, ScrollSelectionForm.IS_IN_FORM)
            return true
        }
        return false
    }

    def paintItem(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        item.paintXY(graphics, x, y)
        val width : Int = item.getMinimumWidth()
        val height : Int = item.getMinimumHeight()
        graphics.setColor(this.getButtonBasicColor().intValue())
        //TWB - Adjust gap between menu items rectangles
        val adjustedBorder : Int = 3
        //graphics.drawRect(x - border, y - border_y, width + border, height + border);
        graphics.drawRect((x - this.halfBorder) - adjustedBorder, (y - this.halfBorder) - adjustedBorder, (width + this.border) + this.adjustedExtraBorder, (height + this.border) + this.adjustedExtraBorder)
        return this.scrollSelectionFormFormTypeItemIndexPaintable.paint(graphics, index, item, x, y)
    }

    def paintUnselectedItem(graphics : Graphics, index : Int, item : ABCustomItem, x : Int, y : Int) : Int = {
        //graphics.setColor(BasicColor.GREY.intValue());
        graphics.setColor(this.getButtonBasicColor().intValue())
        item.paintUnselected(graphics, x, y)
        return this.scrollSelectionFormFormTypeItemIndexPaintable.paint(graphics, index, item, x, y)
    }

    def getDiffX(item : ABCustomItem) : Int = {
        return 0
    }

    /**      * @return the dx      */
    def getDx() : Int = {
        return this.x
    }

    /**      * @return the dy      */
    def getDy() : Int = {
        return this.y
    }

    def setButtonBasicColor(buttonBasicColor : BasicColor) : Unit = {
        this.buttonBasicColor = buttonBasicColor
    }

    private def getButtonBasicColor() : BasicColor = {
        return this.buttonBasicColor
    }

}

object ScrollSelectionForm {
    private def createForm(title : String, items : Array[ABCustomItem], formPaintableFactory : ItemPaintableFactory, border : Int, backgroundBasicColor : BasicColor, foregroundBasicColor : BasicColor) : PaintableForm = {
        try {
            if (formPaintableFactory eq ItemPaintableFactory.getInstance()) {
                return new ScrollSelectionForm(title, items, formPaintableFactory, border, -3, backgroundBasicColor, foregroundBasicColor)
            } else {
                //This call should only work with ItemPaintableFactory.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.putF(commonStrings.EXCEPTION, logUtil, commonStrings.EXCEPTION)
                //throw new RuntimeException();
                return PaintableForm.getNullPaintableForm()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                val logUtil : LogUtil = LogUtil.getInstance()
                logUtil.put(commonStrings.EXCEPTION, logUtil, commonStrings.EXCEPTION, e)
                //throw new RuntimeException();
                return PaintableForm.getNullPaintableForm()
            }
        }
        throw new IllegalStateException()
    }

    private var NULL_SCROLL_SELECTION_FORM : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullScrollSelectionForm() : ScrollSelectionForm = {
        if (ScrollSelectionForm.NULL_SCROLL_SELECTION_FORM eq NullUtil.getInstance().NULL_OBJECT) {
            ScrollSelectionForm.NULL_SCROLL_SELECTION_FORM = ScrollSelectionForm.createForm(StringUtil.getInstance().EMPTY_STRING, new Array[ABCustomItem](0), ItemPaintableFactory.getInstance(), 0, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return ScrollSelectionForm.NULL_SCROLL_SELECTION_FORM.asInstanceOf[ScrollSelectionForm]
    }

    private var NULL_SCROLL_SELECTION_HORIZONTAL_FORM : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullScrollSelectionFormHorizontal() : ScrollSelectionForm = {
        if (ScrollSelectionForm.NULL_SCROLL_SELECTION_HORIZONTAL_FORM eq NullUtil.getInstance().NULL_OBJECT) {
            ScrollSelectionForm.NULL_SCROLL_SELECTION_HORIZONTAL_FORM = ScrollSelectionForm.createForm(StringUtil.getInstance().EMPTY_STRING, new Array[ABCustomItem](0), ItemPaintableFactory.getInstance(), 0, BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return ScrollSelectionForm.NULL_SCROLL_SELECTION_HORIZONTAL_FORM.asInstanceOf[ScrollSelectionForm]
    }

    private val INSIDE_FORM : String = " inside form"

    private val IS_IN_FORM : String = "isInForm"

    private val GET_SELECTED_INDEX : String = "getSelectedIndexForPoint"

}


