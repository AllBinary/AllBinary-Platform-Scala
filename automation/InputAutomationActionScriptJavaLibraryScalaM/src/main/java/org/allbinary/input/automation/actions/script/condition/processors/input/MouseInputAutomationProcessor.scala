/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.org.allbinary.input.automation.robot.InputRobotInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class MouseInputAutomationProcessor private() {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.MouseInputAutomationProcessor.{*}

}

object MouseInputAutomationProcessor {
    def process(mouseActionScriptInputInterface : MouseActionScriptInputInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        logUtil.putF(new StringMaker().append("Start - Processing Mouse Input at: ").append(mouseActionScriptInputInterface.getPoint().toString()).append(" clicks: ").appendint(mouseActionScriptInputInterface.getButtonClicks()).toString(), "MouseInputAutomationProcessor", commonStrings.PROCESS)
        var inputRobotInterface : InputRobotInterface = mouseActionScriptInputInterface.getInputRobotInterface()
        if ((mouseActionScriptInputInterface.getPoint().x != -1) && (mouseActionScriptInputInterface.getPoint().y != -1)) {
            inputRobotInterface.mouseMove(mouseActionScriptInputInterface.getPoint())
        }
        Thread.sleep(mouseActionScriptInputInterface.getTime())
        if (mouseActionScriptInputInterface.getButtonClicks() != 0) {
            inputRobotInterface.mousePress(mouseActionScriptInputInterface.getButtonClicks())
            Thread.sleep(mouseActionScriptInputInterface.getTime())
            inputRobotInterface.mouseRelease(mouseActionScriptInputInterface.getButtonClicks())
        }
        Thread.sleep(mouseActionScriptInputInterface.getTime())
    }

}


