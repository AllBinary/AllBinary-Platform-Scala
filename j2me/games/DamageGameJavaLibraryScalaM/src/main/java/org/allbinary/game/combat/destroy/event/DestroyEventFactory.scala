/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy.event

import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.AllBinaryEventObjectFactoryInterface

class DestroyEventFactory(param_combatGameCanvas : AllBinaryGameCanvas) extends AllBinaryEventObjectFactoryInterface {

    private var combatGameCanvas : AllBinaryGameCanvas = null

    //Constructor
    {
        val combatGameCanvas : AllBinaryGameCanvas = param_combatGameCanvas
        this.combatGameCanvas = combatGameCanvas
    }

    override def getInstance() : AllBinaryEventObject = {
        return new DestroyedEvent(this.combatGameCanvas)
    }

}


