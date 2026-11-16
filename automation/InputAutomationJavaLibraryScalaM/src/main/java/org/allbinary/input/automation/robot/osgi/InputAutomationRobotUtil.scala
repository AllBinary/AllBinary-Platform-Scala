/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot.osgi

import _root_.org.allbinary.input.automation.robot.InputRobotInterface

class InputAutomationRobotUtil private() {
    import _root_.org.allbinary.input.automation.robot.osgi.InputAutomationRobotUtil.{*}

}

object InputAutomationRobotUtil {
    def getChangeEvent(inputRobotInterface : InputRobotInterface) : InputAutomationRobotChangeEvent = {
        var inputAutomationRobotInterfaceWrapper : InputAutomationRobotInterfaceWrapper = new InputAutomationRobotInterfaceWrapper(inputRobotInterface)
        var inputAutomationRobotChangeEvent : InputAutomationRobotChangeEvent = new InputAutomationRobotChangeEvent(inputAutomationRobotInterfaceWrapper)
        return inputAutomationRobotChangeEvent
    }

}


