/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyEventSourceInterface
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.input.event.GameKeyEventFactory
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

final class TouchButtonInput(param_id : Int, param_name : String) extends Input(param_id, param_name) with GameKeyEventSourceInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val gameKeyEventFactory : GameKeyEventFactory = GameKeyEventFactory.getInstance()

    private val TOUCH_BUTTON_SOURCE_ID : Int = this.gameKeyEventFactory.TOUCH_BUTTON_SOURCE_ID

    private var gameKeyEvent : GameKeyEvent = GameKeyEvent.NONE

    //Constructor
    {
        val id : Int = param_id
        val name : String = param_name
        val inputFactory : InputFactory = InputFactory.getInstance()
        inputFactory.add(this.getId(), this)
    }

    def update(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        try {
            var gameKey : GameKey = inputToGameKeyMapping.getInstance(this.getId())
            this.gameKeyEvent = this.gameKeyEventFactory.getInstanceForInput(this, gameKey)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.UPDATE, e)
            }
        }
    }

    override def getSourceId() : Int = {
        return this.TOUCH_BUTTON_SOURCE_ID
    }

    def getGameKeyEvent() : GameKeyEvent = {
        return this.gameKeyEvent
    }

}


