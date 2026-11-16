/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.help

import _root_.java.awt.*
import _root_.java.awt.event.ActionEvent
import _root_.java.io.File
import _root_.java.net.URI
import _root_.java.net.URL
import _root_.javax.help.CSH
import _root_.javax.help.HelpBroker
import _root_.javax.help.HelpSet
import _root_.javax.swing.*
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class JavaHelpUtil private() {
    import _root_.org.allbinary.logic.java.help.JavaHelpUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val point : Point = new Point(0, 0)

    private val dimension : Dimension = new Dimension(640, 480)

    private var contextSensitiveHelpActionEvent : ActionEvent = new ActionEvent(new JLabel(), ActionEvent.ACTION_FIRST, null)

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def getHelpSet(filePath : String) : HelpSet = {
        try {
            var helpSetURI : URI = new File(filePath).toURI()
            var helpSetURL : URL = helpSetURI.toURL()
            return this.getHelpSet(helpSetURL)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, getInstance(), "set", e)
                return null
            }
        }
        throw new IllegalStateException()
    }

    def getHelpSet(url : URL) : HelpSet = {
        try {
            return new HelpSet(null, url)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, getInstance(), "set", e)
                return null
            }
        }
        throw new IllegalStateException()
    }

    def show(helpSet : HelpSet) : Unit = {
        try {
            var helpBroker : HelpBroker = helpSet.createHelpBroker()
            helpBroker.setLocation(this.point)
            helpBroker.setSize(this.dimension)
            new CSH.DisplayHelpFromSource(helpBroker).actionPerformed(this.contextSensitiveHelpActionEvent)
            this.logUtil.putF("CSH Action", getInstance(), "show")
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, getInstance(), "show", e)
            }
        }
    }

}

object JavaHelpUtil {
    private val instance : JavaHelpUtil = new JavaHelpUtil()

    /**      * @return the instance      */
    def getInstance() : JavaHelpUtil = {
        return JavaHelpUtil.instance
    }

    def main(args : Array[String]) : Unit = {
        try {
            var javaHelpUtil : JavaHelpUtil = JavaHelpUtil.getInstance()
            javaHelpUtil.show(javaHelpUtil.getHelpSet("G:/mnt/bc/mydev/working/automation/InputAutomationJavaApplication/AllBinaryInputAutomationHelp/AllBinaryInputAutomation.hs"))
        } catch {
            case e : Exception => {
            }
        }
    }

}


