/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.org.allbinary.game.collision.CollidableHelperFactory
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.collision.CollisionHelper
import _root_.org.allbinary.game.collision.CollisionType
import _root_.org.allbinary.game.collision.CollisionTypeFactory
import _root_.org.allbinary.game.combat.damage.DamageableInterface
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableBehavior
import _root_.org.allbinary.layer.AllBinaryLayer

class CollidableDamageWeaponBehavior(param_collidable : Boolean) extends CollidableDestroyableDamageableBehavior(param_collidable) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var collided : Boolean = false

    var collisionHelper : CollisionHelper = null

    //Constructor
    {
        val collidable : Boolean = param_collidable
        this.setCollided(false)
        this.setCollidable(true)
        this.collisionHelper = CollidableHelperFactory.getInstance()
    }

    def init(sourceLayerInterface : AllBinaryLayer) : Unit = {
        this.setCollided(false)
        this.collisionHelper.setOwnerLayerInterface(sourceLayerInterface)
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def isCollision(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Boolean = {
        if (this.collisionHelper.isCollidable(collisionLayer)) {
            if (ownerLayer.getGroupInterface()(0) ne collisionLayer.getGroupInterface()(0)) {
                //this.logUtil.putF("isCollision: " + this.getGroupInterface().getGroupName() + "==" + collisionLayer.getGroupInterface().getGroupName(), this, damageUtil.IS_COLLISION);
                return super.isCollision(ownerLayer, collisionLayer)
            }
        }
        return false
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def collide(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Unit = {
        //this.logUtil.putF(this.getName() + " collided with " + collisionLayer.getName(), this, damageUtil.COLLIDE);
        super.collide(ownerLayer, collisionLayer)
        this.collided = true
    }

    override def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        if (this.collisionHelper.isCollidable(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer])) {
            val layerInterface : AllBinaryLayer = collidableInterfaceCompositeInterface.asInstanceOf[AllBinaryLayer]
            //this.logUtil.putF("isCollision: " + this.getGroupInterface().getGroupName() + "==" + layerInterface.getGroupInterface().getGroupName(), this, damageUtil.IS_COLLISION);
            if (ownerLayer.getGroupInterface()(0) ne layerInterface.getGroupInterface()(0)) {
                if (this.layerCollisionUtil.isCollision(ownerLayer, layerInterface)) {
                    return true
                }
            }
        }
        return false
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        // if (collidableInterfaceCompositeInterface was instance of DamageableInterface) {
        this.damageUtil.process(ownerLayer.asInstanceOf[DamageableInterface], collidableInterfaceCompositeInterface.asInstanceOf[DamageableInterface])
        this.collided = true
    }

    override def getCollisionTypeWith(layerInterface : AllBinaryLayer) : CollisionType = {
        return CollisionTypeFactory.getInstance().COLLISION
    }

    /**      * @return the collided      */
    def isCollided() : Boolean = {
        return this.collided
    }

    /**      * @param collided the collided to set      */
    private def setCollided(collided : Boolean) : Unit = {
        this.collided = collided
    }

}


