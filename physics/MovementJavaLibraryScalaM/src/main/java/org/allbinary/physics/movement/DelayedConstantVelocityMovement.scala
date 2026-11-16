/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper

class DelayedConstantVelocityMovement(param_basicDecimal : BasicDecimal, param_velocityProperties : BasicVelocityProperties) extends BasicConstantVelocityMovement(param_basicDecimal, param_velocityProperties) {

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(60)

    //Constructor
    {
        val basicDecimal : BasicDecimal = param_basicDecimal
        val velocityProperties : BasicVelocityProperties = param_velocityProperties
    }

    override def init(speedBasicDecimal : BasicDecimal, angle : Int, otherAngle : Int) : Unit = {
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        if (this.timeDelayHelper.isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            super.process(layer)
        }
    }

}


