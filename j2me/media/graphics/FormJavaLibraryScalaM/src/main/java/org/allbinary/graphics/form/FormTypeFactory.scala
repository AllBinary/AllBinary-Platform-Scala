/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.string.StringUtil

class FormTypeFactory {
    import _root_.org.allbinary.graphics.form.FormTypeFactory.{*}

    val UNK : String = "Unknown FormType"

    val NULL_FORM_TYPE : FormType = new FormType(StringUtil.getInstance().NULL_STRING)

    val TEMP_HORIZONTAL_FORM : FormType = new FormType("TempHorizontal")

    val HORIZONTAL_FORM : FormType = new FormType("Horizontal")

    val VERTICAL_CENTER_FORM : FormType = new FormType("Vertical")

    def getFormType() : FormType = {
        var displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        var formType : FormType = null
        if (displayInfo.isPortrait()) {
            formType = this.VERTICAL_CENTER_FORM
        } else {
            formType = this.HORIZONTAL_FORM
        }
        return formType
    }

}

object FormTypeFactory {
    private val instance : FormTypeFactory = new FormTypeFactory()

    def getInstance() : FormTypeFactory = {
        return FormTypeFactory.instance
    }

}


