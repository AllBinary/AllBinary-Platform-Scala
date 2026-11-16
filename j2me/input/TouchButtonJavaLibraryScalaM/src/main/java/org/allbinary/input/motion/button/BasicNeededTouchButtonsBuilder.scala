/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class BasicNeededTouchButtonsBuilder extends BaseTouchInput {

    val logUtil : LogUtil = LogUtil.getInstance()

    override def getList() : BasicArrayList = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
            val list : BasicArrayList = new BasicArrayListD()
            val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
            val basicTouchButtonCellPositionFactory : BasicTouchButtonCellPositionFactory = new BasicTouchButtonCellPositionFactory()
            val commonButtons : CommonButtons = CommonButtons.getInstance()
            val animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)
            var UP : TouchButton = new TouchButton(BasicTouchInputFactory.getInstance().UP, animationInterface, animationInterface, commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.SECOND_FROM_BOTTOM_LEFT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            var DOWN : TouchButton = new TouchButton(BasicTouchInputFactory.getInstance().DOWN, animationInterface, animationInterface, commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.BOTTOM_LEFT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            var LEFT : TouchButton = new TouchButton(BasicTouchInputFactory.getInstance().LEFT, animationInterface, animationInterface, commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.BOTTOM_SECOND_FROM_RIGHT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            var RIGHT : TouchButton = new TouchButton(BasicTouchInputFactory.getInstance().RIGHT, animationInterface, animationInterface, commonButtons.NORMAL_BUTTON, basicTouchButtonCellPositionFactory.BOTTOM_RIGHT, touchButtonLocationHelper.getColumnsRemainderHalf(), touchButtonLocationHelper.getRowsRemainderHalf())
            list.add(UP)
            list.add(DOWN)
            list.add(LEFT)
            list.add(RIGHT)
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


