/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.graphics.hud

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory

class HudGraphicsPosition(param_point : GPoint, param_anchor : Int) {
    import _root_.org.allbinary.game.graphics.hud.HudGraphicsPosition.{NULL_HUD_GRAPHICS_POSITION as _, *}
    def NULL_HUD_GRAPHICS_POSITION : HudGraphicsPosition = _root_.org.allbinary.game.graphics.hud.HudGraphicsPosition.NULL_HUD_GRAPHICS_POSITION

    private var anchor : Int = 0

    private var point : GPoint = PointFactory.getInstance().ZERO_ZERO

    //Constructor
    {
        val point : GPoint = param_point
        val anchor : Int = param_anchor
        this.setAnchor(anchor)
        this.setPoint(point)
    }

    def getAnchor() : Int = {
        return this.anchor
    }

    private def setAnchor(anchor : Int) : Unit = {
        this.anchor = anchor
    }

    def getPoint() : GPoint = {
        return this.point
    }

    def setPoint(point : GPoint) : Unit = {
        this.point = point
    }

}

object HudGraphicsPosition {
    val NULL_HUD_GRAPHICS_POSITION : HudGraphicsPosition = new HudGraphicsPosition(PointFactory.getInstance().ZERO_ZERO, 9)

}


