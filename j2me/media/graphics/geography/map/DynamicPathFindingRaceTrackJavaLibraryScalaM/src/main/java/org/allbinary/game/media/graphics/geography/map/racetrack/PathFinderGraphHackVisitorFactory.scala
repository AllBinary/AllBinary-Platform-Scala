/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinderGraphVisitorFactoryBase
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFinderGraphVisitorBase

/**  *  * @author user  */
class PathFinderGraphHackVisitorFactory(param_edgeMinimum : Int, param_minPathWeight : Int, param_maxPathWeight : Int) extends PathFinderGraphVisitorFactoryBase {

    private var edgeMinimum : Int = 0

    private var minPathWeight : Int = 0

    private var maxPathWeight : Int = 0

    //    }
    //Constructor
    {
        val edgeMinimum : Int = param_edgeMinimum
        val minPathWeight : Int = param_minPathWeight
        val maxPathWeight : Int = param_maxPathWeight
        this.edgeMinimum = edgeMinimum
        this.minPathWeight = minPathWeight
        this.maxPathWeight = maxPathWeight
    }

    override def getInstance(geographicMapInterface : BasicGeographicMap) : PathFinderGraphVisitorBase = {
        return new PathFinderGraphHackVisitor[Object, Object](geographicMapInterface, this.edgeMinimum, this.minPathWeight, this.maxPathWeight)
    }

}


