/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class PooledThread(param_threadPool : ThreadPool) extends Thread(param_threadPool.createName()) {

    private val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val threadObjectUtil : ThreadObjectUtil = ThreadObjectUtil.getInstance()

    private var threadPool : ThreadPool = null

    private val INTERRUPT_EXCEPTION : String = "Exit InterruptedException"

    //Constructor
    {
        val threadPool : ThreadPool = param_threadPool
        this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, this.commonStrings.CONSTRUCTOR)
        this.threadPool = threadPool
    }

    override def run() : Unit = {
        this.threadPool.threadStarted()

        {
            scala.util.boundary { (break_N68957 : scala.util.boundary.Label[Unit]) ?=>
                while (true) {
                    var task2 : Runnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE
                    try {
                        task2 = this.threadPool.getTask()
                        //this.logUtil.putF(task + " with Thread: " + this.toString(), this, this.commonStrings.RUN);
                        this.threadPool.runningTask = true
                        this.threadPool.startTask(task2)
                    } catch {
                        case ex : InterruptedException => {
                            val logUtil : LogUtil = LogUtil.getInstance()
                            logUtil.putF(this.INTERRUPT_EXCEPTION, this, this.commonStrings.RUN)
                            scala.util.boundary.break()(using break_N68957)
                        }
                    }
                    if (task2 eq this.threadObjectUtil.NULL_PRIORITY_RUNNABLE) {
                        scala.util.boundary.break()(using break_N68957)
                    }
                    /*                 else                 {                 PreLogUtil.put("Running: ").append(task, this, this.commonStrings.RUN);                 }              */
                    try {
                        task2.run()
                        this.threadPool.completedTask(task2)
                        this.threadPool.runningTask = false
                    } catch {
                        case e : Exception => {
                            val logUtil : LogUtil = LogUtil.getInstance()
                            logUtil.put(new StringMaker().append(this.commonStrings.EXCEPTION_LABEL).append(StringUtil.getInstance().toString(task2)).toString(), this, this.commonStrings.RUN, e)
                        }
                    }
                }
            }
        }
        this.threadPool.threadStopped()
    }

}


