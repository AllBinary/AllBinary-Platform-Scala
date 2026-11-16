/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.game.layer.AllBinaryGameLayer
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class GeographicMapEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapEventHandler.{*}

    private val list : BasicArrayList = new BasicArrayListD()

    def addListener(gameLayer : AllBinaryGameLayer) : Unit = {
        if (!this.list.contains(gameLayer)) {
            this.list.add(gameLayer)
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

    def fireEvent() : Unit = {

        {
            var index : Int = this.list.size()
            while ({ index -= 1; index } >= 0) {
                try {
                    var gameLayer : AllBinaryGameLayer = this.list.get(index).asInstanceOf[AllBinaryGameLayer]
                    gameLayer.move()
                } catch {
                    case e : Exception => {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e)
                    }
                }
            }
        }
    }

}

object GeographicMapEventHandler {
    private var instance : GeographicMapEventHandler = new GeographicMapEventHandler()

    def getInstance() : GeographicMapEventHandler = {
        return GeographicMapEventHandler.instance
    }

}


