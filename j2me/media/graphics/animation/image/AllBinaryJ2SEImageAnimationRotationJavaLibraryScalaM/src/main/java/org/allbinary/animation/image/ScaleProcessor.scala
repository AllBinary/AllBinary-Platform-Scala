/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.media.image.ImageScaleUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class ScaleProcessor extends ScaleBaseProcessor {
    import _root_.org.allbinary.animation.image.ScaleProcessor.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val imageScaleUtil : ImageScaleUtil = ImageScaleUtil.getInstance()

    override def update(originalImage : Image, originalImageArray : Array[Image], ximageToShowArray : Array[Image], unused : Int, scaleX : Float, scaleY : Float, maxScaleX : Float, maxScaleY : Float) : Unit = {
        try {
            this.imageScaleUtil.scale2(originalImage, originalImageArray, ximageToShowArray, unused, scaleX, scaleY, maxScaleX, maxScaleY)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.UPDATE, e)
            }
        }
    }

}

object ScaleProcessor {
    private val instanceC : ScaleProcessor = new ScaleProcessor()

    /**      * @return the instance      */
    def getInstance() : ScaleBaseProcessor = {
        return ScaleProcessor.instanceC
    }

}


