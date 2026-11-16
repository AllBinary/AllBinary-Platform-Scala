/* Generated Code Do Not Modify */
package org.allbinary.thread


class ThreadObjectUtil {
    import _root_.org.allbinary.thread.ThreadObjectUtil.{*}

    val NULL_PRIORITY_RUNNABLE : PriorityRunnable = new NullPriorityRunnable()

    def notifyObject(anyType : Object) : Unit = {
    }

    def waitObject(anyType : Object) : Unit = {
    }

    def waitObjectFor(anyType : Object, delay : Long) : Unit = {
    }

    def processThread(runnable : Runnable) : Unit = {
        runnable.run()
    }

}

object ThreadObjectUtil {
    private val instance : ThreadObjectUtil = new ThreadObjectUtil()

    def getInstance() : ThreadObjectUtil = {
        return ThreadObjectUtil.instance
    }

}


