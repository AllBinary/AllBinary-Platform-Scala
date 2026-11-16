/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer.event

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.LayerManager
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class LayerManagerEvent(param_layerManager : LayerManager, param_crud : String) extends AllBinaryEventObject(param_layerManager) {

    private var layerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    private var crud : String = null

    //Constructor
    {
        val layerManager : LayerManager = param_layerManager
        val crud : String = param_crud
        this.crud = crud
    }

    /**      * @return the layerInterface      */
    def getLayerInterface() : AllBinaryLayer = {
        return this.layerInterface
    }

    /**      * @param layerInterface      *            the layerInterface to set      */
    def setLayerInterface(layerInterface : AllBinaryLayer) : Unit = {
        this.layerInterface = layerInterface
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("LayerManagerEvent: \n")
        stringBuffer.append("LayerInterface: ")
        stringBuffer.append(this.getLayerInterface().toString())
        stringBuffer.append("\nCRUD: ")
        stringBuffer.append(this.crud)
        return stringBuffer.toString()
    }

}


