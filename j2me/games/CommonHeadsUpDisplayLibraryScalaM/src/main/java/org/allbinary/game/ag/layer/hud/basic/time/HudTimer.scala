/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.time

import _root_.org.allbinary.logic.math.PrimitiveLongSingleton
import _root_.org.allbinary.logic.math.PrimitiveLongUtil
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory

class HudTimer(param_maxTime : Int) {

    private var startTime : Long = -1

    private var hundredthTime : Long = 0L

    private var maxTime : Long = 0L

    private var modifier : Long = 0L

    // PrimitiveLongUtil.NUMBER_STRING_ARRAY[0];
    private var hundrethsString : Array[Char] = PrimitiveLongSingleton.getInstance().ZERO

    private var totalDigits : Int = 1

    private var primitiveLongUtil : PrimitiveLongUtil = null

    private val MAX : Array[Char] = Array[Char]('L', 'O', 'L')

    //String MAX = "LOL";
    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    //Constructor
    {
        val maxTime : Int = param_maxTime
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(maxTime)
        this.maxTime = maxTime.toLong
    }

    def start() : Unit = {
        this.hundredthTime = 0
        this.startTime = this.gameTickTimeDelayHelper.startTime
    }

    def get() : Long = {
        return this.hundredthTime
    }

    /*      * public void add(long score) { this.set(this.time + score); }      */
    def update() : Unit = {
        var lastLowerTime : Long = this.hundredthTime
        var currentTime : Long = ((this.modifier + this.gameTickTimeDelayHelper.startTime) - this.startTime)
        if (currentTime < 0) {
            currentTime = 0
        }
        this.hundredthTime = currentTime / 100
        if (this.hundredthTime >= this.maxTime) {
            if (this.startTime > 0) {
                this.hundrethsString = this.MAX
            }
        } else if (lastLowerTime != this.hundredthTime) {
            // this.get());
            this.hundrethsString = this.primitiveLongUtil.getCharArray(this.hundredthTime.toInt)
            this.totalDigits = this.primitiveLongUtil.getCurrentTotalDigits()
        }
    }

    def reduce(value : Int) : Unit = {
        this.modifier -= value
    }

    def add(value : Int) : Unit = {
        this.modifier += value
    }

    /*      * public String toString() { return this.hundrethsString; }      */
    def getTimeChars() : Array[Char] = {
        return this.hundrethsString
    }

    def getCurrentTotalDigits() : Int = {
        return this.totalDigits
    }

}


