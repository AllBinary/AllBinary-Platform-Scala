/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfiguration
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfigurationFactory

class MotionGestureReceiveInterfaceFactory {
    import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureReceiveInterfaceFactory.{*}

}

object MotionGestureReceiveInterfaceFactory {
    def getInstance() : CompleteMotionGestureListenerInterface = {
        var configuration : MotionGestureConfiguration = MotionGestureConfigurationFactory.getInstance()
        if (!configuration.isExecutingActionsAllowed()) {
            return new NullCompleteMotionGestureReceiver()
        } else {
            return new ResolveCompleteMotionGestureListener()
        }
        throw new IllegalStateException()
    }

}


