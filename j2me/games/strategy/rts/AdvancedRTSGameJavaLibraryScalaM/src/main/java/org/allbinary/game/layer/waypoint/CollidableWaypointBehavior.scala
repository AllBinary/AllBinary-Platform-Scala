/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.CollidableRTSBehavior
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface

class CollidableWaypointBehavior(param_collidable : Boolean) extends CollidableRTSBehavior(param_collidable) {

    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    //public void collide(CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface)
    override def isCollision(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Boolean = {
        return false
    }

    override def collide(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Unit = {
    }

    override def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        return false
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterface : CollidableInterfaceCompositeInterface) : Unit = {
    }

}


