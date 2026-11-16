/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.terrain

import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.AngleFactory

class BasicTerrainInfo(param_angle : Angle) {
    import _root_.org.allbinary.game.terrain.BasicTerrainInfo.{NULL_BASIC_TERRAIN_INFO as _, *}
    def NULL_BASIC_TERRAIN_INFO : BasicTerrainInfo = _root_.org.allbinary.game.terrain.BasicTerrainInfo.NULL_BASIC_TERRAIN_INFO

    private var angle : Angle = null

    //Constructor
    {
        val angle : Angle = param_angle
        this.angle = angle
    }

    def getAngle() : Angle = {
        return this.angle
    }

    def setAngle(angle : Angle) : Unit = {
        this.angle = angle
    }

}

object BasicTerrainInfo {
    val NULL_BASIC_TERRAIN_INFO : BasicTerrainInfo = new BasicTerrainInfo(AngleFactory.getInstance().NOT_ANGLE)

}


