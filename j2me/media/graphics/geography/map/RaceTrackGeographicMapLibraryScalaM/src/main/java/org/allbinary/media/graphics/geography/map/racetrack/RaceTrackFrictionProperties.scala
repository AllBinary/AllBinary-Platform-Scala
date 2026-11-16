/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.game.physics.friction.FrictionData

class RaceTrackFrictionProperties(param_roadFriction : Int, param_groundFriction : Int) {

    private var ROAD_FRICTION_NOMINATOR : Int = 0

    private var GROUND_FRICTION_NOMINATOR : Int = 0

    //Constructor
    {
        val roadFriction : Int = param_roadFriction
        val groundFriction : Int = param_groundFriction
        this.ROAD_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - roadFriction
        this.GROUND_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - groundFriction
    }

    def getRoadFrictionNominator() : Int = {
        return this.ROAD_FRICTION_NOMINATOR
    }

    def getGroundFrictionNominator() : Int = {
        return this.GROUND_FRICTION_NOMINATOR
    }

}


