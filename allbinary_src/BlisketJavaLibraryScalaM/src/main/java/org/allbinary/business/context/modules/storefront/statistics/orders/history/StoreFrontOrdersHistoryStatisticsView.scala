/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.orders.history

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreFrontOrdersHistoryStatisticsView(param_storeFrontOrdersHistoryStatisticsInterface : StoreFrontOrdersHistoryStatisticsInterface) extends DomNodeInterface {

    private var storeFrontOrdersHistoryStatisticsInterface : StoreFrontOrdersHistoryStatisticsInterface = null

    //Constructor
    {
        val storeFrontOrdersHistoryStatisticsInterface : StoreFrontOrdersHistoryStatisticsInterface = param_storeFrontOrdersHistoryStatisticsInterface
        this.storeFrontOrdersHistoryStatisticsInterface = storeFrontOrdersHistoryStatisticsInterface
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.storeFrontOrdersHistoryStatisticsInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, StoreFrontOrdersHistoryStatisticsData.getInstance().NAME, hashMap)
        return node
    }

}


