/* Generated Code Do Not Modify */
package org.allbinary.game.input.analog

import _root_.org.allbinary.graphics.CustomGPoint

class AnalogLocationInput(param_playerId : Int) {
    import _root_.org.allbinary.game.input.analog.AnalogLocationInput.{NULL_ANALOG_LOCATION_INPUT as _, *}
    def NULL_ANALOG_LOCATION_INPUT : AnalogLocationInput = _root_.org.allbinary.game.input.analog.AnalogLocationInput.NULL_ANALOG_LOCATION_INPUT

    private var playerId : Int = 0

    private var customGPoint : CustomGPoint = null

    private var rz : Int = 0

    private var rightTrigger : Int = 0

    private var leftTrigger : Int = 0

    //Constructor
    {
        val playerId : Int = param_playerId
        this.playerId = playerId
        this.customGPoint = new CustomGPoint(0, 0, 0)
    }

    def getPlayerId() : Int = {
        return this.playerId
    }

    def getCustomGPoint() : CustomGPoint = {
        return this.customGPoint
    }

    def getRz() : Int = {
        return this.rz
    }

    def setRz(rz : Int) : Unit = {
        this.rz = rz
    }

    /**      * @return the rightTrigger      */
    def getRightTrigger() : Int = {
        return this.rightTrigger
    }

    /**      * @param rightTrigger the rightTrigger to set      */
    def setRightTrigger(rightTrigger : Int) : Unit = {
        this.rightTrigger = rightTrigger
    }

    /**      * @return the leftTrigger      */
    def getLeftTrigger() : Int = {
        return this.leftTrigger
    }

    /**      * @param leftTrigger the leftTrigger to set      */
    def setLeftTrigger(leftTrigger : Int) : Unit = {
        this.leftTrigger = leftTrigger
    }

}

object AnalogLocationInput {
    val NULL_ANALOG_LOCATION_INPUT : AnalogLocationInput = new AnalogLocationInput(-1)

}


