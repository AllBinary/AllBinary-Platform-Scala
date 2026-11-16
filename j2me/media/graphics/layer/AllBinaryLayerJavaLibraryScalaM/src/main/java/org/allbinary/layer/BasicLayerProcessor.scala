/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicLayerProcessor() {
    import _root_.org.allbinary.layer.BasicLayerProcessor.{NULL_LAYER_PROCESSOR as _, *}
    def NULL_LAYER_PROCESSOR : BasicLayerProcessor = _root_.org.allbinary.layer.BasicLayerProcessor.NULL_LAYER_PROCESSOR

    val logUtil : LogUtil = LogUtil.getInstance()

    private val list : BasicArrayList = new BasicArrayListD()

    def add(layerInterface : AllBinaryLayer) : Unit = {
        if (!this.list.contains(layerInterface)) {
            //}
            this.list.add(layerInterface)
        }
    }

    def process(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        throw new Exception(CommonStrings.getInstance().NOT_IMPLEMENTED)
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}

object BasicLayerProcessor {
    val NULL_LAYER_PROCESSOR : BasicLayerProcessor = new BasicLayerProcessor()

}


