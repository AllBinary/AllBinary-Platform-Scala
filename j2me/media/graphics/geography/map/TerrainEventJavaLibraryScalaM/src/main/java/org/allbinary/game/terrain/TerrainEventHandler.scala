/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.terrain

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TerrainEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.terrain.TerrainEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(terrainEventListener : TerrainEventListener) : Unit = {
        if (!this.list.contains(terrainEventListener)) {
            this.list.add(terrainEventListener)
        }
    }

    override def removeAllListeners() : Unit = {
        this.list.clear()
        super.removeAllListeners()
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = {
        this.list.remove(eventListenerInterface)
        super.removeListener(eventListenerInterface)
    }

    override def fireEvent(eventObject : AllBinaryEventObject) : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    val terrainEventListener : TerrainEventListener = this.list.get(index).asInstanceOf[TerrainEventListener]
                    terrainEventListener.onTerrainEvent(eventObject.asInstanceOf[TerrainEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        super.fireEvent(eventObject)
    }

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val terrainEventListenerInterface : TerrainEventListenerInterface = eventListenerInterface.asInstanceOf[TerrainEventListenerInterface]
        terrainEventListenerInterface.onTerrainEvent(eventObject.asInstanceOf[TerrainEvent])
    }

}

object TerrainEventHandler {
    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().NULL_TABLE

    def init() : Unit = {
        TerrainEventHandler.hashtable = StdUtil.getInstance().createHashtable()
    }

    def getInstance(anyType : Object) : TerrainEventHandler = {
        var eventHandlerCanBeNull : Object = TerrainEventHandler.hashtable.get(anyType)
        if (eventHandlerCanBeNull == null) {
            eventHandlerCanBeNull = new TerrainEventHandler()
            TerrainEventHandler.hashtable.put(anyType, eventHandlerCanBeNull)
        }
        return eventHandlerCanBeNull.asInstanceOf[TerrainEventHandler]
    }

}


