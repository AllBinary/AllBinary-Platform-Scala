/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.view.event

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class ViewPositionEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.view.event.ViewPositionEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(layerInterface : AllBinaryLayer) : Unit = {
        if (!this.list.contains(layerInterface)) {
            this.list.add(layerInterface)
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
                    var layerInterface : AllBinaryLayer = this.list.objectArray(index).asInstanceOf[AllBinaryLayer]
                    layerInterface.onChangeEvent(eventObject.asInstanceOf[ViewPositionEvent])
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
        val viewPositionEventListenerInterface : ViewPositionEventListenerInterface = (eventListenerInterface.asInstanceOf[ViewPositionEventListenerInterface])
        viewPositionEventListenerInterface.onChangeEvent(eventObject.asInstanceOf[ViewPositionEvent])
    }

}

object ViewPositionEventHandler {
    private var SINGLETON : ViewPositionEventHandler = new ViewPositionEventHandler()

    def getInstance() : ViewPositionEventHandler = {
        return ViewPositionEventHandler.SINGLETON
    }

}


