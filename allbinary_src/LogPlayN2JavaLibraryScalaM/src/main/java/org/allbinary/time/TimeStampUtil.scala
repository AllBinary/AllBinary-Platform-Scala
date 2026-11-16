/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.com.google.gwt.i18n.client.DateTimeFormat
import _root_.java.util.Date

//ActualPlatform
class TimeStampUtil private() {
    import _root_.org.allbinary.time.TimeStampUtil.{*}

    //ActualPlatform    
    def getAsString() : String = {
        // GWT's replacement for SimpleDateFormat
        val simpleDataFormat : DateTimeFormat = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss.SSS")
        // replacing the need for Calendar.getInstance().getTime()
        val date : Date = new Date()
        return simpleDataFormat.format(date)
    }

}

object TimeStampUtil {
    private val instance : TimeStampUtil = new TimeStampUtil()

    //ActualPlatform
    def getInstance() : TimeStampUtil = {
        return TimeStampUtil.instance
    }

}


