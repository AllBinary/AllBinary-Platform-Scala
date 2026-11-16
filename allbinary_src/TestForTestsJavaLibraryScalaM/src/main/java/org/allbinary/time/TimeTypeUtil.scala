/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.java.util.Calendar
import _root_.java.util.TimeZone

/**  *  * @author User  */
class TimeTypeUtil {
    import _root_.org.allbinary.time.TimeTypeUtil.{*}

    val NIGHT : String = "Night"

    val DAY : String = "Day"

    //    public final String THE_WITCHING_HOUR = "The Witching Hour";
    def isNight() : Boolean = {
        val hoursOfDay : Int = this.getHourOfDay()
        return (hoursOfDay < 6) || (hoursOfDay > 18)
    }

    def getHourOfDay() : Int = {
        //return LocalTime.now().getHour();
        val calendar : Calendar = Calendar.getInstance()
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    def getNightOrDay() : String = {
        return (if (this.isNight()) this.NIGHT else this.DAY)
    }

    def getHourOfDay(timeInMillis : Long) : Int = {
        //return hoursOfDay < 6 || hoursOfDay > 18;        
        val calendar : Calendar = Calendar.getInstance()
        calendar.setTimeInMillis(timeInMillis)
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    def isNight(timeInMillis : Long) : Boolean = {
        val hoursOfDay : Int = this.getHourOfDay(timeInMillis)
        return (hoursOfDay < 6) || (hoursOfDay > 18)
    }

    def getNightOrDay(timeInMillis : Long) : String = {
        return (if (this.isNight(timeInMillis)) this.NIGHT else this.DAY)
    }

}

object TimeTypeUtil {
    private val instance : TimeTypeUtil = new TimeTypeUtil()

    /**      * @return the instance      */
    def getInstance() : TimeTypeUtil = {
        return TimeTypeUtil.instance
    }

}


