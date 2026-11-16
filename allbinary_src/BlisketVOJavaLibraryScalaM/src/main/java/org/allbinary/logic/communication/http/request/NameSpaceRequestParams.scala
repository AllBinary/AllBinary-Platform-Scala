/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

//containing string values and other hashmaps of the like
class NameSpaceRequestParams private (super_1 : HttpServletRequest, constructor_ : Unit) extends RequestParams(super_1) {

    val logUtil_NameSpaceRequestParams : LogUtil = LogUtil.getInstance()

    def this(httpServletRequest : HttpServletRequest) = {
        this(httpServletRequest, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF("Constructing from HttpServletRequest", this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def this(pageContext : PageContext) = {
        this(pageContext, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF("Constructing from PageContext", this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def this() = {
        this(null, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF("Constructing empty", this, this.commonStrings.CONSTRUCTOR)
        }
    }

    //make new node
    private def createPackageNode(document : Document, packageName : String, packagePropertiesHashMap : HashMap[Object, Object]) : Node = {
        val node : Node = document.createElement(packageName)
        //add root node properties
        val propertyKeySet : Set[Object] = packagePropertiesHashMap.keySet().asInstanceOf[Set[Object]]
        val propertyKeySetArray : Array[Object] = propertyKeySet.toArray()
        val size : Int = propertyKeySetArray.length

        {
            var index : Int = 0
            while (index < size) {
                var propertyName : String = propertyKeySetArray(index).asInstanceOf[String]
                var propertyValue : String = packagePropertiesHashMap.get(propertyName).asInstanceOf[String]
                var propertyNode : Node = ModDomHelper.createTextNode(document, propertyName, propertyValue)
                node.appendChild(propertyNode)
                index += 1
            }
        }
        return node
    }

    private def createPackageMultiNode(document : Document, nameSpaceRequestParam : NameSpaceRequestParam, packageName : String, packagePropertiesHashMap : HashMap[Object, Object]) : Node = {
        var beginIndex : Int = packageName.indexOf('[')
        var indexValue : String = packageName.substring(beginIndex + 1, packageName.length() - 1)
        var multiElementPackage : String = packageName.substring(0, beginIndex)
        var selectedValue : String = nameSpaceRequestParam.getValue()
        var propertyValue : String = packagePropertiesHashMap.get(DomData.VALUE).asInstanceOf[String]
        if (propertyValue.compareTo(NameSpaceRequestParamData.VALUE) != 0) {
            selectedValue = propertyValue
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF((((("\nAppending Multinode Element: " + multiElementPackage) + "[") + indexValue) + "] ") + selectedValue, this, "createPackageMultiNode")
        }
        var nextNode : Node = ModDomHelper.createNameValueNodes(document, multiElementPackage, selectedValue)
        //Add Index Data
        var indexNode : Node = ModDomHelper.createTextNode(document, DomData.INDEX, indexValue)
        nextNode.appendChild(indexNode)
        return nextNode
    }

    private def getRootNode(rootElementPackage : String, packagePropertiesHashMap : HashMap[Object, Object], document : Document) : Node = {
        var rootNode : Node = DomSearchHelper.getNodeNoThrow(rootElementPackage, document.getChildNodes())
        if (rootNode == null) {
            //getName()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                this.logUtil_NameSpaceRequestParams.putF(((("\nAppending Document Root: " + "\nElementName: ") + rootElementPackage) + "\nProperties: ") + packagePropertiesHashMap.toString(), this, "getRootNode")
            }
            //make new root node
            var node : Node = this.createPackageNode(document, rootElementPackage, packagePropertiesHashMap)
            document.appendChild(node)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                this.logUtil_NameSpaceRequestParams.putF("\nAppended Document Created: " + XmlDocumentHelper.toString(document), this, "getRootNode")
            }
            return node
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                this.logUtil_NameSpaceRequestParams.putF("\nUsing Existing Root Node", this, "getRootNode")
            }
            return rootNode
        }
        throw new IllegalStateException()
    }

    private def addNewProperties(document : Document, node : Node, nextPackagePropertiesHashMap : HashMap[Object, Object]) : Node = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF(new StringMaker().append("\nAdding Any New Properties: ").append(nextPackagePropertiesHashMap.toString()).append("\nto node: ").append(node.getNodeName()).toString(), this, "addNewProperties")
        }
        val propertyNameSet : Set[Object] = nextPackagePropertiesHashMap.keySet().asInstanceOf[Set[Object]]
        val propertyNameSetArray : Array[Object] = propertyNameSet.toArray()
        val size : Int = propertyNameSetArray.length

        {
            var index : Int = 0
            while (index < size) {
                var nextPropertyName : String = propertyNameSetArray(index).asInstanceOf[String]
                var propertyValue : String = StringUtil.getInstance().getNonNull(nextPackagePropertiesHashMap.get(nextPropertyName).asInstanceOf[String])
                //Obtain DomData.VALUE and compare to new value
                var valueNode : Node = DomSearchHelper.getNodeNoThrow(nextPropertyName, node.getChildNodes())
                if (valueNode != null) {
                    var existingElementNodeTextNodeValue : String = DomNodeHelper.getTextNodeValue(valueNode)
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF(((((((("\nIf property: \"" + nextPropertyName) + " is the same as:\n") + "Node: ") + node.getNodeName()) + " then: ") + propertyValue) + "==") + existingElementNodeTextNodeValue, this, "addNewProperties")
                    }
                    //Node does not have the same properties
                    if (propertyValue.compareTo(existingElementNodeTextNodeValue) != 0) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                            this.logUtil_NameSpaceRequestParams.putF("At least one Property from NameSpaceRequest Package was different from Node", this, "addNewProperties")
                        }
                        //found a property that does not match
                        throw new Exception("Property Modifications Should Not Occur")
                    }
                } else {
                    //found a new property and now add it
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF((("Adding a new Property: " + nextPropertyName) + "=") + propertyValue, this, "addNewProperties")
                    }
                    var newPropertyNode : Node = ModDomHelper.createTextNode(document, nextPropertyName, propertyValue)
                    node.appendChild(newPropertyNode)
                }
                index += 1
            }
        }
        return node
    }

    private def isElementValueTextNodeEqual(nextPackagePropertiesHashMap : HashMap[Object, Object], node : Node) : Boolean = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF((("\nComparing the value property in: " + nextPackagePropertiesHashMap.toString()) + "\nto node child leaves of node: ") + node.getNodeName(), this, "isElementValueTextNodeEqual")
        }
        var propertyValue : String = nextPackagePropertiesHashMap.get(DomData.VALUE).asInstanceOf[String]
        //Obtain DomData.VALUE and compare to new value
        var valueNode : Node = DomSearchHelper.getNodeNoThrow(DomData.VALUE, node.getChildNodes())
        if (valueNode != null) {
            var existingElementNodeTextNodeValue : String = DomNodeHelper.getTextNodeValue(valueNode)
            //found a property that does not match
            if (propertyValue.compareTo(existingElementNodeTextNodeValue) == 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_NameSpaceRequestParams.putF("Value Node is the same", this, "isElementValueTextNodeEqual")
                }
                return true
            }
        } else {
            return true
        }
        return false
    }

    private def isElementValueTextNodeUnique(nextPackagePropertiesHashMap : HashMap[Object, Object], elementNodeVector : BasicArrayList) : Int = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF(("\nComparing Properties of: " + elementNodeVector.size()) + " Nodes", this, "isElementValueTextNodeUnique")
        }
        //see if a value node contains unique values
        val size : Int = elementNodeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var existingElementNode : Node = elementNodeVector.get(index).asInstanceOf[Node]
                if (this.isElementValueTextNodeEqual(nextPackagePropertiesHashMap, existingElementNode)) {
                    return index
                }
                index += 1
            }
        }
        return -1
    }

    private def addChildren(document : Document, rootNode : Node, nameSpaceRequestParam : NameSpaceRequestParam) : Document = {
        var node : Node = rootNode
        //vector contains hashmaps with one dom element
        val packageVector : BasicArrayList = nameSpaceRequestParam.getPackages()
        //Add Children
        val size : Int = packageVector.size()

        {
            var index : Int = 1
            while (index < size) {
                var nextPackageName : String = packageVector.get(index).asInstanceOf[String]
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_NameSpaceRequestParams.putF(new StringMaker().append("\nTrying to Add Child to Node: ").append(node.getNodeName()).append("\nwith new PackageName: ").append(nextPackageName).toString(), this, "addChildren")
                }
                var nextPackagePropertiesHashMap : HashMap[Object, Object] = nameSpaceRequestParam.getPackageProperties(index).asInstanceOf[HashMap[Object, Object]]
                var elementNodeVector : BasicArrayList = DomSearchHelper.getAllNodesNoThrow(nextPackageName, node.getChildNodes())
                //Document already has atleast 1 node with the same package name
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_NameSpaceRequestParams.putF(("\nDocument Contains " + elementNodeVector.size()) + " Node(s) With Same Name", this, "addChildren")
                }
                //Special for value property
                var isElementValueTextNodeUniqueIndex : Int = this.isElementValueTextNodeUnique(nextPackagePropertiesHashMap, elementNodeVector)
                //Create new node if node with the same name does not exist unless an array multinode
                if (((elementNodeVector.size() == 0) || (isElementValueTextNodeUniqueIndex == -1)) && !nextPackageName.endsWith(CommonSeps.getInstance().BRACKET_CLOSE)) {
                    var nextNode : Node = this.createPackageNode(document, nextPackageName, nextPackagePropertiesHashMap)
                    node.appendChild(nextNode)
                    //Crazy data carry through
                    node = nextNode
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF("\nAppended Package: " + node.getNodeName(), this, "addChildren")
                        this.logUtil_NameSpaceRequestParams.putF("\nAppended Document Created: " + XmlDocumentHelper.toString(document), this, "addChildren")
                    }
                } else if (nextPackageName.endsWith(CommonSeps.getInstance().BRACKET_CLOSE)) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF("Package is MultiNode: just append", this, "addChildren")
                    }
                    var nextNode : Node = this.createPackageMultiNode(document, nameSpaceRequestParam, nextPackageName, nextPackagePropertiesHashMap)
                    node.appendChild(nextNode)
                    node = nextNode
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF("\nAppended Multinode Element: " + XmlDocumentHelper.toString(document), this, "addChildren")
                    }
                } else {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF("Value Node already exists: Now compare (properties to leaf nodes)", this, "addChildren")
                    }
                    var nodeNameDuplicateNode : Node = elementNodeVector.get(isElementValueTextNodeUniqueIndex).asInstanceOf[Node]
                    node = this.addNewProperties(document, nodeNameDuplicateNode, nextPackagePropertiesHashMap)
                    //Not Unique so move on to duplicate
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                        this.logUtil_NameSpaceRequestParams.putF("\nDuplicate Node Found: Moving to next child ^", this, "addChildre")
                    }
                }
                index += 1
            }
        }
        return document
    }

    private def addNameSpace(key : String, value : String, document : Document) : Document = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF(new StringMaker().append("NameSpace key: ").append(key).append(" Value: ").append(value).toString(), this, "addNameSpace")
        }
        val nameSpaceRequestParam : NameSpaceRequestParam = new NameSpaceRequestParam(key, value)
        //vector contains hashmaps with one dom element
        val packageVector : BasicArrayList = nameSpaceRequestParam.getPackages()
        val size : Int = packageVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var packageName : String = packageVector.get(index).asInstanceOf[String]
                var packagePropertiesHashMap : HashMap[Object, Object] = nameSpaceRequestParam.getPackageProperties(packageVector.indexOf(packageName)).asInstanceOf[HashMap[Object, Object]]
                var rootNode : Node = this.getRootNode(packageName, packagePropertiesHashMap, document)
                //document
                if (index < (size - 1)) {
                    return this.addChildren(document, rootNode.asInstanceOf[Node], nameSpaceRequestParam)
                }
                index += 1
            }
        }
        return document
    }

    override def toHashMap() : HashMap[Object, Object] = {
        var document : Document = DomDocumentHelper.create()
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val keys : Set[Object] = this.getMap().keySet().asInstanceOf[Set[Object]]
        val keyArray : Array[Object] = keys.toArray()
        val keySize : Int = keyArray.length
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF("NameSpace Request Size: " + keys.size(), this, "toHashMap")
        }

        {
            var i : Int = 0
            while (i < keySize) {
                var key : String = keyArray(i).asInstanceOf[String]
                var anyType : Object = this.getMap().get(key)
                var className : String = anyType.getClass().getName().asInstanceOf[String]
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                    this.logUtil_NameSpaceRequestParams.putF("Request Param Class: " + className, this, "toHashMap")
                }
                if (this.getMap().get(key).isInstanceOf[String]) {
                    var value : String = this.getMap().get(key).asInstanceOf[String]
                    if (key.indexOf(NameSpaceRequestParamData.NAME) < 0) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                            this.logUtil_NameSpaceRequestParams.putF((("Not NameSpace key: " + key) + " Value: ") + value, this, "toHashMap()")
                        }
                        hashMap.put(new String(key), new String(value))
                    } else {
                        document = this.addNameSpace(new String(key), new String(value), document)
                    }
                } else if (this.getMap().get(key).isInstanceOf[Array[String]]) {
                    var values : Array[String] = this.getMap().get(key).asInstanceOf[Array[String]]
                    if (key.indexOf(NameSpaceRequestParamData.NAME) < 0) {
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
                            this.logUtil_NameSpaceRequestParams.putF((("Not NameSpace key: " + key) + " Value: ") + values(0), this, "toHashMap()")
                        }
                        hashMap.put(new String(key), new String(values(0)))
                    } else {
                        document = this.addNameSpace(new String(key), new String(values(0)), document)
                    }
                }
                i += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().HTTPREQUEST)) {
            this.logUtil_NameSpaceRequestParams.putF((((("NameSpaceRequestParams: " + this.getMap().toString()) + "\ntoHashMap(): ") + hashMap.toString()) + "\nDocument Created: ") + XmlDocumentHelper.toString(document), this, "toHashMap()")
        }
        hashMap.put(NameSpaceRequestParamData.DOCUMENT, document)
        return hashMap
    }

}


