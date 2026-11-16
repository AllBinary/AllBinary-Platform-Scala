/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.game.input.CompleteMotionGestureInputEventHandler
import _root_.org.allbinary.game.input.motion.action.GameKeyCompleteMotionGestureInputEvent
import _root_.org.allbinary.game.input.motion.action.GameKeyFromMotionGestureEventListener
import _root_.org.allbinary.input.motion.gesture.MotionGestureToMotionGestureActionAssociation
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfiguration
import _root_.org.allbinary.input.motion.gesture.configuration.MotionGestureConfigurationFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class ResolveCompleteMotionGestureListener() extends CompleteMotionGestureListenerInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF("MotionGesture to CompleteMotionGesture Reciever", this, commonStrings.CONSTRUCTOR)
        CompleteMotionGestureInputEventHandler.getInstance().addListener(new GameKeyFromMotionGestureEventListener())
    }

    override def onMotionGestureCompleted(list : BasicArrayList) : Unit = {
        //PreLogUtil.put("Gesture Completed: " + list.toString(), this, "mouseGestureCompleted");
        var configuration : MotionGestureConfiguration = MotionGestureConfigurationFactory.getInstance()
        var commandActionsList : BasicArrayList = configuration.getAssociateCommandActionsList()
        var size : Int = commandActionsList.size()
        //this.logUtil.putF("commandActionsList.size(): " + size, this, "mouseGestureCompleted");

        {
            var index : Int = size - 1
            scala.util.boundary { (break_N68964 : scala.util.boundary.Label[Unit]) ?=>
                while (index >= 0) {
                    var association : MotionGestureToMotionGestureActionAssociation = commandActionsList.objectArray(index).asInstanceOf[MotionGestureToMotionGestureActionAssociation]
                    if (association.isMotionGestureArrayEquals(list) == true) {
                        var completeMotionGestureInputEvent : GameKeyCompleteMotionGestureInputEvent = association.getCommandAction().asInstanceOf[GameKeyCompleteMotionGestureInputEvent]
                        //this.logUtil.putF("Gesture Completed: " +  completeMotionGestureInputEvent.getMotionGestureInput().getName(), //      this, "mouseGestureCompleted");
                        CompleteMotionGestureInputEventHandler.getInstance().fireEvent(completeMotionGestureInputEvent)
                        scala.util.boundary.break()(using break_N68964)
                    }
                    index -= 1
                }
            }
        }
    }

}


