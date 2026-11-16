/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.platform.graphics

import _root_.javax.microedition.lcdui.Image

/**  *  * @author User  */
class PlatformBitmapBaseFactory {
    import _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory.{NULL_PLATFORM_BITMAP_BASE_FACTORY as _, *}
    def NULL_PLATFORM_BITMAP_BASE_FACTORY : PlatformBitmapBaseFactory = _root_.org.allbinary.platform.graphics.PlatformBitmapBaseFactory.NULL_PLATFORM_BITMAP_BASE_FACTORY

    def createBitmap(image : Image) : PlatformBitmapBase = {
        throw new RuntimeException()
    }

}

object PlatformBitmapBaseFactory {
    val NULL_PLATFORM_BITMAP_BASE_FACTORY : PlatformBitmapBaseFactory = new PlatformBitmapBaseFactory()

}


