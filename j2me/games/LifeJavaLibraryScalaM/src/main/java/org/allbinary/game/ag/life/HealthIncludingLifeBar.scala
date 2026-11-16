/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.life

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.health.Health
import _root_.org.allbinary.game.health.HealthBarAnimation
import _root_.org.allbinary.game.health.HealthBarTwodAnimation
import _root_.org.allbinary.game.health.HealthInterface
import _root_.org.allbinary.game.health.HealthListenerInterface
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.layer.AllBinaryLayer

class HealthIncludingLifeBar(param_layerInterface : AllBinaryLayer, param_life : Life, param_healthInterface : Health, param_animationInterface : HealthBarAnimation, param_direction : Int) extends Paintable with HealthListenerInterface {
    import _root_.org.allbinary.game.ag.life.HealthIncludingLifeBar.{*}

    private var animationInterface : HealthBarAnimation = null

    private var life : Life = null

    private var healthInterface : HealthInterface = null

    // private int direction;
    var allbinaryLayer : AllBinaryLayer = null

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        val life : Life = param_life
        val healthInterface : Health = param_healthInterface
        val animationInterface : HealthBarAnimation = param_animationInterface
        val direction : Int = param_direction
        this.allbinaryLayer = layerInterface
        this.animationInterface = animationInterface
        this.life = life
        this.healthInterface = healthInterface
        this.healthInterface.addListener(this)
        this.onHealthChange()
    }

    override def onHealthChange() : Unit = {
        this.animationInterface.onHealthChange(((this.healthInterface.getHealth() + (this.healthInterface.getMaxHealth() * this.life.get())) * this.allbinaryLayer.getWidth()) / (this.healthInterface.getMaxHealth() + (this.healthInterface.getMaxHealth() * this.life.getStartLives())))
    }

    override def paint(graphics : Graphics) : Unit = {
        this.animationInterface.paintXY(graphics, 0, 0)
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        this.animationInterface.paintThreedXYZ(graphics, 0, 0, 0)
    }

}

object HealthIncludingLifeBar {
    def createHealthIncludingLifeBar(layerInterface : AllBinaryLayer, life : Life, healthInterface : Health, location : Int, direction : Int) : HealthIncludingLifeBar = {
        return new HealthIncludingLifeBar(layerInterface, life, healthInterface, new HealthBarTwodAnimation(layerInterface, location), direction)
    }

}


