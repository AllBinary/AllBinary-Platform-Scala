/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.direction.DirectionFactory

class LayerPlacementTypeFactory {
    import _root_.org.allbinary.game.layer.LayerPlacementTypeFactory.{*}

    val MAP : LayerPlacementType = new LayerPlacementType(Integer.MAX_VALUE)

    val LEFT : LayerPlacementType = new LayerPlacementType(DirectionFactory.getInstance().LEFT.getValue())

    val DOWN : LayerPlacementType = new LayerPlacementType(DirectionFactory.getInstance().DOWN.getValue())

    val UP : LayerPlacementType = new LayerPlacementType(DirectionFactory.getInstance().UP.getValue())

    val RIGHT : LayerPlacementType = new LayerPlacementType(DirectionFactory.getInstance().RIGHT.getValue())

}

object LayerPlacementTypeFactory {
    private val instance : LayerPlacementTypeFactory = new LayerPlacementTypeFactory()

    def getInstance() : LayerPlacementTypeFactory = {
        return LayerPlacementTypeFactory.instance
    }

}


