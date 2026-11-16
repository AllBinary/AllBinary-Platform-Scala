/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.mapping

import _root_.org.allbinary.game.input.mapping.event.InputMappingEvent
import _root_.org.allbinary.game.input.mapping.event.InputMappingEventListenerInterface
import _root_.org.allbinary.game.input.motion.action.GameKeyCompleteMotionGestureInputEventFactory
import _root_.org.allbinary.input.motion.button.BasicTouchInputFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class MotionInputMappingEventListener extends InputMappingEventListenerInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onInputMappingEvent(inputMappingEvent : InputMappingEvent) : Unit = {
        GameKeyCompleteMotionGestureInputEventFactory.getInstance().updateAll()
        BasicTouchInputFactory.getInstance().updateAll(inputMappingEvent.getInputToGameKeyMapping())
    }

}


