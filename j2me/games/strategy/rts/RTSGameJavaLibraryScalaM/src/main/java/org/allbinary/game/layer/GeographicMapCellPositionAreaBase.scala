/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
class GeographicMapCellPositionAreaBase extends GeographicMapCellPositionAreaInterface {
    import _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase.{NULL_GEOGRPAHIC_MAP_POSITION_AREA_BASE as _, *}
    def NULL_GEOGRPAHIC_MAP_POSITION_AREA_BASE : GeographicMapCellPositionAreaBase = _root_.org.allbinary.game.layer.GeographicMapCellPositionAreaBase.NULL_GEOGRPAHIC_MAP_POSITION_AREA_BASE

    override def getNextSurroundingGeographicMapCellPosition() : GeographicMapCellPosition = {
        throw new RuntimeException()
    }

    override def getOccupyingGeographicMapCellPositionList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def getSurroundingGeographicMapCellPositionList() : BasicArrayList = {
        throw new RuntimeException()
    }

    override def update(geographicMapInterface : BasicGeographicMap) : Unit = {
        throw new RuntimeException()
    }

}

object GeographicMapCellPositionAreaBase {
    val NULL_GEOGRPAHIC_MAP_POSITION_AREA_BASE : GeographicMapCellPositionAreaBase = new GeographicMapCellPositionAreaBase()

}


