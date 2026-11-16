/* Generated Code Do Not Modify */
package org.allbinary.thread

import _root_.org.allbinary.TsUtil

class ThreadObjectUtil {
    import _root_.org.allbinary.thread.ThreadObjectUtil.{*}

    val NULL_PRIORITY_RUNNABLE : PriorityRunnable = new NullPriorityRunnable()

    def notifyObject(anyType : Object) : Unit = {
        anyType.notify()
    }

    def waitObject(anyType : Object) : Unit = {
        anyType.wait()
    }

    def waitObjectFor(anyType : Object, delay : Long) : Unit = {
        TsUtil.getInstance().waitFor(anyType, delay)
    }

    def processThread(runnable : Runnable) : Unit = {
        val thread : Thread = new Thread(runnable)
        thread.start()
    }

}

object ThreadObjectUtil {
    private val instance : ThreadObjectUtil = new ThreadObjectUtil()

    def getInstance() : ThreadObjectUtil = {
        return ThreadObjectUtil.instance
    }

}


