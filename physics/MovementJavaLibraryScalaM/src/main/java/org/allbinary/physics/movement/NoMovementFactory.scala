/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.physics.movement


class NoMovementFactory {
    import _root_.org.allbinary.physics.movement.NoMovementFactory.{*}

    private val movement : Movement = new Movement()

    final def getMovmentInstance() : Movement = {
        return this.movement
    }

}

object NoMovementFactory {
    private val instance : NoMovementFactory = new NoMovementFactory()

    def getInstance() : NoMovementFactory = {
        return NoMovementFactory.instance
    }

}


