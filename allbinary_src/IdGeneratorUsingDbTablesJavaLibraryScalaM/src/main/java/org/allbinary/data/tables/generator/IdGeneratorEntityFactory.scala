/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.generator

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class IdGeneratorEntityFactory private() {
    import _root_.org.allbinary.data.tables.generator.IdGeneratorEntityFactory.{*}

}

object IdGeneratorEntityFactory {
    def getInstance() : IdGeneratorEntityInterface = {
        try {
            return (new _root_.org.allbinary.data.tables.generator.IdGeneratorEntity()).asInstanceOf[IdGeneratorEntityInterface]
        } catch {
            case e : Exception => {
                val logUtil : LogUtil = LogUtil.getInstance()
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                logUtil.put(commonStrings.EXCEPTION, "ServerLicenseRequestEntityFactory", commonStrings.GET_INSTANCE, e)
                return null
            }
        }
        throw new IllegalStateException()
    }

}


