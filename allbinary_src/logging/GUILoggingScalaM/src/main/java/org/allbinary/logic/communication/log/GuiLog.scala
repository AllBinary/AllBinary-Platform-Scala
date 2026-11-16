/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log

import _root_.java.awt.*
import _root_.javax.swing.*
import _root_.org.allbinary.string.CommonStrings

class GuiLog private() {
    import _root_.org.allbinary.logic.communication.log.GuiLog.{*}

    private val logFormatUtil : LogFormatUtil = LogFormatUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def showDialog(msg : String) : Unit = this.synchronized {
        var error : JDialog = new JDialog()
        var size : Int = msg.length() * 9
        var x : Int = size
        if (x > 550) {
            x = 550
        }
        error.getContentPane().setLayout(new GridLayout(1, 1))
        if (size > 255) {
            var y : Int = 550
            error.setSize(x, y)
            error.getContentPane().add(new _root_.javax.swing.JScrollPane(new _root_.javax.swing.JTextArea(msg)))
        } else if (size > 0) {
            var y : Int = 50
            error.setSize(x, y)
            error.getContentPane().add(new _root_.javax.swing.JScrollPane(new _root_.javax.swing.JLabel(msg)))
        }
        error.show()
    }

    def put(specialMessage : String, anyType : Object, functionName : String) : String = this.synchronized {
        return this.put(specialMessage, anyType, functionName, null)
    }

    def put(specialMessage : String, anyType : Object, functionName : String, exception : Exception) : String = this.synchronized {
        try {
            var data : String = this.logFormatUtil.get(specialMessage, anyType.getClass().getName(), functionName, exception)
            this.showDialog(data)
            System.out.println(data)
            return data
        } catch {
            case e : Exception => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, "put", e)
                return "Logging Error"
            }
        }
        throw new IllegalStateException()
    }

    def put(specialMessage : String, className : String, functionName : String) : String = this.synchronized {
        return this.put(specialMessage, className, functionName, null)
    }

    def put(specialMessage : String, className : String, functionName : String, exception : Exception) : String = this.synchronized {
        try {
            var data : String = this.logFormatUtil.get(specialMessage, className, functionName, exception)
            this.showDialog(data)
            System.out.println(data)
            return data
        } catch {
            case e : Exception => {
                PreLogUtil.putOE(this.commonStrings.EXCEPTION, this, "put", e)
                return "Logging Error"
            }
        }
        throw new IllegalStateException()
    }

}

object GuiLog {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : GuiLog = new GuiLog()

    /**      * @return the instance      */
    def getInstance() : GuiLog = {
        return GuiLog.instance
    }

}


