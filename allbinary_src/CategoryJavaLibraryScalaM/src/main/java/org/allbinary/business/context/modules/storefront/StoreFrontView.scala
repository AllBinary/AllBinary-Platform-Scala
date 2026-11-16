/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefront

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.commerce.inventory.basket.BasketData
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreFrontView(param_storeFrontInterface : StoreFrontInterface) extends DomNodeInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var storeFrontInterface : StoreFrontInterface = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF("Constructing: StoreFrontView for: " + storeFrontInterface.getName(), this, commonStrings.GET_INSTANCE)
        }
        this.storeFrontInterface = storeFrontInterface
    }

    def toXmlNode(document : Document) : Node = {
        var hashMap : HashMap[Object, Object] = this.storeFrontInterface.toHashMap().asInstanceOf[HashMap[Object, Object]]
        var storeFrontData : StoreFrontData = StoreFrontData.getInstance()
        hashMap.put(storeFrontData.CURRENTHOMEHOSTNAME, this.storeFrontInterface.getCurrentHomeHostName())
        hashMap.put(storeFrontData.CURRENTHOMEHOSTNAMEPATH, this.storeFrontInterface.getCurrentHomeHostNamePath())
        hashMap.put(storeFrontData.CURRENTHOSTNAME, this.storeFrontInterface.getCurrentHostName())
        hashMap.put(storeFrontData.CURRENTHOSTNAMEPATH, this.storeFrontInterface.getCurrentHostNamePath())
        hashMap.put(BasketData.NAME, this.storeFrontInterface.getBasketName())
        var node : Node = ModDomHelper.createNameValueNodes(document, storeFrontData.NAME, hashMap)
        return node
    }

}


