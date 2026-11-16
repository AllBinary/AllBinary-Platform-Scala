/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront.statistics.users

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreFrontUsersStatisticsView(param_storeFrontUsersStatisticsInterface : StoreFrontUsersStatisticsInterface) extends DomNodeInterface {

    private var storeFrontUsersStatisticsInterface : StoreFrontUsersStatisticsInterface = null

    //Constructor
    {
        val storeFrontUsersStatisticsInterface : StoreFrontUsersStatisticsInterface = param_storeFrontUsersStatisticsInterface
        this.storeFrontUsersStatisticsInterface = storeFrontUsersStatisticsInterface
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.storeFrontUsersStatisticsInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var node : Node = ModDomHelper.createNameValueNodes(document, StoreFrontUsersStatisticsData.getInstance().NAME, hashMap)
        return node
    }

}


