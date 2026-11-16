/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.logic.communication.log.LogUtil

class ThreadUtil {
    import _root_.org.allbinary.thread.ThreadUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val JOIN : String = "join"

    def isRunning(thread : Thread) : Boolean = {
        if ((thread != null) && thread.isAlive()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    def join(thread : Thread) : Unit = {
        if (ThreadUtil.getInstance().isRunning(thread)) {
            //PreLogUtil.put("Waiting for Thread To Join/End", this, JOIN);
            this.logUtil.putF("Waiting for Thread To Join/End", this, this.JOIN)
            //it is still initializing
            thread.join()
        }
    }

}

object ThreadUtil {
    private val instance : ThreadUtil = new ThreadUtil()

    def getInstance() : ThreadUtil = {
        return ThreadUtil.instance
    }

}


