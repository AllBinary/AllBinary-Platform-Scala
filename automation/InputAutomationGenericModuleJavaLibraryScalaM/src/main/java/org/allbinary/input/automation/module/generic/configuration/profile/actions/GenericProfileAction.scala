/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScript
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class GenericProfileAction private () extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var name : String = null

    private var genericProfileActionScript : GenericProfileActionScript = null

    private var genericProfileActionJPanel : GenericProfileActionJPanel = null

    def this(genericProfileActionJPanel : GenericProfileActionJPanel, node : Node) = {
        this()
        var actionNameNode : Node = DomSearchHelper.getNode(GenericProfileActionData.NAME, node.getChildNodes())
        if (actionNameNode != null) {
            this.name = DomNodeHelper.getTextNodeValue(actionNameNode)
        } else {
            throw new Exception("Profile Action Name Node Null")
        }
        this.setGenericProfileActionScript(new GenericProfileActionScript(this.genericProfileActionJPanel, node))
    }

    def this(name : String) = {
        this()
        this.name = name
        this.setGenericProfileActionScript(new GenericProfileActionScript(this.genericProfileActionJPanel))
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(GenericProfileActionData.NAME, this.name)
        this.logUtil.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNodeWithValueNodes(document, GenericProfileActionData.NAME, this.toHashMap())
        node.appendChild(getGenericProfileActionScript().toXmlNode(document))
        return node
    }

    def getGenericProfileActionScript() : GenericProfileActionScript = {
        return this.genericProfileActionScript
    }

    def setGenericProfileActionScript(genericProfileActionScript : GenericProfileActionScript) : Unit = {
        this.genericProfileActionScript = genericProfileActionScript
    }

}


