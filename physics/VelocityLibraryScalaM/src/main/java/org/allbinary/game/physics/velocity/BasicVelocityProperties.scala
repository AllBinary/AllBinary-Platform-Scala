/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity

import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.BasicDecimal
import _root_.org.allbinary.logic.math.vector.AxisMathVectorUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.Angle
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps

class BasicVelocityProperties() extends BasicVelocityInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    var velocityXBasicDecimal : BasicDecimal = null

    var velocityYBasicDecimal : BasicDecimal = null

    var velocityZBasicDecimal : BasicDecimal = null

    private val axisMathVectorUtil : AxisMathVectorUtil = AxisMathVectorUtil.getInstance()

    val directionUtil : DirectionUtil = DirectionUtil.getInstance()

    //Constructor
    {
        this.velocityXBasicDecimal = new BasicDecimal(0)
        this.velocityYBasicDecimal = new BasicDecimal(0)
        this.velocityZBasicDecimal = new BasicDecimal(0)
    }

    override def zero() : Unit = {
        this.velocityXBasicDecimal.setint(0)
        this.velocityYBasicDecimal.setint(0)
        this.velocityZBasicDecimal.setint(0)
    }

    override def getVelocityXBasicDecimalP() : BasicDecimal = {
        return this.velocityXBasicDecimal
    }

    /*     public void setVelocityXBasicDecimal(BasicDecimal velocityXBasicDecimal)     {         this.velocityXBasicDecimal = velocityXBasicDecimal;     }     */
    override def getVelocityYBasicDecimalP() : BasicDecimal = {
        return this.velocityYBasicDecimal
    }

    /*     public void setVelocityYBasicDecimal(BasicDecimal velocityYBasicDecimal)     {         this.velocityYBasicDecimal = velocityYBasicDecimal;     }     */
    def getVelocityZBasicDecimalP() : BasicDecimal = {
        return this.velocityZBasicDecimal
    }

    override def setVelocityWithBigDecimalAndDirection(magnitudeBasicDecimal : BasicDecimal, direction : Direction, otherDirection : Direction) : Unit = {
        val angle : Angle = this.directionUtil.getAngle(direction)
        val otherAngle : Angle = this.directionUtil.getAngle(otherDirection)
        this.setVelocityWithBigDecimal(magnitudeBasicDecimal, angle, otherAngle)
    }

    override def setVelocityWithDirection(magnitude : Long, direction : Direction, otherDirection : Direction) : Unit = {
        val angle : Angle = this.directionUtil.getAngle(direction)
        val otherAngle : Angle = this.directionUtil.getAngle(otherDirection)
        this.setVelocity(magnitude, angle, otherAngle)
    }

    override def addVelocityWithBigDecimalAndDirection(magnitudeBasicDecimal : BasicDecimal, direction : Direction, otherDirection : Direction) : Unit = {
        val angle : Angle = this.directionUtil.getAngle(direction)
        val otherAngle : Angle = this.directionUtil.getAngle(otherDirection)
        this.addVelocityWithBigDecimal(magnitudeBasicDecimal, angle, otherAngle)
    }

    override def addVelocityWithDirection(magnitude : Long, direction : Direction, otherDirection : Direction) : Unit = {
        val angle : Angle = this.directionUtil.getAngle(direction)
        val otherAngle : Angle = this.directionUtil.getAngle(otherDirection)
        this.addVelocity(magnitude, angle, otherAngle)
    }

    override def setVelocityWithBigDecimal(magnitudeBasicDecimal : BasicDecimal, angle : Angle, otherAngle : Angle) : Unit = {
        val magnitude : Long = magnitudeBasicDecimal.getUnscaled()
        this.setVelocity(magnitude, angle, otherAngle)
    }

    override def addVelocityWithBigDecimal(magnitudeBasicDecimal : BasicDecimal, angle : Angle, otherAngle : Angle) : Unit = {
        val magnitude : Long = magnitudeBasicDecimal.getUnscaled()
        this.addVelocity(magnitude, angle, otherAngle)
    }

    override def setVelocity(magnitude : Long, angle : Angle, otherAngle : Angle) : Unit = {
        this.setVelocityi(magnitude, angle.getValue().toInt, otherAngle.getValue().toInt)
    }

    override def addVelocity(magnitude : Long, angle : Angle, otherAngle : Angle) : Unit = {
        this.addVelocityi(magnitude, angle.getValue().toInt, otherAngle.getValue().toInt)
    }

    def setVelocityi(magnitude : Long, angle : Int, otherAngle : Int) : Unit = {
        val xVector : Long = (this.axisMathVectorUtil.calculateX(magnitude, angle) / this.velocityXBasicDecimal.getScaledFactorValue())
        val yVector : Long = (this.axisMathVectorUtil.calculateY(magnitude, angle) / this.velocityYBasicDecimal.getScaledFactorValue())
        val zVector : Long = (this.axisMathVectorUtil.calculateZ(magnitude, otherAngle) / this.velocityZBasicDecimal.getScaledFactorValue())
        // BlowingInTheWindTestInput.getInstance().append(stringBuffer.toString());
        this.velocityXBasicDecimal.setlong(xVector)
        this.velocityYBasicDecimal.setlong(yVector)
        this.velocityZBasicDecimal.setlong(zVector)
    }

    override def addVelocityi(magnitude : Long, angle : Int, otherAngle : Int) : Unit = {
        val xVector : Long = (this.axisMathVectorUtil.calculateX(magnitude, angle) / this.velocityXBasicDecimal.getScaledFactorValue())
        val yVector : Long = (this.axisMathVectorUtil.calculateY(magnitude, angle) / this.velocityYBasicDecimal.getScaledFactorValue())
        val zVector : Long = (this.axisMathVectorUtil.calculateZ(magnitude, otherAngle) / this.velocityZBasicDecimal.getScaledFactorValue())
        //this.logUtil.putF(this.toString(), this, this.commonStrings.ADD);
        this.velocityXBasicDecimal.addlong(xVector)
        this.velocityYBasicDecimal.addlong(yVector)
        this.velocityZBasicDecimal.addlong(zVector)
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val positionStrings : PositionStrings = PositionStrings.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append("Velocity ")
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.append(stringUtil.toString(this.velocityXBasicDecimal))
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.append(stringUtil.toString(this.velocityYBasicDecimal))
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.append(stringUtil.toString(this.velocityZBasicDecimal))
        return stringBuffer.toString()
    }

}


