/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.BasketHelperFactory
import _root_.admin.taghelpers.BasketRequestHelperFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.CustomTagSupport

class BasketTag() extends CustomTagSupport {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var command : String = null

    private var storeName : String = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    def setCommand(command : String) : Unit = {
        this.command = command
    }

    def setStoreName(value : String) : Unit = {
        this.storeName = value
    }

    private def isBasketEmpty() : Boolean = {
        try {
            var anyType : Object = new BasketHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("isBasketEmpty", null)
            var emptyBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return emptyBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isBasketEmpty()", e)
                }
                return true
            }
        }
        throw new IllegalStateException()
    }

    private def addItemToBasket() : Boolean = {
        try {
            var anyType : Object = new BasketRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("addItemToBasket", null)
            var emptyBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return emptyBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to add item from Basket"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "addItemToBasket()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def removeItemFromBasket() : Boolean = {
        try {
            var anyType : Object = new BasketRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("removeItemFromBasket", null)
            var emptyBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return emptyBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to remove item from Basket"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "removeItemFromBasket()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    private def adjustBasket() : Boolean = {
        try {
            var anyType : Object = new BasketRequestHelperFactory().getInstance(this.propertiesHashMap, this.pageContext)
            var method : Method = anyType.getClass().getMethod("adjustBasket", null)
            var emptyBoolean : _root_.java.lang.Boolean = method.invoke(anyType, null).asInstanceOf[_root_.java.lang.Boolean]
            return emptyBoolean.booleanValue()
        } catch {
            case e : LicensingException => {
                throw e
            }
            case e : Exception => {
                var error : String = "Failed to Adjust Basket"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "adjustBasket()", e)
                }
                return false
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (this.command != null) {
                this.propertiesHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
                this.propertiesHashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
                if (this.command.compareTo(BasketData.INSERT) == 0) {
                    if (!this.addItemToBasket()) {
                        this.pageContext.getOut().println("Item is not currently being sold.<p/>")
                    }
                } else if (this.command.compareTo(BasketData.DELETE) == 0) {
                    this.removeItemFromBasket()
                } else if (this.command.compareTo(BasketData.ADJUST) == 0) {
                    this.adjustBasket()
                } else if (this.command.compareTo(BasketData.ISEMPTY) == 0) {
                    if (this.isBasketEmpty()) {
                        return this.EVAL_BODY_INCLUDE
                    } else {
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    }
                }
            }
            return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


