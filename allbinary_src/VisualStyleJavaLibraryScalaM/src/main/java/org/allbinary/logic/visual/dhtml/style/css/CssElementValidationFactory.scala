/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css

import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.w3c.dom.Node

class CssElementValidationFactory private() {
    import _root_.org.allbinary.logic.visual.dhtml.style.css.CssElementValidationFactory.{*}

}

object CssElementValidationFactory {
    //Node is CssElementData.NAME
    def getInstance(node : Node) : ValidationInterface = {
        return (new CssElementValidation(node)).asInstanceOf[ValidationInterface]
    }

}


