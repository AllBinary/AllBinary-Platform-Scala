/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.event

import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventListenerInterface
import _root_.org.allbinary.logic.util.event.handler.BasicEventHandler

class VirtualKeyboardEventHandler private() extends BasicEventHandler {
    import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler.{*}

    val SHOW_EVENT : VirtualKeyboardEvent = new VirtualKeyboardEvent(BooleanFactory.getInstance().TRUE)

    val HIDE_EVENT : VirtualKeyboardEvent = new VirtualKeyboardEvent(BooleanFactory.getInstance().FALSE)

    override def process(eventObject : AllBinaryEventObject, eventListenerInterface : EventListenerInterface) : Unit = {
        val virtualKeyboardEventListenerInterface : VirtualKeyboardEventListenerInterface = eventListenerInterface.asInstanceOf[VirtualKeyboardEventListenerInterface]
        virtualKeyboardEventListenerInterface.onVirtualKeyboardEvent(eventObject.asInstanceOf[VirtualKeyboardEvent])
    }

    def open() : Unit = {
        try {
            Thread.sleep(120)
            this.fireEvent(this.SHOW_EVENT)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "open", e)
            }
        }
    }

    def close() : Unit = {
        try {
            Thread.sleep(120)
            this.fireEvent(this.HIDE_EVENT)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CLOSE, e)
            }
        }
    }

}

object VirtualKeyboardEventHandler {
    private val gameKeyEventHandler : VirtualKeyboardEventHandler = new VirtualKeyboardEventHandler()

    def getInstance() : VirtualKeyboardEventHandler = {
        return VirtualKeyboardEventHandler.gameKeyEventHandler
    }

}


