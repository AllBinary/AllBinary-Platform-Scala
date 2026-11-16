/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.configuration

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationData
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationInterface
import _root_.org.allbinary.logic.communication.smtp.configuration.server.EmailServerConfigurationView
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class ContextConfigurationView private () extends DomNodeInterface {

    private var contextConfigurationInterface : ContextConfigurationInterface = null

    def this(node : Node) = {
        this()
        var childNodeList : NodeList = node.getChildNodes()
        this.contextConfigurationInterface = new ContextConfiguration()
        var emailConfigurationNode : Node = DomSearchHelper.getNode(EmailServerConfigurationData.NAME, childNodeList)
        var emailServerConfigurationView : EmailServerConfigurationView = new EmailServerConfigurationView(emailConfigurationNode)
        this.contextConfigurationInterface.setEmailServerConfigurationInterface(emailServerConfigurationView.getEmailConfigurationInterface().asInstanceOf[EmailServerConfigurationInterface])
    }

    def this(contextConfigurationInterface : ContextConfigurationInterface) = {
        this()
        this.contextConfigurationInterface = contextConfigurationInterface
    }

    def getContextConfigurationInterface() : ContextConfigurationInterface = {
        return this.contextConfigurationInterface
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(ContextConfigurationData.getInstance().NAME)
        var emailServerConfigurationView : EmailServerConfigurationView = new EmailServerConfigurationView(this.getContextConfigurationInterface().getEmailServerConfigurationInterface())
        node.appendChild(emailServerConfigurationView.toXmlNode(document))
        return node
    }

}


