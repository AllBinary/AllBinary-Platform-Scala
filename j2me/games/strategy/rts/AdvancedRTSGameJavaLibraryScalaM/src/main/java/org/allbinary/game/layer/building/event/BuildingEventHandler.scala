/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.building.event

import _root_.org.allbinary.game.layer.RTSLayerEvent
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class BuildingEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.game.layer.building.event.BuildingEventHandler.{*}

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val buildingEventListenerInterface : BuildingEventListenerInterface = (eventListenerInterface.asInstanceOf[BuildingEventListenerInterface])
        buildingEventListenerInterface.onBuildingEvent(eventObject.asInstanceOf[RTSLayerEvent])
    }

}

object BuildingEventHandler {
    private var eventHandler : BuildingEventHandler = new BuildingEventHandler()

    def getInstance() : BuildingEventHandler = {
        return BuildingEventHandler.eventHandler
    }

}


