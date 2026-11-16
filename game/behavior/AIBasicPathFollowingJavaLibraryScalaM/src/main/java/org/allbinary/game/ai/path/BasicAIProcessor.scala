/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ai.path

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapDirectionUtil
import _root_.org.allbinary.media.graphics.geography.pathfinding.GeographicMapCellPathHistoryInfo

class BasicAIProcessor(param_name : String, param_geographicMapCellHistory : GeographicMapCellHistory, param_geographicMapCellPathHistoryInfo : GeographicMapCellPathHistoryInfo, param_chosenPathList : BasicArrayList, param_angleInfo : AngleInfo, param_seed : Int) {

    private var name : String = null

    private var geographicMapCellHistory : GeographicMapCellHistory = null

    private var geographicMapCellPositionBasicArrayList : BasicArrayList = null

    private var geographicMapCellPathHistoryInfo : GeographicMapCellPathHistoryInfo = null

    private var basicAI : BasicDirectionAIHelper = null

    private val geographicMapDirectionUtil : GeographicMapDirectionUtil = GeographicMapDirectionUtil.getInstance()

    //private int MAX_SKIP;
    //Constructor
    {
        val name : String = param_name
        val geographicMapCellHistory : GeographicMapCellHistory = param_geographicMapCellHistory
        val geographicMapCellPathHistoryInfo : GeographicMapCellPathHistoryInfo = param_geographicMapCellPathHistoryInfo
        val chosenPathList : BasicArrayList = param_chosenPathList
        val angleInfo : AngleInfo = param_angleInfo
        val seed : Int = param_seed
        //For Kotlin - START
        this.name = name
        this.geographicMapCellHistory = geographicMapCellHistory
        this.geographicMapCellPositionBasicArrayList = chosenPathList
        this.geographicMapCellPathHistoryInfo = geographicMapCellPathHistoryInfo
        //For Kotlin - END
        this.setName(name)
        this.setNewPath(geographicMapCellHistory, chosenPathList)
        this.basicAI = new BasicDirectionAIHelper(this.getName(), angleInfo)
    }

    private def setNewPath(geographicMapCellHistory : GeographicMapCellHistory, chosenPathList : BasicArrayList) : Unit = {
        this.setGeographicMapCellHistory(geographicMapCellHistory)
        this.geographicMapCellPositionBasicArrayList = chosenPathList
        //MAX_SKIP = this.geographicMapCellPositionBasicArrayList.size()/12;
        this.init()
    }

    def init() : Unit = {
        this.geographicMapCellPathHistoryInfo = new GeographicMapCellPathHistoryInfo()
        this.geographicMapCellPathHistoryInfo.setPreviousOnPathGeographicMapCellPosition(this.geographicMapCellPositionBasicArrayList.get(this.geographicMapCellPositionBasicArrayList.size() - 1).asInstanceOf[GeographicMapCellPosition])
        this.geographicMapCellPathHistoryInfo.setNextOnPathGeographicMapCellPosition(this.geographicMapCellPositionBasicArrayList.get(this.geographicMapCellPositionBasicArrayList.size() - 1).asInstanceOf[GeographicMapCellPosition])
        this.update()
    }

    private def goTowardNextChosenOnPathPosition(currentGeographicMapCellPosition : GeographicMapCellPosition) : Int = {
        var keyDirection : Int = -1
        //this.logUtil.putF(this.getName() + " Off Path - Trying to get back on the path", this, this.commonStrings.PROCESS);
        var goToGeographicMapCellPosition : GeographicMapCellPosition = this.geographicMapCellPathHistoryInfo.getNextChosenOnPathGeographicMapCellPosition()
        var geographicMapDirectionData : Direction = this.geographicMapDirectionUtil.getDirectionFromCellPositionToAdjacentCellPosition(currentGeographicMapCellPosition, goToGeographicMapCellPosition)
        if (geographicMapDirectionData eq DirectionFactory.getInstance().NOT_BORDERED_WITH) {
            geographicMapDirectionData = this.geographicMapDirectionUtil.getDirectionFromCellPositionToCellPosition(currentGeographicMapCellPosition, goToGeographicMapCellPosition)
        }
        keyDirection = this.basicAI.getAIKeyPressedFromDirection(geographicMapDirectionData)
        /*       if(numberOfInterationsOffPath > 3)       {       this.logUtil.putF(this.getName() + " Off Path - for a while", this, this.commonStrings.PROCESS);       keyDirection = this.randomDirectionGenerator.get();       numberOfInterationsOffPath--;       }       else       {       numberOfInterationsOffPath++;       }        */
        return keyDirection
    }

