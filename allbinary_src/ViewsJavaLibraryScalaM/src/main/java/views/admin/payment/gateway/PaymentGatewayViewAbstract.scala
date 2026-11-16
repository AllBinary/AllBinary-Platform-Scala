/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateway

import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayPrimaryKey
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpComposite
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

class PaymentGatewayViewAbstract(param_transformInfoInterface : TransformInfoInterface) extends TransformInfoHttpComposite(param_transformInfoInterface) {

    private var paymentGatewayPrimaryKey : PaymentGatewayPrimaryKey = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.getFormData(this.getPageContext().getRequest().asInstanceOf[HttpServletRequest])
    }

    def getFormData(request : HttpServletRequest) : Unit = {
        /*       this.storeName =       request.getParameter(       allbinary.business.context.modules.storefront.StoreFrontData.NAME);              if(this.storeName==null)       {        **/
        var storeName : String = this.getWeblisketSession().getStoreName()
        /*       }       else       {          this.weblisketSession.setStoreName(storeName);       }*/
        var gatewayName : String = request.getParameter(PaymentGatewayData.NAME.toString())
        //this.paymentGatewayInterface = new PaymentGateway(hashMap);
        this.setPaymentGatewayPrimaryKey(new PaymentGatewayPrimaryKey(storeName, gatewayName))
    }

    def getPaymentGatewayPrimaryKey() : PaymentGatewayPrimaryKey = {
        return this.paymentGatewayPrimaryKey
    }

    def setPaymentGatewayPrimaryKey(paymentGatewayPrimaryKey : PaymentGatewayPrimaryKey) : Unit = {
        this.paymentGatewayPrimaryKey = paymentGatewayPrimaryKey
    }

}


