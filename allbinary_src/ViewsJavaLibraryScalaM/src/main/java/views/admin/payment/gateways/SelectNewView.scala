/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateways

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.admin.payment.gateway.PaymentGatewayViewAbstract

class SelectNewView(param_transformInfoInterface : TransformInfoInterface) extends PaymentGatewayViewAbstract(param_transformInfoInterface) {

    val logUtil_SelectNewView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def view() : String = {
        try {
            var paymentGatewayEntityInterface : PaymentGatewayEntityInterface = PaymentGatewayEntityFactory.getInstance()
            var existingGateways : BasicArrayList = paymentGatewayEntityInterface.findPaymentTypeVectorByStore(this.getPaymentGatewayPrimaryKey().getStoreName())
            var allGatewaysLessExisting : BasicArrayList = BasicPaymentTypeUtil.getInstance().difference(existingGateways)
            return new PaymentGatewaysView(this.getTransformInfoInterface(), allGatewaysLessExisting).view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_SelectNewView.put(this.commonStrings.EXCEPTION, this, "view", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


