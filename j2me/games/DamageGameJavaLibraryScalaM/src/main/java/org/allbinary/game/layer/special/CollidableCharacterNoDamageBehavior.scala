/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.collision.CollisionType
import _root_.org.allbinary.game.collision.CollisionTypeFactory
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil

class CollidableCharacterNoDamageBehavior(param_collidable : Boolean) extends CollidableDestroyableDamageableBehavior(param_collidable) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    override def collide(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        //this.logUtil.putF("collidableLayer", this, damageUtil.COLLIDE);        
        val collisionTypeFactory : CollisionTypeFactory = CollisionTypeFactory.getInstance()
        val collisionType : CollisionType = collidableInterfaceCompositeInterface.getCollidableInferface().getCollisionTypeWith(ownerLayer)
        if (collisionType eq collisionTypeFactory.PICKUP) {
            val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = ownerLayer.asInstanceOf[CollidableDestroyableDamageableLayer]
            collidableDestroyableDamageableLayer.getPickupBehavior().doPickupLayer(collidableInterfaceCompositeInterface.asInstanceOf[PickedUpLayerInterface])
        } else {
        }
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        //this.logUtil.putF("collideInterface", this, damageUtil.COLLIDE);
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
    }

}


