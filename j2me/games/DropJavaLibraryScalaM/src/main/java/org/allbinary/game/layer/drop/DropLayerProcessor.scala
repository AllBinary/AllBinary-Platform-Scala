/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.drop

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.BasicLayerProcessor
import _root_.org.allbinary.util.BasicArrayList

class DropLayerProcessor private() extends BasicLayerProcessor {
    import _root_.org.allbinary.game.layer.drop.DropLayerProcessor.{*}

    override def process(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        val list : BasicArrayList = this.getList()
        val size : Int = list.size()
        var layerInterface : AllBinaryLayer = null
        var dropLayerInterface : DropLayerInterface = null

        {
            var index : Int = 0
            while (index < size) {
                layerInterface = list.objectArray(index).asInstanceOf[AllBinaryLayer]
                dropLayerInterface = layerInterface.asInstanceOf[DropLayerInterface]
                layerInterface = dropLayerInterface.getDroppedLayer().asInstanceOf[AllBinaryLayer]
                allBinaryLayerManager.append(layerInterface)
                index += 1
            }
        }
        list.clear()
    }

}

object DropLayerProcessor {
    private val LAYER_PROCESSOR : BasicLayerProcessor = new DropLayerProcessor()

    def getInstance() : BasicLayerProcessor = {
        return DropLayerProcessor.LAYER_PROCESSOR
    }

}


