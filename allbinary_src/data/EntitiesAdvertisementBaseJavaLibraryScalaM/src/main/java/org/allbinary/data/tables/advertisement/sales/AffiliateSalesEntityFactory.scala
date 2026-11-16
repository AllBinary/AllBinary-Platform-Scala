/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement.sales

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AffiliateSalesEntityFactory private() {
    import _root_.org.allbinary.data.tables.advertisement.sales.AffiliateSalesEntityFactory.{*}

}

object AffiliateSalesEntityFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val CLASSNAME : String = "org.allbinary.data.tables.AffiliatesSalesEntity"

    def getInstance() : AffiliateSalesEntityInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            return (new AffiliateSalesEntity()).asInstanceOf[AffiliateSalesEntityInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, "AffiliateEntityFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


