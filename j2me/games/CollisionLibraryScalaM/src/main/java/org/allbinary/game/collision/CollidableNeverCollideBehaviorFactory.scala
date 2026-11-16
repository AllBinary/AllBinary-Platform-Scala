/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision


class CollidableNeverCollideBehaviorFactory extends CollidableBaseBehaviorFactory {
    import _root_.org.allbinary.game.collision.CollidableNeverCollideBehaviorFactory.{*}

    private val instance : CollidableNeverCollideBehavior = new CollidableNeverCollideBehavior(false)

    override def createBehavior() : CollidableBaseBehavior = {
        return this.instance
    }

}

object CollidableNeverCollideBehaviorFactory {
    private val instanceC : CollidableNeverCollideBehaviorFactory = new CollidableNeverCollideBehaviorFactory()

    /**      * @return the instance2      */
    def getInstance() : CollidableNeverCollideBehaviorFactory = {
        return CollidableNeverCollideBehaviorFactory.instanceC
    }

}


