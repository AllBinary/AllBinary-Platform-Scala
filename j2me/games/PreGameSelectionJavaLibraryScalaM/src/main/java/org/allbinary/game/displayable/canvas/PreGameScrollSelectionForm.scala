/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.form.FormTypeFactory
import _root_.org.allbinary.graphics.form.ItemPaintableFactory
import _root_.org.allbinary.graphics.form.ScrollCurrentSelectionForm

/**  *  * @author user  */
class PreGameScrollSelectionForm(param_title : String, param_items : Array[ABCustomItem], param_formPaintableFactory : ItemPaintableFactory, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ScrollCurrentSelectionForm(param_title, param_items, param_formPaintableFactory, 0, 3, false, param_backgroundBasicColor, param_foregroundBasicColor) {

    //Constructor
    {
        val title : String = param_title
        val items : Array[ABCustomItem] = param_items
        val formPaintableFactory : ItemPaintableFactory = param_formPaintableFactory
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
    }

    def init(rectangle : Rectangle) : Unit = {
        super.init(rectangle, FormTypeFactory.getInstance().TEMP_HORIZONTAL_FORM)
    }

}


