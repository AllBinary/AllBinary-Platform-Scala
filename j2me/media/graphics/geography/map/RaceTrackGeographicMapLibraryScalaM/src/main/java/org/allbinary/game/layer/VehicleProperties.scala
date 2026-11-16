/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.physics.velocity.VelocityProperties

class VehicleProperties(param_velocityProperties : VelocityProperties, param_vehicleFrictionProperties : VehicleFrictionProperties) {

    private var velocityProperties : VelocityProperties = null

    private var vehicleFrictionProperties : VehicleFrictionProperties = null

    //private final int TAIL_SPIN_SPEED = 10 * 1000 * 1000;
    //Constructor
    {
        val velocityProperties : VelocityProperties = param_velocityProperties
        val vehicleFrictionProperties : VehicleFrictionProperties = param_vehicleFrictionProperties
        this.velocityProperties = velocityProperties
        this.vehicleFrictionProperties = vehicleFrictionProperties
    }

    def getVehicleFrictionProperties() : VehicleFrictionProperties = {
        return this.vehicleFrictionProperties
    }

    def setVehicleFrictionProperties(vehicleFrictionProperties : VehicleFrictionProperties) : Unit = {
        this.vehicleFrictionProperties = vehicleFrictionProperties
    }

    def getVelocityProperties() : VelocityProperties = {
        return this.velocityProperties
    }

}


