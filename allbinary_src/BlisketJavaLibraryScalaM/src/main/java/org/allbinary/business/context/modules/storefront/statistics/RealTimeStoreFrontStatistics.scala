/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics

import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.advertisements.StoreFrontAdvertisementsStatistics
import _root_.org.allbinary.business.context.modules.storefront.statistics.advertisements.StoreFrontAdvertisementsStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatistics
import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatistics
import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatistics
import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatisticsInterface

class RealTimeStoreFrontStatistics(param_storeFrontInterface : StoreFrontInterface) extends StoreFrontStatisticsInterface {

    private var storeFrontAdvertisementsStatisticsInterface : StoreFrontAdvertisementsStatisticsInterface = null

    private var storeFrontUsersStatisticsInterface : StoreFrontUsersStatisticsInterface = null

    private var storeFrontInventoryStatisticsInterface : StoreFrontInventoryStatisticsInterface = null

    private var storeFrontOrderHistoryStatisticsInterface : StoreFrontOrdersHistoryStatisticsInterface = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        this.storeFrontAdvertisementsStatisticsInterface = (new StoreFrontAdvertisementsStatistics(storeFrontInterface)).asInstanceOf[StoreFrontAdvertisementsStatisticsInterface]
        this.storeFrontUsersStatisticsInterface = (new StoreFrontUsersStatistics(storeFrontInterface)).asInstanceOf[StoreFrontUsersStatisticsInterface]
        this.storeFrontInventoryStatisticsInterface = (new StoreFrontInventoryStatistics(storeFrontInterface)).asInstanceOf[StoreFrontInventoryStatisticsInterface]
        this.storeFrontOrderHistoryStatisticsInterface = (new StoreFrontOrdersHistoryStatistics(storeFrontInterface)).asInstanceOf[StoreFrontOrdersHistoryStatisticsInterface]
    }

    def getAdvertisements() : StoreFrontAdvertisementsStatisticsInterface = {
        return this.storeFrontAdvertisementsStatisticsInterface
    }

    def getUsers() : StoreFrontUsersStatisticsInterface = {
        return this.storeFrontUsersStatisticsInterface
    }

    def getInventory() : StoreFrontInventoryStatisticsInterface = {
        return this.storeFrontInventoryStatisticsInterface
    }

    def getOrders() : StoreFrontOrdersHistoryStatisticsInterface = {
        return this.storeFrontOrderHistoryStatisticsInterface
    }

}


