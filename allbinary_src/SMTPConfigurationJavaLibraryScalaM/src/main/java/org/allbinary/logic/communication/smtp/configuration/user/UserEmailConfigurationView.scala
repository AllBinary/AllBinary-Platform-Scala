/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfigurationData
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfigurationInterface
import _root_.org.allbinary.logic.communication.smtp.configuration.user.event.UserEmailEventsConfigurationView
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class UserEmailConfigurationView private () extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var userEmailConfigurationInterface : UserEmailConfigurationInterface = null

    def this(node : Node) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        }
        this.userEmailConfigurationInterface = (new UserEmailConfiguration()).asInstanceOf[UserEmailConfigurationInterface]
        var childNodeList : NodeList = node.getChildNodes()
        var userEmailEventsConfigurationNode : Node = DomSearchHelper.getNodeNoThrow(UserEmailEventsConfigurationData.NAME, childNodeList)
        var userEmailEventsConfigurationView : UserEmailEventsConfigurationView = new UserEmailEventsConfigurationView(userEmailEventsConfigurationNode)
        this.userEmailConfigurationInterface.setUserEmailEventsConfigurationInterface(userEmailEventsConfigurationView.getUserEmailEventsConfigurationInterface())
    }

    def this(userEmailConfigurationInterface : UserEmailConfigurationInterface) = {
        this()
        this.userEmailConfigurationInterface = userEmailConfigurationInterface
    }

    def getEmailConfigurationInterface() : UserEmailConfigurationInterface = {
        return this.userEmailConfigurationInterface
    }

    def toXmlNode(document : Document) : Node = {
        var emailConfigurationMapping : UserEmailConfigurationMapping = new UserEmailConfigurationMapping(this.userEmailConfigurationInterface)
        var hashMap : HashMap[Object, Object] = emailConfigurationMapping.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, UserEmailConfigurationData.NAME, hashMap)
        var userEmailConfigurationInterface : UserEmailConfigurationInterface = this.getEmailConfigurationInterface()
        var userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface = userEmailConfigurationInterface.getUserEmailEventsConfigurationInterface()
        var userEmailEventsConfigurationView : UserEmailEventsConfigurationView = new UserEmailEventsConfigurationView(userEmailEventsConfigurationInterface)
        node.appendChild(userEmailEventsConfigurationView.toXmlNode(document))
        return node
    }

}


