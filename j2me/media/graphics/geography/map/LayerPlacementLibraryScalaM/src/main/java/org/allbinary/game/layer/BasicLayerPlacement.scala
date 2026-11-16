/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer


class BasicLayerPlacement(param_layerType : LayerPlacementType, param_width : Int, param_height : Int) {

    private var layerType : LayerPlacementType = null

    private var width : Int = 0

    private var height : Int = 0

    //Constructor
    {
        val layerType : LayerPlacementType = param_layerType
        val width : Int = param_width
        val height : Int = param_height
        this.layerType = layerType
        this.width = width
        this.height = height
    }

    def getWidth() : Int = {
        return this.width
    }

    def getHeight() : Int = {
        return this.height
    }

    def getLayerType() : LayerPlacementType = {
        return this.layerType
    }

    def setLayerType(layerType : LayerPlacementType) : Unit = {
        this.layerType = layerType
    }

}


