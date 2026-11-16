/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.gesture.observer

import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class BasicMotionGesturesHandler() extends BasicEventHandler {
    import _root_.org.allbinary.input.motion.gesture.observer.BasicMotionGesturesHandler.{*}

    /*     public void addListener(PlayerGameInput playerGameInput)     {         if(!list.contains(playerGameInput))         {             list.add(playerGameInput);         }     }      public void removeAllListeners()     {         this.list.clear();         super.removeAllListeners();     }      public void removeListener(EventListenerInterface eventListenerInterface)     {         this.list.remove(eventListenerInterface);         super.removeListener(eventListenerInterface);     }      public void fireEvent(AllBinaryEventObject eventObject) throws Exception     {                 for (int index = this.list.size(); --index >= 0;)         {             try             {                 PlayerGameInput playerGameInput = (PlayerGameInput) this.list.get(index);                 playerGameInput.onMotionGestureEvent((MotionGestureEvent) eventObject);             }             catch (Exception e)             {                 this.logUtil.put(this.commonStrings.EXCEPTION, this, EventStrings.getInstance().FIRE_EVENT, e);             }         }          super.fireEvent(eventObject);     }     */
    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val baseMotionGestureEventListener : BaseMotionGestureEventListener = eventListenerInterface.asInstanceOf[BaseMotionGestureEventListener]
        baseMotionGestureEventListener.onMotionGestureEvent(eventObject.asInstanceOf[MotionGestureEvent])
    }

}

object BasicMotionGesturesHandler {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val SINGLETON : BasicMotionGesturesHandler = new BasicMotionGesturesHandler()

    def getInstance() : BasicMotionGesturesHandler = {
        return BasicMotionGesturesHandler.SINGLETON
    }

}


