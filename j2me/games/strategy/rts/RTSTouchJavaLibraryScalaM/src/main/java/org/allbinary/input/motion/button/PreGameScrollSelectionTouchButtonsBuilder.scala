/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class PreGameScrollSelectionTouchButtonsBuilder extends BaseTouchInput {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def getList() : BasicArrayList = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.GET_LIST)
            val list : BasicArrayList = new BasicArrayListD()
            val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
            //PreLogUtil.put(touchButtonLocationHelper.toString(), this, this.commonStrings.GET_LIST);
            val commonButtons : CommonButtons = CommonButtons.getInstance()
            val basicTouchButtonCellPositionFactory : BasicTouchButtonCellPositionFactory = new BasicTouchButtonCellPositionFactory()
            //Scroll Left Button
            var LEFT : TouchButton = TouchButton.createButton(BasicTouchInputFactory.getInstance().LEFT, TouchButtonStrafeLeftResource.getInstance(), commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.TOP_LEFT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            //Scroll Right Button
            var RIGHT : TouchButton = TouchButton.createButton(BasicTouchInputFactory.getInstance().RIGHT, TouchButtonStrafeRightResource.getInstance(), commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.TOP_RIGHT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            var START : TouchButton = TouchButton.createButton(BasicTouchInputFactory.getInstance().SPECIAL_BUTTON_FIVE, TouchButtonStartResource.getInstance(), commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.BOTTOM_RIGHT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            list.add(LEFT)
            list.add(RIGHT)
            list.add(START)
            return list
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.GET_LIST, e)
                return BasicArrayListUtil.getInstance().getImmutableInstance()
            }
        }
        throw new IllegalStateException()
    }

}


