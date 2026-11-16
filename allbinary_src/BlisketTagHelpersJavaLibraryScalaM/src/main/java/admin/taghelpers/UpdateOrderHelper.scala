/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.address.BillingAddressData
import _root_.org.allbinary.business.user.address.ShippingAddressData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class UpdateOrderHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    private var entryId : String = null

    private var orderId : String = null

    private var userName : String = null

    private var storeName : String = null

    private var shipDate : String = null

    private var orderDate : String = null

    private var transDate : String = null

    private var cancelDate : String = null

    private var status : String = null

    private var paymentMethod : String = null

    private var name : String = null

    private var `type` : String = null

    private var expiration : String = null

    private var number : String = null

    private var encryption : String = null

    private var billingName : String = null

    private var billingStreet : String = null

    private var billingCity : String = null

    private var billingState : String = null

    private var billingCode : String = null

    private var billingCountry : String = null

    private var shippingName : String = null

    private var shippingStreet : String = null

    private var shippingCity : String = null

    private var shippingState : String = null

    private var shippingCode : String = null

    private var shippingCountry : String = null

    private var shippingMethodName : String = null

    private var subTotal : String = null

    private var shippingCost : String = null

    private var tax : String = null

    private var total : String = null

    private var special : String = null

    private var userComment : String = null

    private var userCancelComment : String = null

    private var storeComment : String = null

    private var storeCancelComment : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.entryId = this.request.getParameter(EntryData.getInstance().ID)
        this.orderId = this.request.getParameter(OrderData.ID)
        this.userName = this.request.getParameter(UserData.USERNAME)
        this.storeName = this.request.getParameter(StoreFrontData.getInstance().NAME)
        this.shipDate = this.request.getParameter(OrderHistoryData.SHIPPEDDATE)
        this.orderDate = this.request.getParameter(OrderHistoryData.ORDERDATE)
        this.transDate = this.request.getParameter(OrderHistoryData.TRANSDATE)
        this.cancelDate = this.request.getParameter(OrderHistoryData.CANCELDATE)
        this.status = this.request.getParameter(OrderHistoryData.STATUS)
        this.paymentMethod = this.request.getParameter(PaymentData.METHOD)
        this.name = this.request.getParameter(PaymentData.NAME)
        this.`type` = this.request.getParameter(PaymentData.TYPE)
        this.expiration = this.request.getParameter(PaymentData.EXPIRATION)
        this.number = this.request.getParameter(PaymentData.NUMBER)
        this.encryption = this.request.getParameter(EntryData.getInstance().ENCRYPTION)
        this.billingName = this.request.getParameter(BillingAddressData.NAME)
        this.billingStreet = this.request.getParameter(BillingAddressData.STREET)
        this.billingCity = this.request.getParameter(BillingAddressData.CITY)
        this.billingState = this.request.getParameter(BillingAddressData.STATE)
        this.billingCode = this.request.getParameter(BillingAddressData.CODE)
        this.billingCountry = this.request.getParameter(BillingAddressData.COUNTRY)
        this.shippingName = this.request.getParameter(ShippingAddressData.NAME)
        this.shippingStreet = this.request.getParameter(ShippingAddressData.STREET)
        this.shippingCity = this.request.getParameter(ShippingAddressData.CITY)
        this.shippingState = this.request.getParameter(ShippingAddressData.STATE)
        this.shippingCode = this.request.getParameter(ShippingAddressData.CODE)
        this.shippingCountry = this.request.getParameter(ShippingAddressData.COUNTRY)
        this.shippingMethodName = this.request.getParameter(ShippingMethodData.NAME)
        this.subTotal = this.request.getParameter(OrderHistoryData.SUBTOTAL)
        this.shippingCost = this.request.getParameter(OrderHistoryData.SHIPPINGCOST)
        this.tax = this.request.getParameter(OrderHistoryData.TAX)
        this.total = this.request.getParameter(OrderHistoryData.TOTAL)
        this.special = this.request.getParameter(EntryData.getInstance().SPECIAL)
        this.userComment = this.request.getParameter(OrderData.CUSTOMERCOMMENT)
        this.userCancelComment = this.request.getParameter(OrderData.CUSTOMERCANCELCOMMENT)
        this.storeComment = this.request.getParameter(OrderData.STORECOMMENT)
        this.storeCancelComment = this.request.getParameter(OrderData.STORECANCELCOMMENT)
    }

    def update() : String = {
        try {
            var success : String = "Successful update"
            var orderHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            var whereHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            orderHashMap.put(EntryData.getInstance().ID, this.entryId)
            orderHashMap.put(OrderData.ID, this.orderId)
            orderHashMap.put(UserData.USERNAME, userName)
            orderHashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
            orderHashMap.put(OrderHistoryData.SHIPPEDDATE, shipDate)
            orderHashMap.put(OrderHistoryData.ORDERDATE, orderDate)
            orderHashMap.put(OrderHistoryData.TRANSDATE, transDate)
            orderHashMap.put(OrderHistoryData.CANCELDATE, cancelDate)
            orderHashMap.put(OrderHistoryData.STATUS, status)
            orderHashMap.put(PaymentData.METHOD, paymentMethod)
            orderHashMap.put(PaymentData.NAME, name)
            orderHashMap.put(PaymentData.TYPE, `type`)
            orderHashMap.put(PaymentData.EXPIRATION, expiration)
            //orderHashMap.put(EntryData.getInstance().ENCRYPTION,encryption);
            orderHashMap.put(BillingAddressData.NAME, billingName)
            orderHashMap.put(BillingAddressData.STREET, billingStreet)
            orderHashMap.put(BillingAddressData.CITY, billingCity)
            orderHashMap.put(BillingAddressData.STATE, billingState)
            orderHashMap.put(BillingAddressData.CODE, billingCode)
            orderHashMap.put(BillingAddressData.COUNTRY, billingCountry)
            orderHashMap.put(ShippingAddressData.NAME, shippingName)
            orderHashMap.put(ShippingAddressData.STREET, shippingStreet)
            orderHashMap.put(ShippingAddressData.CITY, shippingCity)
            orderHashMap.put(ShippingAddressData.STATE, shippingState)
            orderHashMap.put(ShippingAddressData.CODE, shippingCode)
            orderHashMap.put(ShippingAddressData.COUNTRY, shippingCountry)
            orderHashMap.put(ShippingMethodData.NAME, this.shippingMethodName)
            orderHashMap.put(OrderHistoryData.SUBTOTAL, this.subTotal)
            orderHashMap.put(OrderHistoryData.SHIPPINGCOST, this.shippingCost)
            orderHashMap.put(OrderHistoryData.TAX, this.tax)
            orderHashMap.put(OrderHistoryData.TOTAL, this.total)
            orderHashMap.put(EntryData.getInstance().SPECIAL, this.special)
            orderHashMap.put(OrderData.CUSTOMERCOMMENT, this.userComment)
            orderHashMap.put(OrderData.CUSTOMERCANCELCOMMENT, this.userCancelComment)
            orderHashMap.put(OrderData.STORECOMMENT, this.storeComment)
            orderHashMap.put(OrderData.STORECANCELCOMMENT, this.storeCancelComment)
            whereHashMap.put(OrderData.ID, orderId)
            OrderHistoryEntityFactory.getInstance().update(whereHashMap, orderHashMap)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update order table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


