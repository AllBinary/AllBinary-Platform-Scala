/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author user  */
class CollisionHelper(param_sourceLayerInterface : AllBinaryLayer) {

    var sourceLayerInterface : AllBinaryLayer = null

    //Constructor
    {
        val sourceLayerInterface : AllBinaryLayer = param_sourceLayerInterface
        this.sourceLayerInterface = sourceLayerInterface
    }

    def isCollidable(layerInterface : CollidableCompositeLayer) : Boolean = {
        return true
    }

    /**     * @return the sourceLayerInterface     */
    def getOwnerLayerInterface() : AllBinaryLayer = {
        return this.sourceLayerInterface
    }

    /**     * @param sourceLayerInterface the sourceLayerInterface to set     */
    def setOwnerLayerInterface(sourceLayerInterface : AllBinaryLayer) : Unit = {
        this.sourceLayerInterface = sourceLayerInterface
    }

}


