/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.configuration.user.event

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class UserEmailEventsConfigurationView private () extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface = null

    def this(node : Node) = {
        this()
        this.userEmailEventsConfigurationInterface = (new UserEmailEventsConfiguration()).asInstanceOf[UserEmailEventsConfigurationInterface]
        var childNodeList : NodeList = node.getChildNodes()
        var emailEventConfigurationNodeVector : BasicArrayList = DomSearchHelper.getAllNodesNoThrow(UserEmailEventConfigurationData.NAME, childNodeList)
        val size : Int = emailEventConfigurationNodeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userEmailConfigurationNode : Node = emailEventConfigurationNodeVector.get(index).asInstanceOf[Node]
                var userEmailEventConfigurationView : UserEmailEventConfigurationView = new UserEmailEventConfigurationView(userEmailConfigurationNode)
                this.userEmailEventsConfigurationInterface.addUserEmailEventConfiguration(userEmailEventConfigurationView.getUserEmailEventConfigurationInterface())
                index += 1
            }
        }
    }

    def this(userEmailEventsConfigurationInterface : UserEmailEventsConfigurationInterface) = {
        this()
        this.userEmailEventsConfigurationInterface = userEmailEventsConfigurationInterface
    }

    def getUserEmailEventsConfigurationInterface() : UserEmailEventsConfigurationInterface = {
        return this.userEmailEventsConfigurationInterface
    }

    def toXmlNode(document : Document) : Node = {
        var userEmailConfigurationMapping : UserEmailEventsConfigurationMapping = new UserEmailEventsConfigurationMapping(this.userEmailEventsConfigurationInterface)
        //HashMap hashMap = userEmailConfigurationMapping.toHashMap();
        var node : Node = document.createElement(UserEmailEventsConfigurationData.NAME)
        var emailEventHashMap : HashMap[Object, Object] = this.getUserEmailEventsConfigurationInterface().getEventConfigurationHashMap().asInstanceOf[HashMap[Object, Object]]
        var set : Set[Object] = emailEventHashMap.keySet().asInstanceOf[Set[Object]]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF("Number Of Email Events Specified in file: " + set.size(), this, this.commonStrings.CONSTRUCTOR)
        }
        val eventNameArray : Array[Object] = set.toArray()
        val size : Int = eventNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var eventName : String = eventNameArray(index).asInstanceOf[String]
                var userEmailEventsConfigurationInterface : UserEmailEventConfigurationInterface = emailEventHashMap.get(eventName).asInstanceOf[UserEmailEventConfigurationInterface]
                var userEmailEventConfigurationView : UserEmailEventConfigurationView = new UserEmailEventConfigurationView(userEmailEventsConfigurationInterface)
                node.appendChild(userEmailEventConfigurationView.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

}


