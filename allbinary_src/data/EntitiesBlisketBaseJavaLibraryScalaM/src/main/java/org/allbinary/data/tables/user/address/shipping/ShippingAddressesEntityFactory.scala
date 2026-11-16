/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.address.shipping

import _root_.org.allbinary.data.tables.user.address.StreetAddressesEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ShippingAddressesEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.address.shipping.ShippingAddressesEntityFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(userName : String) : StreetAddressesEntity = {
        try {
            /*       Object[] params = new Object[1];               Class[] classes = new Class[1];       classes[0] = userName.getClass();               params[0] = (Object) userName;       return (StreetAddressesEntityInterface) AbeFactory.getInstance().getInstance(CLASSNAME, classes, params);        */
            return new ShippingAddressesEntity(userName)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getShippingAddressesEntityInstance()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object ShippingAddressesEntityFactory {
    private val instance : ShippingAddressesEntityFactory = new ShippingAddressesEntityFactory()

    /**      * @return the instance      */
    def getInstance() : ShippingAddressesEntityFactory = {
        return ShippingAddressesEntityFactory.instance
    }

}


