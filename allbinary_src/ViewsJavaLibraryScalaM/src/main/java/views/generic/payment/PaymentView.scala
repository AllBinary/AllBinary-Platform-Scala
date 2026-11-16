/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.payment

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.money.payment.Payment
import _root_.org.allbinary.business.user.commerce.money.payment.PaymentData
import _root_.org.allbinary.data.tables.user.commerce.money.payment.PaymentEntityFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class PaymentView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_PaymentView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var paymentNode : Node = document.createElement(PaymentData.PAYMENT)
            document.appendChild(paymentNode)
            var paymentVector : BasicArrayList = PaymentEntityFactory.getInstance().getPaymentEntityInstance().get(this.getWeblisketSession().getUserName())
            var size : Int = paymentVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var payment : Payment = paymentVector.get(index).asInstanceOf[Payment]
                    paymentNode.appendChild(payment.toXmlNode(document))
                    index += 1
                }
            }
            return paymentNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_PaymentView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def addDomNodeInterfaces() : Unit = {
        this.addDomNodeInterface(this.asInstanceOf[DomNodeInterface])
    }

    override def view() : String = {
        try {
            this.addDomNodeInterfaces()
            return super.view()
        } catch {
            case e : Exception => {
                var error : String = "Failed to view Payment"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_PaymentView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


