/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.transaction

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.address.StreetAddress
import _root_.org.allbinary.business.user.commerce.inventory.basket.Basket
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.business.user.commerce.money.payment.Payment
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.types.TenderTypeFactory
import _root_.org.allbinary.business.user.commerce.money.payment.types.TransactionTypeFactory
import _root_.org.allbinary.data.generator.OrderIdGenerator
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityInterface
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings

class PaymentTransactionInterfaceRequestFactory private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterfaceRequestFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def getInstance(transformInfoInterface : TransformInfoInterface) : PaymentTransactionInterface = {
        try {
            var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
            var pageContext : PageContext = httpTransformInfoInterface.getPageContext()
            var httpServletRequest : HttpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
            var command : String = httpServletRequest.getParameter(_root_.org.allbinary.globals.GLOBALS2.ADMINCOMMAND)
            //Only if testing a gateway with a form instead of using OrderHistory
            if ((command != null) && (command.compareTo(_root_.org.allbinary.globals.GLOBALS2.AUTHORIZEFORMEVALBODYONERROR) == 0)) {
                return this.generateFromTestData(transformInfoInterface)
            } else {
                var propertiesHashMap : HashMap[Object, Object] = httpTransformInfoInterface.getPropertiesHashMap().asInstanceOf[HashMap[Object, Object]]
                var weblisketSession : WeblisketSession = new WeblisketSession(propertiesHashMap, pageContext)
                var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(weblisketSession.getStoreName())
                var order : OrderInterface = weblisketSession.getOrder()
                var orderId : String = order.getId()
                var orderHistoryEntityInterface : OrderHistoryEntityInterface = OrderHistoryEntityFactory.getInstance()
                var orderReview : OrderHistory = orderHistoryEntityInterface.getOrder(orderId)
                var orderPaymentInfo : Payment = orderReview.getPaymentInfo()
                orderPaymentInfo.setTransactionType(TransactionTypeFactory.getInstance().SALE.toString())
                orderPaymentInfo.setTenderType(TenderTypeFactory.getInstance().CREDITCARD.toString())
                orderReview.setPaymentInfo(orderPaymentInfo)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                    this.logUtil.putF(orderReview.getId(), this, "getPaymentTransactionInterface()")
                }
                //this.paymentGatewayInterface = new PaymentGateway(hashMap);
                var paymentTransactionInterface : PaymentTransactionInterface = PaymentTransactionInterfaceFactory.getInstance().getInstance(orderReview)
                return paymentTransactionInterface
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "getPaymentTransactionInterface()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    private def generateFromTestData(transformInfoInterface : TransformInfoInterface) : PaymentTransactionInterface = {
        try {
            var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
            var propertiesHashMap : HashMap[Object, Object] = httpTransformInfoInterface.getPropertiesHashMap().asInstanceOf[HashMap[Object, Object]]
            var pageContext : PageContext = httpTransformInfoInterface.getPageContext()
            var weblisketSession : WeblisketSession = new WeblisketSession(propertiesHashMap, pageContext)
            var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(weblisketSession.getStoreName())
            var httpServletRequest : HttpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
            var gatewayName : String = weblisketSession.getPaymentMethod().asInstanceOf[String]
            if (StringValidationUtil.getInstance().isEmpty(gatewayName)) {
                gatewayName = httpServletRequest.getParameter(PaymentGatewayData.NAME.toString())
            }
            var transactionType : String = httpServletRequest.getParameter(PaymentData.TRANSACTIONTYPE)
            var tenderType : String = httpServletRequest.getParameter(PaymentData.TENDERTYPE)
            var payment : Payment = new Payment()
            payment.setTransactionType(transactionType)
            payment.setTenderType(tenderType)
            var orderReview : OrderHistory = new OrderHistory(new Basket())
            orderReview.setStoreName(storeFrontInterface.getName())
            orderReview.setPaymentMethod(gatewayName)
            orderReview.setUserName("testing")
            var orderId : String = httpServletRequest.getParameter("orderNumber")
            if ((orderId == null) || (orderId.compareTo(StringUtil.getInstance().EMPTY_STRING) == 0)) {
                orderId = new OrderIdGenerator().getNext()
                orderReview.setId(orderId)
                //payment information
                var account : String = httpServletRequest.getParameter("account")
                var expirationDate : String = httpServletRequest.getParameter("expirationDate")
                var checkNumber : String = httpServletRequest.getParameter("checkNumber")
                var driversLicense : String = httpServletRequest.getParameter("driversLicense")
                var magneticInkCheckReader : String = httpServletRequest.getParameter("magneticInkCheckReader")
                var aba : String = httpServletRequest.getParameter("aba")
                var accountType : String = httpServletRequest.getParameter("accountType")
                var name : String = httpServletRequest.getParameter("name")
                payment.setName(name)
                payment.setNumber(account)
                payment.setExpiration(expirationDate)
                payment.setCheckNumber(checkNumber)
                payment.setDriversLicense(driversLicense)
                payment.setMagneticInkCheckReader(magneticInkCheckReader)
                payment.setAba(aba)
                payment.setAccountType(accountType)
                //billing address info
                var street : String = httpServletRequest.getParameter("street")
                var city : String = httpServletRequest.getParameter("city")
                var state : String = httpServletRequest.getParameter("state")
                var zip : String = httpServletRequest.getParameter("zip")
                var streetAddress : StreetAddress = new StreetAddress()
                streetAddress.setName(name)
                streetAddress.setStreet(street)
                streetAddress.setCity(city)
                streetAddress.setState(state)
                streetAddress.setCode(zip)
                var email : String = httpServletRequest.getParameter("email")
                var amount : String = httpServletRequest.getParameter("amount")
                orderReview.setTotal(new Money(amount))
                orderReview.setBillingAddress(streetAddress)
            } else {
                orderReview.setId(orderId)
            }
            orderReview.setPaymentInfo(payment)
            var paymentTransactionInterface : PaymentTransactionInterface = PaymentTransactionInterfaceFactory.getInstance().getInstance(orderReview)
            return paymentTransactionInterface
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "generatePaymentTransactionInterfaceFromTestData()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object PaymentTransactionInterfaceRequestFactory {
    private val instance : PaymentTransactionInterfaceRequestFactory = new PaymentTransactionInterfaceRequestFactory()

    def getInstance() : PaymentTransactionInterfaceRequestFactory = {
        return PaymentTransactionInterfaceRequestFactory.instance
    }

}


