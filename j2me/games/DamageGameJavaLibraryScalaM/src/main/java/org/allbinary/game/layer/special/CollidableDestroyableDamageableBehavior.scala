/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.org.allbinary.game.collision.CollidableBaseBehavior
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.combat.damage.DamageUtil
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil

class CollidableDestroyableDamageableBehavior(param_collidable : Boolean) extends CollidableBaseBehavior(param_collidable) {

    val damageUtil : DamageUtil = DamageUtil.getInstance()

    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def isCollision(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Boolean = {
        if (ownerLayer.getGroupInterface()(0) ne collisionLayer.getGroupInterface()(0)) {
            return super.isCollision(ownerLayer, collisionLayer)
        }
        return false
    }

    //public void collide(CollidableDestroyableDamageableTeamLayer collisionLayer)
    override def collide(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        val ownerCollidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = ownerLayer.asInstanceOf[CollidableDestroyableDamageableLayer]
        val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = collidableInterfaceCompositeInterface.asInstanceOf[CollidableDestroyableDamageableLayer]
        ownerCollidableDestroyableDamageableLayer.damage(collidableDestroyableDamageableLayer.getDamage(0), 0)
    }

    override def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        ForcedLogUtil.log("No Longer Used", this)
        return false
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        ForcedLogUtil.log("No Longer Used", this)
    }

}


