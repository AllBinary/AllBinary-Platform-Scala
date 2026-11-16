/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.address.billing

import _root_.org.allbinary.data.tables.user.address.StreetAddressesEntity
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class BillingAddressesEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.address.billing.BillingAddressesEntityFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(userName : String) : StreetAddressesEntity = {
        try {
            /*       Object params[] = new Object[1];       Class classes[] = new Class[1];               classes[0] = userName.getClass();               params[0] = (Object) userName;       Object object = AbeFactory.getInstance().getInstance(CLASSNAME,classes, params);       return (StreetAddressesEntityInterface) InterfaceCastProxy.newInstance(object);        */
            return new BillingAddressesEntity(userName)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object BillingAddressesEntityFactory {
    private val instance : BillingAddressesEntityFactory = new BillingAddressesEntityFactory()

    /**      * @return the instance      */
    def getInstance() : BillingAddressesEntityFactory = {
        return BillingAddressesEntityFactory.instance
    }

}


