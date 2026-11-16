/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.game.physics.velocity.VelocityInterfaceCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.math.vector.AxisMathVectorUtil
import _root_.org.allbinary.math.AngleFactory

/**  *   * @author user  */
class BasicConstantVelocityMovement(param_basicDecimal : BasicDecimal, param_velocityProperties : BasicVelocityProperties) extends Movement with VelocityInterfaceCompositeInterface {

    private var velocityProperties : BasicVelocityProperties = null

    private var speedBasicDecimal : BasicDecimal = BasicDecimal.ZERO_BIGDECIMAL

    private val axisMathVectorUtil : AxisMathVectorUtil = AxisMathVectorUtil.getInstance()

    //Constructor
    {
        val basicDecimal : BasicDecimal = param_basicDecimal
        val velocityProperties : BasicVelocityProperties = param_velocityProperties
        this.setSpeedBasicDecimal(basicDecimal)
        this.velocityProperties = velocityProperties
    }

    override def init(speedBasicDecimal : BasicDecimal, angle : Int, otherAngle : Int) : Unit = {
        this.speedBasicDecimal = speedBasicDecimal
        var angleFactory : AngleFactory = AngleFactory.getInstance()
        this.velocityProperties.setVelocityWithBigDecimal(speedBasicDecimal, angleFactory.getAt(angle), angleFactory.getAt(otherAngle))
    }

    def moveOutsideRadius(layer : AllBinaryLayer, radius : Long, angle : Int, otherAngle : Int) : Unit = {
        var scaleFactorValue : Int = this.speedBasicDecimal.getScaledFactorValue()
        var xVector : Int = (this.axisMathVectorUtil.calculateX(radius, angle) / scaleFactorValue).toInt
        var yVector : Int = (this.axisMathVectorUtil.calculateY(radius, angle) / scaleFactorValue).toInt
        var zVector : Int = (this.axisMathVectorUtil.calculateZ(radius, otherAngle) / scaleFactorValue).toInt
        layer.moveDXYZ(xVector, yVector, zVector)
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        layer.moveDXYZ(this.velocityProperties.getVelocityXBasicDecimalP().getScaled(), this.velocityProperties.getVelocityYBasicDecimalP().getScaled(), this.velocityProperties.getVelocityZBasicDecimalP().getScaled())
    }

    override def toString() : String = {
        return this.velocityProperties.toString()
    }

    override def stop() : Unit = {
        this.velocityProperties.zero()
    }

    override def getVelocityProperties() : BasicVelocityProperties = {
        return this.velocityProperties
    }

    def setVelocityProperties(velocityProperties : BasicVelocityProperties) : Unit = {
        this.velocityProperties = velocityProperties
    }

    def setSpeedBasicDecimal(speedBasicDecimal : BasicDecimal) : Unit = {
        this.speedBasicDecimal = speedBasicDecimal
    }

    def getSpeedBasicDecimal() : BasicDecimal = {
        return this.speedBasicDecimal
    }

}


