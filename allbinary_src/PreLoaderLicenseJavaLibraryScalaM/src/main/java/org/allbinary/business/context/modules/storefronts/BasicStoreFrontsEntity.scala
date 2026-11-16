/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefronts

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.init.InitSql
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class BasicStoreFrontsEntity() extends InitSql(new UserDbInitInfo()) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val tableName : String = "storefronts"

    //Constructor
    {
        this.setTable(this.tableName)
    }

    def getStoreFrontInterface(name : String) : BasicStoreFrontInterface = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        keysAndValues.put(StoreFrontData.getInstance().NAME, name)
        var storeHashMap : HashMap[Object, Object] = super.getRow(keysAndValues).asInstanceOf[HashMap[Object, Object]]
        if (storeHashMap == null) {
            throw new Exception("No Such Store: " + name)
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
            this.logUtil.putF("StoreFront: " + storeHashMap.toString(), this, "getStore()")
        }
        return (new BasicStoreFront(storeHashMap)).asInstanceOf[BasicStoreFrontInterface]
    }

}


