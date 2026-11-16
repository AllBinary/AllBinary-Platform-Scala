/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.orders.history

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderHistoryInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.order.OrderHistoryEntityInterface
import _root_.org.allbinary.logic.StdUtil

//import org.allbinary.business.context.modules.storefront.statistics.orders.history.*;
class StoreFrontOrdersHistoryStatistics(param_storeFrontInterface : StoreFrontInterface) extends StoreFrontOrdersHistoryStatisticsInterface {

    private var numberOfOrdersLong : _root_.java.lang.Long = null

    private var subTotalMoney : Money = null

    private var shippingCostMoney : Money = null

    private var taxesMoney : Money = null

    private var totalMoney : Money = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        this.subTotalMoney = new Money()
        this.shippingCostMoney = new Money()
        this.taxesMoney = new Money()
        this.totalMoney = new Money()
        val orderHistoryEntityInterface : OrderHistoryEntityInterface = OrderHistoryEntityFactory.getInstance()
        val orderHistoryInterfaceVector : BasicArrayList = orderHistoryEntityInterface.getStoreOrders(storeFrontInterface)
        var numberOfOrders : Long = 0
        var orderHistoryInterface : OrderHistoryInterface = null
        val size : Int = orderHistoryInterfaceVector.size()

        {
            var index : Int = 0
            while (index < size) {
                orderHistoryInterface = orderHistoryInterfaceVector.get(index).asInstanceOf[OrderHistoryInterface]
                numberOfOrders = numberOfOrders + 1
                this.subTotalMoney.add(orderHistoryInterface.getSubTotal())
                this.shippingCostMoney.add(orderHistoryInterface.getShippingCost())
                this.taxesMoney.add(orderHistoryInterface.getTaxes())
                this.totalMoney.add(orderHistoryInterface.getTotal())
                index += 1
            }
        }
        this.numberOfOrdersLong = new _root_.java.lang.Long(numberOfOrders)
    }

    def getNumberOfOrders() : _root_.java.lang.Long = {
        return this.numberOfOrdersLong
    }

    def getSubTotal() : Money = {
        return this.subTotalMoney
    }

    def getShippingCost() : Money = {
        return this.shippingCostMoney
    }

    def getTaxes() : Money = {
        return this.taxesMoney
    }

    def getTotal() : Money = {
        return this.totalMoney
    }

    /*    public Long getNumberOfItemsSold()    {       return this.numberOfItemsSold;    }    */
    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var storeFrontOrdersHistoryStatisticsData : StoreFrontOrdersHistoryStatisticsData = StoreFrontOrdersHistoryStatisticsData.getInstance()
        hashMap.put(storeFrontOrdersHistoryStatisticsData.NUMBEROFORDERS, this.getNumberOfOrders().toString())
        hashMap.put(storeFrontOrdersHistoryStatisticsData.SUBTOTAL, this.getSubTotal().toString())
        hashMap.put(storeFrontOrdersHistoryStatisticsData.SHIPPINGCOST, this.getShippingCost().toString())
        hashMap.put(storeFrontOrdersHistoryStatisticsData.TAXES, this.getTaxes().toString())
        hashMap.put(storeFrontOrdersHistoryStatisticsData.TOTAL, this.getTotal().toString())
        return hashMap
    }

    def toVector() : BasicArrayList = {
        return null
    }

    def getKey() : Object = {
        return null
    }

}


