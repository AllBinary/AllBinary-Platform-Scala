/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.java.awt.event.ActionEvent
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.swing.*
import _root_.javax.swing.tree.TreePath
import _root_.org.allbinary.input.automation.actions.script.JTreeInterfaceFactory
import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem
import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptNodeInterface
import _root_.org.allbinary.input.automation.actions.script.condition.processors.ProfileActionScriptProcessorInterface
import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.GenericProfileActionScriptInputData
import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardActionScriptInput
import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.MouseActionScriptInput
import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.ProfileActionScriptInputFactory
import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.GenericProfileActionScriptOutputData
import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageActionScriptOutput
import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ProfileActionScriptOutputFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class BasicProfileActionScriptCondition private (super_1 : String, super_2 : Node, constructor_ : Unit) extends ProfileActionScriptItem(super_1, super_2) with ProfileActionScriptConditionInterface {

    val logUtil_BasicProfileActionScriptCondition : LogUtil = LogUtil.getInstance()

    //private BasicProfileActionScriptProcessorNode basicProfileActionScriptProcessorNode;
    private var profileActionProcessorInterfaceVector : BasicArrayList = null

    private var profileActionConditionInterfaceVector : BasicArrayList = null

    def this(label : String, node : Node) = {
        this(label, node, ())
        this.init()
        var nodeList : NodeList = node.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var actionItemNode : Node = nodeList.item(index)
                if (actionItemNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (actionItemNode.getNodeName().compareTo(GenericProfileActionScriptConditionData.NAME) == 0) {
                        this.addCondition(ProfileActionScriptConditionFactory.getInstance(actionItemNode))
                    } else if (actionItemNode.getNodeName().compareTo(GenericProfileActionScriptInputData.NAME) == 0) {
                        this.addProcessor(ProfileActionScriptInputFactory.getInstance(actionItemNode))
                    } else if (actionItemNode.getNodeName().compareTo(GenericProfileActionScriptOutputData.NAME) == 0) {
                        this.addProcessor(ProfileActionScriptOutputFactory.getInstance(actionItemNode))
                    }
                }
                index += 1
            }
        }
    }

    def this(label : String) = {
        this(label, null, ())
        this.init()
    }

    def addProcessorNodes(node : Node) : Unit = {
        var nodeList : NodeList = node.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var processorActionItemNode : Node = nodeList.item(index)
                if (processorActionItemNode.getNodeName().compareTo(GenericProfileActionScriptInputData.NAME) == 0) {
                    this.addProcessor(ProfileActionScriptInputFactory.getInstance(processorActionItemNode))
                } else if (processorActionItemNode.getNodeName().compareTo(GenericProfileActionScriptOutputData.NAME) == 0) {
                    this.addProcessor(ProfileActionScriptOutputFactory.getInstance(processorActionItemNode))
                }
                index += 1
            }
        }
    }

    private def init() : Unit = {
        //this.basicProfileActionScriptProcessorNode = new BasicProfileActionScriptProcessorNode();
        this.setProfileActionProcessorInterfaceVector(new BasicArrayListD())
        this.setProfileActionConditionInterfaceVector(new BasicArrayListD())
        this.getJPopupMenu().add(this.getConditionJPopupMenu())
        this.getJPopupMenu().add(this.getInputJPopupMenu())
        this.getJPopupMenu().add(this.getOutputJPopupMenu())
    }

    private def getConditionJPopupMenu() : JMenu = {
        var jMenu : JMenu = new JMenu(ProfileActionScriptItem.NEW_CONDITION)
        var jMenuItemColorAt : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_COLOR_AT)
        var jMenuItemAlways : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_ALWAYS)
        var jMenuItemTimeInterval : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_TIME_INTERVAL)
        jMenuItemColorAt.addActionListener(this)
        jMenuItemAlways.addActionListener(this)
        jMenuItemTimeInterval.addActionListener(this)
        jMenu.add(jMenuItemColorAt)
        jMenu.add(jMenuItemAlways)
        jMenu.add(jMenuItemTimeInterval)
        return jMenu
    }

    private def getInputJPopupMenu() : JMenu = {
        var jMenu : JMenu = new JMenu(ProfileActionScriptItem.NEW_INPUT)
        var jMenuItemKey : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_KEY_INPUT)
        var jMenuItemMouse : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_MOUSE_INPUT)
        var jMenuItemJoystick : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_JOYSTICK_INPUT)
        jMenuItemKey.addActionListener(this)
        jMenuItemMouse.addActionListener(this)
        jMenuItemJoystick.addActionListener(this)
        jMenu.add(jMenuItemKey)
        jMenu.add(jMenuItemMouse)
        jMenu.add(jMenuItemJoystick)
        return jMenu
    }

    private def getOutputJPopupMenu() : JMenu = {
        var jMenu : JMenu = new JMenu(ProfileActionScriptItem.NEW_OUTPUT)
        var jMenuItemImage : JMenuItem = new JMenuItem(ProfileActionScriptItem.NEW_IMAGE_OUTPUT)
        jMenuItemImage.addActionListener(this)
        jMenu.add(jMenuItemImage)
        return jMenu
    }

    def addProcessor(profileActionProcessorInterface : ProfileActionScriptProcessorInterface) : Unit = {
        this.logUtil_BasicProfileActionScriptCondition.putF(this.commonStrings.START, this, "addInput")
        this.getProfileActionProcessorInterfaceVector().add(profileActionProcessorInterface)
        this.add(profileActionProcessorInterface)
    }

    def removeProcessor(profileActionProcessorInterface : ProfileActionScriptProcessorInterface) : Unit = {
        this.logUtil_BasicProfileActionScriptCondition.putF(this.commonStrings.START, this, "removeInput")
        this.getProfileActionProcessorInterfaceVector().remove(profileActionProcessorInterface)
        this.remove(profileActionProcessorInterface)
    }

    def removeCondition(profileActionScriptNodeInterface : ProfileActionScriptNodeInterface) : Unit = {
        this.logUtil_BasicProfileActionScriptCondition.putF(this.commonStrings.START, this, "removeCondition")
        this.getProfileActionConditionInterfaceVector().remove(profileActionScriptNodeInterface)
        this.remove(profileActionScriptNodeInterface)
    }

    def addCondition(profileActionScriptNodeInterface : ProfileActionScriptNodeInterface) : Unit = {
        this.logUtil_BasicProfileActionScriptCondition.putF(this.commonStrings.START, this, "addCondition")
        this.getProfileActionConditionInterfaceVector().add(profileActionScriptNodeInterface)
        this.add(profileActionScriptNodeInterface)
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfileActionScriptConditionData.NAME)
        val profileActionConditionInterfaceVector : BasicArrayList = this.getProfileActionConditionInterfaceVector()
        val size : Int = profileActionConditionInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var profileActionConditionInterface : ProfileActionScriptConditionInterface = profileActionConditionInterfaceVector.get(index).asInstanceOf[ProfileActionScriptConditionInterface]
                node.appendChild(profileActionConditionInterface.toXmlNode(document))
                index += 1
            }
        }
        val profileActionProcessorInterfaceVector : BasicArrayList = this.getProfileActionProcessorInterfaceVector()
        val size2 : Int = profileActionProcessorInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size2) {
                var profileActionProcessorInterface : ProfileActionScriptProcessorInterface = profileActionProcessorInterfaceVector.get(index).asInstanceOf[ProfileActionScriptProcessorInterface]
                node.appendChild(profileActionProcessorInterface.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

    def getProfileActionConditionInterfaceVector() : BasicArrayList = {
        return this.profileActionConditionInterfaceVector
    }

    def setProfileActionConditionInterfaceVector(profileActionConditionInterfaceVector : BasicArrayList) : Unit = {
        this.profileActionConditionInterfaceVector = profileActionConditionInterfaceVector
    }

    override def actionPerformed(actionEvent : ActionEvent) : Unit = {
        try {
            super.actionPerformed(actionEvent)
            if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.DELETE) == 0) {
                if (this.getParent().isInstanceOf[ProfileActionScriptNodeInterface]) {
                    var profileActionScriptNodeInterface : ProfileActionScriptNodeInterface = this.getParent().asInstanceOf[ProfileActionScriptNodeInterface]
                    profileActionScriptNodeInterface.removeCondition(this)
                    JTreeInterfaceFactory.getInstance().getJTreeInterface().updateJTree()
                }
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_COLOR_AT) == 0) {
                this.addCondition(new ColorAtActionScriptCondition())
                this.updateTree()
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_ALWAYS) == 0) {
                this.addCondition(new AlwaysActionScriptCondition())
                this.updateTree()
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_TIME_INTERVAL) == 0) {
                this.addCondition(new TimeIntervalActionScriptCondition())
                this.updateTree()
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_KEY_INPUT) == 0) {
                this.addProcessor(new KeyboardActionScriptInput())
                this.updateTree()
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_MOUSE_INPUT) == 0) {
                this.addProcessor(new MouseActionScriptInput())
                this.updateTree()
            } else if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.NEW_IMAGE_OUTPUT) == 0) {
                this.addProcessor(new ImageActionScriptOutput())
                this.updateTree()
            }
        } catch {
            case e : Exception => {
                this.logUtil_BasicProfileActionScriptCondition.put("Error", this, "actionPerformed", e)
            }
        }
    }

    def getProfileActionProcessorInterfaceVector() : BasicArrayList = {
        return this.profileActionProcessorInterfaceVector
    }

    def setProfileActionProcessorInterfaceVector(profileActionProcessorInterfaceVector : BasicArrayList) : Unit = {
        this.profileActionProcessorInterfaceVector = profileActionProcessorInterfaceVector
    }

    private def updateTree() : Unit = {
        JTreeInterfaceFactory.getInstance().getJTreeInterface().updateJTree()
        var treePath : TreePath = new TreePath(this)
        JTreeInterfaceFactory.getInstance().getJTreeInterface().getActionScriptJTree().expandPath(treePath)
    }

    def shouldProcess(frame : _root_.java.lang.Long) : Boolean = {
        val profileActionConditionInterfaceVector : BasicArrayList = this.getProfileActionConditionInterfaceVector()
        val size : Int = profileActionConditionInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var profileActionScriptConditionInterface : ProfileActionScriptConditionInterface = profileActionConditionInterfaceVector.get(index).asInstanceOf[ProfileActionScriptConditionInterface]
                if (!profileActionScriptConditionInterface.shouldProcess(frame)) {
                    return false
                }
                index += 1
            }
        }
        return true
    }

    //Actually push the automated input into the application
    override def process(frame : _root_.java.lang.Long) : Unit = {
        this.logUtil_BasicProfileActionScriptCondition.putF(new StringMaker().append("Start - Processing ").appendint(this.getProfileActionProcessorInterfaceVector().size()).append(" inputs").toString(), this, this.commonStrings.PROCESS)
        val profileActionProcessorInterfaceVector : BasicArrayList = this.getProfileActionProcessorInterfaceVector()
        val size : Int = profileActionProcessorInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var profileActionScriptProcessorInterface : ProfileActionScriptProcessorInterface = profileActionProcessorInterfaceVector.get(index).asInstanceOf[ProfileActionScriptProcessorInterface]
                profileActionScriptProcessorInterface.process(frame)
                index += 1
            }
        }
    }

}


