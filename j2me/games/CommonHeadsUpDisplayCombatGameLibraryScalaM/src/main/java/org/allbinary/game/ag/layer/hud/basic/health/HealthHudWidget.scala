/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.hud.basic.health

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.graphics.hud.BasicHud
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.health.HealthListenerInterface
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.paint.PaintableInterface
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.NoTimeDelayHelper
import _root_.org.allbinary.time.TimeDelayHelper

class HealthHudWidget(param_animationInterface : Animation, param_healthInterface : Health, param_location : Int, param_direction : Int) extends BasicHud(param_location, param_direction, 2, BasicColorFactory.getInstance().WHITE) with PaintableInterface with HealthListenerInterface {

    private var healthScale : Int = 0

    var animationInterface : Animation = null

    var healthInterface : Health = null

    var max : Int = 0

    private var xArray : Array[Int] = null

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    private var timeDelayHelper : TimeDelayHelper = NoTimeDelayHelper.SINGLETON

    private val slowBeatTimeDelayHelper : TimeDelayHelper = new TimeDelayHelper(1280)

    private val mediumBeatTimeDelayHelper : TimeDelayHelper = new TimeDelayHelper(640)

    private val fastBeatTimeDelayHelper : TimeDelayHelper = new TimeDelayHelper(320)

    //, BasicColor basicColor
    //Constructor
    {
        val animationInterface : Animation = param_animationInterface
        val healthInterface : Health = param_healthInterface
        val location : Int = param_location
        val direction : Int = param_direction
        this.animationInterface = animationInterface
        this.healthInterface = healthInterface
        this.healthInterface.addListener(this)
        this.healthScale = (this.healthInterface.getMaxHealth() / 6) + 1
        this.onHealthChange()
        this.updateMaxWidth = healthInterface.getMaxHealth() * 16
        this.updateMaxHeight = 16
        this.xArray = new Array[Int](30)
        this.update()
    }

    //    }
    final private def update() : Unit = {
        if (this.xArray != null) {

            {
                var index : Int = 0
                while (index < this.xArray.length) {
                    //width = 16
                    this.xArray(index) = this.getX() + (index * 16)
                    index += 1
                }
            }
        }
    }

    override def setX(x : Int) : Unit = {
        super.setX(x)
        this.update()
    }

    override def onHealthChange() : Unit = {
        this.max = (this.healthInterface.getHealth() / this.healthScale)
        this.timeDelayHelper = NoTimeDelayHelper.SINGLETON
        if ((this.max <= 1) && this.healthInterface.isAlive()) {
            this.max = 1
            if ((this.healthScale - this.healthInterface.getHealth()) > ((this.healthScale * 2) / 3)) {
                this.timeDelayHelper = this.slowBeatTimeDelayHelper
            } else if ((this.healthScale - this.healthInterface.getHealth()) > (this.healthScale / 3)) {
                this.timeDelayHelper = this.mediumBeatTimeDelayHelper
            } else {
                this.timeDelayHelper = this.fastBeatTimeDelayHelper
            }
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)

        {
            var index : Int = 0
            while (index < this.max) {
                if (this.timeDelayHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
                    this.animationInterface.paintXY(graphics, this.xArray(index), this.getY())
                }
                index += 1
            }
        }
    }

    override def paintThreed(graphics : Graphics) : Unit = {
    }

}


