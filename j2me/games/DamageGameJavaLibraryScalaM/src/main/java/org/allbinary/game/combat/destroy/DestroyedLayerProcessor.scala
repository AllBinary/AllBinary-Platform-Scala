/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy

import _root_.org.allbinary.game.combat.destroy.event.DestroyEventCircularStaticPool
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEvent
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventHandler
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.BasicLayerProcessor
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class DestroyedLayerProcessor private() extends BasicLayerProcessor {
    import _root_.org.allbinary.game.combat.destroy.DestroyedLayerProcessor.{*}

    //    private final String LAYER_LABEL = "layerInterface: ";    
    override def process(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        var list : BasicArrayList = this.getList()
        var size : Int = list.size()
        val destroyedEventHandler : DestroyedEventHandler = DestroyedEventHandler.getInstance()
        val destroyEventCircularStaticPool : DestroyEventCircularStaticPool = DestroyEventCircularStaticPool.getInstance()
        //GroupLayerManagerListener.getInstance().log();
        var destroyedEvent : DestroyedEvent = null
        var layerInterface : AllBinaryLayer = null

        {
            var index : Int = 0
            while (index < size) {
                // no physics here - just destroy them
                var layerInterfaceCanBeNull : Object = list.objectArray(index)
                if (layerInterfaceCanBeNull != null) {
                    layerInterface = layerInterfaceCanBeNull.asInstanceOf[AllBinaryLayer]
                    //                this.logUtil.putF(stringBuilder.append("Processing: ").appendint(allBinaryLayerManager.getSize()).toString(), this, this.commonStrings.PROCESS);
                    allBinaryLayerManager.remove(layerInterface)
                    //                this.logUtil.putF(stringBuilder.append("After: ").appendint(allBinaryLayerManager.getSize()).toString(), this, this.commonStrings.PROCESS);
                    destroyedEvent = destroyEventCircularStaticPool.getInstanceForLayer(layerInterface)
                    // Notify Listeners of Destroyed Layer
                    destroyedEventHandler.fireEvent(destroyedEvent)
                } else {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                }
                index += 1
            }
        }
        list.clear()
    }

}

object DestroyedLayerProcessor {
    private var DESTROYED_LAYER_PROCESSOR : BasicLayerProcessor = BasicLayerProcessor.NULL_LAYER_PROCESSOR

    def init() : Unit = {
        DestroyedLayerProcessor.DESTROYED_LAYER_PROCESSOR = new DestroyedLayerProcessor()
    }

    def getInstance() : BasicLayerProcessor = {
        return DestroyedLayerProcessor.DESTROYED_LAYER_PROCESSOR
    }

}


