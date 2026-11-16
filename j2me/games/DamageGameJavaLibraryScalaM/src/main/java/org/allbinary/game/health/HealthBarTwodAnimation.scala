/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.health

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.layer.AllBinaryLayer

class HealthBarTwodAnimation(param_layerInterface : AllBinaryLayer, param_location : Int) extends HealthBarAnimation(param_layerInterface, param_location) {

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        val location : Int = param_location
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        val ax : Int = this.allbinaryLayer.getViewPosition().getX()
        //int y = this.getY() - 1;
        this.basicSetColorUtil.setBasicColorP3(graphics, this.basicColor, this.colorP)
        graphics.fillRect(ax, this.getY() - 1, this.x2, this.thickness)
    }

}


