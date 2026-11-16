/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.image.ImageModifierUtil

/**  *  * @author User  */
class SetColorProcessor extends ModifierBaseProcessor {
    import _root_.org.allbinary.animation.image.SetColorProcessor.{*}

    override def updateColor(imageModifierUtil : ImageModifierUtil, originalImage : Image, imageToShow : Image, index : Int, basicColor : BasicColor) : Unit = {
        imageModifierUtil.setColor(originalImage, imageToShow, index, basicColor)
    }

}

object SetColorProcessor {
    private val instanceC : SetColorProcessor = new SetColorProcessor()

    /**      * @return the instance      */
    def getInstance() : SetColorProcessor = {
        return SetColorProcessor.instanceC
    }

}


