/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.game.test

import _root_.javax.swing.*
import _root_.org.allbinary.input.automation.module.AbstractInputAutomationFactory
import _root_.org.allbinary.input.automation.module.InputAutomationModuleData
import _root_.org.allbinary.input.automation.module.configuration.BlankModuleConfigurationJPanel
import _root_.org.allbinary.thread.RunnableInterface

class TestModuleFactory() extends AbstractInputAutomationFactory(_root_.org.allbinary.input.automation.module.game.test.TestModuleFactory.NAME, new BlankModuleConfigurationJPanel()) {
    import _root_.org.allbinary.input.automation.module.game.test.TestModuleFactory.{*}

    private var blankModuleConfigurationJPanel : BlankModuleConfigurationJPanel = null

    override def getName() : String = {
        return TestModuleFactory.NAME
    }

    override def getConfigurationJPanel() : JPanel = {
        return this.blankModuleConfigurationJPanel
    }

    override def getInstance() : RunnableInterface = this.synchronized {
        return null
    }

}

object TestModuleFactory {
    //implements InputAutomationModuleFactoryInterface
    private var NAME : String = "Test New Game" + InputAutomationModuleData.MODULE_NAME_END

}


