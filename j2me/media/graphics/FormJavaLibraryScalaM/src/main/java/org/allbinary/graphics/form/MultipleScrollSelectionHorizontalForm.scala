/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker

/**  *   * @author user  */
class MultipleScrollSelectionHorizontalForm(param_title : String, param_items : Array[ABCustomItem], param_formPaintableFactory : ItemPaintableFactory, param_border : Int, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ScrollSelectionForm(param_title, param_items, param_formPaintableFactory, param_border, 3, param_backgroundBasicColor, param_foregroundBasicColor) with UpdateMyFontInterface {
    import _root_.org.allbinary.graphics.form.MultipleScrollSelectionHorizontalForm.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var rectPaintable : Paintable = NullPaintable.getInstance()

    private var multipleScrollSelectionHorizontalFormTypeItemIndexPaintable : ItemIndexPaintable = ItemIndexPaintable.getInstance()

    private val backgroundColor : Int = BasicColorFactory.getInstance().TRANSPARENT_GREY.intValue()

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var logged : Boolean = false

    private var fontHeight : Int = 0

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val formPaintableFactory : ItemPaintableFactory = param_formPaintableFactory
        val border : Int = param_border
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        if (J2MEUtil.isJ2ME() || J2MEUtil.isHTML()) {
        } else {
            this.rectPaintable = new MultipleScrollSelectionFormRectPaintable(this)
        }
    }

    def fillRect(graphics : Graphics) : Unit = {
        graphics.setColor(this.backgroundColor)
        graphics.fillRect(this.x, this.y, this.rectangle.getWidth(), this.rectangle.getHeight())
    }

    override def init(rectangle : Rectangle, formType : FormType) : Unit = {
        super.init(rectangle, formType)
        //this.logUtil.putF("MultipleScrollSelectionHorizontalForm formType: " + formType.toString(), this, this.commonStrings.INIT);
        val formTypeFactory : FormTypeFactory = FormTypeFactory.getInstance()
        if (formType eq formTypeFactory.HORIZONTAL_FORM) {
            this.multipleScrollSelectionHorizontalFormTypeItemIndexPaintable = new MultipleScrollSelectionFormHorizontalPaintable(this)
        } else if (formType eq formTypeFactory.VERTICAL_CENTER_FORM) {
            this.multipleScrollSelectionHorizontalFormTypeItemIndexPaintable = new MultipleScrollSelectionFormVerticalPaintable(this)
        } else if (formType eq formTypeFactory.NULL_FORM_TYPE) {
        } else {
            throw new Exception(formTypeFactory.UNK)
        }
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def paintHorizontal(graphics : Graphics, index : Int, item : ABCustomItem, param_dx : Int, dy : Int) : Int = {
        var dx : Int = param_dx
        var dx2 : Int = this.paintItem(graphics, index, item, dx, dy) + this.border
        this.paintable.paint(graphics, index, dx, dy)
        dx = dx2
        return dx
    }

    def paintVertical(graphics : Graphics, index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        //+ border
        this.paintItem(graphics, index, item, dx, dy)
        //int dy2 = 
        this.paintable.paint(graphics, index, dx, dy)
        //dy2 = dy;
        return dx
    }

    override def getStartIndex() : Int = {
        return this.getSelectedIndex()
    }

    override def paint(graphics : Graphics) : Unit = {
        try {
            this.myFontProcessor.process(graphics)
            val start : Int = this.getStartIndex()
            val size : Int = this.size()
            var dx : Int = this.x
            val dy : Int = this.y
            this.rectPaintable.paint(graphics)
            graphics.drawString(this.getTitle(), this.x, this.y - this.fontHeight, 0)
            var item : ABCustomItem = null

            {
                var index : Int = start
                while (index < size) {
                    item = this.get(index)
                    if (dx >= this.rectangle.getMaxX()) {
                        if (this.logged) {
                        } else {
                            this.logged = true
                            PreLogUtil.put(new StringMaker().append("painting beyond maxx: ").appendint(this.rectangle.getMaxX()).toString(), this, this.canvasStrings.PAINT)
                        }
                    }
                    dx = this.multipleScrollSelectionHorizontalFormTypeItemIndexPaintable.paint(graphics, index, item, dx, dy)
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                PreLogUtil.put(this.commonStrings.EXCEPTION, this, this.canvasStrings.PAINT)
            }
        }
    }

}

object MultipleScrollSelectionHorizontalForm {
    def createForm(title : String, items : Array[ABCustomItem], rectangle : Rectangle, formType : FormType, border : Int, backgroundBasicColor : BasicColor, foregroundBasicColor : BasicColor) : ScrollSelectionForm = {
        val scrollSelectionForm : ScrollSelectionForm = new MultipleScrollSelectionHorizontalForm(title, items, ItemPaintableFactory.getInstance(), border, backgroundBasicColor, foregroundBasicColor)
        scrollSelectionForm.init(rectangle, formType)
        return scrollSelectionForm
    }

}


