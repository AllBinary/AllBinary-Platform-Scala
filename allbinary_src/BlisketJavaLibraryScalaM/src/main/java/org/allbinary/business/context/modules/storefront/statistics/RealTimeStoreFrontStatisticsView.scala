/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics

import _root_.org.allbinary.business.context.modules.storefront.statistics.advertisements.StoreFrontAdvertisementsStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.advertisements.StoreFrontAdvertisementsStatisticsView
import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.inventory.StoreFrontInventoryStatisticsView
import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.orders.history.StoreFrontOrdersHistoryStatisticsView
import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatisticsInterface
import _root_.org.allbinary.business.context.modules.storefront.statistics.users.StoreFrontUsersStatisticsView
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleFactory
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class RealTimeStoreFrontStatisticsView(param_storeFrontStatisticsInterface : StoreFrontStatisticsInterface, param_userRole : UserRole) extends DomNodeInterface {

    private var storeFrontStatisticsInterface : StoreFrontStatisticsInterface = null

    private var userRole : UserRole = null

    //Constructor
    {
        val storeFrontStatisticsInterface : StoreFrontStatisticsInterface = param_storeFrontStatisticsInterface
        val userRole : UserRole = param_userRole
        this.storeFrontStatisticsInterface = storeFrontStatisticsInterface
        this.userRole = userRole
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(StoreFrontStatisticsData.getInstance().NAME)
        //HashMap hashMap = this.storeFrontStatisticsInterface.toHashMap();
        var storeFrontAdvertisementsStatisticsInterface : StoreFrontAdvertisementsStatisticsInterface = this.storeFrontStatisticsInterface.getAdvertisements()
        var storeFrontAdvertisementsStatisticsDomNodeInterface : DomNodeInterface = new StoreFrontAdvertisementsStatisticsView(storeFrontAdvertisementsStatisticsInterface)
        node.appendChild(storeFrontAdvertisementsStatisticsDomNodeInterface.toXmlNode(document))
        var storeFrontInventoryStatisticsInterface : StoreFrontInventoryStatisticsInterface = this.storeFrontStatisticsInterface.getInventory()
        var storeFrontInventoryStatisticsDomNodeInterface : DomNodeInterface = new StoreFrontInventoryStatisticsView(storeFrontInventoryStatisticsInterface)
        node.appendChild(storeFrontInventoryStatisticsDomNodeInterface.toXmlNode(document))
        var storeFrontOrdersHistoryStatisticsInterface : StoreFrontOrdersHistoryStatisticsInterface = this.storeFrontStatisticsInterface.getOrders()
        var storeFrontOrdersHistoryStatisticsDomNodeInterface : DomNodeInterface = new StoreFrontOrdersHistoryStatisticsView(storeFrontOrdersHistoryStatisticsInterface)
        node.appendChild(storeFrontOrdersHistoryStatisticsDomNodeInterface.toXmlNode(document))
        if (this.userRole eq UserRoleFactory.getInstance().ADMINISTRATOR) {
            var storeFrontUsersStatisticsInterface : StoreFrontUsersStatisticsInterface = this.storeFrontStatisticsInterface.getUsers()
            var storeFrontUsersStatisticsDomNodeInterface : DomNodeInterface = new StoreFrontUsersStatisticsView(storeFrontUsersStatisticsInterface)
            node.appendChild(storeFrontUsersStatisticsDomNodeInterface.toXmlNode(document))
        }
        return node
    }

}


