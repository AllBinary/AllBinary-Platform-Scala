/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.dom

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentFileHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoProperties
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoPropertiesFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TransformInfoPropertiesDocument(param_filePath : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var document : Document = null

    //Constructor
    {
        val filePath : String = param_filePath
        val xmlFile : AbFile = AbFile.createAbFile(filePath)
        this.document = DomDocumentFileHelper.createDocument(xmlFile)
    }

    def toTransformInfoPropertiesHashMap() : HashMap[Object, Object] = {
        try {
            val transformInfoPropertiesHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            /*          Node objectConfigNode = this.document.getElementsByTagName(             TransformInfoObjectConfigData.NAME).item(0);           NodeList objectConfigChildNodeList = objectConfigNode.getChildNodes();          */
            val transformInfosNode : Node = this.document.getElementsByTagName(TransformInfosData.getInstance().NAME).item(0)
            val transformInfosChildNodeList : NodeList = transformInfosNode.getChildNodes()
            val transformInfoNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(TransformInfoData.getInstance().NAME, transformInfosChildNodeList)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Size: " + transformInfoNodeVector.size(), this, "toTransformInfoPropertiesHashMap()")
            }
            val size : Int = transformInfoNodeVector.size()
            var node : Node = null
            var transformInfoProperties : TransformInfoProperties = null

            {
                var index : Int = 0
                while (index < size) {
                    node = transformInfoNodeVector.get(index).asInstanceOf[Node]
                    //Add each transformInfo and its children
                    transformInfoProperties = TransformInfoPropertiesFactory.getInstance().getInstance(node)
                    transformInfoPropertiesHashMap.put(transformInfoProperties.getName(), transformInfoProperties)
                    index += 1
                }
            }
            return transformInfoPropertiesHashMap
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "toTransformInfoPropertiesHashMap()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


