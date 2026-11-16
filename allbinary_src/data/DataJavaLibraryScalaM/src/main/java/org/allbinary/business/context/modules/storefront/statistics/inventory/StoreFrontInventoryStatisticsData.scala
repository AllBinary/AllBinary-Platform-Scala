/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.inventory


class StoreFrontInventoryStatisticsData private() {
    import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatisticsData.{*}

    val NAME : String = "STOREFRONT_INVENTORY_STATISTICS_NAME"

    val NUMBEROFITEMS : String = "STOREFRONT_INVENTORY_STATISTICS_NUMBER_OF_ITEMS"

    val TOTALVALUE : String = "STOREFRONT_INVENTORY_STATISTICS_TOTAL_VALUE"

}

object StoreFrontInventoryStatisticsData {
    private val instance : StoreFrontInventoryStatisticsData = new StoreFrontInventoryStatisticsData()

    def getInstance() : StoreFrontInventoryStatisticsData = {
        return StoreFrontInventoryStatisticsData.instance
    }

}


