/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class DomNodeHelper private() {
    import _root_.org.allbinary.data.tree.dom.DomNodeHelper.{*}

}

object DomNodeHelper {
    /*    public static final Node createTempNode(Document document)    {       return document.createElement(TEMPNODE);    }     public static String getKey()    {       return tempNodeStr;    } */
    def getFirstChildElement(parentNode : Node) : Node = {
        var node : Node = parentNode.getFirstChild()
        if ((node != null) && (node.getNodeType() != Node.ELEMENT_NODE)) {
            var nodeList : NodeList = parentNode.getChildNodes()

            {
                var index : Int = 0
                scala.util.boundary { (break_N67554 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < nodeList.getLength()) {
                        node = nodeList.item(index)
                        if (node.getNodeType() == 1) {
                            scala.util.boundary.break()(using break_N67554)
                        }
                        index += 1
                    }
                }
            }
        }
        return node
    }

    def getTextNodeValue(node : Node) : String = {
        var nodeTextNode : Node = node.getFirstChild()
        if (nodeTextNode != null) {
            return nodeTextNode.getNodeValue()
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

    def getTextNodeValue(nodeName : String, nodeList : NodeList) : String = {
        var node : Node = DomSearchHelper.getNode(nodeName, nodeList)
        return DomNodeHelper.getTextNodeValue(node)
    }

    def getTextNodesValue(node : Node) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        var nodeList : NodeList = node.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var nodeTextNode : Node = nodeList.item(index)
                //instanceof org.w3c.dom.Text
                if (nodeTextNode.getNodeType() == Node.TEXT_NODE) {
                    if (nodeTextNode != null) {
                        stringBuffer.append(nodeTextNode.getNodeValue())
                    }
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}


