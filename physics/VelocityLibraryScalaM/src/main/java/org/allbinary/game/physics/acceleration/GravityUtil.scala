/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.acceleration

import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties

/**  *   * @author user  */
class GravityUtil {
    import _root_.org.allbinary.game.physics.acceleration.GravityUtil.{*}

    //6900; // 800;
    val GAME_GRAVITY_VELOCITY : Int = 1800

    //9600;
    val MAX_GAME_VELOCITY : Int = 18000

    final def process(velocityProperties : BasicVelocityProperties, customGravity : Int) : Unit = {
        velocityProperties.getVelocityYBasicDecimalP().addint(customGravity)
    }

}

object GravityUtil {
    private val instance : GravityUtil = new GravityUtil()

    def getInstance() : GravityUtil = {
        return GravityUtil.instance
    }

}


