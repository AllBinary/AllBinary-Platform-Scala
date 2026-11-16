/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision


class CollidableAlwaysPickupNeverCollideBehaviorFactory extends CollidableBaseBehaviorFactory {
    import _root_.org.allbinary.game.collision.CollidableAlwaysPickupNeverCollideBehaviorFactory.{*}

    private val instance : CollidableAlwaysPickupNeverCollideBehavior = new CollidableAlwaysPickupNeverCollideBehavior()

    override def createBehavior() : CollidableBaseBehavior = {
        return this.instance
    }

}

object CollidableAlwaysPickupNeverCollideBehaviorFactory {
    private val instanceC : CollidableAlwaysPickupNeverCollideBehaviorFactory = new CollidableAlwaysPickupNeverCollideBehaviorFactory()

    /**      * @return the instance2      */
    def getInstance() : CollidableAlwaysPickupNeverCollideBehaviorFactory = {
        return CollidableAlwaysPickupNeverCollideBehaviorFactory.instanceC
    }

}


