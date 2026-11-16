/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.payment.gateways

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewaysData
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentType
import _root_.org.allbinary.business.user.commerce.money.payment.types.PaymentTypeUtil
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class PaymentGatewaysView(param_transformInfoInterface : TransformInfoInterface, param_gatewayVector : BasicArrayList) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_PaymentGatewaysView : LogUtil = LogUtil.getInstance()

    private var paymentGatewayVector : BasicArrayList = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        val gatewayVector : BasicArrayList = param_gatewayVector
        this.paymentGatewayVector = gatewayVector
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var storeName : String = this.getTransformInfoInterface().getStoreName()
            var paymentGatewaysNode : Node = document.createElement(PaymentGatewaysData.NAME)
            var size : Int = this.paymentGatewayVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var paymentType : BasicPaymentType = this.paymentGatewayVector.get(index).asInstanceOf[BasicPaymentType]
                    var hashMap : HashMap[Object, Object] = paymentType.toHashMap().asInstanceOf[HashMap[Object, Object]]
                    //Get the Default for payment Option Screen
                    hashMap.put(EntryData.getInstance().DEFAULT, PaymentTypeUtil.getInstance().getDefault(storeName).getBasicPaymentType().getName())
                    var paymentGatewayNode : Node = ModDomHelper.createNodeWithValueNodes(document, PaymentGatewayData.NAME.toString(), hashMap)
                    paymentGatewaysNode.appendChild(paymentGatewayNode)
                    index += 1
                }
            }
            return paymentGatewaysNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_PaymentGatewaysView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
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
                var error : String = "Failed to view payment gateways"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_PaymentGatewaysView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


