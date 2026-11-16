/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.permissions

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PermissionItemsEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.commerce.inventory.item.permissions.PermissionItemsEntityFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object PermissionItemsEntityFactory {
    private val instance : PermissionItemsEntityFactory = new PermissionItemsEntityFactory()

    /**      * @return the instance      */
    def getInstance() : PermissionItemsEntityFactory = {
        return PermissionItemsEntityFactory.instance
    }

    def getPermissionItemsEntityInstance() : PermissionItemsEntity = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            //return (InventoryEntityInterface) InterfaceCastProxy.newInstance(object);
            return new _root_.org.allbinary.data.tables.user.commerce.inventory.item.permissions.PermissionItemsEntity()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    logUtil.put(commonStrings.EXCEPTION, "PermissionItemsEntityFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


