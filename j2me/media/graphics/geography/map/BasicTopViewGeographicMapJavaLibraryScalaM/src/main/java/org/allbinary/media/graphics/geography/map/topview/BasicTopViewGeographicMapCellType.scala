/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.topview

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellTypeFactory
import _root_.org.allbinary.media.graphics.geography.map.racetrack.RaceTrackGeographicMapCellType
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListS

class BasicTopViewGeographicMapCellType(param_name : String, param_types : BasicArrayList, param_cost : Int) {
    import _root_.org.allbinary.media.graphics.geography.map.topview.BasicTopViewGeographicMapCellType.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    var name : String = null

    var cost : Int = 0

    private var types : Array[Int] = null

    //    }
    //Constructor
    {
        val name : String = param_name
        val types : BasicArrayList = param_types
        val cost : Int = param_cost
        //super(Integer.MIN_VALUE);
        val size : Int = types.size()
        val typeArray : Array[Int] = new Array[Int](size)
        var typeAsInteger : Integer = null
        var `type` : Int = 0

        {
            var index : Int = 0
            while (index < size) {
                typeAsInteger = (types.get(index).asInstanceOf[Integer])
                `type` = typeAsInteger.intValue()
                if (GeographicMapCellTypeFactory.getInstance().getGeographicMapCellTypeArray()(`type`) == null) {
                    new RaceTrackGeographicMapCellType(name, `type`, cost, 0)
                } else {
                }
                typeArray(index) = `type`
                index += 1
            }
        }
        this.name = name
        this.cost = cost
        this.types = typeArray
    }

    def isType(`type` : GeographicMapCellType) : Boolean = {
        return this.hasType(`type`.getType())
    }

    def hasType(`type` : Int) : Boolean = {
        val size : Int = this.types.length

        {
            var index : Int = 0
            while (index < size) {
                if (this.types(index) == `type`) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    def getTypes() : Array[Int] = {
        return this.types
    }

    override def toString() : String = {
        val stringMaker : StringMaker = new StringMaker()
        val size : Int = this.types.length

        {
            var index : Int = 0
            while (index < size) {
                stringMaker.appendint(this.types(index)).append(CommonSeps.getInstance().COMMA)
                index += 1
            }
        }
        return stringMaker.toString()
    }

}

object BasicTopViewGeographicMapCellType {
    //    }
    def createType(name : String, `type` : Int, cost : Int) : BasicTopViewGeographicMapCellType = {
        //        this.types[0] = type;
        val types : BasicArrayList = new BasicArrayListS(1)
        types.add(Integer.valueOf(`type`))
        return new BasicTopViewGeographicMapCellType(name, types, cost)
    }

}


