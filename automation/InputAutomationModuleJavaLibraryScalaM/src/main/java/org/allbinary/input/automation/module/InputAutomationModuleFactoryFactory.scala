/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.java.util.Collection
import _root_.java.util.HashMap
import _root_.java.util.Iterator
import _root_.javax.help.HelpSet
import _root_.javax.help.event.HelpSetEvent
import _root_.javax.help.event.HelpSetListener
import _root_.javax.swing.ListModel
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfiguration
import _root_.org.allbinary.input.automation.module.configuration.InputAutomationModuleConfigurations
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.help.JavaHelpSetNotifier
import _root_.org.allbinary.string.CommonStrings

class InputAutomationModuleFactoryFactory(param_inputAutomationModuleConfigurations : InputAutomationModuleConfigurations, param_helpSetListenerInterface : HelpSetListener) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashMap : HashMap[Object, Object] = null

    private var defaultListModelHelper : DefaultListModelHelper = null

    private var helpSetListenerInterface : HelpSetListener = null

    //Constructor
    {
        val inputAutomationModuleConfigurations : InputAutomationModuleConfigurations = param_inputAutomationModuleConfigurations
        val helpSetListenerInterface : HelpSetListener = param_helpSetListenerInterface
        this.helpSetListenerInterface = helpSetListenerInterface
        this.defaultListModelHelper = new DefaultListModelHelper()
        this.hashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val collection : Collection[Object] = inputAutomationModuleConfigurations.getHashMap().values().asInstanceOf[Collection[Object]]
        val iterator : Iterator[? <: Object] = collection.iterator().asInstanceOf[Iterator[? <: Object]]
        var inputAutomationModuleConfiguration : InputAutomationModuleConfiguration = null

        {
            while (iterator.hasNext()) {
                inputAutomationModuleConfiguration = iterator.next().asInstanceOf[InputAutomationModuleConfiguration]
                this.add(inputAutomationModuleConfiguration)
            }
        }
        this.defaultListModelHelper.initDefaultModelList()
        this.logUtil.putF(((("Loaded " + this.hashMap.size()) + "/") + this.defaultListModelHelper.getListModel().getSize()) + " Input Automation Modules", this, "Contructor")
    }

    private def add(inputAutomationModuleConfiguration : InputAutomationModuleConfiguration) : Unit = {
        val inputAutomationModuleInterface : InputAutomationModuleFactoryInterface = inputAutomationModuleConfiguration.getInputAutomationModuleInterface()
        this.hashMap.put(inputAutomationModuleConfiguration.getName(), inputAutomationModuleInterface)
        this.defaultListModelHelper.add(inputAutomationModuleConfiguration.getName())
        val helpSet : HelpSet = inputAutomationModuleInterface.getHelpSet()
        if (!JavaHelpSetNotifier.isNotified(helpSet)) {
            val helpSetEvent : HelpSetEvent = new HelpSetEvent(this, helpSet, HelpSetEvent.HELPSET_ADDED)
            this.helpSetListenerInterface.helpSetAdded(helpSetEvent)
        }
    }

    def getListModel() : ListModel[Object] = {
        return this.defaultListModelHelper.getListModel().asInstanceOf[ListModel[Object]]
    }

    def getInstance(moduleName : String) : InputAutomationModuleFactoryInterface = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF("Getting Module: " + moduleName, this, commonStrings.GET_INSTANCE)
        val inputAutomationModuleFactoryInterface : InputAutomationModuleFactoryInterface = this.hashMap.get(moduleName).asInstanceOf[InputAutomationModuleFactoryInterface]
        if (inputAutomationModuleFactoryInterface == null) {
            this.logUtil.putF(("Module: " + moduleName) + " was null", this, commonStrings.GET_INSTANCE)
        }
        return inputAutomationModuleFactoryInterface
    }

}


