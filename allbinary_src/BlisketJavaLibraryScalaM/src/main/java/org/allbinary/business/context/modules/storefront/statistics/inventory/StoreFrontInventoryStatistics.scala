/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.inventory

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory
import _root_.org.allbinary.data.tables.user.commerce.inventory.item.InventoryEntityInterface
import _root_.org.allbinary.logic.StdUtil

class StoreFrontInventoryStatistics(param_storeFrontInterface : StoreFrontInterface) extends StoreFrontInventoryStatisticsInterface {

    private var totalNumberOfItems : Long = 0L

    private var totalInventorySaleValueMoney : Money = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        this.totalInventorySaleValueMoney = new Money()
        var inventoryEntityInterface : InventoryEntityInterface = InventoryEntityFactory.getInstance().getInventoryEntityInstance()
        var itemVector : BasicArrayList = inventoryEntityInterface.getItems(storeFrontInterface)
        val size : Int = itemVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var itemInterface : ItemInterface = itemVector.get(index).asInstanceOf[ItemInterface]
                var numberInStock : Int = Integer.valueOf(itemInterface.getNumber()).intValue()
                this.totalNumberOfItems = this.totalNumberOfItems + numberInStock
                var itemPriceMoney : Money = itemInterface.getPrice()
                itemPriceMoney.multiply(numberInStock)
                this.totalInventorySaleValueMoney.add(itemPriceMoney.toString())
                index += 1
            }
        }
    }

    def getNumber() : _root_.java.lang.Long = {
        return new _root_.java.lang.Long(this.totalNumberOfItems)
    }

    def getTotal() : Money = {
        return this.totalInventorySaleValueMoney
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(StoreFrontInventoryStatisticsData.getInstance().NUMBEROFITEMS, this.getNumber().toString())
        hashMap.put(StoreFrontInventoryStatisticsData.getInstance().TOTALVALUE, this.getTotal().toString())
        return hashMap
    }

    def toVector() : BasicArrayList = {
        return null
    }

    def getKey() : Object = {
        return null
    }

}


