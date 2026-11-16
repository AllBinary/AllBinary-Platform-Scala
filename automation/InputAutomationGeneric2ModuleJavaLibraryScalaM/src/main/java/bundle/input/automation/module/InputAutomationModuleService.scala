/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation.module

import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface

class InputAutomationModuleService(param_inputAutomationModuleInterfaceArray : Array[InputAutomationModuleFactoryInterface]) extends InputAutomationModuleServiceInterface {

    private var inputAutomationModuleInterfaceArray : Array[InputAutomationModuleFactoryInterface] = null

    //Constructor
    {
        val inputAutomationModuleInterfaceArray : Array[InputAutomationModuleFactoryInterface] = param_inputAutomationModuleInterfaceArray
        this.setInputAutomationModuleInterfaceArray(inputAutomationModuleInterfaceArray)
    }

    def getInputAutomationModuleInterfaceArray() : Array[InputAutomationModuleFactoryInterface] = {
        return this.inputAutomationModuleInterfaceArray
    }

    def setInputAutomationModuleInterfaceArray(inputAutomationModuleInterfaceArray : Array[InputAutomationModuleFactoryInterface]) : Unit = {
        this.inputAutomationModuleInterfaceArray = inputAutomationModuleInterfaceArray
    }

}


