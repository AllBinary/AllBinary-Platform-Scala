/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class Layer(param_width : Int, param_height : Int) {
    import _root_.org.allbinary.layer.Layer.{ID as _, *}
    def ID : Integer = _root_.org.allbinary.layer.Layer.ID

    val logUtil : LogUtil = LogUtil.getInstance()

    var x : Int = 0

    var y : Int = 0

    var z : Int = 3

    private var width : Int = 0

    private var height : Int = 0

    private var visible : Boolean = true

    //Constructor
    {
        val width : Int = param_width
        val height : Int = param_height
        this.setLayerWidth(width)
        this.setLayerHeight(height)
    }

    def setPosition(x : Int, y : Int, z : Int) : Unit = {
        this.x = x
        this.y = y
        /*         if(this.z != z)         {             ForcedLogUtil.log(this.z + " != " + z, this);         }         */
        this.z = z
    }

    //private static final String MOVE = "move";
    def moveDXY(dx : Int, dy : Int) : Unit = {
        //.toString(), this, MOVE);
        this.x += dx
        this.y += dy
    }

    def moveDXYZ(dx : Int, dy : Int, dz : Int) : Unit = {
        //this.logUtil.putF(stringMaker.append(positionStrings.DX_LABEL).append(dx).append(positionStrings.DY_LABEL).append(dy).append(positionStrings.DZ_LABEL).append(dz).toString(), this, "move");
        this.x += dx
        this.y += dy
        this.z += dz
    }

    def getXP() : Int = {
        return this.x
    }

    def getYP() : Int = {
        return this.y
    }

    def getZP() : Int = {
        return this.z
    }

    def getWidth() : Int = {
        return this.width
    }

    def getHeight() : Int = {
        return this.height
    }

    //3d games need to overide this now for correct screen to world mapping.
    def getDepth() : Long = {
        return 0
    }

    def setVisible(visible : Boolean) : Unit = {
        this.visible = visible
    }

    def isVisible() : Boolean = {
        return this.visible
    }

    //Should be overridden
    def paint(graphics : Graphics) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val canvasStrings : CanvasStrings = CanvasStrings.getInstance()
        this.logUtil.putF(commonStrings.NOT_IMPLEMENTED, this, canvasStrings.PAINT)
    }

    def setLayerWidth(width : Int) : Unit = {
        if (width < 0) {
            throw new IllegalArgumentException()
        }
        this.width = width
    }

    def setLayerHeight(height : Int) : Unit = {
        if (height < 0) {
            throw new IllegalArgumentException()
        }
        this.height = height
    }

    def toStringAppend(stringBuffer : StringMaker) : Unit = {
    }

}

object Layer {
    //- These methods are for optimizing to concrete classes
    val ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

}


