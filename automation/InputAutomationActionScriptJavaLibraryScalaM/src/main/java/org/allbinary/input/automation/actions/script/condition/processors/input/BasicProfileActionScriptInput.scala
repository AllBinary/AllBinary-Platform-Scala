/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.util.HashMap
import _root_.java.util.Iterator
import _root_.java.util.Set
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.automation.actions.script.condition.processors.BasicProfileActionScriptProcessor
import _root_.org.allbinary.input.automation.robot.InputRobotFactory
import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicProfileActionScriptInput private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptProcessor(super_1, super_2) with ProfileActionScriptInputInterface {

    val logUtil_BasicProfileActionScriptInput : LogUtil = LogUtil.getInstance()

    private var inputRobotInterface : InputRobotInterface = null

    private var time : Int = 0

    def this(label : String, node : Node) = {
        this(label, node, ())
        this.logUtil_BasicProfileActionScriptInput.putF(this.commonStrings.START + label, this, this.commonStrings.CONSTRUCTOR)
        val actionNode : Node = DomSearchHelper.getNode(GenericProfileActionScriptInputData.TYPE, node.getChildNodes())
        val inputTypeString : String = DomNodeHelper.getTextNodeValue(actionNode)
        val timeNode : Node = DomSearchHelper.getNodeNoThrow(GenericProfileActionScriptInputData.DELAY, node.getChildNodes())
        if (timeNode != null) {
            val delayString : String = DomNodeHelper.getTextNodeValue(timeNode)
            this.setTime(Integer.valueOf(delayString).intValue())
        } else {
            this.setTime(0)
        }
        this.setInputRobotInterface(InputRobotFactory.getInstance().get(inputTypeString))
    }

    def this(label : String) = {
        this(label, null, ())
        this.logUtil_BasicProfileActionScriptInput.putF(this.commonStrings.START + label, this, this.commonStrings.CONSTRUCTOR)
        val inputRobotFactory : InputRobotFactory = InputRobotFactory.getInstance()
        val hashtable : ABHashtable[Object, Object] = inputRobotFactory.get().asInstanceOf[ABHashtable[Object, Object]]
        val set : Set[Object] = hashtable.keySet().asInstanceOf[Set[Object]]
        val iterator : Iterator[? <: Object] = set.iterator().asInstanceOf[Iterator[? <: Object]]
        this.setInputRobotInterface(inputRobotFactory.get(iterator.next().asInstanceOf[String]))
        this.setTime(0)
    }

    def getTime() : Int = {
        return this.time
    }

    def setTime(time : Int) : Unit = {
        this.time = time
    }

    /*     public Node toXmlNode(Document document) throws Exception     {         Node node = document.createElement(GenericProfileActionScriptConditionData.NAME);          return node;     }      */
    def BasicProfileActionScriptInput_toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(GenericProfileActionScriptInputData.TYPE, this.getInputRobotInterface().getName())
        hashMap.put(GenericProfileActionScriptInputData.DELAY, Integer.toString(this.getTime()))
        this.logUtil_BasicProfileActionScriptInput.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNodeWithValueNodes(document, GenericProfileActionScriptInputData.NAME, this.BasicProfileActionScriptInput_toHashMap())
        return node
    }

    def setInputRobotInterface(inputRobotInterface : InputRobotInterface) : Unit = {
        this.inputRobotInterface = inputRobotInterface
    }

    def getInputRobotInterface() : InputRobotInterface = {
        return this.inputRobotInterface
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(" Input Type: ")
        if (this.getInputRobotInterface() != null) {
            stringBuffer.append(this.getInputRobotInterface().getName())
        } else {
            stringBuffer.append(StringUtil.getInstance().NULL_STRING)
        }
        stringBuffer.append(" Time: ")
        stringBuffer.appendlong(this.getTime())
        return stringBuffer.toString()
    }

}


