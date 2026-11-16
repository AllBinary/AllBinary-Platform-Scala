/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.math

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.MathUtil

class LayerDistanceUtil {
    import _root_.org.allbinary.math.LayerDistanceUtil.{*}

    private val mathUtil : MathUtil = MathUtil.getInstance()

    def getDistance(layerInterface : AllBinaryLayer, layerInterface2 : AllBinaryLayer) : Int = {
        val dx : Int = (layerInterface.getXP() + layerInterface.getHalfWidth()) - (layerInterface2.getXP() + layerInterface2.getHalfWidth())
        val dy : Int = (layerInterface.getYP() + layerInterface.getHalfHeight()) - (layerInterface2.getYP() + layerInterface2.getHalfHeight())
        return this.mathUtil.sqrt((dx * dx) + (dy * dy)).toInt
    }

    def getDistance3D(layerInterface : AllBinaryLayer, layerInterface2 : AllBinaryLayer) : Int = {
        val dx : Int = (layerInterface.getXP() + layerInterface.getHalfWidth()) - (layerInterface2.getXP() + layerInterface2.getHalfWidth())
        val dy : Int = (layerInterface.getYP() + layerInterface.getHalfHeight()) - (layerInterface2.getYP() + layerInterface2.getHalfHeight())
        val dz : Int = (layerInterface.getZP() + layerInterface.getHalfDepth()) - (layerInterface2.getZP() + layerInterface2.getHalfDepth())
        return this.mathUtil.sqrt(((dx * dx) + (dy * dy)) + (dz * dz)).toInt
    }

    def getDistanceAt(layerInterface : AllBinaryLayer, point : GPoint) : Int = {
        val dx : Int = layerInterface.getXP() - point.getX()
        val dy : Int = layerInterface.getYP() - point.getY()
        return this.mathUtil.sqrt((dx * dx) + (dy * dy)).toInt
    }

}

object LayerDistanceUtil {
    private val instance : LayerDistanceUtil = new LayerDistanceUtil()

    /**      * @return the instance      */
    def getInstance() : LayerDistanceUtil = {
        return LayerDistanceUtil.instance
    }

}


