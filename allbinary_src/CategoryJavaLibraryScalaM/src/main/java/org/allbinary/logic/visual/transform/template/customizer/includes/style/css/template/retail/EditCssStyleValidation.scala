/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.includes.style.css.template.retail

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.visual.dhtml.style.StyleData
import _root_.org.allbinary.logic.visual.dhtml.style.StylesData
import _root_.org.allbinary.logic.visual.dhtml.style.color.ColorsView
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EditCssStyleValidation private (super_1 : Document, constructor_ : Unit) extends CssStyleValidation(super_1) with ValidationInterface with DomNodeInterface {

    def this(document : Document) = {
        this(document, ())
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this(hashMap, ())
    }

    def this() = {
        this(null, ())
    }

    override def isValid() : _root_.java.lang.Boolean = {
        return super.isValid()
    }

    override def validationInfo() : String = {
        return super.validationInfo()
    }

    override def toValidationInfoDoc() : Document = {
        return null
    }

    override def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(StylesData.getInstance().NAME)
        var styleNode : Node = document.createElement(StyleData.getInstance().NAME)
        node.appendChild(styleNode)
        styleNode.appendChild(new ColorsView().toXmlNode(document))
        var size : Int = this.cssStyleElementVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var styleDomNodeInterface : DomNodeInterface = cssStyleElementVector.get(i).asInstanceOf[DomNodeInterface]
                styleNode.appendChild(styleDomNodeInterface.toXmlNode(document))
                i += 1
            }
        }
        return node
    }

}


