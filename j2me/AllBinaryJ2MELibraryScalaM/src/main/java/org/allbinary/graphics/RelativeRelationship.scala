/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class RelativeRelationship(param_point : GPoint, param_typesAllowedList : BasicArrayList) {
    import _root_.org.allbinary.graphics.RelativeRelationship.{NULL_RELATIVE_RELATIONSHIP as _, *}
    def NULL_RELATIVE_RELATIONSHIP : RelativeRelationship = _root_.org.allbinary.graphics.RelativeRelationship.NULL_RELATIVE_RELATIONSHIP

    private var typesAllowedList : BasicArrayList = null

    private var x : Int = 0

    private var y : Int = 0

    private var z : Int = 0

    //private Angle[] angleArray;
    //Constructor
    {
        val point : GPoint = param_point
        val typesAllowedList : BasicArrayList = param_typesAllowedList
        this.x = point.getX()
        this.y = point.getY()
        this.z = point.getZ()
        this.typesAllowedList = typesAllowedList
    }

    def getX() : Int = {
        return this.x
    }

    def getY() : Int = {
        return this.y
    }

    def getZ() : Int = {
        return this.z
    }

    def getTypesAllowedList() : BasicArrayList = {
        return this.typesAllowedList
    }

    def setTypesAllowedList(typesAllowedList : BasicArrayList) : Unit = {
        this.typesAllowedList = typesAllowedList
    }

}

object RelativeRelationship {
    val NULL_RELATIVE_RELATIONSHIP : RelativeRelationship = new RelativeRelationship(PointFactory.getInstance().ZERO_ZERO, BasicArrayListUtil.getInstance().getImmutableInstance())

}


