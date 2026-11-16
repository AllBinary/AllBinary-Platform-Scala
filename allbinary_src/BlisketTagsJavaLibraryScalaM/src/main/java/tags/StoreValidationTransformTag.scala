/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package tags

import _root_.javax.servlet.jsp.JspTagException
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil

class StoreValidationTransformTag() extends ValidationTransformTag() {

    val logUtil_StoreValidationTransformTag : LogUtil = LogUtil.getInstance()

    private var storeName : String = null

    override def setStoreName(value : String) : Unit = {
        this.storeName = value
        this.getPropertiesHashMap().put(StoreFrontData.getInstance().NAME, this.storeName)
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_StoreValidationTransformTag.putF("Tag Start", this, tagStrings.DO_START_TAG)
            }
            return super.doStartTag()
        } catch {
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


