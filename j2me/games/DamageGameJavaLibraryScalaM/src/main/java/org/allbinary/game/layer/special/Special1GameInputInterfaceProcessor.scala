/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager

class Special1GameInputInterfaceProcessor(param_collidableDestroyableDamageableLayer : SpecialGameInputInterface) extends SpecialGameInputInterfaceProcessor(param_collidableDestroyableDamageableLayer) {

    //Constructor
    {
        val collidableDestroyableDamageableLayer : SpecialGameInputInterface = param_collidableDestroyableDamageableLayer
    }

    override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
        this.specialGameInputInterface.special1(allbinaryLayerManager, gameKeyEvent)
    }

}


