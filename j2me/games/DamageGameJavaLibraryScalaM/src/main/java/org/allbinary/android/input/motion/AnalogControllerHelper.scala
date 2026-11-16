/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.motion

import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.time.TimeDelayHelper

class AnalogControllerHelper(param_reduceTimeFactor : Int) {

    private var reduceTimeFactor : Int = 0

    private val SCALE_VALUE : Int = AnalogControllerConfigurationFactory.getInstance().SCALE_VALUE

    private val rightTimeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val leftTimeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val downTimeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    private val upTimeElapsedHelper : TimeDelayHelper = new TimeDelayHelper(0)

    //Constructor
    {
        val reduceTimeFactor : Int = param_reduceTimeFactor
        this.reduceTimeFactor = reduceTimeFactor
    }

    def right(collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer, xAnalogValue : Int) : Unit = {
        this.rightTimeElapsedHelper.delay = ((this.SCALE_VALUE - xAnalogValue) >> this.reduceTimeFactor)
        if (this.rightTimeElapsedHelper.isTimeTNT()) {
            collidableDestroyableDamageableLayer.right()
        }
    }

    def left(collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer, xAnalogValue : Int) : Unit = {
        this.leftTimeElapsedHelper.delay = ((this.SCALE_VALUE + xAnalogValue) >> this.reduceTimeFactor)
        if (this.leftTimeElapsedHelper.isTimeTNT()) {
            collidableDestroyableDamageableLayer.left()
        }
    }

    def up(collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer, xAnalogValue : Int) : Unit = {
        this.upTimeElapsedHelper.delay = ((this.SCALE_VALUE - xAnalogValue) >> this.reduceTimeFactor)
        if (this.upTimeElapsedHelper.isTimeTNT()) {
            collidableDestroyableDamageableLayer.up()
        }
    }

    def down(collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer, xAnalogValue : Int) : Unit = {
        this.downTimeElapsedHelper.delay = ((this.SCALE_VALUE + xAnalogValue) >> this.reduceTimeFactor)
        if (this.downTimeElapsedHelper.isTimeTNT()) {
            collidableDestroyableDamageableLayer.down()
        }
    }

}


