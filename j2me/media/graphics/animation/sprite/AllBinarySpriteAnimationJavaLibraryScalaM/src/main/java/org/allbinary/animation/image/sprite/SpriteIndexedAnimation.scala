/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image.sprite

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.ColorCompositeInterface
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels

class SpriteIndexedAnimation(param_sprite : Sprite, param_image : Image, param_basicColorArray : Array[BasicColor], param_animationBehavior : AnimationBehavior) extends IndexedAnimation(param_animationBehavior) with ColorCompositeInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var sprite : Sprite = null

    var image : Image = null

    private var basicColorArray : Array[BasicColor] = null

    //Constructor
    {
        val sprite : Sprite = param_sprite
        val image : Image = param_image
        val basicColorArray : Array[BasicColor] = param_basicColorArray
        val animationBehavior : AnimationBehavior = param_animationBehavior
        this.sprite = sprite
        this.image = image
        this.basicColorArray = basicColorArray
        if ((this.basicColorArray.length != 0) && (this.getSize() != this.basicColorArray.length)) {
            throw new Exception(new StringMaker().append(CommonLabels.getInstance().TOTAL_LABEL).appendint(this.getSize()).append("!=").appendint(this.basicColorArray.length).toString())
        }
    }

    override def getAnimationSize() : Int = {
        return this.getSize()
    }

    override def setBasicColorP(basicColor : BasicColor) : Unit = {

        {
            var index : Int = 0
            scala.util.boundary { (break_N68175 : scala.util.boundary.Label[Unit]) ?=>
                while (index < this.basicColorArray.length) {
                    if (basicColor eq this.basicColorArray(index)) {
                        //  "BasicColor: " + basicColor.getName() + "==" + this.basicColorArray[index].getName() + commonLabels.INDEX_LABEL + index, this, "setBasicColor");
                        this.setFrame(index)
                        scala.util.boundary.break()(using break_N68175)
                    }
                    index += 1
                }
            }
        }
    }

    override def getBasicColorP() : BasicColor = {
        if (this.basicColorArray.length < this.getFrame()) {
            return this.basicColorArray(this.getFrame())
        } else {
            return BasicColorFactory.getInstance().WHITE
        }
        throw new IllegalStateException()
    }

    /*      * public SpriteIndexedAnimation(MESprite sprite, int dx, int dy) {      * this.setSprite(sprite);      *       * this.setDx(dx); this.setDy(dy); }      */
    def paintFrame(graphics : Graphics, frame : Int, x : Int, y : Int) : Unit = {
        this.setFrame(frame)
        this.sprite.setPosition(x, y)
        this.sprite.paint(graphics)
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        this.sprite.setPosition(x, y)
        this.sprite.paint(graphics)
    }

    def paint(graphics : Graphics) : Unit = {
        this.sprite.paint(graphics)
    }

    override def nextFrame() : Unit = {
        this.sprite.nextFrame()
    }

    override def previousFrame() : Unit = {
        this.sprite.prevFrame()
    }

    override def getSize() : Int = {
        // .getFrameSequenceLength()
        return this.sprite.getRawFrameCount()
    }

    override def setFrame(frame : Int) : Unit = {
        this.sprite.setFrame(frame)
    }

    override def getFrame() : Int = {
        return this.sprite.getFrame()
    }

    override def isLastFrame() : Boolean = {
        if (this.sprite.getFrame() == (this.getSize() - 1)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def getLastFrame() : Int = {
        //use Seguence at some point
        return this.getSize()
    }

    override def setSequence(sequence : Array[Int]) : Unit = {
    }

    override def getSequence() : Array[Int] = {
        return PrimitiveIntUtil.getArrayInstance()
    }

    def close() : Unit = {
    }

    override def finalize() : Unit = {
    }

}


