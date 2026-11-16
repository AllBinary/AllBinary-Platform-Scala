/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.awt.event.KeyEvent
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.KeySingletonFactory
import _root_.org.allbinary.input.KeyUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class KeyboardActionScriptInput private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptInput(super_1, super_2) with KeyboardActionScriptInputInterface {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardActionScriptInput.{*}

    val logUtil_KeyboardActionScriptInput : LogUtil = LogUtil.getInstance()

    private var keyArray : Array[Integer] = Array[Integer](KeySingletonFactory.getInstance(KeyEvent.VK_0))

    private var keyboardActionScriptInputJPanel : KeyboardActionScriptInputJPanel = null

    private var press : Boolean = false

    private var release : Boolean = false

    private var delayBetweenKeys : Int = 0

    def this(node : Node) = {
        this(_root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardActionScriptInput.NAME, node, ())
        this.logUtil_KeyboardActionScriptInput.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        var actionNode : Node = DomSearchHelper.getNode(KeyboardActionScriptInputData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()
            var vector : BasicArrayList = new BasicArrayListD()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().startsWith(KeyboardActionScriptInputData.KEY)) {
                        var keyString : String = DomNodeHelper.getTextNodeValue(childNode)
                        vector.add(Integer.valueOf(keyString))
                    } else if (childNode.getNodeName().compareTo(KeyboardActionScriptInputData.DELAY_BETWEEN_KEYS) == 0) {
                        var time : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setDelayBetweenKeys(Integer.valueOf(time).intValue())
                    } else if (childNode.getNodeName().compareTo(KeyboardActionScriptInputData.PRESS) == 0) {
                        var value : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setPress(_root_.java.lang.Boolean.valueOf(value))
                    } else if (childNode.getNodeName().compareTo(KeyboardActionScriptInputData.RELEASE) == 0) {
                        var value : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setRelease(_root_.java.lang.Boolean.valueOf(value))
                    } else {
                        throw new Exception("Action Script Input Unknown Node")
                    }
                    index += 1
                }
            }
            this.setKeyArray(vector.toArrayType(new Array[Integer](vector.size()).asInstanceOf[Array[Object]]).asInstanceOf[Array[Integer]])
        } else {
            throw new Exception("Action Script Input Node Null")
        }
        this.setAllowsChildren(false)
        if (!this.isPress() && !this.isRelease()) {
            this.setNormal()
        }
        this.keyboardActionScriptInputJPanel = new KeyboardActionScriptInputJPanel(this)
    }

    def this() = {
        this(_root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardActionScriptInput.NAME, null, ())
        if (!this.isPress() && !this.isRelease()) {
            this.setNormal()
        }
        this.setAllowsChildren(false)
        this.setTime(120)
        this.keyboardActionScriptInputJPanel = new KeyboardActionScriptInputJPanel(this)
    }

    def getDelayBetweenKeys() : Int = {
        return this.delayBetweenKeys
    }

    def setDelayBetweenKeys(delayBetweenKeys : Int) : Unit = {
        this.delayBetweenKeys = delayBetweenKeys
    }

    def isPress() : Boolean = {
        return this.press
    }

    def setPress(press : Boolean) : Unit = {
        this.press = press
    }

    def isRelease() : Boolean = {
        return this.release
    }

    def setRelease(release : Boolean) : Unit = {
        this.release = release
    }

    def isNormal() : Boolean = {
        return this.isRelease() && this.isPress()
    }

    def setNormal() : Unit = {
        this.setPress(true)
        this.setRelease(true)
    }

    def getKeyArray() : Array[Integer] = {
        return this.keyArray
    }

    def setKeyArray(keyArray : Array[Integer]) : Unit = {
        if (keyArray != null) {
            this.logUtil_KeyboardActionScriptInput.putF(CommonLabels.getInstance().START + keyArray.length, this, "setKeyArray")
        }
        this.keyArray = keyArray
    }

    override def showDialog() : Unit = {
        this.keyboardActionScriptInputJPanel.getKeyActionJDialog().setVisible(true)
    }

    def getText() : String = {
        return _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardActionScriptInput.getText(this.getKeyArray())
    }

    def setText(text : String) : Unit = {
        this.logUtil_KeyboardActionScriptInput.putF(CommonLabels.getInstance().START + text, this, "setText")
        var integerArray : Array[Integer] = this.integerArrayValue(text)
        this.setKeyArray(integerArray)
    }

    private def integerArrayValue(text : String) : Array[Integer] = {
        this.logUtil_KeyboardActionScriptInput.putF(CommonLabels.getInstance().START + text, this, "integerArrayValue")
        var vector : BasicArrayList = new BasicArrayListD()
        var index : Int = 0

        {
            while (index < text.length()) {
                scala.util.boundary { (continue_N82678 : scala.util.boundary.Label[Unit]) ?=>
                    var aChar : Char = text.charAt(index)
                    if (aChar == '&') {
                        if (text.charAt(index + 1) == '#') {
                            var endIndex : Int = text.indexOf(';', index + 1)
                            if (endIndex != -1) {
                                var nextCharString : String = text.substring(index + 2, endIndex)
                                this.logUtil_KeyboardActionScriptInput.putF((CommonLabels.getInstance().NEXT + " Char String: ") + nextCharString, this, "integerArrayValue")
                                vector.add(Integer.valueOf(nextCharString.substring(index, nextCharString.length())))
                                index = (index + nextCharString.length()) + 3
                                scala.util.boundary.break()(using continue_N82678)
                            }
                        }
                    }
                    vector.add(KeySingletonFactory.getHashtable().get(String.valueOf(aChar)))
                    index += 1
                }
            }
        }
        var integerArray : Array[Integer] = vector.toArrayType(new Array[Integer](vector.size()).asInstanceOf[Array[Object]]).asInstanceOf[Array[Integer]]
        return integerArray
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        //super.toHashMap().put(KeyActionScriptInputData.NAME, hashMap);

        {
            var index : Int = 0
            while (index < this.getKeyArray().length) {
                hashMap.put(KeyboardActionScriptInputData.KEY + index, Integer.toString(this.getKeyArray()(index)))
                index += 1
            }
        }
        hashMap.put(KeyboardActionScriptInputData.DELAY_BETWEEN_KEYS, Integer.toString(this.getDelayBetweenKeys()))
        hashMap.put(KeyboardActionScriptInputData.PRESS, _root_.java.lang.Boolean.toString(this.isPress()))
        hashMap.put(KeyboardActionScriptInputData.RELEASE, _root_.java.lang.Boolean.toString(this.isRelease()))
        this.logUtil_KeyboardActionScriptInput.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        node.appendChild(ModDomHelper.createNodeWithValueNodes(document, KeyboardActionScriptInputData.NAME, this.toHashMap()))
        return node
    }

    override def process(frame : _root_.java.lang.Long) : Unit = {
        KeyboardInputAutomationProcessor.process(this)
    }

    def log() : Unit = {
        this.logUtil_KeyboardActionScriptInput.putF(this.toString(), this, "log")
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(" Text: ")
        stringBuffer.append(this.getText())
        stringBuffer.append(" isPress: ")
        stringBuffer.appendboolean(this.isPress())
        stringBuffer.append(" isRelease: ")
        stringBuffer.appendboolean(this.isRelease())
        stringBuffer.append(" Between Key Delay: ")
        stringBuffer.appendint(this.getDelayBetweenKeys())
        return stringBuffer.toString()
    }

}

object KeyboardActionScriptInput {
    private val NAME : String = "Keyboard"

    private def getText(integerArray : Array[Integer]) : String = {
        var index : Int = 0
        var stringBuffer : StringMaker = new StringMaker()

        {
            while (index < integerArray.length) {
                var nextInteger : Integer = integerArray(index)
                if (KeyUtil.isNormallyDisplayed(nextInteger)) {
                    stringBuffer.append(KeyEvent.getKeyText(nextInteger))
                } else {
                    stringBuffer.append(("&#" + nextInteger) + ";")
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


