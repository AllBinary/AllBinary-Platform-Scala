/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity

import _root_.org.allbinary.logic.math.BasicDecimal

/**  *  * @author user  */
class DragVelocityBehavior extends VelocityBehaviorBase {
    import _root_.org.allbinary.game.physics.velocity.DragVelocityBehavior.{instance as _, *}
    def instance : DragVelocityBehavior = _root_.org.allbinary.game.physics.velocity.DragVelocityBehavior.instance

    override def reduce(velocityProperties : BasicVelocityProperties, nominator : Int, denominator : Int) : Unit = {
        //this.logUtil.putF("VelocityY: " + this.getVelocityYBasicDecimalP().getUnscaled(), this, "friction");
        if (velocityProperties.getVelocityXBasicDecimalP().getUnscaled() != 0L) {
            val basicDecimal : BasicDecimal = velocityProperties.getVelocityXBasicDecimalP()
            basicDecimal.multiplyint(nominator)
            basicDecimal.divideint(denominator)
        }
        if (velocityProperties.getVelocityYBasicDecimalP().getUnscaled() != 0L) {
            val basicDecimal : BasicDecimal = velocityProperties.getVelocityYBasicDecimalP()
            basicDecimal.multiplyint(nominator)
            basicDecimal.divideint(denominator)
        }
    }

    override def reduceX(velocityProperties : BasicVelocityProperties, nominator : Int, denominator : Int) : Unit = {
        val basicDecimal : BasicDecimal = velocityProperties.getVelocityXBasicDecimalP()
        if (basicDecimal.getUnscaled() != 0L) {
            basicDecimal.multiplyint(nominator)
            basicDecimal.divideint(denominator)
        }
    }

    override def reduceY(velocityProperties : BasicVelocityProperties, nominator : Int, denominator : Int) : Unit = {
        if (velocityProperties.getVelocityYBasicDecimalP().getUnscaled() != 0L) {
            val basicDecimal : BasicDecimal = velocityProperties.getVelocityYBasicDecimalP()
            basicDecimal.multiplyint(nominator)
            basicDecimal.divideint(denominator)
        }
    }

}

object DragVelocityBehavior {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    val instance : DragVelocityBehavior = new DragVelocityBehavior()

}


