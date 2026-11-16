/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.util.BasicArrayList

/**  *  * @author user  */
class PathGenerator private() extends PathGeneratorInterface {
    import _root_.org.allbinary.media.graphics.geography.pathfinding.PathGenerator.{*}

    def init(geographicMapInterface : Object, totalPaths : Int) : Unit = {
    }

    def getInstanceNoCache(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, totalPaths : Int) : BasicArrayList = {
        //Integer mapIdInteger = geographicMapInterface.getAllBinaryTiledLayer().getDataId();
        val geographicMapCellPositionBasicArrayList : BasicArrayList = this.create(geographicMapInterface, pathFindingInfo, totalPaths)
        return geographicMapCellPositionBasicArrayList
    }

    override def createList(geographicMapInterface : BasicGeographicMap, geographicMapCellHistory : GeographicMapCellHistory, pathFindingInfo : PathFindingInfo, totalPaths : Int) : BasicArrayList = {
        throw new RuntimeException()
    }

    private def create(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, totalPaths : Int) : BasicArrayList = {
        val startPathFindingNodeList : BasicArrayList = pathFindingInfo.getStartPathFindingNodeList()
        val endPathFindingNodeList : BasicArrayList = pathFindingInfo.getEndPathFindingNodeList()
        val geographicPathFinderInterface : GeographicPathFinderBase = pathFindingInfo.getPathFinder()
        val geographicMapCellPositionBasicArrayList : BasicArrayList = geographicPathFinderInterface.searchTotalPath(startPathFindingNodeList, endPathFindingNodeList, totalPaths)
        return geographicMapCellPositionBasicArrayList
    }

    def createN(geographicMapInterface : BasicGeographicMap, pathFindingInfo : PathFindingInfo, totalPaths : Int, multipassState : MultipassState) : BasicArrayList = {
        //timeDelayHelper.setStartTime();
        val startPathFindingNodeList : BasicArrayList = pathFindingInfo.getStartPathFindingNodeList()
        val endPathFindingNodeList : BasicArrayList = pathFindingInfo.getEndPathFindingNodeList()
        val geographicPathFinderInterface : GeographicPathFinderBase = pathFindingInfo.getPathFinder()
        val geographicMapCellPositionBasicArrayList : BasicArrayList = geographicPathFinderInterface.searchTotalPathN(startPathFindingNodeList, endPathFindingNodeList, totalPaths, multipassState)
        //        }
        return geographicMapCellPositionBasicArrayList
    }

    //returns true if - vector contain all of the cells in the path
    private def isValid(pathList : BasicArrayList, geographicMapCellHistory : GeographicMapCellHistory) : Boolean = {
        throw new RuntimeException()
    }

}

object PathGenerator {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val SINGLETON : PathGenerator = new PathGenerator()

    def getInstance() : PathGenerator = {
        return PathGenerator.SINGLETON
    }

}


