/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager

class RTSPlayerRightGameInputProcessor(param_rtsPlayerGameInput : RTSPlayerGameInput) extends RTSPlayerGameInputProcessor(param_rtsPlayerGameInput) {

    //Constructor
    {
        val rtsPlayerGameInput : RTSPlayerGameInput = param_rtsPlayerGameInput
    }

    override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
        this.rtsPlayerGameInput.right()
    }

}


