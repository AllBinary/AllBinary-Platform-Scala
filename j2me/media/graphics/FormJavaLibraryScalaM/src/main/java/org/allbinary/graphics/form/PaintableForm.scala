/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

class PaintableForm(param_title : String, param_items : Array[ABCustomItem], param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABCustomForm(param_title, param_items, param_backgroundBasicColor, param_foregroundBasicColor) {
    import _root_.org.allbinary.graphics.form.PaintableForm.{*}

    val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    var rectangle : Rectangle = RectangleFactory.SINGLETON

    var x : Int = 0

    var y : Int = 0

    var formType : FormType = FormTypeFactory.getInstance().NULL_FORM_TYPE

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.setSelectedIndex(0)
    }

    def init(rectangle : Rectangle, formType : FormType) : Unit = {
        //this.logUtil.putF("PaintableForm formType: " + formType.toString(), this, this.commonStrings.INIT);
        this.rectangle = rectangle
        val point : GPoint = this.rectangle.getPoint()
        this.x = point.getX()
        this.y = point.getY()
        this.formType = formType
    }

    override def getWidth() : Int = {
        return this.rectangle.getWidth()
    }

}

object PaintableForm {
    private var NULL_PAINTABLE_FORM : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullPaintableForm() : PaintableForm = {
        if (PaintableForm.NULL_PAINTABLE_FORM eq NullUtil.getInstance().NULL_OBJECT) {
            PaintableForm.NULL_PAINTABLE_FORM = new PaintableForm(StringUtil.getInstance().EMPTY_STRING, new Array[ABCustomItem](0), BasicColorFactory.getInstance().BLACK, BasicColorFactory.getInstance().WHITE)
        }
        return PaintableForm.NULL_PAINTABLE_FORM.asInstanceOf[PaintableForm]
    }

}


