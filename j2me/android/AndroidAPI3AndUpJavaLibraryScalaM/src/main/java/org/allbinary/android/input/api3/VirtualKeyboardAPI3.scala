/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.api3

import _root_.android.app.Activity
import _root_.org.allbinary.android.input.VirtualKeyboard
import _root_.org.allbinary.input.event.VirtualKeyboardEvent
import _root_.org.allbinary.input.event.VirtualKeyboardEventHandler
import _root_.org.allbinary.input.event.VirtualKeyboardEventListenerInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings

class VirtualKeyboardAPI3(param_activity : Activity) extends VirtualKeyboard() with VirtualKeyboardEventListenerInterface {
    import _root_.org.allbinary.android.input.api3.VirtualKeyboardAPI3.{*}

    private var virtualKeyboard : Boolean = false

    private var activity : Activity = null

    private var showVirtualKeyboardRunnable : Runnable = null

    private var hideVirtualKeyboardRunnable : Runnable = null

    //Constructor
    {
        val activity : Activity = param_activity
        this.activity = activity
        this.showVirtualKeyboardRunnable = new ShowVirtualKeyboardRunnable(this.activity)
        this.hideVirtualKeyboardRunnable = new HideVirtualKeyboardRunnable(this.activity)
        val virtualKeyboardEventHandler : VirtualKeyboardEventHandler = VirtualKeyboardEventHandler.getInstance()
        virtualKeyboardEventHandler.removeAllListeners()
        virtualKeyboardEventHandler.addListenerInterface(this)
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onVirtualKeyboardEvent(virtualKeyboardEvent : VirtualKeyboardEvent) : Unit = {
        val isShow : _root_.java.lang.Boolean = virtualKeyboardEvent.getSource().asInstanceOf[_root_.java.lang.Boolean]
        if (isShow.booleanValue()) {
            this.showVirtualKeyboard()
        } else {
            this.hideVirtualKeyboard()
        }
    }

    override def forceHide() : Unit = {
        this.hideVirtualKeyboard()
    }

    override def hide() : Unit = {
        if (this.virtualKeyboard) {
            this.forceHide()
        }
    }

    private def showVirtualKeyboard() : Unit = {
        this.activity.runOnUiThread(this.showVirtualKeyboardRunnable)
        this.virtualKeyboard = true
    }

    private def hideVirtualKeyboard() : Unit = {
        this.activity.runOnUiThread(this.hideVirtualKeyboardRunnable)
        this.virtualKeyboard = false
    }

}

object VirtualKeyboardAPI3 {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    var MAX_API : Int = Integer.MAX_VALUE

    var MIN_API : Int = 3

}


