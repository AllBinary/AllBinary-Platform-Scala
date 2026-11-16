/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.graphics.geography.map

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.AnimationBehavior
import _root_.org.allbinary.animation.text.TextAnimation
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.font.MyFontProcessor
import _root_.org.allbinary.graphics.font.UpdateMyFontInterface
import _root_.org.allbinary.graphics.font.UpdateMyFontProcessor
import _root_.org.allbinary.logic.math.BasicDecimal

class GeographicMapCellHistory() extends UpdateMyFontInterface {
    import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory.{NULL_GEOGRPAHIC_MAP_HISTORY_ARRAY as _, *}
    def NULL_GEOGRPAHIC_MAP_HISTORY_ARRAY : Array[GeographicMapCellHistory] = _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellHistory.NULL_GEOGRPAHIC_MAP_HISTORY_ARRAY

    val logUtil : LogUtil = LogUtil.getInstance()

    private val booleanFactory : BooleanFactory = BooleanFactory.getInstance()

    private var list : BasicArrayList = null

    private var visitedList : BasicArrayList = null

    private val MISSED_INFO : String = "Missed"

    private val animation : Animation = new TextAnimation(this.MISSED_INFO, AnimationBehavior.getInstance())

    private var myFontProcessor : MyFontProcessor = new UpdateMyFontProcessor(this)

    private var totalVisited : Int = 0

    private var halfWidth : Int = 0

    private var fontHeight : Int = 0

    private val RED : Int = BasicColorFactory.getInstance().RED.intValue()

    //Constructor
    {
        this.list = new BasicArrayListD()
        this.visitedList = new BasicArrayListD()
        this.init()
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        this.fontHeight = font.getHeight()
        this.myFontProcessor = MyFontProcessor.getInstance()
    }

    def getTotalVisited() : Int = {
        return this.totalVisited
    }

    def getTotalNotVisited() : Int = {
        return this.getSize() - this.totalVisited
    }

    def getSize() : Int = {
        return this.list.size()
    }

    def trackAll(list : BasicArrayList) : Unit = {
        val size : Int = list.size()
        this.list.ensureCapacity(size)
        this.visitedList.ensureCapacity(size)
        var geographicMapCellPosition : GeographicMapCellPosition = null

        {
            var index : Int = 0
            while (index < size) {
                geographicMapCellPosition = list.get(index).asInstanceOf[GeographicMapCellPosition]
                this.track(geographicMapCellPosition)
                index += 1
            }
        }
    }

    def track(geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        //Don't allow duplicates
        if (!this.list.contains(geographicMapCellPosition)) {
            this.list.add(geographicMapCellPosition)
            this.visitedList.add(this.booleanFactory.FALSE)
        }
    }

    def getTracked() : BasicArrayList = {
        return this.list
    }

    def getVisited() : BasicArrayList = {
        return this.visitedList
    }

    /*    public GeographicMapCellPosition getRandom()    {       return (GeographicMapCellPosition) BasicArrayListUtil.getRandom(this.list);    }     * */
    def getAfterIfNotLast(geographicMapCellPosition : GeographicMapCellPosition) : GeographicMapCellPosition = {
        val localList : BasicArrayList = this.list
        val index : Int = localList.indexOf(geographicMapCellPosition)
        if (localList.size() > (index + 1)) {
            return localList.get(index + 1).asInstanceOf[GeographicMapCellPosition]
        }
        return geographicMapCellPosition
    }

    def getFirstUnvisited() : GeographicMapCellPosition = {
        val localList : BasicArrayList = this.list
        val localVisitedList : BasicArrayList = this.visitedList
        val size : Int = localVisitedList.size()
        var value : _root_.java.lang.Boolean = null

        {
            var index : Int = 0
            while (index < size) {
                value = this.visitedList.get(index).asInstanceOf[_root_.java.lang.Boolean]
                if (value == this.booleanFactory.FALSE) {
                    return localList.get(index).asInstanceOf[GeographicMapCellPosition]
                }
                index += 1
            }
        }
        return localList.get(0).asInstanceOf[GeographicMapCellPosition]
    }

    def getFirstUnvisitedIndex() : Int = {
        var localVisitedList : BasicArrayList = this.visitedList
        var size : Int = localVisitedList.size()
        var value : _root_.java.lang.Boolean = null

        {
            var index : Int = 0
            while (index < size) {
                value = this.visitedList.get(index).asInstanceOf[_root_.java.lang.Boolean]
                if (value == this.booleanFactory.FALSE) {
                    return index
                }
                index += 1
            }
        }
        return 0
    }

    def getInPathButNotTracked(pathList : BasicArrayList) : BasicArrayList = {
        val inPathButNotTrackedList : BasicArrayList = new BasicArrayListD()
        val localList : BasicArrayList = this.list
        val size : Int = pathList.size()
        var geographicMapCellPosition : GeographicMapCellPosition = null

        {
            var index : Int = 0
            while (index < size) {
                geographicMapCellPosition = pathList.get(index).asInstanceOf[GeographicMapCellPosition]
                if (!localList.contains(geographicMapCellPosition)) {
                    inPathButNotTrackedList.add(geographicMapCellPosition)
                }
                index += 1
            }
        }
        return inPathButNotTrackedList
    }

