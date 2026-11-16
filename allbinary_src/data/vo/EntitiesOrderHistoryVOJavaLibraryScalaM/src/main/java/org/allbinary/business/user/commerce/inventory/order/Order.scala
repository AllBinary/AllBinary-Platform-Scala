/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.java.io.Serializable
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class Order private () extends OrderInterface with Serializable {

    private var basket : BasketInterface = null

    private var paymentMethod : String = null

    private var shippingType : String = null

    private var storeName : String = null

    private var special : String = null

    private var id : String = null

    private var userComment : String = null

    private var userCancelComment : String = null

    private var storeComment : String = null

    private var storeCancelComment : String = null

    def this(storeName : String, basket : BasketInterface, id : String, shippingType : String, special : String, paymentMethod : String) = {
        this()
        this.storeName = storeName
        this.basket = basket
        this.id = id
        this.shippingType = shippingType
        this.special = special
        this.paymentMethod = paymentMethod
    }

    def this(basket : BasketInterface) = {
        this()
        this.basket = basket
        this.id = null
        this.shippingType = StringUtil.getInstance().EMPTY_STRING
    }

    /*    public OrderInterface getOrder(OrderReview orderReview)    {       return null;    }    */
    def isIdValid() : _root_.java.lang.Boolean = {
        if ((((this.getId() == null) || (this.getId().compareTo(StringUtil.getInstance().EMPTY_STRING) == 0)) || (this.getId().length() > OrderHistoryData.MAXIDLEN)) || !StringValidationUtil.getInstance().isNumber(this.getId())) {
            return _root_.java.lang.Boolean.FALSE
        }
        return _root_.java.lang.Boolean.TRUE
    }

    def isValid() : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.TRUE
    }

    def getIdValidationInfo() : String = {
        val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING
        if ((((this.getId() == null) || (this.getId().compareTo(EMPTY_STRING) == 0)) || (this.getId().length() > OrderHistoryData.MAXIDLEN)) || !StringValidationUtil.getInstance().isNumber(this.getId())) {
            return ("Please enter a valid order Id < " + OrderHistoryData.MAXIDLEN) + " digits in length.<br>"
        }
        return EMPTY_STRING
    }

    /*    public void setBasket(BasketInterface basket)    {       this.basket = basket;    }    */
    def setShippingMethod(shippingType : String) : Unit = {
        this.shippingType = shippingType
    }

    def setPaymentMethod(value : String) : Unit = {
        this.paymentMethod = value
    }

    def setSpecial(special : String) : Unit = {
        this.special = special
    }

    def setId(value : String) : Unit = {
        this.id = value
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    def setUserComments(value : String) : Unit = {
        this.userComment = value
    }

    def setUserCancelComments(value : String) : Unit = {
        this.userCancelComment = value
    }

    def setStoreComments(value : String) : Unit = {
        this.storeComment = value
    }

    def setStoreCancelComments(value : String) : Unit = {
        this.storeCancelComment = value
    }

    def getBasket() : BasketInterface = {
        return this.basket
    }

    def getShippingMethod() : String = {
        return this.shippingType
    }

    def getPaymentMethod() : String = {
        return this.paymentMethod
    }

    def getSpecial() : String = {
        return this.special
    }

    def getId() : String = {
        return this.id
    }

    def getStoreName() : String = {
        return this.storeName
    }

    def getUserComments() : String = {
        return this.userComment
    }

    def getUserCancelComments() : String = {
        return this.userCancelComment
    }

    def getStoreComments() : String = {
        return this.storeComment
    }

    def getStoreCancelComments() : String = {
        return this.storeCancelComment
    }

    def reviewOrder(paymentMethod : String) : String = {
        return "Create your own Order.reviewOrder"
    }

    def viewOrder(paymentMethod : String) : String = {
        return "Create your own Order.viewOrder"
    }

    def emailOrder(userName : String, paymentMethod : String, storeFrontInterface : StoreFrontInterface) : String = {
        return "Create your own Order.emailOrder"
    }

    def toHashMapOrder() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(PaymentData.METHOD, this.paymentMethod)
        hashMap.put(ShippingMethodData.NAME, this.shippingType)
        hashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
        hashMap.put(EntryData.getInstance().SPECIAL, this.special)
        hashMap.put(OrderData.ID, this.id)
        hashMap.put(OrderData.CUSTOMERCOMMENT, this.userComment)
        hashMap.put(OrderData.CUSTOMERCANCELCOMMENT, this.userCancelComment)
        hashMap.put(OrderData.STORECOMMENT, this.storeComment)
        hashMap.put(OrderData.STORECANCELCOMMENT, this.storeCancelComment)
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.toHashMapOrder().asInstanceOf[HashMap[Object, Object]]
        var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keySet.toArray()
        var size : Int = keyArray.length
        var node : Node = document.createElement(OrderData.ORDER)

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

}


