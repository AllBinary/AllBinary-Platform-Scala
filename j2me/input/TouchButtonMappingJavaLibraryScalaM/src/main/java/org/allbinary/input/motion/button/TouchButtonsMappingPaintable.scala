/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class TouchButtonsMappingPaintable(param_basicColor : BasicColor) extends Paintable {

    val logUtil : LogUtil = LogUtil.getInstance()

    var foregroundColor : Int = 0

    private var paintableTable : Array[Array[Paintable]] = Array.ofDim[Paintable](0, 0)

    private var touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()

    //Constructor
    {
        val basicColor : BasicColor = param_basicColor
        this.foregroundColor = basicColor.intValue()
        this.init()
    }

    private def init() : Unit = {
        try {
            this.paintableTable = this.createPaintableTable()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, "updateRectangle", e)
            }
        }
    }

    private def createPaintableTable() : Array[Array[Paintable]] = {
        var totalColumns : Int = this.touchButtonLocationHelper.getTotalColumns()
        var totalRows : Int = this.touchButtonLocationHelper.getTotalRows()
        var paintableTable : Array[Array[Paintable]] = Array.ofDim[Paintable](totalColumns, totalRows)
        var cellPositionFactory : CellPositionFactory = CellPositionFactory.getInstance()
        var commonButtons : CommonButtons = CommonButtons.getInstance()

        {
            var index : Int = totalColumns - 1
            while (index >= 0) {

                {
                    var rowIndex : Int = totalRows - 1
                    while (rowIndex >= 0) {
                        this.paintableTable(index)(rowIndex) = TouchButton.createButton(BasicTouchInputFactory.getInstance().NONE, TouchButtonBlankResource.getInstance(), commonButtons.NORMAL_BUTTON, cellPositionFactory.getInstanceColRow(index, rowIndex), this.touchButtonLocationHelper.getColumnsRemainderHalf(), this.touchButtonLocationHelper.getRowsRemainderHalf())
                        rowIndex -= 1
                    }
                }
                index -= 1
            }
        }
        return paintableTable
    }

    override def paint(graphics : Graphics) : Unit = {
        var totalColumns : Int = this.touchButtonLocationHelper.getTotalColumns()
        var totalRows : Int = this.touchButtonLocationHelper.getTotalRows()

        {
            var index : Int = totalColumns - 1
            while (index >= 0) {

                {
                    var rowIndex : Int = totalRows - 1
                    while (rowIndex >= 0) {
                        this.paintableTable(index)(rowIndex).paint(graphics)
                        rowIndex -= 1
                    }
                }
                index -= 1
            }
        }
    }

}


