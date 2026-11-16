/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.util.BasicArrayListUtil

class ThreadPool(param_poolName : String, param_numThreads : Int, param_priority : Int) {
    import _root_.org.allbinary.thread.ThreadPool.{NORMAL_PRIORITY as _, *}
    def NORMAL_PRIORITY : Int = _root_.org.allbinary.thread.ThreadPool.NORMAL_PRIORITY

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val NULL_RUNNABLE : NullRunnable = NullRunnable.getInstance()

    val threadPoolStrings : ThreadPoolStrings = ThreadPoolStrings.getInstance()

    val threadObjectUtil : ThreadObjectUtil = ThreadObjectUtil.getInstance()

    private var poolName : String = null

    private var priority : Int = 0

    private var isAlive : Boolean = false

    private var taskQueue : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private var threadID : Int = 0

    private var numThreads : Int = 0

    var runningTask : Boolean = false

    //Constructor
    {
        val poolName : String = param_poolName
        val numThreads : Int = param_numThreads
        val priority : Int = param_priority
        this.poolName = poolName
        this.priority = priority
        this.numThreads = numThreads
    }

    def init() : Unit = {
        if (!this.isAlive) {
            //this.logUtil.putF(this.commonStrings.INIT, this, this.commonStrings.INIT);
            this.isAlive = true
            this.taskQueue = new BasicArrayListD()
            var pooledThread : PooledThread = null

            {
                var i : Int = 0
                while (i < this.numThreads) {
                    pooledThread = new PooledThread(this)
                    pooledThread.setPriority(this.priority)
                    pooledThread.start()
                    i += 1
                }
            }
        }
    }

    def runAPriorityTask() : Unit = {
        throw new RuntimeException()
    }

    //private final String ADD_PRIORITY = "Add priority task: ";
    def runTaskWithPriority(task : PriorityRunnable) : Unit = {
        this.synchronized {
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
                    scala.util.boundary { (break_N70092 : scala.util.boundary.Label[Unit]) ?=>
                        while (index < size) {
                            runnable = this.taskQueue.get(index).asInstanceOf[PriorityRunnable]
                            //this.logUtil.putF(new StringMaker().append(COMPARE_PRIORITY).append(task.getPriority()).toString(), this, this.threadPoolStrings.ADD_TASK);
                            if (runnable.getPriority() > task.getPriority()) {
                                lowerPriorityRunnable = runnable
                                scala.util.boundary.break()(using break_N70092)
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
                this.notify()
            }
        }
    }

    def runTask(task : Runnable) : Unit = {
        this.synchronized {
            if (!this.isAlive) {
                this.init()
            }
            if (task != null) {
                //PreLogUtil.put("Add: ").append(task, this, this.threadPoolStrings.ADD_TASK);
                this.taskQueue.add(task)
                this.notify()
            }
        }
    }

    def getTask() : Runnable = {
        this.synchronized {

            {
                while (this.taskQueue.size() == 0) {
                    if (!this.isAlive) {
                        return this.NULL_RUNNABLE
                    }
                    this.wait()
                }
            }
            val runnable : Runnable = this.taskQueue.removeAt(0).asInstanceOf[Runnable]
            return runnable
        }
        throw new IllegalStateException()
    }

    def clear() : Unit = {
        this.synchronized {
            if (this.isAlive) {
                //this.logUtil.putF("clear", this, this.commonStrings.RUN);
                this.taskQueue.clear()
            }
        }
    }

    def close() : Unit = {
        this.synchronized {
            if (this.isAlive) {
                this.isAlive = false
                //this.logUtil.putF("clear2", this, this.commonStrings.RUN);
                this.taskQueue.clear()
            }
        }
    }

    def join() : Unit = {
        this.synchronized {
            this.isAlive = false
            //this.logUtil.putF("clear3", this, this.commonStrings.RUN);
            this.taskQueue.clear()
            this.notifyAll()
        }
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
        }
    }

    def startTask(task : Runnable) : Unit = {
    }

    def completedTask(task : Runnable) : Unit = {
    }

    def createName() : String = {
        return new StringMaker().append(this.poolName).append(ThreadPool.ROOT_NAME).appendint({ val value_N71753 = this.threadID; this.threadID += 1; value_N71753 }).toString()
    }

}

object ThreadPool {
    private val ROOT_NAME : String = "-PooledThread-"

    //private static int threadPoolID;
    val NORMAL_PRIORITY : Int = Thread.NORM_PRIORITY

}


