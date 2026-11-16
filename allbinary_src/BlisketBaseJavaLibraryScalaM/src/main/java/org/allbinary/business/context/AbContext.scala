/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AbContext(param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var propertiesHashMap : HashMap[Object, Object] = null

    private var pageContext : PageContext = null

    //Constructor
    {
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Properties HashMap: " + propertiesHashMap.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.propertiesHashMap = propertiesHashMap
        this.pageContext = pageContext
    }

    def getWeblisketSession() : WeblisketSessionInterface = {
        return new WeblisketSession(this.propertiesHashMap, pageContext)
    }

    def getPageContext() : PageContext = {
        return this.pageContext
    }

    def getPropertiesHashMap() : HashMap[Object, Object] = {
        return this.propertiesHashMap
    }

}


