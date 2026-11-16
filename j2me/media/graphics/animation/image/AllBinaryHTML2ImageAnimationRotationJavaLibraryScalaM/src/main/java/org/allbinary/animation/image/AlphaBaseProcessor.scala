/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.media.image.ImageModifierUtil

/**  *  * @author User  */
class AlphaBaseProcessor {
    import _root_.org.allbinary.animation.image.AlphaBaseProcessor.{*}

    def setAlpha(imageModifierUtil : ImageModifierUtil, originalImage : Image, imageToShow : Image, alpha : Int) : Unit = {
    }

}

object AlphaBaseProcessor {
    private val instance : AlphaBaseProcessor = new AlphaBaseProcessor()

    /**      * @return the instance      */
    def getInstance() : AlphaBaseProcessor = {
        return AlphaBaseProcessor.instance
    }

}


