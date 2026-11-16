/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.configuration

import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration

class InputAutomationConfigurationModuleChangeEvent(param_inputAutomationModuleConfiguration : InputAutomationModuleConfiguration) {

    private var inputAutomationModuleConfiguration : InputAutomationModuleConfiguration = null

    //Constructor
    {
        val inputAutomationModuleConfiguration : InputAutomationModuleConfiguration = param_inputAutomationModuleConfiguration
        this.setInputAutomationModuleConfiguration(inputAutomationModuleConfiguration)
    }

    def getInputAutomationModuleConfiguration() : InputAutomationModuleConfiguration = {
        return this.inputAutomationModuleConfiguration
    }

    private def setInputAutomationModuleConfiguration(inputAutomationModuleConfiguration : InputAutomationModuleConfiguration) : Unit = {
        this.inputAutomationModuleConfiguration = inputAutomationModuleConfiguration
    }

}


