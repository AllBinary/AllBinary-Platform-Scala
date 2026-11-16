/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy

import _root_.org.allbinary.game.layer.CollidableCompositeLayer

class DestroyableSimpleBehavior(param_ownerLayer : CollidableCompositeLayer) extends DestroyableBaseBehavior {

    var ownerLayer : CollidableCompositeLayer = null

    private var destroyed : Boolean = false

    //Constructor
    {
        val ownerLayer : CollidableCompositeLayer = param_ownerLayer
        this.ownerLayer = ownerLayer
    }

    override def isDestroyed() : Boolean = {
        return this.destroyed
    }

    override def setDestroyed(destroyed : Boolean) : Unit = {
        this.destroyed = destroyed
        if (this.isDestroyed()) {
            DestroyedLayerProcessor.getInstance().add(this.ownerLayer)
        }
    }

}


