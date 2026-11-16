/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author user  */
class GeographicMapCellHistoryProgress(param_geographicMapCellHistoryArray : Array[GeographicMapCellHistory]) extends GeographicMapCellHistoryProgressBase {

    private var totalVisitedArray : Array[Int] = NullUtil.getInstance().NULL_INT_ARRAY

    private var geographicMapCellHistoryArray : Array[GeographicMapCellHistory] = GeographicMapCellHistory.NULL_GEOGRPAHIC_MAP_HISTORY_ARRAY

    //Constructor
    {
        val geographicMapCellHistoryArray : Array[GeographicMapCellHistory] = param_geographicMapCellHistoryArray
        this.geographicMapCellHistoryArray = geographicMapCellHistoryArray
        this.init()
    }

    override def init() : Unit = {
        this.totalVisitedArray = new Array[Int](this.geographicMapCellHistoryArray.length)
    }

    override def isAnyProgress() : Boolean = {
        var isProgressing : Boolean = false
        var size : Int = this.geographicMapCellHistoryArray.length
        var currentTotalVisited : Int = 0
        var totalVisited : Int = 0

        {
            var index : Int = 0
            while (index < size) {
                totalVisited = this.geographicMapCellHistoryArray(index).getTotalVisited()
                currentTotalVisited = this.totalVisitedArray(index)
                if (currentTotalVisited < totalVisited) {
                    isProgressing = true
                    this.totalVisitedArray(index) = totalVisited
                }
                index += 1
            }
        }
        return isProgressing
    }

}


