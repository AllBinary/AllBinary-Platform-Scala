/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.audio

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class AllBinaryMediaManagerShutdown {
    import _root_.org.allbinary.media.audio.AllBinaryMediaManagerShutdown.{*}

}

object AllBinaryMediaManagerShutdown {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : AllBinaryMediaManagerShutdown = new AllBinaryMediaManagerShutdown()

    def shutdown(soundsFactoryInterface : SoundsFactoryInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonStrings.START, instance, "shutdown")
        AllBinaryMediaManager.shutdown(soundsFactoryInterface)
    }

}


