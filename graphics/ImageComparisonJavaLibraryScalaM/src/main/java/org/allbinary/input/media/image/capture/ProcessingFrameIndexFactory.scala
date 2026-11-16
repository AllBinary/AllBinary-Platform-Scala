/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture


class ProcessingFrameIndexFactory private() {
    import _root_.org.allbinary.input.media.image.capture.ProcessingFrameIndexFactory.{*}

}

object ProcessingFrameIndexFactory {
    private var currentFrame : Long = 0L

    def next() : Long = this.synchronized {
        return { val value_N65675 = ProcessingFrameIndexFactory.currentFrame; ProcessingFrameIndexFactory.currentFrame += 1; value_N65675 }
    }

}


