/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment

import _root_.org.allbinary.business.user.commerce.money.payment.gateway.processor.PaymentProcessorInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.processor.PaymentProcessorInterfaceFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class PaymentProcessorComponent(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_PaymentProcessorComponent : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def addDomNodeInterfaces() : Unit = {
        var paymentProcessorInterface : PaymentProcessorInterface = PaymentProcessorInterfaceFactory.getInstance().getInstance(this.getTransformInfoInterface())
        paymentProcessorInterface.process()
        //If Processing works the empty basket
        var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
        httpTransformInfoInterface.getWeblisketSession().removeBasket()
        this.addDomNodeInterface(paymentProcessorInterface.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_PaymentProcessorComponent.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


