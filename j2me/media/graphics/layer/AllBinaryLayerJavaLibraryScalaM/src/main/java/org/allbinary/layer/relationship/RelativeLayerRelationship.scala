/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer.relationship

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.RelativeRelationship
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.util.BasicArrayList

class RelativeLayerRelationship(param_layer : AllBinaryLayer, param_point : GPoint, param_typesAllowedList : BasicArrayList) extends RelativeRelationship(param_point, param_typesAllowedList) {

    private var layer : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    //Constructor
    {
        val layer : AllBinaryLayer = param_layer
        val point : GPoint = param_point
        val typesAllowedList : BasicArrayList = param_typesAllowedList
        this.layer = layer
    }

    override def getX() : Int = {
        return this.layer.getXP() + super.getX()
    }

    override def getY() : Int = {
        return this.layer.getYP() + super.getY()
    }

    override def getZ() : Int = {
        return this.layer.getZP() + super.getZ()
    }

}


