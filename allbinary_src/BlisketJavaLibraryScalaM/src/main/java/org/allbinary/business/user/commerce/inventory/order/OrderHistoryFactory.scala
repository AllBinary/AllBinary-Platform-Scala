/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

//Retrieves a single order for a user
class OrderHistoryFactory private() {
    import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object OrderHistoryFactory {
    def getInstance(id : String) : OrderHistory = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            //   = (OrderHistoryEntityInterface) InterfaceCastProxy.newInstance(object);
            var orderHistoryEntityInterface : OrderHistoryEntity = new _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntity()
            return orderHistoryEntityInterface.getOrder(id).asInstanceOf[OrderHistory]
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    logUtil.put(commonStrings.EXCEPTION, "OrderHistoryFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


