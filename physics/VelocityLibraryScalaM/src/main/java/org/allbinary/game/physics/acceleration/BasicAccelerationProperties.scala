/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.acceleration


class BasicAccelerationProperties(param_forward : Int, param_reverse : Int) {

    private var forward : Int = 0

    private var reverse : Int = 0

    //Constructor
    {
        val forward : Int = param_forward
        val reverse : Int = param_reverse
        this.setForward(forward)
        this.setReverse(reverse)
    }

    def setReverse(reverse : Int) : Unit = {
        this.reverse = reverse
    }

    def getReverse() : Int = {
        return this.reverse
    }

    def setForward(forward : Int) : Unit = {
        this.forward = forward
    }

    def getForward() : Int = {
        return this.forward
    }

}


