/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.layer.event.LayerManagerEvent
import _root_.org.allbinary.layer.event.LayerManagerEventHandler

class AllBinaryLayerManager() extends LayerManager(LayerManagerNoDebug.getInstance()) {

    //private final CommonLabels commonLabels = CommonLabels.getInstance();
    private val layerManagerEventHandler : LayerManagerEventHandler = LayerManagerEventHandler.getInstance()

    private val createLayerManagerEvent : LayerManagerEvent = new LayerManagerEvent(this, this.layerManagerEventHandler.CREATE)

    private val deleteLayerManagerEvent : LayerManagerEvent = new LayerManagerEvent(this, this.layerManagerEventHandler.DELETE)

    private var basicLayerProcessorArray : Array[LayerProcessor] = new Array[LayerProcessor](0)

    // private int damageIndex = -1;
    def getLayerProcessorArray() : Array[LayerProcessor] = {
        return this.basicLayerProcessorArray
    }

    // , int damageIndex
    def setLayerProcessorArray(layerProcessorArray : Array[LayerProcessor]) : Unit = {
        this.basicLayerProcessorArray = layerProcessorArray
    }

    final def log() : Unit = {
        //this.logUtil.putF(this.commonLabels.TOTAL_LABEL + this.getSize(), this, "log");
        var size : Int = this.basicLayerProcessorArray.length

        {
            var index : Int = 0
            while (index < size) {
                var layerProcessorInterface : LayerProcessor = this.basicLayerProcessorArray(index)
                index += 1
            }
        }
    }

    override def append(layerInterface : AllBinaryLayer) : Unit = {
        if (!this.contains(layerInterface)) {
            this.appendProcessors(layerInterface)
            super.append(layerInterface)
        }
    }

    override def appendAt(layerInterface : AllBinaryLayer, index : Int) : Unit = {
        if (!this.contains(layerInterface)) {
            this.appendProcessors(layerInterface)
            super.appendAt(layerInterface, index)
        }
    }

    private def appendProcessors(layerInterface : AllBinaryLayer) : Unit = {
        //this.logUtil.putF("Append: " + layerInterface, this, "appendProcessors");
        this.createLayerManagerEvent.setLayerInterface(layerInterface)
        this.layerManagerEventHandler.fireEvent(this.createLayerManagerEvent)
        var layerProcessorInterface : LayerProcessor = null
        //this.logUtil.putF("Total BasicLayerProcessors: " + this.basicLayerProcessorArray.length, this, "appendProcessors");

        {
            var index : Int = this.basicLayerProcessorArray.length
            while ({ index -= 1; index } >= 0) {
                layerProcessorInterface = this.basicLayerProcessorArray(index)
                //this.logUtil.putF("Processing BasicLayerProcessor: " + layerProcessorInterface.getClass().getName(), this, "appendProcessors");
                if (layerProcessorInterface.isProcessorLayer(layerInterface)) {
                    //this.logUtil.putF("Appending BasicLayerProcessor: " + layerProcessorInterface.getClass().getName(), this, "appendProcessors");
                    layerProcessorInterface.getLayerManager().append(layerInterface)
                }
            }
        }
    }

    override def remove(layerInterface : AllBinaryLayer) : Unit = this.synchronized {
        //this.logUtil.putF("Remove: " + layerInterface, this, "remove");
        this.deleteLayerManagerEvent.setLayerInterface(layerInterface)
        this.layerManagerEventHandler.fireDeleteEvent(this.deleteLayerManagerEvent)
        var layerProcessorInterface : LayerProcessor = null

        {
            var index : Int = this.basicLayerProcessorArray.length
            while ({ index -= 1; index } >= 0) {
                layerProcessorInterface = this.basicLayerProcessorArray(index)
                //this.logUtil.putF("Processing BasicLayerProcessor: " + layerProcessorInterface.getClass().getName(), this, "processGame");
                layerProcessorInterface.getLayerManager().remove(layerInterface)
            }
        }
        super.remove(layerInterface)
    }

    def process() : Unit = {
        var layerProcessorInterface : LayerProcessor = null
        var size : Int = this.basicLayerProcessorArray.length
        //this.logUtil.putF(this.commonStrings.START + size, this, this.commonStrings.PROCESS);

        {
            var index : Int = 0
            while (index < size) {
                layerProcessorInterface = this.basicLayerProcessorArray(index)
                // if(index != damageIndex)
                layerProcessorInterface.process(this)
                index += 1
            }
        }
    }

    override def cleanup() : Unit = {
        //PrelogUtil.putF(new Integer(this.getSize()).toString(), this, this.commonStrings.CLEANUP);
        var layerProcessorInterface : LayerProcessor = null
        var size : Int = this.basicLayerProcessorArray.length

        {
            var index : Int = 0
            while (index < size) {
                layerProcessorInterface = this.basicLayerProcessorArray(index)
                layerProcessorInterface.getLayerManager().cleanup()
                index += 1
            }
        }
        super.cleanup()
    }

}


