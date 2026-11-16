/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.game.physics.velocity.VelocityProperties
import _root_.org.allbinary.logic.math.BasicDecimal

class XYOscillateVelocityMovement(param_speedBasicDecimal : BasicDecimal, param_oscillateMin : Int, param_oscillateMax : Int) extends BasicConstantVelocityMovement(param_speedBasicDecimal, new VelocityProperties(param_speedBasicDecimal.getUnscaled().toInt, param_speedBasicDecimal.getUnscaled().toInt)) {

    private var oscillateMin : Int = 0

    private var oscillateMax : Int = 0

    private var oscillate : Int = 0

    private var oscillatePositive : Boolean = false

    //Constructor
    {
        val speedBasicDecimal : BasicDecimal = param_speedBasicDecimal
        val oscillateMin : Int = param_oscillateMin
        val oscillateMax : Int = param_oscillateMax
        this.oscillateMin = oscillateMin
        this.oscillateMax = oscillateMax
    }

    override def process(layer : AllBinaryGameLayer) : Unit = {
        super.process(layer)
        if (this.oscillate < this.oscillateMin) {
            this.oscillatePositive = true
            this.getVelocityProperties().getVelocityYBasicDecimalP().addint(3000)
        } else if (this.oscillate > this.oscillateMax) {
            this.oscillatePositive = false
            this.getVelocityProperties().getVelocityYBasicDecimalP().subtractint(3000)
        }
        if (this.oscillatePositive) {
            this.oscillate += 1
            this.getVelocityProperties().getVelocityXBasicDecimalP().addint(5000)
        } else {
            this.oscillate -= 1
            this.getVelocityProperties().getVelocityXBasicDecimalP().subtractint(5000)
        }
    }

}


