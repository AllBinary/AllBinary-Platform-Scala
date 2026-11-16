/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.util.BasicArrayList

class MotionGestureToMotionGestureActionAssociation(param_list : BasicArrayList, param_commandAction : CompleteMotionGestureInputEvent) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var list : BasicArrayList = null

    private var motionGestureAction : CompleteMotionGestureInputEvent = null

    //Constructor
    {
        val list : BasicArrayList = param_list
        val commandAction : CompleteMotionGestureInputEvent = param_commandAction
        this.list = list
        this.motionGestureAction = commandAction
    }

    def getMotionGesture() : BasicArrayList = {
        return this.list
    }

    def setMotionGestures(list : BasicArrayList) : Unit = {
        this.list = list
    }

    def getCommandAction() : CompleteMotionGestureInputEvent = {
        return this.motionGestureAction
    }

    def setMotionGestureAction(commandAction : CompleteMotionGestureInputEvent) : Unit = {
        this.motionGestureAction = commandAction
    }

    def isMotionGestureArrayEquals(aList : BasicArrayList) : Boolean = {
        var size : Int = aList.size()
        if (this.list.size() != size) {
            //this.logUtil.putF("List Is Not The Same Size", this, "isMotionGestureArrayEquals");
            return false
        }

        {
            var i : Int = size - 1
            while (i >= 0) {
                if (aList.objectArray(i) ne this.list.objectArray(i)) {
                    //this.logUtil.putF("List is different: aList: " + aList + " list: " + this.list, this, "isMotionGestureArrayEquals");
                    return false
                }
                i -= 1
            }
        }
        return true
    }

}


