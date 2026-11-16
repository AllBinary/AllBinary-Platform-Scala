/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.java.util.Calendar
import _root_.java.util.Date

//NoPlatform
class TimeStampUtil private() {
    import _root_.org.allbinary.time.TimeStampUtil.{*}

    def getAsString() : String = {
        throw new RuntimeException()
    }

}

object TimeStampUtil {
    private val instance : TimeStampUtil = new TimeStampUtil()

    def getInstance() : TimeStampUtil = {
        return TimeStampUtil.instance
    }

}


