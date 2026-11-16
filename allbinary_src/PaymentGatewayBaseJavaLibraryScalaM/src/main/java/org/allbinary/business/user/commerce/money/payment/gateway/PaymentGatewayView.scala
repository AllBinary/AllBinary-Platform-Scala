/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.gateway

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class PaymentGatewayView(param_paymentGatewayInterface : PaymentGatewayInterface) extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var paymentGatewayInterface : PaymentGatewayInterface = null

    //Constructor
    {
        val paymentGatewayInterface : PaymentGatewayInterface = param_paymentGatewayInterface
        this.paymentGatewayInterface = paymentGatewayInterface
    }

    def getPaymentGatewayInterface() : PaymentGatewayInterface = {
        return this.paymentGatewayInterface
    }

    def toHashMap() : HashMap[Object, Object] = {
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF(this.commonStrings.START, this, "toXmlNode")
            }
            val hashMap : HashMap[Object, Object] = new PaymentGatewayMapping(this.paymentGatewayInterface).toHashMap().asInstanceOf[HashMap[Object, Object]]
            hashMap.putAll(this.toHashMap())
            val paymentGatewayNode : Node = ModDomHelper.createNodeWithValueNodes(document, PaymentGatewayData.NAME.toString(), hashMap)
            return paymentGatewayNode
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlNode", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


