/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings

class TransformInfoHttpFactory private() {
    import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpFactory.{*}

}

object TransformInfoHttpFactory {
    def getInstance(propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformInfoInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var weblisketSession : WeblisketSession = new WeblisketSession(propertiesHashMap, pageContext)
            if (!StringValidationUtil.getInstance().isEmpty(weblisketSession.getStoreName())) {
                var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(weblisketSession.getStoreName())
                if (storeFrontInterface != null) {
                    return (new TransformInfoHttpStore(storeFrontInterface, propertiesHashMap, pageContext)).asInstanceOf[TransformInfoInterface]
                } else {
                    throw new Exception("No StoreFront with: " + weblisketSession.getStoreName())
                }
            } else {
                return (new TransformInfoHttpContext(propertiesHashMap, pageContext)).asInstanceOf[TransformInfoInterface]
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, "TransformInfoFactory", commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


