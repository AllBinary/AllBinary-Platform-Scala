/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.context.modules.storefronts

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class BasicStoreFrontFactory private() {
    import _root_.org.allbinary.business.context.modules.storefronts.BasicStoreFrontFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(storeName : String) : BasicStoreFrontInterface = {
        try {
            var storeFronts : BasicStoreFrontsEntity = new BasicStoreFrontsEntity()
            return storeFronts.getStoreFrontInterface(storeName)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().FACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object BasicStoreFrontFactory {
    private val instance : BasicStoreFrontFactory = new BasicStoreFrontFactory()

    /**      * @return the instance      */
    def getInstance() : BasicStoreFrontFactory = {
        return BasicStoreFrontFactory.instance
    }

}


