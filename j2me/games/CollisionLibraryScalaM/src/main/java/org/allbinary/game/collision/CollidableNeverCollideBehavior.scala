/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.collision

import _root_.org.allbinary.game.layer.CollidableCompositeLayer

class CollidableNeverCollideBehavior(param_isCollidable : Boolean) extends CollidableBaseBehavior(param_isCollidable) {

    //Constructor
    {
        val isCollidable : Boolean = param_isCollidable
    }

    override def isCollision(ownerLayer : CollidableCompositeLayer, allbinaryCollidableLayer : CollidableCompositeLayer) : Boolean = {
        return false
    }

    override def collide(ownerLayer : CollidableCompositeLayer, allbinaryCollidableLayer : CollidableCompositeLayer) : Unit = {
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
    }

    override def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        return false
    }

}


