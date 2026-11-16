/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision


/**  *  * @author Berthelot, Travis  * @version 1.0  */
class CollisionTypeFactory {
    import _root_.org.allbinary.game.collision.CollisionTypeFactory.{*}

    var NONE : CollisionType = new CollisionType("None")

    var DAMAGE : CollisionType = new CollisionType("Damage")

    var PICKUP : CollisionType = new CollisionType("Pickup")

    var COLLISION : CollisionType = new CollisionType("Collision")

}

object CollisionTypeFactory {
    private var SINGLETON : CollisionTypeFactory = new CollisionTypeFactory()

    def getInstance() : CollisionTypeFactory = {
        return CollisionTypeFactory.SINGLETON
    }

}


