/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.order

import _root_.org.allbinary.data.generator.OrderIdGenerator
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntity
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderItemsEntity

/**  *  * @author user  */
class OrderProcessorUtil {
    import _root_.org.allbinary.business.user.commerce.inventory.order.OrderProcessorUtil.{*}

    private val ORDER_PROCESSED : String = "Order Processed"

    def process(userName : String, order : Order) : String = {
        var orderItems : OrderItemsEntity = new OrderItemsEntity()
        var orderHistory : OrderHistoryEntity = new OrderHistoryEntity()
        order.setId(new OrderIdGenerator().getNext())
        orderItems.insert(userName, order)
        orderHistory.insert(userName, order)
        return this.ORDER_PROCESSED
    }

}

object OrderProcessorUtil {
    private val instance : OrderProcessorUtil = new OrderProcessorUtil()

    def getInstance() : OrderProcessorUtil = {
        return OrderProcessorUtil.instance
    }

}


