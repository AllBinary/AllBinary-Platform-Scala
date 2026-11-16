/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.graphics.CellPosition
import _root_.org.allbinary.graphics.CellPositionFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class BasicTouchButtonCellPositionFactory() {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    var TOP_RIGHT : CellPosition = null

    var TOP_LEFT : CellPosition = null

    var SECOND_FROM_TOP_LEFT : CellPosition = null

    var SECOND_FROM_TOP_RIGHT : CellPosition = null

    var TOP_SECOND_FROM_LEFT : CellPosition = null

    var TOP_SECOND_FROM_RIGHT : CellPosition = null

    //public CellPosition SECOND_FROM_BOTTOM_RIGHT;
    var BOTTOM_RIGHT : CellPosition = null

    var BOTTOM_SECOND_FROM_RIGHT : CellPosition = null

    var SECOND_FROM_BOTTOM_RIGHT : CellPosition = null

    var THIRD_FROM_BOTTOM_RIGHT : CellPosition = null

    var FOURTH_FROM_BOTTOM_RIGHT : CellPosition = null

    var SECOND_FROM_BOTTOM_SECOND_FROM_RIGHT : CellPosition = null

    var SECOND_FROM_BOTTOM_THIRD_FROM_RIGHT : CellPosition = null

    var SECOND_FROM_BOTTOM_FOURTH_FROM_RIGHT : CellPosition = null

    var BOTTOM_THIRD_FROM_RIGHT : CellPosition = null

    var BOTTOM_FOURTH_FROM_RIGHT : CellPosition = null

    var BOTTOM_SECOND_FROM_LEFT : CellPosition = null

    var SECOND_FROM_BOTTOM_LEFT : CellPosition = null

    var THIRD_FROM_BOTTOM_LEFT : CellPosition = null

    var BOTTOM_LEFT : CellPosition = null

    var SECOND_FROM_BOTTOM_SECOND_FROM_LEFT : CellPosition = null

    //Constructor
    {
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
        val cellPositionFactory : CellPositionFactory = CellPositionFactory.getInstance()
        cellPositionFactory.init(touchButtonLocationHelper.getTotalColumns(), touchButtonLocationHelper.getTotalRows())
        this.TOP_LEFT = cellPositionFactory.getInstanceColRow(0, 0)
        this.TOP_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, 0)
        this.BOTTOM_LEFT = cellPositionFactory.getInstanceColRow(0, touchButtonLocationHelper.getTotalRows() - 1)
        this.BOTTOM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, touchButtonLocationHelper.getTotalRows() - 1)
        this.BOTTOM_SECOND_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 2, touchButtonLocationHelper.getTotalRows() - 1)
        this.SECOND_FROM_BOTTOM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, touchButtonLocationHelper.getTotalRows() - 2)
        this.SECOND_FROM_BOTTOM_SECOND_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 2, touchButtonLocationHelper.getTotalRows() - 2)
        this.BOTTOM_SECOND_FROM_LEFT = cellPositionFactory.getInstanceColRow(1, touchButtonLocationHelper.getTotalRows() - 1)
        this.SECOND_FROM_BOTTOM_LEFT = cellPositionFactory.getInstanceColRow(0, touchButtonLocationHelper.getTotalRows() - 2)
        this.SECOND_FROM_BOTTOM_SECOND_FROM_LEFT = cellPositionFactory.getInstanceColRow(1, touchButtonLocationHelper.getTotalRows() - 2)
        if (touchButtonLocationHelper.getTotalRows() > 2) {
            this.SECOND_FROM_TOP_LEFT = cellPositionFactory.getInstanceColRow(0, 1)
            this.SECOND_FROM_TOP_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, 1)
        } else {
            this.SECOND_FROM_TOP_LEFT = cellPositionFactory.NONE
            this.SECOND_FROM_TOP_RIGHT = cellPositionFactory.NONE
        }
        if (touchButtonLocationHelper.getTotalRows() >= 4) {
            this.THIRD_FROM_BOTTOM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, touchButtonLocationHelper.getTotalRows() - 3)
            this.FOURTH_FROM_BOTTOM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 1, touchButtonLocationHelper.getTotalRows() - 4)
            this.THIRD_FROM_BOTTOM_LEFT = cellPositionFactory.getInstanceColRow(0, touchButtonLocationHelper.getTotalRows() - 3)
        } else {
            this.THIRD_FROM_BOTTOM_RIGHT = cellPositionFactory.NONE
            this.FOURTH_FROM_BOTTOM_RIGHT = cellPositionFactory.NONE
            this.THIRD_FROM_BOTTOM_LEFT = cellPositionFactory.NONE
        }
        if (touchButtonLocationHelper.getTotalColumns() >= 4) {
            this.SECOND_FROM_BOTTOM_THIRD_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 3, touchButtonLocationHelper.getTotalRows() - 2)
            this.SECOND_FROM_BOTTOM_FOURTH_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 4, touchButtonLocationHelper.getTotalRows() - 2)
            this.BOTTOM_THIRD_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 3, touchButtonLocationHelper.getTotalRows() - 1)
            this.BOTTOM_FOURTH_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 4, touchButtonLocationHelper.getTotalRows() - 1)
            this.TOP_SECOND_FROM_LEFT = cellPositionFactory.getInstanceColRow(1, 0)
            this.TOP_SECOND_FROM_RIGHT = cellPositionFactory.getInstanceColRow(touchButtonLocationHelper.getTotalColumns() - 2, 0)
        } else {
            this.SECOND_FROM_BOTTOM_THIRD_FROM_RIGHT = cellPositionFactory.NONE
            this.SECOND_FROM_BOTTOM_FOURTH_FROM_RIGHT = cellPositionFactory.NONE
            this.BOTTOM_THIRD_FROM_RIGHT = cellPositionFactory.NONE
            this.BOTTOM_FOURTH_FROM_RIGHT = cellPositionFactory.NONE
            this.TOP_SECOND_FROM_LEFT = cellPositionFactory.NONE
            this.TOP_SECOND_FROM_RIGHT = cellPositionFactory.NONE
        }
    }

}


