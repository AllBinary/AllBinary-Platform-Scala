/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.time.TimeDelayHelper

class KeyboardInputAutomationProcessor private() {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyboardInputAutomationProcessor.{*}

}

object KeyboardInputAutomationProcessor {
    def process(keyActionScriptInputInterface : KeyboardActionScriptInputInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(CommonLabels.getInstance().START + keyActionScriptInputInterface.toString(), "KeyInputAutomationProcessor", commonStrings.PROCESS)
        var inputRobotInterface : InputRobotInterface = keyActionScriptInputInterface.getInputRobotInterface()
        var integer : Array[Integer] = keyActionScriptInputInterface.getKeyArray()
        //Simultaneious
        if (keyActionScriptInputInterface.getDelayBetweenKeys() == 0) {

            {
                var index : Int = 0
                while (index < keyActionScriptInputInterface.getKeyArray().length) {
                    if (keyActionScriptInputInterface.isPress()) {
                        inputRobotInterface.keyPress(integer(index))
                    }
                    index += 1
                }
            }
            Thread.sleep(keyActionScriptInputInterface.getTime())

            {
                var index : Int = keyActionScriptInputInterface.getKeyArray().length - 1
                while (index >= 0) {
                    if (keyActionScriptInputInterface.isRelease()) {
                        inputRobotInterface.keyRelease(integer(index))
                    }
                    index -= 1
                }
            }
        } else {

            {
                var index : Int = 0
                while (index < keyActionScriptInputInterface.getKeyArray().length) {
                    if (keyActionScriptInputInterface.isPress()) {
                        inputRobotInterface.keyPress(integer(index))
                    }
                    Thread.sleep(keyActionScriptInputInterface.getTime())
                    if (keyActionScriptInputInterface.isRelease()) {
                        inputRobotInterface.keyRelease(integer(index))
                    }
                    var timeHelper : TimeDelayHelper = new TimeDelayHelper(keyActionScriptInputInterface.getDelayBetweenKeys())
                    var toLong : Int = 0

                    {
                        while (!timeHelper.isTimeTNT() || (toLong > 6000)) {
                            toLong += 1
                            Thread.sleep(50)
                        }
                    }
                    index += 1
                }
            }
        }
    }

}


