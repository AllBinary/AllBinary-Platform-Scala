/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.java.util.Calendar

class TimeUtil {
    import _root_.org.allbinary.time.TimeUtil.{*}

    def setCalendar(calendar : Calendar, yearString : String, monthString : String, dayString : String, hourString : String) : Unit = {
        var year : Int = new Integer(yearString).intValue()
        var month : Int = new Integer(monthString).intValue()
        var day : Int = new Integer(dayString).intValue()
        var hour : Int = new Integer(hourString).intValue()
        calendar.set(year, month, day, hour, 0)
    }

    def setCalendarWithTime(calendar : Calendar, yearString : String, monthString : String, dayString : String, hourString : String, minuteString : String, secondString : String) : Unit = {
        var year : Int = new Integer(yearString).intValue()
        var month : Int = new Integer(monthString).intValue()
        var day : Int = new Integer(dayString).intValue()
        var hour : Int = new Integer(hourString).intValue()
        var minute : Int = new Integer(minuteString).intValue()
        var second : Int = new Integer(secondString).intValue()
        calendar.set(year, month, day, hour, minute, second)
    }

    def setExpirationCalendar(calendar : Calendar, yearsString : String, monthsString : String, daysString : String, hoursString : String, minutesString : String, secondsString : String) : Unit = {
        var year : Int = calendar.get(Calendar.YEAR) + new Integer(yearsString).intValue()
        var month : Int = calendar.get(Calendar.MONTH) + new Integer(monthsString).intValue()
        var day : Int = calendar.get(Calendar.DAY_OF_MONTH) + new Integer(daysString).intValue()
        var hour : Int = calendar.get(Calendar.HOUR) + new Integer(hoursString).intValue()
        var minute : Int = calendar.get(Calendar.MINUTE) + new Integer(minutesString).intValue()
        var second : Int = calendar.get(Calendar.SECOND) + new Integer(secondsString).intValue()
        calendar.set(year, month, day, hour, minute, second)
    }

    def getTotalTime(yearString : String, monthString : String, dayString : String, hourString : String, minuteString : String, secondString : String) : Long = {
        var time : Long = TimeUtil.calendar.getTimeInMillis()
        this.setExpirationCalendar(TimeUtil.calendar, yearString, monthString, dayString, hourString, minuteString, secondString)
        var timeDelta : Long = TimeUtil.calendar.getTimeInMillis()
        return timeDelta - time
    }

}

object TimeUtil {
    private val instance : TimeUtil = new TimeUtil()

    def getInstance() : TimeUtil = {
        return TimeUtil.instance
    }

    private val calendar : Calendar = Calendar.getInstance()

}


