/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.direction

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps

class DirectionFactory private() {
    import _root_.org.allbinary.direction.DirectionFactory.{*}

    val NAME : String = "DIRECTION"

    val LEFT : Direction = new Direction(CommonPhoneStrings.getInstance().LEFT, "WEST", 0, 1)

    val RIGHT : Direction = new Direction(CommonPhoneStrings.getInstance().RIGHT, "EAST", 1, 0)

    val DOWN : Direction = new Direction(CommonPhoneStrings.getInstance().DOWN, "SOUTH", 2, 0)

    val UP : Direction = new Direction(CommonPhoneStrings.getInstance().UP, "NORTH", 3, 0)

    var UP_LEFT : Direction = null

    var UP_RIGHT : Direction = null

    var DOWN_LEFT : Direction = null

    var DOWN_RIGHT : Direction = null

    val NOT_BORDERED_WITH : Direction = new Direction("NOT_BORDERED_WITH", "NOT_BORDERED_WITH", 8, 0)

    val NO_DIRECTION : Direction = new Direction("NO_DIRECTION", "NO_DIRECTION", 9, 0)

    val TOP : Direction = new Direction("TOP", "TOP", 10, 0)

    val BOTTOM : Direction = new Direction("BOTTOM", "BOTTOM", 11, 0)

    val ALL_DIRECTION : Direction = new Direction("ALL_DIRECTION", "ALL_DIRECTION", 12, 0)

    //Constructor
    {
        var stringBuffer : StringMaker = new StringMaker()
        var commonSeps : CommonSeps = CommonSeps.getInstance()
        this.UP_LEFT = new Direction("UP LEFT", stringBuffer.append(this.UP.getOtherName()).append(commonSeps.SPACE).append(this.LEFT.getOtherName()).toString(), 4, 0)
        stringBuffer.delete(0, stringBuffer.length())
        this.UP_RIGHT = new Direction("UP RIGHT", stringBuffer.append(this.UP.getOtherName()).append(commonSeps.SPACE).append(this.RIGHT.getOtherName()).toString(), 5, 0)
        stringBuffer.delete(0, stringBuffer.length())
        this.DOWN_LEFT = new Direction("DOWN LEFT", stringBuffer.append(this.DOWN.getOtherName()).append(commonSeps.SPACE).append(this.LEFT.getOtherName()).toString(), 6, 0)
        stringBuffer.delete(0, stringBuffer.length())
        this.DOWN_RIGHT = new Direction("DOWN RIGHT", stringBuffer.append(this.DOWN.getOtherName()).append(commonSeps.SPACE).append(this.RIGHT.getOtherName()).toString(), 7, 0)
    }

}

object DirectionFactory {
    private val instance : DirectionFactory = new DirectionFactory()

    def getInstance() : DirectionFactory = {
        return DirectionFactory.instance
    }

}


