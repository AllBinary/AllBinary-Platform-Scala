/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.canvas.transition.progress

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.android.app.Activity

class TitleProgressBarSetProgressRunnable(param_midletActivity : Activity, param_progressCanvas : ProgressCanvas) extends ProgressRunnable(param_midletActivity, param_progressCanvas) {

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val midletActivity : Activity = param_midletActivity
        val progressCanvas : ProgressCanvas = param_progressCanvas
    }

    override def run() : Unit = {
        try {
            this.midletActivity.onSetProgress(this.progressCanvas.getValue().toInt, this.progressCanvas.getText())
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.RUN, e)
            }
        }
    }

}


