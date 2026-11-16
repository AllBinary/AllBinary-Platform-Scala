/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package bundle.input.automation.module.generic

import _root_.org.allbinary.input.automation.module.generic.InputAutomationGenericModuleServiceFactory
import _root_.org.allbinary.input.automation.module.osgi.InputAutomationModuleBundleActivator

class InputAutomationGenericModuleBundleActivator() extends InputAutomationModuleBundleActivator {

    override def init() : Unit = {
        var inputAutomationGenericModuleServiceFactory : InputAutomationGenericModuleServiceFactory = InputAutomationGenericModuleServiceFactory.getInstance()
        this.setInputAutomationModuleInterface(inputAutomationGenericModuleServiceFactory.getInputAutomationModuleInterfaceArray())
        this.setServiceFactory(inputAutomationGenericModuleServiceFactory)
    }

}


