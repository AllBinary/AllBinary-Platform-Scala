/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision.layer

import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerProcessor

class CollidableInterfaceLayerProcessor() extends LayerProcessor(new CollidableInterfaceLayerManager()) {

    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, index : Int) : Unit = {
        //no physics here - just destroy them
        var collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface = layerInterface.asInstanceOf[CollidableInterfaceCompositeInterface]
        if (collidableInterfaceCompositeInterface.getCollidableInferface().isCollidable(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer])) {
            AllBinaryCollisionManager.getInstance().process(this.getLayerManager(), collidableInterfaceCompositeInterface, index)
        }
    }

    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        if (layerInterface.implmentsCollidableInterface()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


