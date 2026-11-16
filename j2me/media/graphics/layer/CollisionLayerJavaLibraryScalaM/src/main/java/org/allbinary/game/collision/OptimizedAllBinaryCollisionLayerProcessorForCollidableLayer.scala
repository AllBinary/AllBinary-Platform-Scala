/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerManager
import _root_.org.allbinary.layer.LayerProcessor

class OptimizedAllBinaryCollisionLayerProcessorForCollidableLayer() extends LayerProcessor(new OptimizedAllBinaryCollisionLayerManager()) {

    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, startIndex : Int) : Unit = {
        // no physics here - just destroy them
        var collidableInterfaceCompositeInterface : CollidableCompositeLayer = layerInterface.asInstanceOf[CollidableCompositeLayer]
        var collidableBase : CollidableBaseBehavior = collidableInterfaceCompositeInterface.getCollidableInferface()
        //this.logUtil.putF(collidableInterfaceCompositeInterface.toString(), this, this.commonStrings.START);
        if (collidableBase.isCollidable(collidableInterfaceCompositeInterface)) {
            val layerManager : LayerManager = this.getLayerManager()
            val size : Int = layerManager.getSize()
            var collidableInterfaceCompositeInterface2 : CollidableCompositeLayer = null
            var collidableBase2 : CollidableBaseBehavior = null
            //this.logUtil.putF("startIndex: " + startIndex + CommonSeps.getInstance().SPACE + CommonLabels.getInstance().TOTAL_LABEL + size, this, this.commonStrings.PROCESS);

            {
                var index : Int = startIndex + 1
                while (index < size) {
                    collidableInterfaceCompositeInterface2 = layerManager.getLayerAt(index).asInstanceOf[CollidableCompositeLayer]
                    collidableBase2 = collidableInterfaceCompositeInterface2.getCollidableInferface()
                    //this.logUtil.putF(collidableInterfaceCompositeInterface2.toString(), this, this.commonStrings.PROCESS);
                    if (collidableBase2.isCollidable(collidableInterfaceCompositeInterface) && collidableBase.isCollision(collidableInterfaceCompositeInterface, collidableInterfaceCompositeInterface2)) {
                        collidableBase.collide(collidableInterfaceCompositeInterface, collidableInterfaceCompositeInterface2)
                        collidableBase2.collide(collidableInterfaceCompositeInterface2, collidableInterfaceCompositeInterface)
                    }
                    index += 1
                }
            }
        }
    }

    //private final String IS_PROCESSING_LAYER = "isProcessorLayer";
    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        //this.logUtil.putF(layerInterface.toString(), this, IS_PROCESSING_LAYER);
        if (layerInterface.implmentsCollidableInterface()) {
            //this.logUtil.putF("implmentsCollidableInterface - true: " + layerInterface.toString(), this, IS_PROCESSING_LAYER);
            return true
        } else {
            //this.logUtil.putF("implmentsCollidableInterface - false: " + layerInterface.toString(), this, IS_PROCESSING_LAYER);
            return false
        }
        throw new IllegalStateException()
    }

}


