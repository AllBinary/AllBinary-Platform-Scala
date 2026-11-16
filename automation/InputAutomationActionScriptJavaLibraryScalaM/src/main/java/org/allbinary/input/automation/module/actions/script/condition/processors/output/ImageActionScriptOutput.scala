/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class ImageActionScriptOutput private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptOutput(super_1, super_2) with ImageActionScriptOutputInterface {
    import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageActionScriptOutput.{*}

    val logUtil_ImageActionScriptOutput : LogUtil = LogUtil.getInstance()

    private var saved : Boolean = false

    private var display : Boolean = false

    private var imageTypes : ImageTypes = null

    private var actionScriptOutputJPanel : ImageActionScriptOutputJPanel = null

    def this(node : Node) = {
        this(_root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageActionScriptOutput.NAME, node, ())
        this.logUtil_ImageActionScriptOutput.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        var actionNode : Node = DomSearchHelper.getNode(ImageActionScriptOutputData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().compareTo(ImageActionScriptOutputData.SAVE) == 0) {
                        var booleanString : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setSaved(new _root_.java.lang.Boolean(booleanString).booleanValue())
                    } else if (childNode.getNodeName().compareTo(ImageActionScriptOutputData.DISPLAY) == 0) {
                        var booleanString : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.setSaved(new _root_.java.lang.Boolean(booleanString).booleanValue())
                    } else if (childNode.getNodeName().compareTo(ImageActionScriptOutputData.TYPES) == 0) {
                        this.setImageTypes(new ImageTypes(childNode))
                    } else {
                        throw new Exception("Action Script Output Unknown Node")
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Action Script Output Node Null")
        }
        this.setAllowsChildren(false)
        this.actionScriptOutputJPanel = new ImageActionScriptOutputJPanel(this)
    }

    def this() = {
        this(_root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageActionScriptOutput.NAME, null, ())
        this.setImageTypes(new ImageTypes())
        this.setAllowsChildren(false)
        this.actionScriptOutputJPanel = new ImageActionScriptOutputJPanel(this)
    }

    def getActionScriptOutputJPanel() : ImageActionScriptOutputJPanel = {
        return this.actionScriptOutputJPanel
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(ImageActionScriptOutputData.DISPLAY, _root_.java.lang.Boolean.toString(this.isDisplay()))
        hashMap.put(ImageActionScriptOutputData.SAVE, _root_.java.lang.Boolean.toString(this.isSaved()))
        this.logUtil_ImageActionScriptOutput.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        var newNode : Node = ModDomHelper.createNodeWithValueNodes(document, ImageActionScriptOutputData.NAME, this.toHashMap())
        newNode.appendChild(this.getImageTypes().toXmlNode(document))
        node.appendChild(newNode)
        //return newNode;
        return node
    }

    override def process(frame : _root_.java.lang.Long) : Unit = {
        ImageActionScriptOutputProcessor.process(this, frame)
    }

    override def showDialog() : Unit = {
        this.actionScriptOutputJPanel.getCapturedImageActionJDialog().setVisible(true)
    }

    def isSaved() : Boolean = {
        return this.saved
    }

    def setSaved(saved : Boolean) : Unit = {
        this.saved = saved
    }

    def isDisplay() : Boolean = {
        return this.display
    }

    def setDisplay(display : Boolean) : Unit = {
        this.display = display
    }

    def future_toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(" Is Save: ")
        stringBuffer.appendboolean(this.isSaved())
        stringBuffer.append(" Is Display: ")
        stringBuffer.appendboolean(this.isDisplay())
        stringBuffer.append(" ")
        stringBuffer.append(this.getImageTypes().toString())
        return stringBuffer.toString()
    }

    def log() : Unit = {
        this.logUtil_ImageActionScriptOutput.putF(this.future_toString(), this, "log")
    }

    def getImageTypes() : ImageTypes = {
        return this.imageTypes
    }

    def setImageTypes(imageTypes : ImageTypes) : Unit = {
        this.imageTypes = imageTypes
    }

}

object ImageActionScriptOutput {
    private val NAME : String = "Captures"

}


