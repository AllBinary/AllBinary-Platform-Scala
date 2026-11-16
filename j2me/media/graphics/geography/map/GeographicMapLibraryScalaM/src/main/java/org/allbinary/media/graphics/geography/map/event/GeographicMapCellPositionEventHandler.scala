/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.event

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.game.layer.geographic.map.MiniMapLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class GeographicMapCellPositionEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.media.graphics.geography.map.event.GeographicMapCellPositionEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(miniMapLayer : MiniMapLayer) : Unit = {
        if (!this.list.contains(miniMapLayer)) {
            this.list.add(miniMapLayer)
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
                    var miniMapLayer : MiniMapLayer = this.list.get(index).asInstanceOf[MiniMapLayer]
                    miniMapLayer.onGeographicMapCellPositionEvent(eventObject.asInstanceOf[GeographicMapCellPositionEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        super.fireEvent(eventObject)
    }

    def fireRemoveEvent(eventObject : AllBinaryEventObject) : Unit = this.synchronized {
        var list : BasicArrayList = this.eventListenerInterfaceList

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    var miniMapLayer : MiniMapLayer = this.list.get(index).asInstanceOf[MiniMapLayer]
                    miniMapLayer.onRemoveGeographicMapCellPositionEvent(eventObject.asInstanceOf[GeographicMapCellPositionEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        var eventListenerInterface : EventListenerInterface = null
        var geographicMapCellPositionEventListenerInterface : GeographicMapCellPositionEventListenerInterface = null
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                try {
                    eventListenerInterface = list.get(index).asInstanceOf[EventListenerInterface]
                    geographicMapCellPositionEventListenerInterface = (eventListenerInterface.asInstanceOf[GeographicMapCellPositionEventListenerInterface])
                    geographicMapCellPositionEventListenerInterface.onRemoveGeographicMapCellPositionEvent(eventObject.asInstanceOf[GeographicMapCellPositionEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
                index += 1
            }
        }
    }

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        var geographicMapCellPositionEventListenerInterface : GeographicMapCellPositionEventListenerInterface = (eventListenerInterface.asInstanceOf[GeographicMapCellPositionEventListenerInterface])
        geographicMapCellPositionEventListenerInterface.onGeographicMapCellPositionEvent(eventObject.asInstanceOf[GeographicMapCellPositionEvent])
    }

}

object GeographicMapCellPositionEventHandler {
    private var instance : GeographicMapCellPositionEventHandler = new GeographicMapCellPositionEventHandler()

    def getInstance() : GeographicMapCellPositionEventHandler = {
        return GeographicMapCellPositionEventHandler.instance
    }

}


