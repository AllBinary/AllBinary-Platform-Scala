/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class GeographicPathFinderBase {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.GeographicPathFinderBase.{NULL_GEOGRAPHIC_PATH_FINDER_BASE as _, *}
    def NULL_GEOGRAPHIC_PATH_FINDER_BASE : GeographicPathFinderBase = _root_.org.allbinary.media.graphics.geography.pathfinding.GeographicPathFinderBase.NULL_GEOGRAPHIC_PATH_FINDER_BASE

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def searchTotalPath(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, totalPaths : Int) : BasicArrayList = {
        throw new RuntimeException()
    }

    def searchTotalPathN(startPathFindingNodeList : BasicArrayList, endPathFindingNodeList : BasicArrayList, totalPaths : Int, multipassState : MultipassState) : BasicArrayList = {
        throw new RuntimeException()
    }

}

object GeographicPathFinderBase {
    val NULL_GEOGRAPHIC_PATH_FINDER_BASE : GeographicPathFinderBase = new GeographicPathFinderBase()

}


