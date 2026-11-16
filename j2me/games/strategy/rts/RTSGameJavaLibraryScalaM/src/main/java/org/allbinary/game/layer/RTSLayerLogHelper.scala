/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.math.NamedAngle
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class RTSLayerLogHelper {
    import _root_.org.allbinary.game.layer.RTSLayerLogHelper.{*}

    def setClosestGeographicMapCellHistory(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, pathsList : BasicArrayList) : Unit = {
    }

    def trackTo(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition, dx : Int, dy : Int, reason : String) : Unit = {
    }

    def turnTo(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int, angleInfo : AngleInfo, angle : Int, movementAngle : NamedAngle, evading : Boolean, targetAngle : Int) : Unit = {
    }

    def doneMoving(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def closeEnough(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def movingLeft(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def movingRight(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def movingUp(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def movingDown(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def currentMoveEnded(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def evade(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def rotateLeft(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def rotateRight(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def handle(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, movementAngle : NamedAngle) : Unit = {
    }

    def noRotation(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
    }

    def notOnPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, geographicMapCellHistory : GeographicMapCellHistory, currentGeographicMapCellPosition : GeographicMapCellPosition, pathList : BasicArrayList) : Unit = {
    }

}

object RTSLayerLogHelper {
    private val instance : RTSLayerLogHelper = new RTSLayerLogHelper()

    /**      * @return the instance      */
    def getInstance() : RTSLayerLogHelper = {
        return RTSLayerLogHelper.instance
    }

}


