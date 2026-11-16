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
import _root_.org.allbinary.logic.NullUtil

class CollidableWeaponBehavior(param_collidable : Boolean) extends CollidableDestroyableDamageableBehavior(param_collidable) {
    import _root_.org.allbinary.game.layer.weapon.CollidableWeaponBehavior.{*}

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
                // collisionLayer.getGroupInterface().getGroupName(), this, // damageUtil.IS_COLLISION);
                return super.isCollision(ownerLayer, collisionLayer)
            }
        }
        return false
    }

    // TODO TWB Special Super Efficient Collision Processing
    override def collide(ownerLayer : CollidableCompositeLayer, collisionLayer : CollidableCompositeLayer) : Unit = {
        //this.slow();
        super.collide(ownerLayer, collisionLayer)
        this.collided = true
    }

    override def isCollisionInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Boolean = {
        if (this.collisionHelper.isCollidable(collidableInterfaceCompositeInterface.asInstanceOf[CollidableCompositeLayer])) {
            val layerInterface : AllBinaryLayer = collidableInterfaceCompositeInterface.asInstanceOf[AllBinaryLayer]
            // layerInterface.getGroupInterface().getGroupName(), // this, damageUtil.IS_COLLISION);
            if (ownerLayer.getGroupInterface()(0) ne layerInterface.getGroupInterface()(0)) {
                if (this.layerCollisionUtil.isCollision(ownerLayer, layerInterface)) {
                    return true
                }
            }
        }
        return false
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        // DamageableInterface) {
        val ownerDamageableInterface : DamageableInterface = ownerLayer.asInstanceOf[DamageableInterface]
        val damageableInterface : DamageableInterface = collidableInterfaceCompositeInterface.asInstanceOf[DamageableInterface]
        this.damageUtil.process(ownerDamageableInterface, damageableInterface)
        this.collided = true
    }

    /*     private void slow()     {         Movement movement = ((WeaponLayer) this.ownerLayer).getMovement();          BasicVelocityProperties velocityProperties =              ((VelocityInterfaceCompositeInterface) movement).getVelocityProperties();          BasicDecimal xBasicDecimal = velocityProperties.getVelocityXBasicDecimalP();         BasicDecimal yBasicDecimal = velocityProperties.getVelocityYBasicDecimalP();           if(xBasicDecimal.getUnscaled() > 1000 || yBasicDecimal.getUnscaled() > 1000)         {             xBasicDecimal.divide(2);             yBasicDecimal.divide(2);         }     }     */
    override def getCollisionTypeWith(layerInterface : AllBinaryLayer) : CollisionType = {
        return CollisionTypeFactory.getInstance().COLLISION
    }

    /**      * @return the collided      */
    def isCollided() : Boolean = {
        return this.collided
    }

    /**      * @param collided      *            the collided to set      */
    private def setCollided(collided : Boolean) : Unit = {
        this.collided = collided
    }

}

object CollidableWeaponBehavior {
    private var NULL_COLLIDABLE_WEAPON_BEHAVIOR : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : CollidableWeaponBehavior = {
        if (CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR eq NullUtil.getInstance().NULL_OBJECT) {
            CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR = new CollidableWeaponBehavior(false)
        }
        return CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR.asInstanceOf[CollidableWeaponBehavior]
    }

}


