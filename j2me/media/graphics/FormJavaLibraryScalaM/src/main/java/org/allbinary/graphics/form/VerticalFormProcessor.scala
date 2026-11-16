/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.org.allbinary.canvas.Processor

class VerticalFormProcessor(param_scrollCurrentSelectionForm : ScrollCurrentSelectionForm) extends Processor {

    private var scrollCurrentSelectionForm : ScrollCurrentSelectionForm = null

    //Constructor
    {
        val scrollCurrentSelectionForm : ScrollCurrentSelectionForm = param_scrollCurrentSelectionForm
        this.scrollCurrentSelectionForm = scrollCurrentSelectionForm
    }

    override def process() : Unit = {
        this.scrollCurrentSelectionForm.processVerticalForm()
        this.scrollCurrentSelectionForm.processor = Processor.getInstance()
    }

}


