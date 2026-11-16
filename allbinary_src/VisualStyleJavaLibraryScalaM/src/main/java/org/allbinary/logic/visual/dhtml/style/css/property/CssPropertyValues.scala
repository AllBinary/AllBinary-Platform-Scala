/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property

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
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CssPropertyValues() extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var propertyValueVector : BasicArrayList = null

    //Constructor
    {
        this.propertyValueVector = new BasicArrayListD()
    }

    def this(node : Node) = {
        this()
        var indexPropertyValueHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.propertyValueVector = new BasicArrayListD()
        //Child Nodes Are CssPropertyData.VALUE
        var cssPropertyNodeVector : BasicArrayList = DomSearchHelper.getAllNodes(CssPropertyValueData.getInstance().NAME, node.getChildNodes())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STYLE)) {
            this.logUtil.putF("Number Of Properties: " + cssPropertyNodeVector.size(), this, "CssProperties()")
        }
        val size : Int = cssPropertyNodeVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var cssPropertyValueNode : Node = cssPropertyNodeVector.get(index).asInstanceOf[Node]
                var valueNode : Node = DomSearchHelper.getNode(DomData.VALUE, cssPropertyValueNode.getChildNodes())
                var propertyValue : String = DomNodeHelper.getTextNodeValue(valueNode)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STYLE)) {
                    this.logUtil.putF("Property Value: " + propertyValue, this, "CssProperties()")
                }
                var indexNode : Node = DomSearchHelper.getNode(DomData.INDEX, cssPropertyValueNode.getChildNodes())
                var indexValue : String = DomNodeHelper.getTextNodeValue(indexNode)
                indexPropertyValueHashMap.put(indexValue, propertyValue)
                index += 1
            }
        }
        val size2 : Int = indexPropertyValueHashMap.keySet().size()

        {
            var index : Int = 0
            while (index < size2) {
                var indexInt : Integer = new Integer(index)
                var propertyValue : String = indexPropertyValueHashMap.get(indexInt.toString()).asInstanceOf[String]
                this.propertyValueVector.add(propertyValue)
                index += 1
            }
        }
    }

    /*    public CssPropertyValues(HashMap hashMap)    {       this.propertyValueVector = new BasicArrayListD();        Set set = hashMap.keySet();       iter = set;       int index = 0;        while(iter.hasNext())       {          String key = (String) iter.next();          String value = (String) hashMap.get(key);          this.propertyValueVector.add(value);       }    } */
    def toHashMap() : HashMap[Object, Object] = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val cssPropertyValueData : CssPropertyValueData = CssPropertyValueData.getInstance()
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val stringBuffer : StringMaker = new StringMaker()
        val size : Int = this.propertyValueVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var value : String = this.propertyValueVector.get(index).asInstanceOf[String]
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(cssPropertyValueData.NAME)
                stringBuffer.append(commonSeps.BRACKET_OPEN)
                stringBuffer.appendint(index)
                stringBuffer.append(commonSeps.BRACKET_CLOSE)
                hashMap.put(stringBuffer.toString(), value)
                index += 1
                index += 1
            }
        }
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
            this.logUtil.putF("CssPropertyValues HashMap: " + hashMap.toString(), this, "toXmlNode()")
        }
        return ModDomHelper.createNameValueIndexNodes(document, CssPropertyData.getInstance().VALUES, CssPropertyValueData.getInstance().NAME, this.propertyValueVector)
    }

}


