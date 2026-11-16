/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity


class VelocityProperties(param_maxForwardVelocity : Int, param_maxReverseVelocity : Int) extends BasicVelocityProperties with VelocityInterface {
    import _root_.org.allbinary.game.physics.velocity.VelocityProperties.{NULL_VELOCITY_PROPERTIES as _, *}
    def NULL_VELOCITY_PROPERTIES : VelocityProperties = _root_.org.allbinary.game.physics.velocity.VelocityProperties.NULL_VELOCITY_PROPERTIES

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var maxForwardVelocity : Int = 0

    private var maxReverseVelocity : Int = 0

    //Constructor
    {
        val maxForwardVelocity : Int = param_maxForwardVelocity
        val maxReverseVelocity : Int = param_maxReverseVelocity
        this.setMaxForwardVelocity(maxForwardVelocity)
        this.setMaxReverseVelocity(maxReverseVelocity)
    }

    /*       public void setMaxVelocity(Direction direction)    {       int magnitude = this.getMaxForwardVelocity();       super.setVelocity(magnitude, direction);    }     public void setMaxVelocity(Angle angle)    {       int magnitude = this.getMaxForwardVelocity();       super.setVelocity(magnitude, angle);    }      public void setMaxXVelocity(int multiply)    {       this.getVelocityXBasicDecimalP().set(this.getMaxForwardVelocity() * multiply);    }     public void setMaxYVelocity(int multiply)    {       this.getVelocityYBasicDecimalP().set(this.getMaxForwardVelocity() * multiply);    } */
    override def getMaxForwardVelocity() : Int = {
        return this.maxForwardVelocity
    }

    override def setMaxForwardVelocity(maxForwardVelocity : Int) : Unit = {
        this.maxForwardVelocity = maxForwardVelocity
    }

    override def getMaxReverseVelocity() : Int = {
        return this.maxReverseVelocity
    }

    override def setMaxReverseVelocity(maxReverseVelocity : Int) : Unit = {
        this.maxReverseVelocity = maxReverseVelocity
    }

    override def limitMaxXYForwardVelocity() : Unit = {
        this.limitMaxXYVelocity(this.getMaxForwardVelocity())
    }

    override def limitMaxXYReverseVelocity() : Unit = {
        this.limitMaxXYVelocity(this.getMaxReverseVelocity())
    }

    def limitMaxYForwardVelocity() : Unit = {
        this.limitMaxYVelocity(this.getMaxForwardVelocity())
    }

    def limitMaxYReverseVelocity() : Unit = {
        this.limitMaxYVelocity(this.getMaxReverseVelocity())
    }

    def limitMaxXForwardVelocity() : Unit = {
        this.limitMaxXVelocity(this.getMaxForwardVelocity())
    }

    def limitMaxXReverseVelocity() : Unit = {
        this.limitMaxXVelocity(this.getMaxReverseVelocity())
    }

    def isOverXYMaxForwardVelocity() : Boolean = {
        return this.isOverXYMaxVelocity(this.getMaxForwardVelocity())
    }

    def isOverXYMaxReverseVelocity() : Boolean = {
        return this.isOverXYMaxVelocity(this.getMaxReverseVelocity())
    }

    override def limitXYToForwardAndReverseMaxVelocity() : Unit = {
        //this.logUtil.putF("Limit Velocity", this, "limitMaxVelocity");
        this.limitMaxXYForwardVelocity()
        this.limitMaxXYReverseVelocity()
    }

    //Not very realistic but it keeps the game sane since the physics is bull
    override def limitMaxXYVelocity(maxVelocity : Int) : Unit = {
        this.limitMaxXVelocity(maxVelocity)
        this.limitMaxYVelocity(maxVelocity)
    }

    def limitMaxPositiveYVelocity(maxVelocity : Int) : Unit = {
        if (this.velocityYBasicDecimal.getUnscaled() > maxVelocity) {
            this.velocityYBasicDecimal.setint(maxVelocity)
        }
    }

    def limitMaxNegativeYVelocity(maxVelocity : Int) : Unit = {
        if (this.velocityYBasicDecimal.getUnscaled() < -maxVelocity) {
            this.velocityYBasicDecimal.setint(-maxVelocity)
        }
    }

    def limitMaxYVelocity(maxVelocity : Int) : Unit = {
        this.limitMaxPositiveYVelocity(maxVelocity)
        this.limitMaxNegativeYVelocity(maxVelocity)
    }

    def limitMaxXVelocity(maxVelocity : Int) : Unit = {
        if (this.velocityXBasicDecimal.getUnscaled() > maxVelocity) {
            this.velocityXBasicDecimal.setint(maxVelocity)
        }
        if (this.velocityXBasicDecimal.getUnscaled() < -maxVelocity) {
            this.velocityXBasicDecimal.setint(-maxVelocity)
        }
    }

    def isOverXYMaxVelocity(maxVelocity : Int) : Boolean = {
        if (this.velocityXBasicDecimal.getUnscaled() > maxVelocity) {
            return true
        }
        if (this.velocityXBasicDecimal.getUnscaled() < -maxVelocity) {
            return true
        }
        if (this.velocityYBasicDecimal.getUnscaled() > maxVelocity) {
            return true
        }
        if (this.velocityYBasicDecimal.getUnscaled() < -maxVelocity) {
            return true
        }
        return false
    }

    override def setVelocityi(magnitude : Long, angle : Int, otherAngle : Int) : Unit = {
        super.setVelocityi(magnitude, angle, otherAngle)
        this.limitXYToForwardAndReverseMaxVelocity()
    }

    override def addVelocityi(magnitude : Long, angle : Int, otherAngle : Int) : Unit = {
        super.addVelocityi(magnitude, angle, otherAngle)
        this.limitXYToForwardAndReverseMaxVelocity()
    }

}

object VelocityProperties {
    val NULL_VELOCITY_PROPERTIES : VelocityProperties = new VelocityProperties(0, 0)

}


