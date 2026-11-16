/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.dhtml.style.css.property.CssPropertiesValidationFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class CssElementView() extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val TITLE : String = "title"

    private val DESCRIPTION : String = "description"

    private var value : String = null

    private var title : String = null

    private var description : String = null

    var cssElementVector : BasicArrayList = null

    var cssPropertyVector : BasicArrayList = null

    //Constructor
    {
        this.cssPropertyVector = new BasicArrayListD()
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.title = stringUtil.EMPTY_STRING
        this.description = stringUtil.EMPTY_STRING
        this.value = stringUtil.EMPTY_STRING
    }

    def this(node : Node) = {
        this()
        try {
            val valueNode : Node = DomSearchHelper.getNode(DomData.VALUE, node.getChildNodes())
            this.value = DomNodeHelper.getTextNodeValue(valueNode)
            val titleValueNode : Node = DomSearchHelper.getNodeNoThrow(this.TITLE, node.getChildNodes())
            if (titleValueNode != null) {
                this.title = DomNodeHelper.getTextNodeValue(titleValueNode)
            } else {
                val stringUtil : StringUtil = StringUtil.getInstance()
                this.title = stringUtil.EMPTY_STRING
            }
            val descriptionValueNode : Node = DomSearchHelper.getNodeNoThrow(this.DESCRIPTION, node.getChildNodes())
            if (descriptionValueNode != null) {
                this.description = DomNodeHelper.getTextNodeValue(descriptionValueNode)
            } else {
                this.description = StringUtil.getInstance().EMPTY_STRING
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF(new StringMaker().append("Value: ").append(this.value).append("\nTitle: ").append(this.title).append("\nDescription: ").append(this.description).toString(), this, this.commonStrings.CONSTRUCTOR)
            }
            //Nodes with CssElementData.NAME
            var cssElementStyleNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(CssElementData.getInstance().NAME, node.getChildNodes())
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Child Css Elements: " + cssElementStyleNodeVector.size(), this, "CssElementView()")
            }
            this.cssElementVector = CssElementsValidationFactory.getInstance(cssElementStyleNodeVector)
            val nodeList : NodeList = node.getChildNodes()
            this.cssPropertyVector = CssPropertiesValidationFactory.getInstance(nodeList)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(new StringMaker().append("Value: ").append(this.value).append("\nTitle: ").append(this.title).append("\nDescription: ").append(this.description).toString(), this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw new Exception("CssElementView")
            }
        }
    }

    def getValue() : String = {
        return this.value
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        //hashMap.put(CssElementData.NAME, this.name);
        hashMap.put(DomData.VALUE, this.value)
        hashMap.put(this.TITLE, this.title)
        hashMap.put(this.DESCRIPTION, this.description)
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("CssView HashMap: " + hashMap.toString(), this, "toXmlNode")
        }
        var node : Node = ModDomHelper.createNodeWithValueNodes(document, CssElementData.getInstance().NAME, hashMap)
        val size : Int = this.cssPropertyVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var cssPropertyDomNodeInterface : DomNodeInterface = this.cssPropertyVector.get(index).asInstanceOf[DomNodeInterface]
                node.appendChild(cssPropertyDomNodeInterface.toXmlNode(document))
                index += 1
            }
        }
        val size2 : Int = this.cssElementVector.size()

        {
            var index : Int = 0
            while (index < size2) {
                var cssElementDomNodeInterface : DomNodeInterface = this.cssElementVector.get(index).asInstanceOf[DomNodeInterface]
                node.appendChild(cssElementDomNodeInterface.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

}


