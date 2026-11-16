/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.form.item.ABCustomItem

class ScrollSelectionFormVerticalPaintable(param_scrollSelectionForm : ScrollSelectionForm) extends ItemIndexPaintable {

    private var scrollSelectionForm : ScrollSelectionForm = null

    //Constructor
    {
        val scrollSelectionForm : ScrollSelectionForm = param_scrollSelectionForm
        this.scrollSelectionForm = scrollSelectionForm
    }

    override def paint(graphics : Graphics, index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return this.scrollSelectionForm.paintItemVertical(graphics, index, item, dx, dy)
    }

}


