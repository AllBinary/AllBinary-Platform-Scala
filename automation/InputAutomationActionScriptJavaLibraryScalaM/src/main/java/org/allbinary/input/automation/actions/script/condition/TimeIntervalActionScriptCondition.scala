/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TimeIntervalActionScriptCondition private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptCondition(super_1, super_2) with TimeIntervalActionScriptConditionInterface {
    import _root_.org.allbinary.input.automation.actions.script.condition.TimeIntervalActionScriptCondition.{*}

    val logUtil_TimeIntervalActionScriptCondition : LogUtil = LogUtil.getInstance()

    private var timeIntervalActionScriptConditionJPanel : TimeIntervalActionScriptConditionJPanel = null

    private var timeHelper : TimeDelayHelper = null

    def this(node : Node) = {
        this(TimeIntervalActionScriptCondition.NAME, node, ())
        var actionNode : Node = DomSearchHelper.getNode(TimeIntervalActionScriptConditionData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().compareTo(TimeIntervalActionScriptConditionData.TIME) == 0) {
                        var interval : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setTimeDelayHelper(new TimeDelayHelper(Integer.valueOf(interval)))
                    } else {
                        throw new Exception("Time Interval Action Script Condition Unknown Node")
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Time Interval Action Script Condition Node Null")
        }
        this.init()
    }

    def this() = {
        this(TimeIntervalActionScriptCondition.NAME, null, ())
        this.setTimeDelayHelper(new TimeDelayHelper(0))
        this.init()
    }

    private def init() : Unit = {
        this.timeIntervalActionScriptConditionJPanel = new TimeIntervalActionScriptConditionJPanel(this)
    }

    override def showDialog() : Unit = {
        this.timeIntervalActionScriptConditionJPanel.getTimeIntervalActionJDialog().setVisible(true)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(TimeIntervalActionScriptConditionData.TIME, Integer.toString(this.timeHelper.delay))
        this.logUtil_TimeIntervalActionScriptCondition.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        node.appendChild(ModDomHelper.createNodeWithValueNodes(document, TimeIntervalActionScriptConditionData.NAME, this.toHashMap()))
        return node
    }

    def log() : Unit = {
        this.logUtil_TimeIntervalActionScriptCondition.putF("Time Interval: " + this.timeHelper.delay, this, "log")
    }

    def getTimeDelayHelper() : TimeDelayHelper = {
        return this.timeHelper
    }

    def setTimeDelayHelper(timeHelper : TimeDelayHelper) : Unit = {
        this.timeHelper = timeHelper
    }

    override def shouldProcess(frame : _root_.java.lang.Long) : Boolean = {
        val timeHelper : TimeDelayHelper = this.getTimeDelayHelper()
        if (timeHelper.isTimeTNT()) {
            timeHelper.setStartTimeTNT()
            return super.shouldProcess(frame)
        }
        return false
    }

}

object TimeIntervalActionScriptCondition {
    private val NAME : String = "Time Interval"

}


