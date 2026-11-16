/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.canvas

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory

/**  *  * @author User  */
class GameGlobalsFactory {
    import _root_.org.allbinary.canvas.GameGlobalsFactory.{*}

    var newCanvas : Boolean = true

    var newDisplaybleTime : Long = Integer.MIN_VALUE.toLong

    var point : GPoint = PointFactory.getInstance().ZERO_ZERO

}

object GameGlobalsFactory {
    private val instance : GameGlobalsFactory = new GameGlobalsFactory()

    /**      * @return the instance      */
    def getInstance() : GameGlobalsFactory = {
        return GameGlobalsFactory.instance
    }

}


