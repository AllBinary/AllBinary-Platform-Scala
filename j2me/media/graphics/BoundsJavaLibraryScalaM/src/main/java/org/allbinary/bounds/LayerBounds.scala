/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.bounds

import _root_.org.allbinary.bounds.event.BoundsChangeEvent
import _root_.org.allbinary.bounds.event.BoundsChangeEventListener
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class LayerBounds(param_rectangle : Rectangle) extends BoundsChangeEventListener {

    val logUtil : LogUtil = LogUtil.getInstance()

    var rectangle : Rectangle = null

    //Constructor
    {
        val rectangle : Rectangle = param_rectangle
        this.rectangle = rectangle
    }

    def getRectangleP() : Rectangle = {
        return this.rectangle
    }

    def visit(boundsVisitorInterface : BoundsVisitorInterface) : Unit = {
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onBoundsChangeEvent(boundsChangeEvent : BoundsChangeEvent) : Unit = {
        this.rectangle = boundsChangeEvent.getRectangle()
    }

}


