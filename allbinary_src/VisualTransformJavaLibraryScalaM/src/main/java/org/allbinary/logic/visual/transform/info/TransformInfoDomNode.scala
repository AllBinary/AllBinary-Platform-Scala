/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Attr
import _root_.org.w3c.dom.NamedNodeMap
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TransformInfoDomNode private () {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var transformInfoInterface : TransformInfoInterface = null

    private var mappedName : String = null

    def this(transformInfoInterface : TransformInfoInterface, mappedName : String) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        this.mappedName = mappedName
    }

    def this(name : String, mappedName : String) = {
        this()
        this.transformInfoInterface = new TransformInfo(name)
        //new TransformInfo(name, null, null, null, null);
        this.mappedName = mappedName
    }

    def this(node : Node) = {
        this()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Constructing TransformInfo From TransformInfoDomNode: " + node.getNodeName(), this, "TransformInfoDomNode(Node node)")
        }
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        var attributes : NamedNodeMap = node.getAttributes()
        var attrNode : Attr = attributes.getNamedItem(transformInfoData.NAME).asInstanceOf[Attr]
        var name : String = attrNode.getValue()
        var nodeList : NodeList = node.getChildNodes()
        if (nodeList.getLength() > 1) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Constructing Complete TransformInfo Node For: ")
                stringBuffer.append(name)
                stringBuffer.append(" with ")
                stringBuffer.appendint(nodeList.getLength())
                stringBuffer.append(" children")
                this.logUtil.putF(stringBuffer.toString(), this, "TransformInfoObjectConfigComponent(Node node)")
            }
            var objectFileNameNode : Node = DomSearchHelper.getNode(transformInfoData.OBJECTFILENAME, nodeList)
            var objectFileName : String = DomNodeHelper.getTextNodeValue(objectFileNameNode)
            var objectConfigFileNameNode : Node = DomSearchHelper.getNode(transformInfoData.OBJECTCONFIGFILENAME, nodeList)
            var objectConfigFileName : String = DomNodeHelper.getTextNodeValue(objectConfigFileNameNode)
            var templateFileNameNode : Node = DomSearchHelper.getNode(transformInfoData.TEMPLATEFILENAME, nodeList)
            var templateFileName : String = DomNodeHelper.getTextNodeValue(templateFileNameNode)
            var dataFileNameNode : Node = DomSearchHelper.getNode(transformInfoData.DATAFILENAME, nodeList)
            var dataFileName : String = DomNodeHelper.getTextNodeValue(dataFileNameNode)
            //Assumes that the transform info has absolute URIs unlike Store/Context requests
            this.transformInfoInterface = (new TransformInfo(name, objectFileName, objectConfigFileName, templateFileName, dataFileName)).asInstanceOf[TransformInfoInterface]
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Constructing Partial TransformInfo Node For: ")
                stringBuffer.append(name)
                stringBuffer.append(" with ")
                stringBuffer.appendint(nodeList.getLength())
                stringBuffer.append(" children")
                this.logUtil.putF(stringBuffer.toString(), this, "TransformInfoObjectConfigComponent(Node node)")
            }
            this.transformInfoInterface = (new TransformInfo(name)).asInstanceOf[TransformInfoInterface]
        }
        var templateAttrNode : Attr = attributes.getNamedItem(transformInfoData.MAPPED).asInstanceOf[Attr]
        if (templateAttrNode != null) {
            this.mappedName = templateAttrNode.getValue()
        } else {
            this.mappedName = this.getTransformInfoInterface().getName()
        }
    }

    def this(transformInfoInterface : TransformInfoInterface) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        this.mappedName = transformInfoInterface.getName()
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.transformInfoInterface
    }

    //the number of parent templates required.
    def getMappedName() : String = {
        return this.mappedName
    }

    //TWB - seems that mapped name is not used anymore?
    def getReplaceKey() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("<transform:component name=\"")
        //stringBuffer.append(this.getMappedName());
        stringBuffer.append("body")
        stringBuffer.append("\"/>")
        var key : String = stringBuffer.toString()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Component Key: " + key, this, "getReplaceKey()")
        }
        return key
    }

}


