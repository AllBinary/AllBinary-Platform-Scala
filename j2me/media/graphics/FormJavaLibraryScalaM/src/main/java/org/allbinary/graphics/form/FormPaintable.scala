/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.Paintable

class FormPaintable(param_form : PaintableForm) extends Paintable {

    private var form : PaintableForm = null

    //Constructor
    {
        val form : PaintableForm = param_form
        this.form = form
    }

    override def paint(graphics : Graphics) : Unit = {
        this.form.paint(graphics)
    }

    def getForm() : PaintableForm = {
        return this.form
    }

}


