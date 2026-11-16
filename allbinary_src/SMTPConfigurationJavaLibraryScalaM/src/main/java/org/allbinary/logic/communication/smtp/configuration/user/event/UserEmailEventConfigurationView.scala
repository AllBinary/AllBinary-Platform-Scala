/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class UserEmailEventConfigurationView private () extends DomNodeInterface {

    private var userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface = null

    def this(node : Node) = {
        this()
        var childNodeList : NodeList = node.getChildNodes()
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var name : String = DomNodeHelper.getTextNodeValue(UserEmailEventConfigurationData.NAME, childNodeList)
        hashMap.put(UserEmailEventConfigurationData.NAME, name)
        var eventListenerClassPath : String = DomNodeHelper.getTextNodeValue(UserEmailEventConfigurationData.LISTENER_CLASSPATH, childNodeList)
        hashMap.put(UserEmailEventConfigurationData.LISTENER_CLASSPATH, eventListenerClassPath)
        this.setUserEmailEventConfigurationInterface((new UserEmailEventConfiguration(hashMap)).asInstanceOf[UserEmailEventConfigurationInterface])
    }

    def this(userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface) = {
        this()
        this.setUserEmailEventConfigurationInterface(userEmailEventConfigurationInterface)
    }

    def toXmlNode(document : Document) : Node = {
        var userEmailEventConfigurationMapping : UserEmailEventConfigurationMapping = new UserEmailEventConfigurationMapping(this.getUserEmailEventConfigurationInterface())
        var hashMap : HashMap[Object, Object] = userEmailEventConfigurationMapping.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, UserEmailEventConfigurationData.NAME, hashMap)
        return node
    }

    def getUserEmailEventConfigurationInterface() : UserEmailEventConfigurationInterface = {
        return this.userEmailEventConfigurationInterface
    }

    def setUserEmailEventConfigurationInterface(userEmailEventConfigurationInterface : UserEmailEventConfigurationInterface) : Unit = {
        this.userEmailEventConfigurationInterface = userEmailEventConfigurationInterface
    }

}


