/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.org.allbinary.game.paint.FullScreenPaintable
import _root_.org.allbinary.graphics.paint.Paintable

/**  *  * @author User  */
class FullScreenPaintableFactory {
    import _root_.org.allbinary.graphics.displayable.screen.FullScreenPaintableFactory.{*}

    var paintable : Paintable = FullScreenPaintable.getInstance()

}

object FullScreenPaintableFactory {
    private val instance : FullScreenPaintableFactory = new FullScreenPaintableFactory()

    /**      * @return the instance      */
    def getInstance() : FullScreenPaintableFactory = {
        return FullScreenPaintableFactory.instance
    }

}


