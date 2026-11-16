/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PaymentGatewayInterfaceFactory() extends PaymentGatewayInterfaceFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(httpServletRequest : HttpServletRequest) : PaymentGatewayInterface = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                this.logUtil.putF("Getting", this, commonStrings.GET_INSTANCE)
            }
            return this.getInstance(new RequestParams(httpServletRequest).toHashMap())
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(HttpServletRequest)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def getInstance(paymentType : BasicPaymentType) : PaymentGatewayInterface = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(PaymentGatewayData.NAME.toString(), paymentType.getName())
        return this.getInstance(hashMap)
    }

    def getInstance(hashMap : HashMap[Object, Object]) : PaymentGatewayInterface = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            var gatewayName : String = hashMap.get(PaymentGatewayData.NAME.toString()).asInstanceOf[String]
            var paymentType : BasicPaymentType = BasicPaymentTypeUtil.getInstance().get(gatewayName)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENT)) {
                this.logUtil.putF((("Getting PaymentGatewayInterface for PaymentType: " + paymentType.getName()) + " with: ") + hashMap, this, commonStrings.GET_INSTANCE)
            }
            var paymentGatewayInterfaceFactoryInterface : PaymentGatewayInterfaceFactoryInterface = paymentType.getPaymentGatewayInterfaceFactoryInterface()
            return paymentGatewayInterfaceFactoryInterface.getInstance(hashMap)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