    def isVisited(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        var index : Int = this.list.indexOf(geographicMapCellPosition)
        if (index != -1) {
            var value : _root_.java.lang.Boolean = this.visitedList.get(index).asInstanceOf[_root_.java.lang.Boolean]
            if (value == this.booleanFactory.TRUE) {
                return true
            }
        } else {
        }
        return false
    }

    def visit(geographicMapCellPosition : GeographicMapCellPosition) : Boolean = {
        val index : Int = this.list.indexOf(geographicMapCellPosition)
        var value : _root_.java.lang.Boolean = null
        if (index != -1) {
            value = this.visitedList.get(index).asInstanceOf[_root_.java.lang.Boolean]
            var TRUE : _root_.java.lang.Boolean = this.booleanFactory.TRUE
            if (value != TRUE) {
                this.visitedList.set(index, TRUE)
                this.totalVisited += 1
                return true
            }
        } else {
        }
        return false
    }

    /*    public Boolean isVisited(    GeographicMapCellPosition geographicMapCellPosition)    throws Exception    {    int index = this.list.indexOf(geographicMapCellPosition);    if (index != -1)    {    Boolean isCellVisitedBoolean = (Boolean) this.visitedList.get(index);    return isCellVisitedBoolean;    }    else    {    return falseBoolean;    }    }      */
    def isAllVisited() : Boolean = {
        if (this.totalVisited == (this.getSize() - 1)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isAllVisited2() : Boolean = {
        if (this.totalVisited == this.getSize()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def isPortionVisited(basicDecimal : BasicDecimal) : Boolean = {
        val size : Int = this.getSize()
        val numberRequired : Int = (size << basicDecimal.getScaledFactor()) / basicDecimal.getUnscaled().toInt
        //int numberNotVisited = 0;
        val numberNotVisited : Int = (this.getSize() - 1) - this.totalVisited
        /*       this.logUtil.putF(          "Total Visited: " + (size - numberNotVisited) +          " out of " + size + " Number Required: " + numberRequired, this, "isMostlyVisited");          */
        if ((size - numberNotVisited) > numberRequired) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def reset() : Unit = {
        val localVisitedList : BasicArrayList = this.visitedList
        val localFalseBoolean : _root_.java.lang.Boolean = this.booleanFactory.FALSE
        var size : Int = localVisitedList.size()

        {
            var index : Int = size - 1
            while (index >= 0) {
                localVisitedList.set(index, localFalseBoolean)
                index -= 1
            }
        }
        this.totalVisited = 0
    }

    private def paintNotVisitedRelativeToPoint(graphics : Graphics, tiledLayer : AllBinaryTiledLayer, point : GPoint) : Unit = {
        val x : Int = point.getX() - tiledLayer.getXP()
        val y : Int = point.getY() - tiledLayer.getYP()
        //graphics.fillArc(x, y, tiledLayer.getCellWidth(), tiledLayer.getCellHeight(), 0, Angle.THREE_SIXTY);
        if (this.halfWidth == 0) {
            this.halfWidth = (graphics.getFont().stringWidth(this.MISSED_INFO) >> 1)
        }
        val height : Int = 2 * this.fontHeight
        this.animation.paintXY(graphics, x + this.halfWidth, y + (height))
    }

    def paintNotVisited(graphics : Graphics, geographicMapInterface : BasicGeographicMap) : Unit = {
        try {
            this.myFontProcessor.process(graphics)
            graphics.setColor(this.RED)
            val localVisitedList : BasicArrayList = this.visitedList
            //Boolean localFalseBoolean = this.falseBoolean;
            val size : Int = localVisitedList.size()
            var geographicMapCellPosition : GeographicMapCellPosition = null
            var isCellVisitedBoolean : _root_.java.lang.Boolean = null

            {
                var index : Int = size
                while ({ index -= 1; index } >= 0) {
                    geographicMapCellPosition = this.list.get(index).asInstanceOf[GeographicMapCellPosition]
                    isCellVisitedBoolean = localVisitedList.get(index).asInstanceOf[_root_.java.lang.Boolean]
                    //this.isVisited(geographicMapCellPosition);
                    if (!isCellVisitedBoolean.booleanValue()) {
                        this.paintNotVisitedRelativeToPoint(graphics, geographicMapInterface.getAllBinaryTiledLayer(), geographicMapCellPosition.getPoint())
                    }
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "paintNotVisited", e)
            }
        }
    }

    def init() : Unit = {
        this.list.clear()
        this.visitedList.clear()
        this.totalVisited = 0
    }

}

object GeographicMapCellHistory {
    val NULL_GEOGRPAHIC_MAP_HISTORY_ARRAY : Array[GeographicMapCellHistory] = new Array[GeographicMapCellHistory](0)

}


