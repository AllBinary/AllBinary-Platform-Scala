/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.android.graphics.Paint
import _root_.android.graphics.PorterDuff
import _root_.android.graphics.PorterDuffColorFilter
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author User  */
class ImageModifierUtil {
    import _root_.org.allbinary.media.image.ImageModifierUtil.{*}

    //private final String SET_COLOR = "setBasicColor: ";
    val paint : Paint = new Paint(Paint.ANTI_ALIAS_FLAG)

    def setColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        //this.logUtil.putF(new StringMaker().append(SET_COLOR).append(basicColor.toString()).toString(), this, this.commonStrings.PROCESS);
        this.paint.setColorFilter(new PorterDuffColorFilter(basicColor.intValue(), PorterDuff.Mode.SRC_IN))
    }

    def changeColor(unusedOriginalImage : Image, image : Image, imageIndex : Int, basicColor : BasicColor) : Unit = {
        this.paint.setColorFilter(new PorterDuffColorFilter(basicColor.intValue(), PorterDuff.Mode.SRC_IN))
    }

    def setAlpha(originalImage : Image, image : Image, imageIndex : Int, alphaInt : Int) : Unit = {
        if (alphaInt != this.paint.getAlpha()) {
            this.paint.setAlpha(alphaInt)
        }
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
    //protected final CommonStrings commonStrings = CommonStrings.getInstance();
    def getInstanceOrCreate() : ImageModifierUtil = {
        return new ImageModifierUtil()
    }

}


