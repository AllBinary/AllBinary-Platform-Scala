/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.time

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels

class TimeDelayHelper(param_delay : Int) {

    private var startTime : Long = -1

    private var elapsedTimeAtPause : Long = _root_.java.lang.Long.MIN_VALUE

    var delay : Int = 0

    //Constructor
    {
        val delay : Int = param_delay
        this.delay = delay
        this.setStartTimeTNT()
    }

    def isTimeTNT() : Boolean = {
        var currentTime : Long = System.currentTimeMillis()
        if ((currentTime - this.startTime) > this.delay) {
            this.startTime = currentTime
            return true
        }
        return false
    }

    def isTimeSinceTNT(delay : Int) : Boolean = {
        var currentTime : Long = System.currentTimeMillis()
        if ((currentTime - this.startTime) > delay) {
            this.startTime = currentTime
            return true
        }
        return false
    }

    def isTime(currentTime : Long) : Boolean = {
        if ((currentTime - this.startTime) > this.delay) {
            this.startTime = currentTime
            return true
        }
        return false
    }

    def isTimeWithoutReset(currentTime : Long) : Boolean = {
        if ((currentTime - this.startTime) > this.delay) {
            return true
        }
        return false
    }

    def isTimeSince(delay : Int, currentTime : Long) : Boolean = {
        if ((currentTime - this.startTime) > this.delay) {
            this.startTime = currentTime
            return true
        }
        return false
    }

    def getElapsedTNT() : Long = {
        return System.currentTimeMillis() - this.startTime
    }

    def getElapsed(currentTime : Long) : Long = {
        return currentTime - this.startTime
    }

    def isElapsed(currentTime : Long, time : Long) : Boolean = {
        if (this.getElapsed(currentTime) > time) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isElapsedTNT(time : Long) : Boolean = {
        if (this.getElapsedTNT() > time) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def setStartTime(startTime : Long) : Unit = {
        this.startTime = startTime
    }

    def getStartTime() : Long = {
        return this.startTime
    }

    def setStartTimeTNT() : Unit = {
        this.startTime = System.currentTimeMillis()
    }

    def pause() : Unit = {
        this.elapsedTimeAtPause = this.getElapsedTNT()
        this.startTime = _root_.java.lang.Long.MAX_VALUE
    }

    def resume() : Boolean = {
        if (this.elapsedTimeAtPause != _root_.java.lang.Long.MIN_VALUE) {
            this.startTime = System.currentTimeMillis() + this.elapsedTimeAtPause
            this.elapsedTimeAtPause = _root_.java.lang.Long.MIN_VALUE
            this.setStartTimeTNT()
            return true
        }
        return false
    }

    def toStringAt(currentTime : Long) : String = {
        var elapsed : Long = this.getElapsed(currentTime)
        if (elapsed > 0) {
            val commonLabels : CommonLabels = CommonLabels.getInstance()
            val elapsedAsString : String = _root_.java.lang.Long.toString(elapsed)
            return new StringMaker().append(commonLabels.START).appendlong(this.startTime).append(commonLabels.CURRENT).appendlong(currentTime).append(commonLabels.ELAPSED).append(elapsedAsString).toString()
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        var currentTime : Long = System.currentTimeMillis()
        var elapsed : Long = this.getElapsed(currentTime)
        if (elapsed > 0) {
            val commonLabels : CommonLabels = CommonLabels.getInstance()
            val elapsedAsString : String = _root_.java.lang.Long.toString(elapsed)
            return new StringMaker().append(commonLabels.START).appendlong(this.startTime).append(commonLabels.CURRENT).appendlong(currentTime).append(commonLabels.ELAPSED).append(elapsedAsString).toString()
        } else {
            return StringUtil.getInstance().EMPTY_STRING
        }
        throw new IllegalStateException()
    }

}


