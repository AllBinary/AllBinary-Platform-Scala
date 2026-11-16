/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.transaction

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentTypeUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PaymentTransactionInterfaceFactory private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterfaceFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(orderReview : OrderHistory) : PaymentTransactionInterface = {
        try {
            var gatewayName : String = orderReview.getPaymentMethod()
            //should move to payment class .getGatewayName();
            if (gatewayName != null) {
                var paymentType : PaymentType = PaymentTypeUtil.getInstance().get(gatewayName)
                var paymentTransactionInterfaceFactoryInterface : PaymentTransactionInterfaceFactoryInterface = paymentType.getPaymentTransactionInterfaceFactoryInterface()
                var paymentTransactionInterface : PaymentTransactionInterface = paymentTransactionInterfaceFactoryInterface.getInstance(orderReview)
                return paymentTransactionInterface
            }
            throw new Exception(("Failed to create PaymentTransactionInterface: " + "GatewayName is: ") + gatewayName)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put("Failed to generate test data", this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object PaymentTransactionInterfaceFactory {
    private val instance : PaymentTransactionInterfaceFactory = new PaymentTransactionInterfaceFactory()

    def getInstance() : PaymentTransactionInterfaceFactory = {
        return PaymentTransactionInterfaceFactory.instance
    }

}


