/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.math.MathUtil
import _root_.org.allbinary.logic.math.ScaleFactorFactory

class PreciseConstantVelocityMovement(param_basicDecimal : BasicDecimal, param_velocityProperties : BasicVelocityProperties) extends BasicConstantVelocityMovement(param_basicDecimal, param_velocityProperties) {

    private var accumulatedX : Int = 0

    private var accumulatedY : Int = 0

    private var accumulatedZ : Int = 0

    private val factorValue : Int = ScaleFactorFactory.getInstance().DEFAULT_SCALE_VALUE

    //Constructor
    {
        val basicDecimal : BasicDecimal = param_basicDecimal
        val velocityProperties : BasicVelocityProperties = param_velocityProperties
    }

    override def init(speedBasicDecimal : BasicDecimal, angle : Int, otherAngle : Int) : Unit = {
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        val mathUtil : MathUtil = MathUtil.getInstance()
        val velocityProperties : BasicVelocityProperties = this.getVelocityProperties()
        this.accumulatedX = (this.accumulatedX + velocityProperties.getVelocityXBasicDecimalP().getUnscaled()).toInt
        this.accumulatedY = (this.accumulatedY + velocityProperties.getVelocityYBasicDecimalP().getUnscaled()).toInt
        this.accumulatedZ = (this.accumulatedZ + velocityProperties.getVelocityZBasicDecimalP().getUnscaled()).toInt
        layer.moveDXYZ(this.accumulatedX / this.factorValue, this.accumulatedY / this.factorValue, this.accumulatedZ / this.factorValue)
        if (mathUtil.abs(this.accumulatedX) > this.factorValue) {
            this.accumulatedX = 0
        }
        if (mathUtil.abs(this.accumulatedY) > this.factorValue) {
            this.accumulatedY = 0
        }
        if (mathUtil.abs(this.accumulatedZ) > this.factorValue) {
            this.accumulatedZ = 0
        }
    }

}


