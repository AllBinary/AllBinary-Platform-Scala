/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CssProperty private () extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var propertyName : String = null

    private var cssPropertyValues : CssPropertyValues = null

    def this(name : String) = {
        this()
        this.propertyName = name
        this.cssPropertyValues = new CssPropertyValues()
    }

    /*     *<CSS_PROPERTY_NAME>     *   <name>CSS_PROPERTY_NAME</name>     *   <value>propertyName</value>     *   <CSS_PROPERTY_VALUES_NAME>     *      <CSS_PROPERTY_VALUE_NAME>value</CSS_PROPERTY_VALUE_NAME>     *   <CSS_PROPERTY_VALUES_NAME>     *</CSS_PROPERTY_NAME>     *CssPropertyData.NAME     */
    def this(node : Node) = {
        this()
        var propertyNode : Node = DomSearchHelper.getNode(DomData.VALUE, node.getChildNodes())
        this.propertyName = DomNodeHelper.getTextNodeValue(propertyNode)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().STYLE)) {
            this.logUtil.putF("Name: " + this.getName(), this, "CssProperty()")
        }
        var propertyValuesNode : Node = DomSearchHelper.getNode(CssPropertyData.getInstance().VALUES, node.getChildNodes())
        this.cssPropertyValues = new CssPropertyValues(propertyValuesNode)
    }

    /*    public CssProperty(HashMap hashMap)    {       this.propertyName = (String) hashMap.get(CssPropertyData.NAME);        if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().STYLE))       {          this.logUtil.putF("Name: " + this.getName(),this,"CssProperty()");       }        HashMap propertyValuesHashMap =           (HashMap) hashMap.get(CssPropertyData.VALUES);              this.cssPropertyValues = new CssPropertyValues(propertyValuesHashMap);    } */
    def getName() : String = {
        return this.propertyName
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(CssPropertyData.getInstance().NAME, this.propertyName)
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("CssView HashMap: " + hashMap.toString(), this, "toXmlNode()")
        }
        var node : Node = ModDomHelper.createNameValueNodes(document, CssPropertyData.getInstance().NAME, this.propertyName)
        node.appendChild(this.cssPropertyValues.toXmlNode(document))
        return node
    }

}


