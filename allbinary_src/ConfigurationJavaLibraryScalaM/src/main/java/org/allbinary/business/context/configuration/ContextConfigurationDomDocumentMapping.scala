/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.configuration

import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ContextConfigurationDomDocumentMapping(param_contextConfigurationInterface : ContextConfigurationInterface) extends DomDocumentMappingInterface {

    private var contextConfigurationInterface : ContextConfigurationInterface = null

    //Constructor
    {
        val contextConfigurationInterface : ContextConfigurationInterface = param_contextConfigurationInterface
        this.contextConfigurationInterface = contextConfigurationInterface
    }

    def toXmlDoc() : Document = {
        var document : Document = DomDocumentHelper.create()
        var node : Node = new ContextConfigurationView(this.contextConfigurationInterface).toXmlNode(document)
        document.appendChild(node)
        return document
    }

    def toDomDocumentString() : String = {
        return XmlDocumentHelper.toString(this.toXmlDoc())
    }

}


