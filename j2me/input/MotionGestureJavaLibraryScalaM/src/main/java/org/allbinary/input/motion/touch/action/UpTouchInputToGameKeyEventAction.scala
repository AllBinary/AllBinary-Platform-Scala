/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.touch.action

import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.motion.action.GameKeyCompleteMotionGestureInputEvent
import _root_.org.allbinary.input.motion.gesture.TouchMotionGestureFactory
import _root_.org.allbinary.logic.NullUtil

class UpTouchInputToGameKeyEventAction private() extends GameKeyCompleteMotionGestureInputEvent("Up Action", TouchMotionGestureFactory.getInstance().UP, PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance().getInputMapping()) {
    import _root_.org.allbinary.input.motion.touch.action.UpTouchInputToGameKeyEventAction.{*}

}

object UpTouchInputToGameKeyEventAction {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameKeyCompleteMotionGestureInputEvent = {
        if (UpTouchInputToGameKeyEventAction.instance eq NullUtil.getInstance().NULL_OBJECT) {
            UpTouchInputToGameKeyEventAction.instance = new UpTouchInputToGameKeyEventAction()
        }
        return UpTouchInputToGameKeyEventAction.instance.asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
    }

}


