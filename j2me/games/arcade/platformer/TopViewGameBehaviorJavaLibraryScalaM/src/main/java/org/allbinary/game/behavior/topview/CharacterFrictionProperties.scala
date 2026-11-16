/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.game.physics.FrictionProperties
import _root_.org.allbinary.game.physics.friction.FrictionData

class CharacterFrictionProperties(param_airFriction : Int, param_waterFriction : Int, param_collisionFriction : Int) extends FrictionProperties {

    private var WATER_FRICTION_NOMINATOR : Int = 0

    private var AIR_FRICTION_NOMINATOR : Int = 0

    private var COLLISION_FRICTION_NOMINATOR : Int = 0

    //Constructor
    {
        val airFriction : Int = param_airFriction
        val waterFriction : Int = param_waterFriction
        val collisionFriction : Int = param_collisionFriction
        this.AIR_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - airFriction
        this.COLLISION_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - collisionFriction
        this.WATER_FRICTION_NOMINATOR = FrictionData.getFrictionDenominator() - waterFriction
    }

    def getWATER_FRICTION_NOMINATOR() : Int = {
        return this.WATER_FRICTION_NOMINATOR
    }

    def getAIR_FRICTION_NOMINATOR() : Int = {
        return this.AIR_FRICTION_NOMINATOR
    }

    def getCOLLISION_FRICTION_NOMINATOR() : Int = {
        return this.COLLISION_FRICTION_NOMINATOR
    }

}


