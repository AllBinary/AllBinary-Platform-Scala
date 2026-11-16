/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class DomSearchHelper private() {
    import _root_.org.allbinary.data.tree.dom.DomSearchHelper.{*}

}

object DomSearchHelper {
    //Finds first node in the nodelist with the same tagname
    def getNodeNoThrow(nodeName : String, nodeList : NodeList) : Node = {
        //PreLogUtil.put("NodeName: " + nodeName, "DomHelper", "searchNodeList");
        val numberOfNodes : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfNodes) {
                val node : Node = nodeList.item(index)
                //PreLogUtil.put("next NodeName: " + node.getNodeName(), "DomHelper", "searchNodeList");
                if (node.getNodeName().compareTo(nodeName) == 0) {
                    return node
                }
                index += 1
            }
        }
        return null
    }

    def getNode(nodeName : String, nodeList : NodeList) : Node = {
        var node : Node = DomSearchHelper.getNodeNoThrow(nodeName, nodeList)
        if (node != null) {
            return node
        } else {
            throw new Exception(nodeName + " Node Not Found in search")
        }
        throw new IllegalStateException()
    }

    def getChildNodeList(nodeName : String, nodeList : NodeList) : NodeList = {
        var node : Node = DomSearchHelper.getNode(nodeName, nodeList)
        return node.getChildNodes()
    }

    //This may be dangerious - since nodes in vector may be lost if it is the last reference
    def getAllNodes(nodeName : String, nodeList : NodeList) : BasicArrayList = {
        var vector : BasicArrayList = DomSearchHelper.getAllNodesNoThrow(nodeName, nodeList)
        if (vector == null) {
            throw new Exception(nodeName + " Node Not Found in search")
        } else {
            return vector
        }
        throw new IllegalStateException()
    }

    //Finds all nodes in the nodelist with the same tagname
    def getAllNodesNoThrow(nodeName : String, nodeList : NodeList) : BasicArrayList = {
        var nodeVector : BasicArrayList = new BasicArrayListD()
        var numberOfNodes : Int = nodeList.getLength()

        {
            var index : Int = 0
            while (index < numberOfNodes) {
                var node : Node = nodeList.item(index)
                /*                   if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().XMLLOGGING))          {                      PreLogUtil.put("NodeName: " + node.getNodeName(),"DomHelper","searchNodeList");          }          */
                if (node.getNodeName().compareTo(nodeName) == 0) {
                    nodeVector.add(node)
                }
                index += 1
            }
        }
        return nodeVector
    }

}


