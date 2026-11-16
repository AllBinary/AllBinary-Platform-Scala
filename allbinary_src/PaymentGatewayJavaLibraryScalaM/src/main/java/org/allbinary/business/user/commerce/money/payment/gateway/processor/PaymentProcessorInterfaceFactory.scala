/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway.processor

import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.transaction.PaymentTransactionInterfaceRequestFactory
import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentTypeUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings

class PaymentProcessorInterfaceFactory private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.gateway.processor.PaymentProcessorInterfaceFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(transformInfoInterface : TransformInfoInterface) : PaymentProcessorInterface = this.synchronized {
        try {
            var paymentTransactionInterface : PaymentTransactionInterface = PaymentTransactionInterfaceRequestFactory.getInstance().getInstance(transformInfoInterface)
            //PageContext pageContext = transformInfoInterface.getPageContext();
            var gatewayName : String = paymentTransactionInterface.getOrderHistory().getPaymentMethod()
            if (!StringValidationUtil.getInstance().isEmpty(gatewayName)) {
                //storeTransformInfoInterface
                var paymentType : PaymentType = PaymentTypeUtil.getInstance().get(gatewayName)
                var paymentProcessorInterfaceFactoryInterface : PaymentProcessorInterfaceFactoryInterface = paymentType.getPaymentProcessorInterfaceFactoryInterface()
                return paymentProcessorInterfaceFactoryInterface.getInstance(transformInfoInterface, paymentTransactionInterface).asInstanceOf[PaymentProcessorInterface]
            }
            throw new Exception("Error Getting PaymentProcessorInterface")
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().PAYMENTERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object PaymentProcessorInterfaceFactory {
    private val instance : PaymentProcessorInterfaceFactory = new PaymentProcessorInterfaceFactory()

    def getInstance() : PaymentProcessorInterfaceFactory = {
        return PaymentProcessorInterfaceFactory.instance
    }

}


