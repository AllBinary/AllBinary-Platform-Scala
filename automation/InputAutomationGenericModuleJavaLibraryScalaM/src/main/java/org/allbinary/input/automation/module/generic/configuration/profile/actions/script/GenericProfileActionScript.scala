/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions.script

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptNodeInterface
import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionFactory
import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionInterface
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActionData
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActionJPanel
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class GenericProfileActionScript private (super_1 : String, constructor_ : Unit) extends DefaultMutableTreeNode(super_1) with ProfileActionScriptNodeInterface {
    import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScript.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var genericProfileActionJPanel : GenericProfileActionJPanel = null

    private var profileActionConditionInterfaceVector : BasicArrayList = null

    def this(genericProfileActionJPanel : GenericProfileActionJPanel, node : Node) = {
        this(_root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.script.GenericProfileActionScript.NAME, ())
        this.genericProfileActionJPanel = genericProfileActionJPanel
        this.setProfileActionConditionInterfaceVector(new BasicArrayListD())
        var actionScriptNode : Node = DomSearchHelper.getNode(GenericProfileActionData.SCRIPT, node.getChildNodes())
        if (actionScriptNode != null) {
            var nodeList : NodeList = actionScriptNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var actionConditionNode : Node = nodeList.item(index)
                    if (actionConditionNode.getNodeType() == Node.ELEMENT_NODE) {
                        this.addCondition(ProfileActionScriptConditionFactory.getInstance(actionConditionNode))
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Profile Action Script Node Null")
        }
    }

    def this(genericProfileActionJPanel : GenericProfileActionJPanel) = {
        this(null, ())
        this.genericProfileActionJPanel = genericProfileActionJPanel
        this.setProfileActionConditionInterfaceVector(new BasicArrayListD())
    }

    def addCondition(profileActionScriptNodeInterface : ProfileActionScriptNodeInterface) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "addCondition")
        this.getProfileActionConditionInterfaceVector().add(profileActionScriptNodeInterface)
        this.add(profileActionScriptNodeInterface)
    }

    def removeCondition(profileActionScriptNodeInterface : ProfileActionScriptNodeInterface) : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "removeCondition")
        this.getProfileActionConditionInterfaceVector().remove(profileActionScriptNodeInterface)
        this.remove(profileActionScriptNodeInterface)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.logUtil.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    def getProfileActionConditionInterfaceVector() : BasicArrayList = {
        return this.profileActionConditionInterfaceVector
    }

    def setProfileActionConditionInterfaceVector(profileActionConditionInterfaceVector : BasicArrayList) : Unit = {
        this.profileActionConditionInterfaceVector = profileActionConditionInterfaceVector
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfileActionData.SCRIPT)
        val vector : BasicArrayList = this.getProfileActionConditionInterfaceVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var profileActionConditionInterface : ProfileActionScriptConditionInterface = vector.get(index).asInstanceOf[ProfileActionScriptConditionInterface]
                node.appendChild(profileActionConditionInterface.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

}

object GenericProfileActionScript {
    private val NAME : String = "Root"

}


