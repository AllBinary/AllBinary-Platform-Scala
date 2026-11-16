/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.damage

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorArrayIndexer
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorSetUtil
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.java.character.CharArrayFactory
import _root_.org.allbinary.logic.math.PrimitiveLongUtil
import _root_.org.allbinary.util.CircularIndexUtil
import _root_.org.allbinary.view.ViewPosition
import _root_.org.allbinary.view.ViewPositionBase

class PtsDamageFloaters(param_layerInterface : AllBinaryLayer) extends DamageFloaters {
    import _root_.org.allbinary.game.combat.damage.PtsDamageFloaters.{*}

    val basicSetColorUtil : BasicColorSetUtil = BasicColorSetUtil.getInstance()

    private var layerInterface : AllBinaryLayer = null

    private var lastDamage : Array[Int] = new Array[Int](5)

    //    StringUtil.getInstance(), StringUtil.getInstance() };
    private var lastDamageString : Array[Array[Char]] = Array.ofDim[Char](5, 0)

    private var lastDamageStringSizeArray : Array[Int] = new Array[Int](5)

    private var circularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstance(5)

    private var primitiveLongUtil : PrimitiveLongUtil = null

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    /*     public PtsDamageFloaters(AllBinaryLayer layerInterface,             BasicColor[] basicColorArray) throws Exception     {         this.primitiveLongUtil = new PrimitiveLongUtil(100000);                  this.layerInterface = layerInterface;     }     */
    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        this.primitiveLongUtil = PrimitiveLongUtil.createPowerOfTen(100000)
        this.layerInterface = layerInterface
        var CHAR_ARRAY : Array[Char] = CharArrayFactory.getInstance().getZeroCharArray()

        {
            var index : Int = this.lastDamageString.length - 1
            while (index >= 0) {
                this.lastDamageString(index) = CHAR_ARRAY
                index -= 1
            }
        }
    }

    override def add(damage : Int) : Unit = {
        var index : Int = this.circularIndexUtil.getIndex()
        this.lastDamage(index) = damage
        this.lastDamageString(index) = this.primitiveLongUtil.getCharArray(this.lastDamage(index))
        this.lastDamageStringSizeArray(index) = this.primitiveLongUtil.getCurrentTotalDigits()
        this.circularIndexUtil.next()
    }

    override def paint(graphics : Graphics) : Unit = {
        val viewPosition : ViewPositionBase = this.layerInterface.getViewPosition()
        val x : Int = viewPosition.getX()
        val y : Int = viewPosition.getY()

        {
            var index : Int = this.lastDamage.length - 1
            while (index >= 0) {
                if (this.lastDamage(index) != 0) {
                    var delta : Int = 10 * (index + 2)
                    this.basicSetColorUtil.setBasicColorP(graphics, PtsDamageFloaters.basicColorArrayIndexer.get())
                    //graphics.drawString(this.lastDamageString[index],
                    graphics.drawChars(this.lastDamageString(index), 0, this.lastDamageStringSizeArray(index), x - this.myRandomFactory.getNextInt(delta), y - delta, 0)
                    PtsDamageFloaters.basicColorArrayIndexer.next()
                }
                this.lastDamage(index) = 0
                index -= 1
            }
        }
    }

}

object PtsDamageFloaters {
    private val basicColorArrayIndexer : BasicColorArrayIndexer = new BasicColorArrayIndexer(Array[BasicColor](BasicColorFactory.getInstance().WHITE, BasicColorFactory.getInstance().RED, BasicColorFactory.getInstance().YELLOW, BasicColorFactory.getInstance().BLUE))

}


