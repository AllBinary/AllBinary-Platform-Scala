/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

//This is mainly for network communications.
class SecondaryThreadPool(param_poolName : String, param_numThreads : Int, param_priority : Int) extends ThreadPool(param_poolName, param_numThreads, param_priority) {
    import _root_.org.allbinary.thread.SecondaryThreadPool.{*}

    //Constructor
    {
        val poolName : String = param_poolName
        val numThreads : Int = param_numThreads
        val priority : Int = param_priority
    }

    override def runTask(task : Runnable) : Unit = {
        this.logUtil.putF(new StringMaker().append(StringUtil.getInstance().toString(task)).appendlong(System.currentTimeMillis()).toString(), this, this.threadPoolStrings.ADD_TASK)
        super.runTask(task)
    }

    override def startTask(task : Runnable) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.threadPoolStrings.START_TASK).append(StringUtil.getInstance().toString(task)).appendlong(System.currentTimeMillis()).toString(), this, this.commonStrings.RUN)
    }

    override def completedTask(task : Runnable) : Unit = {
        this.logUtil.putF(new StringMaker().append(this.threadPoolStrings.COMPLETE_TASK).append(StringUtil.getInstance().toString(task)).appendlong(System.currentTimeMillis()).toString(), this, this.commonStrings.RUN)
    }

}

object SecondaryThreadPool {
    private val instance : ThreadPool = new SecondaryThreadPool("Secondary", 1, ThreadPool.NORMAL_PRIORITY)

    def getInstance() : ThreadPool = {
        return SecondaryThreadPool.instance
    }

}


