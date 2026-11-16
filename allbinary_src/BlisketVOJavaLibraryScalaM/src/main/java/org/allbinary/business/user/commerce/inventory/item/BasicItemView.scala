/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicItemView(param_itemInterface : ItemInterface, param_vector : BasicArrayList) extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val basicItemData : BasicItemData = BasicItemData.getInstance()

    private var itemInterface : ItemInterface = null

    private var vector : BasicArrayList = null

    //Constructor
    {
        val itemInterface : ItemInterface = param_itemInterface
        val vector : BasicArrayList = param_vector
        this.itemInterface = itemInterface
        this.vector = vector
    }

    def toXmlNode(document : Document) : Node = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PRODUCTSEARCHLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, "toXmlNode")
        }
        /*       try       {        */
        var hashMap : HashMap[Object, Object] = this.itemInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        hashMap.put(this.basicItemData.IMAGE, EMPTY_STRING)
        var stringUtil : StringUtil = StringUtil.getInstance()
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var node : Node = document.createElement(this.basicItemData.ITEM)
        val nameArray : Array[Object] = keySet.toArray()
        val size2 : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size2) {
                var name : String = nameArray(index).asInstanceOf[String]
                var value : String = hashMap.get(name).asInstanceOf[String]
                value = stringUtil.getNonNull(value)
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                index += 1
            }
        }
        var totalNode : Node = ModDomHelper.createNameValueNodes(document, this.basicItemData.TOTAL, this.itemInterface.getTotal().toString())
        node.appendChild(totalNode)
        val size : Int = this.vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var domNodeInterface : DomNodeInterface = this.vector.get(index).asInstanceOf[DomNodeInterface]
                var customNode : Node = domNodeInterface.toXmlNode(document)
                node.appendChild(customNode)
                index += 1
            }
        }
        return node
    }

    def toXmlDoc() : Document = {
        return null
    }

    def view() : String = {
        return null
    }

}


