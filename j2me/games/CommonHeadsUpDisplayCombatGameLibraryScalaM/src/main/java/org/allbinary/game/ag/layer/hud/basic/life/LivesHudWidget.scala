/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.life

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.ag.life.Life
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.event.DisplayChangeEvent
import _root_.org.allbinary.graphics.paint.PaintableInterface

class LivesHudWidget(param_animationInterface : Animation, param_lifeInterface : Life, param_location : Int, param_direction : Int) extends BasicHud(param_location, param_direction, 2, BasicColorFactory.getInstance().WHITE) with PaintableInterface {

    private var lifeInterface : Life = null

    private var xArray : Array[Int] = null

    private var animationInterface : Animation = null

    //, BasicColor basicColor
    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val lifeInterface : Life = param_lifeInterface
        val location : Int = param_location
        val direction : Int = param_direction
        this.lifeInterface = lifeInterface
        val size : Int = this.getLifeInterface().getMaxlives().toInt
        this.xArray = new Array[Int](size)
        this.animationInterface = animationInterface
        this.updateMaxWidth = this.lifeInterface.getMaxlives() * 16
        this.updateMaxHeight = 16
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        super.updateMeasurement(graphics)
        var maxLives : Int = this.getLifeInterface().getMaxlives().toInt

        {
            var index : Int = 0
            while (index < maxLives) {
                //width = 16
                this.xArray(index) = this.getX() + (index * 16)
                index += 1
            }
        }
    }

    override def onDisplayChangeEvent(displayChangeEvent : DisplayChangeEvent) : Unit = {
        super.onDisplayChangeEvent(displayChangeEvent)
        this.myFontProcessor = this.updateMyFontProcessor
    }

    override def setX(x : Int) : Unit = {
        super.setX(x)
        this.myFontProcessor = this.updateMyFontProcessor
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)

        {
            var index : Int = this.getLifeInterface().get().toInt
            while ({ index -= 1; index } >= 0) {
                this.animationInterface.paintXY(graphics, this.xArray(index), this.getY())
            }
        }
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

    def getLifeInterface() : Life = {
        return this.lifeInterface
    }

}


