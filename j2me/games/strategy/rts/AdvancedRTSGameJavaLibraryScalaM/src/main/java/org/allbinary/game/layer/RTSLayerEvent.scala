/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class RTSLayerEvent(param_rtsLayer : PathFindingLayerInterface) extends AllBinaryEventObject(param_rtsLayer) {

    private var rtsLayer : PathFindingLayerInterface = NullPathFindingLayer.NULL_PATH_FINDING_LAYER

    //Constructor
    {
        val rtsLayer : PathFindingLayerInterface = param_rtsLayer
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("RTSLayerEvent: \n")
        stringBuffer.append("RTSLayer: ")
        stringBuffer.append(this.getRtsLayer().toString())
        return stringBuffer.toString()
    }

    /**      * @return the rtsLayer      */
    def getRtsLayer() : PathFindingLayerInterface = {
        return this.rtsLayer
    }

    /**      * @param rtsLayer the rtsLayer to set      */
    def setRtsLayer(rtsLayer : PathFindingLayerInterface) : Unit = {
        this.rtsLayer = rtsLayer
    }

}


