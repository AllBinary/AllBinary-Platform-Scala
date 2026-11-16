/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image

import _root_.org.allbinary.input.media.image.capture.CapturedImageInputOutput
import _root_.org.allbinary.media.image.comparison.ComparisonImageInputOutput
import _root_.org.allbinary.media.image.comparison.motion.MotionRectanglesImageInputOutput
import _root_.org.allbinary.media.image.io.ImageIOInterface

class InputImageIOInterfaceFactory private() {
    import _root_.org.allbinary.input.media.image.InputImageIOInterfaceFactory.{*}

}

object InputImageIOInterfaceFactory {
    def getInstance(imageType : InputImageType) : ImageIOInterface = {
        if (imageType eq InputImageType.CAPTURE) {
            return new CapturedImageInputOutput()
        } else if (imageType eq InputImageType.COMPARISON) {
            return new ComparisonImageInputOutput()
        } else if (imageType eq InputImageType.MOTION) {
            return new MotionRectanglesImageInputOutput()
        } else {
            throw new Exception("No ImageIOInterface for: " + imageType.toString())
        }
        throw new IllegalStateException()
    }

}


