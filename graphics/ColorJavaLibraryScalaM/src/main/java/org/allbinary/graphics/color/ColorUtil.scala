/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.color

import _root_.java.awt.*

/**  *  * @author User  */
class ColorUtil {
    import _root_.org.allbinary.graphics.color.ColorUtil.{*}

    def isGreyishOrWhiteLike(color : Color) : Boolean = {
        //Grey/Black and Pastel/White do not have large deltas between RGB
        if (((Math.abs(color.getRed() - color.getGreen()) > 20) || (Math.abs(color.getRed() - color.getBlue()) > 20)) || (Math.abs(color.getGreen() - color.getBlue()) > 20)) {
            return false
        }
        return true
    }

    def isDark(color : Color) : Boolean = {
        if (((color.getRed() < 0x77) && (color.getRed() < 0x77)) && (color.getRed() < 0x77)) {
            return true
        }
        return false
    }

}

object ColorUtil {
    private val instance : ColorUtil = new ColorUtil()

    /**      * @return the instance      */
    def getInstance() : ColorUtil = {
        return ColorUtil.instance
    }

}


