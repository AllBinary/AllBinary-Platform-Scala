/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.order

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketReview
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.data.tables.BasicDataTableInterface

trait OrderItemsEntityInterface extends BasicDataTableInterface {

    def setStatus(orderId : String, groupId : String, status : String) : Unit

    def isEverythingShipped(orderId : String) : Boolean

    def getBasketReview(orderId : String) : BasketReview

    //public void delete(String value);
    def insert(userName : String, order : OrderInterface) : Unit

    def insert(values : BasicArrayList) : Unit

}


