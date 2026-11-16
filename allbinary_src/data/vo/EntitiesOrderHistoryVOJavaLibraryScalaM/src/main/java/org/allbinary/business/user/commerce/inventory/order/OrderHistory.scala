/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.java.util.Date
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.BillingAddressData
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.business.user.commerce.money.payment.Payment
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class OrderHistory private (super_1 : String, super_2 : BasketInterface, super_3 : String, super_4 : String, super_5 : String, super_6 : String, constructor_ : Unit) extends Order(super_1, super_2, super_3, super_4, super_5, super_6) with OrderHistoryInterface {

    private var userName : String = null

    private var shippingAddress : StreetAddress = null

    private var billingAddress : StreetAddress = null

    private var payment : Payment = null

    private var shipDate : String = null

    private var orderDate : String = null

    private var transDate : String = null

    private var cancelDate : String = null

    private var status : String = null

    private var subTotal : Money = null

    private var shippingCost : Money = null

    private var taxes : Money = null

    private var total : Money = null

    def this(basketInterface : BasketInterface, orderHistory : OrderHistory) = {
        this(orderHistory.getStoreName(), basketInterface, orderHistory.getId(), orderHistory.getShippingMethod(), orderHistory.getSpecial(), orderHistory.getPaymentMethod(), ())
        this.userName = orderHistory.getUserName()
        this.shippingAddress = orderHistory.getShippingAddress()
        this.billingAddress = orderHistory.getBillingAddress()
        this.payment = orderHistory.getPaymentInfo()
        this.shipDate = orderHistory.getShipDate()
        this.orderDate = orderHistory.getOrderDate()
        this.transDate = orderHistory.getTransDate()
        this.cancelDate = orderHistory.getCancelDate()
        this.status = orderHistory.getStatus()
        this.subTotal = orderHistory.getSubTotal()
        this.shippingCost = orderHistory.getShippingCost()
        this.taxes = orderHistory.getTaxes()
        this.total = orderHistory.getTotal()
        super.setUserComments(orderHistory.getUserComments().asInstanceOf[String])
        super.setUserCancelComments(orderHistory.getUserCancelComments().asInstanceOf[String])
        super.setStoreComments(orderHistory.getStoreComments().asInstanceOf[String])
        super.setStoreCancelComments(orderHistory.getStoreCancelComments().asInstanceOf[String])
    }

    def this(basketInterface : BasketInterface, orderHistoryHashMap : HashMap[Object, Object]) = {
        this(orderHistoryHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String], basketInterface, orderHistoryHashMap.get(OrderData.ID).asInstanceOf[String], orderHistoryHashMap.get(ShippingMethodData.NAME).asInstanceOf[String], orderHistoryHashMap.get(EntryData.getInstance().SPECIAL).asInstanceOf[String], orderHistoryHashMap.get(PaymentData.METHOD).asInstanceOf[String], ())
        this.shippingAddress = new StreetAddress(orderHistoryHashMap.get(ShippingAddressData.NAME).asInstanceOf[String], orderHistoryHashMap.get(ShippingAddressData.STREET).asInstanceOf[String], orderHistoryHashMap.get(ShippingAddressData.CITY).asInstanceOf[String], orderHistoryHashMap.get(ShippingAddressData.STATE).asInstanceOf[String], orderHistoryHashMap.get(ShippingAddressData.CODE).asInstanceOf[String], orderHistoryHashMap.get(ShippingAddressData.COUNTRY).asInstanceOf[String])
        this.billingAddress = new StreetAddress(orderHistoryHashMap.get(BillingAddressData.NAME).asInstanceOf[String], orderHistoryHashMap.get(BillingAddressData.STREET).asInstanceOf[String], orderHistoryHashMap.get(BillingAddressData.CITY).asInstanceOf[String], orderHistoryHashMap.get(BillingAddressData.STATE).asInstanceOf[String], orderHistoryHashMap.get(BillingAddressData.CODE).asInstanceOf[String], orderHistoryHashMap.get(BillingAddressData.COUNTRY).asInstanceOf[String])
        this.payment = new Payment(orderHistoryHashMap)
        this.userName = orderHistoryHashMap.get(UserData.USERNAME).asInstanceOf[String]
        this.orderDate = orderHistoryHashMap.get(OrderHistoryData.ORDERDATE).asInstanceOf[String]
        this.shipDate = orderHistoryHashMap.get(OrderHistoryData.SHIPPEDDATE).asInstanceOf[String]
        this.transDate = orderHistoryHashMap.get(OrderHistoryData.TRANSDATE).asInstanceOf[String]
        this.cancelDate = orderHistoryHashMap.get(OrderHistoryData.CANCELDATE).asInstanceOf[String]
        this.status = orderHistoryHashMap.get(OrderHistoryData.STATUS).asInstanceOf[String]
        this.subTotal = new Money(orderHistoryHashMap.get(OrderHistoryData.SUBTOTAL).asInstanceOf[String])
        this.total = new Money(orderHistoryHashMap.get(OrderHistoryData.TOTAL).asInstanceOf[String])
        this.shippingCost = new Money(orderHistoryHashMap.get(OrderHistoryData.SHIPPINGCOST).asInstanceOf[String])
        this.taxes = new Money(orderHistoryHashMap.get(OrderHistoryData.TAX).asInstanceOf[String])
        super.setUserComments(orderHistoryHashMap.get(OrderData.CUSTOMERCOMMENT).asInstanceOf[String])
        super.setUserCancelComments(orderHistoryHashMap.get(OrderData.CUSTOMERCANCELCOMMENT).asInstanceOf[String])
        super.setStoreComments(orderHistoryHashMap.get(OrderData.STORECOMMENT).asInstanceOf[String])
        super.setStoreCancelComments(orderHistoryHashMap.get(OrderData.STORECANCELCOMMENT).asInstanceOf[String])
    }

    def this(basketInterface : BasketInterface) = {
        this(basketInterface, null, null, null, null, null, ())
    }

    def setUserName(value : String) : Unit = {
        this.userName = value
    }

    def setDefaultShippingAddress(shippingAddress : StreetAddress) : Unit = {
        this.shippingAddress = shippingAddress
    }

    def setBillingAddress(billingAddress : StreetAddress) : Unit = {
        this.billingAddress = billingAddress
    }

    def setPaymentInfo(payment : Payment) : Unit = {
        this.payment = payment
    }

    def setShipDate(value : String) : Unit = {
        this.shipDate = value
    }

    def setOrderDate(value : String) : Unit = {
        this.orderDate = value
    }

    def setTransDate(value : String) : Unit = {
        this.transDate = value
    }

    def setCancelDate(value : String) : Unit = {
        this.cancelDate = value
    }

    def setStatus(value : String) : Unit = {
        this.status = value
    }

    def setSubTotal(value : Money) : Unit = {
        this.subTotal = value
    }

    def setShippingCost(value : Money) : Unit = {
        this.shippingCost = value
    }

    def setTaxes(value : Money) : Unit = {
        this.taxes = value
    }

    def setTotal(value : Money) : Unit = {
        this.total = value
    }

    def getUserName() : String = {
        return this.userName
    }

    def getShippingAddress() : StreetAddress = {
        return this.shippingAddress
    }

    def getBillingAddress() : StreetAddress = {
        return this.billingAddress
    }

    def getPaymentInfo() : Payment = {
        return this.payment
    }

    def getShipDate() : String = {
        return this.shipDate
    }

    def getOrderDate() : String = {
        return this.orderDate
    }

    def getTransDate() : String = {
        return this.transDate
    }

    def getCancelDate() : String = {
        return this.cancelDate
    }

    def getStatus() : String = {
        return this.status
    }

    def getSubTotal() : Money = {
        return this.subTotal
    }

    def getShippingCost() : Money = {
        return this.shippingCost
    }

    def getTaxes() : Money = {
        return this.taxes
    }

    def getTotal() : Money = {
        return this.total
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(UserData.USERNAME, this.userName)
        hashMap.put(OrderHistoryData.ORDERDATE, this.orderDate)
        hashMap.put(OrderHistoryData.SHIPPEDDATE, this.shipDate)
        hashMap.put(OrderHistoryData.TRANSDATE, this.transDate)
        hashMap.put(OrderHistoryData.CANCELDATE, this.cancelDate)
        //Long.parseLong(
        hashMap.put(OrderHistoryData.ORDERDATEFORMATTED, new Date(new _root_.java.lang.Long(this.orderDate).longValue()).toString())
        hashMap.put(OrderHistoryData.SHIPPEDDATEFORMATTED, new Date(new _root_.java.lang.Long(this.shipDate).longValue()).toString())
        hashMap.put(OrderHistoryData.TRANSDATEFORMATTED, new Date(new _root_.java.lang.Long(this.transDate).longValue()).toString())
        hashMap.put(OrderHistoryData.CANCELDATEFORMATTED, new Date(new _root_.java.lang.Long(this.cancelDate).longValue()).toString())
        hashMap.put(OrderHistoryData.STATUS, this.status)
        hashMap.put(OrderHistoryData.SUBTOTAL, this.subTotal.toString())
        hashMap.put(OrderHistoryData.TOTAL, this.total.toString())
        hashMap.put(OrderHistoryData.SHIPPINGCOST, this.shippingCost.toString())
        hashMap.put(OrderHistoryData.TAX, this.taxes.toString())
        return hashMap
    }

    /*    public BasicArrayList toVector()    {       return new BasicArrayListD();    }    */
    override def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keySet.toArray()
        var size : Int = keyArray.length
        var node : Node = document.createElement(OrderHistoryData.ORDERHISTORY)
        node.appendChild(super.toXmlNode(document))
        var billingAddressNode : Node = document.createElement(BillingAddressData.BILLINGADDRESS)
        billingAddressNode.appendChild(this.billingAddress.toXmlNode(document))
        var shippingAddressNode : Node = document.createElement(ShippingAddressData.SHIPPINGADDRESS)
        shippingAddressNode.appendChild(this.shippingAddress.toXmlNode(document))
        node.appendChild(billingAddressNode)
        node.appendChild(shippingAddressNode)
        node.appendChild(this.payment.toXmlNode(document))

        {
            var i : Int = 0
            while (i < size) {
                var name : String = keyArray(i).asInstanceOf[String]
                var value : String = hashMap.get(name).asInstanceOf[String]
                value = StringUtil.getInstance().getNonNull(value)
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                i += 1
            }
        }
        return node
    }

    //Needed for polyglot do not remove
    override def getPaymentMethod() : String = {
        return super.getPaymentMethod()
    }

}


