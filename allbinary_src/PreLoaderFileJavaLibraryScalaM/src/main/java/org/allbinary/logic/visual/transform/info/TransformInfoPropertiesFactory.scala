/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.w3c.dom.Attr
import _root_.org.w3c.dom.NamedNodeMap
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TransformInfoPropertiesFactory private() {
    import _root_.org.allbinary.logic.visual.transform.info.TransformInfoPropertiesFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(node : Node) : TransformInfoProperties = {
        val transformInfoChildNodeList : NodeList = node.getChildNodes()
        val transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        val attributes : NamedNodeMap = node.getAttributes()
        val attrNode : Attr = attributes.getNamedItem(transformInfoData.NAME).asInstanceOf[Attr]
        val name : String = attrNode.getValue()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF((CommonLabels.getInstance().NEXT + " View Name: ") + name, this, "toTransformInfoPropertiesHashMap()")
        }
        val labelNode : Node = DomSearchHelper.getNodeNoThrow(transformInfoData.LABEL, transformInfoChildNodeList)
        var label : String = DomNodeHelper.getTextNodesValue(labelNode)
        if (label == null) {
            label = name
        }
        val descriptionNode : Node = DomSearchHelper.getNode(transformInfoData.DESCRIPTION, transformInfoChildNodeList)
        val description : String = DomNodeHelper.getTextNodesValue(descriptionNode)
        val objectFileNode : Node = DomSearchHelper.getNode(transformInfoData.OBJECTFILENAME, transformInfoChildNodeList)
        val objectFileName : String = DomNodeHelper.getTextNodeValue(objectFileNode)
        val objectConfigFileNode : Node = DomSearchHelper.getNode(transformInfoData.OBJECTCONFIGFILENAME, transformInfoChildNodeList)
        val objectConfigFileName : String = DomNodeHelper.getTextNodeValue(objectConfigFileNode)
        val templateFileNode : Node = DomSearchHelper.getNode(transformInfoData.TEMPLATEFILENAME, transformInfoChildNodeList)
        val templateFileName : String = DomNodeHelper.getTextNodeValue(templateFileNode)
        val transformInfoProperties : TransformInfoProperties = new TransformInfoProperties(name, label, description, objectFileName, objectConfigFileName, templateFileName)
        //TWB - Why was I returning null here for all cases?
        return transformInfoProperties
    }

}

object TransformInfoPropertiesFactory {
    private val instance : TransformInfoPropertiesFactory = new TransformInfoPropertiesFactory()

    def getInstance() : TransformInfoPropertiesFactory = {
        return TransformInfoPropertiesFactory.instance
    }

}


