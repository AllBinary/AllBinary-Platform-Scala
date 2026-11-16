/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.org.allbinary.logic.math.PrimitiveLongSingleton
import _root_.org.allbinary.logic.math.ScaleFactorFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

class BaseGameStatistics() {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(Integer.MAX_VALUE)

    private val updateDelayHelper : TimeDelayHelper = new TimeDelayHelper(2000)

    private var totalRefreshes : Long = 0L

    private var totalFrames : Long = 0L

    val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private val DEFAULT_SCALE_FACTOR : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_FACTOR

    val NOT : String = "Not enough Time to Calculate"

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    private val STRING_ARRAY : Array[String] = Array[String](" Total Time: ", this.EMPTY_STRING, " Total Frames: ", this.EMPTY_STRING, " Frames/10 Sec: ", this.EMPTY_STRING, " Total Paints: ", this.EMPTY_STRING, " Paints/10 Sec: ", this.EMPTY_STRING)

    private val SPACE_CHAR : Char = ' '

    private val PLUS_CHAR : Char = '+'

    private val X_CHAR : Char = 'X'

    private val CHAR_ARRAY : Array[Array[Char]] = Array[Array[Char]](Array[Char]('F', 'r', 'a', 'm', 'e', 's', '/', '1', '0', ' ', 'S', 'e', 'c', ':'), Array[Char]('X', 'X'), Array[Char]('P', 'a', 'i', 'n', 't', 's', '/', '1', '0', ' ', 'S', 'e', 'c', ':'), Array[Char]('X', 'X'))

    private val primitiveLongSingleton : PrimitiveLongSingleton = PrimitiveLongSingleton.getInstance()

    def init() : Unit = {
        this.timeDelayHelper.setStartTimeTNT()
        this.totalRefreshes = 0
        this.totalFrames = 0
    }

    def add(string : String) : Unit = {
    }

    // never really implemented
    def process() : Unit = {
    }

    def nextFrame() : Unit = {
        this.totalFrames += 1
    }

    def nextRefresh() : Unit = {
        this.totalRefreshes += 1
    }

    def getRefreshRate() : Short = {
        var elapsed : Long = this.timeDelayHelper.getElapsed(this.gameTickTimeDelayHelper.startTime)
        if (elapsed > 1) {
            val time : Short = (this.totalRefreshes / (elapsed >> this.DEFAULT_SCALE_FACTOR)).toShort
            return time
        } else {
            return 0
        }
        throw new IllegalStateException()
    }

    /*      * public static boolean shouldBuffer() { if ((totalRefreshes / 10 * 9) <      * totalFrames) { return false; } else { return true; } }      */
    def getTimeDelayHelper() : TimeDelayHelper = {
        return this.timeDelayHelper
    }

    def to2DCharArray() : Array[Array[Char]] = {
        var totalTime : Long = this.timeDelayHelper.getElapsed(this.gameTickTimeDelayHelper.startTime)
        totalTime = (totalTime >> this.DEFAULT_SCALE_FACTOR)
        if ((totalTime > 0) && this.updateDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            var framesPerSec : Int = (this.totalFrames / totalTime).toInt
            if (framesPerSec < 10) {
                this.CHAR_ARRAY(1)(0) = this.SPACE_CHAR
                this.CHAR_ARRAY(1)(1) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(framesPerSec)
            } else if (framesPerSec < 100) {
                var tens : Int = framesPerSec / 10
                var removeTens : Int = tens * 10
                this.CHAR_ARRAY(1)(0) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(tens)
                this.CHAR_ARRAY(1)(1) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(framesPerSec - removeTens)
            } else {
                this.CHAR_ARRAY(1)(0) = this.PLUS_CHAR
                this.CHAR_ARRAY(1)(1) = this.PLUS_CHAR
            }
            var refreshesPerSec : Int = (this.totalRefreshes / totalTime).toInt
            if (refreshesPerSec < 10) {
                this.CHAR_ARRAY(3)(0) = this.X_CHAR
                this.CHAR_ARRAY(3)(1) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(refreshesPerSec)
            } else if (refreshesPerSec < 100) {
                var tens : Int = refreshesPerSec / 10
                var removeTens : Int = tens * 10
                this.CHAR_ARRAY(3)(0) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(refreshesPerSec / 10)
                this.CHAR_ARRAY(3)(1) = this.primitiveLongSingleton.NUMBER_CHAR_ARRAY(refreshesPerSec - removeTens)
            } else {
                this.CHAR_ARRAY(3)(0) = this.PLUS_CHAR
                this.CHAR_ARRAY(3)(1) = this.PLUS_CHAR
            }
        }
        return this.CHAR_ARRAY
    }

    def toStringArray() : Array[String] = {
        var totalTime : Long = this.timeDelayHelper.getElapsed(this.gameTickTimeDelayHelper.startTime)
        totalTime = (totalTime / 10000)
        if (totalTime > 0) {
            this.STRING_ARRAY(1) = _root_.java.lang.Long.toString(totalTime)
            this.STRING_ARRAY(3) = _root_.java.lang.Long.toString(this.totalFrames)
            this.STRING_ARRAY(5) = _root_.java.lang.Long.toString(this.totalFrames / totalTime)
            this.STRING_ARRAY(7) = _root_.java.lang.Long.toString(this.totalRefreshes)
            this.STRING_ARRAY(9) = _root_.java.lang.Long.toString(this.totalRefreshes / totalTime)
        } else {
            var string : String = this.EMPTY_STRING
            this.STRING_ARRAY(1) = string
            this.STRING_ARRAY(3) = string
            this.STRING_ARRAY(5) = string
            this.STRING_ARRAY(7) = string
            this.STRING_ARRAY(9) = string
        }
        return this.STRING_ARRAY
    }

    def toStringAt(totalTime : Long) : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.STRING_ARRAY(0))
        stringBuffer.appendlong(totalTime)
        stringBuffer.append(this.STRING_ARRAY(2))
        stringBuffer.appendlong(this.totalFrames)
        stringBuffer.append(this.STRING_ARRAY(4))
        stringBuffer.appendlong(this.totalFrames / totalTime)
        if (this.totalRefreshes > 0) {
            stringBuffer.append(this.STRING_ARRAY(6))
            stringBuffer.appendlong(this.totalRefreshes)
            stringBuffer.append(this.STRING_ARRAY(8))
            stringBuffer.appendlong(this.totalRefreshes / totalTime)
            stringBuffer.append(CommonSeps.getInstance().NEW_LINE)
        }
        return stringBuffer.toString()
    }

    override def toString() : String = {
        var totalTime : Long = this.timeDelayHelper.getElapsed(this.gameTickTimeDelayHelper.startTime)
        totalTime = (totalTime / 1000)
        if (totalTime > 0) {
            return this.toStringAt(totalTime)
        } else {
            return this.NOT
        }
        throw new IllegalStateException()
    }

}


