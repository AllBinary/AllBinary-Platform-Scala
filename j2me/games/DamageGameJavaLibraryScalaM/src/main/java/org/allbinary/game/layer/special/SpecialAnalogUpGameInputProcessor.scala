/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager

class SpecialAnalogUpGameInputProcessor(param_collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer) extends SpecialGameInputProcessor(param_collidableDestroyableDamageableLayer) {

    //Constructor
    {
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = param_collidableDestroyableDamageableLayer
    }

    override def processAnalog(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent, yAnalogValue : Int) : Unit = {
        this.collidableDestroyableDamageableLayer.upAnalog(yAnalogValue)
    }

}


