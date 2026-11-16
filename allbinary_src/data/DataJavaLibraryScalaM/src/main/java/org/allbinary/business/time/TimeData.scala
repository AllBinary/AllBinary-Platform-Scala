/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.time


class TimeData private() {
    import _root_.org.allbinary.business.time.TimeData.{*}

    val NAME : String = "TIME_NAME"

    val START : String = "TIME_START"

    val END : String = "TIME_END"

}

object TimeData {
    private val instance : TimeData = new TimeData()

    def getInstance() : TimeData = {
        return TimeData.instance
    }

}


