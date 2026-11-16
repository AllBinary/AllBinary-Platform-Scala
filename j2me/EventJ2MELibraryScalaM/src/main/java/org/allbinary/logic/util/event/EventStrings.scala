/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event


/**  *  * @author User  */
class EventStrings {
    import _root_.org.allbinary.logic.util.event.EventStrings.{*}

    val PERFORMANCE_MESSAGE : String = "Use Custom onEvent Methods for needed optimization"

    val TOTAL_LISTENERS : String = "Total Listeners: "

    val LISTENER_LABEL : String = " Listener: "

    val FIRE_EVENT : String = "fireEvent"

}

object EventStrings {
    private val instance : EventStrings = new EventStrings()

    /**      * @return the instance      */
    def getInstance() : EventStrings = {
        return EventStrings.instance
    }

}


