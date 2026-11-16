/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.advertisement

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AdvertisementsEntityFactory private() {
    import _root_.org.allbinary.data.tables.advertisement.AdvertisementsEntityFactory.{*}

}

object AdvertisementsEntityFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val CLASSNAME : String = "org.allbinary.data.tables.AdvertisementEntity"

    def getInstance() : AdvertisementsEntityInterface = {
        val logUtil : LogUtil = LogUtil.getInstance()
        try {
            return (new AdvertisementsEntity()).asInstanceOf[AdvertisementsEntityInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    logUtil.put(commonStrings.EXCEPTION, "AdvertisementEntityFactory", commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


