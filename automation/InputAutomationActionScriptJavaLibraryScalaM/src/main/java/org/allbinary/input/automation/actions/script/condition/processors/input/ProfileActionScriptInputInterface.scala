/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.org.allbinary.input.automation.actions.script.condition.processors.ProfileActionScriptProcessorInterface
import _root_.org.allbinary.input.automation.robot.InputRobotInterface

trait ProfileActionScriptInputInterface extends ProfileActionScriptProcessorInterface {

    def setInputRobotInterface(inputRobotInterface : InputRobotInterface) : Unit

    def getInputRobotInterface() : InputRobotInterface

    def getTime() : Int

    def setTime(time : Int) : Unit

}


