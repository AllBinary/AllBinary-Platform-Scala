/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.mapping.PersistentInputMapping
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class PlatformInputMappingFactory {
    import _root_.org.allbinary.game.input.PlatformInputMappingFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var inputToGameKeyMapping : PersistentInputMapping = PersistentInputMapping.getNullInstance()

    def getPersistentInputMappingInstance() : PersistentInputMapping = {
        try {
            if (this.inputToGameKeyMapping eq PersistentInputMapping.getNullInstance()) {
                this.inputToGameKeyMapping = new LaptopGameInputMapping()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
            }
        }
        return this.inputToGameKeyMapping
    }

}

object PlatformInputMappingFactory {
    private val instance : PlatformInputMappingFactory = new PlatformInputMappingFactory()

    def getInstance() : PlatformInputMappingFactory = {
        return PlatformInputMappingFactory.instance
    }

}


