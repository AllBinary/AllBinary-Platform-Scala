/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

/**  *  * @author user  */
class Driver(param_turnSpeed : Integer, param_trackPathSelectionSkill : Integer, param_aggression : Aggression) {
    import _root_.org.allbinary.game.layer.Driver.{NULL_DRIVER as _, *}
    def NULL_DRIVER : Driver = _root_.org.allbinary.game.layer.Driver.NULL_DRIVER

    //driver intelligence
    private var turnSpeed : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    private var trackPathSelectionSkill : Integer = SmallIntegerSingletonFactory.getInstance().getAt(0)

    private var aggression : Aggression = null

    //Constructor
    {
        val turnSpeed : Integer = param_turnSpeed
        val trackPathSelectionSkill : Integer = param_trackPathSelectionSkill
        val aggression : Aggression = param_aggression
        this.setTurnSpeed(turnSpeed)
        this.setTrackPathSelectionSkill(trackPathSelectionSkill)
        this.aggression = aggression
    }

    def getTurnSpeed() : Integer = {
        return this.turnSpeed
    }

    def setTurnSpeed(turnSpeed : Integer) : Unit = {
        this.turnSpeed = turnSpeed
    }

    def getTrackPathSelectionSkill() : Integer = {
        return this.trackPathSelectionSkill
    }

    def setTrackPathSelectionSkill(trackPathSelectionSkill : Integer) : Unit = {
        this.trackPathSelectionSkill = trackPathSelectionSkill
    }

    def getAggression() : Aggression = {
        return this.aggression
    }

    def setAggression(aggression : Aggression) : Unit = {
        this.aggression = aggression
    }

}

object Driver {
    val NULL_DRIVER : Driver = new Driver(SmallIntegerSingletonFactory.getInstance().getAt(0), SmallIntegerSingletonFactory.getInstance().getAt(0), new Aggression(SmallIntegerSingletonFactory.getInstance().getAt(0), SmallIntegerSingletonFactory.getInstance().getAt(0), SmallIntegerSingletonFactory.getInstance().getAt(0)))

}


