/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.pickup

import _root_.org.allbinary.logic.string.StringUtil

class PickedUpLayerTypeFactory {
    import _root_.org.allbinary.game.layer.pickup.PickedUpLayerTypeFactory.{*}

    var NONE : PickedUpLayerType = new PickedUpLayerType(StringUtil.getInstance().NULL_STRING)

    var BEAM : PickedUpLayerType = new PickedUpLayerType("BEAM")

    var MINE : PickedUpLayerType = new PickedUpLayerType("MINE")

    var PROJECTILE : PickedUpLayerType = new PickedUpLayerType("PROJECTILE")

    var ENHANCEMENT : PickedUpLayerType = new PickedUpLayerType("Enhancement")

    var MORPH : PickedUpLayerType = new PickedUpLayerType("Morph")

    var PART : PickedUpLayerType = new PickedUpLayerType("Part")

    var HEAL : PickedUpLayerType = new PickedUpLayerType("Heal")

    var LIFE : PickedUpLayerType = new PickedUpLayerType("Life")

    var POINTS : PickedUpLayerType = new PickedUpLayerType("Points")

}

object PickedUpLayerTypeFactory {
    private val instance : PickedUpLayerTypeFactory = new PickedUpLayerTypeFactory()

    def getInstance() : PickedUpLayerTypeFactory = {
        return PickedUpLayerTypeFactory.instance
    }

}


