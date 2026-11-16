/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.platform.graphics

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory

/**  *  * @author User  */
class PlatformBitmapBase {
    import _root_.org.allbinary.platform.graphics.PlatformBitmapBase.{NULL_PLATFORM_BITMAP_BASE as _, *}
    def NULL_PLATFORM_BITMAP_BASE : PlatformBitmapBase = _root_.org.allbinary.platform.graphics.PlatformBitmapBase.NULL_PLATFORM_BITMAP_BASE

    var alpha : Int = 255

    var basicColor : BasicColor = BasicColorFactory.getInstance().NULL_COLOR

    def getWidth() : Int = {
        return 0
    }

    def getHeight() : Int = {
        return 0
    }

    def getImage() : Image = {
        return NullImage.NULL_IMAGE
    }

}

object PlatformBitmapBase {
    val NULL_PLATFORM_BITMAP_BASE : PlatformBitmapBase = new PlatformBitmapBase()

}


