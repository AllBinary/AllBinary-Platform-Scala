/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread


//This is mainly for network communications.
class PathFindingThreadPool(param_poolName : String, param_numThreads : Int, param_priority : Int) extends ThreadPool(param_poolName, param_numThreads, ThreadPool.NORMAL_PRIORITY) {
    import _root_.org.allbinary.thread.PathFindingThreadPool.{*}

    //Constructor
    {
        val poolName : String = param_poolName
        val numThreads : Int = param_numThreads
        val priority : Int = param_priority
    }

    override def runTaskWithPriority(task : PriorityRunnable) : Unit = {
        //this.logUtil.putF(new StringMaker().append(task).append(System.currentTimeMillis()).toString(), this, this.threadPoolStrings.ADD_TASK);
        super.runTaskWithPriority(task)
    }

    override def runTask(task : Runnable) : Unit = {
        //this.logUtil.putF(new StringMaker().append(task).append(System.currentTimeMillis()).toString(), this, this.threadPoolStrings.ADD_TASK);
        super.runTask(task)
    }

    override def startTask(task : Runnable) : Unit = {
    }

    override def completedTask(task : Runnable) : Unit = {
    }

}

object PathFindingThreadPool {
    //1 = Thread.MIN_PRIORITY
    private val instance : ThreadPool = new PathFindingThreadPool("PathFinding", 1, 1)

    def getInstance() : ThreadPool = {
        return PathFindingThreadPool.instance
    }

}


