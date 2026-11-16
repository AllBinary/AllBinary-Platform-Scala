/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.racetrack

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonLabels

/**  *  * @author user  * Used for generating static paths.  Use in the build game method  */
class RaceTracksPathPrinter {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private def printPath(list : BasicArrayList) : Unit = {
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                var anyType : Object = list.get(index)
                PreLogUtil.put(new StringMaker().append("pathList.add(cellPositionFactory.getInstance").append(anyType.toString()).append(");").toString(), this, "printPath")
                index += 1
            }
        }
    }

    def printPaths(list : BasicArrayList) : Unit = {
        val size : Int = list.size()

        {
            var index : Int = 0
            while (index < size) {
                System.out.println(new StringMaker().append(" Path ").appendint(index).append(CommonLabels.getInstance().COLON_SEP).toString())
                this.printPath(list.get(index).asInstanceOf[BasicArrayList])
                index += 1
            }
        }
    }

}


