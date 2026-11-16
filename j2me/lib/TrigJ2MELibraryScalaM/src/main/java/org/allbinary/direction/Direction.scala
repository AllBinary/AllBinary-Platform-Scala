/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.direction

import _root_.org.allbinary.logic.string.StringMaker

class Direction(param_name : String, param_otherName : String, param_value : Int, param_frameFactor : Int) {
    import _root_.org.allbinary.direction.Direction.{*}

    private var name : String = null

    private var otherName : String = null

    private var value : Int = 0

    private var frameFactor : Int = 0

    //Constructor
    {
        val name : String = param_name
        val otherName : String = param_otherName
        val value : Int = param_value
        val frameFactor : Int = param_frameFactor
        this.name = name
        this.otherName = otherName
        this.value = value
        this.frameFactor = frameFactor
        Direction.directionArray(value) = this
    }

    def getValue() : Int = {
        return this.value
    }

    def getFrameFactor() : Int = {
        return this.frameFactor
    }

    def getOtherName() : String = {
        return this.otherName
    }

    def getName() : String = {
        return this.name
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Direction: ")
        stringBuffer.append(this.getName())
        stringBuffer.append(" Or: ")
        stringBuffer.append(this.getOtherName())
        stringBuffer.append(" Value: ")
        stringBuffer.appendint(this.value)
        return stringBuffer.toString()
    }

}

object Direction {
    private var directionArray : Array[Direction] = new Array[Direction](13)

    def getInstance(direction : Int) : Direction = {
        // hashtable.get(Integer.valueOf(direction));
        return Direction.directionArray(direction)
    }

}


