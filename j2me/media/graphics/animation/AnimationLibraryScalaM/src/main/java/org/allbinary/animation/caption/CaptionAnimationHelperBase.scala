/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.caption

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author User  */
class CaptionAnimationHelperBase extends Animation {
    import _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase.{INSTANCE as _, *}
    def INSTANCE : CaptionAnimationHelperBase = _root_.org.allbinary.animation.caption.CaptionAnimationHelperBase.INSTANCE

    def isShowing() : Boolean = {
        return false
    }

    def tick() : Unit = {
    }

    def update(message : String, basicColor : BasicColor) : Unit = {
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

}

object CaptionAnimationHelperBase {
    val INSTANCE : CaptionAnimationHelperBase = new CaptionAnimationHelperBase()

}


