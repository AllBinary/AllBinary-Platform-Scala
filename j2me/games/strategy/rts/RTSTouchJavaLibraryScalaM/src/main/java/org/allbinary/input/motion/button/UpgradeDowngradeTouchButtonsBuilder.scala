/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.resource.TouchButtonDowngradeResource
import _root_.org.allbinary.game.input.resource.TouchButtonUpgradeResource
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.graphics.CellPositionFactory

class UpgradeDowngradeTouchButtonsBuilder extends BaseTouchInput {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def getList() : BasicArrayList = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
            val list : BasicArrayList = new BasicArrayListD()
            val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
            val cellPositionFactory : CellPositionFactory = CellPositionFactory.getInstance()
            val basicTouchButtonCellPositionFactory : BasicTouchButtonCellPositionFactory = new BasicTouchButtonCellPositionFactory()
            if ((basicTouchButtonCellPositionFactory.SECOND_FROM_TOP_LEFT ne cellPositionFactory.NONE) && (basicTouchButtonCellPositionFactory.SECOND_FROM_TOP_RIGHT ne cellPositionFactory.NONE)) {
                var commonButtons : CommonButtons = CommonButtons.getInstance()
                // Upgrade Button
                var UP : TouchButton = TouchButton.createButton(BasicTouchInputFactory.getInstance().SPECIAL_BUTTON_TWO, TouchButtonUpgradeResource.getInstance(), commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.SECOND_FROM_TOP_LEFT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
                // Downgrade Button
                var DOWN : TouchButton = TouchButton.createButton(BasicTouchInputFactory.getInstance().SPECIAL_BUTTON_ONE, TouchButtonDowngradeResource.getInstance(), commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.SECOND_FROM_TOP_RIGHT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
                list.add(UP)
                list.add(DOWN)
            }
            return list
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
                return BasicArrayListUtil.getInstance().getImmutableInstance()
            }
        }
        throw new IllegalStateException()
    }

}


