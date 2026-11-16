/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me

import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author user  */
class StatusFactory {
    import _root_.org.allbinary.graphics.j2me.StatusFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val SETSTATUS : String = "setStatus"

    private val STATUS_LABEL : String = "Status: "

    def setStatusNoLog(status : String) : Unit = {
        MyFrame.statusJLabel.setText(status)
    }

    def setStatus(status : String) : Unit = {
        this.setStatusNoLog(status)
        this.logUtil.putF(this.STATUS_LABEL + status, this, this.SETSTATUS)
    }

}

object StatusFactory {
    private val instance : StatusFactory = new StatusFactory()

    /**      * @return the instance      */
    def getInstance() : StatusFactory = {
        return StatusFactory.instance
    }

}


