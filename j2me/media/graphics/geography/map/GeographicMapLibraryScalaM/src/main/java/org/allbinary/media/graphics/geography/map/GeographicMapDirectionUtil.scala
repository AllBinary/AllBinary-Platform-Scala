/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.direction.Direction
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.graphics.CellPosition

/**  *  * @author user  */
class GeographicMapDirectionUtil private() {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapDirectionUtil.{*}

    private val MESSAGE : String = "Cell Position should have been cached!!!"

    private val ERROR : String = "Error: "

    private val EQUAL : String = " == "

    def getDirectionFromCellPositionToAdjacentCellPosition(fromGeographicMapCellPosition : GeographicMapCellPosition, toGeographicMapCellPosition : GeographicMapCellPosition) : Direction = {
        var fromColumn : Int = fromGeographicMapCellPosition.getColumn()
        var fromRow : Int = fromGeographicMapCellPosition.getRow()
        var goColumn : Int = toGeographicMapCellPosition.getColumn()
        var goRow : Int = toGeographicMapCellPosition.getRow()
        var directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if ((fromColumn - 1) == goColumn) {
            return directionFactory.LEFT
        } else if ((fromColumn + 1) == goColumn) {
            return directionFactory.RIGHT
        } else if ((fromRow - 1) == goRow) {
            return directionFactory.UP
        } else if ((fromRow + 1) == goRow) {
            return directionFactory.DOWN
        } else if (fromGeographicMapCellPosition eq toGeographicMapCellPosition) {
            return directionFactory.NO_DIRECTION
        } else if ((fromRow == goRow) && (fromColumn == goColumn)) {
            //return directionFactory.NO_DIRECTION;
            throw new Exception(this.MESSAGE)
        }
        return directionFactory.NOT_BORDERED_WITH
    }

    def getEightDirectionFromCellPositionToAdjacentCellPosition(fromGeographicMapCellPosition : GeographicMapCellPosition, toGeographicMapCellPosition : GeographicMapCellPosition) : Direction = {
        var fromColumn : Int = fromGeographicMapCellPosition.getColumn()
        var fromRow : Int = fromGeographicMapCellPosition.getRow()
        var goColumn : Int = toGeographicMapCellPosition.getColumn()
        var goRow : Int = toGeographicMapCellPosition.getRow()
        var directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if (fromRow == goRow) {
            if ((fromColumn - 1) == goColumn) {
                return directionFactory.LEFT
            } else if ((fromColumn + 1) == goColumn) {
                return directionFactory.RIGHT
            }
        } else if ((fromRow - 1) == goRow) {
            if (fromColumn == goColumn) {
                return directionFactory.UP
            }
            if ((fromColumn - 1) == goColumn) {
                return directionFactory.UP_LEFT
            } else if ((fromColumn + 1) == goColumn) {
                return directionFactory.UP_RIGHT
            }
        } else if ((fromRow + 1) == goRow) {
            if (fromColumn == goColumn) {
                return directionFactory.DOWN
            }
            if ((fromColumn - 1) == goColumn) {
                return directionFactory.DOWN_LEFT
            } else if ((fromColumn + 1) == goColumn) {
                return directionFactory.DOWN_RIGHT
            }
        } else if (fromGeographicMapCellPosition eq toGeographicMapCellPosition) {
            return directionFactory.NO_DIRECTION
        } else if ((fromRow == goRow) && (fromColumn == goColumn)) {
            //return directionFactory.NO_DRECTION;
            throw new Exception(this.MESSAGE)
        }
        return directionFactory.NOT_BORDERED_WITH
    }

    // This should have combo directions or angle returned.
    def getDirectionFromCellPositionToCellPosition(fromGeographicMapCellPosition : GeographicMapCellPosition, toGeographicMapCellPosition : GeographicMapCellPosition) : Direction = {
        var fromColumn : Int = fromGeographicMapCellPosition.getColumn()
        var fromRow : Int = fromGeographicMapCellPosition.getRow()
        var goColumn : Int = toGeographicMapCellPosition.getColumn()
        var goRow : Int = toGeographicMapCellPosition.getRow()
        var directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if (fromColumn > goColumn) {
            return directionFactory.LEFT
        } else if (fromColumn < goColumn) {
            return directionFactory.RIGHT
        } else if (fromRow > goRow) {
            return directionFactory.UP
        } else if (fromRow < goRow) {
            return directionFactory.DOWN
        }
        val stringMaker : StringMaker = new StringMaker()
        val string : String = stringMaker.append(CellPosition.toStringCellPosition(fromGeographicMapCellPosition)).append(" == ").append(CellPosition.toStringCellPosition(toGeographicMapCellPosition)).toString()
        stringMaker.delete(0, stringMaker.length())
        throw new Exception(stringMaker.append("Error: ").append(string).toString())
    }

    def getEightDirectionFromCellPositionToCellPosition(fromGeographicMapCellPosition : GeographicMapCellPosition, toGeographicMapCellPosition : GeographicMapCellPosition) : Direction = {
        var fromColumn : Int = fromGeographicMapCellPosition.getColumn()
        var fromRow : Int = fromGeographicMapCellPosition.getRow()
        var goColumn : Int = toGeographicMapCellPosition.getColumn()
        var goRow : Int = toGeographicMapCellPosition.getRow()
        var directionFactory : DirectionFactory = DirectionFactory.getInstance()
        if (fromGeographicMapCellPosition eq toGeographicMapCellPosition) {
            return directionFactory.NO_DIRECTION
        } else if (fromRow == goRow) {
            if (fromColumn > goColumn) {
                return directionFactory.LEFT
            } else if (fromColumn < goColumn) {
                return directionFactory.RIGHT
            }
        } else if (fromRow > goRow) {
            if (fromColumn > goColumn) {
                return directionFactory.UP_LEFT
            } else if (fromColumn < goColumn) {
                return directionFactory.UP_RIGHT
            } else if (fromColumn == goColumn) {
                return directionFactory.UP
            }
        } else if (fromRow < goRow) {
            if (fromColumn > goColumn) {
                return directionFactory.DOWN_LEFT
            } else if (fromColumn < goColumn) {
                return directionFactory.DOWN_RIGHT
            } else if (fromColumn == goColumn) {
                return directionFactory.DOWN
            }
        }
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.ERROR)
        stringBuffer.append(CellPosition.toStringCellPosition(fromGeographicMapCellPosition))
        stringBuffer.append(this.EQUAL)
        stringBuffer.append(CellPosition.toStringCellPosition(toGeographicMapCellPosition))
        throw new Exception(stringBuffer.toString())
    }

}

object GeographicMapDirectionUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : GeographicMapDirectionUtil = new GeographicMapDirectionUtil()

    def getInstance() : GeographicMapDirectionUtil = {
        return GeographicMapDirectionUtil.instance
    }

}


