/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.string.CommonStrings

class LayerProcessor(param_layerManager : LayerManager) extends LayerProcessorInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var layerManager : LayerManager = null

    //Constructor
    {
        val layerManager : LayerManager = param_layerManager
        this.layerManager = layerManager
    }

    /*     public LayerProcessor(LayerManager layerManager)     {         this.setLayerManager(layerManager);     }     */
    override def processAt(allBinaryLayerManager : AllBinaryLayerManager, layerInterface : AllBinaryLayer, index : Int) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def isProcessorLayer(layerInterface : AllBinaryLayer) : Boolean = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def getLayerManager() : LayerManager = {
        return this.layerManager
    }

    override def process(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var layerManager : LayerManager = this.getLayerManager()
        var size : Int = layerManager.getSize()

        {
            var index : Int = 0
            while (index < size) {
                //this.logUtil.putF(this.commonStrings.TOTAL_LABEL + layerManager.getSize(), this, this.commonStrings.PROCESS);
                this.processAt(allBinaryLayerManager, layerManager.getLayerAt(index).asInstanceOf[AllBinaryLayer], index)
                index += 1
            }
        }
    }

}


