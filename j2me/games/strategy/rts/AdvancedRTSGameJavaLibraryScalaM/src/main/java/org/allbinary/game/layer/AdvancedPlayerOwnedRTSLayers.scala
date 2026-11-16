/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AdvancedPlayerOwnedRTSLayers extends PlayerOwnedRTSLayers {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val unitsList : BasicArrayList = new BasicArrayListD()

    private val waypointsList : BasicArrayList = new BasicArrayListD()

    private val buildingList : BasicArrayList = new BasicArrayListD()

    private val baseList : BasicArrayList = new BasicArrayListD()

    private val garrisonList : BasicArrayList = new BasicArrayListD()

    private val houseList : BasicArrayList = new BasicArrayListD()

    private val labList : BasicArrayList = new BasicArrayListD()

    private val factoryList : BasicArrayList = new BasicArrayListD()

    def addUnit(rtsLayer : RTSLayer) : Unit = {
        this.unitsList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addWaypoint(rtsLayer : RTSLayer) : Unit = {
        this.waypointsList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addBase(rtsLayer : RTSLayer) : Unit = {
        this.baseList.add(rtsLayer)
        this.buildingList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addGarrison(rtsLayer : RTSLayer) : Unit = {
        this.garrisonList.add(rtsLayer)
        this.buildingList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addHouse(rtsLayer : RTSLayer) : Unit = {
        this.houseList.add(rtsLayer)
        this.buildingList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addLab(rtsLayer : RTSLayer) : Unit = {
        this.labList.add(rtsLayer)
        this.buildingList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def addFactory(rtsLayer : RTSLayer) : Unit = {
        this.factoryList.add(rtsLayer)
        this.buildingList.add(rtsLayer)
        this.rtsLayerList.add(rtsLayer)
    }

    def removeUnit(gameLayer : AllBinaryGameLayer) : Unit = {
        this.unitsList.remove(gameLayer)
        this.rtsLayerList.remove(gameLayer)
    }

    def removeWaypoint(gameLayer : AllBinaryGameLayer) : Unit = {
        this.waypointsList.remove(gameLayer)
        this.rtsLayerList.remove(gameLayer)
    }

    /**      * @return the unitsList      */
    def getUnitsList() : BasicArrayList = {
        return this.unitsList
    }

    /**      * @return the waypointsList      */
    def getWaypointsList() : BasicArrayList = {
        return this.waypointsList
    }

    /**      * @return the baseList      */
    def getBaseList() : BasicArrayList = {
        return this.baseList
    }

    /**      * @return the garrisonList      */
    def getGarrisonList() : BasicArrayList = {
        return this.garrisonList
    }

    /**      * @return the houseList      */
    def getHouseList() : BasicArrayList = {
        return this.houseList
    }

    /**      * @return the labList      */
    def getLabList() : BasicArrayList = {
        return this.labList
    }

    /**      * @return the factoryList      */
    def getFactoryList() : BasicArrayList = {
        return this.factoryList
    }

    def getTotalBuildings() : Int = {
        return (((this.baseList.size() + this.garrisonList.size()) + this.houseList.size()) + this.labList.size()) + this.factoryList.size()
    }

    def removeBuilding(layerInterface : AllBinaryGameLayer) : Unit = {
        this.buildingList.add(layerInterface)
        /*         final StringMaker stringBuffer = new StringMaker();          stringBuffer.append("removeBuilding: ");         stringBuffer.append(layerInterface.getName());                  this.logUtil.putF(stringBuffer.toString(), this, "removeBuilding");         */
        if (this.getBaseList().remove(layerInterface)) {
            this.rtsLayerList.remove(layerInterface)
        } else if (this.getFactoryList().remove(layerInterface)) {
            this.rtsLayerList.remove(layerInterface)
        } else if (this.getGarrisonList().remove(layerInterface)) {
            this.rtsLayerList.remove(layerInterface)
        } else if (this.getLabList().remove(layerInterface)) {
            this.rtsLayerList.remove(layerInterface)
        } else if (this.getHouseList().remove(layerInterface)) {
            this.rtsLayerList.remove(layerInterface)
        }
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(super.toString())
        stringBuffer.append(" Bases: ")
        stringBuffer.appendint(this.getBaseList().size())
        stringBuffer.append(" Factory: ")
        stringBuffer.appendint(this.getFactoryList().size())
        stringBuffer.append(" Garrison: ")
        stringBuffer.appendint(this.getGarrisonList().size())
        stringBuffer.append(" Labs: ")
        stringBuffer.appendint(this.getLabList().size())
        stringBuffer.append(" Houses: ")
        stringBuffer.appendint(this.getHouseList().size())
        stringBuffer.append(" Waypoints: ")
        stringBuffer.appendint(this.getWaypointsList().size())
        stringBuffer.append(" Units: ")
        stringBuffer.appendint(this.getUnitsList().size())
        return stringBuffer.toString()
    }

    def getBuildingList() : BasicArrayList = {
        return this.buildingList
    }

}


