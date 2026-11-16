/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.microemu.device.playn.PlaynMutableImage
import _root_.playn.core.CanvasImage
import _root_.playn.core.CanvasSurface

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    def setColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
    }

    def changeColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
    }

    def setAlpha(originalImage : Image, image : Image, imageIndex : Int, alphaInt : Int) : Unit = {
    }

    def getImageArray(originalImageArray : Array[Image]) : Array[Image] = {
        return originalImageArray
    }

    def handleImage(imageArray : Array[Image], index : Int, image : Image) : Unit = {
    }

    def reset() : Unit = {
    }

}

object ImageModifierUtil {
    private val instance : ImageModifierUtil = new ImageModifierUtil()

    /**      * @return the instance      */
    def getInstanceOrCreate() : ImageModifierUtil = {
        return ImageModifierUtil.instance
    }

}


