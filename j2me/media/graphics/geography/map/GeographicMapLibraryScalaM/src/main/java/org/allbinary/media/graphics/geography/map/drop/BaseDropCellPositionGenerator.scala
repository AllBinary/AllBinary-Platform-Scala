/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.drop

import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap

class BaseDropCellPositionGenerator extends DropCellPositionGeneratorInterface {

    /* (non-Javadoc)      * @see allbinary.media.graphics.geography.map.racetrack.drop.DropCellPositionGeneratorInterface#getName()      */
    override def getName() : String = {
        return this.getClass().getName()
    }

    override def update(allBinaryGameLayerManager : AllBinaryGameLayerManager, geographicMapInterface : BasicGeographicMap) : Unit = {
    }

    override def isDropAllowedAt(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        return true
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
    }

}


