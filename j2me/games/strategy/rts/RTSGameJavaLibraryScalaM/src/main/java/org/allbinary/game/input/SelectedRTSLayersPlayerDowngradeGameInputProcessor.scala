/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.layer.AllBinaryLayerManager

class SelectedRTSLayersPlayerDowngradeGameInputProcessor(param_selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput) extends SelectedRTSLayersPlayerGameInputProcessor(param_selectedRTSLayersPlayerGameInput) {

    //Constructor
    {
        val selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput = param_selectedRTSLayersPlayerGameInput
    }

    override def processEvent(allbinaryLayerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
        this.selectedRTSLayersPlayerGameInput.downgrade()
    }

}


