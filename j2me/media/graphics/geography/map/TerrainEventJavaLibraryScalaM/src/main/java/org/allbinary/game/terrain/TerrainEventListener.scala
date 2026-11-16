/* Generated Code Do Not Modify */
package org.allbinary.game.terrain

import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TerrainEventListener extends TerrainEventListenerInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val list : BasicArrayList = new BasicArrayListD()

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onTerrainEvent(terrainEvent : TerrainEvent) : Unit = {
        // terrainEvent.getBasicTerrainInfo().getAngle().getValue(), this, "onTerrainEvent");
        this.list.clear()
        this.list.add(terrainEvent)
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}


