/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerProcessor

class OptimizedGameInputLayerProcessorForCollidableLayer() extends LayerProcessor(new OptimizedGameInputLayerManager()) {

    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, index : Int) : Unit = {
        val gameInputInterface : AllBinaryGameLayer = layerInterface.asInstanceOf[AllBinaryGameLayer]
        //this.logUtil.putF(new StringMaker().append("processInput: ").append(layerInterface).toString(), this, gameInputStrings.PROCESS_INPUT);
        gameInputInterface.processInput(allBinaryLayerManager)
    }

    //private final String IS_PROCESSING_LAYER = "isProcessorLayer";
    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        //this.logUtil.putF(new StringMaker().append("isProcessorLayer: ").append(layerInterface).toString(), this, IS_PROCESSING_LAYER);
        if (layerInterface.implmentsGameInputInterface()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


