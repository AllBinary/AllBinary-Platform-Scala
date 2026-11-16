/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation.robot

import _root_.org.allbinary.input.automation.robot.InputRobotInterface

class InputAutomationRobotService(param_inputRobotInterfaceArray : Array[InputRobotInterface]) extends InputAutomationRobotServiceInterface {

    private var inputRobotInterfaceArray : Array[InputRobotInterface] = null

    //Constructor
    {
        val inputRobotInterfaceArray : Array[InputRobotInterface] = param_inputRobotInterfaceArray
        this.setInputRobotInterfaceArray(inputRobotInterfaceArray)
    }

    def getInputRobotInterfaceArray() : Array[InputRobotInterface] = {
        return this.inputRobotInterfaceArray
    }

    def setInputRobotInterfaceArray(inputRobotInterfaceArray : Array[InputRobotInterface]) : Unit = {
        this.inputRobotInterfaceArray = inputRobotInterfaceArray
    }

}


