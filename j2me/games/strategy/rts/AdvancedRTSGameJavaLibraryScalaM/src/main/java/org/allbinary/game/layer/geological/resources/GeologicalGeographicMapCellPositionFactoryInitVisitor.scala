/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources

import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInitVisitorInterface

/**  *  * @author user  */
class GeologicalGeographicMapCellPositionFactoryInitVisitor extends GeographicMapCellPositionFactoryInitVisitorInterface {

    override def visit(tiledLayer : AllBinaryTiledLayer, cellPosition : GeographicMapCellPosition) : Unit = {
        val geologicalGeographicMapCellPosition : GeologicalGeographicMapCellPosition = (cellPosition.asInstanceOf[GeologicalGeographicMapCellPosition])
        geologicalGeographicMapCellPosition.getGeologicalResource().init()
    }

}


