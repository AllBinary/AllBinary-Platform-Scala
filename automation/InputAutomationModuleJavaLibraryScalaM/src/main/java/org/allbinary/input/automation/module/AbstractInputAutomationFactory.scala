/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.java.net.URL
import _root_.javax.help.HelpSet
import _root_.javax.swing.*
import _root_.org.allbinary.logic.java.help.JavaHelpUtil

class AbstractInputAutomationFactory private () extends InputAutomationModuleFactoryInterface {

    private var name : String = null

    private var jPanel : JPanel = null

    private var helpSet : HelpSet = null

    def this(name : String, jPanel : JPanel, helpSet : HelpSet) = {
        this()
        this.name = name
        this.jPanel = jPanel
        this.helpSet = helpSet
    }

    def this(name : String, jPanel : JPanel) = {
        this()
        this.name = name
        this.jPanel = jPanel
        var url : URL = this.getClass().getResource("/help/Help.hs")
        this.helpSet = JavaHelpUtil.getInstance().getHelpSet(url)
    }

    override def getName() : String = {
        return this.name
    }

    override def getConfigurationJPanel() : JPanel = {
        return this.jPanel
    }

    override def getHelpSet() : HelpSet = {
        return this.helpSet
    }

}


