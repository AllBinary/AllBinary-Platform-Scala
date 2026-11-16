/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.building

import _root_.org.allbinary.game.combat.damage.DamageFloaters
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.game.tracking.TrackingEventHandler
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author User  */
class SimulatedBuildingPropertiesFactory extends BuildingPropertiesFactory {
    import _root_.org.allbinary.game.layer.building.SimulatedBuildingPropertiesFactory.{*}

    override def getEfficiencyPerLevel(buildingLayer : BuildingLayer) : Int = {
        return 0
    }

    override def getDamageFloaters(buildingLayer : BuildingLayer) : DamageFloaters = {
        val damageFloaters : DamageFloaters = DamageFloaters.getInstance()
        this.damageFloatersPaintableInterface = damageFloaters
        return damageFloaters
    }

    override def getHealthBar(buildingLayer : BuildingLayer) : Paintable = {
        return NullPaintable.getInstance()
    }

    override def getHashtable() : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    override def getTrackingEvent(buildingLayer : BuildingLayer) : TrackingEvent = {
        return new TrackingEvent(TrackingEventHandler.getInstance())
    }

}

object SimulatedBuildingPropertiesFactory {
    private val instanceC : SimulatedBuildingPropertiesFactory = new SimulatedBuildingPropertiesFactory()

    /**      * @return the instance      */
    def getInstance() : SimulatedBuildingPropertiesFactory = {
        return SimulatedBuildingPropertiesFactory.instanceC
    }

}


