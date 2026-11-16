/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.game.layer.behavior.GameLayerBehavior
import _root_.org.allbinary.game.physics.acceleration.BasicAccelerationProperties
import _root_.org.allbinary.game.physics.velocity.VelocityProperties

/**  *  * @author User  */
class TopViewGameLayerBehavior(param_maxGravityActionIndex : Int) extends GameLayerBehavior {

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    var maxGravityActionIndex : Int = 0

    var isJumpAction : Boolean = true

    var isJumpOver : Boolean = false

    var isFallingWithoutJumpAttempt : Boolean = false

    // Action associated with jumping or falling
    var gravityActionIndex : Int = 0

    //Constructor
    {
        val maxGravityActionIndex : Int = param_maxGravityActionIndex
        this.maxGravityActionIndex = maxGravityActionIndex
    }

    def gravity() : Unit = {
        if (this.gravityActionIndex == 0) {
            this.gravityActionIndex += 1
            this.isFallingWithoutJumpAttempt = true
        }
    }

    def land(velocityProperties : VelocityProperties) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, "land");
        velocityProperties.getVelocityYBasicDecimalP().setint(0)
        this.landReset()
    }

    def landReset() : Unit = {
        this.gravityActionIndex = 0
        this.isFallingWithoutJumpAttempt = false
        this.isJumpAction = true
        this.isJumpOver = false
    }

    def up(velocityProperties : VelocityProperties, acceleration : BasicAccelerationProperties, jumpBehavior : InitialJumpBehavior, accelerationMultiplier : Int) : Unit = {
        if (!this.isJumpOver) {
            if (this.gravityActionIndex < this.maxGravityActionIndex) {
                val acceleration2 : Int = -acceleration.getForward() * accelerationMultiplier
                //this.logUtil.putF("Acceleration: " + acceleration2, this, this.commonStrings.UP);
                velocityProperties.getVelocityYBasicDecimalP().addint(acceleration2)
                //this.logUtil.putF("Jumping: " + velocityProperties.getVelocityYBasicDecimalP().getUnscaled(), this, this.commonStrings.UP);
                velocityProperties.limitXYToForwardAndReverseMaxVelocity()
                // this.getVelocityProperties().addVelocity(this.acceleration.getForward(), angle);
                this.gravityActionIndex += 1
            } else {
            }
        } else {
        }
        if (this.isJumpAction) {
            jumpBehavior.process()
            // jumpPlayer.start();
            this.isJumpAction = false
        }
    }

    def inputFrames(velocityProperties : VelocityProperties) : Unit = {
        if ((this.gravityActionIndex > 0) && (velocityProperties.getVelocityYBasicDecimalP().getUnscaled() > 0)) {
            //this.logUtil.putF("Falling from jump now", this, "inputFrames");
            this.isJumpOver = true
        }
    }

}


