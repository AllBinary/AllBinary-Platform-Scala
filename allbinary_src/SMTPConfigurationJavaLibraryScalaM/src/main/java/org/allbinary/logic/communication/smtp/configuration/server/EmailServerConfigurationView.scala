/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.server

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class EmailServerConfigurationView private () extends DomNodeInterface {

    private var emailServerConfigurationInterface : EmailServerConfigurationInterface = null

    def this(node : Node) = {
        this()
        var childNodeList : NodeList = node.getChildNodes()
        var server : String = DomNodeHelper.getTextNodeValue(EmailServerConfigurationData.SERVER, childNodeList)
        var accountName : String = DomNodeHelper.getTextNodeValue(EmailServerConfigurationData.ACCOUNT, childNodeList)
        var password : String = DomNodeHelper.getTextNodeValue(EmailServerConfigurationData.PASSWORD, childNodeList)
        this.emailServerConfigurationInterface = (new EmailServerConfiguration(accountName, password, server)).asInstanceOf[EmailServerConfigurationInterface]
    }

    def this(emailServerConfigurationInterface : EmailServerConfigurationInterface) = {
        this()
        this.emailServerConfigurationInterface = emailServerConfigurationInterface
    }

    def getEmailConfigurationInterface() : EmailServerConfigurationInterface = {
        return this.emailServerConfigurationInterface
    }

    def toXmlNode(document : Document) : Node = {
        var emailConfigurationMapping : EmailServerConfigurationMapping = new EmailServerConfigurationMapping(this.emailServerConfigurationInterface)
        var hashMap : HashMap[Object, Object] = emailConfigurationMapping.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNodeWithValueNodes(document, EmailServerConfigurationData.NAME, hashMap)
        return node
    }

}


