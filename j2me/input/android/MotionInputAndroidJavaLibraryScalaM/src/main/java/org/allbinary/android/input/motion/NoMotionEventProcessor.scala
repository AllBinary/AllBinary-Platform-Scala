/* * AllBinary Open License Version 1 * Copyright (c) 2009 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion


class NoMotionEventProcessor extends MotionEventProcessor {
    import _root_.org.allbinary.android.input.motion.NoMotionEventProcessor.{SINGLETON as _, *}
    def SINGLETON : MotionEventProcessor = _root_.org.allbinary.android.input.motion.NoMotionEventProcessor.SINGLETON

}

object NoMotionEventProcessor {
    val SINGLETON : MotionEventProcessor = new MotionEventProcessor()

    def getInstance() : MotionEventProcessor = {
        return NoMotionEventProcessor.SINGLETON
    }

}


