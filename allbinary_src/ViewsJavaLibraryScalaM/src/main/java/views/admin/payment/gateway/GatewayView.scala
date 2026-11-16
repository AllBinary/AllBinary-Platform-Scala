/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateway

import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterface
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class GatewayView(param_transformInfoInterface : TransformInfoInterface) extends PaymentGatewayViewAbstract(param_transformInfoInterface) {

    val logUtil_GatewayView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    override def getFormData(request : HttpServletRequest) : Unit = {
        super.getFormData(request)
        if (StringValidationUtil.getInstance().isEmpty(this.getPaymentGatewayPrimaryKey().getName())) {
            this.getPaymentGatewayPrimaryKey().setName(this.getWeblisketSession().getPaymentMethod())
        }
    }

    def view() : String = {
        try {
            var paymentGatewayInterface : PaymentGatewayInterface = PaymentGatewayEntityFactory.getInstance().getPaymentGatewayInterface(this.getPaymentGatewayPrimaryKey().getStoreName(), BasicPaymentTypeUtil.getInstance().get(this.getPaymentGatewayPrimaryKey().getName()))
            return new PaymentGatewayComponent(this.getTransformInfoInterface(), paymentGatewayInterface).view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_GatewayView.put(this.commonStrings.EXCEPTION, this, "edit()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


