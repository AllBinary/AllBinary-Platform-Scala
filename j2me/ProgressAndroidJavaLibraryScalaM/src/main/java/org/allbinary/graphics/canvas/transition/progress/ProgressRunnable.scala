/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.android.app.Activity
import _root_.org.allbinary.android.activity.MidletActivityBase
import _root_.org.allbinary.android.activity.SimpleProgressActivityInterface
import _root_.org.allbinary.thread.ARunnable

class ProgressRunnable(param_midletActivity : Activity, param_progressCanvas : ProgressCanvas) extends ARunnable {

    var midletActivity : SimpleProgressActivityInterface = null

    var progressCanvas : ProgressCanvas = null

    //Constructor
    {
        val midletActivity : Activity = param_midletActivity
        val progressCanvas : ProgressCanvas = param_progressCanvas
        val midletActivity2 : MidletActivityBase = midletActivity.asInstanceOf[MidletActivityBase]
        this.midletActivity = midletActivity2.asInstanceOf[SimpleProgressActivityInterface]
        this.progressCanvas = progressCanvas
    }

    override def run() : Unit = {
    }

}


