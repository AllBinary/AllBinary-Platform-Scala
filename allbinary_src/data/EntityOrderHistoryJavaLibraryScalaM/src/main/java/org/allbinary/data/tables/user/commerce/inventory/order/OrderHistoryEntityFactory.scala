/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class OrderHistoryEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory.{*}

}

object OrderHistoryEntityFactory {
    def getInstance() : OrderHistoryEntity = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            //return (OrderHistoryEntityInterface) InterfaceCastProxy.newInstance(object);
            return new _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntity()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    logUtil.put(commonStrings.EXCEPTION, "OrderHistoryEntityFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


