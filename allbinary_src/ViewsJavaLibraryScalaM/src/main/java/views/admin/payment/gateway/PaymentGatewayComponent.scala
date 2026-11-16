/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateway

import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.modules.gateway.PaymentGatewayDomNodeFactoryInterface
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class PaymentGatewayComponent(param_transformInfoInterface : TransformInfoInterface, param_paymentGatewayInterface : PaymentGatewayInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_PaymentGatewayComponent : LogUtil = LogUtil.getInstance()

    private var paymentGatewayInterface : PaymentGatewayInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        val paymentGatewayInterface : PaymentGatewayInterface = param_paymentGatewayInterface
        this.paymentGatewayInterface = paymentGatewayInterface
    }

    def addDomNodeInterfaces() : Unit = {
        var paymentType : BasicPaymentType = BasicPaymentTypeUtil.getInstance().get(this.paymentGatewayInterface.getName())
        var paymentGatewayDomNodeFactoryInterface : PaymentGatewayDomNodeFactoryInterface = paymentType.getPaymentGatewayDomNodeFactoryInterface()
        var domNodeInterface : DomNodeInterface = paymentGatewayDomNodeFactoryInterface.getInstance(this.paymentGatewayInterface).asInstanceOf[DomNodeInterface]
        this.addDomNodeInterface(domNodeInterface)
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                var error : String = "Failed to view payment gateway"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_PaymentGatewayComponent.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


