/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map.platform

import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListS

class BasicPlatormGeographicMapCellType(param_types : BasicArrayList) {
    import _root_.org.allbinary.media.graphics.geography.map.platform.BasicPlatormGeographicMapCellType.{*}

    private var types : Array[Int] = null

    //    }
    //Constructor
    {
        val types : BasicArrayList = param_types
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
                new GeographicMapCellType(`type`, 0)
                typeArray(index) = `type`
                index += 1
            }
        }
        this.types = typeArray
    }

    def isType(`type` : GeographicMapCellType) : Boolean = {
        return this.hasType(`type`.getType())
    }

    def hasType(`type` : Int) : Boolean = {
        val size : Int = types.length

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

}

object BasicPlatormGeographicMapCellType {
    def createType(`type` : Int) : BasicPlatormGeographicMapCellType = {
        //super(type);
        val types : BasicArrayList = new BasicArrayListS(1)
        types.add(SmallIntegerSingletonFactory.getInstance().getAt(`type`))
        val basicPlatormGeographicMapCellType : BasicPlatormGeographicMapCellType = new BasicPlatormGeographicMapCellType(types)
        //this.types[0] = type;
        return basicPlatormGeographicMapCellType
    }

}


