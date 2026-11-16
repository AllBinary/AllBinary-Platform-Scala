/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.io.OutputTypeData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoDomNode
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.logic.visual.transform.template.XslData
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Attr
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.NamedNodeMap
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class TransformInfoObjectConfig private () extends TransformInfoObjectConfigInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var ownerTransformInfoInterface : TransformInfoInterface = null

    /**     * <OBJECTCONFIG_NAME OBJECTCONFIG_NAME="GenericStoreCompoundTransformInfoConfig" >     * <OBJECTCONFIG_TEMPLATE_NAME TRANSFORM_INFO_NAME="a Contact" >     * </OBJECTCONFIG_TEMPLATE_NAME>     * <TRANSFORM_COMPONENTS_NAME>     * <COMPONENT_NAME TRANSFORM_INFO_NAME="a Contact Body" >     * </COMPONENT_NAME>     * </TRANSFORM_COMPONENTS_NAME>     * </OBJECTCONFIG_NAME>     */
    private var document : Document = null

    private var outputTypeName : String = null

    def this(transformInfoInterface : TransformInfoInterface, name : String, `type` : String) = {
        this()
        this.ownerTransformInfoInterface = transformInfoInterface
        this.createDocument()
        var configNameAttr : Attr = this.document.createAttribute(TransformInfoObjectConfigData.getInstance().NAME)
        configNameAttr.setValue(name)
        var objectConfigNode : Node = this.document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
        objectConfigNode.appendChild(configNameAttr)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("TransformInfo: ")
            if (this.ownerTransformInfoInterface != null) {
                stringBuffer.append(this.ownerTransformInfoInterface.getName())
            } else {
                stringBuffer.append("No Owner!?#@")
            }
            stringBuffer.append("\nConstructed with document: ")
            stringBuffer.append(this.toString())
            this.logUtil.putF(stringBuffer.toString(), this, "Constructor(TransformInfoInterface, name, type)")
        }
    }

    def this(transformInfoInterface : TransformInfoInterface, document : Document) = {
        this()
        this.ownerTransformInfoInterface = transformInfoInterface
        this.document = document
        var node : Node = DomSearchHelper.getNodeNoThrow(OutputTypeData.getInstance().NAME, this.getRootNode().getChildNodes())
        if (node != null) {
            this.setOutputTypeName(DomNodeHelper.getTextNodeValue(node))
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("TransformInfo: ")
            if (this.ownerTransformInfoInterface != null) {
                stringBuffer.append(this.ownerTransformInfoInterface.getName())
            } else {
                stringBuffer.append("No Owner!?#@")
            }
            stringBuffer.append("\nConstructed with document: ")
            stringBuffer.append(this.toString())
            this.logUtil.putF(stringBuffer.toString(), this, "Constructor(TransformInfoInterface, Document)")
        }
    }

    /*    private String inputOutputTypeName;    private String inputOutputTypeFile;     private String importUriPath;    */
    def this(transformInfoInterface : TransformInfoInterface) = {
        this()
        this.ownerTransformInfoInterface = transformInfoInterface
        this.createDocument()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("TransformInfo: ")
            if (this.ownerTransformInfoInterface != null) {
                stringBuffer.append(this.ownerTransformInfoInterface.getName())
            } else {
                stringBuffer.append("No Owner!?#@")
            }
            stringBuffer.append("\nConstructed with document: ")
            stringBuffer.append(this.toString())
            this.logUtil.putF(stringBuffer.toString(), this, "Constructor(TransformInfoInterface)")
        }
    }

    private def createDocument() : Unit = {
        this.document = DomDocumentHelper.create()
        var objectConfigNode : Node = this.document.createElement(TransformInfoObjectConfigData.getInstance().NAME)
        this.document.appendChild(objectConfigNode)
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.ownerTransformInfoInterface
    }

    def toXmlDoc() : Document = {
        return this.document
    }

    def setDocument(document : Document) : Unit = {
        this.document = document
    }

    //Usually used for updating a sites templates
    def containsView(transformInfoInterface : TransformInfoInterface) : Boolean = {
        var objectConfigNode : Node = this.document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
        var viewNodeList : NodeList = objectConfigNode.getChildNodes()
        var numberOfViews : Int = viewNodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfViews) {
                var viewNode : Node = viewNodeList.item(index)
                var viewAttributes : NamedNodeMap = viewNode.getAttributes()
                var attrNode : Attr = viewAttributes.getNamedItem(TransformInfoData.getInstance().NAME).asInstanceOf[Attr]
                if (transformInfoInterface.getName().compareTo(attrNode.getValue()) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    private def getTemplateAttributes() : NamedNodeMap = {
        var componentNode : Node = this.document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
        return componentNode.getAttributes()
    }

    def getName() : String = {
        var attrNode : Attr = this.getTemplateAttributes().getNamedItem(TransformInfoObjectConfigData.getInstance().NAME).asInstanceOf[Attr]
        return attrNode.getValue()
    }

    def setName(name : String) : Unit = {
        var attrNode : Attr = this.getTemplateAttributes().getNamedItem(TransformInfoObjectConfigData.getInstance().NAME).asInstanceOf[Attr]
        attrNode.setValue(name)
    }

    private def getNodeVector(nodeName : String) : BasicArrayList = {
        var componentsNodeList : NodeList = this.document.getElementsByTagName(nodeName)
        if ((componentsNodeList != null) && (componentsNodeList.getLength() > 0)) {
            var viewNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(TransformInfoData.getInstance().NAME, componentsNodeList.item(0).getChildNodes())
            var numberOfViews : Int = viewNodeVector.size()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Number Of ")
                stringBuffer.append(nodeName)
                stringBuffer.append(" Nodes: ")
                stringBuffer.appendint(numberOfViews)
                this.logUtil.putF(stringBuffer.toString(), this, "getNodeVector(nodename)")
            }
            return viewNodeVector
        }
        return new BasicArrayListD()
    }

    //Best to not use this
    private def getTransformDomNodes(nodeName : String) : BasicArrayList = {
        var viewVector : BasicArrayList = new BasicArrayListD()
        var viewNodeVector : BasicArrayList = this.getNodeVector(nodeName)
        val size : Int = viewNodeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var viewNode : Node = viewNodeVector.get(index).asInstanceOf[Node]
                viewVector.add(new TransformInfoDomNode(viewNode))
                index += 1
            }
        }
        return viewVector
    }

    def getTransforms(nodeName : String) : BasicArrayList = {
        var viewVector : BasicArrayList = new BasicArrayListD()
        var viewNodeVector : BasicArrayList = this.getNodeVector(nodeName)
        val size : Int = viewNodeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var viewNode : Node = viewNodeVector.get(index).asInstanceOf[Node]
                viewVector.add(new TransformInfoDomNode(viewNode).getTransformInfoInterface())
                index += 1
            }
        }
        return viewVector
    }

    def getTransformsGroup(group : String) : BasicArrayList = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Started: " + group, this, "getTransformsGroup()")
        }
        var viewVector : BasicArrayList = new BasicArrayListD()
        val GROUP : String = TransformInfosData.getInstance().GROUP
        var componentsNodeList : NodeList = this.document.getElementsByTagName(GROUP)
        if ((componentsNodeList != null) && (componentsNodeList.getLength() > 0)) {
            var componentsNode : Node = componentsNodeList.item(0)
            var length : Int = componentsNodeList.getLength()

            {
                var index : Int = 0
                scala.util.boundary { (break_N76878 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < length) {
                        var node : Node = componentsNodeList.item(index)
                        var attributes : NamedNodeMap = node.getAttributes()
                        var attrNode : Attr = attributes.getNamedItem(GROUP).asInstanceOf[Attr]
                        var value : String = attrNode.getValue()
                        if (value.compareTo(group) == 0) {
                            componentsNode = node
                            scala.util.boundary.break()(using break_N76878)
                        }
                        index += 1
                    }
                }
            }
            var viewNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(TransformInfoData.getInstance().NAME, componentsNode.getChildNodes())
            var numberOfViews : Int = viewNodeVector.size()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Number Of Nodes: " + numberOfViews, this, "getTransformsGroup()")
            }
            val size : Int = viewNodeVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var viewNode : Node = viewNodeVector.get(index).asInstanceOf[Node]
                    viewVector.add(new TransformInfoDomNode(viewNode))
                    index += 1
                }
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                if (componentsNodeList == null) {
                    this.logUtil.putF("Number Of Nodes: NULL", this, "getTransformsGroup()")
                } else {
                    this.logUtil.putF("Number Of Nodes: 0", this, "getTransformsGroup()")
                }
            }
        }
        return viewVector
    }

    def getTransformDomNodes() : BasicArrayList = {
        return this.getTransformDomNodes(TransformInfosData.getInstance().GROUP)
    }

    def getTransforms() : BasicArrayList = {
        return this.getTransforms(TransformInfosData.getInstance().NAME)
    }

    def getGroupTransforms() : BasicArrayList = {
        return this.getTransforms(TransformInfosData.getInstance().GROUP)
    }

    def getParentTransforms() : BasicArrayList = {
        return this.getTransforms(TransformInfoData.getInstance().PARENT)
    }

    private def getRootNode() : Node = {
        return this.document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
    }

    def setOutputTypeName(outputTypeName : String) : Unit = {
        this.outputTypeName = outputTypeName
    }

    def getOutputTypeName() : String = {
        return this.outputTypeName
    }

    def getInputOutputTypeName() : String = {
        var node : Node = DomSearchHelper.getNode(InputOutputTypeData.getInstance().NAME, this.getRootNode().getChildNodes())
        return DomNodeHelper.getTextNodeValue(node)
    }

    def getInputOutputTypeFile() : String = {
        var node : Node = DomSearchHelper.getNode(InputOutputTypeData.getInstance().FILE, this.getRootNode().getChildNodes())
        return DomNodeHelper.getTextNodeValue(node)
    }

    def getImportUriPath() : String = {
        var node : Node = DomSearchHelper.getNode(XslData.getInstance().ROOT_IMPORT_URI, this.getRootNode().getChildNodes())
        return DomNodeHelper.getTextNodeValue(node)
    }

    /*    public void setImportUriPath(String importUriPath)    {       this.importUriPath = importUriPath;    }       */
    override def toString() : String = {
        try {
            if (this.document != null) {
                return XmlDocumentHelper.toString(this.document)
            } else {
                return null
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.putF("DOM Document error", this, this.commonStrings.TOSTRING)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


