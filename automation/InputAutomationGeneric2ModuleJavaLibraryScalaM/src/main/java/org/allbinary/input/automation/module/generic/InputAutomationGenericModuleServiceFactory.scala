/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.org.allbinary.input.automation.module.InputAutomationModuleFactoryInterface
import _root_.org.allbinary.input.automation.module.osgi.InputAutomationModuleServiceFactory
import _root_.org.allbinary.logic.communication.log.LogUtil

class InputAutomationGenericModuleServiceFactory() extends InputAutomationModuleServiceFactory {
    import _root_.org.allbinary.input.automation.module.generic.InputAutomationGenericModuleServiceFactory.{*}

    val logUtil_InputAutomationGenericModuleServiceFactory : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        try {
            var inputAutomationModuleInterfaceArray : Array[InputAutomationModuleFactoryInterface] = new Array[InputAutomationModuleFactoryInterface](1)
            inputAutomationModuleInterfaceArray(0) = new GenericModuleFactory()
            this.setInputAutomationModuleInterfaceArray(inputAutomationModuleInterfaceArray)
        } catch {
            case e : Exception => {
                this.logUtil_InputAutomationGenericModuleServiceFactory.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

}

object InputAutomationGenericModuleServiceFactory {
    private var inputAutomationGenericModuleServiceFactory : InputAutomationGenericModuleServiceFactory = new InputAutomationGenericModuleServiceFactory()

    def getInstance() : InputAutomationGenericModuleServiceFactory = {
        return InputAutomationGenericModuleServiceFactory.inputAutomationGenericModuleServiceFactory
    }

}


