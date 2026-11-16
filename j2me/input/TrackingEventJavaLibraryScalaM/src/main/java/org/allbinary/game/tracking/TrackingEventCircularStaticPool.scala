/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.tracking

import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventCircularPool

class TrackingEventCircularStaticPool {
    import _root_.org.allbinary.game.tracking.TrackingEventCircularStaticPool.{*}

    private var EVENT_POOL : AllBinaryEventCircularPool = new AllBinaryEventCircularPool(20)

    def init() : Unit = {
        this.EVENT_POOL.initAllBinaryEventCircularPool(new TrackingEventFactory())
    }

    def getNextInstance(layerInterface : AllBinaryLayer) : TrackingEvent = this.synchronized {
        var trackingEvent : TrackingEvent = this.EVENT_POOL.getNextInstance().asInstanceOf[TrackingEvent]
        trackingEvent.setLayerInterfaceForCircularStaticPool(layerInterface)
        return trackingEvent
    }

}

object TrackingEventCircularStaticPool {
    private var instance : TrackingEventCircularStaticPool = new TrackingEventCircularStaticPool()

    def getInstance() : TrackingEventCircularStaticPool = {
        return TrackingEventCircularStaticPool.instance
    }

}


