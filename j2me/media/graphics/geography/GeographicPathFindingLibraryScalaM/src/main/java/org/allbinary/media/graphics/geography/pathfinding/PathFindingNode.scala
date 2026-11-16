/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.pathfinding

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.string.CommonLabels

class PathFindingNode(param_parent : Object, param_geographicMapCellPosition : GeographicMapCellPosition) {

    var parent : Object = NullUtil.getInstance().NULL_OBJECT

    var geographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    //Constructor
    {
        val parent : Object = param_parent
        val geographicMapCellPosition : GeographicMapCellPosition = param_geographicMapCellPosition
        this.parent = parent
        this.setGeographicMapCellPositionP(geographicMapCellPosition)
        /*       if(this.getParent() == null)       {          this.logUtil.putF("No Parent", this, this.commonStrings.CONSTRUCTOR);       }          */
        if (this.geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            throw new Exception("No GeographicMapCellPosition")
        }
    }

    def getParentP() : PathFindingNode = {
        return this.parent.asInstanceOf[PathFindingNode]
    }

    def setGeographicMapCellPositionP(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        this.geographicMapCellPosition = geographicMapCellPosition
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.getClass().getName())
        stringBuffer.append(CommonLabels.getInstance().COLON_SEP)
        stringBuffer.append(" Path: ")
        stringBuffer.append(this.geographicMapCellPosition.toString())
        var pathFindingNode : PathFindingNode = this.getParentP()

        {
            while (pathFindingNode != null) {
                stringBuffer.append(pathFindingNode.geographicMapCellPosition.toString())
                stringBuffer.append(CommonSeps.getInstance().SPACE)
                pathFindingNode = pathFindingNode.getParentP()
            }
        }
        return stringBuffer.toString()
    }

}


