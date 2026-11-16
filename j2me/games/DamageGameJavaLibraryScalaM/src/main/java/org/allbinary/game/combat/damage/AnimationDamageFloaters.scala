/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.damage

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.CircularIndexUtil
import _root_.org.allbinary.view.ViewPosition
import _root_.org.allbinary.view.ViewPositionBase

class AnimationDamageFloaters(param_layerInterface : AllBinaryLayer, param_animationInterfaceArray : Array[IndexedAnimation], param_dx : Int, param_dy : Int) extends DamageFloaters {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var layerInterface : AllBinaryLayer = null

    private var animationInterfaceArray : Array[IndexedAnimation] = null

    //private int[] lastDamage;
    private var circularIndexUtil : CircularIndexUtil = null

    private var dx : Int = 0

    private var dy : Int = 0

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        val animationInterfaceArray : Array[IndexedAnimation] = param_animationInterfaceArray
        val dx : Int = param_dx
        val dy : Int = param_dy
        this.animationInterfaceArray = animationInterfaceArray

        {
            var index : Int = this.animationInterfaceArray.length - 1
            while (index >= 0) {
                this.animationInterfaceArray(index).setFrame(this.animationInterfaceArray(index).getSize() - 1)
                index -= 1
            }
        }
        //this.lastDamage = new int[animationInterfaceArray.length];
        this.layerInterface = layerInterface
        this.circularIndexUtil = CircularIndexUtil.createInstance(this.animationInterfaceArray.length)
        this.dx = dx
        this.dy = dy
    }

    /*     public AnimationDamageFloaters(AllBinaryLayer layerInterface)     {         this.layerInterface = layerInterface;          this.circularIndexUtil = CircularIndexUtil.getInstance(0);     }     */
    override def add(damage : Int) : Unit = {
        var i : Int = this.circularIndexUtil.getIndex()
        //this.lastDamage[i] = damage;
        this.animationInterfaceArray(i).setFrame(0)
        this.circularIndexUtil.next()
    }

    override def paint(graphics : Graphics) : Unit = {
        try {
            val viewPosition : ViewPositionBase = this.layerInterface.getViewPosition()
            val x : Int = viewPosition.getX()
            val y : Int = viewPosition.getY()

            {
                var index : Int = 0
                while (index < this.animationInterfaceArray.length) {
                    var animationInterface : IndexedAnimation = this.animationInterfaceArray(index)
                    if (animationInterface.getFrame() < (animationInterface.getAnimationSize() - 1)) {
                        var delta : Int = animationInterface.getFrame() * 20
                        animationInterface.paintXY(graphics, x + this.dx, (y - delta) + this.dy)
                        /*                     for(int index2 = 0; index2 < this.lastDamage[index2]; index2++)                     {                         animationInterface.paint(graphics, x + MyRandom.getAbsoluteNextInt(3 * animationInterface.getFrame()), y - delta);                     }                     */
                        animationInterface.nextFrame()
                    }
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                val canvasStrings : CanvasStrings = CanvasStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, canvasStrings.PAINT, e)
            }
        }
    }

}


