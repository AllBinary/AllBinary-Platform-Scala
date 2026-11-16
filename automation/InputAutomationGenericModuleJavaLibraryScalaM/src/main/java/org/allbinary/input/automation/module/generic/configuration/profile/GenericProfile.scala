/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActions
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class GenericProfile private () {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var name : String = null

    private var vector : BasicArrayList = null

    private var genericProfileActions : GenericProfileActions = null

    def this(node : Node) = {
        this()
        this.setName(DomNodeHelper.getTextNodeValue(node))
        this.vector = new BasicArrayListD()
        var nodeList : NodeList = node.getChildNodes()
        this.logUtil.putF((("Name: " + this.getName()) + " Child Nodes: ") + nodeList.getLength(), this, "Contructor")

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var profileNode : Node = nodeList.item(index)
                if (profileNode.getNodeName().compareTo(GenericProfileDataWorkerData.NAME) == 0) {
                    var genericProfileDataWorkerType : GenericProfileDataWorkerType = GenericProfileDataWorkerType.getInstance(profileNode)
                    this.logUtil.putF("Adding GenericProfileDataWorkerType: " + genericProfileDataWorkerType.toString(), this, "Contructor")
                    this.vector.add(genericProfileDataWorkerType)
                }
                index += 1
            }
        }
    }

    def this(name : String) = {
        this()
        this.setName(name)
        this.vector = new BasicArrayListD()
    }

    def getGenericProfileDataWorkerTypeVector() : BasicArrayList = {
        return this.vector
    }

    def add(genericProfileDataWorkerType : GenericProfileDataWorkerType) : Unit = {
        if (!this.vector.contains(genericProfileDataWorkerType)) {
            this.vector.add(genericProfileDataWorkerType)
        }
    }

    def remove(genericProfileDataWorkerType : GenericProfileDataWorkerType) : Unit = {
        this.vector.remove(genericProfileDataWorkerType)
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createTextNode(document, GenericProfileData.NAME, this.name)
        val size : Int = this.vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var genericProfileDataWorkerType : GenericProfileDataWorkerType = this.vector.get(index).asInstanceOf[GenericProfileDataWorkerType]
                node.appendChild(genericProfileDataWorkerType.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getGenericProfileActions() : GenericProfileActions = {
        return this.genericProfileActions
    }

    def setGenericProfileActions(genericProfileActions : GenericProfileActions) : Unit = {
        this.genericProfileActions = genericProfileActions
    }

}


