/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.input.api3

import _root_.android.app.Activity
import _root_.android.content.Context
import _root_.android.view.View
import _root_.android.view.inputmethod.InputMethodManager
import _root_.org.allbinary.android.activity.ViewCompositeInterface
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ShowVirtualKeyboardRunnable(param_activity : Activity) extends Runnable {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var activity : Activity = null

    //private int index = 3;
    //Constructor
    {
        val activity : Activity = param_activity
        this.activity = activity
    }

    override def run() : Unit = {
        try {
            val inputMethodManager : InputMethodManager = this.activity.getSystemService(Context.INPUT_METHOD_SERVICE).asInstanceOf[InputMethodManager]
            val viewCompositeInterface : ViewCompositeInterface = this.activity.asInstanceOf[ViewCompositeInterface]
            if (viewCompositeInterface == null) {
                ForcedLogUtil.log("Activity Null", this)
            }
            val view : View = viewCompositeInterface.getView()
            /*             if (index == 3) {                  inputMethodManager.showSoftInput(                         view, InputMethodManager.SHOW_IMPLICIT);                 index++;             } else if (index == 4) {                  inputMethodManager.showSoftInput(                         this.activity.getWindow().getDecorView(), InputMethodManager.SHOW_IMPLICIT);                 index++;             } else if (index == 5) {                 index = 0;             }           */
            inputMethodManager.toggleSoftInputFromWindow(view.getWindowToken(), InputMethodManager.SHOW_FORCED, 0)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


