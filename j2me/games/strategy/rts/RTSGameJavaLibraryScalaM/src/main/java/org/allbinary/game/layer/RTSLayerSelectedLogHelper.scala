/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.AngleInfo
import _root_.org.allbinary.math.NamedAngle
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class RTSLayerSelectedLogHelper extends RTSLayerLogHelper {
    import _root_.org.allbinary.game.layer.RTSLayerSelectedLogHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val positionStrings : PositionStrings = PositionStrings.getInstance()

    private val TRACKTO_TURNTO : String = "trackTo:turnTo"

    override def setClosestGeographicMapCellHistory(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, pathsList : BasicArrayList) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(CommonLabels.getInstance().START)
        stringBuffer.appendint(pathsList.size())
        stringBuffer.append(" -> ")
        stringBuffer.append(StringUtil.getInstance().toString(pathsList))
        this.logUtil.putF(stringBuffer.toString(), this, "selected: setClosestGeographicMapCellHistory")
    }

    override def trackTo(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, nextUnvisitedPathGeographicMapCellPosition : GeographicMapCellPosition, dx : Int, dy : Int, reason : String) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(StringUtil.getInstance().toString(nextUnvisitedPathGeographicMapCellPosition))
        stringBuffer.append(this.positionStrings.DX_LABEL)
        stringBuffer.appendint(dx)
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.positionStrings.DY_LABEL)
        stringBuffer.appendint(dy)
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(reason)
        this.logUtil.putF(stringBuffer.toString(), this, "selected: trackTo")
    }

    override def turnTo(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, dx : Int, dy : Int, angleInfo : AngleInfo, angle : Int, movementAngle : NamedAngle, evading : Boolean, targetAngle : Int) : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(associatedAdvancedRTSGameLayer.getName())
        stringBuffer.append(" steering - ")
        //            stringBuffer.append(angleOfTarget2);
        stringBuffer.append(this.positionStrings.DX_LABEL)
        stringBuffer.appendint(dx)
        stringBuffer.append(this.commonSeps.SPACE)
        stringBuffer.append(this.positionStrings.DY_LABEL)
        stringBuffer.appendint(dy)
        stringBuffer.append(" angle: ")
        stringBuffer.appendint(angle)
        stringBuffer.append(" movementAngle: ")
        stringBuffer.append(movementAngle.name)
        stringBuffer.append(this.commonSeps.FORWARD_SLASH)
        stringBuffer.appendshort(movementAngle.getValue())
        if (angleInfo != null) {
            val angleIncrement : Short = angleInfo.getAngleIncrementInfo().getAngleIncrement()
            stringBuffer.append(" angleIncrement: ")
            stringBuffer.appendshort(angleIncrement)
        }
        stringBuffer.append(" Evading: ")
        stringBuffer.appendboolean(evading)
        this.logUtil.putF(stringBuffer.toString(), this, this.TRACKTO_TURNTO)
    }

    override def doneMoving(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - done moving 0,0").toString(), this, this.TRACKTO_TURNTO)
    }

    override def closeEnough(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - close enough").toString(), this, this.TRACKTO_TURNTO)
    }

    override def movingLeft(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - allow movingLeft").toString(), this, this.TRACKTO_TURNTO)
    }

    override def movingRight(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - allow movingRight").toString(), this, this.TRACKTO_TURNTO)
    }

    override def movingUp(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - allow movingUp").toString(), this, this.TRACKTO_TURNTO)
    }

    override def movingDown(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - allow movingDown").toString(), this, this.TRACKTO_TURNTO)
    }

    override def currentMoveEnded(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - correct angle, but movement not needed for current deltas so reseting movement angle").toString(), this, this.TRACKTO_TURNTO)
    }

    override def evade(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - evade").toString(), this, this.TRACKTO_TURNTO)
    }

    override def rotateLeft(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - rotating left").toString(), this, this.TRACKTO_TURNTO)
    }

    override def rotateRight(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - rotating right").toString(), this, this.TRACKTO_TURNTO)
    }

    override def handle(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, movementAngle : NamedAngle) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - movementAngle: ").append(movementAngle.name).append(this.commonSeps.FORWARD_SLASH).appendshort(movementAngle.getValue()).toString(), this, this.TRACKTO_TURNTO)
    }

    override def noRotation(associatedAdvancedRTSGameLayer : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(" steering - Do not rotate").toString(), this, this.TRACKTO_TURNTO)
    }

    override def notOnPath(associatedAdvancedRTSGameLayer : PathFindingLayerInterface, geographicMapCellHistory : GeographicMapCellHistory, currentGeographicMapCellPosition : GeographicMapCellPosition, pathList : BasicArrayList) : Unit = {
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.logUtil.putF(new StringMaker().append(associatedAdvancedRTSGameLayer.getName()).append(CommonSeps.getInstance().SPACE).appendint(geographicMapCellHistory.getTotalVisited()).append(CommonSeps.getInstance().SPACE).append(stringUtil.toString(currentGeographicMapCellPosition)).append(" - trying to move but not on path: ").append(stringUtil.toString(pathList)).toString(), this, "turnTo")
    }

}

object RTSLayerSelectedLogHelper {
    private val instanceC : RTSLayerSelectedLogHelper = new RTSLayerSelectedLogHelper()

    /**      * @return the instance      */
    def getInstance() : RTSLayerSelectedLogHelper = {
        return RTSLayerSelectedLogHelper.instanceC
    }

}


