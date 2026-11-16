/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image.capture

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class CapturedImageWorkerResultsEvent(param_anyType : Object, param_frame : _root_.java.lang.Long, param_bufferedImage : BufferedImage) extends AllBinaryEventObject(param_anyType) {

    private var frame : _root_.java.lang.Long = null

    private var bufferedImage : BufferedImage = null

    //Constructor
    {
        val anyType : Object = param_anyType
        val frame : _root_.java.lang.Long = param_frame
        val bufferedImage : BufferedImage = param_bufferedImage
        this.frame = frame
        this.setBufferedImage(bufferedImage)
    }

    def getBufferedImage() : BufferedImage = {
        return this.bufferedImage
    }

    private def setBufferedImage(bufferedImage : BufferedImage) : Unit = {
        this.bufferedImage = bufferedImage
    }

    def getFrame() : _root_.java.lang.Long = {
        return this.frame
    }

}


