/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.org.allbinary.game.input.analog.AnalogLocationInput
import _root_.org.allbinary.game.input.analog.AnalogLocationInputFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager

class SingleAnalogControllerVisitor(param_playerInputId : Int) extends AnalogControllerVisitor {

    private var playerInputId : Int = 0

    //Constructor
    {
        val playerInputId : Int = param_playerInputId
        this.playerInputId = playerInputId
    }

    override def process(allbinaryLayerManager : AllBinaryLayerManager, analogLocationInputProcessor : AnalogLocationInputProcessor) : Unit = {
        val analogLocationInput : AnalogLocationInput = AnalogLocationInputFactory.getInstance().getInstanceForPlayer(this.playerInputId)
        analogLocationInputProcessor.process(allbinaryLayerManager, analogLocationInput)
    }

}


