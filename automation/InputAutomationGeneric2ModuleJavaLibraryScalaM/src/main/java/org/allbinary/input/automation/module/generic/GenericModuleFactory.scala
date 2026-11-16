/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic

import _root_.org.allbinary.input.automation.module.AbstractInputAutomationFactory
import _root_.org.allbinary.input.automation.module.InputAutomationActionInterface
import _root_.org.allbinary.input.automation.module.InputAutomationModuleData
import _root_.org.allbinary.input.automation.module.generic.configuration.GenericModuleConfigurationJPanel
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfile
import _root_.org.allbinary.input.automation.module.generic.constraints.NoImageComparatorConstraints
import _root_.org.allbinary.input.automation.module.generic.constraints.NoMotionRectangleConstraints
import _root_.org.allbinary.thread.RunnableInterface

class GenericModuleFactory() extends AbstractInputAutomationFactory(_root_.org.allbinary.input.automation.module.generic.GenericModuleFactory.NAME, new GenericModuleConfigurationJPanel()) {
    import _root_.org.allbinary.input.automation.module.generic.GenericModuleFactory.{*}

    override def getInstance() : RunnableInterface = this.synchronized {
        var genericProfile : GenericProfile = (this.getConfigurationJPanel().asInstanceOf[GenericModuleConfigurationJPanel]).getSelectedGenericProfile()
        var inputAutomationActionInterface : InputAutomationActionInterface = (new GenericInputAutomationAction()).asInstanceOf[InputAutomationActionInterface]
        return (new GenericInputAutomationWorker(inputAutomationActionInterface, genericProfile, new NoMotionRectangleConstraints(), new NoImageComparatorConstraints())).asInstanceOf[RunnableInterface]
    }

}

object GenericModuleFactory {
    //implements InputAutomationModuleFactoryInterface
    private var NAME : String = "Generic" + InputAutomationModuleData.MODULE_NAME_END

}


