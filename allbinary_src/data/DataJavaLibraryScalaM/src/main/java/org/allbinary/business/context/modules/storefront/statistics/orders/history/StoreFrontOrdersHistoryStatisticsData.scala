/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.orders.history


class StoreFrontOrdersHistoryStatisticsData private() {
    import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatisticsData.{*}

    val NAME : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_NAME"

    val NUMBEROFORDERS : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_NUMBER_OF_ORDERS"

    val SUBTOTAL : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_SUBTOTAL"

    val SHIPPINGCOST : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_SHIPPINGCOST"

    val TAXES : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_TAXES"

    val TOTAL : String = "STOREFRONT_ORDERS_HISTORY_STATISTICS_TOTAL"

}

object StoreFrontOrdersHistoryStatisticsData {
    private val instance : StoreFrontOrdersHistoryStatisticsData = new StoreFrontOrdersHistoryStatisticsData()

    def getInstance() : StoreFrontOrdersHistoryStatisticsData = {
        return StoreFrontOrdersHistoryStatisticsData.instance
    }

}


