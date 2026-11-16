/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.w3c.dom.Node

class CssElementsValidationFactory private() {
    import _root_.org.allbinary.logic.visual.dhtml.style.css.CssElementsValidationFactory.{*}

}

object CssElementsValidationFactory {
    //Nodes with CssElementData.NAME
    def getInstance(cssElementStyleNodeList : BasicArrayList) : BasicArrayList = {
        val styles : BasicArrayList = new BasicArrayListD()
        val size : Int = cssElementStyleNodeList.size()
        var cssElementStyleNode : Node = null
        var cssValidationInterface : ValidationInterface = null

        {
            var index : Int = 0
            while (index < size) {
                cssElementStyleNode = cssElementStyleNodeList.get(index).asInstanceOf[Node]
                cssValidationInterface = CssElementValidationFactory.getInstance(cssElementStyleNode).asInstanceOf[ValidationInterface]
                styles.add(cssValidationInterface)
                index += 1
            }
        }
        return styles
    }

    def getInstance(hashMap : HashMap[Object, Object]) : BasicArrayList = {
        val styles : BasicArrayList = new BasicArrayListD()
        return styles
    }

}


