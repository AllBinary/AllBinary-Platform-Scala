/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.java.util.Calendar
import _root_.org.junit.jupiter.api.Assertions
import _root_.org.junit.jupiter.api.DisplayName
import _root_.org.junit.jupiter.api.Test

class TimeTypeTest {
    import _root_.org.allbinary.time.TimeTypeTest.{*}

    @Test
    @DisplayName("isNight returns true for hours < 6")
    def isNight_returnsTrue_for_hours_less_than_6() : Unit = {

        {
            val array_N67016 = Array[Int](0, 1, 2, 3, 4, 5)
            var index_N67016 : Int = 0
            while (index_N67016 < array_N67016.length) {
                val h : Int = array_N67016(index_N67016)
                index_N67016 += 1
                var util : TimeTypeUtil = new TestableTimeTypeUtil(h)
                Assertions.assertTrue(util.isNight(), "Expected night for hour=" + h)
            }
        }
    }

    @Test
    @DisplayName("isNight returns true for hours > 18")
    def isNight_returnsTrue_for_hours_greater_than_18() : Unit = {

        {
            val array_N67238 = Array[Int](19, 20, 21, 22, 23)
            var index_N67238 : Int = 0
            while (index_N67238 < array_N67238.length) {
                val h : Int = array_N67238(index_N67238)
                index_N67238 += 1
                var util : TimeTypeUtil = new TestableTimeTypeUtil(h)
                Assertions.assertTrue(util.isNight(), "Expected night for hour=" + h)
            }
        }
    }

    @Test
    @DisplayName("isNight returns false for boundary hours 6 and 18")
    def isNight_returnsFalse_for_boundary_hours_6_and_18() : Unit = {

        {
            val array_N67456 = Array[Int](6, 18)
            var index_N67456 : Int = 0
            while (index_N67456 < array_N67456.length) {
                val h : Int = array_N67456(index_N67456)
                index_N67456 += 1
                var util : TimeTypeUtil = new TestableTimeTypeUtil(h)
                Assertions.assertFalse(util.isNight(), "Expected day for boundary hour=" + h)
            }
        }
    }

    @Test
    @DisplayName("getNightOrDay returns labels consistent with isNight")
    def getNightOrDay_returns_expected_label() : Unit = {
        var nightUtil : TimeTypeUtil = new TestableTimeTypeUtil(0)
        Assertions.assertEquals(nightUtil.NIGHT, nightUtil.getNightOrDay())
        var dayUtil : TimeTypeUtil = new TestableTimeTypeUtil(12)
        Assertions.assertEquals(dayUtil.DAY, dayUtil.getNightOrDay())
    }

    @Test
    @DisplayName("getHourOfDay(long) converts epoch millis to local hour correctly")
    def getHourOfDay_long_converts_epoch_to_local_hour() : Unit = {
        var util : TimeTypeUtil = new TimeTypeUtil()

        {
            val array_N67944 = Array[Int](0, 6, 12, 18, 23)
            var index_N67944 : Int = 0
            while (index_N67944 < array_N67944.length) {
                val h : Int = array_N67944(index_N67944)
                index_N67944 += 1
                var millis : Long = TimeTypeTest.millisForHourLocal(h)
                Assertions.assertEquals(h, util.getHourOfDay(millis), "Hour mismatch for h=" + h)
            }
        }
    }

    @Test
    @DisplayName("isNight(long) returns true for <6 and >18 hours and false otherwise")
    def isNight_long_expected_ranges() : Unit = {
        var util : TimeTypeUtil = new TimeTypeUtil()
        // true cases

        {
            val array_N68220 = Array[Int](0, 1, 2, 3, 4, 5, 19, 20, 21, 22, 23)
            var index_N68220 : Int = 0
            while (index_N68220 < array_N68220.length) {
                val h : Int = array_N68220(index_N68220)
                index_N68220 += 1
                var millis : Long = TimeTypeTest.millisForHourLocal(h)
                Assertions.assertTrue(util.isNight(millis), "Expected night for hour=" + h)
            }
        }
        // false cases including boundaries

        {
            val array_N68436 = Array[Int](6, 7, 12, 18)
            var index_N68436 : Int = 0
            while (index_N68436 < array_N68436.length) {
                val h : Int = array_N68436(index_N68436)
                index_N68436 += 1
                var millis : Long = TimeTypeTest.millisForHourLocal(h)
                Assertions.assertFalse(util.isNight(millis), "Expected day for hour=" + h)
            }
        }
    }

    @Test
    @DisplayName("getNightOrDay(long) returns DAY/NIGHT consistent with isNight(long)")
    def getNightOrDay_long_consistency() : Unit = {
        var util : TimeTypeUtil = new TimeTypeUtil()
        var nightMillis : Long = TimeTypeTest.millisForHourLocal(0)
        var dayMillis : Long = TimeTypeTest.millisForHourLocal(12)
        Assertions.assertEquals(util.NIGHT, util.getNightOrDay(nightMillis))
        Assertions.assertEquals(util.DAY, util.getNightOrDay(dayMillis))
    }

    @Test
    @DisplayName("Boundary checks: 6 and 18 should be DAY for long-based API")
    def boundaries_day_for_long_based_api() : Unit = {
        var util : TimeTypeUtil = new TimeTypeUtil()

        {
            val array_N69008 = Array[Int](6, 18)
            var index_N69008 : Int = 0
            while (index_N69008 < array_N69008.length) {
                val h : Int = array_N69008(index_N69008)
                index_N69008 += 1
                var millis : Long = TimeTypeTest.millisForHourLocal(h)
                Assertions.assertFalse(util.isNight(millis))
                Assertions.assertEquals(util.DAY, util.getNightOrDay(millis))
            }
        }
    }

    @Test
    @DisplayName("Public constants NIGHT and DAY are accessible and stable")
    def constants_accessible_and_stable() : Unit = {
        var util : TimeTypeUtil = new TimeTypeUtil()
        Assertions.assertEquals("Night", util.NIGHT)
        Assertions.assertEquals("Day", util.DAY)
    }

    @Test
    @DisplayName("getInstance returns the same singleton instance")
    def getInstance_returns_same_singleton() : Unit = {
        var a : TimeTypeUtil = TimeTypeUtil.getInstance()
        var b : TimeTypeUtil = TimeTypeUtil.getInstance()
        Assertions.assertSame(a, b)
    }

}

object TimeTypeTest {
    private def millisForHourLocal(hour : Int) : Long = {
        //return ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();        
        var cal : Calendar = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, hour)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.getTimeInMillis()
    }

    class TestableTimeTypeUtil(param_hour : Int) extends TimeTypeUtil {

        private[TestableTimeTypeUtil] var hour : Int = 0

        //Constructor
        {
            val hour : Int = param_hour
            this.hour = hour
        }

        override def getHourOfDay() : Int = {
            return this.hour
        }

    }

}


