/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class CaptureWorkerUtil() {
    import _root_.org.allbinary.input.automation.module.generic.CaptureWorkerUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

}

object CaptureWorkerUtil {
    def processProfileActionConditions(vector : BasicArrayList, frame : _root_.java.lang.Long) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(commonStrings.START, "CaptureWorkerUtil", "processProfileActionConditions")
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var profileActionConditionInterface : ProfileActionScriptConditionInterface = vector.get(index).asInstanceOf[ProfileActionScriptConditionInterface]
                if (profileActionConditionInterface.shouldProcess(frame)) {
                    //logUtil.putF("Should Process", this, "processProfileActionConditions");
                    profileActionConditionInterface.process(frame)
                } else {
                }
                index += 1
            }
        }
    }

}


