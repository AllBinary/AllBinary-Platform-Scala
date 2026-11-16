/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.user.commerce.money.MoneyException
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.communication.http.request.RequestParams

class ItemFactoryUnused private() {
    import _root_.org.allbinary.business.user.commerce.inventory.item.ItemFactoryUnused.{*}

}

object ItemFactoryUnused {
    def getInstance(hashMap : HashMap[Object, Object]) : TableMappingInterface = {
        return (new Item(hashMap)).asInstanceOf[TableMappingInterface]
    }

    def getInstance(request : HttpServletRequest) : TableMappingInterface = {
        return (new Item(new RequestParams(request).toHashMap())).asInstanceOf[TableMappingInterface]
    }

}


