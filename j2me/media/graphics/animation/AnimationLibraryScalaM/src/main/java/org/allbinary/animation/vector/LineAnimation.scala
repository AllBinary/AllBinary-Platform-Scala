/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.vector

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.ColorCompositeInterface
import _root_.org.allbinary.layer.PositionInterface
import _root_.org.allbinary.logic.NullUtil

class LineAnimation(param_basicColor : BasicColor) extends Animation with ColorCompositeInterface with PositionInterface {

    private var newLine : Array[Array[Int]] = Array.ofDim[Int](2, 2)

    private var tempLine : Array[Array[Int]] = NullUtil.getInstance().NULL_INT_ARRAY_ARRAY

    private var line : Array[Array[Int]] = Array.ofDim[Int](2, 2)

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        this.setBasicColorP(basicColor)
    }

    def init(x : Int, y : Int) : Unit = {
        this.newLine(0)(0) = x
        this.newLine(0)(1) = y
        this.newLine(1)(0) = x
        this.newLine(1)(1) = y
        this.tempLine = this.line
        this.line = this.newLine
        this.newLine = this.tempLine
    }

    override def setPosition(x : Int, y : Int, z : Int) : Unit = {
        this.newLine(0)(0) = this.line(1)(0)
        this.newLine(0)(1) = this.line(1)(1)
        this.newLine(1)(0) = x
        this.newLine(1)(1) = y
        this.tempLine = this.line
        this.line = this.newLine
        this.newLine = this.tempLine
    }

    /*     public void setPosition(int x, int y)     {         if (this.tempLine == null)         {             this.newLine[0][0] = x;             this.newLine[0][1] = y;                     }         else         {             this.newLine[0][0] = this.line[1][0];             this.newLine[0][1] = this.line[1][1];                     }          this.newLine[1][0] = x;         this.newLine[1][1] = y;          this.tempLine = this.line;         this.line = this.newLine;         this.newLine = this.tempLine;     }     */
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        val currentLine : Array[Array[Int]] = this.line
        this.basicSetColorUtil.setBasicColorP3(graphics, this.getBasicColorP(), this.getColor())
        graphics.drawLine(currentLine(0)(0), currentLine(0)(1), currentLine(1)(0), currentLine(1)(1))
    }

    override def nextFrame() : Unit = {
    }

    //Needed for polyglot do not remove
    override def getBasicColorP() : BasicColor = {
        return super.getBasicColorP()
    }

    //Needed for polyglot do not remove
    override def setBasicColorP(basicColor : BasicColor) : Unit = {
        super.setBasicColorP(basicColor)
    }

}


