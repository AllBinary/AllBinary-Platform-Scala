/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.java.util.Enumeration
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.LayerInterfaceFactory
import _root_.org.allbinary.layer.LayerInterfaceVisitor
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.EnumerationUtil

class LayerPlacer(param_layerInterfaceVisitor : LayerInterfaceVisitor, param_dimension : GPoint) {

    private val enumerationUtil : EnumerationUtil = EnumerationUtil.getInstance()

    var layerInterfaceVisitor : LayerInterfaceVisitor = null

    private var dimension : GPoint = null

    //Constructor
    {
        val layerInterfaceVisitor : LayerInterfaceVisitor = param_layerInterfaceVisitor
        val dimension : GPoint = param_dimension
        this.layerInterfaceVisitor = layerInterfaceVisitor
        this.dimension = dimension
    }

    def processList(list : BasicArrayList) : Unit = {
        val size : Int = list.size()
        var layerPlacementInterface : LayerPlacementInterface = null

        {
            var index : Int = 0
            while (index < size) {
                layerPlacementInterface = list.objectArray(index).asInstanceOf[LayerPlacementInterface]
                this.process(layerPlacementInterface)
                index += 1
            }
        }
    }

    def process(layerPlacementInterface : LayerPlacementInterface) : Unit = {
        val relativePoint : GPoint = this.getPoint(layerPlacementInterface)
        val layerInterfaceFactory : LayerInterfaceFactory = LayerInterfaceFactory.getInstance()
        val hashtable : ABHashtable[Object, Object] = layerPlacementInterface.getInstance()
        //GPoint point = (GPoint) objectArray[index];
        val enumeration : Enumeration[? <: Object] = hashtable.keys().asInstanceOf[Enumeration[? <: Object]]
        var point : GPoint = null
        var layerHashtable : ABHashtable[Object, Object] = null
        var x : Int = 0
        var y : Int = 0
        var z : Int = 0
        var layerInterface : AllBinaryLayer = null

        {
            while (this.enumerationUtil.hasMoreElements(enumeration)) {
                point = this.enumerationUtil.nextElement(enumeration).asInstanceOf[GPoint]
                layerHashtable = hashtable.get(point).asInstanceOf[ABHashtable[Object, Object]]
                x = point.getX() + relativePoint.getX()
                y = point.getY() + relativePoint.getY()
                z = point.getZ() + relativePoint.getZ()
                layerInterface = layerInterfaceFactory.getNexInstance(layerHashtable, x, y, z)
                this.layerInterfaceVisitor.visit(layerInterface)
            }
        }
    }

    def getPoint(layerPlacementInterface : LayerPlacementInterface) : GPoint = {
        val pointFactory : PointFactory = PointFactory.getInstance()
        val layerPlacementType : LayerPlacementType = layerPlacementInterface.getLayerType()
        if (layerPlacementType eq LayerPlacementTypeFactory.getInstance().MAP) {
            val width : Int = layerPlacementInterface.getWidth()
            val height : Int = layerPlacementInterface.getHeight()
            val x : Int = ((this.dimension.getX() - width) / 2)
            val y : Int = ((this.dimension.getY() - height) / 2)
            return pointFactory.createXY(x, y)
        } else if (layerPlacementType eq LayerPlacementTypeFactory.getInstance().UP) {
            val width : Int = layerPlacementInterface.getWidth()
            val height : Int = layerPlacementInterface.getHeight()
            val x : Int = ((this.dimension.getX() - width) / 2)
            val y : Int = -height
            return pointFactory.createXY(x, y)
        } else {
            throw new Exception("PlacementType Not Recognized")
        }
        throw new IllegalStateException()
    }

}


