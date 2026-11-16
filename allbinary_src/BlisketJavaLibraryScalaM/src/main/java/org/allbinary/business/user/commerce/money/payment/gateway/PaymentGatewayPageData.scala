/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author user  */
class PaymentGatewayPageData(param_location : String, param_paymentMethod : String) {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPageData.{FORWARDMAKEPAYMENT as _, PAYMENTOPTIONS as _, STARTCHECKOUT as _, *}
    def FORWARDMAKEPAYMENT : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPageData.FORWARDMAKEPAYMENT
    def PAYMENTOPTIONS : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPageData.PAYMENTOPTIONS
    def STARTCHECKOUT : String = _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPageData.STARTCHECKOUT

    var MAKEPAYMENT : String = null

    var CHECKOUT : String = null

    var SHIPPING : String = null

    //String FORWARDSHIPPINGADDRESSPAGE = paymentMethod + SHIPPINGADDRESSPAGENAME;
    var SHIPPINGADDRESS : String = null

    var SHIPPINGADDRESSACTION : String = null

    var BILLINGADDRESS : String = null

    var PAYMENT : String = null

    var AUTHORIZE : String = null

    var FINISH : String = null

    //Constructor
    {
        val location : String = param_location
        val paymentMethod : String = param_paymentMethod
        val paymentMethodString : String = PaymentGatewayPageData.NAME + paymentMethod
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(location)
        stringBuffer.append("MakePayment")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        MAKEPAYMENT = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("Checkout")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        CHECKOUT = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("Shipping")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        SHIPPING = stringBuffer.toString()
        //String FORWARDSHIPPINGADDRESSPAGE = paymentMethod + SHIPPINGADDRESSPAGENAME;
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("ShippingAddress")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        SHIPPINGADDRESS = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("ShippingAddressAction")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        SHIPPINGADDRESSACTION = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("BillingAddress")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        BILLINGADDRESS = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("Payment")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        PAYMENT = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("Authorize")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        AUTHORIZE = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(paymentMethodString)
        stringBuffer.append("PaymentFinish")
        stringBuffer.append(PaymentGatewayPageData.EXTENSION)
        FINISH = stringBuffer.toString()
    }

}

object PaymentGatewayPageData {
    private val EXTENSION : String = ".jsp"

    //private final static String NAME = "PaymentGateway";
    private val NAME : String = StringUtil.getInstance().EMPTY_STRING

    //Payment pages automatically added for each possible payment processor
    val FORWARDMAKEPAYMENT : String = "MakePayment.jsp"

    val PAYMENTOPTIONS : String = "PaymentOptions" + PaymentGatewayPageData.EXTENSION

    val STARTCHECKOUT : String = "StartCheckout" + PaymentGatewayPageData.EXTENSION

}


