/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment

import _root_.javax.servlet.ServletRequest
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

//import org.allbinary.business.user.commerce.money.payment.*;
class PaymentFactory private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.PaymentFactory.{*}

}

object PaymentFactory {
    def getInstance(request : ServletRequest) : PaymentInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            return (new _root_.org.allbinary.business.user.commerce.money.payment.Payment(request)).asInstanceOf[PaymentInterface]
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    logUtil.put(commonStrings.EXCEPTION, "PaymentFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


