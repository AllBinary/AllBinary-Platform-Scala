/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.configuration

import _root_.java.io.File
import _root_.java.io.FileInputStream
import _root_.java.util.List
import _root_.javax.xml.bind.JAXBContext
import _root_.javax.xml.bind.JAXBElement
import _root_.javax.xml.bind.Unmarshaller
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class InputAutomationConfigurationFactory private() {
    import _root_.org.allbinary.input.automation.configuration.InputAutomationConfigurationFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    var inputAutomationConfiguration : InputAutomationConfiguration = null

    def init(abeClientInformation : AbeClientInformationInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val INPUT_AUTOMATION_CONFIGURATION : String = "InputAutomationConfiguration"
        val file : File = InputAutomationConfiguration.getFile()
        if (file.isFile()) {
            logUtil.putF("LoadingConfiguration", INPUT_AUTOMATION_CONFIGURATION, commonStrings.INIT)
            val jaxbContext : JAXBContext = JAXBContext.newInstance(classOf[InputAutomationConfiguration])
            val unmarshaller : Unmarshaller = jaxbContext.createUnmarshaller()
            val root : JAXBElement[InputAutomationConfiguration] = unmarshaller.unmarshal(new StreamSource(new FileInputStream(file)), classOf[InputAutomationConfiguration])
            this.inputAutomationConfiguration = root.getValue().asInstanceOf[InputAutomationConfiguration]
            val inputAutomationModuleConfigurationList : List[InputAutomationModuleConfiguration] = this.inputAutomationConfiguration.getInputAutomationModuleConfigurationList()
            logUtil.putF((("isInstalled: " + this.inputAutomationConfiguration.isInstalled()) + " inputAutomationModuleConfigurationList: ") + inputAutomationModuleConfigurationList, INPUT_AUTOMATION_CONFIGURATION, commonStrings.INIT)
            if (inputAutomationModuleConfigurationList != null) {
                val size : Int = inputAutomationModuleConfigurationList.size()
                var inputAutomationModuleConfiguration : InputAutomationModuleConfiguration = null

                {
                    var index : Int = 0
                    while (index < size) {
                        inputAutomationModuleConfiguration = inputAutomationModuleConfigurationList.get(index)
                        inputAutomationModuleConfiguration.init(abeClientInformation)
                        index += 1
                    }
                }
            }
            logUtil.putF("LoadedConfiguration", INPUT_AUTOMATION_CONFIGURATION, commonStrings.INIT)
        } else {
            logUtil.putF("New Configuration", INPUT_AUTOMATION_CONFIGURATION, commonStrings.INIT)
            this.inputAutomationConfiguration = new InputAutomationConfiguration()
        }
    }

}

object InputAutomationConfigurationFactory {
    private val instance : InputAutomationConfigurationFactory = new InputAutomationConfigurationFactory()

    def getInstance() : InputAutomationConfigurationFactory = {
        return InputAutomationConfigurationFactory.instance
    }

}


