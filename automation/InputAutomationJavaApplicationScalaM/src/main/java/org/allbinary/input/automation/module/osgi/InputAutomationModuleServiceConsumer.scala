/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.osgi

import _root_.org.osgi.framework.BundleContext
import _root_.bundle.input.automation.module.InputAutomationModuleServiceInterface
import _root_.org.allbinary.osgi.service.InputAutomationServiceConsumer

class InputAutomationModuleServiceConsumer(param_bundleContext : BundleContext) extends InputAutomationServiceConsumer(classOf[InputAutomationModuleServiceInterface].getName(), param_bundleContext, new InputAutomationModuleOSGIServiceVisitor()) {

    //Constructor
    {
        val bundleContext : BundleContext = param_bundleContext
    }

}


