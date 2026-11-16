/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.address.StreetAddressData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.logic.string.StringUtil

class Item private (super_1 : HashMap[Object, Object], constructor_ : Unit) extends BasicItem(super_1) with OrderItemInterface {

    private var group : String = null

    private var tax : String = null

    private var shippingType : String = null

    private var shippingCost : String = null

    private var shippedDate : String = null

    private var shippingAddress : StreetAddress = null

    private var special : String = null

    def this(itemHashMap : HashMap[Object, Object]) = {
        this(itemHashMap, ())
        this.setData(itemHashMap)
    }

    def this() = {
        this(null, ())
        val EMPTY : String = StringUtil.getInstance().EMPTY_STRING
        this.group = EMPTY
        this.tax = EMPTY
        this.shippingType = EMPTY
        this.shippingCost = EMPTY
        this.shippingAddress = new StreetAddress()
    }

    private def setData(itemHashMap : HashMap[Object, Object]) : Unit = {
        this.group = itemHashMap.get(ShippingMethodData.GROUP).asInstanceOf[String]
        this.tax = itemHashMap.get(OrderHistoryData.TAX).asInstanceOf[String]
        this.shippingType = itemHashMap.get(ShippingMethodData.NAME).asInstanceOf[String]
        this.shippingCost = itemHashMap.get(ShippingMethodData.COST).asInstanceOf[String]
        this.shippedDate = itemHashMap.get(OrderHistoryData.SHIPPEDDATE).asInstanceOf[String]
        itemHashMap.put(StreetAddressData.NAME, itemHashMap.get(ShippingAddressData.NAME))
        itemHashMap.put(StreetAddressData.STREET, itemHashMap.get(ShippingAddressData.STREET))
        itemHashMap.put(StreetAddressData.CITY, itemHashMap.get(ShippingAddressData.CITY))
        itemHashMap.put(StreetAddressData.STATE, itemHashMap.get(ShippingAddressData.STATE))
        itemHashMap.put(StreetAddressData.CODE, itemHashMap.get(ShippingAddressData.CODE))
        itemHashMap.put(StreetAddressData.COUNTRY, itemHashMap.get(ShippingAddressData.COUNTRY))
        this.shippingAddress = new StreetAddress(itemHashMap)
    }

    def setGroup(value : String) : Unit = {
        this.group = value
    }

    def setTax(value : String) : Unit = {
        this.tax = value
    }

    def setShippingType(value : String) : Unit = {
        this.shippingType = value
    }

    def setShippingCost(value : String) : Unit = {
        this.shippingCost = value
    }

    def setShippingAddress(value : StreetAddress) : Unit = {
        this.shippingAddress = value
    }

    def setSpecial(value : String) : Unit = {
        this.special = value
    }

    def getGroup() : String = {
        return this.group
    }

    def getTax() : String = {
        return this.tax
    }

    def getShippingType() : String = {
        return this.shippingType
    }

    def getShippingCost() : String = {
        return this.shippingCost
    }

    def getShippingAddress() : StreetAddress = {
        return this.shippingAddress
    }

    def getSpecial() : String = {
        return this.special
    }

    override def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = super.toHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(ShippingMethodData.GROUP, this.group)
        hashMap.put(OrderHistoryData.TAX, this.tax)
        hashMap.put(ShippingMethodData.NAME, this.shippingType)
        hashMap.put(ShippingMethodData.COST, this.shippingCost)
        hashMap.put(OrderHistoryData.SHIPPEDDATE, this.shippedDate)
        hashMap.put(EntryData.getInstance().SPECIAL, this.special)
        return hashMap
    }

}


