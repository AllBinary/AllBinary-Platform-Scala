/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me

import _root_.org.allbinary.logic.communication.log.GuiLog
import _root_.org.allbinary.logic.communication.log.LogUtil

class GraphicsException private (super_1 : String, constructor_ : Unit) extends _root_.java.lang.Exception(super_1) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val guiLog : GuiLog = GuiLog.getInstance()

    def this(msg : String, obj : Object, method : String) = {
        this(msg, ())
        try {
            this.guiLog.showDialog(msg)
            this.logUtil.put(msg, obj, method, this)
        } catch {
            case e : Exception => {
            }
        }
    }

    def this(msg : String, className : String, method : String) = {
        this(msg, ())
        try {
            this.guiLog.showDialog(msg)
            this.logUtil.put(msg, className, method, this)
        } catch {
            case e : Exception => {
            }
        }
    }

}


