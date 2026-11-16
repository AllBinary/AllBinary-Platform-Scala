/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.physics.FrictionProperties
import _root_.org.allbinary.game.physics.friction.FrictionData

class VehicleFrictionProperties(param_tireFriction : Int, param_brakeFriction : Int, param_airFriction : Int, param_crashFriction : Int) extends FrictionProperties {

    private var TIRE_FRICTION_NOMINATOR : Int = 0

    private var BRAKE_FRICTION_NOMINATOR : Int = 0

    private var AIR_FRICTION_NOMINATOR : Int = 0

    private var CRASH_FRICTION_NOMINATOR : Int = 0

    //Constructor
    {
        val tireFriction : Int = param_tireFriction
        val brakeFriction : Int = param_brakeFriction
        val airFriction : Int = param_airFriction
        val crashFriction : Int = param_crashFriction
        this.TIRE_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - tireFriction
        this.BRAKE_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - brakeFriction
        this.AIR_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - airFriction
        this.CRASH_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - crashFriction
    }

    def getTireFrictionNominator() : Int = {
        return this.TIRE_FRICTION_NOMINATOR
    }

    def getBrakeFrictionNominator() : Int = {
        return this.BRAKE_FRICTION_NOMINATOR
    }

    def getAirFrictionNominator() : Int = {
        return this.AIR_FRICTION_NOMINATOR
    }

    def getCrashFrictionNominator() : Int = {
        return this.CRASH_FRICTION_NOMINATOR
    }

}


