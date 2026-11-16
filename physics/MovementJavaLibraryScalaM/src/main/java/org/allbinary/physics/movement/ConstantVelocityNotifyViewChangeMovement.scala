/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.velocity.BasicVelocityProperties
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.math.vector.AxisMathVectorUtil
import _root_.org.allbinary.math.AngleFactory

/**  *  * @author user  */
class ConstantVelocityNotifyViewChangeMovement() extends Movement {

    var basicVelocityProperties : BasicVelocityProperties = null

    private var speedBasicDecimal : BasicDecimal = null

    private val axisMathVectorUtil : AxisMathVectorUtil = AxisMathVectorUtil.getInstance()

    //Constructor
    {
        this.speedBasicDecimal = BasicDecimal.ZERO_BIGDECIMAL
        this.basicVelocityProperties = new BasicVelocityProperties()
    }

    override def init(speedBasicDecimal : BasicDecimal, angle : Int, otherAngle : Int) : Unit = {
        this.speedBasicDecimal = speedBasicDecimal
        var angleFactory : AngleFactory = AngleFactory.getInstance()
        this.basicVelocityProperties.setVelocityWithBigDecimal(speedBasicDecimal, angleFactory.getAt(angle), angleFactory.getAt(otherAngle))
    }

    def moveOutsideRadius(layer : AllBinaryLayer, radius : Long, angle : Int, otherAngle : Int) : Unit = {
        var scaleFactorValue : Int = this.speedBasicDecimal.getScaledFactorValue()
        var xVector : Int = (this.axisMathVectorUtil.calculateX(radius, angle) / scaleFactorValue).toInt
        var yVector : Int = (this.axisMathVectorUtil.calculateY(radius, angle) / scaleFactorValue).toInt
        var zVector : Int = (this.axisMathVectorUtil.calculateZ(radius, otherAngle) / scaleFactorValue).toInt
        layer.moveDXYZ(xVector, yVector, zVector)
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        var x : Int = this.basicVelocityProperties.getVelocityXBasicDecimalP().getScaled()
        var y : Int = this.basicVelocityProperties.getVelocityYBasicDecimalP().getScaled()
        var z : Int = this.basicVelocityProperties.getVelocityZBasicDecimalP().getScaled()
        layer.moveDXYZ(x, y, z)
        if (((x != 0) || (y != 0)) || (z != 0)) {
            layer.onViewPositionChangeEvent()
        }
    }

    override def stop() : Unit = {
        this.basicVelocityProperties.zero()
    }

}


