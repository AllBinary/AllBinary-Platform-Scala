/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules.configuration

import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.time.created.TimeCreatedView
import _root_.org.allbinary.business.time.modified.TimeLastModifiedView
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationData
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationInterface
import _root_.org.allbinary.logic.communication.smtp.configuration.user.UserEmailConfigurationView
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class UserConfigurationView private () extends DomNodeInterface {

    private var userConfigurationInterface : UserConfigurationInterface = null

    def this(node : Node) = {
        this()
        this.userConfigurationInterface = (new UserConfiguration()).asInstanceOf[UserConfigurationInterface]
        var childNodeList : NodeList = node.getChildNodes()
        var emailConfigurationNode : Node = DomSearchHelper.getNode(UserEmailConfigurationData.NAME, childNodeList)
        var userEmailConfigurationView : UserEmailConfigurationView = new UserEmailConfigurationView(emailConfigurationNode)
        var userEmailConfigurationInterface : UserEmailConfigurationInterface = userEmailConfigurationView.getEmailConfigurationInterface().asInstanceOf[UserEmailConfigurationInterface]
        this.userConfigurationInterface.setUserEmailConfigurationInterface(userEmailConfigurationInterface)
        /*       Node ftpConfigurationNode = DomSearchHelper.getNode(          FtpConfigurationData.NAME, childNodeList);        FtpConfigurationView ftpConfigurationView =          new FtpConfigurationView(ftpConfigurationNode);        FtpConfigurationInterface ftpConfigurationInterface = (FtpConfigurationInterface)           ftpConfigurationView.getFtpConfigurationInterface();       this.userConfigurationInterface.setFtpConfigurationInterface(ftpConfigurationInterface);       */
        var timeCreatedNode : Node = DomSearchHelper.getNode(EntryData.getInstance().TIMECREATED, childNodeList)
        var timeCreatedView : TimeCreatedView = new TimeCreatedView(timeCreatedNode)
        this.userConfigurationInterface.setTimeCreated(timeCreatedView.getTimeCreated())
        var timeLastModifiedNode : Node = DomSearchHelper.getNode(EntryData.getInstance().LASTMODIFIED, childNodeList)
        var timeLastModifiedView : TimeLastModifiedView = new TimeLastModifiedView(timeLastModifiedNode)
        this.userConfigurationInterface.setTimeLastModified(timeLastModifiedView.getTimeLastModified())
    }

    def this(userConfigurationInterface : UserConfigurationInterface) = {
        this()
        this.userConfigurationInterface = userConfigurationInterface
    }

    def getUserConfigurationInterface() : UserConfigurationInterface = {
        return this.userConfigurationInterface
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(UserConfigurationData.NAME)
        var userEmailConfigurationView : UserEmailConfigurationView = new UserEmailConfigurationView(this.userConfigurationInterface.getUserEmailConfigurationInterface())
        node.appendChild(userEmailConfigurationView.toXmlNode(document))
        /*       FtpConfigurationView ftpConfigurationView =           new FtpConfigurationView(this.userConfigurationInterface.getFtpConfigurationInterface());       node.appendChild(ftpConfigurationView.toXmlNode(document)); */
        var timeCreatedView : TimeCreatedView = new TimeCreatedView(this.userConfigurationInterface.getTimeCreated())
        node.appendChild(timeCreatedView.toXmlNode(document))
        var timeLastModifiedView : TimeLastModifiedView = new TimeLastModifiedView(this.userConfigurationInterface.getTimeLastModified())
        node.appendChild(timeLastModifiedView.toXmlNode(document))
        return node
    }

}


