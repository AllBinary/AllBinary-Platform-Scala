/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class ThreadPool(param_poolName : String, param_numThreads : Int, param_priority : Int) {
    import _root_.org.allbinary.thread.ThreadPool.{NORMAL_PRIORITY as _, *}
    def NORMAL_PRIORITY : Int = _root_.org.allbinary.thread.ThreadPool.NORMAL_PRIORITY

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val NULL_RUNNABLE : NullRunnable = NullRunnable.getInstance()

    val threadPoolStrings : ThreadPoolStrings = ThreadPoolStrings.getInstance()

    val threadObjectUtil : ThreadObjectUtil = ThreadObjectUtil.getInstance()

    //private final int priority;
    private var isAlive : Boolean = false

    private var taskQueue : BasicArrayList = new BasicArrayListD()

    //private int threadID;
    private var numThreads : Int = 0

    //private static int threadPoolID;
    private var runningTask : Boolean = false

    //TWB - PlayN Single Thread Fix
    private var currentPriorityRunnable : PriorityRunnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE

    //Constructor
    {
        val poolName : String = param_poolName
        val numThreads : Int = param_numThreads
        val priority : Int = param_priority
    }

    def runAPriorityTask() : Unit = {
        if (!this.currentPriorityRunnable.isDone()) {
            //this.logUtil.putF(currentPriorityRunnable.toString(), this, "runAPriorityTask:Again");
            this.currentPriorityRunnable.run()
        } else {
            val runnable : Runnable = this.getTask()
            if (runnable eq this.NULL_RUNNABLE) {
                return
            }
            this.currentPriorityRunnable = runnable.asInstanceOf[PriorityRunnable]
            if (!(this.currentPriorityRunnable eq this.threadObjectUtil.NULL_PRIORITY_RUNNABLE)) {
                //this.logUtil.putF(currentPriorityRunnable.toString(), this, "runAPriorityTask:New");
                this.currentPriorityRunnable.reset()
                this.currentPriorityRunnable.run()
            }
        }
    }

    def runATask() : Unit = {
        var runnable : Runnable = this.getTask()
        if (runnable != null) {
            runnable.run()
        }
    }

    def init() : Unit = {
        if (!this.isAlive) {
            this.isAlive = true
            this.taskQueue = new BasicArrayListD()
        }
    }

    def runTaskWithPriority(task : PriorityRunnable) : Unit = this.synchronized {
        if (!this.isAlive) {
            this.init()
        }
        if (task != null) {
            //PreLogUtil.put("Add: ").append(task, this, this.threadPoolStrings.ADD_TASK);
            val size : Int = this.taskQueue.size()
            var runnable : PriorityRunnable = null
            var lowerPriorityRunnable : PriorityRunnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE

            {
                var index : Int = 0
                scala.util.boundary { (break_N69485 : scala.util.boundary.Label[Unit]) ?=>
                    while (index < size) {
                        runnable = this.taskQueue.get(index).asInstanceOf[PriorityRunnable]
                        //this.logUtil.putF(new StringMaker().append(COMPARE_PRIORITY).append(task.getPriority()).toString(), this, this.threadPoolStrings.ADD_TASK);
                        if (runnable.getPriority() > task.getPriority()) {
                            lowerPriorityRunnable = runnable
                            scala.util.boundary.break()(using break_N69485)
                        }
                        index += 1
                    }
                }
            }
            if (lowerPriorityRunnable eq this.threadObjectUtil.NULL_PRIORITY_RUNNABLE) {
                this.taskQueue.add(task)
            } else {
                //this.logUtil.putF(new StringMaker().append(ADD_PRIORITY).append(task.getPriority()).toString(), this, this.threadPoolStrings.ADD_TASK);
                val index : Int = this.taskQueue.indexOf(lowerPriorityRunnable)
                //this.logUtil.putF(new StringMaker().append(ADD_PRIORITY).append(index).append(CommonSeps.getInstance().SPACE).append(this.taskQueue.size()).toString(), this, this.threadPoolStrings.ADD_TASK);
                this.taskQueue.addAt(index, task)
            }
        }
    }

    def runTask(task : Runnable) : Unit = this.synchronized {
        if (!this.isAlive) {
            this.init()
        }
        if (task != null) {
            //PreLogUtil.put("Add: ").append(task, this, "runTask");
            this.taskQueue.add(task)
        }
    }

    def getTask() : Runnable = this.synchronized {
        if (this.taskQueue.isEmpty()) {
            return this.NULL_RUNNABLE
        }
        /*         while (this.taskQueue.size() == 0)         {             if (!this.isAlive)             {                 return NULL_RUNNABLE;             }             //TWB - Playn Testing             //this.wait();         }         */
        return this.taskQueue.removeAt(0).asInstanceOf[Runnable]
    }

    def clear() : Unit = this.synchronized {
        this.taskQueue.clear()
    }

    def close() : Unit = this.synchronized {
        if (this.isAlive) {
            this.isAlive = false
            this.taskQueue.clear()
            this.currentPriorityRunnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE
        }
    }

    def join() : Unit = {
        this.isAlive = false
        this.taskQueue.clear()
        this.currentPriorityRunnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE
    }

    def isBusy() : Boolean = {
        if (!this.isAlive) {
            return false
        }
        if (this.taskQueue.size() > 0) {
            return true
        }
        if (this.runningTask) {
            return true
        }
        return false
    }

    def threadStarted() : Unit = {
    }

    def threadStopped() : Unit = {
        if (this.numThreads == 1) {
            this.isAlive = false
            this.taskQueue.clear()
            this.currentPriorityRunnable = this.threadObjectUtil.NULL_PRIORITY_RUNNABLE
        }
    }

    def startTask(task : Runnable) : Unit = {
    }

    def completedTask(task : Runnable) : Unit = {
    }

}

object ThreadPool {
    //5 = Thread.NORM_PRIORITY
    val NORMAL_PRIORITY : Int = 5

}


