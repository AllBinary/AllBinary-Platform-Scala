/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.orderhistory

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderData
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryData
import _root_.org.allbinary.business.user.username.UserName
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntity
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class UserNameOrderHistoryView(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) with ValidationComponentInterface with DomNodeInterface {

    val logUtil_UserNameOrderHistoryView : LogUtil = LogUtil.getInstance()

    private var request : HttpServletRequest = null

    private var userName : String = null

    private var shipped : String = null

    private var partiallyShipped : String = null

    private var processing : String = null

    private var preprocessing : String = null

    private var cancelled : String = null

    private val ON : String = "on"

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.request = this.getPageContext().getRequest().asInstanceOf[HttpServletRequest]
        this.userName = this.request.getParameter(UserData.USERNAME)
        this.preprocessing = this.request.getParameter(OrderHistoryData.PREPROCESSINGNAME)
        this.shipped = this.request.getParameter(OrderHistoryData.SHIPPEDNAME)
        this.partiallyShipped = this.request.getParameter(OrderHistoryData.PARTIALLYSHIPPEDNAME)
        this.processing = this.request.getParameter(OrderHistoryData.PROCESSINGNAME)
        this.cancelled = this.request.getParameter(OrderHistoryData.CANCELLEDNAME)
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
                    this.logUtil_UserNameOrderHistoryView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def toXmlNode(document : Document) : Node = {
        try {
            var node : Node = document.createElement(OrderData.ORDERS)
            var orderHistoryEntity : OrderHistoryEntity = new OrderHistoryEntity()
            //could pass in false hidden data
            var orderReviewVector : BasicArrayList = orderHistoryEntity.getOrders(this.userName)
            var size : Int = orderReviewVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var orderHistory : OrderHistory = orderReviewVector.get(index).asInstanceOf[OrderHistory]
                    var orderHistoryNode : Node = orderHistory.toXmlNode(document)
                    var orderNode : Node = document.createElement(orderHistory.getPaymentMethod())
                    node.appendChild(orderHistory.toXmlNode(document))
                    index += 1
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_UserNameOrderHistoryView.putF("Attempt to View a users order history", this, "view")
            }
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PREPROCESSINGNAME, OrderHistoryData.PREPROCESSING))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PROCESSINGNAME, OrderHistoryData.PROCESSING))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.CANCELLEDNAME, OrderHistoryData.CANCELLED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.PARTIALLYSHIPPEDNAME, OrderHistoryData.PARTIALLYSHIPPED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, OrderHistoryData.SHIPPEDNAME, OrderHistoryData.SHIPPED))
            node.appendChild(ModDomHelper.createNameValueNodes(document, GLOBALS2.VIEWNAME, GLOBALS2.VIEW))
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().XSLLOGGINGERROR)) {
                    this.logUtil_UserNameOrderHistoryView.put(this.commonStrings.FAILURE, this, "toXmlNode", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def isValid() : _root_.java.lang.Boolean = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_UserNameOrderHistoryView.putF("Started", this, this.commonStrings.IS_VALID)
        }
        if (UserName.getInstance().isValid(this.userName) == _root_.java.lang.Boolean.TRUE) {
            return _root_.java.lang.Boolean.TRUE
        }
        return _root_.java.lang.Boolean.FALSE
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        if (this.userName == null) {
            return "No User Name Specified<br />"
        }
        if (UserName.getInstance().isValid(this.userName) == _root_.java.lang.Boolean.FALSE) {
            return "Invalid User Name<br />"
        }
        return "Unknown Error<br />"
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


