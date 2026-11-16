/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.platform.opengles

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class PlatformTextureBaseFactory {
    import _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory.{NULL_PLATFORM_TEXTURE_BASE_FACTORY as _, *}
    def NULL_PLATFORM_TEXTURE_BASE_FACTORY : PlatformTextureBaseFactory = _root_.org.allbinary.platform.opengles.PlatformTextureBaseFactory.NULL_PLATFORM_TEXTURE_BASE_FACTORY

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def load(gl : GL10, target : Int, level : Int, image : Image, border : Int, flip : Boolean) : Unit = {
    }

}

object PlatformTextureBaseFactory {
    val NULL_PLATFORM_TEXTURE_BASE_FACTORY : PlatformTextureBaseFactory = new PlatformTextureBaseFactory()

}


