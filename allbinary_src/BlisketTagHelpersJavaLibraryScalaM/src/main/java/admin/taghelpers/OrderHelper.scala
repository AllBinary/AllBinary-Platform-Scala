/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.Order
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderProcessorUtil
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayInterface
import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentType
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntity
import _root_.org.allbinary.data.tables.user.commerce.money.payment.gateway.PaymentGatewayEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil

class OrderHelper(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    private var request : HttpServletRequest = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        this.propertiesHashMap = propertiesHashMap
        this.pageContext = pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        var storeName : String = propertiesHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (!StringValidationUtil.getInstance().isEmpty(storeName)) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        }
        this.weblisketSession = new WeblisketSession(this.propertiesHashMap, this.pageContext)
    }

    def setPaymentGateway() : _root_.java.lang.Boolean = {
        try {
            var paymentGatewayBoolean : _root_.java.lang.Boolean = _root_.java.lang.Boolean.FALSE
            var orderInterface : OrderInterface = this.weblisketSession.getOrder()
            //Set Payment Method to Request Param
            var requestPaymentGateway : String = this.request.getParameter(PaymentGatewayData.NAME.toString()).asInstanceOf[String]
            if (!StringValidationUtil.getInstance().isEmpty(requestPaymentGateway)) {
                this.weblisketSession.setPaymentMethod(requestPaymentGateway)
                orderInterface.setPaymentMethod(requestPaymentGateway)
                paymentGatewayBoolean = _root_.java.lang.Boolean.TRUE
            }
            //Otherwise set if only one payment gateway is available
            var paymentGatewayEntityInterface : PaymentGatewayEntity = PaymentGatewayEntityFactory.getInstance().asInstanceOf[PaymentGatewayEntity]
            var paymentTypeVector : BasicArrayList = paymentGatewayEntityInterface.findPaymentTypeVectorByStore(this.weblisketSession.getStoreName())
            if (paymentTypeVector.size() == 1) {
                var paymentType : BasicPaymentType = paymentTypeVector.get(0).asInstanceOf[BasicPaymentType]
                var paymentGatewayInterface : PaymentGatewayInterface = paymentGatewayEntityInterface.getPaymentGatewayInterface(this.weblisketSession.getStoreName(), paymentType).asInstanceOf[PaymentGatewayInterface]
                var paymentGateway : String = paymentGatewayInterface.getName()
                this.weblisketSession.setPaymentMethod(paymentGateway)
                orderInterface.setPaymentMethod(paymentGateway)
                paymentGatewayBoolean = _root_.java.lang.Boolean.TRUE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Successfully set PaymentGateway Order: ")
                stringBuffer.append(orderInterface.getId())
                stringBuffer.append(" to: ")
                stringBuffer.append(orderInterface.getPaymentMethod())
                this.logUtil.putF(stringBuffer.toString(), this, "setPaymentGateway()")
            }
            return paymentGatewayBoolean
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failed to set PaymentGateway for Order: ")
                    try {
                        var orderInterface : OrderInterface = this.weblisketSession.getOrder()
                        if (orderInterface != null) {
                            stringBuffer.append(orderInterface.getId())
                            stringBuffer.append(" to: ")
                            stringBuffer.append(orderInterface.getPaymentMethod())
                        }
                    } catch {
                        case ex : Exception => {
                            stringBuffer.append(" Exception Getting")
                        }
                    }
                    this.logUtil.put(stringBuffer.toString(), this, "setPaymentGateway()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def process() : String = {
        try {
            var order : OrderInterface = this.weblisketSession.getOrder()
            order.setStoreName(this.storeFrontInterface.getName())
            var result : String = OrderProcessorUtil.getInstance().process(this.weblisketSession.getUserName(), order.asInstanceOf[Order])
            //OrderHistoryEntityFactory.getInstance().setPaymentMethod(order.getId(),this.paymentMethod);
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("Successfully Processed Order: " + result, this, "processOrder()")
            }
            return result
        } catch {
            case e : Exception => {
                val stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Failed to Process Order: ")
                try {
                    stringBuffer.append(this.weblisketSession.getOrder().getId())
                } catch {
                    case ex : Exception => {
                        stringBuffer.append(" Exception Getting Id")
                    }
                }
                val error : String = stringBuffer.toString()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.PROCESS, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


