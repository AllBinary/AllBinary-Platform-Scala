/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.layer.AllBinaryLayer

class HealthBarAnimation(param_layerInterface : AllBinaryLayer, param_location : Int) extends Animation {

    private val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    var x2 : Int = 0

    var thickness : Int = 0

    private var location : Int = 0

    var allbinaryLayer : AllBinaryLayer = null

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        val location : Int = param_location
        this.allbinaryLayer = layerInterface
        this.location = location
        val basicHudFactory : BasicHudFactory = BasicHudFactory.getInstance()
        if ((this.location != basicHudFactory.TOPLEFT) && (this.location != basicHudFactory.BOTTOMLEFT)) {
            throw new Exception("Location Not Valid")
        }
        if (layerInterface.getWidth() > 40) {
            this.thickness = 3
        } else if (layerInterface.getWidth() > 20) {
            this.thickness = 2
        } else {
            this.thickness = 1
        }
    }

    def onHealthChange(newX2 : Int) : Unit = {
        this.x2 = newX2
        var quarter : Int = (this.allbinaryLayer.getWidth() >> 2)
        if (this.x2 > (quarter * 3)) {
            this.basicColor = this.basicColorFactory.GREEN
            this.colorP = this.basicColor.intValue()
        } else if (this.x2 > (quarter * 2)) {
            this.basicColor = this.basicColorFactory.YELLOW
            this.colorP = this.basicColor.intValue()
        } else if (this.x2 > quarter) {
            this.basicColor = this.basicColorFactory.ORANGE
            this.colorP = this.basicColor.intValue()
        } else {
            this.basicColor = this.basicColorFactory.RED
            this.colorP = this.basicColor.intValue()
        }
    }

    def getY() : Int = {
        val basicHudFactory : BasicHudFactory = BasicHudFactory.getInstance()
        if (this.location == basicHudFactory.TOPLEFT) {
            return this.allbinaryLayer.getViewPosition().getY() - 4
        } else if (this.location == basicHudFactory.BOTTOMLEFT) {
            return this.allbinaryLayer.getViewPosition().getY2() + 4
        }
        return -1
    }

}


