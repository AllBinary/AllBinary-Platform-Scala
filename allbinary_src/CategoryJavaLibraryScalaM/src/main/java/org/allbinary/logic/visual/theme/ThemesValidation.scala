/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.theme

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ThemesValidation() extends Validation with DomNodeInterface {

    private var themeVector : BasicArrayList = null

    //Constructor
    {
        this.themeVector = new BasicArrayListD()
    }

    def this(node : Node) = {
        this()
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
    }

    override def isValid() : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.TRUE
    }

    override def validationInfo() : String = {
        return null
    }

    override def toValidationInfoDoc() : Document = {
        return null
    }

    override def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(ThemesData.getInstance().NAME)
        var size : Int = this.themeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var themeDomNodeInterface : DomNodeInterface = this.themeVector.get(i).asInstanceOf[DomNodeInterface]
                node.appendChild(themeDomNodeInterface.toXmlNode(document))
                i += 1
            }
        }
        return node
    }

}


