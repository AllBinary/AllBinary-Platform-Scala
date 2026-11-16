/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.combat.destroy.event

import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class DestroyedEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.combat.destroy.event.DestroyedEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer) : Unit = {
        if (!this.list.contains(collidableDestroyableDamageableLayer)) {
            this.list.add(collidableDestroyableDamageableLayer)
        }
    }

    override def removeAllListeners() : Unit = this.synchronized {
        this.list.clear()
        super.removeAllListeners()
    }

    override def removeListener(eventListenerInterface : EventListenerInterface) : Unit = this.synchronized {
        this.list.remove(eventListenerInterface)
        super.removeListener(eventListenerInterface)
    }

    override def fireEvent(eventObject : AllBinaryEventObject) : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    var collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer = this.list.objectArray(index).asInstanceOf[CollidableDestroyableDamageableLayer]
                    collidableDestroyableDamageableLayer.onDestroyed(eventObject.asInstanceOf[DestroyedEvent])
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
        val destroyedEventListenerInterface : DestroyedEventListenerInterface = eventListenerInterface.asInstanceOf[DestroyedEventListenerInterface]
        destroyedEventListenerInterface.onDestroyed(eventObject.asInstanceOf[DestroyedEvent])
    }

}

object DestroyedEventHandler {
    private val instance : DestroyedEventHandler = new DestroyedEventHandler()

    def getInstance() : DestroyedEventHandler = this.synchronized {
        return DestroyedEventHandler.instance
    }

}


