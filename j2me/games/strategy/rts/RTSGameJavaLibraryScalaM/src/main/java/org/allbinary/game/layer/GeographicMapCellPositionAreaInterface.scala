/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author User  */
trait GeographicMapCellPositionAreaInterface {

    def getNextSurroundingGeographicMapCellPosition() : GeographicMapCellPosition

    /**      * @return the occupyingGeographicMapCellPositionList      */
    def getOccupyingGeographicMapCellPositionList() : BasicArrayList

    /**      * @return the surroundingGeographicMapCellPositionList      */
    def getSurroundingGeographicMapCellPositionList() : BasicArrayList

    def update(geographicMapInterface : BasicGeographicMap) : Unit

}


