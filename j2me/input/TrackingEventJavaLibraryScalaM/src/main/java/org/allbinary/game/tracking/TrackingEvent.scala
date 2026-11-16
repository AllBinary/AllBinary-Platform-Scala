/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tracking

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class TrackingEvent(param_allBinaryLayerInterface : Object) extends AllBinaryEventObject(param_allBinaryLayerInterface) {

    private var layerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    //Constructor
    {
        val allBinaryLayerInterface : Object = param_allBinaryLayerInterface
        if (allBinaryLayerInterface ne TrackingEventHandler.getInstance()) {
            this.setLayerInterface(allBinaryLayerInterface.asInstanceOf[AllBinaryLayer])
        }
    }

    def init(anyType : Object) : Unit = {
        this.setSource(anyType)
    }

    def getLayerInterface() : AllBinaryLayer = {
        return this.layerInterface
    }

    private def setLayerInterface(layerInterface : AllBinaryLayer) : Unit = {
        this.layerInterface = layerInterface
    }

    def setLayerInterfaceForCircularStaticPool(layerInterface : AllBinaryLayer) : Unit = {
        this.layerInterface = layerInterface
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("TrackingEvent: \n")
        stringBuffer.append("LayerInterface: ")
        stringBuffer.append(this.layerInterface.toString())
        return stringBuffer.toString()
    }

}


