/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.java.io.IOException
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ImageArrayRotationUtil {
    import _root_.org.allbinary.media.image.ImageArrayRotationUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val TOTAL_ANGLE : String = "totalAngle: "

    def process(imageProcessorInput : ImageProcessorInput, input : String, visitor : ImageProcessedVisitor) : Unit = {
        var totalAngle : Integer = null
        if (input eq this.commonStrings.UP) {
            totalAngle = Integer.valueOf(-90)
        } else if (input eq this.commonStrings.DOWN) {
            totalAngle = Integer.valueOf(90)
        } else {
            totalAngle = Integer.valueOf(input)
        }
        var generatedBufferedImage : BufferedImage = null
        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()

        {
            var index : Int = 0
            while (index < bufferedImageArray.length) {
                this.logUtil.putF(this.TOTAL_ANGLE + totalAngle, this, this.commonStrings.RUN)
                generatedBufferedImage = ImageJ2SERotationUtil.getInstance().getRotatedImage(bufferedImageArray(index), totalAngle.intValue())
                visitor.visit(generatedBufferedImage, input, index)
                index += 1
            }
        }
    }

}

object ImageArrayRotationUtil {
    private val instance : ImageArrayRotationUtil = new ImageArrayRotationUtil()

    /**      * @return the instance      */
    def getInstance() : ImageArrayRotationUtil = {
        return ImageArrayRotationUtil.instance
    }

}


