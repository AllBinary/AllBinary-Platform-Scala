/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.TouchFeatureFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.form.item.ABCustomItem

class CommandCurrentSelectionFormFactory {
    import _root_.org.allbinary.graphics.form.CommandCurrentSelectionFormFactory.{*}

}

object CommandCurrentSelectionFormFactory {
    def getInstance(title : String, items : Array[ABCustomItem], rectangle : Rectangle, formType : FormType, border : Int, moveForSmallScreen : Boolean, backgroundBasicColor : BasicColor, foregroundBasicColor : BasicColor) : ScrollSelectionForm = {
        if (Features.getInstance().isFeature(TouchFeatureFactory.getInstance().TOUCH_ENABLED)) {
            val scrollSelectionForm : ScrollSelectionForm = new CommandCurrentSelectionForm(title, items, border, moveForSmallScreen, backgroundBasicColor, foregroundBasicColor)
            scrollSelectionForm.init(rectangle, formType)
            return scrollSelectionForm
        } else {
            return ScrollSelectionFormNoneFactory.getInstance()
        }
        throw new IllegalStateException()
    }

}


