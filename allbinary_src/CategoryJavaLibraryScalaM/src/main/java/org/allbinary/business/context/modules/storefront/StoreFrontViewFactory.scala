/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront

import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntity
import _root_.org.allbinary.data.tables.context.module.storefronts.StoreFrontsEntityFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class StoreFrontViewFactory private() {
    import _root_.org.allbinary.business.context.modules.storefront.StoreFrontViewFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object StoreFrontViewFactory {
    def getInstance(storeName : String) : DomNodeInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            var storeFronts : StoreFrontsEntity = StoreFrontsEntityFactory.getInstance().getStoreFrontsEntityInstance()
            return (new StoreFrontView(storeFronts.getStoreFrontInterface(storeName))).asInstanceOf[DomNodeInterface]
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    logUtil.put(commonStrings.EXCEPTION, "StoreFrontFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


