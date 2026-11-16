/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tick

import _root_.org.allbinary.layer.AllBinaryLayerManager

class NullTickable extends TickableInterface {
    import _root_.org.allbinary.game.tick.NullTickable.{*}

    private val NAME : String = "NulLTickable"

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
    }

    override def getName() : String = {
        return this.NAME
    }

}

object NullTickable {
    private val SINGLETON : NullTickable = new NullTickable()

    def getInstance() : NullTickable = {
        return NullTickable.SINGLETON
    }

}


