/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy.event

import _root_.org.allbinary.game.displayable.canvas.AllBinaryGameCanvas
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventCircularPool

class DestroyEventCircularStaticPool private() {
    import _root_.org.allbinary.game.combat.destroy.event.DestroyEventCircularStaticPool.{*}

    private var EVENT_POOL : AllBinaryEventCircularPool = new AllBinaryEventCircularPool(20)

    def init(combatGameCanvas : AllBinaryGameCanvas) : Unit = {
        this.EVENT_POOL.initAllBinaryEventCircularPool(new DestroyEventFactory(combatGameCanvas))
    }

    def getInstanceForLayer(layerInterface : AllBinaryLayer) : DestroyedEvent = {
        var destroyedEvent : DestroyedEvent = this.EVENT_POOL.getNextInstance().asInstanceOf[DestroyedEvent]
        destroyedEvent.setLayerInterfaceForCircularStaticPool(layerInterface)
        return destroyedEvent
    }

}

object DestroyEventCircularStaticPool {
    private val instance : DestroyEventCircularStaticPool = new DestroyEventCircularStaticPool()

    def getInstance() : DestroyEventCircularStaticPool = {
        return DestroyEventCircularStaticPool.instance
    }

}


