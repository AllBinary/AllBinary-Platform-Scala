/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMapCellPositionFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.PathData
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class StaticPathGenerator() extends PathGeneratorInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    //Constructor
    {
        PreLogUtil.put("Using Static Path Finding", this, CommonStrings.getInstance().CONSTRUCTOR)
    }

    def init(geographicMapInterface : Object, totalPaths : Int) : Unit = {
    }

    //into static paths with GeographicMapCellPositions
    private def getGeographicMapCellPositionListFromBasicGeographicMapCellPositionList(geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory, pathList : BasicArrayList) : BasicArrayList = {
        val list : BasicArrayList = new BasicArrayListD()
        val size : Int = pathList.size()
        var basicGeographicMapCellPosition : CellPosition = null
        var geographicMapCellPosition : GeographicMapCellPosition = null

        {
            var index : Int = 0
            while (index < size) {
                basicGeographicMapCellPosition = pathList.get(index).asInstanceOf[CellPosition]
                geographicMapCellPosition = geographicMapCellPositionFactory.getAt(basicGeographicMapCellPosition.getColumn(), basicGeographicMapCellPosition.getRow())
                list.add(geographicMapCellPosition)
                index += 1
            }
        }
        return list
    }

    override def createList(geographicMapInterface : BasicGeographicMap, geographicMapCellHistory : GeographicMapCellHistory, pathFindingInfo : PathFindingInfo, totalPaths : Int) : BasicArrayList = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            val pathCacheFactory : PathCacheFactory = PathCacheFactory.getInstance()
            val mapIdInteger : Integer = geographicMapInterface.getAllBinaryTiledLayer().getDataId()
            var list : BasicArrayList = pathCacheFactory.getOrCreate(mapIdInteger)
            if (list eq this.basicArrayListUtil.getImmutableInstance()) {
                list = new BasicArrayListD()
                val smallIntegerSingletonFactory : SmallIntegerSingletonFactory = SmallIntegerSingletonFactory.getInstance()
                val geographicMapCellPositionFactory : BasicGeographicMapCellPositionFactory = geographicMapInterface.getGeographicMapCellPositionFactory()
                val id : Int = PathData.getInstance().OFFSET + mapIdInteger.intValue()
                val basicList : BasicArrayList = pathCacheFactory.getOrCreate(smallIntegerSingletonFactory.getAt(id))
                val size : Int = basicList.size()
                var pathList : BasicArrayList = null

                {
                    var index : Int = 0
                    while (index < size) {
                        pathList = this.getGeographicMapCellPositionListFromBasicGeographicMapCellPositionList(geographicMapCellPositionFactory, basicList.get(index).asInstanceOf[BasicArrayList])
                        list.add(pathList)
                        index += 1
                    }
                }
                pathCacheFactory.add(mapIdInteger, list)
                pathCacheFactory.remove(smallIntegerSingletonFactory.getAt(id))
            }
            this.logUtil.putF(new StringMaker().append("Using Cached Path(s): ").append(StringUtil.getInstance().toString(list)).toString(), this, commonStrings.GET_INSTANCE)
            return list
        } catch {
            case e : Exception => {
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                return new BasicArrayListD()
            }
        }
        throw new IllegalStateException()
    }

}


