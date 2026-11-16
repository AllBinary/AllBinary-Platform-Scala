/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.event

import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPositionTracking

class GeographicMapCellPositionEventUtil(param_anyType : Object) {

    private var geographicMapCellPositionEvent : GeographicMapCellPositionEvent = null

    private val geographicMapCellPositionEventHandler : GeographicMapCellPositionEventHandler = GeographicMapCellPositionEventHandler.getInstance()

    //Constructor
    {
        val anyType : Object = param_anyType
        this.geographicMapCellPositionEvent = new GeographicMapCellPositionEvent(anyType, CellPositionFactory.getInstance().NONE)
    }

    def update(geographicMapCellPositionTracking : GeographicMapCellPositionTracking) : Unit = {
        this.geographicMapCellPositionEvent.setGeographicMapCellPosition(geographicMapCellPositionTracking.getCurrentGeographicMapCellPosition())
        this.geographicMapCellPositionEventHandler.fireEvent(this.geographicMapCellPositionEvent)
    }

    def remove(geographicMapCellPositionTracking : GeographicMapCellPositionTracking) : Unit = {
        this.geographicMapCellPositionEvent.setGeographicMapCellPosition(geographicMapCellPositionTracking.getCurrentGeographicMapCellPosition())
        this.geographicMapCellPositionEventHandler.fireRemoveEvent(this.geographicMapCellPositionEvent)
    }

}


