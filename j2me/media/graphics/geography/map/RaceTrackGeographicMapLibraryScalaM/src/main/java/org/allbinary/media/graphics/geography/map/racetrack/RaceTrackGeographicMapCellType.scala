/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType

class RaceTrackGeographicMapCellType(param_name : String, param_type : Int, param_travelCost : Int, param_reset : Int) extends GeographicMapCellType(param_type, param_reset) {

    /*    public long northTravelCostBetweenArray[][] = {       //MAX        { max, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, max, max, max, max, max, max, max },       { 0, 0, 0, max, max, max, 0, 0 },       { 0, 0, 0, max, max, max, max, max }    };     public long southTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, 0, 0, max, 0, 0 },       { 0, max, max, 0, 0, max, max, max }    };     public long eastTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, max, 0, max, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, 0, max, 0, max, 0, max, max },       { 0, 0, max, 0, max, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max }    };     public long westTravelCostBetweenArray[][] = {       { max, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, 0, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, 0, max, 0, max, max, max },       { 0, max, max, max, max, max, max, max },       { 0, max, max, max, max, max, max, max }    };       */
    var name : String = null

    private var travelCost : Int = 0

    //   }
    //Constructor
    {
        val name : String = param_name
        val `type` : Int = param_type
        val travelCost : Int = param_travelCost
        val reset : Int = param_reset
        this.name = name
        this.travelCost = travelCost
    }

    //}
    def getTravelCost() : Int = {
        return this.travelCost
    }

}


