/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.media.graphics.geography.map.racetrack

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapInterfaceFactoryInterface
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackRoadsGeographicMapCellHistoryFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTracksPathPrinter
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathFindingInfo
import _root_.org.allbinary.media.graphics.geography.pathfinding.PathGenerator

/**  *  * @author user  * Used for generating static paths.  Use in the build game method  */
class DynamicRaceTracksPathPrinter extends RaceTracksPathPrinter {

    val logUtil : LogUtil = LogUtil.getInstance()

    def printAllPaths(raceTrackGeographicMapInterfaceFactoryInterface : RaceTrackGeographicMapInterfaceFactoryInterface, pathFindingInfo : PathFindingInfo, size : Int) : Unit = {
        try {
            //ImageCacheFactory.init();

            {
                var index : Int = 0
                while (index < size) {
                    var geographicMapInterface : BasicGeographicMap = raceTrackGeographicMapInterfaceFactoryInterface.getTrackInstance(SmallIntegerSingletonFactory.getInstance().getAt(index))
                    var list : BasicArrayList = PathGenerator.getInstance().createList(geographicMapInterface, RaceTrackRoadsGeographicMapCellHistoryFactory.getInstance(), pathFindingInfo, 10)
                    System.out.println("Track " + index)
                    this.printPaths(list)
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.PROCESS, e)
            }
        }
    }

}


