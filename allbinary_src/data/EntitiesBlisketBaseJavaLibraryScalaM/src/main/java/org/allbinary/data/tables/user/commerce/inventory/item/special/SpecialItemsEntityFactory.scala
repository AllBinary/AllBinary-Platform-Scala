/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.inventory.item.special

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class SpecialItemsEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.commerce.inventory.item.special.SpecialItemsEntityFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getSpecialItemsEntityInstance() : SpecialItemsEntity = {
        try {
            //return (InventoryEntityInterface) InterfaceCastProxy.newInstance(object);
            return new _root_.org.allbinary.data.tables.user.commerce.inventory.item.special.SpecialItemsEntity()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object SpecialItemsEntityFactory {
    private val instance : SpecialItemsEntityFactory = new SpecialItemsEntityFactory()

    /**      * @return the instance      */
    def getInstance() : SpecialItemsEntityFactory = {
        return SpecialItemsEntityFactory.instance
    }

}


