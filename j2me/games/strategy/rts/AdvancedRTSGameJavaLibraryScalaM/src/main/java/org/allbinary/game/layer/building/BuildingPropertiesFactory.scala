/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.building

import _root_.org.allbinary.game.combat.damage.DamageFloaters
import _root_.org.allbinary.game.combat.damage.PtsDamageFloaters
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GameFeatureFactory
import _root_.org.allbinary.game.graphics.hud.BasicHudFactory
import _root_.org.allbinary.game.health.HealthBar
import _root_.org.allbinary.game.health.HealthBarTwodAnimation
import _root_.org.allbinary.game.tracking.TrackingEvent
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author User  */
class BuildingPropertiesFactory {
    import _root_.org.allbinary.game.layer.building.BuildingPropertiesFactory.{*}

    var damageFloatersPaintableInterface : Paintable = NullPaintable.getInstance()

    def getEfficiencyPerLevel(buildingLayer : BuildingLayer) : Int = {
        return (10000 / buildingLayer.getMaxLevel()) + (10000 % buildingLayer.getMaxLevel())
    }

    def getDamageFloaters(buildingLayer : BuildingLayer) : DamageFloaters = {
        var damageFloaters : DamageFloaters = DamageFloaters.getInstance()
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().DAMAGE_FLOATERS)) {
            damageFloaters = new PtsDamageFloaters(buildingLayer)
            this.damageFloatersPaintableInterface = damageFloaters
        } else {
            damageFloaters = new DamageFloaters()
        }
        return damageFloaters
    }

    def getHealthBar(buildingLayer : BuildingLayer) : Paintable = {
        var healthBar : Paintable = NullPaintable.getInstance()
        if (Features.getInstance().isFeature(GameFeatureFactory.getInstance().HEALTH_BARS)) {
            healthBar = new HealthBar(buildingLayer, buildingLayer.getHealthInterface(), new HealthBarTwodAnimation(buildingLayer.asInstanceOf[AllBinaryLayer], BasicHudFactory.getInstance().BOTTOMLEFT), -1)
        }
        return healthBar
    }

    def getHashtable() : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().createHashtable()
    }

    def getTrackingEvent(buildingLayer : BuildingLayer) : TrackingEvent = {
        return new TrackingEvent(buildingLayer)
    }

}

object BuildingPropertiesFactory {
    private val instance : BuildingPropertiesFactory = new BuildingPropertiesFactory()

    /**      * @return the instance      */
    def getInstance() : BuildingPropertiesFactory = {
        return BuildingPropertiesFactory.instance
    }

}


