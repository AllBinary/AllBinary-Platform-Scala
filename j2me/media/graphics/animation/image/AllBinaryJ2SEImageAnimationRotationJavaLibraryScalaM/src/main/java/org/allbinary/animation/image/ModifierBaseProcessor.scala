/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.media.image.ImageModifierUtil

/**  *  * @author User  */
class ModifierBaseProcessor {
    import _root_.org.allbinary.animation.image.ModifierBaseProcessor.{*}

    def updateColor(imageModifierUtil : ImageModifierUtil, originalImage : Image, imageToShow : Image, index : Int, basicColor : BasicColor) : Unit = {
    }

    def updateAlpha(imageModifierUtil : ImageModifierUtil, originalImage : Image, imageToShow : Image, index : Int, alpha : Int) : Unit = {
    }

}

object ModifierBaseProcessor {
    private val instance : ModifierBaseProcessor = new ModifierBaseProcessor()

    /**      * @return the instance      */
    def getInstance() : ModifierBaseProcessor = {
        return ModifierBaseProcessor.instance
    }

}


