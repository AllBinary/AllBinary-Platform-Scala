/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.image.ImageModifierUtil

/**  *  * @author User  */
class ChangeColorProcessor extends ModifierBaseProcessor {
    import _root_.org.allbinary.animation.image.ChangeColorProcessor.{*}

    override def updateColor(imageModifierUtil : ImageModifierUtil, originalImage : Image, imageToShow : Image, index : Int, basicColor : BasicColor) : Unit = {
        imageModifierUtil.changeColor(originalImage, imageToShow, index, basicColor)
    }

}

object ChangeColorProcessor {
    private val instanceC : ChangeColorProcessor = new ChangeColorProcessor()

    /**      * @return the instance      */
    def getInstance() : ChangeColorProcessor = {
        return ChangeColorProcessor.instanceC
    }

}


