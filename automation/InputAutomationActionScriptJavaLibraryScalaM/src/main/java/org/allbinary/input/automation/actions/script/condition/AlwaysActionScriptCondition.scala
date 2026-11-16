/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class AlwaysActionScriptCondition private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptCondition(super_1, super_2) with AlwaysActionScriptConditionInterface {
    import _root_.org.allbinary.input.automation.actions.script.condition.AlwaysActionScriptCondition.{*}

    val logUtil_AlwaysActionScriptCondition : LogUtil = LogUtil.getInstance()

    private var alwaysActionScriptConditionJPanel : AlwaysActionScriptConditionJPanel = null

    private var isOn : Boolean = false

    def this(node : Node) = {
        this(AlwaysActionScriptCondition.NAME, node, ())
        var actionNode : Node = DomSearchHelper.getNode(AlwaysActionScriptConditionData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().compareTo(AlwaysActionScriptConditionData.IS_ON) == 0) {
                        var booleanString : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setIsOn(new _root_.java.lang.Boolean(booleanString).booleanValue())
                    } else {
                        throw new Exception("Action Script Condition Unknown Node")
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Action Script Condition Node Null")
        }
        this.init()
    }

    def this() = {
        this(AlwaysActionScriptCondition.NAME, null, ())
        this.init()
    }

    private def init() : Unit = {
        this.alwaysActionScriptConditionJPanel = new AlwaysActionScriptConditionJPanel(this)
    }

    def isIsOn() : Boolean = {
        return this.isOn
    }

    def setIsOn(isOn : Boolean) : Unit = {
        this.isOn = isOn
    }

    override def showDialog() : Unit = {
        this.alwaysActionScriptConditionJPanel.getAlwaysActionJDialog().setVisible(true)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(AlwaysActionScriptConditionData.IS_ON, _root_.java.lang.Boolean.toString(this.isIsOn()))
        this.logUtil_AlwaysActionScriptCondition.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        node.appendChild(ModDomHelper.createNodeWithValueNodes(document, AlwaysActionScriptConditionData.NAME, this.toHashMap()))
        return node
    }

    override def shouldProcess(frame : _root_.java.lang.Long) : Boolean = {
        if (this.isIsOn()) {
            return super.shouldProcess(frame)
        }
        return false
    }

    def log() : Unit = {
        this.logUtil_AlwaysActionScriptCondition.putF("Is On: " + this.isIsOn(), this, "log")
    }

}

object AlwaysActionScriptCondition {
    private val NAME : String = "Always On/Off"

}


