/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class NullPlayerGameInputComposite extends PlayerGameInputCompositeInterface {
    import _root_.org.allbinary.game.input.NullPlayerGameInputComposite.{NULL_PLAYER_GAME_INPUT_COMPOSITE as _, *}
    def NULL_PLAYER_GAME_INPUT_COMPOSITE : NullPlayerGameInputComposite = _root_.org.allbinary.game.input.NullPlayerGameInputComposite.NULL_PLAYER_GAME_INPUT_COMPOSITE

    override def getName() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    override def processInput(layerManager : AllBinaryLayerManager) : Unit = {
    }

    override def initInputProcessors() : Unit = {
    }

    override def getPlayerGameInput() : PlayerGameInput = {
        return NoPlayerGameInput.getInstance()
    }

}

object NullPlayerGameInputComposite {
    val NULL_PLAYER_GAME_INPUT_COMPOSITE : NullPlayerGameInputComposite = new NullPlayerGameInputComposite()

}


