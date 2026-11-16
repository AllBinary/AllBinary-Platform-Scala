/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.identification.GroupCommonFactory
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.GameInfo
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.part.PartInterface
import _root_.org.allbinary.game.part.weapon.BasicWeaponPart
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.BaseRaceTrackGeographicMap
import _root_.org.allbinary.util.ABHashtable

class RTSLayerUtil {
    import _root_.org.allbinary.game.layer.RTSLayerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()

    private val MAX_RELOAD_TIME : Long = Integer.MAX_VALUE.toLong / 100000

    private def createWeaponProperties(weaponProperties : WeaponProperties, currentLevel : Int, lastLevel : Int) : WeaponProperties = {
        var reloadTime : Long = weaponProperties.getReloadTime()
        if (lastLevel > currentLevel) {
            reloadTime = reloadTime + 50
        } else if (lastLevel < currentLevel) {
            reloadTime = reloadTime - 50
        }
        val newWeaponProperties : WeaponProperties = new WeaponProperties(reloadTime, weaponProperties.getTargetingTime(), weaponProperties.getSpeed().getUnscaled(), (weaponProperties.getDamage() / lastLevel) * currentLevel, weaponProperties.getDissipation())
        //      "WeaponProperties: ").append(newWeaponProperties, //    this, "createWeaponProperties");
        return newWeaponProperties
    }

    def downgrade(rtsLayer : RTSLayer) : Unit = {
        rtsLayer.setLevel(rtsLayer.getLevel() - 1)
        val partInterfaceArray : Array[PartInterface] = rtsLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var partInterface : BasicWeaponPart = null

        {
            var index : Int = size
            while ({ index -= 1; index } >= 0) {
                partInterface = partInterfaceArray(index).asInstanceOf[BasicWeaponPart]
                partInterface.setWeaponProperties(this.createWeaponProperties(partInterface.getWeaponProperties(), rtsLayer.getLevel(), rtsLayer.getLevel() + 1))
            }
        }
        rtsLayer.select()
    }

    def upgrade(rtsLayer : RTSLayer) : Unit = {
        rtsLayer.setLevel(rtsLayer.getLevel() + 1)
        val partInterfaceArray : Array[PartInterface] = rtsLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var partInterface : BasicWeaponPart = null

        {
            var index : Int = size
            while ({ index -= 1; index } >= 0) {
                partInterface = partInterfaceArray(index).asInstanceOf[BasicWeaponPart]
                partInterface.setWeaponProperties(this.createWeaponProperties(partInterface.getWeaponProperties(), rtsLayer.getLevel(), rtsLayer.getLevel() - 1))
            }
        }
        rtsLayer.select()
    }

    //1000 = 1000 10000 = 100000
    def getCostExponential(cost : Long) : Long = {
        return (((cost * cost) * cost) / (cost * 1000))
    }

    private def getWeaponPropertiesCost(weaponProperties : WeaponProperties) : Int = {
        //I artificially reduce the cost of reload time since they miss a bunch
        var cost : Long = ((weaponProperties.getDamage() + weaponProperties.getRange()) + ((this.MAX_RELOAD_TIME / weaponProperties.getReloadTime()) >> 1))
        //this.logUtil.putF("Pre Cost: ").append(cost, this, "getWeaponPropertiesCost");
        cost = this.getCostExponential(cost)
        //this.logUtil.putF("Cost: ").append(cost, this, "getWeaponPropertiesCost");
        return cost.toInt
    }

    def getCost(rtsLayer : RTSLayer) : Int = {
        var total : Int = 0
        val partInterfaceArray : Array[PartInterface] = rtsLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var partInterface : BasicWeaponPart = null
        var weaponProperties : WeaponProperties = null

        {
            var index : Int = size - 1
            while (index >= 0) {
                partInterface = partInterfaceArray(index).asInstanceOf[BasicWeaponPart]
                weaponProperties = partInterface.getWeaponProperties()
                total += this.getWeaponPropertiesCost(weaponProperties)
                index -= 1
            }
        }
        return total
    }

    def getDowngradeCost(rtsLayer : RTSLayer) : Int = {
        val partInterfaceArray : Array[PartInterface] = rtsLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var downgradeCost : Int = 0
        var partInterface : BasicWeaponPart = null
        var weaponProperties : WeaponProperties = null
        var downgradeWeaponCost : Int = 0
        var currentWeaponCost : Int = 0

        {
            var index : Int = size - 1
            while (index >= 0) {
                partInterface = partInterfaceArray(index).asInstanceOf[BasicWeaponPart]
                weaponProperties = partInterface.getWeaponProperties()
                downgradeWeaponCost = this.getWeaponPropertiesCost(this.createWeaponProperties(weaponProperties, rtsLayer.getLevel() - 1, rtsLayer.getLevel()))
                currentWeaponCost = this.getWeaponPropertiesCost(weaponProperties)
                downgradeCost += (currentWeaponCost - downgradeWeaponCost)
                index -= 1
            }
        }
        downgradeCost = (downgradeCost * 9) / 10
        this.logUtil.putF(new StringMaker().append("Total Cost: ").appendint(downgradeCost).toString(), this, "getDowngradeCost")
        return downgradeCost
    }

    def getUpgradeCost(rtsLayer : RTSLayer) : Int = {
        var upgradeCost : Int = 0
        val partInterfaceArray : Array[PartInterface] = rtsLayer.getPartInterfaceArray()
        val size : Int = partInterfaceArray.length
        var partInterface : BasicWeaponPart = null
        var weaponProperties : WeaponProperties = null
        var upgradedWeaponCost : Int = 0
        var currentWeaponCost : Int = 0

        {
            var index : Int = size - 1
            while (index >= 0) {
                partInterface = partInterfaceArray(index).asInstanceOf[BasicWeaponPart]
                weaponProperties = partInterface.getWeaponProperties()
                upgradedWeaponCost = this.getWeaponPropertiesCost(this.createWeaponProperties(weaponProperties, rtsLayer.getLevel() + 1, rtsLayer.getLevel()))
                currentWeaponCost = this.getWeaponPropertiesCost(weaponProperties)
                upgradeCost += (upgradedWeaponCost - currentWeaponCost)
                index -= 1
            }
        }
        this.logUtil.putF(new StringMaker().append("Total Cost: ").appendint(upgradeCost).toString(), this, "getUpgradeCost")
        return upgradeCost
    }

    final def destroyAndClear(list : BasicArrayList) : Unit = {
        var rtsLayer : RTSLayer = null

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                rtsLayer = list.get(index).asInstanceOf[RTSLayer]
                rtsLayer.setDestroyed(true)
                index -= 1
            }
        }
        list.clear()
    }

    final def createFakeRTSLayerHashtable(baseRaceTrackGeographicMap : BaseRaceTrackGeographicMap) : ABHashtable[Object, Object] = {
        val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()
        val layerManager : FakeLayerManager = new FakeLayerManager(GameInfo.NONE)
        layerManager.setGeographicMapInterface(Array[BasicGeographicMap](baseRaceTrackGeographicMap))
        hashtable.put(AllBinaryGameLayerManager.ID, layerManager)
        hashtable.put(DirectionFactory.getInstance().NAME, DirectionFactory.getInstance().LEFT)
        hashtable.put(this.groupCommonFactory.ID, BasicGroupFactory.getInstance().NONE_ARRAY)
        return hashtable
    }

}

object RTSLayerUtil {
    private val instance : RTSLayerUtil = new RTSLayerUtil()

    def getInstance() : RTSLayerUtil = {
        return RTSLayerUtil.instance
    }

}


