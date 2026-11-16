/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.terrain

import _root_.org.allbinary.logic.util.event.AllBinaryEventCircularPool

class TerrainEventCircularStaticPool {
    import _root_.org.allbinary.game.terrain.TerrainEventCircularStaticPool.{*}

    private var EVENT_POOL : AllBinaryEventCircularPool = new AllBinaryEventCircularPool(20)

    def init() : Unit = {
        this.EVENT_POOL.initAllBinaryEventCircularPool(new TerrainEventFactory())
    }

    def getNext(basicTerrainInfo : BasicTerrainInfo) : TerrainEvent = this.synchronized {
        var trackingEvent : TerrainEvent = this.EVENT_POOL.getNextInstance().asInstanceOf[TerrainEvent]
        trackingEvent.setBasicTerrainInfoForCircularStaticPool(basicTerrainInfo)
        return trackingEvent
    }

}

object TerrainEventCircularStaticPool {
    private val instance : TerrainEventCircularStaticPool = new TerrainEventCircularStaticPool()

    def getInstance() : TerrainEventCircularStaticPool = {
        return TerrainEventCircularStaticPool.instance
    }

}


