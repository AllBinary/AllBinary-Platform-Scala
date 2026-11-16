/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.special

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.IndexedAnimationBehavior
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.logic.ABSystemWrapper
import _root_.org.allbinary.logic.math.PrimitiveIntUtil

class TitleAnimation(param_animationInterfaceArray : Array[IndexedAnimation], param_basicColorArray : Array[BasicColor], param_dxArray : Array[Int], param_dyArray : Array[Int], param_y : Int, param_width : Int, param_animationBehavior : AnimationBehavior) extends SpecialAnimation(param_animationBehavior) {
    import _root_.org.allbinary.animation.special.TitleAnimation.{*}

    val systemWrapper : ABSystemWrapper = ABSystemWrapper.getInstance()

    var deltaX : Float = 0.0f

    var deltaY : Float = 0.0f

    var deltaZ : Float = 0.0f

    var basicColorArray : Array[BasicColor] = null

    var dxArray : Array[Int] = null

    var dyArray : Array[Int] = null

    var widthP : Int = 0

    // private final int HEIGHT = 45;
    var animationInterfaceArray : Array[IndexedAnimation] = null

    var sizeP : Int = 0

    var y : Int = 0

    private var lastFrameStartTime : Long = 0L

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    val CLEAR_COLOR : BasicColor = BasicColorFactory.getInstance().CLEAR_COLOR

    //Constructor
    {
        val animationInterfaceArray : Array[IndexedAnimation] = param_animationInterfaceArray
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        val dxArray : Array[Int] = param_dxArray
        val dyArray : Array[Int] = param_dyArray
        val y : Int = param_y
        val width : Int = param_width
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.lastFrameStartTime = this.systemWrapper.currentTimeMillis()
        this.animationInterfaceArray = animationInterfaceArray
        this.sizeP = this.animationInterfaceArray.length
        this.basicColorArray = basicColorArray
        this.dxArray = dxArray
        this.dyArray = dyArray
        this.y = y
        this.widthP = width
        this.reset()
    }

    override def nextFrame() : Unit = {
        val currentTime : Long = this.systemWrapper.currentTimeMillis()
        val totalTimeElapsed : Long = currentTime - this.lastFrameStartTime
        val indexedAnimationBehavior : IndexedAnimationBehavior = this.getAnimationBehavior().asInstanceOf[IndexedAnimationBehavior]
        // If Frame is up long enough
        if (totalTimeElapsed > indexedAnimationBehavior.frameDelayTime) {
            this.previousFrame()
            this.lastFrameStartTime = currentTime
        }
        if (this.animationInterfaceArray(0).getFrame() == 0) {
            indexedAnimationBehavior.loopIndex += 1
        }
    }

    override def isComplete() : Boolean = {
        val indexedAnimationBehavior : IndexedAnimationBehavior = this.getAnimationBehavior().asInstanceOf[IndexedAnimationBehavior]
        if (((indexedAnimationBehavior.loopTotal == -1) || (indexedAnimationBehavior.loopIndex < indexedAnimationBehavior.loopTotal)) || (this.getFrame() != 0)) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    override def getSize() : Int = {
        return this.animationInterfaceArray(0).getSize()
    }

    override def getFrame() : Int = {
        return this.animationInterfaceArray(0).getFrame()
    }

    override def setFrame(frame : Int) : Unit = {

        {
            var index : Int = 0
            while (index < this.sizeP) {
                this.animationInterfaceArray(index).setFrame(frame)
                index += 1
            }
        }
    }

    override def setLastFrame() : Unit = {
        this.setFrame(this.getSize() - 1)
    }

    override def reset() : Unit = {
        // this.setFrame(0);
        this.setLastFrame()
        val indexedAnimationBehavior : IndexedAnimationBehavior = (this.getAnimationBehavior().asInstanceOf[IndexedAnimationBehavior])
        indexedAnimationBehavior.reset()
    }

    //this is called from nextFrame. Logical? probably not.
    override def previousFrame() : Unit = {
        //ForcedLogUtil.log(commonStrings.NOT_IMPLEMENTED, this);

        {
            var index : Int = 0
            while (index < this.sizeP) {
                this.animationInterfaceArray(index).previousFrame()
                index += 1
            }
        }
    }

    def paintFrameXY(graphics : Graphics, frame : Int, x : Int, y : Int) : Unit = {
        this.setFrame(frame)
        this.paintXY(graphics, x, y)
    }

    override def paintXY(graphics : Graphics, ax : Int, ay : Int) : Unit = {
        var x : Int = 0
        if (this.widthP != Integer.MIN_VALUE) {
            //x = ((graphics.getClipWidth() - this.width) / 2);
            x = ((this.displayInfoSingleton.getLastWidth() - this.widthP) / 2)
        }
        var deltaX : Int = 0
        var deltaY : Int = 0

        {
            var index : Int = 0
            while (index < this.sizeP) {
                deltaX = this.dxArray(index) + x
                deltaY = this.dyArray(index) + this.y
                if (this.basicColorArray(index) ne this.CLEAR_COLOR) {
                    this.basicSetColorUtil.setBasicColorP(graphics, this.basicColorArray(index))
                }
                //this.logUtil.putF("deltaX: " + deltaX + " " + x, this, canvasStrings.PAINT);
                this.animationInterfaceArray(index).paintXY(graphics, deltaX, deltaY)
                index += 1
            }
        }
    }

}

object TitleAnimation {
    //    }
    def createAnimation(animationInterfaceArray : Array[IndexedAnimation], basicColorArray : Array[BasicColor], dxArray : Array[Int], dyArray : Array[Int], y : Int, width : Int) : TitleAnimation = {
        return new TitleAnimation(animationInterfaceArray, basicColorArray, dxArray, dyArray, y, width, new IndexedAnimationBehavior(1, 250))
    }

}


