/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.bounds.event

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class BoundsChangeEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.bounds.event.BoundsChangeEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val boundsChangeEventListener : BoundsChangeEventListener = eventListenerInterface.asInstanceOf[BoundsChangeEventListener]
        boundsChangeEventListener.onBoundsChangeEvent(eventObject.asInstanceOf[BoundsChangeEvent])
    }

}

object BoundsChangeEventHandler {
    private var SINGLETON : BasicEventHandler = new BoundsChangeEventHandler()

    def getInstance() : BasicEventHandler = {
        return BoundsChangeEventHandler.SINGLETON
    }

}


