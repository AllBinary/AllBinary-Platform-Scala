/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ItemView(param_itemInterface : OrderItemInterface, param_vector : BasicArrayList) {

    private var itemInterface : OrderItemInterface = null

    private var vector : BasicArrayList = null

    //Constructor
    {
        val itemInterface : OrderItemInterface = param_itemInterface
        val vector : BasicArrayList = param_vector
        this.itemInterface = itemInterface
        this.vector = vector
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.itemInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var node : Node = document.createElement(ItemData.ITEM)
        var basicItemView : BasicItemView = new BasicItemView(this.itemInterface, this.vector)
        node.appendChild(basicItemView.toXmlNode(document))
        val stringUtil : StringUtil = StringUtil.getInstance()
        val nameArray : Array[Object] = keySet.toArray()
        val size : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var name : String = nameArray(index).asInstanceOf[String]
                var value : String = hashMap.get(name).asInstanceOf[String]
                value = stringUtil.getNonNull(value)
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                index += 1
            }
        }
        var shippingAddressNode : Node = document.createElement(StreetAddressData.NAME)
        shippingAddressNode.appendChild(this.itemInterface.getShippingAddress().toXmlNode(document))
        return node
    }

}


