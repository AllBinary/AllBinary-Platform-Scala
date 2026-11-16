/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.generic.order

import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderItemsEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ValidationView(param_transformInfoInterface : TransformInfoInterface) extends OrderView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_ValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (this.order.isIdValid() == _root_.java.lang.Boolean.FALSE) {
                return _root_.java.lang.Boolean.FALSE
            } else {
                this.orderHistory = OrderHistoryFactory.getInstance(this.order.getId())
                if ((this.orderHistory == null) || (this.orderHistory.isValid() == _root_.java.lang.Boolean.FALSE)) {
                    return _root_.java.lang.Boolean.FALSE
                }
                var orderItems : OrderItemsEntity = new OrderItemsEntity()
                this.basketReview = orderItems.getBasketReview(this.order.getId())
                if ((this.basketReview == null) || (this.basketReview.isValid() == _root_.java.lang.Boolean.FALSE)) {
                    return _root_.java.lang.Boolean.FALSE
                }
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_ValidationView.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (this.order.isIdValid() == _root_.java.lang.Boolean.FALSE) {
                stringBuffer.append(this.order.getIdValidationInfo())
            } else {
                this.orderHistory = OrderHistoryFactory.getInstance(this.order.getId())
                if ((this.orderHistory == null) || (this.orderHistory.isValid() == _root_.java.lang.Boolean.FALSE)) {
                    stringBuffer.append("Order History data error for: ")
                    stringBuffer.append(this.order.getId())
                    stringBuffer.append("<br />")
                }
                var orderItems : OrderItemsEntity = new OrderItemsEntity()
                this.basketReview = orderItems.getBasketReview(this.order.getId())
                if (this.basketReview == null) {
                    stringBuffer.append("Order Items data error - does not exist for: ")
                    stringBuffer.append(this.order.getId())
                    stringBuffer.append("<br />")
                } else if (this.basketReview.isValid() == _root_.java.lang.Boolean.FALSE) {
                    stringBuffer.append("Order Items data error - not valid for: ")
                    stringBuffer.append(this.order.getId())
                    stringBuffer.append("<br />")
                }
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_ValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


