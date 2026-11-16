/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.awt.*
import _root_.java.awt.event.InputEvent
import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class MouseActionScriptInput private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptInput(super_1, super_2) with MouseActionScriptInputInterface {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.MouseActionScriptInput.{*}

    val logUtil_MouseActionScriptInput : LogUtil = LogUtil.getInstance()

    private var point : Point = null

    private var buttons : Int = 0

    private var mouseActionScriptInputJPanel : MouseActionScriptInputJPanel = null

    def this(node : Node) = {
        this(_root_.org.allbinary.input.automation.actions.script.condition.processors.input.MouseActionScriptInput.NAME, node, ())
        this.logUtil_MouseActionScriptInput.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.point = new Point()
        var actionNode : Node = DomSearchHelper.getNode(MouseActionScriptInputData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().compareTo(MouseActionScriptInputData.BUTTONS) == 0) {
                        var buttons : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setButtonClicks(Integer.valueOf(buttons).intValue())
                    } else if (childNode.getNodeName().compareTo(MouseActionScriptInputData.MOVE) == 0) {
                        var mouseXNode : Node = DomSearchHelper.getNode(MouseActionScriptInputData.MOVE_X, childNode.getChildNodes())
                        var mouseXString : String = DomNodeHelper.getTextNodeValue(mouseXNode)
                        var mouseXInteger : Integer = Integer.valueOf(mouseXString)
                        var mouseYNode : Node = DomSearchHelper.getNode(MouseActionScriptInputData.MOVE_Y, childNode.getChildNodes())
                        var mouseYString : String = DomNodeHelper.getTextNodeValue(mouseYNode)
                        var mouseYInteger : Integer = Integer.valueOf(mouseYString)
                        var newPoint : Point = new Point(mouseXInteger.intValue(), mouseYInteger.intValue())
                        this.setPoint(newPoint)
                    } else {
                        throw new Exception("Action Script Input Unknown Node")
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Action Script Input Node Null")
        }
        this.setAllowsChildren(false)
        this.mouseActionScriptInputJPanel = new MouseActionScriptInputJPanel(this)
    }

    def this() = {
        this(_root_.org.allbinary.input.automation.actions.script.condition.processors.input.MouseActionScriptInput.NAME, null, ())
        this.point = new Point()
        this.setAllowsChildren(false)
        this.mouseActionScriptInputJPanel = new MouseActionScriptInputJPanel(this)
    }

    def setPoint(point : Point) : Unit = {
        this.point = point
    }

    def getPoint() : Point = {
        return this.point
    }

    def getButtonClicks() : Int = {
        return this.buttons
    }

    def setButtonClicks(buttons : Int) : Unit = {
        this.buttons = buttons
    }

    override def showDialog() : Unit = {
        this.mouseActionScriptInputJPanel.getMouseActionJDialog().setVisible(true)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        //super.toHashMap().put(MouseActionScriptInputData.NAME, hashMap);
        hashMap.put(MouseActionScriptInputData.BUTTONS, Integer.toString(this.getButtonClicks()))
        this.logUtil_MouseActionScriptInput.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        var mouseNode : Node = ModDomHelper.createNodeWithValueNodes(document, MouseActionScriptInputData.NAME, this.toHashMap())
        node.appendChild(mouseNode)
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(MouseActionScriptInputData.MOVE_X, Integer.toString(this.getPoint().x))
        hashMap.put(MouseActionScriptInputData.MOVE_Y, Integer.toString(this.getPoint().y))
        mouseNode.appendChild(ModDomHelper.createNodeWithValueNodes(document, MouseActionScriptInputData.MOVE, hashMap))
        return node
    }

    override def process(frame : _root_.java.lang.Long) : Unit = {
        MouseInputAutomationProcessor.process(this)
    }

    def log() : Unit = {
        var buttonStringBuffer : StringMaker = new StringMaker()
        buttonStringBuffer.append("1: ")
        val booleanFactory : BooleanFactory = BooleanFactory.getInstance()
        if ((this.getButtonClicks() & InputEvent.BUTTON1_MASK) != 0) {
            buttonStringBuffer.append(booleanFactory.TRUE_STRING)
        } else {
            buttonStringBuffer.append(booleanFactory.FALSE_STRING)
        }
        buttonStringBuffer.append(" 2: ")
        if ((this.getButtonClicks() & InputEvent.BUTTON2_MASK) != 0) {
            buttonStringBuffer.append(booleanFactory.TRUE_STRING)
        } else {
            buttonStringBuffer.append(booleanFactory.FALSE_STRING)
        }
        buttonStringBuffer.append(" 3: ")
        if ((this.getButtonClicks() & InputEvent.BUTTON3_MASK) != 0) {
            buttonStringBuffer.append(booleanFactory.TRUE_STRING)
        } else {
            buttonStringBuffer.append(booleanFactory.FALSE_STRING)
        }
        this.logUtil_MouseActionScriptInput.putF((((("Input Type: " + this.getInputRobotInterface().getName()) + " Point: ") + this.getPoint()) + " Buttons Clicked: ") + buttonStringBuffer.toString(), this, "log")
    }

}

object MouseActionScriptInput {
    private val NAME : String = "Mouse"

}


