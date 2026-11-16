/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.data

import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontViewFactory
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.search.SearchRequest

class TransformStoreDocument private (super_1 : PageContext, super_2 : WeblisketSession, constructor_ : Unit) extends TransformHttpRequestDocument(super_1, super_2) {

    val logUtil_TransformStoreDocument : LogUtil = LogUtil.getInstance()

    def this(pageContext : PageContext, weblisketSession : WeblisketSession) = {
        this(pageContext, weblisketSession, ())
        try {
            // UrlGlobalsViewFactory.getInstance().toXmlNode(this.getDoc()));
            var storeName : String = weblisketSession.getStoreName()
            /*          if(StringValidationUtil.isEmpty(storeName))          {             storeName = pageContext.getRequest().getParameter(StoreFrontData.NAME);             if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().VIEW))             {                this.logUtil.putF("Using Request StoreName: " + storeName, this, this.commonStrings.CONSTRUCTOR);             }          }          else          {*/
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_TransformStoreDocument.putF("Using Session StoreName: " + storeName, this, this.commonStrings.CONSTRUCTOR)
            }
            //}
            this.getBaseNode().appendChild(StoreFrontViewFactory.getInstance(storeName).toXmlNode(this.getDoc()))
            this.getBaseNode().appendChild(new RequestParams(pageContext.getRequest().asInstanceOf[HttpServletRequest]).toXmlNode(this.getDoc()))
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_TransformStoreDocument.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

    //, WeblisketSession weblisketSession
    def this(searchRequest : SearchRequest) = {
        this(searchRequest, null, ())
        try {
            // UrlGlobalsViewFactory.getInstance().toXmlNode(this.getDoc()));
            this.getBaseNode().appendChild(StoreFrontViewFactory.getInstance(searchRequest.getStoreFront().getName()).toXmlNode(this.getDoc()))
            this.getBaseNode().appendChild(searchRequest.getParams().getParamsNode(this.getDoc()))
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_TransformStoreDocument.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                }
                throw e
            }
        }
    }

}


