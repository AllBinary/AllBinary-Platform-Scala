/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.storefront

import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.modules.storefront.StoreFront
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.views.business.context.modules.storefront.HttpStoreComponentView

class StoreFrontComponent(param_transformInfoInterface : TransformInfoInterface) extends HttpStoreComponentView(param_transformInfoInterface) {

    val logUtil_StoreFrontComponent : LogUtil = LogUtil.getInstance()

    var newStoreFrontInterface : StoreFrontInterface = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        this.newStoreFrontInterface = (new StoreFront(this.getPageContext().getRequest().asInstanceOf[HttpServletRequest])).asInstanceOf[StoreFrontInterface]
        //or higher can manage a store
        if (this.newStoreFrontInterface.getName() == null) {
            this.newStoreFrontInterface.setName(this.getWeblisketSession().getStoreName())
        }
    }

    override def view() : String = {
        try {
            //Store is already included in store view
            return super.view()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_StoreFrontComponent.put(this.commonStrings.EXCEPTION, this, "view", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


