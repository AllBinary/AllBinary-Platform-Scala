/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.hud.basic

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.animation.AnimationInterface
import _root_.org.allbinary.game.health.HealthInterface
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.image.ImageCacheFactory

class ImageHealthGraphic(param_animationInterface : AnimationInterface, param_healthInterface : HealthInterface, param_location : Int, param_direction : Int) extends HealthGraphic(param_animationInterface, param_healthInterface, param_location, param_direction) {

    private var image : Array[Image] = null

    //Constructor
    {
        val animationInterface : AnimationInterface = param_animationInterface
        val healthInterface : HealthInterface = param_healthInterface
        val location : Int = param_location
        val direction : Int = param_direction
        this.image = new Array[Image](this.healthInterface.getMaxHealth())
        var imageCacheFactory : ImageCacheFactory = ImageCacheFactory.getInstance()

        {
            var numOfHealth : Int = 0
            while (numOfHealth <= max) {
                this.image(numOfHealth) = imageCacheFactory.get(this, numOfHealth + (1 * 10), 10)
                numOfHealth += 1
            }
        }

        {
            var numOfHealth : Int = 0
            while (numOfHealth <= max) {

                {
                    var index : Int = 0
                    while (index < numOfHealth) {
                        this.animationInterface.paint(this.image(numOfHealth).getGraphics(), numOfHealth * 10, 0)
                        index += 1
                    }
                }
                numOfHealth += 1
            }
        }
    }

    def paint(graphics : Graphics) : Unit = {
        graphics.drawImage(this.image(max), x, y, Anchor.TOP_LEFT)
    }

}


