/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.configuration

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEvent
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.input.motion.gesture.MotionGestureToMotionGestureActionAssociation
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class MotionGestureConfiguration() {

    //    public static final CompleteMotionGestureInputEvent NULL_COMPLETE_MOTION_GESTURE_INPUT_EVENT = new CompleteMotionGestureInputEvent(StringUtil.getInstance().EMPTY_STRING, TouchMotionGestureFactory.getInstance().NO_MOTION);
    private var diagonalMotionGestureAllowed : Boolean = true

    private var diagonalTolerance : Int = 7

    private var minimumMotionGesture : Int = 9

    private var button : String = StringUtil.getInstance().EMPTY_STRING

    private var color : BasicColor = BasicColorFactory.getInstance().BLUE

    private var executingActions : Boolean = true

    private var mouseButtonMask : Int = 0

    private var activeCommands : BasicArrayList = new BasicArrayListD()

    //    }
    def addMotionGestureAction(list : BasicArrayList, commandAction : CompleteMotionGestureInputEvent) : Unit = {
        this.activeCommands.add(new MotionGestureToMotionGestureActionAssociation(list, commandAction))
    }

    def clearMotionGestureAction() : Unit = {
        this.activeCommands.clear()
    }

    /*     public void setGestureActionAssociation(int index, BasicArrayList list, BaseInputActionProcessor commandAction) {         activeCommands.set(index, new MotionGestureToMotionGestureActionAssociation(list, commandAction));     }     */
    def getAssociateCommandActionsList() : BasicArrayList = {
        return this.activeCommands
    }

    def isDiagonalMotionGestureAllowed() : Boolean = {
        return this.diagonalMotionGestureAllowed
    }

    def isExecutingActionsAllowed() : Boolean = {
        return this.executingActions
    }

    def setExecutingActionsAllowed(executingActionAllowed : Boolean) : Unit = {
        this.executingActions = executingActionAllowed
    }

    def setDiagonalMotionGestureAllowed(diagonalMotionGestureAllowed : Boolean) : Unit = {
        this.diagonalMotionGestureAllowed = diagonalMotionGestureAllowed
    }

    def getDiagonalTolerance() : Int = {
        return this.diagonalTolerance
    }

    def setDiagonalTolerance(diagonalTolerance : Int) : Unit = {
        this.diagonalTolerance = diagonalTolerance
    }

    def getMinimumMotionGesture() : Int = {
        return this.minimumMotionGesture
    }

    def setMinimumMotionGesture(minimumMotionGesture : Int) : Unit = {
        this.minimumMotionGesture = minimumMotionGesture
    }

    def getButton() : String = {
        return this.button
    }

    def setButton(button : String) : Unit = {
        this.button = button
    }

    def getColor() : BasicColor = {
        return this.color
    }

    def setColor(color : BasicColor) : Unit = {
        this.color = color
    }

    def getMouseButtonMask() : Int = {
        return this.mouseButtonMask
    }

    def setMouseButtonMask(mouseButtonMask : Int) : Unit = {
        this.mouseButtonMask = mouseButtonMask
    }

}


