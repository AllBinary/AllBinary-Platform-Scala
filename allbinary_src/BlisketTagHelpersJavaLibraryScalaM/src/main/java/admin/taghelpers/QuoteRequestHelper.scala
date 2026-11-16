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
import _root_.org.allbinary.business.user.quoterequest.QuoteRequest
import _root_.org.allbinary.data.tables.user.quoterequest.QuoteRequestEntityFactory
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil

//TWB - Am I missing the correct Quote Request? Probably not
class QuoteRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var weblisketSession : WeblisketSession = null

    private var storeFrontInterface : StoreFrontInterface = null

    private var quoteRequest : QuoteRequest = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        var request : HttpServletRequest = pageContext.getRequest().asInstanceOf[HttpServletRequest]
        this.weblisketSession = new WeblisketSession(hashMap, pageContext)
        this.quoteRequest = new QuoteRequest(this.weblisketSession.getUserName(), request)
        //new QuoteRequest((WeblisketSessionInterface) this.weblisketSession, request);
        var storeName : String = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        if (storeName != null) {
            this.storeFrontInterface = StoreFrontFactory.getInstance(storeName)
        }
    }

    def isValid() : _root_.java.lang.Boolean = {
        return this.quoteRequest.isValid()
    }

    def validationInfo() : String = {
        return this.quoteRequest.validationInfo()
    }

    override def insert() : String = {
        try {
            var values : BasicArrayList = this.quoteRequest.toVector()
            QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance().insert(values)
            var success : String = "New QuoteRequest Successfully added to the QuoteRequest Table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "add()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add QuoteRequest"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "add()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            var values : HashMap[Object, Object] = this.quoteRequest.toHashMap().asInstanceOf[HashMap[Object, Object]]
            QuoteRequestEntityFactory.getInstance().getQuoteRequestEntityInstance().update(this.quoteRequest.getUserName(), values)
            var success : String = "New QuoteRequest Successfully updated"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to update QuoteRequest"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        return commonStrings.NOT_IMPLEMENTED
    }

}


