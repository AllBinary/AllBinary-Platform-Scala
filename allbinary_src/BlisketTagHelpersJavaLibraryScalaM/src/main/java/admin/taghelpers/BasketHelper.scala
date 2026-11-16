/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketInterface
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil

class BasketHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TagHelper {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    private val MAX : Int = 200

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.propertiesHashMap = hashMap
        this.pageContext = pageContext
        var storeName : String = this.propertiesHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        }
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
    }

    def isBasketEmpty() : _root_.java.lang.Boolean = {
        try {
            var basket : BasketInterface = this.weblisketSession.getOrder().getBasket()
            if (basket.getNumberOfItems().intValue() <= 0) {
                return _root_.java.lang.Boolean.TRUE
            } else {
                return _root_.java.lang.Boolean.FALSE
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "isBasketEmpty()", e)
                }
                return _root_.java.lang.Boolean.TRUE
            }
        }
        throw new IllegalStateException()
    }

}


