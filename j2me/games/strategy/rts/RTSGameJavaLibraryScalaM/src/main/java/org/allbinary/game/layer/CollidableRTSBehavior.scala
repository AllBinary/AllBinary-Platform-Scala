/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.collision.CollisionType
import _root_.org.allbinary.game.collision.CollisionTypeFactory
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableBehavior

class CollidableRTSBehavior(param_collidable : Boolean) extends CollidableDestroyableDamageableBehavior(param_collidable) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    //public void collide(CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface)
    override def isCollision(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Boolean = {
        val collisionTypeFactory : CollisionTypeFactory = CollisionTypeFactory.getInstance()
        val collisionType : CollisionType = collidableInterfaceCompositeInterface.getCollidableInferface().getCollisionTypeWith(ownerLayer)
        // collisionType.toString(), this, damageUtil.COLLIDE);
        if (collisionType eq collisionTypeFactory.PICKUP) {
        } else if (collisionType eq collisionTypeFactory.COLLISION) {
            return super.isCollision(ownerLayer, collidableInterfaceCompositeInterface)
        } else {
            if ((((collidableInterfaceCompositeInterface.getX2() <= ownerLayer.getXP()) || (collidableInterfaceCompositeInterface.getY2() <= ownerLayer.getYP())) || (collidableInterfaceCompositeInterface.getYP() >= ownerLayer.getY2())) || (collidableInterfaceCompositeInterface.getXP() >= ownerLayer.getX2())) {
                return false
            } else {
                // collisionLayer).getViewPosition().getY2(), this, // damageUtil.IS_COLLISION);
                return true
            }
        }
        return false
    }

    override def collide(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        val collisionTypeFactory : CollisionTypeFactory = CollisionTypeFactory.getInstance()
        val collisionType : CollisionType = collidableInterfaceCompositeInterface.getCollidableInferface().getCollisionTypeWith(ownerLayer)
        //this.logUtil.putF("collisionType: ").append(collisionType.toString(), this, damageUtil.COLLIDE);
        if (collisionType eq collisionTypeFactory.PICKUP) {
        } else if (collisionType eq collisionTypeFactory.COLLISION) {
            //this.logUtil.putF("isCollision: ").append(this.getGroupInterface().getGroupName()).append("==").append(((CollidableDestroyableDamageableLayer) collidableInterface).getGroupInterface().getGroupName(), this, damageUtil.IS_COLLISION);
            super.collide(ownerLayer, collidableInterfaceCompositeInterface)
        } else {
            this.collideNone(ownerLayer, collidableInterfaceCompositeInterface)
        }
    }

    def collideNone(ownerLayer : CollidableCompositeLayer, collidableInterface : CollidableCompositeLayer) : Unit = {
    }

}


