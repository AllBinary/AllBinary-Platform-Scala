/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.collision.CollisionType
import _root_.org.allbinary.game.collision.CollisionTypeFactory
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableBehavior
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer

class CollidableVehicleBehavior(param_collidable : Boolean) extends CollidableDestroyableDamageableBehavior(param_collidable) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    var totalImpactVelocity : Long = 0

    private var halfImpactVelocityX : Long = 0L

    private var halfImpactVelocityY : Long = 0L

    //Constructor
    {
        val collidable : Boolean = param_collidable
    }

    override def collide(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableCompositeLayer) : Unit = {
        //if (this.getHealthInterface().isAlive())
        val collisionTypeFactory : CollisionTypeFactory = CollisionTypeFactory.getInstance()
        val collisionType : CollisionType = collidableInterfaceCompositeInterface.getCollidableInferface().getCollisionTypeWith(ownerLayer)
        if (collisionType eq collisionTypeFactory.PICKUP) {
            val collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = (ownerLayer.asInstanceOf[CollidableDestroyableDamageableLayer])
            collidableDestroyableDamageableLayer.getPickupBehavior().doPickupLayer(collidableInterfaceCompositeInterface.asInstanceOf[PickedUpLayerInterface])
        } else if (collisionType eq collisionTypeFactory.COLLISION) {
            super.collide(ownerLayer, collidableInterfaceCompositeInterface)
        } else {
            this.collideVehicle(ownerLayer, collidableInterfaceCompositeInterface.asInstanceOf[VehiclePropertiesCompositeInterface])
        }
    }

    override def collideInterface(ownerLayer : CollidableCompositeLayer, collidableInterfaceCompositeInterface : CollidableInterfaceCompositeInterface) : Unit = {
        ForcedLogUtil.log("Don't Use Interface Version It Is Slower", this)
    }

    def collideVehicle(ownerLayer : CollidableCompositeLayer, vehiclePropertiesCompositeInterface : VehiclePropertiesCompositeInterface) : Unit = {
        val ownerVehicleLayerInterface : VehiclePropertiesCompositeInterface = (ownerLayer.asInstanceOf[VehiclePropertiesCompositeInterface])
        val ownerVehicleProperties : VehicleProperties = ownerVehicleLayerInterface.getVehicleProperties()
        val vehicleProperties : VehicleProperties = vehiclePropertiesCompositeInterface.getVehicleProperties()
        // Reverse Velocity of both vehicles on the side of the hit
        val impactVelocityX : Long = ownerVehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().getUnscaled() - vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().getUnscaled()
        val impactVelocityY : Long = ownerVehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().getUnscaled() - vehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().getUnscaled()
        // Basic bounce off
        if (impactVelocityX != 0L) {
            // impactVelocityX, this, damageUtil.COLLIDE);
            this.halfImpactVelocityX = (impactVelocityX >> 1)
            ownerVehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityX)
            vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityX)
        } else {
        }
        // Basic bounce off
        if (impactVelocityY != 0L) {
            // impactVelocityY, this, damageUtil.COLLIDE);
            this.halfImpactVelocityY = (impactVelocityY >> 1)
            ownerVehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().addlong(this.halfImpactVelocityY)
            vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityY)
        } else {
        }
        // Slow Down
        this.collideFriction(ownerVehicleLayerInterface)
        this.collideFriction(vehiclePropertiesCompositeInterface)
        this.totalImpactVelocity = impactVelocityX + impactVelocityY
    }

    private def collideFriction(vehiclePropertiesCompositeInterface : VehiclePropertiesCompositeInterface) : Unit = {
        val vehicleFrictionProperties : VehicleFrictionProperties = vehiclePropertiesCompositeInterface.getVehicleProperties().getVehicleFrictionProperties()
        vehiclePropertiesCompositeInterface.getVehicleProperties().getVehicleFrictionProperties().friction(vehiclePropertiesCompositeInterface.getVehicleProperties().getVelocityProperties(), vehicleFrictionProperties.getCrashFrictionNominator())
    }

}


