/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.Order
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistory
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait OrderHistoryEntityInterface extends BasicDataTableInterface {

    def insert(userName : String, order : Order) : Unit

    def setStatus(orderId : String, status : String) : Unit

    def setPaymentMethod(orderId : String, status : String) : Unit

    // public String getOrderForm(String orderId);
    def getStoreOrders(storeFrontInterface : StoreFrontInterface) : BasicArrayList

    def getOrders(userName : String) : BasicArrayList

    def getOrders(status : String, fromDate : String, toDate : String) : BasicArrayList

    def getOrder(id : String) : OrderHistory

    def update(whereHashMap : HashMap[Object, Object], orderHashMap : HashMap[Object, Object]) : Unit

}


