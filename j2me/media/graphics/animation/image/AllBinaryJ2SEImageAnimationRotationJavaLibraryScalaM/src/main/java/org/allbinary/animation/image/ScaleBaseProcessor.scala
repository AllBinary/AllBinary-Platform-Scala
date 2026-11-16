/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image

/**  *  * @author User  */
class ScaleBaseProcessor {
    import _root_.org.allbinary.animation.image.ScaleBaseProcessor.{*}

    def update(originalImage : Image, originalImageArray : Array[Image], imageToShowArray : Array[Image], index : Int, scaleX : Float, scaleY : Float, maxScaleX : Float, maxScaleY : Float) : Unit = {
    }

}

object ScaleBaseProcessor {
    private val instance : ScaleBaseProcessor = new ScaleBaseProcessor()

    /**      * @return the instance      */
    def getInstance() : ScaleBaseProcessor = {
        return ScaleBaseProcessor.instance
    }

}


