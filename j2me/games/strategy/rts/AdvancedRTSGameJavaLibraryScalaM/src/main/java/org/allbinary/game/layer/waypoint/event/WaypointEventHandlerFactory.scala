/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint.event

import _root_.org.allbinary.game.identification.Group

/**  *  * @author user  */
class WaypointEventHandlerFactory {
    import _root_.org.allbinary.game.layer.waypoint.event.WaypointEventHandlerFactory.{*}

}

object WaypointEventHandlerFactory {
    //One for each Group
    private val eventHandlerArray : Array[WaypointEventHandler] = Array[WaypointEventHandler](new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler(), new WaypointEventHandler())

    def getInstance(groupInterface : Group) : WaypointEventHandler = {
        val groupId : Int = groupInterface.getGroupId().toInt
        return WaypointEventHandlerFactory.eventHandlerArray(groupId)
    }

    def removeAll() : Unit = {

        {
            var index : Int = WaypointEventHandlerFactory.eventHandlerArray.length - 1
            while (index >= 0) {
                WaypointEventHandlerFactory.eventHandlerArray(index).removeAllListeners()
                index -= 1
            }
        }
    }

}


