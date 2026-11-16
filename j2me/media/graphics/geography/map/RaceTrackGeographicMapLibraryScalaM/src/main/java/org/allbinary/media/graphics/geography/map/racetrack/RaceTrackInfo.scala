/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.graphics.color.BasicColor

class RaceTrackInfo(param_id : Integer, param_name : String, param_raceTrackFrictionProperties : RaceTrackFrictionProperties, param_foregroundBasicColor : BasicColor, param_backgroundBasicColor : BasicColor, param_qualifyTime : Int, param_worstContinuePosition : Int, param_totalLaps : Int) {

    private var id : Integer = null

    private var name : String = null

    private var raceTrackFrictionProperties : RaceTrackFrictionProperties = null

    private var foregroundBasicColor : BasicColor = null

    private var backgroundBasicColor : BasicColor = null

    private var qualifyTime : Int = 0

    private var worstContinuePosition : Int = 0

    private var totalLaps : Int = 0

    //Constructor
    {
        val id : Integer = param_id
        val name : String = param_name
        val raceTrackFrictionProperties : RaceTrackFrictionProperties = param_raceTrackFrictionProperties
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val qualifyTime : Int = param_qualifyTime
        val worstContinuePosition : Int = param_worstContinuePosition
        val totalLaps : Int = param_totalLaps
        this.id = id
        this.name = name
        this.raceTrackFrictionProperties = raceTrackFrictionProperties
        this.backgroundBasicColor = backgroundBasicColor
        this.foregroundBasicColor = foregroundBasicColor
        this.qualifyTime = qualifyTime
        this.worstContinuePosition = worstContinuePosition
        this.totalLaps = totalLaps
    }

    def getId() : Integer = {
        return this.id
    }

    private def setId(id : Integer) : Unit = {
        this.id = id
    }

    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getQualifyTime() : Int = {
        return this.qualifyTime
    }

    def setQualifyTime(qualifyTime : Int) : Unit = {
        this.qualifyTime = qualifyTime
    }

    def getWorstContinuePosition() : Int = {
        return this.worstContinuePosition
    }

    def setWorstContinuePosition(worstContinuePosition : Int) : Unit = {
        this.worstContinuePosition = worstContinuePosition
    }

    def getTotalLaps() : Int = {
        return this.totalLaps
    }

    def setTotalLaps(totalLaps : Int) : Unit = {
        this.totalLaps = totalLaps
    }

    def getForegroundBasicColor() : BasicColor = {
        return this.foregroundBasicColor
    }

    def setForegroundBasicColor(foregroundBasicColor : BasicColor) : Unit = {
        this.foregroundBasicColor = foregroundBasicColor
    }

    def getBackgroundBasicColor() : BasicColor = {
        return this.backgroundBasicColor
    }

    def setBackgroundBasicColor(backgroundBasicColor : BasicColor) : Unit = {
        this.backgroundBasicColor = backgroundBasicColor
    }

    def getRaceTrackFrictionProperties() : RaceTrackFrictionProperties = {
        return this.raceTrackFrictionProperties
    }

    def setRaceTrackFrictionProperties(raceTrackFrictionProperties : RaceTrackFrictionProperties) : Unit = {
        this.raceTrackFrictionProperties = raceTrackFrictionProperties
    }

}


