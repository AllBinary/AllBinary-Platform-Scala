/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.view

import _root_.org.allbinary.layer.AllBinaryLayer

/**  *  * @author User  */
class ViewPosition(param_x : Int, param_y : Int, param_z : Int) extends ViewPositionBase(param_x, param_y, param_z) {
    import _root_.org.allbinary.view.ViewPosition.{*}

    private var allbinaryLayer : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    //    }
    //Constructor
    {
        val x : Int = param_x
        val y : Int = param_y
        val z : Int = param_z
    }

    override def getX() : Int = {
        return this.allbinaryLayer.getXP()
    }

    override def getY() : Int = {
        return this.allbinaryLayer.getYP()
    }

    override def getZ() : Int = {
        return this.allbinaryLayer.getZP()
    }

    override def getX2() : Int = {
        return this.getX() + this.allbinaryLayer.getWidth()
    }

    override def getY2() : Int = {
        return this.getY() + this.allbinaryLayer.getHeight()
    }

    override def getZ2() : Int = {
        return (this.getZ() + this.allbinaryLayer.getDepth()).toInt
    }

    /*      * private AllBinaryLayer getAllbinaryLayer() { return allbinaryLayer; }      */
    override def setAllbinaryLayer(allbinaryLayer : Object) : Unit = {
        this.allbinaryLayer = allbinaryLayer.asInstanceOf[AllBinaryLayer]
    }

}

object ViewPosition {
    def getInstanceD() : ViewPosition = {
        return new ViewPosition(0, 0, 0)
    }

}


