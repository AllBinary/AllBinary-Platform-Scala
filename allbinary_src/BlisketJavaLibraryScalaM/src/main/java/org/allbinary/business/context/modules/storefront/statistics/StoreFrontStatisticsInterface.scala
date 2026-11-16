/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics

import _root_.org.allbinary.business.context.modules.storefront.statistics.advertisements.StoreFrontAdvertisementsStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatisticsInterface

trait StoreFrontStatisticsInterface {

    def getAdvertisements() : StoreFrontAdvertisementsStatisticsInterface

    def getUsers() : StoreFrontUsersStatisticsInterface

    def getInventory() : StoreFrontInventoryStatisticsInterface

    def getOrders() : StoreFrontOrdersHistoryStatisticsInterface

}


