/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class CssPropertiesValidationFactory private() {
    import _root_.org.allbinary.logic.visual.dhtml.style.css.property.CssPropertiesValidationFactory.{*}

}

object CssPropertiesValidationFactory {
    //Create Properties from Nodes with CssPropertyData.NAME
    def getInstance(nodeList : NodeList) : BasicArrayList = {
        var propertiesVector : BasicArrayList = new BasicArrayListD()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var node : Node = nodeList.item(index)
                //Some Nodes May Not Be Property Nodes
                if (node.getNodeName().compareTo(CssPropertyData.getInstance().NAME) == 0) {
                    var cssPropertyValidationInterface : ValidationInterface = CssPropertyValidationFactory.getInstance(node).asInstanceOf[ValidationInterface]
                    propertiesVector.add(cssPropertyValidationInterface)
                }
                index += 1
            }
        }
        return propertiesVector
    }

    def getInstance(hashMap : HashMap[Object, Object]) : BasicArrayList = {
        var styles : BasicArrayList = new BasicArrayListD()
        return styles
    }

}


