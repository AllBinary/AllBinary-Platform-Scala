/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea

import _root_.org.allbinary.dom.DomHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class WorkAreaDom(param_document : Document) {
    import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.{WORKAREA as _, NAME as _, FRAMES as _, *}
    def WORKAREA : String = _root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.WORKAREA
    def NAME : String = _root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.NAME
    def FRAMES : String = _root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.FRAMES

    private var name : String = null

    private var canvasNodeList : BasicArrayList = null

    //Constructor
    {
        val document : Document = param_document
        var workAreaNodeList : NodeList = document.getElementsByTagName(_root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.WORKAREA)
        if (workAreaNodeList != null) {
            var numberOfworkAreas : Int = workAreaNodeList.getLength()
            if (numberOfworkAreas == 1) {
                var numberOfNodes : Int = workAreaNodeList.getLength()
                //find name node
                var nameNode : Node = DomHelper.getInstance().searchNodeList(_root_.org.allbinary.graphics.j2me.workarea.WorkAreaDom.NAME, workAreaNodeList.item(0).getChildNodes())
                var nameTextNode : Node = nameNode.getFirstChild()
                this.name = nameTextNode.getNodeValue()
            } else {
                throw new Exception("Wrong Number of WorkAreas: " + numberOfworkAreas)
            }
            this.canvasNodeList = DomHelper.getInstance().getChildrenWithoutTextNodes(WorkAreaDom.FRAMES, workAreaNodeList.item(0).getChildNodes())
        } else {
            throw new Exception("workArea Node Not Found")
        }
    }

    def getName() : String = {
        return this.name
    }

    def getCanvasNodes() : BasicArrayList = {
        return this.canvasNodeList
    }

}

object WorkAreaDom {
    val WORKAREA : String = "workArea"

    val NAME : String = "name"

    val FRAMES : String = "frames"

}


