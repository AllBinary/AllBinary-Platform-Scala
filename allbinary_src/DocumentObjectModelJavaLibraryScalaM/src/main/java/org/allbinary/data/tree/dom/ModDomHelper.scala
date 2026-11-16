/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.java.anyType.clazz.ClassUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ModDomHelper private() {
    import _root_.org.allbinary.data.tree.dom.ModDomHelper.{*}

}

object ModDomHelper {
    def createTextNode(document : Document, name : String, text : String) : Node = {
        var newValueNode : Node = document.createElement(name)
        var newValueTextNode : Node = document.createTextNode(text)
        newValueNode.appendChild(newValueTextNode)
        return newValueNode
    }

    def createValueNode(document : Document, text : String) : Node = {
        return ModDomHelper.createTextNode(document, DomData.VALUE, text)
    }

    def createNameNode(document : Document, text : String) : Node = {
        return ModDomHelper.createTextNode(document, DomData.NAME, text)
    }

    def createIndexNode(document : Document, index : Int) : Node = {
        return ModDomHelper.createTextNode(document, DomData.INDEX, new Integer(index).toString())
    }

    def createNameValueNodes(document : Document, elementName : String, nameText : String, valueText : String) : Node = {
        var newNode : Node = document.createElement(elementName)
        newNode.appendChild(ModDomHelper.createNameNode(document, nameText))
        newNode.appendChild(ModDomHelper.createValueNode(document, valueText))
        return newNode
    }

    def createNameValueNodes(document : Document, elementNameAndNameText : String, valueText : String) : Node = {
        var newNode : Node = ModDomHelper.createNameValueNodes(document, elementNameAndNameText, elementNameAndNameText, valueText)
        return newNode
    }

    def createNameValueIndexNodes(document : Document, elementNameAndNameText : String, index : Int, valueText : String) : Node = {
        var newNode : Node = ModDomHelper.createNameValueNodes(document, elementNameAndNameText, valueText)
        newNode.appendChild(ModDomHelper.createIndexNode(document, index))
        return newNode
    }

    def createNameValueNodes(document : Document, rootNode : String, hashMap : HashMap[Object, Object]) : Node = {
        var node : Node = document.createElement(rootNode)
        return ModDomHelper.createNameValueNodes(document, node, hashMap)
    }

    //Don't use - use withvaluenodes - it excludes name nodes and makes value nodes a text node
    def createNameValueNodes(document : Document, node : Node, hashMap : HashMap[Object, Object]) : Node = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keySet.toArray()
        var size : Int = keyArray.length

        {
            var i : Int = 0
            while (i < size) {
                var objectKey : Object = keyArray(i)
                var name : String = objectKey.asInstanceOf[String]
                var anyType : Object = hashMap.get(objectKey).asInstanceOf[Object]
                //this.logUtil.putF("Adding: " + name + "=" + value ,this,"toXmlNode(document)");
                if (anyType == null) {
                    var value : String = stringUtil.EMPTY_STRING
                    node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                } else if (anyType.isInstanceOf[String]) {
                    var value : String = stringUtil.getNonNull(anyType.asInstanceOf[String])
                    node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                } else if (anyType.isInstanceOf[HashMap[Object, Object]]) {
                    node.appendChild(ModDomHelper.createNameValueNodes(document, name, hashMap))
                } else {
                    throw new Exception("HashMap value is the wrong instance and is: " + ClassUtil.viewAll(anyType, CommonSeps.getInstance().NEW_LINE))
                }
                i += 1
            }
        }
        return node
    }

    def createNameValueNodes(document : Document, rootNodeName : String, duplicateNodeName : String, valueVector : BasicArrayList) : Node = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        var node : Node = document.createElement(rootNodeName)
        var size : Int = valueVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var value : String = stringUtil.getNonNull(valueVector.get(i).asInstanceOf[String])
                //this.logUtil.putF("Adding: " + name + "=" + value , this, stringUtil.EMPTY_STRING);
                node.appendChild(ModDomHelper.createNameValueNodes(document, duplicateNodeName, value))
                i += 1
            }
        }
        return node
    }

    def createNameValueIndexNodes(document : Document, rootNodeName : String, duplicateNodeName : String, valueVector : BasicArrayList) : Node = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        var node : Node = document.createElement(rootNodeName)
        var size : Int = valueVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var value : String = stringUtil.getNonNull(valueVector.get(index).asInstanceOf[String])
                //this.logUtil.putF("Adding: " + name + "=" + value , this, stringUtil.EMPTY_STRING);
                node.appendChild(ModDomHelper.createNameValueIndexNodes(document, duplicateNodeName, index, value))
                index += 1
            }
        }
        return node
    }

    def createNodeWithValueNodes(document : Document, rootNode : String, hashMap : HashMap[Object, Object]) : Node = {
        var node : Node = document.createElement(rootNode)
        return ModDomHelper.createNodeWithValueNodes(document, node, hashMap)
    }

    def createNodeWithValueNodes(document : Document, node : Node, hashMap : HashMap[Object, Object]) : Node = {
        var stringUtil : StringUtil = StringUtil.getInstance()
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keySet.toArray()
        var size : Int = keyArray.length

        {
            var i : Int = 0
            while (i < size) {
                var name : String = keyArray(i).asInstanceOf[String]
                var anyType : Object = hashMap.get(name).asInstanceOf[Object]
                //this.logUtil.putF("Adding: " + name + "=" + value ,this,"toXmlNode(document)");
                var value : String = stringUtil.getNonNull(anyType.asInstanceOf[String])
                node.appendChild(ModDomHelper.createTextNode(document, name, value))
                i += 1
            }
        }
        return node
    }

}


