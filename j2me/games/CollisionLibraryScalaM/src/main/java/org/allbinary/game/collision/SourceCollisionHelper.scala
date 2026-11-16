/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author user  */
class SourceCollisionHelper(param_layerInterface : AllBinaryLayer) extends CollisionHelper(param_layerInterface) {

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
    }

    //LayerInterface
    override def isCollidable(layerInterface : CollidableCompositeLayer) : Boolean = {
        if (this.sourceLayerInterface ne layerInterface) {
            return true
        }
        return false
    }

}


