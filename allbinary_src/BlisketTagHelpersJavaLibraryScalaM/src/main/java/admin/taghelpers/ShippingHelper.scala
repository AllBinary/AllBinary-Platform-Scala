/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.shipping.ShippingMethodData
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil

class ShippingHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    private var request : HttpServletRequest = null

    private var shippingType : String = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        //this.propertiesHashMap = propertiesHashMap;
        this.pageContext = pageContext
        this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        var storeName : String = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        }
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.getFormData()
    }

    private def getFormData() : Unit = {
        this.shippingType = this.request.getParameter(ShippingMethodData.NAME)
    }

    def setShippingType() : String = {
        try {
            var success : String = "Successfully Set Shipping Type"
            var order : OrderInterface = this.weblisketSession.getOrder()
            order.setShippingMethod(this.shippingType)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "setShippingType()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to view Shipping Type"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setShippingType()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}


