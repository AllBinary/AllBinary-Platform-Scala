/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.PathFindingLayerInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker

/**  *  * @author User  */
class WaypointRunnableSelectedLogHelper extends WaypointRunnableLogHelper {
    import _root_.org.allbinary.game.layer.waypoint.WaypointRunnableSelectedLogHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    override def start(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(this.commonStrings.START_RUNNABLE).toString(), this, this.commonStrings.RUN)
    }

    override def end(pathFindingLayerInterface : PathFindingLayerInterface) : Unit = {
        this.logUtil.putF(new StringMaker().append(pathFindingLayerInterface.getName()).append(this.commonStrings.END_RUNNABLE).toString(), this, this.commonStrings.RUN)
    }

}

object WaypointRunnableSelectedLogHelper {
    private val instanceC : WaypointRunnableSelectedLogHelper = new WaypointRunnableSelectedLogHelper()

    /**      * @return the instance      */
    def getInstance() : WaypointRunnableSelectedLogHelper = {
        return WaypointRunnableSelectedLogHelper.instanceC
    }

}


