/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.order

import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.inventory.basket.Basket
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketReview
import _root_.org.allbinary.business.user.commerce.inventory.order.Order
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class OrderView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with DomNodeInterface {

    val logUtil_OrderView : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    var order : Order = null

    var orderHistory : OrderHistory = null

    var basketReview : BasketReview = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.getFormData()
    }

    private def getFormData() : Unit = {
        var id : String = this.request.getParameter(OrderData.ID)
        if (id == null) {
            id = this.getWeblisketSession().getOrder().getId()
        }
        this.order = new Order(new Basket())
        this.order.setId(id)
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var orderHistoryNode : Node = this.orderHistory.toXmlNode(document)
            var node : Node = document.createElement(this.orderHistory.getPaymentMethod())
            orderHistoryNode.appendChild(this.basketReview.toXmlNode(document))
            node.appendChild(orderHistoryNode)
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_OrderView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                return null
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
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_OrderView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


