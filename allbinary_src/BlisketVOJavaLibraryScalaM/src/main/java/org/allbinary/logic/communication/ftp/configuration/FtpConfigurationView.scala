/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.ftp.configuration

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class FtpConfigurationView private () extends DomNodeInterface {

    private var ftpConfigurationInterface : FtpConfigurationInterface = null

    def this(node : Node) = {
        this()
        this.setFtpConfigurationInterface((new FtpConfiguration()).asInstanceOf[FtpConfigurationInterface])
        var chileNodeList : NodeList = node.getChildNodes()
        var server : String = DomNodeHelper.getTextNodeValue(FtpConfigurationData.SERVER, chileNodeList)
        this.getFtpConfigurationInterface().setServer(server)
        var userName : String = DomNodeHelper.getTextNodeValue(FtpConfigurationData.USERNAME, chileNodeList)
        this.getFtpConfigurationInterface().setUserName(userName)
        var password : String = DomNodeHelper.getTextNodeValue(FtpConfigurationData.PASSWORD, chileNodeList)
        this.getFtpConfigurationInterface().setPassword(password)
        var path : String = DomNodeHelper.getTextNodeValue(FtpConfigurationData.PATH, chileNodeList)
        this.getFtpConfigurationInterface().setPath(path)
    }

    def this(ftpConfigurationInterface : FtpConfigurationInterface) = {
        this()
        this.setFtpConfigurationInterface(ftpConfigurationInterface)
    }

    def toXmlNode(document : Document) : Node = {
        var ftpConfigurationMapping : FtpConfigurationMapping = new FtpConfigurationMapping(this.getFtpConfigurationInterface())
        var hashMap : HashMap[Object, Object] = ftpConfigurationMapping.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, FtpConfigurationData.NAME, hashMap)
        return node
    }

    def getFtpConfigurationInterface() : FtpConfigurationInterface = {
        return this.ftpConfigurationInterface
    }

    def setFtpConfigurationInterface(ftpConfigurationInterface : FtpConfigurationInterface) : Unit = {
        this.ftpConfigurationInterface = ftpConfigurationInterface
    }

}


