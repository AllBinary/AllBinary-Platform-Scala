/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.orders.history

import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.data.tables.TableMappingInterface

trait StoreFrontOrdersHistoryStatisticsInterface extends TableMappingInterface {

    def getNumberOfOrders() : _root_.java.lang.Long

    def getSubTotal() : Money

    def getShippingCost() : Money

    def getTaxes() : Money

    def getTotal() : Money

}


