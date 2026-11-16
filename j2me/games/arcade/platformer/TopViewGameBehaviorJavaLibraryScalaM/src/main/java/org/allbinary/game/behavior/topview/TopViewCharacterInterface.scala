/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType

/**  *  * @author User  */
trait TopViewCharacterInterface {

    def terrainMove(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], x : Int, y : Int) : Unit

    def terrainEvent(x : Int, y : Int, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition) : Unit

    def move() : Unit

    def upp() : Unit

    def leftp() : Unit

    def rightp() : Unit

    def reset() : Unit

}


