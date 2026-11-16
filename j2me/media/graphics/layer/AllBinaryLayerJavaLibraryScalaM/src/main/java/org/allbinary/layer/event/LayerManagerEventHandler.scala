/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.layer.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class LayerManagerEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.layer.event.LayerManagerEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    val CREATE : String = "Create"

    val DELETE : String = "Delete"

    def addListener(layerManagerEventListener : LayerManagerEventListener) : Unit = {
        if (!this.list.contains(layerManagerEventListener)) {
            this.list.add(layerManagerEventListener)
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
                    val layerManagerEventListener : LayerManagerEventListener = this.list.objectArray(index).asInstanceOf[LayerManagerEventListener]
                    layerManagerEventListener.onCreateLayerManagerEvent(eventObject.asInstanceOf[LayerManagerEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        super.fireEvent(eventObject)
    }

    def fireDeleteEvent(eventObject : AllBinaryEventObject) : Unit = this.synchronized {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    val layerManagerEventListener : LayerManagerEventListener = this.list.objectArray(index).asInstanceOf[LayerManagerEventListener]
                    layerManagerEventListener.onDeleteLayerManagerEvent(eventObject.asInstanceOf[LayerManagerEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
        val eventListenerInterfaceList : BasicArrayList = this.eventListenerInterfaceList
        var eventListenerInterface : EventListenerInterface = null
        var layerManagerEventListenerInterface : LayerManagerEventListenerInterface = null
        var listenerIndex : Int = 0

        {
            while (listenerIndex < eventListenerInterfaceList.size()) {
                try {
                    eventListenerInterface = eventListenerInterfaceList.objectArray(listenerIndex).asInstanceOf[EventListenerInterface]
                    layerManagerEventListenerInterface = (eventListenerInterface.asInstanceOf[LayerManagerEventListenerInterface])
                    layerManagerEventListenerInterface.onDeleteLayerManagerEvent(eventObject.asInstanceOf[LayerManagerEvent])
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
                listenerIndex += 1
            }
        }
    }

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val layerManagerEventListenerInterface : LayerManagerEventListenerInterface = (eventListenerInterface.asInstanceOf[LayerManagerEventListenerInterface])
        layerManagerEventListenerInterface.onCreateLayerManagerEvent(eventObject.asInstanceOf[LayerManagerEvent])
    }

}

object LayerManagerEventHandler {
    private var instance : LayerManagerEventHandler = new LayerManagerEventHandler()

    def getInstance() : LayerManagerEventHandler = {
        return LayerManagerEventHandler.instance
    }

}