    private def update() : Unit = {
        // int unvisitedIndex = this.geographicMapCellHistory.getFirstUnvisitedIndex();
        this.geographicMapCellPathHistoryInfo.setNextUnvisitedOnPathGeographicMapCellPosition(this.getGeographicMapCellHistory().getFirstUnvisited())
        /*       int index = this.geographicMapCellPositionBasicArrayList.indexOf(       currentGeographicMapCellPosition);              //Assumes the track is a loop       this.circularIndexUtil       if(index == this.geographicMapCellPositionBasicArrayList.size() - 1)       {       index = 0;       }       else       {       index++;       }              this.geographicMapCellPathHistoryInfo.setNextOnPathGeographicMapCellPosition(       (GeographicMapCellPosition)       this.geographicMapCellPositionBasicArrayList.get(index));        */
        this.geographicMapCellPathHistoryInfo.setNextChosenOnPathGeographicMapCellPosition(this.geographicMapCellPathHistoryInfo.getNextUnvisitedOnPathGeographicMapCellPosition())
    }

    def processAI(myManager : AllBinaryLayerManager, currentGeographicMapCellPosition : GeographicMapCellPosition) : Int = {
        var keyDirection : Int = -1
        if (this.geographicMapCellPositionBasicArrayList.contains(currentGeographicMapCellPosition)) {
            //numberOfInterationsOffPath = 0;
            this.update()
            keyDirection = this.goTowardNextChosenOnPathPosition(currentGeographicMapCellPosition)
            this.geographicMapCellPathHistoryInfo.setPreviousOnPathGeographicMapCellPosition(currentGeographicMapCellPosition)
        } else {
            keyDirection = this.goTowardNextChosenOnPathPosition(currentGeographicMapCellPosition)
        }
        return keyDirection
    }

    /*    GeographicMapCellPosition previousGeographicMapCellPosition =     this.geographicMapCellPathHistoryInfo.getPreviousGeographicMapCellPosition();        if(currentGeographicMapCellPosition != previousGeographicMapCellPosition)    {    //this.logUtil.putF(this.getName() + " currentGeographicMapCellPosition: " + currentGeographicMapCellPosition, this, this.commonStrings.PROCESS);        keyDirection = this.update(currentGeographicMapCellPosition);        this.geographicMapCellPathHistoryInfo.setPreviousGeographicMapCellPosition(    currentGeographicMapCellPosition);    }    else    {    keyDirection = this.goTowardLastOnPathPosition(    currentGeographicMapCellPosition);    }     */
    def getName() : String = {
        return this.name
    }

    def setName(name : String) : Unit = {
        this.name = name
    }

    def getGeographicMapCellPathHistoryInfo() : GeographicMapCellPathHistoryInfo = {
        return this.geographicMapCellPathHistoryInfo
    }

    def setGeographicMapCellPathHistoryInfo(geographicMapCellPathHistoryInfo : GeographicMapCellPathHistoryInfo) : Unit = {
        this.geographicMapCellPathHistoryInfo = geographicMapCellPathHistoryInfo
    }

    def getGeographicMapCellHistory() : GeographicMapCellHistory = {
        return this.geographicMapCellHistory
    }

    def setGeographicMapCellHistory(geographicMapCellHistory : GeographicMapCellHistory) : Unit = {
        this.geographicMapCellHistory = geographicMapCellHistory
    }

}


