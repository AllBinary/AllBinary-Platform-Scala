/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.w3c.dom.Attr
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.NamedNodeMap
import _root_.org.w3c.dom.Node

class TransformInfoDomNodeView private (super_1 : TransformInfoInterface, super_2 : String, constructor_ : Unit) extends TransformInfoDomNode(super_1, super_2) with DomNodeInterface {

    def this(transformInfoInterface : TransformInfoInterface, mapping : String) = {
        this(transformInfoInterface, mapping, ())
    }

    def this(name : String, mappedName : String) = {
        this(name, mappedName, ())
    }

    def this(transformInfoInterface : TransformInfoInterface) = {
        this(transformInfoInterface, null, ())
    }

    def this(name : String) = {
        this(name, null, ())
    }

    def toXmlNode(document : Document) : Node = {
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var subViewNode : Node = document.createElement(transformInfoData.NAME)
        var viewNameAttr : Attr = document.createAttribute(transformInfoData.NAME)
        viewNameAttr.setValue(this.getTransformInfoInterface().getName())
        //subViewNode.appendChild(viewNameAttr);
        var componentNodeAttributes : NamedNodeMap = subViewNode.getAttributes()
        componentNodeAttributes.setNamedItem(viewNameAttr)
        if (this.getMappedName() != null) {
            var mappedNameAttr : Attr = document.createAttribute(transformInfoData.MAPPED)
            mappedNameAttr.setValue(this.getMappedName())
            componentNodeAttributes.setNamedItem(mappedNameAttr)
        }
        return subViewNode
    }

}


