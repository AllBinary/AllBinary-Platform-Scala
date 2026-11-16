/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property

import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.visual.dhtml.style.css.property.font.FontFamilyValidation
import _root_.org.w3c.dom.Node

class CssPropertyValidationFactory private() {
    import _root_.org.allbinary.logic.visual.dhtml.style.css.property.CssPropertyValidationFactory.{*}

}

object CssPropertyValidationFactory {
    def getInstance(node : Node) : ValidationInterface = {
        return (new FontFamilyValidation(node)).asInstanceOf[ValidationInterface]
    }

}


