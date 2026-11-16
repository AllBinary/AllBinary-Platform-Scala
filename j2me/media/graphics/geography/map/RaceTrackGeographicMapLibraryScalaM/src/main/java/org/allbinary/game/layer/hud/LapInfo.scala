/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud

import _root_.org.allbinary.logic.string.StringMaker

class LapInfo(param_totalLaps : Int) {
    import _root_.org.allbinary.game.layer.hud.LapInfo.{*}

    private var numberOfLaps : Int = 0

    private var totalLaps : Int = 0

    //Constructor
    {
        val totalLaps : Int = param_totalLaps
        this.totalLaps = totalLaps
        this.numberOfLaps = 1
    }

    def add() : Unit = {
        this.numberOfLaps += 1
    }

    def getCurrentLap() : Int = {
        return this.numberOfLaps
    }

    def getTotalLaps() : Int = {
        return this.totalLaps
    }

    def isDone() : Boolean = {
        if (this.numberOfLaps >= this.totalLaps) {
            return true
        }
        return false
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("isDone: ")
        stringBuffer.appendboolean(this.isDone())
        stringBuffer.append(" CurrentLap: ")
        stringBuffer.appendint(this.getCurrentLap())
        stringBuffer.append(" Total Laps: ")
        stringBuffer.appendint(this.getTotalLaps())
        return stringBuffer.toString()
    }

}

object LapInfo {
    var NULL_LAP_INFO : LapInfo = new LapInfo(-1)

}


