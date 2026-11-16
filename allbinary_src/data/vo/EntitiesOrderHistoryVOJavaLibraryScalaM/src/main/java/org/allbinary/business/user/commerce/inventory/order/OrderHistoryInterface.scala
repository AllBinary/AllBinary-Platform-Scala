/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.payment.Payment

trait OrderHistoryInterface {

    def setUserName(value : String) : Unit

    def setDefaultShippingAddress(shippingAddress : StreetAddress) : Unit

    def setBillingAddress(billingAddress : StreetAddress) : Unit

    def setPaymentInfo(payment : Payment) : Unit

    def setShipDate(value : String) : Unit

    def setOrderDate(value : String) : Unit

    def setTransDate(value : String) : Unit

    def setCancelDate(value : String) : Unit

    def setStatus(value : String) : Unit

    def setSubTotal(value : Money) : Unit

    def setShippingCost(value : Money) : Unit

    def setTaxes(value : Money) : Unit

    def setTotal(value : Money) : Unit

    def getUserName() : String

    def getShippingAddress() : StreetAddress

    def getBillingAddress() : StreetAddress

    def getPaymentInfo() : Payment

    def getShipDate() : String

    def getOrderDate() : String

    def getTransDate() : String

    def getCancelDate() : String

    def getStatus() : String

    def getSubTotal() : Money

    def getShippingCost() : Money

    def getTaxes() : Money

    def getTotal() : Money

    def getPaymentMethod() : String

}


