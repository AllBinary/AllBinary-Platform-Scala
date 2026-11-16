/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker

/**  *  * @author User  */
class RTSLayer2SelectedLogHelper extends RTSLayer2LogHelper {
    import _root_.org.allbinary.game.layer.RTSLayer2SelectedLogHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val TRACK_TO_FIRE_OR_MOVE : String = "trackTo:fireOrMove"

    private val BUILDING_CHASE : String = "buildingChase"

    override def steeringUp(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Up").toString(), this, this.TRACK_TO_FIRE_OR_MOVE)
    }

    override def steeringFireOrStop(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Fire/All Stop").toString(), this, this.TRACK_TO_FIRE_OR_MOVE)
    }

    override def buildingAbove(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" Building Above").toString(), this, this.BUILDING_CHASE)
    }

    override def buildingChaseLeft(pathFindingLayerInterface : PathFindingLayerInterface, angle : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Going Left: ").appendint(angle).toString(), this, this.BUILDING_CHASE)
    }

    override def buildingChaseRight(pathFindingLayerInterface : PathFindingLayerInterface, angle : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Going Right: ").appendint(angle).toString(), this, this.BUILDING_CHASE)
    }

    override def buildingDown(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" Building Below").toString(), this, this.BUILDING_CHASE)
    }

    override def buildingChaseDown(pathFindingLayerInterface : PathFindingLayerInterface, angle : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Going Down: ").appendint(angle).toString(), this, this.BUILDING_CHASE)
    }

    override def buildingChaseUp(pathFindingLayerInterface : PathFindingLayerInterface, angle : Int) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" steering - Going Up: ").appendint(angle).toString(), this, this.BUILDING_CHASE)
    }

    def buildingLeft(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" Building Left").toString(), this, this.BUILDING_CHASE)
    }

    def buildingRight(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(" Building Right").toString(), this, this.BUILDING_CHASE)
    }

}

object RTSLayer2SelectedLogHelper {
    private val instanceC : RTSLayer2SelectedLogHelper = new RTSLayer2SelectedLogHelper()

    /**      * @return the instance      */
    def getInstance() : RTSLayer2SelectedLogHelper = {
        return RTSLayer2SelectedLogHelper.instanceC
    }

}


