/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class CanvasExpandUtil {
    import _root_.org.allbinary.media.image.CanvasExpandUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonSeps commonSeps = CommonSeps.getInstance();
    private val stringUtil : StringUtil = StringUtil.getInstance()

    def process(imageProcessorInput : ImageProcessorInput, increaseX : Int, increaseY : Int, visitor : ImageProcessedVisitor) : Unit = {
        val imageUtil : ImageUtil = ImageUtil.getInstance()
        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()
        val subBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](bufferedImageArray.length)
        val size : Int = bufferedImageArray.length
        var bufferedImage : BufferedImage = null

        {
            var index : Int = 0
            while (index < size) {
                bufferedImage = bufferedImageArray(index)
                //this.logUtil.putF(spriteType, this, this.commonStrings.RUN);
                subBufferedImageArray(index) = imageUtil.createBufferedImage(bufferedImage, bufferedImage.getWidth() + increaseX, bufferedImage.getHeight() + increaseY, false)
                visitor.visit(subBufferedImageArray(index), this.stringUtil.EMPTY_STRING, index)
                index += 1
            }
        }
    }

}

object CanvasExpandUtil {
    private val instance : CanvasExpandUtil = new CanvasExpandUtil()

    /**      * @return the instance      */
    def getInstance() : CanvasExpandUtil = {
        return CanvasExpandUtil.instance
    }

}


