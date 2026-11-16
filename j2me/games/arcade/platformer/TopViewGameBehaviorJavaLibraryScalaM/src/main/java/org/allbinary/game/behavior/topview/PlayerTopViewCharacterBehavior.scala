/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.tracking.TrackingEventCircularStaticPool
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *  * @author User  */
class PlayerTopViewCharacterBehavior extends TopViewCharacterBehavior {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def terrainEvent(layer : AllBinaryLayer, direction : Direction, x : Int, y : Int, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        TrackingEventHandler.getInstance().fireEvent(TrackingEventCircularStaticPool.getInstance().getNextInstance(layer))
    }

    override def terrainMove(layer : AllBinaryLayer, geographicMapInterfaceArray : Array[BasicGeographicMap], x : Int, y : Int) : Unit = {
        //final DisplayInfoSingleton displayInfo = DisplayInfoSingleton.getInstance();
        val basicGeographicMapUtil : BasicGeographicMapUtil = BasicGeographicMapUtil.getInstance()
        //basicGeographicMapUtil.move(geographicMapInterfaceArray, -x, -y);
        basicGeographicMapUtil.setPosition(geographicMapInterfaceArray, x, y)
    }

    private def moveIfOnScreen(layer : AllBinaryLayer, ax : Int, ay : Int) : Unit = {
    }

    private def isTiledLayerMoveable(terrainTiledLayer : AllBinaryTiledLayer, x : Int, y : Int) : Boolean = {
        return (((terrainTiledLayer.getXP() + DisplayInfoSingleton.getInstance().getLastWidth()) < terrainTiledLayer.getWidth()) || (x < 0)) && ((terrainTiledLayer.getXP() > 0) || (x > 0))
    }

}


