/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.acceleration.GravityUtil
import _root_.org.allbinary.game.physics.velocity.VelocityProperties
import _root_.org.allbinary.logic.math.BasicDecimal

/**  *  * @author user  */
class BasicGravityConstantVelocityMovement(param_speedBasicDecimal : BasicDecimal) extends BasicConstantVelocityMovement(param_speedBasicDecimal, new VelocityProperties(param_speedBasicDecimal.getUnscaled().toInt, param_speedBasicDecimal.getUnscaled().toInt)) {

    private val gravityUtil : GravityUtil = GravityUtil.getInstance()

    //Constructor
    {
        val speedBasicDecimal : BasicDecimal = param_speedBasicDecimal
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        super.process(layer)
        this.gravityUtil.process(this.getVelocityProperties(), this.gravityUtil.GAME_GRAVITY_VELOCITY)
    }

}


